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
 * Servlet implementation class ADDInventoryServlet
 */
@WebServlet("/ADDInventoryServlet")
public class ADDInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADDInventoryServlet() {
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
		//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		 
//		�����
		PrintWriter out = response.getWriter();
		
//		����������
		String inventoryId = request.getParameter("inventoryId");
		System.out.println(inventoryId);
		String  inventoryName = request.getParameter("inventoryName");
		System.out.println(inventoryName);
		String inventoryNum = request.getParameter("inventoryNum");
		System.out.println(inventoryNum);
		String  inventoryPrice = request.getParameter("inventoryPrice");
		System.out.println(inventoryPrice);
		String inventorytypeId = request.getParameter("inventorytypeId");
		System.out.println(inventorytypeId);
				
//		��װ����
		 Inventory inventory = new Inventory(Integer.parseInt(inventoryId),inventoryName,Integer.parseInt(inventoryNum),Float.parseFloat(inventoryPrice),Integer.parseInt(inventorytypeId));
		
//		����ҵ�����
		 InventoryService service = new InventoryService();
		
		try {
			/*Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			
			out.print(gson.toJson(service.addInventory(inventory)));*/
			service.addInventory(inventory);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}

//		�ɹ���ʾ
		out.print("��Ʒ���ӳɹ���");
		
	}
		// TODO Auto-generated method stub
	}


