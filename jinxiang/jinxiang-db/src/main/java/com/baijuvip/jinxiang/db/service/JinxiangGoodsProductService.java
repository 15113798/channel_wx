package com.baijuvip.jinxiang.db.service;

import org.apache.ibatis.annotations.Param;
import com.baijuvip.jinxiang.db.dao.GoodsProductMapper;
import com.baijuvip.jinxiang.db.dao.JinxiangGoodsProductMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangGoodsProduct;
import com.baijuvip.jinxiang.db.domain.JinxiangGoodsProductExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JinxiangGoodsProductService {
    @Resource
    private JinxiangGoodsProductMapper jinxiangGoodsProductMapper;
    @Resource
    private GoodsProductMapper goodsProductMapper;

    public List<JinxiangGoodsProduct> queryByGid(Integer gid) {
        JinxiangGoodsProductExample example = new JinxiangGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid).andDeletedEqualTo(false);
        return jinxiangGoodsProductMapper.selectByExample(example);
    }

    public JinxiangGoodsProduct findById(Integer id) {
        return jinxiangGoodsProductMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        jinxiangGoodsProductMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(JinxiangGoodsProduct goodsProduct) {
        goodsProduct.setAddTime(LocalDateTime.now());
        goodsProduct.setUpdateTime(LocalDateTime.now());
        jinxiangGoodsProductMapper.insertSelective(goodsProduct);
    }

    public int count() {
        JinxiangGoodsProductExample example = new JinxiangGoodsProductExample();
        example.or().andDeletedEqualTo(false);
        return (int) jinxiangGoodsProductMapper.countByExample(example);
    }

    public void deleteByGid(Integer gid) {
        JinxiangGoodsProductExample example = new JinxiangGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid);
        jinxiangGoodsProductMapper.logicalDeleteByExample(example);
    }

    public int addStock(Integer id, Short num){
        return goodsProductMapper.addStock(id, num);
    }

    public int reduceStock(Integer id, Short num){
        return goodsProductMapper.reduceStock(id, num);
    }
}