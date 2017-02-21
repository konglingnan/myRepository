package com.icss.oa.expatriate.controller.expatriate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.expatriate.pojo.Expatriate;
import com.icss.oa.expatriate.service.ExpatriateService;

@WebServlet("/DelExpatriateServlet")
public class DelExpatriateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
		String expatriateId=request.getParameter("expatriateId");
		System.out.print(expatriateId);
		
//		创建业务对象
		ExpatriateService service = new ExpatriateService();

		try {
			service.deleteExpatriate(Integer.parseInt(expatriateId));
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
			
	}



}