package com.baijuvip.jinxiang.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.baijuvip.jinxiang.admin.annotation.RequiresPermissionsDesc;
import com.baijuvip.jinxiang.admin.service.LogHelper;
import com.baijuvip.jinxiang.core.util.RegexUtil;
import com.baijuvip.jinxiang.core.util.ResponseUtil;
import com.baijuvip.jinxiang.core.validator.Order;
import com.baijuvip.jinxiang.core.validator.Sort;
import com.baijuvip.jinxiang.db.domain.JinxiangAdmin;
import com.baijuvip.jinxiang.db.domain.JinxiangUser;
import com.baijuvip.jinxiang.db.service.JinxiangAdminService;
import com.baijuvip.jinxiang.db.service.JinxiangUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.baijuvip.jinxiang.admin.util.AdminResponseCode.ADMIN_INVALID_NAME;
import static com.baijuvip.jinxiang.admin.util.AdminResponseCode.ADMIN_INVALID_PASSWORD;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
@Validated
public class AdminUserController {
    private final Log logger = LogFactory.getLog(AdminUserController.class);

    @Autowired
    private JinxiangUserService userService;
    @Autowired
    private JinxiangAdminService adminService;
    @Autowired
    private LogHelper logHelper;

    private Object validate(JinxiangUser user) {
        String nickname = user.getNickname();
        if (StringUtils.isEmpty(nickname)) {
            return ResponseUtil.badArgument();
        }
        String mobile = user.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return ResponseUtil.badArgument();
        }
        return null;
    }

    @RequiresPermissions("admin:user:list")
    @RequiresPermissionsDesc(menu={"用户管理" , "会员管理"}, button="查询")
    @GetMapping("/list")
    public Object list(String nickname, String mobile,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<JinxiangUser> userList = userService.querySelective(nickname, mobile, page, limit, sort, order);
        return ResponseUtil.okList(userList);
    }

    @RequiresPermissions("admin:user:update")
    @RequiresPermissionsDesc(menu={"用户管理" , "会员管理"}, button="编辑")
    @PostMapping("/update")
    public Object update(@RequestBody JinxiangUser user) {
        Object error = validate(user);
        if (error != null) {
            return error;
        }

        Integer anotherUserId = user.getId();
        if (anotherUserId == null) {
            return ResponseUtil.badArgument();
        }

        // =====关联管理员=====
        if(user.getAdminId() != 0) {
        	JinxiangAdmin admin = this.adminService.findById(user.getAdminId());
        	if(admin != null) {
        		user.setAdminName(admin.getUsername());
        	} else {
        		user.setAdminId(0);
        		user.setAdminName("");
        	}
        }
        // =====关联管理员=====
        
        if (userService.updateById(user) == 0) {
            return ResponseUtil.updatedDataFailed();
        }

        logHelper.logAuthSucceed("编辑会员", user.getNickname());
        return ResponseUtil.ok(user);
    }
}
