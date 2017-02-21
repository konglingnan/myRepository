package com.icss.oa.card.controller.card;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.icss.oa.card.service.CardService;

@WebServlet("/DelCardServlet")
public class DelCardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		����������
	
		String cardId=request.getParameter("cardId");
		
		//String data =request.getParameter("data");	
	
//		��װ����
		
		
//		����ҵ�����
		CardService service = new CardService();
		System.out.print(cardId);
		try {
			service.deleteCard(Integer.parseInt(cardId));
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("�������ӳɹ���");
	
	}
	

}