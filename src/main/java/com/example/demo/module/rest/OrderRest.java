package com.example.demo.module.rest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import java.util.Random;

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

    /**
      * 根据id获取一条
      * @param id
      * @throws
      * @return com.example.demo.common.base.Result<com.example.demo.module.pojo.Order>
      * @author zhy
      * @date 2020/5/10 20:33
      */
    @GetMapping("/{id}")
    public Result<Order> getById(@PathVariable String id){
        Order order = orderService.getById(id);
        return addSucResult(order);
    }

    /**
      * 根据停车场id保存一条纪录
      * @param carParkId
      * @throws
      * @return com.example.demo.common.base.Result
      * @author zhy
      * @date 2020/5/10 20:33
      */
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

    /**
      * 根据停车场id获取纪录
      * @param carParkId
      * @throws
      * @return com.example.demo.common.base.Result<com.example.demo.module.pojo.Order>
      * @author zhy
      * @date 2020/5/10 20:33
      */
    @GetMapping("list/{carParkId}")
    public Result<Order> list(@PathVariable String carParkId){
        if("all".equals(carParkId)){
            return addSucResult(orderService.list());
        }else{
            LambdaQueryWrapper<Order> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(Order::getCarParkId,carParkId);
            return addSucResult(orderService.list(lambdaQueryWrapper));
        }
    }

    /**
      * 分页查询
      * @param carParkId
      * @throws
      * @return com.example.demo.common.base.Result
      * @author zhy
      * @date 2020/5/10 20:32
      */
    @PostMapping("/listPage/{carParkId}")
    public Result listPage(@PathVariable String carParkId){
        Integer pageSize = 10;
        Integer pageNum = 1;
        IPage<Order> page = new Page<Order>(pageNum, pageSize, true);
        if("all".equals(carParkId)){
            return addSucResult(orderService.page(page));
        }else{
            LambdaQueryWrapper<Order> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(Order::getCarParkId,carParkId);
            return addSucResult(orderService.page(page,lambdaQueryWrapper));
        }
    }


    /**
      * 批量新增
      * @param
      * @throws
      * @return com.example.demo.common.base.Result
      * @author zhy
      * @date 2020/5/10 20:32
      */
    @PostMapping("/saveBatch")
    public Result saveBatch(){
        List<String> carParkIds = new ArrayList<>();
        for (int i = 0; i < 25; i ++){
            carParkIds.add(String.valueOf(i));
        }
        Random random = new Random();
        int i = 0;
        List<Order> insList = new ArrayList<>();
        while(i < 10000){
            Order order = new Order();
            String uuid = UUIDUtil.getUUID();
            order.setId(uuid);
            order.setCreateTime(new Date());
            order.setNo(uuid);
            order.setCarParkId(carParkIds.get(random.nextInt(carParkIds.size())));
            insList.add(order);
            if (insList.size() >= 1000){
                orderService.saveBatch(insList);
                insList.clear();
            }
            i++;
        }
        return addSucResult();
    }

}
