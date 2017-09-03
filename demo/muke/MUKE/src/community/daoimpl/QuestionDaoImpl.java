package community.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DbUtil;
import community.dao.QuestionDao;
import community.pojo.Question;

public class QuestionDaoImpl implements QuestionDao {

	@Override
	public void addQuestion(String question_user, String question_title, String question_time) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		PreparedStatement pstm=conn.prepareStatement("SELECT count(*) FROM question;");
		ResultSet rs=pstm.executeQuery();
		rs.next();
		String question_id = String.valueOf(Integer.parseInt(rs.getString(1))+1);

		StringBuffer sb = new StringBuffer();
		sb.append("insert into question ");
		sb.append("values(?,?,?,?,?,?,?)");

		if(question_user == null || question_user == "" || question_user == "null") {
			question_user = "游客";
		}
		
		pstm=conn.prepareStatement(sb.toString());
		pstm.setString(1, question_id);
		pstm.setString(2,question_user);
		pstm.setString(3,question_title);
		pstm.setString(4,question_time);
		pstm.setString(5,"");
		pstm.setString(6,"0");
		pstm.setString(7,"无");
		pstm.executeUpdate();
	}

	@Override
	public ArrayList<Question> queryQuestion(int question_id, String question_user, String question_title,
			String question_time, String question_label, String question_num, String question_new) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
