package com.baijuvip.jinxiang.wx.service;

import com.baijuvip.jinxiang.db.domain.JinxiangRegion;
import com.baijuvip.jinxiang.db.service.JinxiangRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhy
 * @date 2019-01-17 23:07
 **/
@Component
public class GetRegionService {

	@Autowired
	private JinxiangRegionService regionService;

	private static List<JinxiangRegion> jinxiangRegions;

	protected List<JinxiangRegion> getJinxiangRegions() {
		if(jinxiangRegions==null){
			createRegion();
		}
		return jinxiangRegions;
	}

	private synchronized void createRegion(){
		if (jinxiangRegions == null) {
			jinxiangRegions = regionService.getAll();
		}
	}
}
