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
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		����������
		String carIdStr = request.getParameter("carId");
		String carType = request.getParameter("carType");
		String carTag = request.getParameter("carTag");
		
//		��װ����
//		��װΪpojo����
		int carId = Integer.parseInt(carIdStr);
		
		Car car = new Car(carId, carType, carTag, null);
		
//		����ҵ�����
		CarService service = new CarService();
		
		try {
			service.updateCar(car);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}

//		�ɹ���ʾ
		out.print("�޸ĳɹ���");
		
	}

}
