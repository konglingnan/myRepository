package course.doimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;
import common.DbUtil;
import course.dao.CourseDao;
import course.pojo.Course;

public class CourseDaoImpl implements CourseDao {

	@Override
	public ArrayList<Course> queryAll(String direction, String classification, String rank)
			throws SQLException {
		Connection conn = (Connection) DbUtil.getConnection();
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT *");
		sb.append("From course where 1=1 ");
		
		if(direction != null){
			sb.append("and course_direction = ? ");
			if(classification != null && rank == null){
				sb.append("and course_classification = ? ");
			}else if(classification != null && rank != null ){
				sb.append("and course_classification = ? ");
				sb.append("and course_rank = ? ");
			}else if( classification == null && rank != null){
				sb.append("and course_rank = ? ");
			}
		}else{
			if(classification != null && rank == null){		
				sb.append("and course_classification = ? ");
			}else if(classification != null && rank != null ){
				sb.append("and course_classification = ? ");
				sb.append("and course_rank = ? ");
			}else if( classification == null && rank != null){
				sb.append("and course_rank = ? ");
			}
		}
		
		

		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sb.toString

());
		
		if(direction != null){
			pstmt.setString(1, direction);
			if(classification != null && rank == null){
				pstmt.setString(2, classification);
			}else if(classification != null && rank != null ){
				pstmt.setString(2, classification);
				pstmt.setString(3, rank);
			}else if( classification == null && rank != null){
				pstmt.setString(2, rank);
			}
		}else{
			if(classification != null && rank == null){
				pstmt.setString(1, classification);
			}else if(classification != null && rank != null ){
				pstmt.setString(1, classification);
				pstmt.setString(2, rank);
			}else if( classification == null && rank != null){
				pstmt.setString(1, rank);
			}
		}
		
	
		
//		sb.append("SELECT *");
//		sb.append("From course where 1=1 ");
//
//		if(direction != null){
//			sb.append("and course_direction = ? ");
//		}else if(classification != null && rank == null){
//			sb.append("and course_classification = ? ");
//		}else if(classification != null && rank != null ){
//			sb.append("and course_classification = ? ");
//			sb.append("and course_rank = ? ");
//		}else if( classification == null && rank != null){
//			sb.append("and course_rank = ? ");
//		}

//		if(direction != null){
//			sb.append("and course_direction = ? ");
//		}
//		if(classification != null){
//			sb.append("and course_classification = ? ");
//		}
//		if(rank != null){
//			sb.append("and course_rank = ? ");
//		}
//		
//		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sb.toString());
//
//		if(direction != null){
//			pstmt.setString(1, direction);
//		}else if(classification != null && rank == null){
//			pstmt.setString(1, classification);
//		}else if(classification != null && rank != null ){
//			pstmt.setString(1, classification);
//			pstmt.setString(2, rank);
//		}else if( classification == null && rank != null){
//			pstmt.setString(1, rank);
//		}
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Course> list = new ArrayList();
		
		Course c = null;
		while(rs.next()){
			c = new Course();
			c.setCourse_id(rs.getString(1));
			c.setCourse_name(rs.getString(2));
			c.setCourse_rank(rs.getString(3));
			c.setCourse_direction(rs.getString(4));
			c.setCourse_description(rs.getString(5));
			c.setCourse_classification(rs.getString(6));
			c.setCourse_studyTime(rs.getString(7));
			c.setCourse_progress(rs.getString(8));
			c.setCourse_studyNum(rs.getString(9));
			
			list.add(c);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}

}
