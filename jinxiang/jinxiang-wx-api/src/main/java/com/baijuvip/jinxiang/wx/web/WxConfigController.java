package com.baijuvip.jinxiang.wx.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.baijuvip.jinxiang.core.util.ResponseUtil;
import com.baijuvip.jinxiang.db.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * 商城配置服务
 */
@RestController
@RequestMapping("/wx/config")
@Validated
public class WxConfigController {
    private final Log logger = LogFactory.getLog(WxConfigController.class);

    @Autowired
    private JinxiangSystemConfigService systemConfigService;

    /**
     * 商场配置
     *
     * @return
     */
    @GetMapping("mall")
    public Object listMall() {
    	Map<String, String> data = systemConfigService.listMail();
        return ResponseUtil.ok(data);
    }
}