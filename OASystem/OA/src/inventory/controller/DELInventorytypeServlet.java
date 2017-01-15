package inventory.controller;

import inventory.service.InventorytypeService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DELInventorytypeServlet
 */
@WebServlet("/DELInventorytypeServlet")
public class DELInventorytypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DELInventorytypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String inventorytypeId = request.getParameter("inventorytypeId");
		
		InventorytypeService service = new InventorytypeService();
		
		try {
			service.deleteInventorytype(Integer.parseInt(inventorytypeId));
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
		// TODO Auto-generated method stub

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
