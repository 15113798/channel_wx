package com.baijuvip.jinxiang.db.service;

import com.github.pagehelper.PageHelper;
import com.baijuvip.jinxiang.db.dao.JinxiangAdminMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangAdmin;
import com.baijuvip.jinxiang.db.domain.JinxiangAdmin.Column;
import com.baijuvip.jinxiang.db.domain.JinxiangAdminExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JinxiangAdminService {
    private final Column[] result = new Column[]{Column.id, Column.username, Column.avatar, Column.roleIds};
    @Resource
    private JinxiangAdminMapper adminMapper;

    public List<JinxiangAdmin> findAdmin(String username) {
        JinxiangAdminExample example = new JinxiangAdminExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return adminMapper.selectByExample(example);
    }

    public JinxiangAdmin findAdmin(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    public List<JinxiangAdmin> querySelective(String username, Integer page, Integer limit, String sort, String order) {
        JinxiangAdminExample example = new JinxiangAdminExample();
        JinxiangAdminExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return adminMapper.selectByExampleSelective(example, result);
    }

    public int updateById(JinxiangAdmin admin) {
        admin.setUpdateTime(LocalDateTime.now());
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    public void deleteById(Integer id) {
        adminMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(JinxiangAdmin admin) {
        admin.setAddTime(LocalDateTime.now());
        admin.setUpdateTime(LocalDateTime.now());
        adminMapper.insertSelective(admin);
    }

    public JinxiangAdmin findById(Integer id) {
        return adminMapper.selectByPrimaryKeySelective(id, result);
    }

    public List<JinxiangAdmin> all() {
        JinxiangAdminExample example = new JinxiangAdminExample();
        example.or().andDeletedEqualTo(false);
        return adminMapper.selectByExample(example);
    }
}
