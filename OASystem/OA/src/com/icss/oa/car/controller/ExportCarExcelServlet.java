package com.icss.oa.car.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.car.service.CarService;

@WebServlet("/ExportCarExcelServlet")
public class ExportCarExcelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ�ͷ��֪ͨ������Ը�����ʽ��������
		response.setHeader("content-disposition", "attachment;filename=car.xls");

//		��Ӧ�����
		OutputStream out = response.getOutputStream();
		
		CarService service = new CarService();
		
		try {
			service.exportExcel(out);
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
	}

}
