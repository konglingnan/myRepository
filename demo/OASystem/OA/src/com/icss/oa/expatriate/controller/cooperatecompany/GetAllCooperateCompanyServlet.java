package com.icss.oa.expatriate.controller.cooperatecompany;

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
import com.icss.oa.card.service.CardService;
import com.icss.oa.expatriate.pojo.CooperateCompany;
import com.icss.oa.expatriate.service.CooperateCompanyService;

@WebServlet("/GetAllCooperateCompanyServlet")
public class GetAllCooperateCompanyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		����������
		
		
		
		//String data =request.getParameter("data");	
	
//		��װ����
		
		
//		����ҵ�����
		CooperateCompanyService service = new CooperateCompanyService();

		try {
			ArrayList<CooperateCompany> list= service.queryAllCooperateCompany();
			
//			����json��ʽ����
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			System.out.print(gson.toJson(list)+"sss");
			out.print(gson.toJson(list));
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		

	}

	

}