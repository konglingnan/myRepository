package com.icss.oa.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.system.pojo.Department;
import com.icss.oa.system.service.DepartmentService;

/**
 * Servlet implementation class UpdateDeptServlet
 */
@WebServlet("/UpdateDeptServlet")
public class UpdateDeptServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String deptDesc = request.getParameter("deptDesc");
		String deptTel = request.getParameter("deptTel");
		
//		封装数据
		Department dept = new Department(Integer.parseInt(deptId),deptName,deptDesc, deptTel);
		
		
//		创建业务对象
		DepartmentService service = new DepartmentService();
		
		try {
			service.updateDept(dept);
		} catch (SQLException e) {	
			e.printStackTrace();
			return;
		}
		
//		成功提示
		out.print("部门修改成功！");
		
	}

}
