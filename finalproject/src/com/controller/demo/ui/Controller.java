package com.controller.demo.ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.demo.domain.Customer;
import com.controller.demo.service.CustomerService;
import com.controller.demo.service.imp.CustomerServiceImp;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService customerService = new CustomerServiceImp();
   
    public Controller() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // 操作标志
        String action = request.getParameter("action");

        if ("search".equalsIgnoreCase(action)) {
            //TODO
        } else if ("reg".equalsIgnoreCase(action)) {
            //TODO
        } else if ("login".equalsIgnoreCase(action)) {

            String companyId = request.getParameter("companyId");
            String companyNumber = request.getParameter("companyNumber");

            Customer customer = new Customer();
            customer.setCompanyId(Integer.parseInt(companyId));
            customer.setCompanyNumber(companyNumber);

            if (customerService.login(customer)) {
                //登录成功
                HttpSession session = request.getSession();
                session.setAttribute("customer", customer);
                request.getRequestDispatcher("login_success.jsp").forward(request, response);
            } else {
                // 登录失败
                request.getRequestDispatcher("login.html").forward(request, response);
            }

        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
