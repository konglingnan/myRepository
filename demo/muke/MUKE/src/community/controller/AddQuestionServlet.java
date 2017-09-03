package community.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.service.QuestionService;

@WebServlet("/addQuestion.action") public class AddQuestionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");

		String question_user = request.getParameter("question_user");
		String question_title = request.getParameter("question_title");
		String question_time = request.getParameter("question_time");
		
		QuestionService service = new QuestionService();
		try {
			service.addQuestion(question_user, question_title, question_time);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
