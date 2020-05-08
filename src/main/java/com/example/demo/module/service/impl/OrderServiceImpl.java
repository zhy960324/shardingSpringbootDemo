package com.example.demo.module.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.module.dao.OrderMapper;
import com.example.demo.module.pojo.Order;
import com.example.demo.module.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title: OrderServiceImpl
 * @projectName shardingdemo
 * @description: TODO
 * @author zhy
 * @date 2020/5/69:31
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
}
