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
 * ����excel����
 */
@WebServlet("/ExportInventorytypeExcelServlet")
public class ExportInventorytypeExcelServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ�ͷ��֪ͨ������Ը�����ʽ��������
		response.setHeader("content-disposition", "attachment;filename=inventorytype.xls");
				
//		��Ӧ�����
		OutputStream out = response.getOutputStream();
		
//		ҵ�����
		InventorytypeService service = new InventorytypeService();
		
		try {
//			��������
			service.exportExcel(out);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

}
