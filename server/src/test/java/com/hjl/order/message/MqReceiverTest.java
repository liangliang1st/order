package com.hjl.order.message;

import com.hjl.order.OrderApplicationTest;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.junit.Assert.*;

@Component
public class MqReceiverTest extends OrderApplicationTest {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void pocessTest () {
        amqpTemplate.convertAndSend("myQueue","now "+new Date());
    }

    @Test
    public void pocessOrderTest () {
        amqpTemplate.convertAndSend("myOrder","computer","now "+new Date());
    }

    @Test
    public void pocessFruitTest () {
        amqpTemplate.convertAndSend("myQueue","now "+new Date());
    }
}