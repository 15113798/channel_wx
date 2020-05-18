package com.baijuvip.jinxiang.wx.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.baijuvip.jinxiang.core.util.ResponseUtil;
import com.baijuvip.jinxiang.db.domain.JinxiangUser;
import com.baijuvip.jinxiang.db.domain.JinxiangUserFormid;
import com.baijuvip.jinxiang.db.service.JinxiangUserFormIdService;
import com.baijuvip.jinxiang.db.service.JinxiangUserService;
import com.baijuvip.jinxiang.wx.annotation.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/wx/formid")
@Validated
public class WxUserFormId {
    private final Log logger = LogFactory.getLog(WxUserFormId.class);

    @Autowired
    private JinxiangUserService userService;

    @Autowired
    private JinxiangUserFormIdService formIdService;

    @GetMapping("create")
    public Object create(@LoginUser Integer userId, @NotNull String formId) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        JinxiangUser user = userService.findById(userId);
        JinxiangUserFormid userFormid = new JinxiangUserFormid();
        userFormid.setOpenid(user.getWeixinOpenid());
        userFormid.setFormid(formId);
        userFormid.setIsprepay(false);
        userFormid.setUseamount(1);
        userFormid.setExpireTime(LocalDateTime.now().plusDays(7));
        formIdService.addUserFormid(userFormid);

        return ResponseUtil.ok();
    }
}
