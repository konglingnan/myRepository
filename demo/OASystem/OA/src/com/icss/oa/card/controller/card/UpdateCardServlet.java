package com.icss.oa.card.controller.card;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.card.pojo.Card;
import com.icss.oa.card.service.CardService;

@WebServlet("/UpdateCardServlet")
public class UpdateCardServlet extends HttpServlet {

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
		String cardName=request.getParameter("cardName");;
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String cardQQ=request.getParameter("cardQQ");
		String eMail=request.getParameter("eMail");
		String company=request.getParameter("company");
		String identity=request.getParameter("identity");
		String cardTypeId=request.getParameter("cardTypeId");
		
		
//		��װ����
		Card card=new Card(Integer.valueOf(cardId),cardName,phone,address,cardQQ,eMail,company,identity);
		System.out.print(card.toString());
//		����ҵ�����
		CardService service = new CardService();
		
		try {
			service.updateCard(card);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("�������ӳɹ���");
	
	}
	

}