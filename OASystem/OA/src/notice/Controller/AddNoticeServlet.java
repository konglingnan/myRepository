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
 * ���Ӳ������ݷ��ʽӿ�
 * @author Administrator
 *
 */
@WebServlet("/AddNoticeServlet")
public class AddNoticeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		����������

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//String s=request.getParameter("notice_time");
		
		//Date notice_time=Date.valueOf(s);

		String s=request.getParameter("notice_time");
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String time=request.getParameter("notice_time");
		s=sd.format(Calendar.getInstance().getTime());
		Date notice_time=Date.valueOf(s);
		
		
		System.out.print(content+title+s);
//		��װ����
		//Notice notice = new Notice(title,content,Date.valueOf(notice_time));
		
		Notice notice = new Notice(title,content,notice_time);
		
		
//		����ҵ�����
		NoticeService service = new NoticeService();
		
		try {
			service.addNotice(notice);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("�������ӳɹ���");
		
	}

}
