package com.baijuvip.jinxiang.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.baijuvip.jinxiang.admin.annotation.RequiresPermissionsDesc;
import com.baijuvip.jinxiang.admin.dto.Template;
import com.baijuvip.jinxiang.admin.dto.TemplateParam;
import com.baijuvip.jinxiang.admin.service.LogHelper;
import com.baijuvip.jinxiang.admin.util.CommonUtil;
import com.baijuvip.jinxiang.admin.util.HttpUtil;
import com.baijuvip.jinxiang.core.util.DateUtils;
import com.baijuvip.jinxiang.core.util.ResponseUtil;
import com.baijuvip.jinxiang.core.util.bcrypt.BCryptPasswordEncoder;
import com.baijuvip.jinxiang.core.validator.Order;
import com.baijuvip.jinxiang.core.validator.Sort;
import com.baijuvip.jinxiang.db.domain.JinxiangAddress;
import com.baijuvip.jinxiang.db.domain.JinxiangAdmin;
import com.baijuvip.jinxiang.db.domain.JinxiangIntegral;
import com.baijuvip.jinxiang.db.domain.JinxiangUser;
import com.baijuvip.jinxiang.db.service.JinxiangAddressService;
import com.baijuvip.jinxiang.db.service.JinxiangIntegralService;
import com.baijuvip.jinxiang.db.service.JinxiangRegionService;
import com.baijuvip.jinxiang.db.service.JinxiangUserService;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.baijuvip.jinxiang.admin.util.AdminResponseCode.ADMIN_NAME_EXIST;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/integral")
@Validated
public class AdminIntegralController {
    private final Log logger = LogFactory.getLog(AdminIntegralController.class);

    @Autowired
    private JinxiangIntegralService integralService;
    @Autowired
    private JinxiangUserService userService;
    @Autowired
    private LogHelper logHelper;

    @RequiresPermissions("admin:integral:list")
    @RequiresPermissionsDesc(menu={"用户管理" , "积分记录"}, button="查询")
    @GetMapping("/list")
    public Object list(Integer userId, String name,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
    	List<JinxiangIntegral> integralList = integralService.querySelective(userId, name, page, limit, sort, order);
        return ResponseUtil.okList(integralList);
    }

    @RequiresPermissions("admin:integral:create")
    @RequiresPermissionsDesc(menu={"用户管理" , "积分记录"}, button="添加")
    @GetMapping("/create")
    public Object create(@RequestParam Integer userId, @RequestParam Integer integral) {
    	if(integral == 0) {
    		return ResponseUtil.fail(ADMIN_NAME_EXIST, "参数错误，请输入积分数值,正数为增加,负数为减少");
    	}
    	
        JinxiangUser user = this.userService.findById(userId);
        if (user == null) {
            return ResponseUtil.fail(ADMIN_NAME_EXIST, "参数错误，用户不存在");
        }
        
        if(user.getIntegral() + integral < 0) {
        	return ResponseUtil.fail(ADMIN_NAME_EXIST, "参数错误，用户积分不足");
        }
        
        JinxiangIntegral userIntegral = new JinxiangIntegral();
        userIntegral.setUserId(userId);
        userIntegral.setIntegral(integral);
        userIntegral.setOldIntegral(user.getIntegral());
        userIntegral.setIsNotified(1);
        if(this.integralService.add(userIntegral) > 0) {
        	user.setIntegral(user.getIntegral() + integral);
        	this.userService.updateById(user);
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
		
        logHelper.logAuthSucceed("用户积分" + (integral > 0 ? "增加" : "减少") + integral, user.getNickname());
        return ResponseUtil.ok(userIntegral);
    }
}
