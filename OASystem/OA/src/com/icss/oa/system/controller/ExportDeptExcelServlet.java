package com.icss.oa.system.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.system.service.DepartmentService;

/**
 * 导出excel报表
 */
@WebServlet("/ExportDeptExcelServlet")
public class ExportDeptExcelServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		设置报头，通知浏览器以附件形式接收数据
		response.setHeader("content-disposition", "attachment;filename=department.xls");
				
//		响应输出流
		OutputStream out = response.getOutputStream();
		
		DepartmentService service = new DepartmentService();
		
		try {
			service.exportExcel(out);
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
	}

}
