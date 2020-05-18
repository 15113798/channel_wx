package com.baijuvip.jinxiang.db.service;

import com.baijuvip.jinxiang.db.dao.JinxiangPermissionMapper;
import com.baijuvip.jinxiang.db.dao.JinxiangRoleMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangPermission;
import com.baijuvip.jinxiang.db.domain.JinxiangPermissionExample;
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
public class JinxiangPermissionService {
    @Resource
    private JinxiangPermissionMapper permissionMapper;

    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<String>();
        if(roleIds.length == 0){
            return permissions;
        }

        JinxiangPermissionExample example = new JinxiangPermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<JinxiangPermission> permissionList = permissionMapper.selectByExample(example);

        for(JinxiangPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }


    public Set<String> queryByRoleId(Integer roleId) {
        Set<String> permissions = new HashSet<String>();
        if(roleId == null){
            return permissions;
        }

        JinxiangPermissionExample example = new JinxiangPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        List<JinxiangPermission> permissionList = permissionMapper.selectByExample(example);

        for(JinxiangPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    public boolean checkSuperPermission(Integer roleId) {
        if(roleId == null){
            return false;
        }

        JinxiangPermissionExample example = new JinxiangPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andPermissionEqualTo("*").andDeletedEqualTo(false);
        return permissionMapper.countByExample(example) != 0;
    }

    public void deleteByRoleId(Integer roleId) {
        JinxiangPermissionExample example = new JinxiangPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        permissionMapper.logicalDeleteByExample(example);
    }

    public void add(JinxiangPermission jinxiangPermission) {
        jinxiangPermission.setAddTime(LocalDateTime.now());
        jinxiangPermission.setUpdateTime(LocalDateTime.now());
        permissionMapper.insertSelective(jinxiangPermission);
    }
}
