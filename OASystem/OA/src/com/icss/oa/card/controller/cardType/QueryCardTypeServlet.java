package com.icss.oa.card.controller.cardType;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.card.pojo.CardType;
import com.icss.oa.card.service.CardService;
import com.icss.oa.card.service.CardTypeService;

@WebServlet("/QueryCardTypeServlet")
public class QueryCardTypeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
	
		
		//String employeeId=request.getParameter("employeeId");	
//		创建业务对象
		CardTypeService service = new CardTypeService();
		
		try {
			HttpSession session=request.getSession();
			int employeeId=(int)session.getAttribute("employee_id");
			
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			
			out.print(gson.toJson(service.queryAllCardType(employeeId)));
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
			
	}

}