package com.icss.oa.card.controller.card;


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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.card.pojo.Card;
import com.icss.oa.card.service.CardService;
import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Employee;


/**
 * 分页查询员工数据接口
 */
@WebServlet("/QueryCardServlet")
public class QueryCardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

//		输出流
		PrintWriter out = response.getWriter();

//		获得页码
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
		String cardTypeName = request.getParameter("cardTypeName");
//		业务对象
		CardService service = new CardService();
		System.out.print(cardTypeName);
		try {
			HttpSession session=request.getSession();
			int employeeId=(int)session.getAttribute("employee_id");
			
			Pager pager = new Pager(service.getCount(employeeId,cardTypeName),pageNum,pageSize);
			ArrayList<Card> list = service.queryAllCard(pager,employeeId,cardTypeName);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("pager", pager);
			map.put("list", list);
			
//			产生json格式数据
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			System.out.print(gson.toJson(list));
			out.print(gson.toJson(map));
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
				
	}

}