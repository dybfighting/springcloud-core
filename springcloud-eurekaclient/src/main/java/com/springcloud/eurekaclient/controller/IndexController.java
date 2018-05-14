package com.springcloud.eurekaclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dyb
 * @version V1.0
 * @Package com.springcloud.eurekaclient.controller
 * @Description: TODO
 * @date 2018/5/14 下午1:50
 */
@RestController
public class IndexController {
    @RequestMapping(value = "/index",method = {RequestMethod.GET,RequestMethod.POST})
    public String index(){
        return "index";
    }
}
