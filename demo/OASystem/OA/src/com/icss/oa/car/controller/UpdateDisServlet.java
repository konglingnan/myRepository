package com.icss.oa.car.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.icss.oa.system.service.EmployeeService;

/**
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/UpdateDisServlet")
public class UpdateDisServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
		String distributeCarIdStr = request.getParameter("distributeCarId");
		String route = request.getParameter("route");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String state = request.getParameter("state");
		String empId = request.getParameter("empId");
		String carId = request.getParameter("carId");
		
//		封装数据
//		封装为pojo对象
		Employee employee = new Employee();
		employee.setEmpId(Integer.parseInt(empId));
		
		Car car = new Car();
		car.setCarId(Integer.parseInt(carId));
		
		int distributeCarId = Integer.parseInt(distributeCarIdStr);
		
		DistributeCar distributeCar = new DistributeCar(distributeCarId, route, Date.valueOf(startDate), Date.valueOf(endDate), "已派发", employee, car);
		
//		创建业务对象
		DistributeCarService service = new DistributeCarService();
		
		try {
			service.updateDis(distributeCar);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}

//		成功提示
		out.print("派车成功！");
		
	}

}
