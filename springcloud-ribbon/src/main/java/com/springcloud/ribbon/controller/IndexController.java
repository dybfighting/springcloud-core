package com.springcloud.ribbon.controller;

import com.springcloud.ribbon.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dyb
 * @version V1.0
 * @Package com.springcloud.ribbon.controller
 * @Description: TODO
 * @date 2018/5/14 下午3:05
 */
@RestController
public class IndexController {
    @Autowired
    IndexService indexService;
    @RequestMapping("/ribbonindex")
    public String index(){
        return indexService.indexService();
    }
}

