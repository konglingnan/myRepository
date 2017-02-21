package com.icss.oa.car.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.car.pojo.Car;
import com.icss.oa.car.service.CarService;

/**
 * 汽车照片数据访问接口
 */
@WebServlet("/QueryCarPicServlet")
public class QueryCarPicServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OutputStream out = response.getOutputStream();
		
		String cpId = request.getParameter("carId");
		
		CarService service = new CarService();
		
		try {
			Car car = service.queryPic(Integer.parseInt(cpId));
			InputStream is = car.getCarPic();
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