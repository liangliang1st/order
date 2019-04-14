package com.hjl.order.client;

import com.hjl.product.common.DecresseStockInput;
import com.hjl.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @ClassName ClientPro
 * @AUthor hanjialiang
 * @Date 2019-04-12 14:45
 * @Version 1.0
 * @Description
 */
//@FeignClient(name = "product")
public interface ClientPro {
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);
    @PostMapping("/product/decreaseStock")
    void decreaseStock(List<DecresseStockInput> cartDTOList);
    @GetMapping("/msg")
    String getMsg();
}
