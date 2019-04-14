package com.hjl.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName ResultEnum
 * @AUthor hanjialiang
 * @Date 2019-04-10 21:03
 * @Version 1.0
 * @Description
 */
@Getter
@AllArgsConstructor
public enum  ResultEnum {

    PARAM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车为空"),
    ;

    private Integer code;
    private String message;
}
