package com.baijuvip.jinxiang.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.baijuvip.jinxiang.db.dao.JinxiangRoleMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangRole;
import com.baijuvip.jinxiang.db.domain.JinxiangRoleExample;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JinxiangRoleService {
    @Resource
    private JinxiangRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if(roleIds.length == 0){
            return roles;
        }

        JinxiangRoleExample example = new JinxiangRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<JinxiangRole> roleList = roleMapper.selectByExample(example);

        for(JinxiangRole role : roleList){
            roles.add(role.getName());
        }

        return roles;

    }

    public List<JinxiangRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        JinxiangRoleExample example = new JinxiangRoleExample();
        JinxiangRoleExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return roleMapper.selectByExample(example);
    }

    public JinxiangRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(JinxiangRole role) {
        role.setAddTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(JinxiangRole role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExist(String name) {
        JinxiangRoleExample example = new JinxiangRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<JinxiangRole> queryAll() {
        JinxiangRoleExample example = new JinxiangRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}
