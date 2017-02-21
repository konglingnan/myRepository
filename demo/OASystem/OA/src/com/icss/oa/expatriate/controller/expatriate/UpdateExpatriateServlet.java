package com.icss.oa.expatriate.controller.expatriate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.expatriate.pojo.Expatriate;
import com.icss.oa.expatriate.service.ExpatriateService;

@WebServlet("/UpdateExpatriateServlet")
public class UpdateExpatriateServlet extends HttpServlet {

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
		String expatriateId=request.getParameter("expatriateId");
		String expatriateName  =request.getParameter("expatriateName");
		String expatriateSkill =request.getParameter("expatriateSkill");
		String expatriateSalary  =request.getParameter("expatriateSalary");
		String expatriateState = request.getParameter("expatriateState");
		
		//String data =request.getParameter("data");	
	
//		��װ����
		Expatriate expatriate=new Expatriate(Integer.parseInt(expatriateId),expatriateName,expatriateSkill,Float.parseFloat(expatriateSalary),expatriateState);
		System.out.print(expatriate.toString());
//		����ҵ�����
		ExpatriateService service = new ExpatriateService();

		try {
			service.updateExpatriate(expatriate);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("�������ӳɹ���");
	
	}
	

}