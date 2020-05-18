package com.baijuvip.jinxiang.db.service;

import com.github.pagehelper.PageHelper;
import com.baijuvip.jinxiang.db.dao.JinxiangStorageMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangStorage;
import com.baijuvip.jinxiang.db.domain.JinxiangStorageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JinxiangStorageService {
    @Autowired
    private JinxiangStorageMapper storageMapper;

    public void deleteByKey(String key) {
        JinxiangStorageExample example = new JinxiangStorageExample();
        example.or().andKeyEqualTo(key);
        storageMapper.logicalDeleteByExample(example);
    }

    public void add(JinxiangStorage storageInfo) {
        storageInfo.setAddTime(LocalDateTime.now());
        storageInfo.setUpdateTime(LocalDateTime.now());
        storageMapper.insertSelective(storageInfo);
    }

    public JinxiangStorage findByKey(String key) {
        JinxiangStorageExample example = new JinxiangStorageExample();
        example.or().andKeyEqualTo(key).andDeletedEqualTo(false);
        return storageMapper.selectOneByExample(example);
    }

    public int update(JinxiangStorage storageInfo) {
        storageInfo.setUpdateTime(LocalDateTime.now());
        return storageMapper.updateByPrimaryKeySelective(storageInfo);
    }

    public JinxiangStorage findById(Integer id) {
        return storageMapper.selectByPrimaryKey(id);
    }

    public List<JinxiangStorage> querySelective(String key, String name, Integer page, Integer limit, String sort, String order) {
        JinxiangStorageExample example = new JinxiangStorageExample();
        JinxiangStorageExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(key)) {
            criteria.andKeyEqualTo(key);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return storageMapper.selectByExample(example);
    }
}
