package com.hjl.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MqReceiver
 * @AUthor hanjialiang
 * @Date 2019-04-13 22:01
 * @Version 1.0
 * @Description
 */
@Slf4j
@Component
public class MqReceiver {
    //1、手动创建
    //@RabbitListener(queues = "myQueue")
    //2自动创建队列
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3、自动创建并绑定queue和Exchange
    @RabbitListener(bindings = @QueueBinding(
            value =@Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void pocess(String message){
        log.info("MyReceiver: {}",message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value =@Queue("computerOrder"),
            exchange = @Exchange("myOrder"),
            key = "computer"
    ))
    public void pocessComputer(String message){
        log.info("Computer Mq Receiver: {}",message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value =@Queue("computerOrder"),
            exchange = @Exchange("myOrder"),
            key = "fruit"
    ))
    public void pocessFruit(String message){
        log.info("Fruit Mq Receiver: {}",message);
    }
}
