package com.baijuvip.jinxiang.db.dao;

import org.apache.ibatis.annotations.Param;
import com.baijuvip.jinxiang.db.domain.JinxiangOrder;

import java.time.LocalDateTime;

public interface OrderMapper {
    int updateWithOptimisticLocker(@Param("lastUpdateTime") LocalDateTime lastUpdateTime, @Param("order") JinxiangOrder order);
}