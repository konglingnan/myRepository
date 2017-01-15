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

@WebServlet("/AddCooperateCompanyServlet")
public class AddCooperateCompanyServlet extends HttpServlet {

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
		String cooperateCompanyName=request.getParameter("cooperateCompanyName");
		String cooperateCompanyTel=request.getParameter("cooperateCompanyTel");
		String cooperateCompanyPerson=request.getParameter("cooperateCompanyPerson");
		String cooperateCompanyAddress=request.getParameter("cooperateCompanyAddress");
		
		
		//String data =request.getParameter("data");	
	
//		封装数据
		CooperateCompany cooperateCompany=new CooperateCompany(cooperateCompanyName,
				cooperateCompanyPerson,
				cooperateCompanyAddress,
				cooperateCompanyTel);
		
//		创建业务对象
		CooperateCompanyService service = new CooperateCompanyService();

		try {
			service.addCooperateCompany(cooperateCompany);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		成功提示
		out.print("部门增加成功！");
	
	}
	

}