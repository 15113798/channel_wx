package com.baijuvip.jinxiang.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.baijuvip.jinxiang.db.dao.JinxiangGoodsMapper;
import com.baijuvip.jinxiang.db.dao.JinxiangGrouponRulesMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangGoods;
import com.baijuvip.jinxiang.db.domain.JinxiangGrouponRules;
import com.baijuvip.jinxiang.db.domain.JinxiangGrouponRulesExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JinxiangGrouponRulesService {
    @Resource
    private JinxiangGrouponRulesMapper mapper;
    @Resource
    private JinxiangGoodsMapper goodsMapper;
    private JinxiangGoods.Column[] goodsColumns = new JinxiangGoods.Column[]{JinxiangGoods.Column.id, JinxiangGoods.Column.name, JinxiangGoods.Column.brief, JinxiangGoods.Column.picUrl, JinxiangGoods.Column.counterPrice, JinxiangGoods.Column.retailPrice};

    public int createRules(JinxiangGrouponRules rules) {
        rules.setAddTime(LocalDateTime.now());
        rules.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(rules);
    }

    /**
     * 根据ID查找对应团购项
     *
     * @param id
     * @return
     */
    public JinxiangGrouponRules queryById(Integer id) {
        JinxiangGrouponRulesExample example = new JinxiangGrouponRulesExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 查询某个商品关联的团购规则
     *
     * @param goodsId
     * @return
     */
    public List<JinxiangGrouponRules> queryByGoodsId(Integer goodsId) {
        JinxiangGrouponRulesExample example = new JinxiangGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    /**
     * 获取首页团购活动列表
     *
     * @param page
     * @param limit
     * @return
     */
    public List<JinxiangGrouponRules> queryList(Integer page, Integer limit) {
        return queryList(page, limit, "add_time", "desc");
    }

    public List<JinxiangGrouponRules> queryList(Integer page, Integer limit, String sort, String order) {
        JinxiangGrouponRulesExample example = new JinxiangGrouponRulesExample();
        example.or().andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(page, limit);
        return mapper.selectByExample(example);
    }

    /**
     * 判断某个团购活动是否已经过期
     *
     * @return
     */
    public boolean isExpired(JinxiangGrouponRules rules) {
        return (rules == null || rules.getExpireTime().isBefore(LocalDateTime.now()));
    }

    /**
     * 获取团购活动列表
     *
     * @param goodsId
     * @param page
     * @param size
     * @param sort
     * @param order
     * @return
     */
    public List<JinxiangGrouponRules> querySelective(String goodsId, Integer page, Integer size, String sort, String order) {
        JinxiangGrouponRulesExample example = new JinxiangGrouponRulesExample();
        example.setOrderByClause(sort + " " + order);

        JinxiangGrouponRulesExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    public void delete(Integer id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }

    public int updateById(JinxiangGrouponRules grouponRules) {
        grouponRules.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(grouponRules);
    }
}