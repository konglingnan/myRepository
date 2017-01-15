package com.icss.oa.expatriate.controller.cooperatecompany;

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
import com.icss.oa.expatriate.pojo.CooperateCompany;
import com.icss.oa.expatriate.service.CooperateCompanyService;

@WebServlet("/UpdateCooperateCompanyServlet")
public class UpdateCooperateCompanyServlet extends HttpServlet {

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
		String cooperateCompanyId=request.getParameter("cooperateCompanyId");
		String cooperateCompanyName=request.getParameter("cooperateCompanyName");
		String cooperateCompanyTel=request.getParameter("cooperateCompanyTel");
		String cooperateCompanyPerson=request.getParameter("cooperateCompanyPerson");
		String cooperateCompanyAddress=request.getParameter("cooperateCompanyAddress");
		
		//String data =request.getParameter("data");	
	
//		��װ����
		CooperateCompany cooperateCompany=new CooperateCompany(Integer.parseInt(cooperateCompanyId),
				cooperateCompanyName,
				cooperateCompanyPerson,
				cooperateCompanyAddress,
				cooperateCompanyTel);
		System.out.print("ssssssssssssssssss"+cooperateCompany.toString());
//		����ҵ�����
		CooperateCompanyService service = new CooperateCompanyService();

		try {
			service.updateCooperateCompany(cooperateCompany);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("�������ӳɹ���");
	
	}
	

}