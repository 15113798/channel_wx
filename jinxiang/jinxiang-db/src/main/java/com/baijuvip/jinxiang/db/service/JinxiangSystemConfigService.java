package com.baijuvip.jinxiang.db.service;

import com.baijuvip.jinxiang.db.dao.JinxiangSystemMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangSystem;
import com.baijuvip.jinxiang.db.domain.JinxiangSystemExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JinxiangSystemConfigService {
    @Resource
    private JinxiangSystemMapper systemMapper;

    public Map<String, String> queryAll() {
        JinxiangSystemExample example = new JinxiangSystemExample();
        example.or().andDeletedEqualTo(false);

        List<JinxiangSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> systemConfigs = new HashMap<>();
        for (JinxiangSystem item : systemList) {
            systemConfigs.put(item.getKeyName(), item.getKeyValue());
        }

        return systemConfigs;
    }

    public Map<String, String> listMail() {
        JinxiangSystemExample example = new JinxiangSystemExample();
        example.or().andKeyNameLike("jinxiang_mall_%").andDeletedEqualTo(false);
        List<JinxiangSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(JinxiangSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listWx() {
        JinxiangSystemExample example = new JinxiangSystemExample();
        example.or().andKeyNameLike("jinxiang_wx_%").andDeletedEqualTo(false);
        List<JinxiangSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(JinxiangSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listOrder() {
        JinxiangSystemExample example = new JinxiangSystemExample();
        example.or().andKeyNameLike("jinxiang_order_%").andDeletedEqualTo(false);
        List<JinxiangSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(JinxiangSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listExpress() {
        JinxiangSystemExample example = new JinxiangSystemExample();
        example.or().andKeyNameLike("jinxiang_express_%").andDeletedEqualTo(false);
        List<JinxiangSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(JinxiangSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public void updateConfig(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            JinxiangSystemExample example = new JinxiangSystemExample();
            example.or().andKeyNameEqualTo(entry.getKey()).andDeletedEqualTo(false);

            JinxiangSystem system = new JinxiangSystem();
            system.setKeyName(entry.getKey());
            system.setKeyValue(entry.getValue());
            system.setUpdateTime(LocalDateTime.now());
            systemMapper.updateByExampleSelective(system, example);
        }

    }

    public void addConfig(String key, String value) {
        JinxiangSystem system = new JinxiangSystem();
        system.setKeyName(key);
        system.setKeyValue(value);
        system.setAddTime(LocalDateTime.now());
        system.setUpdateTime(LocalDateTime.now());
        systemMapper.insertSelective(system);
    }
    
    public JinxiangSystem get(Integer id) {
    	return systemMapper.selectByPrimaryKey(id);
    }

	public Map<String, String> listSignin() {
		JinxiangSystemExample example = new JinxiangSystemExample();
        example.or().andKeyNameLike("jinxiang_signin_%").andDeletedEqualTo(false);
        List<JinxiangSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(JinxiangSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
	}
}
