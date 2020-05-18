package com.baijuvip.jinxiang.db.service;

import com.baijuvip.jinxiang.db.dao.JinxiangGoodsAttributeMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangGoodsAttribute;
import com.baijuvip.jinxiang.db.domain.JinxiangGoodsAttributeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JinxiangGoodsAttributeService {
    @Resource
    private JinxiangGoodsAttributeMapper goodsAttributeMapper;

    public List<JinxiangGoodsAttribute> queryByGid(Integer goodsId) {
        JinxiangGoodsAttributeExample example = new JinxiangGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }

    public void add(JinxiangGoodsAttribute goodsAttribute) {
        goodsAttribute.setAddTime(LocalDateTime.now());
        goodsAttribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    public JinxiangGoodsAttribute findById(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        JinxiangGoodsAttributeExample example = new JinxiangGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsAttributeMapper.logicalDeleteByExample(example);
    }
}
