package com.hjl.order.datatoobject;

import com.hjl.order.dataobject.OrderDetail;
import com.hjl.order.enums.OrderStatusEnum;
import com.hjl.order.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName OrderDTO
 * @AUthor hanjialiang
 * @Date 2019-04-10 20:37
 * @Version 1.0
 * @Description
 */
@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();
    private Integer payStatus= PayStatusEnum.WAIT.getCode();

    private List<OrderDetail> orderDetailList;
}
