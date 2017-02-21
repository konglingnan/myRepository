package com.icss.oa.system.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.system.service.JobService;

/**
 * 删除部门数据访问接口
 */
@WebServlet("/DelJobServlet")
public class DelJobServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jobId = request.getParameter("jobId");
		
		JobService service = new JobService();
		
		try {
			service.deleteJob(Integer.parseInt(jobId));
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}

