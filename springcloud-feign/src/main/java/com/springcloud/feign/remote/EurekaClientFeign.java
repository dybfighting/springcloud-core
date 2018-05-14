package com.springcloud.feign.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dyb
 * @version V1.0
 * @Package com.springcloud.feign.remote
 * @Description: TODO
 * @date 2018/5/14 下午4:43
 */
@FeignClient("springcloud-eurekaclient")
public interface EurekaClientFeign {
    @RequestMapping("/eurekaclient/index")
    String eurekaClientIndex();
}
