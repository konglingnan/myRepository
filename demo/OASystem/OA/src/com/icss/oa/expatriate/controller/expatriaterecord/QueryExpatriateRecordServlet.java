package com.icss.oa.expatriate.controller.expatriaterecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.common.Pager;
import com.icss.oa.expatriate.pojo.Expatriate;
import com.icss.oa.expatriate.pojo.ExpatriateRecord;
import com.icss.oa.expatriate.service.ExpatriateRecordService;
import com.icss.oa.expatriate.service.ExpatriateService;

@WebServlet("/QueryExpatriateRecordServlet")
public class QueryExpatriateRecordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
		String pageNumStr = request.getParameter("pageNum");
		
		int pageNum = 1;
		
		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (Exception e) {
			
		}
		
//		每页记录数
		String pageSizeStr = request.getParameter("pageSize");
		
		int pageSize = 10;
		
		try {
			pageSize = Integer.parseInt(pageSizeStr);
		} catch (Exception e) {
			
		}
		
//		创建业务对象
		ExpatriateRecordService service = new ExpatriateRecordService();

		try {
			Pager pager = new Pager(service.getCount(),pageNum,pageSize);
			ArrayList<ExpatriateRecord> list=service.queryAllExpatriateRecord(pager);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("pager", pager);
			map.put("list", list);
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			
			out.print(gson.toJson(map));
			System.out.println(gson.toJson(map));
			
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
				
	}


}