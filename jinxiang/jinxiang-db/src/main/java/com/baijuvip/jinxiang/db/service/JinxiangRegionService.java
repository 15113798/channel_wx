package com.baijuvip.jinxiang.db.service;

import com.github.pagehelper.PageHelper;
import com.baijuvip.jinxiang.db.dao.JinxiangRegionMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangRegion;
import com.baijuvip.jinxiang.db.domain.JinxiangRegionExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JinxiangRegionService {

    @Resource
    private JinxiangRegionMapper regionMapper;

    public List<JinxiangRegion> getAll(){
        JinxiangRegionExample example = new JinxiangRegionExample();
        byte b = 4;
        example.or().andTypeNotEqualTo(b);
        return regionMapper.selectByExample(example);
    }

    public List<JinxiangRegion> queryByPid(Integer parentId) {
        JinxiangRegionExample example = new JinxiangRegionExample();
        example.or().andPidEqualTo(parentId);
        return regionMapper.selectByExample(example);
    }

    public JinxiangRegion findById(Integer id) {
        return regionMapper.selectByPrimaryKey(id);
    }

    public List<JinxiangRegion> querySelective(String name, Integer code, Integer page, Integer size, String sort, String order) {
        JinxiangRegionExample example = new JinxiangRegionExample();
        JinxiangRegionExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(code)) {
            criteria.andCodeEqualTo(code);
        }

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return regionMapper.selectByExample(example);
    }

}
