package com.baijuvip.jinxiang.db.service;

import com.github.pagehelper.PageHelper;
import com.baijuvip.jinxiang.db.dao.JinxiangCommentMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangComment;
import com.baijuvip.jinxiang.db.domain.JinxiangCommentExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JinxiangCommentService {
    @Resource
    private JinxiangCommentMapper commentMapper;

    public List<JinxiangComment> queryGoodsByGid(Integer id, int offset, int limit) {
        JinxiangCommentExample example = new JinxiangCommentExample();
        example.setOrderByClause(JinxiangComment.Column.addTime.desc());
        example.or().andValueIdEqualTo(id).andTypeEqualTo((byte) 0).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return commentMapper.selectByExample(example);
    }

    public List<JinxiangComment> query(Byte type, Integer valueId, Integer showType, Integer offset, Integer limit) {
        JinxiangCommentExample example = new JinxiangCommentExample();
        example.setOrderByClause(JinxiangComment.Column.addTime.desc());
        if (showType == 0) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andDeletedEqualTo(false);
        } else if (showType == 1) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andHasPictureEqualTo(true).andDeletedEqualTo(false);
        } else {
            throw new RuntimeException("showType不支持");
        }
        PageHelper.startPage(offset, limit);
        return commentMapper.selectByExample(example);
    }

    public int count(Byte type, Integer valueId, Integer showType) {
        JinxiangCommentExample example = new JinxiangCommentExample();
        if (showType == 0) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andDeletedEqualTo(false);
        } else if (showType == 1) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andHasPictureEqualTo(true).andDeletedEqualTo(false);
        } else {
            throw new RuntimeException("showType不支持");
        }
        return (int) commentMapper.countByExample(example);
    }

    public int save(JinxiangComment comment) {
        comment.setAddTime(LocalDateTime.now());
        comment.setUpdateTime(LocalDateTime.now());
        return commentMapper.insertSelective(comment);
    }

    public List<JinxiangComment> querySelective(String userId, String valueId, Integer page, Integer size, String sort, String order) {
        JinxiangCommentExample example = new JinxiangCommentExample();
        JinxiangCommentExample.Criteria criteria = example.createCriteria();

        // type=2 是订单商品回复，这里过滤
        criteria.andTypeNotEqualTo((byte) 2);

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(valueId)) {
            criteria.andValueIdEqualTo(Integer.valueOf(valueId)).andTypeEqualTo((byte) 0);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return commentMapper.selectByExample(example);
    }

    public void deleteById(Integer id) {
        commentMapper.logicalDeleteByPrimaryKey(id);
    }

    public String queryReply(Integer id) {
        JinxiangCommentExample example = new JinxiangCommentExample();
        example.or().andTypeEqualTo((byte) 2).andValueIdEqualTo(id);
        List<JinxiangComment> commentReply = commentMapper.selectByExampleSelective(example, JinxiangComment.Column.content);
        // 目前业务只支持回复一次
        if (commentReply.size() == 1) {
            return commentReply.get(0).getContent();
        }
        return null;
    }

    public JinxiangComment findById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }
}
