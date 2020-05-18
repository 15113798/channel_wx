package com.baijuvip.jinxiang.wx.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.baijuvip.jinxiang.core.util.DateUtils;
import com.baijuvip.jinxiang.core.util.JacksonUtil;
import com.baijuvip.jinxiang.core.util.ResponseUtil;
import com.baijuvip.jinxiang.core.validator.Order;
import com.baijuvip.jinxiang.core.validator.Sort;
import com.baijuvip.jinxiang.db.domain.JinxiangIntegral;
import com.baijuvip.jinxiang.db.domain.JinxiangUser;
import com.baijuvip.jinxiang.db.service.*;
import com.baijuvip.jinxiang.wx.annotation.LoginUser;
import com.baijuvip.jinxiang.wx.dto.Template;
import com.baijuvip.jinxiang.wx.dto.TemplateParam;

import com.baijuvip.jinxiang.wx.util.CommonUtil;
import com.baijuvip.jinxiang.wx.util.HttpUtil;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 积分服务
 */
@RestController
@RequestMapping("/wx/integral")
@Validated
public class WxIntegralController {
	private final Log logger = LogFactory.getLog(WxIntegralController.class);

	@Autowired
	private JinxiangIntegralService integralService;
	@Autowired
	private JinxiangUserService jinxiangUserService;

	/**
	 * 个人优惠券列表
	 *
	 * @param userId
	 * @param status
	 * @param page
	 * @param limit
	 * @param sort
	 * @param order
	 * @return
	 */
	@GetMapping("mylist")
	public Object mylist(@LoginUser Integer userId, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer limit,
			@Sort @RequestParam(defaultValue = "add_time") String sort,
			@Order @RequestParam(defaultValue = "desc") String order) {
		if (userId == null) {
			return ResponseUtil.unlogin();
		}

		List<JinxiangIntegral> integralList = integralService.querySelective(userId, null, page, limit, sort, order);
		return ResponseUtil.okList(integralList, integralList);
	}

	@PostMapping("notice")
	@Transactional
	public Object notice(@LoginUser Integer userId, @RequestBody String body) {
        Integer integralId = JacksonUtil.parseInteger(body, "integralId");
		JinxiangIntegral integral = this.integralService.queryById(integralId);
		integral.setIsNotified(1);
		this.integralService.update(integral);
		
		JinxiangUser user = this.jinxiangUserService.findById(integral.getUserId());

		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx7e12dbb195caf0ef&secret=91b7f51a01026851866c8ad41f131c03";
		String result = HttpUtil.sendGet(url);
		JSONObject object = JSONObject.fromObject(result);
		String accessToken = object.getString("access_token");

		Template template = new Template();
		template.setTemplate_id("iBnwmjBoMCKoUoJYiWmISQD1YxHRAWp_x5QO9Gtz_0E");
		template.setTouser(user.getWeixinOpenid());
		template.setPage("pages/index/index");
		List<TemplateParam> paras = new ArrayList<TemplateParam>();
		paras.add(new TemplateParam("number1", Math.abs(integral.getIntegral()) + ""));
		paras.add(new TemplateParam("date2", DateUtils.formatDateTime()));
		paras.add(new TemplateParam("thing3", "请进入小程序查看"));
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