package community.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import community.pojo.Question;

public interface QuestionDao {

	public void addQuestion(String question_user, String question_title, String question_time) throws SQLException;

	public ArrayList<Question> queryQuestion(int question_id, String question_user, String question_title, String question_time,
			String question_label, String question_num, String question_new) throws SQLException;
}
