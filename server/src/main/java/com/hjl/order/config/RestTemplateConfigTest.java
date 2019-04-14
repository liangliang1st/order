package com.hjl.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplateConfig
 * @AUthor hanjialiang
 * @Date 2019-04-11 09:07
 * @Version 1.0
 * @Description
 */
@Component
public class RestTemplateConfigTest {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
