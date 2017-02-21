package login.LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginService.LoginService;

import com.icss.oa.system.pojo.Employee;
/**
 * ��½��֤���ݽӿ�
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
//		����˺ź�����
		String emp_id = request.getParameter("employee_id");
		String passwd = request.getParameter("passwd");
		int employee_id = Integer.parseInt(emp_id);
		
		System.out.println("employee_id=" + employee_id);
		System.out.println("passwd=" + passwd);
		
//		��װΪ����
		Employee login = new Employee(employee_id,null,null,null,passwd,null,null);
		
		
//		����ҵ�����
		LoginService service = new LoginService();
		
		try {
			int result = service.checkLogin(login);
			
//			�����½�ɹ����ڻỰ�м�¼
			if (!(result == -1)) {
				HttpSession session = request.getSession();
				session.setAttribute("employee_id", employee_id);
			}

			out.print(result);	
			System.out.print(result);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}



