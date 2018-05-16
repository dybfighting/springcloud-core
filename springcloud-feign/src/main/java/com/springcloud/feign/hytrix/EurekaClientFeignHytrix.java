package com.springcloud.feign.hytrix;

import com.springcloud.feign.remote.EurekaClientFeign;
import org.springframework.stereotype.Component;

/**
 * @author dyb
 * @version V1.0
 * @Package com.springcloud.feign.hytrix
 * @Description: TODO
 * @date 2018/5/16 上午9:54
 */
@Component
public class EurekaClientFeignHytrix implements EurekaClientFeign{
    @Override
    public String eurekaClientIndex() {
        return "eurekaClientIndex error ";
    }
}
