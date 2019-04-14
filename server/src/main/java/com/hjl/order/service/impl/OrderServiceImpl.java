package com.hjl.order.service.impl;


import com.hjl.order.client.ClientPro;
import com.hjl.order.dataobject.OrderDetail;
import com.hjl.order.dataobject.OrderMaster;
import com.hjl.order.datatoobject.OrderDTO;
import com.hjl.order.enums.OrderStatusEnum;
import com.hjl.order.enums.PayStatusEnum;
import com.hjl.order.repository.OrderDetailRepository;
import com.hjl.order.repository.OrderMasterRepository;
import com.hjl.order.service.OrderService;
import com.hjl.order.utils.KeyUtil;

import com.hjl.product.client.ProductClient;
import com.hjl.product.common.DecresseStockInput;
import com.hjl.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName OrderServiceImpl
 * @AUthor hanjialiang
 * @Date 2019-04-10 20:40
 * @Version 1.0
 * @Description
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    public OrderMasterRepository orderMasterRepository;
    @Autowired
    public OrderDetailRepository orderDetailRepository;
//    @Autowired
//    public ProductClient productClient;
    @Autowired
    public ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId=KeyUtil.genUniqueKey();

         // 2、查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);

        // 3、计算总价 TODO
        BigDecimal orderAmout=new BigDecimal(BigInteger.ZERO);
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            for(ProductInfoOutput productInfo:productInfoList){
                if(productInfo.getProductId().equals(orderDetail.getProductId())){
                    orderAmout=productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

         // 4、扣库存 TODO
        List<DecresseStockInput> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecresseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        // 5、订单入库
        OrderMaster orderMaster=new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());

        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
