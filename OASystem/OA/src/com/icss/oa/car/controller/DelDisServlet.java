package com.icss.oa.car.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.car.service.DistributeCarService;


@WebServlet("/DelDisServlet")
public class DelDisServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String distributeCarId = request.getParameter("distributeCarId");
		
		DistributeCarService service = new DistributeCarService();
		
		try {
			service.deleteDis(Integer.parseInt(distributeCarId));
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}
