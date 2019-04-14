package com.hjl.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName EnvController
 * @AUthor hanjialiang
 * @Date 2019-04-13 14:58
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/env")
@RefreshScope
public class EnvController {
    @Value("${env}")
    private String env;
    @GetMapping("/print")
    public String getEnv() {
        return env;
    }
}
