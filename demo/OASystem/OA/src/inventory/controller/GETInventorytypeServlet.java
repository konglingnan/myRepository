package inventory.controller;

import inventory.pojo.Inventorytype;
import inventory.service.InventorytypeService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class GETInventorytypeServlet
 */
@WebServlet("/GETInventorytypeServlet")
public class GETInventorytypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GETInventorytypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();

		String inventorytypeId = request.getParameter("inventorytypeId");

		InventorytypeService service = new InventorytypeService();

		try {
			Inventorytype inventorytype = service.queryInventorytypeById(Integer.parseInt(inventorytypeId));
			System.out.println(inventorytype);	
			
//			产生json格式数据
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			
			out.print(gson.toJson(inventorytype));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
