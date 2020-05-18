package com.baijuvip.jinxiang.db.service;

import com.github.pagehelper.PageHelper;
import com.baijuvip.jinxiang.db.dao.JinxiangUserMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangUser;
import com.baijuvip.jinxiang.db.domain.JinxiangUserExample;
import com.baijuvip.jinxiang.db.domain.UserVo;
import com.baijuvip.jinxiang.db.util.WechatNickNameUtils;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JinxiangUserService {
    @Resource
    private JinxiangUserMapper userMapper;

    public JinxiangUser findById(Integer userId) {
    	JinxiangUser user = userMapper.selectByPrimaryKey(userId);
    	user.setNickname(WechatNickNameUtils.decode(user.getNickname()));
        return user;
    }

    public JinxiangUser findByMobile(String mobile) {
    	JinxiangUserExample example = new JinxiangUserExample();
        example.or().andMobileEqualTo(mobile).andDeletedEqualTo(false);
        JinxiangUser user = userMapper.selectOneByExample(example);
        if(user != null) {
        	user.setNickname(WechatNickNameUtils.decode(user.getNickname()));
        }
        return user;
    }

    public UserVo findUserVoById(Integer userId) {
        JinxiangUser user = findById(userId);
        UserVo userVo = new UserVo();
        userVo.setNickname(user.getNickname());
        userVo.setAvatar(user.getAvatar());
        return userVo;
    }

    public JinxiangUser queryByOid(String openId) {
        JinxiangUserExample example = new JinxiangUserExample();
        example.or().andWeixinOpenidEqualTo(openId).andDeletedEqualTo(false);
        JinxiangUser user = userMapper.selectOneByExample(example);
        if(user != null) {
        	user.setNickname(WechatNickNameUtils.decode(user.getNickname()));
        }
        return user;
    }

    public void add(JinxiangUser user) {
        user.setAddTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
    	user.setNickname(WechatNickNameUtils.encode(user.getNickname()));
        userMapper.insertSelective(user);
    }

    public int updateById(JinxiangUser user) {
        user.setUpdateTime(LocalDateTime.now());
    	user.setNickname(WechatNickNameUtils.encode(user.getNickname()));
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public List<JinxiangUser> querySelective(String nickname, String mobile, Integer page, Integer size, String sort, String order) {
        JinxiangUserExample example = new JinxiangUserExample();
        JinxiangUserExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(nickname)) {
            criteria.andNicknameLike("%" + WechatNickNameUtils.encode(nickname) + "%");
        }
        if (!StringUtils.isEmpty(mobile)) {
            criteria.andMobileEqualTo(mobile);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        List<JinxiangUser> userList = userMapper.selectByExample(example);
        for(JinxiangUser user : userList) {
        	user.setNickname(WechatNickNameUtils.decode(user.getNickname().replaceAll("%", "%25")));
        }
        return userList;
    }

    public int count() {
        JinxiangUserExample example = new JinxiangUserExample();
        example.or().andDeletedEqualTo(false);

        return (int) userMapper.countByExample(example);
    }

    public List<JinxiangUser> queryByUsername(String username) {
        JinxiangUserExample example = new JinxiangUserExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        List<JinxiangUser> userList = userMapper.selectByExample(example);
        for(JinxiangUser user : userList) {
        	user.setNickname(WechatNickNameUtils.decode(user.getNickname()));
        }
        return userList;
    }

    public boolean checkByUsername(String username) {
        JinxiangUserExample example = new JinxiangUserExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return userMapper.countByExample(example) != 0;
    }

    public List<JinxiangUser> queryByMobile(String mobile) {
        JinxiangUserExample example = new JinxiangUserExample();
        example.or().andMobileEqualTo(mobile).andDeletedEqualTo(false);
        List<JinxiangUser> userList = userMapper.selectByExample(example);
        for(JinxiangUser user : userList) {
        	user.setNickname(WechatNickNameUtils.decode(user.getNickname()));
        }
        return userList;
    }

    public List<JinxiangUser> queryByOpenid(String openid) {
        JinxiangUserExample example = new JinxiangUserExample();
        example.or().andWeixinOpenidEqualTo(openid).andDeletedEqualTo(false);
        List<JinxiangUser> userList = userMapper.selectByExample(example);
        for(JinxiangUser user : userList) {
        	user.setNickname(WechatNickNameUtils.decode(user.getNickname()));
        }
        return userList;
    }

    public void deleteById(Integer id) {
        userMapper.logicalDeleteByPrimaryKey(id);
    }
}
