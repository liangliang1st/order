package com.hjl.order.repository;

import com.hjl.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName OrderMasterRepository
 * @AUthor hanjialiang
 * @Date 2019-04-10 20:12
 * @Version 1.0
 * @Description
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
