package com.hjl.order.controller;

import com.hjl.order.datatoobject.OrderDTO;
import com.hjl.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName SendMessageController
 * @AUthor hanjialiang
 * @Date 2019-04-13 22:42
 * @Version 1.0
 * @Description
 */
@RestController
public class SendMessageController {
    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMessage")
    public void process(){
        String message="now "+new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }

    @GetMapping("/send")
    public void processobj(){
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setOrderId("123455");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
