package course.service;

import java.sql.SQLException;
import java.util.ArrayList;

import course.pojo.Course;
import course.dao.CourseDao;
import course.doimpl.CourseDaoImpl;

public class CourseService {

	private CourseDao dao = new CourseDaoImpl();
	
	public ArrayList<Course> queryAll(String direction, String classification,String rank) throws SQLException{
		
		if("全部".equals(direction)){
			direction = null;
		}
		if("全部".equals(classification)){
			classification = null;
		}
		if("全部".equals(rank)){
			rank = null;
		}
		
		return dao.queryAll(direction, classification, rank);
	}
	
}
