package com.icss.oa.expatriate.controller.expatriaterecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.expatriate.pojo.CooperateCompany;
import com.icss.oa.expatriate.pojo.Expatriate;
import com.icss.oa.expatriate.pojo.ExpatriateRecord;
import com.icss.oa.expatriate.service.ExpatriateRecordService;

@WebServlet("/UpdateExpatriateRecordServlet")
public class UpdateExpatriateRecordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
		String expatriateRecordId=request.getParameter("expatriateRecordId");
		String expatriateId  =request.getParameter("expatriateId");
		String cooperateCompanyId =request.getParameter("cooperateCompanyId");
	
		
		
		//String data =request.getParameter("data");	
		Expatriate expatriate=new Expatriate();
		CooperateCompany cooperateCompany=new CooperateCompany();
		cooperateCompany.setCooperateCompanyId(Integer.parseInt(cooperateCompanyId));
		expatriate.setExpatriateId(Integer.parseInt(expatriateId));
//		封装数据
		ExpatriateRecord expatriateRecord=new ExpatriateRecord(Integer.parseInt(expatriateRecordId),
				expatriate,cooperateCompany);
		
//		创建业务对象
		ExpatriateRecordService service = new ExpatriateRecordService();

		try {
			service.updateExpatriateRecord(expatriateRecord);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		成功提示
		out.print("部门增加成功！");
	
	}
	

}