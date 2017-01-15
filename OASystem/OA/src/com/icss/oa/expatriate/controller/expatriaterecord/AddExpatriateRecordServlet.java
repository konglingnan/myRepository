package com.icss.oa.expatriate.controller.expatriaterecord;

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
import com.icss.oa.expatriate.pojo.Expatriate;
import com.icss.oa.expatriate.pojo.ExpatriateRecord;
import com.icss.oa.expatriate.service.CooperateCompanyService;
import com.icss.oa.expatriate.service.ExpatriateRecordService;
import com.icss.oa.expatriate.service.ExpatriateService;

@WebServlet("/AddExpatriateRecordServlet")
public class AddExpatriateRecordServlet extends HttpServlet {

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
		String expatriateId  =request.getParameter("expatriateId");
		String cooperateCompanyId =request.getParameter("cooperateCompanyId");
		
		
		
		//String data =request.getParameter("data");	
	
//		��װ����
		System.out.println("ssssssssssssss"+expatriateId);
		ExpatriateService expatriateService=new ExpatriateService();
		try {
			expatriateService.updateExpatriate(Integer.parseInt(expatriateId));
		} catch (NumberFormatException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Expatriate expatriate=new Expatriate();
		CooperateCompany cooperateCompany=new CooperateCompany();
		cooperateCompany.setCooperateCompanyId(Integer.parseInt(cooperateCompanyId));
		expatriate.setExpatriateId(Integer.parseInt(expatriateId));
//		��װ����
		ExpatriateRecord expatriateRecord=new ExpatriateRecord(
				expatriate,cooperateCompany);
//		����ҵ�����
		ExpatriateRecordService service = new ExpatriateRecordService();

		try {
			service.addExpatriateRecord(expatriateRecord);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("�������ӳɹ���");
	
	}
	

}