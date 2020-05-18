package com.baijuvip.jinxiang.wx.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.baijuvip.jinxiang.core.util.ResponseUtil;
import com.baijuvip.jinxiang.core.validator.Order;
import com.baijuvip.jinxiang.core.validator.Sort;
import com.baijuvip.jinxiang.db.domain.JinxiangBrand;
import com.baijuvip.jinxiang.db.service.JinxiangBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 专题服务
 */
@RestController
@RequestMapping("/wx/brand")
@Validated
public class WxBrandController {
    private final Log logger = LogFactory.getLog(WxBrandController.class);

    @Autowired
    private JinxiangBrandService brandService;

    /**
     * 品牌列表
     *
     * @param page 分页页数
     * @param limit 分页大小
     * @return 品牌列表
     */
    @GetMapping("list")
    public Object list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<JinxiangBrand> brandList = brandService.query(page, limit, sort, order);
        return ResponseUtil.okList(brandList);
    }

    /**
     * 品牌详情
     *
     * @param id 品牌ID
     * @return 品牌详情
     */
    @GetMapping("detail")
    public Object detail(@NotNull Integer id) {
        JinxiangBrand entity = brandService.findById(id);
        if (entity == null) {
            return ResponseUtil.badArgumentValue();
        }

        return ResponseUtil.ok(entity);
    }
}