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
//        SpringApplication.run(SpringcloudZuulApplication.class, args);
        String s = "9999";
        System.out.println(Arrays.toString(s.getBytes("utf-8")));
        byte b = 0x68;
        String data = "{head:{tag1:value1,tag2:value2,...},body:{tag3:value3,tag4:value4, params:[{ param1:values1 },{ paramn:valuesn }],...}}";
        System.out.println(Arrays.toString(data.getBytes("UTF-8"))+"lenght:"+data.getBytes("UTF-8").length);
    }
}
