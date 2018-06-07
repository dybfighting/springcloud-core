package com.dyb.data.config;

import java.lang.annotation.*;

/**
 * @author dyb
 * @version V1.0
 * @Package com.dyb.data.config
 * @Description: TODO
 * @date 2018/6/6 下午4:24
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name();
}
