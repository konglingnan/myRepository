package com.icss.oa.car.controller;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.car.pojo.Car;
import com.icss.oa.car.service.CarService;

/**
 * 根据汽车照片id输出汽车照片
 */
@WebServlet("/GetCarPicServlet")
public class GetCarPicServlet  extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		响应输出流
		OutputStream out = response.getOutputStream();
		
		String carId = request.getParameter("carId");
		
		CarService service = new CarService();
		
		try {
			Car car = service.queryCarById(Integer.parseInt(carId));
			
			//获得图片数据
			InputStream is = car.getCarPic();
			
//			循环读取输出数据
			byte[] b = new byte[1024 * 8];
			
			int len = is.read(b);
			
			while (len != -1) {
				out.write(b, 0, len);
				len = is.read(b);
			}
			
			is.close();
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}