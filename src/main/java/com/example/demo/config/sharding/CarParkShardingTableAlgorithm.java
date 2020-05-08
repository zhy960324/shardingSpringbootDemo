package com.example.demo.config.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @title: CarParkShardingTableAlgorithm
 * @projectName shardingdemo
 * @description: 按停车场id分表
 * @author zhy
 * @date 2020/5/611:25
 */
public class CarParkShardingTableAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        StringBuilder sb = new StringBuilder();
        String value = preciseShardingValue.getValue();
        //获取设置的虚拟表名称，这里获取到的logicTableName=t_order
        String logicTableName = preciseShardingValue.getLogicTableName();
        //拼接实际的表名称，value为carParkId字段的值
        sb.append(logicTableName).append("_").append(value);
        return sb.toString();
    }
}

