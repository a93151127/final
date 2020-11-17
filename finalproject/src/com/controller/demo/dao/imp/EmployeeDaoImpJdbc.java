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
import com.controller.demo.dao.EmployeeDao;
import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Employee;

public class EmployeeDaoImpJdbc implements EmployeeDao{

	@Override
	public void create(Employee employee) {
		String sql = "insert into finalproject.employee(employeeName,employeeTel,email,jobTitle,officeCode) values (?,?,?,?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, employee.getEmployeeName());
                ps.setString(2, employee.getEmployeeTel());
                ps.setString(3, employee.getEmail());
                ps.setString(4, employee.getJobTitle());
                ps.setInt(5, employee.getOfficeCode());
               

                return ps;
            }
        });
		
	}

	@Override
	public void modify(Employee employee) {
		String sql = "update finalproject.employee set employeeName=?, employeeTel=?,email=?,jobTitle=?,officeCode=? where employeeId=?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, employee.getEmployeeName());
                ps.setString(2, employee.getEmployeeTel());
                ps.setString(3, employee.getEmail());
                ps.setString(4, employee.getJobTitle());
                ps.setInt(5, employee.getOfficeCode());
                ps.setInt(6, employee.getEmployeeId());
               
                return ps;
            }
        });
		
	}

	@Override
	public void remove(int employeeId) {
		 String sql = "delete from finalproject.employee where employeeId=?";
	        jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setInt(1,employeeId);

	                return ps;
	            }
	        });
		
	}

	@Override
	public Employee findByPk(int pk) {
		final List<Employee> list = new ArrayList<Employee>();

        String sql = "select employeeName,employeeTel,email,jobTitle,officeCode from finalproject.employee where employeeId=?";

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

            	Employee employee = new Employee();
                //customer.setCompanyId(rs.getInt("companyId"));
            	employee.setEmployeeId(pk);
            	employee.setEmployeeName(rs.getString("employeeName"));
            	employee.setEmployeeTel(rs.getString("employeeTel"));
            	employee.setEmail(rs.getString("email"));
            	employee.setJobTitle(rs.getString("jobTitle"));
            	employee.setOfficeCode(rs.getInt("officeCode"));
                

                list.add(employee);
            }
        });

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> list = new ArrayList<Employee>();

        String sql = "select * from finalproject.employee";

        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

                PreparedStatement ps = conn.prepareStatement(sql);
                return ps;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {

            	Employee employee = new Employee();
            	employee.setEmployeeId(rs.getInt("employeeId"));
            	employee.setEmployeeName(rs.getString("employeeName"));
            	employee.setEmployeeTel(rs.getString("employeeTel"));
            	employee.setEmail(rs.getString("email"));
            	employee.setJobTitle(rs.getString("jobTitle"));
            	employee.setOfficeCode(rs.getInt("officeCode"));

                list.add(employee);
            }
        });

        return list;
	}

}
