package com.controller.demo.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.controller.db.core.PreparedStatementCreator;
import com.controller.db.core.RowCallbackHandler;
import com.controller.db.core.jdbcTemplate;
import com.controller.demo.dao.OfficeDao;
import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Office;

public class OfficeDaoImpJdbc implements OfficeDao {

	@Override
	public void create(Office office) {
		 String sql = "insert into office(city,officeAddress,postalCode) values (?,?,?)";
	        jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setString(1, office.getCity());
	                ps.setString(2, office.getOfficeAddress());
	                ps.setInt(3, office.getPostalCode());
	               
	                return ps;
	            }
	        });
		
	}

	@Override
	public void modify(Office office) {
		String sql = "update finalproject.office set city=?, officeAddress=?,postalCode=? where officeCode=?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, office.getCity());
                ps.setString(2, office.getOfficeAddress());
                ps.setInt(3, office.getPostalCode());
                ps.setInt(4, office.getOfficeCode());
               

                return ps;
            }
        });
		
	}

	@Override
	public void remove(int officeCode) {
		 String sql = "delete from finalproject.office where officeCode=?";
	        jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setInt(1, officeCode);

	                return ps;
	            }
	        });
		
	}

	@Override
	public Office findByPk(int pk) {
		List<Office> list = new ArrayList<Office>();

        String sql = "select city,officeAddress,postalCode from finalproject.office where officeCode=?";

        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, pk);

                return ps;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {

                Office office=new Office();
                //customer.setCompanyId(rs.getInt("companyId"));
                office.setOfficeCode(pk);
                office.setCity(rs.getString("city"));
                office.setOfficeAddress(rs.getString("officeAddress"));
                office.setPostalCode(rs.getInt("postalCode"));
               

                list.add(office);
            }
        });

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
	}

	@Override
	public List<Office> findAll() {
		final List<Office> list = new ArrayList<Office>();

        String sql = "select * from finalproject.office";

        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

                PreparedStatement ps = conn.prepareStatement(sql);
                return ps;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {

            	Office office = new Office();
            	office.setOfficeCode(rs.getInt("officeCode"));
                office.setCity(rs.getString("city"));
                office.setOfficeAddress(rs.getString("officeAddress"));
                office.setPostalCode(rs.getInt("postalCode"));
               

                list.add(office);
            }
        });

        return list;
	}

}
