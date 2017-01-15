package com.icss.oa.car.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.car.pojo.DistributeCar;
import com.icss.oa.car.service.DistributeCarService;

@WebServlet("/GetDisServlet")
public class GetDisServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();

		String distributeCarId = request.getParameter("distributeCarId");

		DistributeCarService service = new DistributeCarService();

		try {
			
			DistributeCar distributeCar = service.queryDisById(Integer.parseInt(distributeCarId));
			
//			产生json格式数据
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();

			out.print(gson.toJson(distributeCar));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
