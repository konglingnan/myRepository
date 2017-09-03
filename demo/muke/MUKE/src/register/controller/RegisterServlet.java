package register.controller;

import common.StringUtil;
import login.pojo.User;
import register.service.RegisterService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register.action") public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");

		String rtel = request.getParameter("rtel");
		String rname = request.getParameter("rname");
		String rpwd = request.getParameter("rpwd");
		System.out.println("rtel  "+rtel);
		System.out.println("rname  "+  rname);
		System.out.println("rpwd  "+rpwd);
		RegisterService service = new RegisterService();
		try {
			Boolean result = service.register(rtel,rname,rpwd);
			System.out.println("result:  "+result);
			
			PrintWriter out = response.getWriter();
//			ajax
			out.write(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
