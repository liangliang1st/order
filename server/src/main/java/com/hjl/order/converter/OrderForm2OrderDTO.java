package com.hjl.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hjl.order.dataobject.OrderDetail;
import com.hjl.order.datatoobject.OrderDTO;
import com.hjl.order.enums.ResultEnum;
import com.hjl.order.exception.OrderException;
import com.hjl.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderForm2OrderDTO
 * @AUthor hanjialiang
 * @Date 2019-04-10 21:05
 * @Version 1.0
 * @Description
 */
@Slf4j
public class OrderForm2OrderDTO {
    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList=new ArrayList<>();
        Gson gson=new Gson();
        try{
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());

        }catch (Exception e ){
            log.error("【json转换】错误,string={}",orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return  orderDTO;
    }
}
