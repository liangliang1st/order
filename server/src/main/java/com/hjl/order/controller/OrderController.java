package com.hjl.order.controller;

import com.hjl.order.converter.OrderForm2OrderDTO;
import com.hjl.order.datatoobject.OrderDTO;
import com.hjl.order.enums.ResultEnum;
import com.hjl.order.exception.OrderException;
import com.hjl.order.form.OrderForm;
import com.hjl.order.service.OrderService;
import com.hjl.order.utils.ResultVOUtil;
import com.hjl.order.viewobject.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName OrderController
 * @AUthor hanjialiang
 * @Date 2019-04-10 20:33
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    /**
     * 1、参数校验
     * 2、查询商品信息（调用商品服务）
     * 3、计算总价
     * 4、扣库存
     * 5、订单入库
     */
    @Autowired
    private OrderService orderService;

    //5
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确,orderForm={}",orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        //orderForm->orderDto
        OrderDTO orderDTO= OrderForm2OrderDTO.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String,String> map=new HashMap<>();
        map.put("orderId",result.getOrderId());
        return ResultVOUtil.success(map);
    }
}
