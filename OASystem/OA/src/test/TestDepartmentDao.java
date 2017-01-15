package test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.icss.oa.system.dao.DepartmentDao;
import com.icss.oa.system.pojo.Department;

/**
 * ����DAO��
 * @author Administrator
 *
 */
public class TestDepartmentDao {

	DepartmentDao dao = new DepartmentDao();
		
	
/*	
	@Test
	public void testInsert() throws SQLException {
		
		Department dept = new Department("����","�������");		
		dao.insert(dept);		
	}
	
	@Test
	public void testDelete() throws SQLException {
		
		dao.delete(8);
		
	}
	
	@Test
	public void testUpdate() throws SQLException {
		
		Department dept = new Department(18,"����","�ͻ�����");
		
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