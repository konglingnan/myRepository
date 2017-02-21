package com.icss.oa.expatriate.controller.expatriate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.expatriate.pojo.Expatriate;
import com.icss.oa.expatriate.service.ExpatriateService;
import com.icss.oa.system.pojo.Department;
import com.icss.oa.system.service.DepartmentService;

/**
 * Servlet implementation class GetDeptServlet
 */
@WebServlet("/GetExpatriateServlet")
public class GetExpatriateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();

		String expatriateId = request.getParameter("expatriateId");

		ExpatriateService service = new ExpatriateService();

		try {
			Expatriate expatriate = service.queryExpatriateById(Integer.parseInt(expatriateId));
			System.out.println(expatriate);	
			
//			产生json格式数据
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			
			out.print(gson.toJson(expatriate));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}