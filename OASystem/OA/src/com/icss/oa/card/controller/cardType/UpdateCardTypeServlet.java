package com.icss.oa.card.controller.cardType;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.card.pojo.CardType;
import com.icss.oa.card.service.CardService;
import com.icss.oa.card.service.CardTypeService;

@WebServlet("/UpdateCardTypeServlet")
public class UpdateCardTypeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		����������
	
		String cardTypeName=request.getParameter("cardTypeName");
		String cardTypeId=request.getParameter("cardTypeId");
		
		//String data =request.getParameter("data");	
	
//		��װ����
		System.out.println(cardTypeId+cardTypeName+"  ");
		//CardType cardType=new CardType(cardTypeName,Integer.parseInt(cardTypeId));
//		����ҵ�����
		CardTypeService service = new CardTypeService();
		
		try {
			service.updateCardType(cardTypeName,cardTypeId);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		

		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
}