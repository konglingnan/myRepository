package inventory.controller;

import inventory.service.InventorytypeService;

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
@WebServlet("/ExportInventorytypeExcelServlet")
public class ExportInventorytypeExcelServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		设置报头，通知浏览器以附件形式接收数据
		response.setHeader("content-disposition", "attachment;filename=inventorytype.xls");
				
//		响应输出流
		OutputStream out = response.getOutputStream();
		
//		业务对象
		InventorytypeService service = new InventorytypeService();
		
		try {
//			导出报表
			service.exportExcel(out);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

}
