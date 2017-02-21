package test;

import java.sql.SQLException;

import org.junit.Test;

import com.icss.oa.system.dao.JobDao;
import com.icss.oa.system.pojo.Job;

public class TestJobDao {

	JobDao dao = new JobDao();
	
	@Test
	public void testInsert() throws SQLException {
		
		Job job = new Job("司机","开车");
		
		dao.insert(job);
		
	}
	
}