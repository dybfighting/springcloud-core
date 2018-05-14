package com.springcloud.feign.controller;

import com.springcloud.feign.remote.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dyb
 * @version V1.0
 * @Package com.springcloud.feign.controller
 * @Description: TODO
 * @date 2018/5/14 下午4:48
 */
@RestController
public class IndexController {
    @Autowired
    EurekaClientFeign eurekaClientFeign;
    @RequestMapping("/index")
    public String index(){
        return eurekaClientFeign.eurekaClientIndex();
    }
}
