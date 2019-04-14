package com.hjl.order.viewobject;

import lombok.Data;

/**
 * @ClassName ResultVO
 * @AUthor hanjialiang
 * @Date 2019-04-10 21:22
 * @Version 1.0
 * @Description
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}
