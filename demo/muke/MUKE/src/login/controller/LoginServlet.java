package login.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.StringUtil;
import login.pojo.User;
import login.service.LoginService;

@WebServlet("/login.action") public class LoginServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		System.out.println("uname  "+  uname);
		System.out.println("upwd  "+upwd);
		LoginService service = new LoginService();
		try {
			User user = service.select(uname,upwd);
			System.out.println("user:  "+user);
			
			PrintWriter out = response.getWriter();
			//查询全部
			if(user!=null){
//				ajax
				out.write(user.getUser_name());
			}else{
				System.out.println("登录失败");
				out.write("");
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}