package com.baijuvip.jinxiang.db.service;

import com.github.pagehelper.PageHelper;
import com.baijuvip.jinxiang.db.dao.JinxiangSearchHistoryMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangSearchHistory;
import com.baijuvip.jinxiang.db.domain.JinxiangSearchHistoryExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JinxiangSearchHistoryService {
    @Resource
    private JinxiangSearchHistoryMapper searchHistoryMapper;

    public void save(JinxiangSearchHistory searchHistory) {
        searchHistory.setAddTime(LocalDateTime.now());
        searchHistory.setUpdateTime(LocalDateTime.now());
        searchHistoryMapper.insertSelective(searchHistory);
    }

    public List<JinxiangSearchHistory> queryByUid(int uid) {
        JinxiangSearchHistoryExample example = new JinxiangSearchHistoryExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        example.setDistinct(true);
        return searchHistoryMapper.selectByExampleSelective(example, JinxiangSearchHistory.Column.keyword);
    }

    public void deleteByUid(int uid) {
        JinxiangSearchHistoryExample example = new JinxiangSearchHistoryExample();
        example.or().andUserIdEqualTo(uid);
        searchHistoryMapper.logicalDeleteByExample(example);
    }

    public List<JinxiangSearchHistory> querySelective(String userId, String keyword, Integer page, Integer size, String sort, String order) {
        JinxiangSearchHistoryExample example = new JinxiangSearchHistoryExample();
        JinxiangSearchHistoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andKeywordLike("%" + keyword + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return searchHistoryMapper.selectByExample(example);
    }
}
