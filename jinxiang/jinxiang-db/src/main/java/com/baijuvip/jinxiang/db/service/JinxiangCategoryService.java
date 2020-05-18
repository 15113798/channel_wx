package com.baijuvip.jinxiang.db.service;

import com.github.pagehelper.PageHelper;
import com.baijuvip.jinxiang.db.dao.JinxiangCategoryMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangCategory;
import com.baijuvip.jinxiang.db.domain.JinxiangCategoryExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JinxiangCategoryService {
    @Resource
    private JinxiangCategoryMapper categoryMapper;
    private JinxiangCategory.Column[] CHANNEL = {JinxiangCategory.Column.id, JinxiangCategory.Column.name, JinxiangCategory.Column.iconUrl};

    public List<JinxiangCategory> queryL1WithoutRecommend(int offset, int limit) {
        JinxiangCategoryExample example = new JinxiangCategoryExample();
        example.or().andLevelEqualTo("L1").andNameNotEqualTo("推荐").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<JinxiangCategory> queryL1(int offset, int limit) {
        JinxiangCategoryExample example = new JinxiangCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<JinxiangCategory> queryL1() {
        JinxiangCategoryExample example = new JinxiangCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<JinxiangCategory> queryByPid(Integer pid) {
        JinxiangCategoryExample example = new JinxiangCategoryExample();
        example.or().andPidEqualTo(pid).andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<JinxiangCategory> queryL2ByIds(List<Integer> ids) {
        JinxiangCategoryExample example = new JinxiangCategoryExample();
        example.or().andIdIn(ids).andLevelEqualTo("L2").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public JinxiangCategory findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public List<JinxiangCategory> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        JinxiangCategoryExample example = new JinxiangCategoryExample();
        JinxiangCategoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(id)) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return categoryMapper.selectByExample(example);
    }

    public int updateById(JinxiangCategory category) {
        category.setUpdateTime(LocalDateTime.now());
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    public void deleteById(Integer id) {
        categoryMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(JinxiangCategory category) {
        category.setAddTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insertSelective(category);
    }

    public List<JinxiangCategory> queryChannel() {
        JinxiangCategoryExample example = new JinxiangCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExampleSelective(example, CHANNEL);
    }
}
