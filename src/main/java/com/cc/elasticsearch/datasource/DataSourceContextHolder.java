package com.cc.elasticsearch.datasource;

/**
 * @author : chenchen
 * @ClassName DataSourceContextHolder
 * @date : 2020-08-01 14:44
 * @Description TODO
 **/
public class DataSourceContextHolder {
    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = "db";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    // 设置数据源名
    public static void setDB(String dbType) {
        contextHolder.set(dbType);
    }

    // 获取数据源名
    public static String getDB() {
        return (contextHolder.get());
    }

    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }
}
