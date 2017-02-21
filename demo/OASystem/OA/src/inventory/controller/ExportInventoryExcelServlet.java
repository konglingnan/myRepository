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
 * ����excel����
 */
@WebServlet("/ExportInventoryExcelServlet")
public class ExportInventoryExcelServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ�ͷ��֪ͨ������Ը�����ʽ��������
		response.setHeader("content-disposition", "attachment;filename=inventory.xls");
				
//		��Ӧ�����
		OutputStream out = response.getOutputStream();
		
//		ҵ�����
		InventoryService service = new InventoryService();
		
		try {
//			��������
			service.exportExcel(out);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

}
