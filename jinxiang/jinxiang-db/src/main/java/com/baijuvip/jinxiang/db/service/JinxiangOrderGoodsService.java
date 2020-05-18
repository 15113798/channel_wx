package com.baijuvip.jinxiang.db.service;

import com.baijuvip.jinxiang.db.dao.JinxiangOrderGoodsMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangOrderGoods;
import com.baijuvip.jinxiang.db.domain.JinxiangOrderGoodsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JinxiangOrderGoodsService {
    @Resource
    private JinxiangOrderGoodsMapper orderGoodsMapper;

    public int add(JinxiangOrderGoods orderGoods) {
        orderGoods.setAddTime(LocalDateTime.now());
        orderGoods.setUpdateTime(LocalDateTime.now());
        return orderGoodsMapper.insertSelective(orderGoods);
    }

    public List<JinxiangOrderGoods> queryByOid(Integer orderId) {
        JinxiangOrderGoodsExample example = new JinxiangOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public List<JinxiangOrderGoods> findByOidAndGid(Integer orderId, Integer goodsId) {
        JinxiangOrderGoodsExample example = new JinxiangOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public JinxiangOrderGoods findById(Integer id) {
        return orderGoodsMapper.selectByPrimaryKey(id);
    }

    public void updateById(JinxiangOrderGoods orderGoods) {
        orderGoods.setUpdateTime(LocalDateTime.now());
        orderGoodsMapper.updateByPrimaryKeySelective(orderGoods);
    }

    public Short getComments(Integer orderId) {
        JinxiangOrderGoodsExample example = new JinxiangOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        long count = orderGoodsMapper.countByExample(example);
        return (short) count;
    }

    public boolean checkExist(Integer goodsId) {
        JinxiangOrderGoodsExample example = new JinxiangOrderGoodsExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.countByExample(example) != 0;
    }
}
