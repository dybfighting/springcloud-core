package com.springcloud.ribbon.service;

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

    public String indexService(){
        return restTemplate.getForObject("http://springcloud-eurekaclient/eurekaclient/index",String.class);
    }
}
