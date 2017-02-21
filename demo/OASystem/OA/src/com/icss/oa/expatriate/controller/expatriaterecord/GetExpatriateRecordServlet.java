package com.icss.oa.expatriate.controller.expatriaterecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.expatriate.pojo.Expatriate;
import com.icss.oa.expatriate.pojo.ExpatriateRecord;
import com.icss.oa.expatriate.service.ExpatriateRecordService;
import com.icss.oa.expatriate.service.ExpatriateService;

@WebServlet("/GetExpatriateRecordServlet")
public class GetExpatriateRecordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
		String expatriateRecordId=request.getParameter("expatriateRecordId");
		
		
//		创建业务对象
		ExpatriateRecordService service = new ExpatriateRecordService();

		try {
			ExpatriateRecord expatriateRecord = service.queryExpatriateRecordById(Integer.parseInt(expatriateRecordId));
			
			
//			产生json格式数据
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			
			out.print(gson.toJson(expatriateRecord));
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
			
	}



}