package com.example.demo.config.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * @title: CarParkShardingTableAlgorithm
 * @projectName shardingdemo
 * @description: 按创建时间分库
 * @author zhy
 * @date 2020/5/611:25
 */
public class CreateTimeShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<Date> {


    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {
        Date value = preciseShardingValue.getValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("ds").append(sdf.format(value));
        return sb.toString();
    }
}

