package com.example.demo.module.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.module.dao.CarParkMapper;
import com.example.demo.module.dao.OrderMapper;
import com.example.demo.module.pojo.CarPark;
import com.example.demo.module.service.CarParkService;
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
public class CarParkServiceImpl extends ServiceImpl<CarParkMapper, CarPark> implements CarParkService {
    @Autowired
    private CarParkMapper carParkMapper;
}
