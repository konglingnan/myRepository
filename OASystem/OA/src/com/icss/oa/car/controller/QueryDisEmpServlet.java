package com.icss.oa.car.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.system.pojo.Employee;
import com.icss.oa.system.service.EmployeeService;

@WebServlet("/QueryDisEmpServlet")
public class QueryDisEmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		����ҵ�����
		EmployeeService service = new EmployeeService();
		
		try {
			ArrayList<Employee> list = service.queryAllEmp();
			
//			����json��ʽ����
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			
			out.print(gson.toJson(list));
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

}
