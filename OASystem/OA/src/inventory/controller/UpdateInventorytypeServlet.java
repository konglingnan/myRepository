package inventory.controller;

import inventory.pojo.Inventorytype;
import inventory.service.InventorytypeService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateInventorytypeServlet
 */
@WebServlet("/UpdateInventorytypeServlet")
public class UpdateInventorytypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInventorytypeServlet() {
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
	//			设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
		String inventorytypeId = request.getParameter("inventorytypeId");
		String inventorytypeName = request.getParameter("inventorytypeName");
		
//		封装数据
		Inventorytype inventorytype = new Inventorytype(Integer.parseInt(inventorytypeId),inventorytypeName);
		
		
//		创建业务对象
		InventorytypeService service = new InventorytypeService();
		
		try {
			service.updateInventorytype(inventorytype);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		成功提示
		out.print("物品信息修改成功！");
		
	}
		// TODO Auto-generated method stub

}
