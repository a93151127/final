package com.controller.demo.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.controller.db.core.jdbcTemplate;
import com.controller.demo.dao.GoodsDao;
import com.controller.demo.domain.Goods;

public class GoodsDaoImpJdbc implements GoodsDao {
	private void populate(List<Goods> list, ResultSet rs) throws SQLException {
        Goods goods = new Goods();
        //goods.setProductCode(rs.getString("productCode"));
        goods.setProductName(rs.getString("productName"));
        goods.setProductLint(rs.getInt("productLine"));
        goods.setProductDescription(rs.getString("productDescription"));
        goods.setProductBrand(rs.getString("productBrand"));
        goods.setBuyPrice(rs.getString("buyPrice"));
        goods.setImage1(rs.getString("image1"));
        

        list.add(goods);
    }
	@Override
	public Goods findByPk(String pk) {
		List<Goods> list = new ArrayList<Goods>();

        String sql = "select productName,productLine,productBrand,productDescription,buyPrice,image1 from finalproject.product where productCode=?";
        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pk);
            return ps;
        }, rs -> {
            populate(list, rs);

        });

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
	}

	@Override
	public List<Goods> findAll() {
		 List<Goods> list = new ArrayList<Goods>();

	        String sql = "select * from finalproject.product";
	        jdbcTemplate.query(conn -> {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            return ps;
	        }, rs -> {
	            populate(list, rs);
	        });

	        return list;
	}

	@Override
	public List<Goods> findStartEnd(int start, int end) {
		List<Goods> list = new ArrayList<Goods>();

        StringBuffer sql = new StringBuffer("select * from finalproject.product");
        sql.append(" LIMIT ").append(end - start);
        sql.append(" OFFSET ").append(start);

        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            return ps;
        }, rs -> {
            populate(list, rs);

        });

        return list;
	}

	@Override
	public void create(Goods goods) {
		String sql = "insert into finalproject.product(productCode,productName,productLine,productBrand,productDescription,buyPrice,image1)" +
                " values (?,?,?,?,?,?,?)";

        jdbcTemplate.update(conn -> {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, goods.getProductCode());
            ps.setString(2, goods.getProductName());
            ps.setDouble(3, goods.getProductLint());
            ps.setString(5, goods.getProductDescription());
            ps.setString(4, goods.getProductBrand());
            ps.setString(6, goods.getBuyPrice());
            ps.setString(7, goods.getImage1());
           
            return ps;
        });
		
	}

	@Override
	public void modify(Goods goods) {
		String sql = "update finalproject.product set productName=?,productLine=?,productBrand=?,productDescription=?,buyPrice=?,image1=? where  productCode=?";

        jdbcTemplate.update(conn -> {

            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, goods.getProductName());
            ps.setInt(2, goods.getProductLint());
            ps.setString(3, goods.getProductBrand());
            ps.setString(4, goods.getProductDescription());
            ps.setString(5, goods.getBuyPrice());
            ps.setString(6, goods.getImage1());
            ps.setString(7, goods.getProductCode());
            
            return ps;
        });
		
	}

	@Override
	public void remove(String pk) {
		 String sql = "delete from finalproject.product where productCode=?";

	        jdbcTemplate.update(conn -> {

	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, pk);

	            return ps;
	        });
		
	}

}
