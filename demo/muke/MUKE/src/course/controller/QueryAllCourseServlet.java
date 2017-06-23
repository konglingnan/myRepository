package course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import course.pojo.Course;
import course.service.CourseService;

@WebServlet("/queryCourse.action") public class QueryAllCourseServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String direction = request.getParameter("course_direction");
		String classification = request.getParameter("course_classification");
		String rank = request.getParameter("course_rank");
		
		if("".equals(direction.trim())){
			direction=null;
		}
		
		if("".equals(classification.trim())){
			classification=null;
		}
		
		if("".equals(rank.trim())){
			rank=null;
		}
		
		CourseService service = new CourseService();
		try{
			ArrayList<Course> list = service.queryAll(direction, classification, rank);
//			for (Course course : list) {
//				System.out.println(course); 
//			}
			Gson gson=new Gson();
			out.write(gson.toJson(list));
			
			/*Gson gson=new Gson();
			out.write(gson.toJson(list));*/
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
