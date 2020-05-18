package com.baijuvip.jinxiang.wx.web;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.baijuvip.jinxiang.core.util.RegexUtil;
import com.baijuvip.jinxiang.core.util.ResponseUtil;
import com.baijuvip.jinxiang.db.domain.JinxiangFeedback;
import com.baijuvip.jinxiang.db.domain.JinxiangUser;
import com.baijuvip.jinxiang.db.service.JinxiangFeedbackService;
import com.baijuvip.jinxiang.db.service.JinxiangUserService;
import com.baijuvip.jinxiang.wx.annotation.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 意见反馈服务
 *
 * @author Yogeek
 * @date 2018/8/25 14:10
 */
@RestController
@RequestMapping("/wx/feedback")
@Validated
public class WxFeedbackController {
    private final Log logger = LogFactory.getLog(WxFeedbackController.class);

    @Autowired
    private JinxiangFeedbackService feedbackService;
    @Autowired
    private JinxiangUserService userService;

    private Object validate(JinxiangFeedback feedback) {
        String content = feedback.getContent();
        if (StringUtils.isEmpty(content)) {
            return ResponseUtil.badArgument();
        }

        String type = feedback.getFeedType();
        if (StringUtils.isEmpty(type)) {
            return ResponseUtil.badArgument();
        }

        Boolean hasPicture = feedback.getHasPicture();
        if (hasPicture == null || !hasPicture) {
            feedback.setPicUrls(new String[0]);
        }

        // 测试手机号码是否正确
        String mobile = feedback.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return ResponseUtil.badArgument();
        }
        if (!RegexUtil.isMobileExact(mobile)) {
            return ResponseUtil.badArgument();
        }
        return null;
    }

    /**
     * 添加意见反馈
     *
     * @param userId   用户ID
     * @param feedback 意见反馈
     * @return 操作结果
     */
    @PostMapping("submit")
    public Object submit(@LoginUser Integer userId, @RequestBody JinxiangFeedback feedback) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        Object error = validate(feedback);
        if (error != null) {
            return error;
        }

        JinxiangUser user = userService.findById(userId);
        String username = user.getUsername();
        feedback.setId(null);
        feedback.setUserId(userId);
        feedback.setUsername(username);
        //状态默认是0，1表示状态已发生变化
        feedback.setStatus(1);
        feedbackService.add(feedback);

        return ResponseUtil.ok();
    }

}
