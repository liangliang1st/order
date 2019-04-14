package com.hjl.order.controller;

import com.hjl.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GirlController
 * @AUthor hanjialiang
 * @Date 2019-04-13 16:17
 * @Version 1.0
 * @Description
 */
@RestController
public class GirlController {
    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print(){
        return "name:"+girlConfig.getName()+"  age:"+girlConfig.getAge();
    }
}
