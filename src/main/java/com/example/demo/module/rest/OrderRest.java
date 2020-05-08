package com.example.demo.module.rest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.base.BaseRest;
import com.example.demo.common.base.Result;
import com.example.demo.common.utils.UUIDUtil;
import com.example.demo.module.pojo.Order;
import com.example.demo.module.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @title: OrderRest
 * @projectName shardingdemo
 * @description: TODO
 * @author zhy
 * @date 2020/5/69:33
 */
@RestController
@RequestMapping("/order")
public class OrderRest extends BaseRest {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public Result<Order> getById(@PathVariable String id){
        Order order = orderService.getById(id);
        return addSucResult(order);
    }

    @PostMapping("/{carParkId}")
    public Result save(@PathVariable String carParkId){
        Order order = new Order();
        order.setId(UUIDUtil.getUUID());
        order.setCarParkId(carParkId);
        order.setNo(order.getId());
        order.setCreateTime(new Date());
        orderService.save(order);
        return addSucResult();
    }

    @GetMapping("list/{carParkId}")
    private Result<Order> list(@PathVariable String carParkId){
        if("all".equals(carParkId)){
            LambdaQueryWrapper<Order> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            //查询停车场id为0 1 的数据
            lambdaQueryWrapper.in(Order::getCarParkId,"0","1");
            return addSucResult(orderService.list(lambdaQueryWrapper));
        }else{
            LambdaQueryWrapper<Order> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(Order::getCarParkId,carParkId);
            return addSucResult(orderService.list(lambdaQueryWrapper));
        }
    }
}
