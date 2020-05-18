package com.baijuvip.jinxiang.db.service;

import com.github.pagehelper.PageHelper;
import com.baijuvip.jinxiang.db.dao.JinxiangIntegralMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangIntegral;
import com.baijuvip.jinxiang.db.domain.JinxiangIntegralExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JinxiangIntegralService {
    @Resource
    private JinxiangIntegralMapper integralMapper;

    public JinxiangIntegral queryById(Integer id) {
        JinxiangIntegralExample example = new JinxiangIntegralExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        List<JinxiangIntegral> list = integralMapper.selectByExample(example);
        if(list != null && list.size() > 0) {
        	return list.get(0);
        }
        return null;
    }

    public List<JinxiangIntegral> queryByUid(Integer uid) {
        JinxiangIntegralExample example = new JinxiangIntegralExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        return integralMapper.selectByExample(example);
    }

    public JinxiangIntegral query(Integer userId, Integer id) {
        JinxiangIntegralExample example = new JinxiangIntegralExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return integralMapper.selectOneByExample(example);
    }

    public int add(JinxiangIntegral integral) {
        integral.setAddTime(LocalDateTime.now());
        integral.setUpdateTime(LocalDateTime.now());
        return integralMapper.insertSelective(integral);
    }

    public int update(JinxiangIntegral integral) {
        integral.setUpdateTime(LocalDateTime.now());
        return integralMapper.updateByPrimaryKeySelective(integral);
    }

    public void delete(Integer id) {
        integralMapper.logicalDeleteByPrimaryKey(id);
    }

    public void resetDefault(Integer userId) {
        JinxiangIntegral integral = new JinxiangIntegral();
        integral.setUpdateTime(LocalDateTime.now());
        JinxiangIntegralExample example = new JinxiangIntegralExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        integralMapper.updateByExampleSelective(integral, example);
    }

    public List<JinxiangIntegral> querySelective(Integer userId, String name, Integer page, Integer limit, String sort, String order) {
        JinxiangIntegralExample example = new JinxiangIntegralExample();
        JinxiangIntegralExample.Criteria criteria = example.createCriteria();

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
        return integralMapper.selectByExample(example);
    }

    public List<JinxiangIntegral> getNoticeList() {
        JinxiangIntegralExample example = new JinxiangIntegralExample();
        JinxiangIntegralExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        criteria.andIsNotifiedEqualTo(0);
        example.setOrderByClause("id ASC");
        return integralMapper.selectByExample(example);
    }
}
