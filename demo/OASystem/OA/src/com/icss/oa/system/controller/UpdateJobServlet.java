package com.icss.oa.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.system.pojo.Job;
import com.icss.oa.system.service.JobService;

/**
 * Servlet implementation class UpdateJobServlet
 */
@WebServlet("/UpdateJobServlet")
public class UpdateJobServlet extends HttpServlet {
	
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
		String jobId = request.getParameter("jobId");
		String jobName = request.getParameter("jobName");
		String jobDesc = request.getParameter("jobDesc");
		String jobTel = request.getParameter("jobTel");
		
//		��װ����
		Job job = new Job(Integer.parseInt(jobId),jobName,jobDesc);
		
		
//		����ҵ�����
		JobService service = new JobService();
		
		try {
			service.updateJob(job);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("�����޸ĳɹ���");
		
	}

}

