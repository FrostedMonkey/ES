package com.cc.elasticsearch.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author : chenchen
 * @ClassName DynamicDataSource
 * @date : 2020-08-01 14:41
 * @Description TODO
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDB();
    }
}