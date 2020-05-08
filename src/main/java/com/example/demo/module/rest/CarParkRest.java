package com.example.demo.module.rest;

import com.example.demo.common.base.BaseRest;
import com.example.demo.common.base.Result;
import com.example.demo.module.pojo.CarPark;
import com.example.demo.module.pojo.Order;
import com.example.demo.module.service.CarParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: OrderRest
 * @projectName shardingdemo
 * @description: TODO
 * @author zhy
 * @date 2020/5/69:33
 */
@RestController
@RequestMapping("/carPark")
public class CarParkRest extends BaseRest {

    @Autowired
    private CarParkService carParkService;

    @GetMapping("/{id}")
    public Result<Order> getById(@PathVariable String id){
        CarPark carPark = carParkService.getById(id);
        return addSucResult(carPark);
    }

    @GetMapping("list")
    private Result<Order> list(){
        return addSucResult(carParkService.list());
    }
}
