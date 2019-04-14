package com.hjl.order.datatoobject;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName CartDTO
 * @AUthor hanjialiang
 * @Date 2019-04-11 11:03
 * @Version 1.0
 * @Description
 */
@Data
@AllArgsConstructor
public class CartDTO {

    private String productId;

    private Integer productQuantity;
}
