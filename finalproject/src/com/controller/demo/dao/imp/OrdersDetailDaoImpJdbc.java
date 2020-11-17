package com.controller.demo.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.controller.db.core.jdbcTemplate;
import com.controller.demo.dao.OrdersDetailDao;
import com.controller.demo.domain.Goods;
import com.controller.demo.domain.OrdersDetail;

public class OrdersDetailDaoImpJdbc implements OrdersDetailDao {
	
	@Override
	public OrdersDetail findByOrderId(int orderId) {
		List<OrdersDetail> list = new ArrayList<OrdersDetail>();
		OrdersDetail ordersdetail= new OrdersDetail();
        String sql = "select productCode,quantityOrder,priceEach from finalproject.orderdetail where orderId=?";
        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            return ps;
        }, rs -> {
           
        	 ordersdetail.setProductCode(rs.getString("productCode"));
             ordersdetail.setQuantityOrder(rs.getString("quantityOrder"));
             ordersdetail.setPriceEach(rs.getString("priceEach"));
             list.add(ordersdetail);
        });

        if (list.size() >= 1) {
            return list.get(0);
        }
        return null;
	}

	@Override
	public OrdersDetail findByProductCode(String productCode) {
		List<OrdersDetail> list = new ArrayList<OrdersDetail>();
		OrdersDetail ordersdetail= new OrdersDetail();
        String sql = "select quantityOrder,priceEach,orderId from finalproject.orderdetail where productCode=?";
        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,productCode);
            return ps;
        }, rs -> {
           
        	ordersdetail.setOrderId(rs.getInt("orderId"));
            ordersdetail.setQuantityOrder(rs.getString("quantityOrder"));
            ordersdetail.setPriceEach(rs.getString("priceEach"));
             list.add(ordersdetail);
        });

        if (list.size() >= 1) {
            return list.get(0);
        }
        return null;
	}

	@Override
	public List<OrdersDetail> findAll() {
		List<OrdersDetail> list = new ArrayList<OrdersDetail>();
		OrdersDetail ordersdetail= new OrdersDetail();
        String sql = "select * from finalproject.orderdetail";
        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps;
        }, rs -> {
        	ordersdetail.setProductCode(rs.getString("productCode"));
            ordersdetail.setQuantityOrder(rs.getString("quantityOrder"));
            ordersdetail.setPriceEach(rs.getString("priceEach"));
            ordersdetail.setOrderId(rs.getInt("orderId"));
            list.add(ordersdetail);
        });

        return list;
	}

	@Override
	public void create(OrdersDetail ordersdetail) {
		String sql = "insert into finalproject.orderdetail(productCode,quantityOrder,priceEach,orderId)" +
                " values (?,?,?,?)";
		//OrdersDetail ordersdetail2= new OrdersDetail();
        jdbcTemplate.update(conn -> {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ordersdetail.getProductCode());
            ps.setString(2, ordersdetail.getQuantityOrder());
            ps.setString(3, ordersdetail.getPriceEach());
            ps.setInt(4, ordersdetail.getOrderId());
            
            return ps;
        });
		
	}

	@Override
	public void modify(OrdersDetail ordersdetail) {
		String sql = "update finalproject.orderdetail set productCode=?,quantityOrder=?,priceEach=?,orderId=? where  number=?";

        jdbcTemplate.update(conn -> {

            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, ordersdetail.getProductCode());
            ps.setString(2, ordersdetail.getQuantityOrder());
            ps.setString(3, ordersdetail.getPriceEach());
            ps.setInt(4, ordersdetail.getOrderId());
            ps.setInt(5, ordersdetail.getNumber());
            
            
            return ps;
        });
		
	}

	@Override
	public void remove(int pk) {
		 String sql = "delete from finalproject.orderdetail where number=?";

	        jdbcTemplate.update(conn -> {

	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, pk);

	            return ps;
	        });
		
	}

}
