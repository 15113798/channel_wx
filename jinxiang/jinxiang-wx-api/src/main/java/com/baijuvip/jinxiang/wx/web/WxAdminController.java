package com.baijuvip.jinxiang.wx.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.baijuvip.jinxiang.core.util.DateUtils;
import com.baijuvip.jinxiang.core.util.JacksonUtil;
import com.baijuvip.jinxiang.core.util.ResponseUtil;
import com.baijuvip.jinxiang.db.domain.JinxiangIntegral;
import com.baijuvip.jinxiang.db.domain.JinxiangUser;
import com.baijuvip.jinxiang.db.service.JinxiangIntegralService;
import com.baijuvip.jinxiang.db.service.JinxiangOrderService;
import com.baijuvip.jinxiang.db.service.JinxiangUserService;
import com.baijuvip.jinxiang.wx.annotation.LoginUser;
import com.baijuvip.jinxiang.wx.dto.Template;
import com.baijuvip.jinxiang.wx.dto.TemplateParam;
import com.baijuvip.jinxiang.wx.util.CommonUtil;
import com.baijuvip.jinxiang.wx.util.HttpUtil;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员服务
 */
@RestController
@RequestMapping("/wx/admin")
@Validated
public class WxAdminController {
    private final Log logger = LogFactory.getLog(WxAdminController.class);

    @Autowired
    private JinxiangIntegralService jinxiangIntegralService;
    @Autowired
    private JinxiangUserService jinxiangUserService;

    /**
     * 积分通知页面数据
     */
    @GetMapping("integral/notice/list")
    public Object integralNoticeList(@LoginUser Integer userId) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        JinxiangUser user = this.jinxiangUserService.findById(userId);
        if(user.getAdminId() == null || user.getAdminId() == 0) {
        	return ResponseUtil.unauthz();
        }
        return ResponseUtil.ok(this.jinxiangIntegralService.getNoticeList());
    }

	@PostMapping("integral/save")
	@Transactional
	public Object userIntegralSave(@LoginUser Integer userId, @RequestBody String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        
        Integer integral = JacksonUtil.parseInteger(body, "integral");
        String mobile = JacksonUtil.parseString(body, "mobile");
		
		JinxiangUser user = this.jinxiangUserService.findByMobile(mobile);
		if(user == null) {
			return ResponseUtil.fail(999, "用户不存在，无法操作");
		}
		
		JinxiangIntegral integralObj = new JinxiangIntegral();
		integralObj.setUserId(user.getId());
		integralObj.setIntegral(integral);
		integralObj.setOldIntegral(user.getIntegral());
		integralObj.setIsNotified(1);
        if(this.jinxiangIntegralService.add(integralObj) > 0) {
        	user.setIntegral(user.getIntegral() + integral);
        	this.jinxiangUserService.updateById(user);
        }

		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx7e12dbb195caf0ef&secret=91b7f51a01026851866c8ad41f131c03";
		String result = HttpUtil.sendGet(url);
		JSONObject object = JSONObject.fromObject(result);
		String accessToken = object.getString("access_token");

		Template template = new Template();
		template.setTemplate_id("iBnwmjBoMCKoUoJYiWmISQD1YxHRAWp_x5QO9Gtz_0E");
		template.setTouser(user.getWeixinOpenid());
		template.setPage("pages/index/index");
		List<TemplateParam> paras = new ArrayList<TemplateParam>();
		paras.add(new TemplateParam("number1", Math.abs(integral) + ""));
		paras.add(new TemplateParam("date2", DateUtils.formatDateTime()));
		paras.add(new TemplateParam("thing3", "用户积分" + (integral > 0 ? "增加" : "减少") + integral + "，请进入小程序查看"));
		template.setTemplateParamList(paras);
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		System.out.println(template.toJSON());
		JSONObject jsonResult = CommonUtil.httpsRequest(requestUrl, "POST", template.toJSON());
		if (jsonResult != null) {
			System.out.println(jsonResult);
			int errorCode = jsonResult.getInt("errcode");
			String errorMessage = jsonResult.getString("errmsg");
			if (errorCode == 0) {
				System.out.println("Send Success");
			} else {
				System.out.println("订阅消息发送失败:" + errorCode + "," + errorMessage);
			}
		}
		return ResponseUtil.ok();
	}

}