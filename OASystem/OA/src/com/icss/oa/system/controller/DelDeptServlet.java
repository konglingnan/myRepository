package com.icss.oa.system.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.system.service.DepartmentService;

/**
 * 删除部门数据访问接口
 */
@WebServlet("/DelDeptServlet")
public class DelDeptServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deptId = request.getParameter("deptId");
		
		DepartmentService service = new DepartmentService();
		
		try {
			service.deleteDept(Integer.parseInt(deptId));
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}
