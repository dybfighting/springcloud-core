package com.dyb.data.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

/**
 * @author dyb
 * @version V1.0
 * @Package com.dyb.data.config
 * @Description: 动态数据源
 * @date 2018/6/5 下午3:44
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {
        String key = DynamicDataSourceHolder.getDataSourceKey();
        System.out.println("determineCurrentLookupKey !!!!!!!!  key:"+key);
        return key;
    }
}
