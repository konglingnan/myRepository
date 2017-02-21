package test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.icss.oa.system.dao.DepartmentDao;
import com.icss.oa.system.pojo.Department;

/**
 * 测试DAO类
 * @author Administrator
 *
 */
public class TestDepartmentDao {

	DepartmentDao dao = new DepartmentDao();
		
	
/*	
	@Test
	public void testInsert() throws SQLException {
		
		Department dept = new Department("财务部","管理财务");		
		dao.insert(dept);		
	}
	
	@Test
	public void testDelete() throws SQLException {
		
		dao.delete(8);
		
	}
	
	@Test
	public void testUpdate() throws SQLException {
		
		Department dept = new Department(18,"车队","客户接送");
		
		dao.update(dept);
		
	}
	
	@Test
	public void testQueryById() throws SQLException {
		
		Department dept = dao.queryById(23333);
		System.out.println(dept);
		
	}
		
*/
	
	@Test
	public void testQueryAll() throws SQLException {
		
		ArrayList<Department> list = dao.queryAll();
		
		for (Department dept : list) {
			System.out.println(dept);
		}
		
	}

	
}