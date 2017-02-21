package com.icss.oa.system.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.system.service.EmployeeService;

/**
 * ɾ���������ݷ��ʽӿ�
 */
@WebServlet("/DelEmpServlet")
public class DelEmpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empId = request.getParameter("empId");
		EmployeeService service = new EmployeeService();
		
		try {
			service.deleteEmp(Integer.parseInt(empId));
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
	}

}
