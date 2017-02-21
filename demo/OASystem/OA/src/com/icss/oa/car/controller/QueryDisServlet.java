package com.icss.oa.car.controller;

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
import com.icss.oa.car.pojo.DistributeCar;
import com.icss.oa.car.service.DistributeCarService;
import com.icss.oa.common.Pager;

@WebServlet("/QueryDisServlet")
public class QueryDisServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();

//		���ҳ��
		String pageNumStr = request.getParameter("pageNum");
		
		int pageNum = 1;
		
		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (Exception e) {
			
		}
		
//		ÿҳ��¼��
		String pageSizeStr = request.getParameter("pageSize");
		
		int pageSize = 10;
		
		try {
			pageSize = Integer.parseInt(pageSizeStr);
		} catch (Exception e) {
			
		}
		
		
//		����ҵ�����
		DistributeCarService service = new DistributeCarService();
		
		try {
			Pager pager = new Pager(service.getDisCount(),pageNum,pageSize);
			ArrayList<DistributeCar> list = service.queryAllDis(pager);

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("pager", pager);
			map.put("list", list);
			
//			����json��ʽ����
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			
			out.print(gson.toJson(map));
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

}
