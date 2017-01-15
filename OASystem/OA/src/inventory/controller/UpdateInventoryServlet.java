package inventory.controller;

import inventory.pojo.Inventory;
import inventory.service.InventoryService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateInventoryServlet
 */
@WebServlet("/UpdateInventoryServlet")
public class UpdateInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
		String inventoryId = request.getParameter("inventoryId");
		System.out.println(inventoryId);
		String inventoryName = request.getParameter("inventoryName");
		System.out.println(inventoryName);
		String inventoryNum = request.getParameter("inventoryNum");
		System.out.println(inventoryNum);
		String inventoryPrice = request.getParameter("inventoryPrice");
		System.out.println(inventoryPrice);
		String inventorytypeId = request.getParameter("inventorytypeId");
		System.out.println(inventorytypeId);
				
//		封装数据
		 Inventory inventory = new Inventory(Integer.parseInt(inventoryId),inventoryName,Integer.parseInt(inventoryNum),Float.parseFloat(inventoryPrice),Integer.parseInt(inventorytypeId));
		
		
//		创建业务对象
		InventoryService service = new InventoryService();
		
		try {
			service.updateInventory(inventory);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		成功提示
		out.print("物品信息修改成功！");
		
	}
		// TODO Auto-generated method stub

}
