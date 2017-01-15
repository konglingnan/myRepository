package notice.Controller;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.Service.NoticeService;

/**
 * 删除部门数据访问接口
 */
@WebServlet("/DelNoticeServlet")
public class DelNoticeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String notice_id = request.getParameter("notice_id");
		
		NoticeService service = new NoticeService();
		
		try {
			service.deleteNotice(Integer.parseInt(notice_id));
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}

