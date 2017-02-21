package com.icss.oa.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.system.pojo.Department;
import com.icss.oa.system.pojo.Employee;
import com.icss.oa.system.pojo.Job;
import com.icss.oa.system.service.EmployeeService;

/**
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/UpdateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();

//		����������
		String empIdStr = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String empSex = request.getParameter("empSex");
		String empBirth = request.getParameter("empBirth");
		String empPasswd = request.getParameter("empPasswd");
		String deptId = request.getParameter("deptId");
		String jobId = request.getParameter("jobId");
		
//		��װ����
//		��װΪpojo����
		Department dept = new Department();
		dept.setDeptId(Integer.parseInt(deptId));
		
		Job job = new Job();
		job.setJobId(Integer.parseInt(jobId));
		
		int empId = Integer.parseInt(empIdStr);
		
		Employee emp = new Employee(empId, empName,empSex,Date.valueOf(empBirth),empPasswd, dept,job);
		
//		����ҵ�����
		EmployeeService service = new EmployeeService();
		
		try {
			service.updateEmp(emp);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}

//		�ɹ���ʾ
		out.print(" Ա���޸ĳɹ���");
		
	}

}
