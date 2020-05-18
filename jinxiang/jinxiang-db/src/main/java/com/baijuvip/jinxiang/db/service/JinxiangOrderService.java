package com.baijuvip.jinxiang.db.service;

import com.github.pagehelper.PageHelper;
import com.baijuvip.jinxiang.db.dao.JinxiangOrderMapper;
import com.baijuvip.jinxiang.db.dao.OrderMapper;
import com.baijuvip.jinxiang.db.domain.JinxiangOrder;
import com.baijuvip.jinxiang.db.domain.JinxiangOrderExample;
import com.baijuvip.jinxiang.db.util.OrderUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class JinxiangOrderService {
    @Resource
    private JinxiangOrderMapper jinxiangOrderMapper;
    @Resource
    private OrderMapper orderMapper;

    public int add(JinxiangOrder order) {
        order.setAddTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());
        return jinxiangOrderMapper.insertSelective(order);
    }

    public int count(Integer userId) {
        JinxiangOrderExample example = new JinxiangOrderExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return (int) jinxiangOrderMapper.countByExample(example);
    }

    public JinxiangOrder findById(Integer orderId) {
        return jinxiangOrderMapper.selectByPrimaryKey(orderId);
    }

    private String getRandomNum(Integer num) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public int countByOrderSn(Integer userId, String orderSn) {
        JinxiangOrderExample example = new JinxiangOrderExample();
        example.or().andUserIdEqualTo(userId).andOrderSnEqualTo(orderSn).andDeletedEqualTo(false);
        return (int) jinxiangOrderMapper.countByExample(example);
    }

    // TODO 这里应该产生一个唯一的订单，但是实际上这里仍然存在两个订单相同的可能性
    public String generateOrderSn(Integer userId) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = df.format(LocalDate.now());
        String orderSn = now + getRandomNum(6);
        while (countByOrderSn(userId, orderSn) != 0) {
            orderSn = now + getRandomNum(6);
        }
        return orderSn;
    }

    public List<JinxiangOrder> queryByOrderStatus(Integer userId, List<Short> orderStatus, Integer page, Integer limit, String sort, String order) {
        JinxiangOrderExample example = new JinxiangOrderExample();
        example.setOrderByClause(JinxiangOrder.Column.addTime.desc());
        JinxiangOrderExample.Criteria criteria = example.or();
        criteria.andUserIdEqualTo(userId);
        if (orderStatus != null) {
            criteria.andOrderStatusIn(orderStatus);
        }
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return jinxiangOrderMapper.selectByExample(example);
    }

    public List<JinxiangOrder> querySelective(Integer userId, String orderSn, List<Short> orderStatusArray, Integer page, Integer limit, String sort, String order) {
        JinxiangOrderExample example = new JinxiangOrderExample();
        JinxiangOrderExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(orderSn)) {
            criteria.andOrderSnEqualTo(orderSn);
        }
        if (orderStatusArray != null && orderStatusArray.size() != 0) {
            criteria.andOrderStatusIn(orderStatusArray);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return jinxiangOrderMapper.selectByExample(example);
    }

    public int updateWithOptimisticLocker(JinxiangOrder order) {
        LocalDateTime preUpdateTime = order.getUpdateTime();
        order.setUpdateTime(LocalDateTime.now());
        return orderMapper.updateWithOptimisticLocker(preUpdateTime, order);
    }

    public void deleteById(Integer id) {
        jinxiangOrderMapper.logicalDeleteByPrimaryKey(id);
    }

    public int count() {
        JinxiangOrderExample example = new JinxiangOrderExample();
        example.or().andDeletedEqualTo(false);
        return (int) jinxiangOrderMapper.countByExample(example);
    }

    public List<JinxiangOrder> queryUnpaid(int minutes) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expired = now.minusMinutes(minutes);
        JinxiangOrderExample example = new JinxiangOrderExample();
        example.or().andOrderStatusEqualTo(OrderUtil.STATUS_CREATE).andAddTimeLessThan(expired).andDeletedEqualTo(false);
        return jinxiangOrderMapper.selectByExample(example);
    }

    public List<JinxiangOrder> queryUnconfirm(int days) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expired = now.minusDays(days);
        JinxiangOrderExample example = new JinxiangOrderExample();
        example.or().andOrderStatusEqualTo(OrderUtil.STATUS_SHIP).andShipTimeLessThan(expired).andDeletedEqualTo(false);
        return jinxiangOrderMapper.selectByExample(example);
    }

    public JinxiangOrder findBySn(String orderSn) {
        JinxiangOrderExample example = new JinxiangOrderExample();
        example.or().andOrderSnEqualTo(orderSn).andDeletedEqualTo(false);
        return jinxiangOrderMapper.selectOneByExample(example);
    }

    public Map<Object, Object> orderInfo(Integer userId) {
        JinxiangOrderExample example = new JinxiangOrderExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        List<JinxiangOrder> orders = jinxiangOrderMapper.selectByExampleSelective(example, JinxiangOrder.Column.orderStatus, JinxiangOrder.Column.comments);

        int unpaid = 0;
        int unship = 0;
        int unrecv = 0;
        int uncomment = 0;
        for (JinxiangOrder order : orders) {
            if (OrderUtil.isCreateStatus(order)) {
                unpaid++;
            } else if (OrderUtil.isPayStatus(order)) {
                unship++;
            } else if (OrderUtil.isShipStatus(order)) {
                unrecv++;
            } else if (OrderUtil.isConfirmStatus(order) || OrderUtil.isAutoConfirmStatus(order)) {
                uncomment += order.getComments();
            } else {
                // do nothing
            }
        }

        Map<Object, Object> orderInfo = new HashMap<Object, Object>();
        orderInfo.put("unpaid", unpaid);
        orderInfo.put("unship", unship);
        orderInfo.put("unrecv", unrecv);
        orderInfo.put("uncomment", uncomment);
        return orderInfo;

    }

    public List<JinxiangOrder> queryComment(int days) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expired = now.minusDays(days);
        JinxiangOrderExample example = new JinxiangOrderExample();
        example.or().andCommentsGreaterThan((short) 0).andConfirmTimeLessThan(expired).andDeletedEqualTo(false);
        return jinxiangOrderMapper.selectByExample(example);
    }
}
