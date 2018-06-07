package com.dyb.data.config;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * @author dyb
 * @version V1.0
 * @Package com.dyb.data.config
 * @Description: 初始化数据源数据源
 * @date 2018/6/6 下午2:57
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar,EnvironmentAware {

    private Properties properties = new Properties();
    /** 默认数据源 */
    private DataSource defaultDataSource;

    /** 自定义其他数据源 */
    private Map<String, DataSource> customDataSources = new HashMap<>();
    /**
     *
     * 在spring启动时初始化所有数据源
     *
     * 实现自EnvironmentAware，用来在spring环境启动时做一些事情
     */
    @Override
    public void setEnvironment(Environment environment) {
        InputStream is = DynamicDataSourceRegister.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        initDefaultDataSource();
        initCustomDataSources();
    }

    private void initCustomDataSources() {
        customDataSources.put("fincont",this.buildMysqlDataSource("fincont"));
    }

    private void initDefaultDataSource() {
        defaultDataSource = this.buildMysqlDataSource("test");
    }

    public DataSource buildMysqlDataSource(String database) {
//        try {
            //使用的数据源连接池， 如果为空这为默认的C3PO数据源连接池
//            Object type = "com.mchange.v2.c3p0.ComboPooledDataSource";

//            Class<? extends DataSource> dataSourceType;
//            //动态加载数据源连接池class文件
//            dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);

            //获取数据源的驱动类名
            String driverClassName = properties.getProperty(database+".datasource.driver-class-name");
            //获取数据员连接池地址
            String url = properties.getProperty(database+".datasource.url");
            //用户名
            String username = properties.getProperty(database+".datasource.username");
            //密码
            String password = properties.getProperty(database+".datasource.password");

            //创建数据库工厂
            DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url)
                    .username(username).password(password);
//                    .type(dataSourceType);
            //返回创建好的数据库连接
            return factory.build();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();

        /** 添加其他数据源到targetDataSources*/
        targetDataSources.putAll(customDataSources);

        /** 添加其他数据源到DynamicDataSourceContextHolder*/
        for (String key : customDataSources.keySet()) {
            DynamicDataSourceHolder.dataSourceKeys.add(key);
        }

        /** 创建DynamicDataSource 并注册到spring上下文环境*/
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();

        /** 增加两个属性defaultTargetDataSource，targetDataSources*/
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        mpv.addPropertyValue("targetDataSources", targetDataSources);

        beanDefinitionRegistry.registerBeanDefinition("dataSource", beanDefinition);

    }
}
