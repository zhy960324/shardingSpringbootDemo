package com.example.demo.module.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.module.pojo.CarPark;
import org.apache.ibatis.annotations.Mapper;

/**
 * @title: OrderMapper
 * @projectName shardingdemo
 * @description: TODO
 * @author zhy
 * @date 2020/5/69:30
 */
@Mapper
public interface CarParkMapper extends BaseMapper<CarPark> {
}
