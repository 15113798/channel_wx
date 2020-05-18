package com.baijuvip.jinxiang.db.service;

import com.github.pagehelper.PageHelper;
import com.baijuvip.jinxiang.db.dao.JinxiangAddressMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangAddress;
import com.baijuvip.jinxiang.db.domain.JinxiangAddressExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JinxiangAddressService {
    @Resource
    private JinxiangAddressMapper addressMapper;

    public List<JinxiangAddress> queryByUid(Integer uid) {
        JinxiangAddressExample example = new JinxiangAddressExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        return addressMapper.selectByExample(example);
    }

    public JinxiangAddress query(Integer userId, Integer id) {
        JinxiangAddressExample example = new JinxiangAddressExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return addressMapper.selectOneByExample(example);
    }

    public int add(JinxiangAddress address) {
        address.setAddTime(LocalDateTime.now());
        address.setUpdateTime(LocalDateTime.now());
        return addressMapper.insertSelective(address);
    }

    public int update(JinxiangAddress address) {
        address.setUpdateTime(LocalDateTime.now());
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    public void delete(Integer id) {
        addressMapper.logicalDeleteByPrimaryKey(id);
    }

    public JinxiangAddress findDefault(Integer userId) {
        JinxiangAddressExample example = new JinxiangAddressExample();
        example.or().andUserIdEqualTo(userId).andIsDefaultEqualTo(true).andDeletedEqualTo(false);
        return addressMapper.selectOneByExample(example);
    }

    public void resetDefault(Integer userId) {
        JinxiangAddress address = new JinxiangAddress();
        address.setIsDefault(false);
        address.setUpdateTime(LocalDateTime.now());
        JinxiangAddressExample example = new JinxiangAddressExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        addressMapper.updateByExampleSelective(address, example);
    }

    public List<JinxiangAddress> querySelective(Integer userId, String name, Integer page, Integer limit, String sort, String order) {
        JinxiangAddressExample example = new JinxiangAddressExample();
        JinxiangAddressExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return addressMapper.selectByExample(example);
    }
}
