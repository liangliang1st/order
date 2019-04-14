package com.hjl.order.message;

import com.hjl.order.datatoobject.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @ClassName StreamReceiver
 * @AUthor hanjialiang
 * @Date 2019-04-13 22:40
 * @Version 1.0
 * @Description
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    /*@StreamListener(StreamClient.INPUT)
    public void process(Object message){
        log.info("StreamReceiver: {}",message);
    }*/
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT)
    public Object process(OrderDTO message){
        log.info("StreamReceiver: {}",message);
        return message;
    }
    @StreamListener(StreamClient.OUTPUT)
    public void processOutput(OrderDTO message){
        log.info("StreameReceiver: {}",message);
    }


}
