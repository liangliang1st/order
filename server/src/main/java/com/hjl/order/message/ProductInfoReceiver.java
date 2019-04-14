package com.hjl.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hjl.order.utils.JsonUtil;
import com.hjl.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName ProductInfoReceiver
 * @AUthor hanjialiang
 * @Date 2019-04-14 11:05
 * @Version 1.0
 * @Description
 */
@Component
@Slf4j
public class ProductInfoReceiver {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @RabbitListener(queuesToDeclare =@Queue("productInfo"))
    public void process(String message){
        //message-->ProductInfoOutput
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>) JsonUtil
                .fromJson(message, new TypeReference<List<ProductInfoOutput>>() {});
        log.info("从队列【{}】接受消息：{}",productInfoOutputList);

        //储存到redis中
        for (ProductInfoOutput productInfoOutput:productInfoOutputList){
            redisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE,productInfoOutput.getProductId()),
                    String.valueOf(productInfoOutput.getProductStock()));
        }
    }
}
