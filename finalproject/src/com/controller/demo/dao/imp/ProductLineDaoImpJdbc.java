package com.controller.demo.dao.imp;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.controller.db.core.jdbcTemplate;
import com.controller.demo.dao.ProductLineDao;
import com.controller.demo.domain.OrdersDetail;
import com.controller.demo.domain.ProductLine;

public class ProductLineDaoImpJdbc implements ProductLineDao {

	@Override
	public void create(ProductLine productline) {
		String sql = "insert into finalproject.productline(brand)" +
                " values (?)";
		//OrdersDetail ordersdetail2= new OrdersDetail();
        jdbcTemplate.update(conn -> {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, productline.getBrand());
           
            
            return ps;
        });
		
	}

	@Override
	public void modify(ProductLine productline) {
		String sql = "update finalproject.productline set brand=? where productline=?";

        jdbcTemplate.update(conn -> {

            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, productline.getBrand());
            ps.setInt(2, productline.getProductLine());
           
            
            
            return ps;
        });
		
		
	}

	@Override
	public void remove(ProductLine productline) {
		String sql = "delete from finalproject.productline where productline=?";

        jdbcTemplate.update(conn -> {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, productline.getProductLine());

            return ps;
        });
		
	}

	@Override
	public ProductLine findByPk(int pk) {
		List<ProductLine> list = new ArrayList<ProductLine>();
		ProductLine productline= new ProductLine();
        String sql = "select brand from finalproject.productLine where productLine=?";
        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pk);
            return ps;
        }, rs -> {
           
        	 productline.setBrand(rs.getString("brand"));
             
             list.add(productline);
        });

        if (list.size() >= 1) {
            return list.get(0);
        }
        return null;
	}

	@Override
	public List<ProductLine> findAll() {
		List<ProductLine> list = new ArrayList<ProductLine>();
		ProductLine productline= new ProductLine();
        String sql = "select * from finalproject.productline";
        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps;
        }, rs -> {
        	productline.setProductLine(rs.getInt("productLine"));
        	productline.setBrand(rs.getString("brand"));
           
            list.add(productline);
        });

        return list;
	}

}
