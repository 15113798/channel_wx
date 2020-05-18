package com.baijuvip.jinxiang.db.service;

import com.github.pagehelper.PageHelper;
import com.baijuvip.jinxiang.db.dao.JinxiangTopicMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangTopic;
import com.baijuvip.jinxiang.db.domain.JinxiangTopic.Column;
import com.baijuvip.jinxiang.db.domain.JinxiangTopicExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JinxiangTopicService {
    @Resource
    private JinxiangTopicMapper topicMapper;
    private Column[] columns = new Column[]{Column.id, Column.title, Column.subtitle, Column.price, Column.picUrl, Column.readCount};

    public List<JinxiangTopic> queryList(int offset, int limit) {
        return queryList(offset, limit, "add_time", "desc");
    }

    public List<JinxiangTopic> queryList(int offset, int limit, String sort, String order) {
        JinxiangTopicExample example = new JinxiangTopicExample();
        example.or().andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(offset, limit);
        return topicMapper.selectByExampleSelective(example, columns);
    }

    public int queryTotal() {
        JinxiangTopicExample example = new JinxiangTopicExample();
        example.or().andDeletedEqualTo(false);
        return (int) topicMapper.countByExample(example);
    }

    public JinxiangTopic findById(Integer id) {
        JinxiangTopicExample example = new JinxiangTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return topicMapper.selectOneByExampleWithBLOBs(example);
    }

    public List<JinxiangTopic> queryRelatedList(Integer id, int offset, int limit) {
        JinxiangTopicExample example = new JinxiangTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        List<JinxiangTopic> topics = topicMapper.selectByExample(example);
        if (topics.size() == 0) {
            return queryList(offset, limit, "add_time", "desc");
        }
        JinxiangTopic topic = topics.get(0);

        example = new JinxiangTopicExample();
        example.or().andIdNotEqualTo(topic.getId()).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        List<JinxiangTopic> relateds = topicMapper.selectByExampleWithBLOBs(example);
        if (relateds.size() != 0) {
            return relateds;
        }

        return queryList(offset, limit, "add_time", "desc");
    }

    public List<JinxiangTopic> querySelective(String title, String subtitle, Integer page, Integer limit, String sort, String order) {
        JinxiangTopicExample example = new JinxiangTopicExample();
        JinxiangTopicExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(subtitle)) {
            criteria.andSubtitleLike("%" + subtitle + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return topicMapper.selectByExampleWithBLOBs(example);
    }

    public int updateById(JinxiangTopic topic) {
        topic.setUpdateTime(LocalDateTime.now());
        JinxiangTopicExample example = new JinxiangTopicExample();
        example.or().andIdEqualTo(topic.getId());
        return topicMapper.updateByExampleSelective(topic, example);
    }

    public void deleteById(Integer id) {
        topicMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(JinxiangTopic topic) {
        topic.setAddTime(LocalDateTime.now());
        topic.setUpdateTime(LocalDateTime.now());
        topicMapper.insertSelective(topic);
    }


}
