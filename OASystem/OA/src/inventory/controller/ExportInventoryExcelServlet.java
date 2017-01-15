package inventory.controller;

import inventory.service.InventoryService;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 导出excel报表
 */
@WebServlet("/ExportInventoryExcelServlet")
public class ExportInventoryExcelServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		设置报头，通知浏览器以附件形式接收数据
		response.setHeader("content-disposition", "attachment;filename=inventory.xls");
				
//		响应输出流
		OutputStream out = response.getOutputStream();
		
//		业务对象
		InventoryService service = new InventoryService();
		
		try {
//			导出报表
			service.exportExcel(out);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

}
