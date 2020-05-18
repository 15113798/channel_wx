package com.baijuvip.jinxiang.wx.web;

import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.baijuvip.jinxiang.core.util.ResponseUtil;
import com.baijuvip.jinxiang.core.validator.Order;
import com.baijuvip.jinxiang.core.validator.Sort;
import com.baijuvip.jinxiang.db.domain.JinxiangIssue;
import com.baijuvip.jinxiang.db.service.JinxiangIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/issue")
@Validated
public class WxIssueController {
    private final Log logger = LogFactory.getLog(WxIssueController.class);

    @Autowired
    private JinxiangIssueService issueService;

    /**
     * 帮助中心
     */
    @RequestMapping("/list")
    public Object list(String question,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<JinxiangIssue> issueList = issueService.querySelective(question, page, size, sort, order);
        return ResponseUtil.okList(issueList);
    }

}
