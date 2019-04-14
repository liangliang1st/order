package com.hjl.order.repository;

import com.hjl.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName OrderDetailRepository
 * @AUthor hanjialiang
 * @Date 2019-04-10 20:26
 * @Version 1.0
 * @Description
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
