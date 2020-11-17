package com.controller.demo.dao;

import java.util.List;


import com.controller.demo.domain.OrdersDetail;

public interface OrdersDetailDao {
	OrdersDetail findByOrderId(int orderId);
	
	OrdersDetail findByProductCode(String productCode);

    List<OrdersDetail> findAll();

    void create(OrdersDetail ordersdetail);

    void modify(OrdersDetail ordersdetail);

    void remove(int pk);
}
