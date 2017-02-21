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
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		����������
		String distributeCarIdStr = request.getParameter("distributeCarId");
		String route = request.getParameter("route");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String state = request.getParameter("state");
		String empId = request.getParameter("empId");
		String carId = request.getParameter("carId");
		
//		��װ����
//		��װΪpojo����
		Employee employee = new Employee();
		employee.setEmpId(Integer.parseInt(empId));
		
		Car car = new Car();
		car.setCarId(Integer.parseInt(carId));
		
		int distributeCarId = Integer.parseInt(distributeCarIdStr);
		
		DistributeCar distributeCar = new DistributeCar(distributeCarId, route, Date.valueOf(startDate), Date.valueOf(endDate), "���ɷ�", employee, car);
		
//		����ҵ�����
		DistributeCarService service = new DistributeCarService();
		
		try {
			service.updateDis(distributeCar);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}

//		�ɹ���ʾ
		out.print("�ɳ��ɹ���");
		
	}

}
