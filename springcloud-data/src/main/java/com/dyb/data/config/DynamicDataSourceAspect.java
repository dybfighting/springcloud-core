package com.dyb.data.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author dyb
 * @version V1.0
 * @Package com.dyb.data.config
 * @Description: TODO
 * @date 2018/6/6 下午4:08
 */
@Aspect()
//@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
@Order(-1)
@Component
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, TargetDataSource ds) {
        String key = ds.name();
        logger.info("切面进来啦");
        System.out.println("切面进来啦System.out.println");
        logger.info(point.getSignature().getName());
        if (!DynamicDataSourceHolder.containsDataSource(key)) {
            logger.debug("数据源[{}]不存在，使用默认数据源 > {}", key, point.getSignature());
        } else {
            logger.info("Use DataSource : {} > {}", key, point.getSignature());
            DynamicDataSourceHolder.setDataSourceKey(key);
        }
    }

    @After("@annotation(ds)")
    public void revertDataSource(JoinPoint point, TargetDataSource ds) {
        DynamicDataSourceHolder.removeDataSoureKey();
    }

}
