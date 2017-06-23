package community.service;

import java.sql.SQLException;

import community.dao.QuestionDao;
import community.daoimpl.QuestionDaoImpl;

public class QuestionService {
	private QuestionDao dao = new QuestionDaoImpl();
	
	public void addQuestion(String question_user, String question_title, String question_time) throws SQLException{
		dao.addQuestion(question_user, question_title, question_time);
	}

}
