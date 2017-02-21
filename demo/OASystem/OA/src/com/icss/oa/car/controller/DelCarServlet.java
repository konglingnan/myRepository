package com.icss.oa.car.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.car.service.CarService;


/**
 * 删除部门数据访问接口
 */
@WebServlet("/DelCarServlet")
public class DelCarServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String carId = request.getParameter("carId");
		
		System.out.println("Servlet:"+carId);
		
		CarService service = new CarService();
		
		try {
			service.deleteCar(Integer.parseInt(carId));
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}
