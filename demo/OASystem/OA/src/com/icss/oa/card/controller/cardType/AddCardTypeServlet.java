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
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
	
		String cardTypeName=request.getParameter("cardTypeName");
		
	
//		封装数据
		System.out.println(cardTypeName+"  ");
		HttpSession session=request.getSession();
		int employeeId=(int)session.getAttribute("employee_id");
		CardType cardType=new CardType(cardTypeName,employeeId);
//		创建业务对象
		CardTypeService service = new CardTypeService();
		
		try {
			service.addCardType(cardType);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		成功提示	
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		
	
	}

	
}