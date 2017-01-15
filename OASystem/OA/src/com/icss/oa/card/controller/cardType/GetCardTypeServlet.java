package com.icss.oa.card.controller.cardType;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.card.pojo.Card;
import com.icss.oa.card.pojo.CardType;
import com.icss.oa.card.service.CardService;
import com.icss.oa.card.service.CardTypeService;

@WebServlet("/GetCardTypeServlet")
public class GetCardTypeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
		String cardTypeId=request.getParameter("cardTypeId");
	
//		创建业务对象
		CardTypeService service = new CardTypeService();
		
		System.out.println(cardTypeId);
		try {
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			String cardType=service.queryName(Integer.parseInt(cardTypeId));	
			
			out.print(gson.toJson(cardType));
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}	
	}


	

}