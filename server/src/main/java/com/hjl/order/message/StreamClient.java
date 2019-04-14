package com.hjl.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @ClassName StreamClient
 * @AUthor hanjialiang
 * @Date 2019-04-13 22:38
 * @Version 1.0
 * @Description
 */
public interface StreamClient {

    String INPUT="input";
    String OUTPUT="output";


    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();
}
