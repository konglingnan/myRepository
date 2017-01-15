package com.icss.oa.car.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.car.pojo.Car;
import com.icss.oa.car.service.CarService;

/**
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/UpdateCarServlet")
public class UpdateCarServlet extends HttpServlet {
	
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
		String carIdStr = request.getParameter("carId");
		String carType = request.getParameter("carType");
		String carTag = request.getParameter("carTag");
		
//		封装数据
//		封装为pojo对象
		int carId = Integer.parseInt(carIdStr);
		
		Car car = new Car(carId, carType, carTag, null);
		
//		创建业务对象
		CarService service = new CarService();
		
		try {
			service.updateCar(car);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}

//		成功提示
		out.print("修改成功！");
		
	}

}
