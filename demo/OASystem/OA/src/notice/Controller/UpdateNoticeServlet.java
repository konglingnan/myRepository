package notice.Controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.Pojo.Notice;
import notice.Service.NoticeService;

/**
 * Servlet implementation class UpdateDeptServlet
 */
@WebServlet("/UpdateNoticeServlet")
public class UpdateNoticeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
		//String notice_id = request.getParameter("notice_id");
		
		String notice_id=request.getParameter("notice_id");
		//int notice_id=Integer.valueOf(id);
        //int notice_id=Integer.parseInt(id);
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String s=request.getParameter("notice_time");
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String time=request.getParameter("notice_time");
		s=sd.format(Calendar.getInstance().getTime());
		Date notice_time=Date.valueOf(s);
		
		
		System.out.print(notice_id+title+content+notice_time);	
		//		封装数据
		
		Notice notice = new Notice(Integer.parseInt(notice_id),title,content,notice_time);
		//Notice notice = new Notice(notice_id,title,content,notice_time);
		
		
		
//		创建业务对象
		NoticeService service = new NoticeService();
		
		try {
			service.updateNotice(notice);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		成功提示
		out.print("部门修改成功！");
		
	}

}

