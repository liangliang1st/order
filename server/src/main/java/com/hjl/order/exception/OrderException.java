package com.hjl.order.exception;

import com.hjl.order.enums.ResultEnum;

/**
 * @ClassName OrderException
 * @AUthor hanjialiang
 * @Date 2019-04-10 21:00
 * @Version 1.0
 * @Description
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException (Integer code,String message){
        super(message);
        this.code=code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}
