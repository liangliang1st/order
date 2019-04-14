package com.hjl.order.service;

import com.hjl.order.datatoobject.OrderDTO;

public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);
}
