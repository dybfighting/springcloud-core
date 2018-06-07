package com.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class SpringcloudZuulApplication {

    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(SpringcloudZuulApplication.class, args);
    }
}
