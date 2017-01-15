package com.icss.oa.car.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.car.pojo.Car;
import com.icss.oa.car.pojo.DistributeCar;
import com.icss.oa.car.service.DistributeCarService;
import com.icss.oa.system.pojo.Employee;

@WebServlet("/AddDisServlet")
public class AddDisServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		
//		获得表单数据
		String route = request.getParameter("route");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String empId = request.getParameter("empId");

//		封装为pojo对象
		Employee employee = new Employee();
		employee.setEmpId(Integer.parseInt(empId));
		
		DistributeCar distributeCar = new DistributeCar(route, Date.valueOf(startDate), Date.valueOf(endDate), null, employee, null);
		
//		业务对象
		DistributeCarService service = new DistributeCarService();
		
		try {
			service.addDis(distributeCar);
		} catch (SQLException e) {			
			e.printStackTrace();
		}

	}

}