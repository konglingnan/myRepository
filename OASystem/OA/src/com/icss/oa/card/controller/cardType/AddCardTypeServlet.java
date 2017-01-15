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

import com.icss.oa.card.pojo.CardType;
import com.icss.oa.card.service.CardService;
import com.icss.oa.card.service.CardTypeService;

@WebServlet("/AddCardTypeServlet")
public class AddCardTypeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		����������
	
		String cardTypeName=request.getParameter("cardTypeName");
		
	
//		��װ����
		System.out.println(cardTypeName+"  ");
		HttpSession session=request.getSession();
		int employeeId=(int)session.getAttribute("employee_id");
		CardType cardType=new CardType(cardTypeName,employeeId);
//		����ҵ�����
		CardTypeService service = new CardTypeService();
		
		try {
			service.addCardType(cardType);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ	
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		
	
	}

	
}