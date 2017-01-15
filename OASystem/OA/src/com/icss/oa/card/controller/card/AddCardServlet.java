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
import com.icss.oa.card.pojo.CardType;
import com.icss.oa.card.service.CardService;
import com.icss.oa.card.service.CardTypeService;

@WebServlet("/AddCardServlet")
public class AddCardServlet extends HttpServlet {

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
		String cardName=request.getParameter("cardName");;
		String phone=request.getParameter("cardPhone");
		String address=request.getParameter("address");
		String cardQQ=request.getParameter("cardQQ");
		String eMail=request.getParameter("Email");
		String company=request.getParameter("company");
		String identity=request.getParameter("identity");
		String cardTypeId=request.getParameter("cardTypeId");
		
		//String data =request.getParameter("data");
		
		System.out.println(cardTypeId);
	
		Card card=new Card(cardName,phone,address,cardQQ,eMail,company,identity,Integer.parseInt(cardTypeId));
		System.out.print(card.toString());
//		����ҵ�����
		CardService service = new CardService();
		
		try {
			service.addCard(card);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("�������ӳɹ���");
	
	}
	

}