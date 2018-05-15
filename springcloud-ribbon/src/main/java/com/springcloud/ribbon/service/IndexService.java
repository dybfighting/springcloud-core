package com.springcloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author dyb
 * @version V1.0
 * @Package com.springcloud.ribbon.service
 * @Description: TODO
 * @date 2018/5/14 下午3:00
 */
@Service
public class IndexService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "indexError")
    public String indexService(){
        return restTemplate.getForObject("http://springcloud-eurekaclient/eurekaclient/index",String.class);
    }

    public String indexError(){
        return "sorry, index error ";
    }
}
