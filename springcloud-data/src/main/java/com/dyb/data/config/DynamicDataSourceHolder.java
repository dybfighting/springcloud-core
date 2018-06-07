package com.dyb.data.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dyb
 * @version V1.0
 * @Package com.dyb.data.config
 * @Description: TODO
 * @date 2018/6/6 下午2:31
 */
public class DynamicDataSourceHolder {

    private static final ThreadLocal<String> dataSourceHolder = new ThreadLocal<String>();

    public static List<String> dataSourceKeys = new ArrayList<String>();

    public static void setDataSourceKey(String key) {
        dataSourceHolder.set(key);
    }

    public static String getDataSourceKey() {
        return dataSourceHolder.get();
    }

    public static void removeDataSoureKey() {
        dataSourceHolder.remove();
    }

    //判断spring容器中是否存在名字为dataSourceId的数据源实例
    public static boolean containsDataSource(String key) {
        return dataSourceKeys.contains(key);
    }

}
