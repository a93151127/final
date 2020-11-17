package com.controller.demo.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.controller.demo.dao.OrderDao;
import com.controller.demo.domain.Orders;
import com.controller.db.core.RowCallbackHandler;
import com.controller.db.core.jdbcTemplate;
public class OrderDaoImpJdbc implements OrderDao{
	jdbcTemplate jdbcTemplate = new jdbcTemplate();
	@Override
	public Orders findByPk(int pk) {
		 List<Orders> list = new ArrayList<Orders>();

	        String sql = "select orderDate,shipDate,amount,companyId from finalproject.order where orderId=?";

	        jdbcTemplate.query(conn -> {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, pk);
	            return ps;
	        },  new RowCallbackHandler() {

				@Override
				public void processRow(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					Orders orders=new Orders();
					orders.setOrderDate(rs.getString("orderDate"));
					orders.setShipDate(rs.getString("shipDate"));
					orders.setAmount(rs.getString("amount"));
					orders.setCompanyId(rs.getInt("companyId"));
					orders.setOrderId(pk);
					list.add(orders);
				}
	        	
	        });

	        if (list.size() == 1) {
	            return list.get(0);
	        }
	        return null;
	}

	@Override
	public List<Orders> findAll() {
		 List<Orders> list = new ArrayList<Orders>();

	        String sql = "select * from finalproject.order";

	        jdbcTemplate.query(conn -> {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            return ps;
	        }, rs -> {
	        	Orders orders=new Orders();
				orders.setOrderDate(rs.getString("orderDate"));
				orders.setShipDate(rs.getString("shipDate"));
				orders.setAmount(rs.getString("amount"));
				orders.setCompanyId(rs.getInt("companyId"));
				orders.setOrderId(rs.getInt("orderId"));
				list.add(orders);
	        });

	        return list;
	}
	
	@Override
	public void create(Orders orders) {
		 String sql = "insert into finalproject.order (orderDate,shipDate,amount,companyId) values (?,?,?,?)";

	        jdbcTemplate.update(conn -> {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, orders.getOrderDate());
	            ps.setString(2, orders.getShipDate());
	            ps.setString(3,orders.getAmount());
	            ps.setInt(4, orders.getCompanyId());

	            return ps;
	        });
	}

	@Override
	public void modify(Orders orders) {
		 String sql = "update finalproject.order set orderDate=?,shipDate=?,amount=?,companyId=? where orderId=?";

	        jdbcTemplate.update(conn -> {
	            PreparedStatement ps = conn.prepareStatement(sql);

	            ps.setString(1, orders.getOrderDate());
	            ps.setString(2,orders.getShipDate());
	            ps.setString(3, orders.getAmount());
	            ps.setInt(4, orders.getCompanyId());
	            ps.setInt(5, orders.getOrderId());
	            

	            return ps;
	        });
		
	}

	@Override
	public void remove(int pk) {
		 String sql = "delete from finalproject.order where orderId=?";

	        jdbcTemplate.update(conn -> {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, pk);

	            return ps;
	        });
		
	}

}
