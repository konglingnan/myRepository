package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.EmployeeDao;
import com.icss.oa.system.pojo.Employee;
import com.icss.oa.system.service.EmployeeService;

public class TestEmployeeDao {

	EmployeeDao dao = new EmployeeDao();
	
	EmployeeService service = new EmployeeService();


	@Test
	public void testExportExcel() throws SQLException, IOException {
		
		FileOutputStream fos = new FileOutputStream("e:\\data.xls");
		
		service.exportExcel(fos);
		
	}

	@Test
	public void testQuery() throws SQLException {
		

		ArrayList<Employee> list = dao.queryAll();

		for (Employee emp : list) {
			System.out.println(emp);
		}

	}
	

	@Test
	public void testQueryAll() throws SQLException {
		
		Pager pager = new Pager(dao.getCount(),0,6);

		ArrayList<Employee> list = dao.queryAll(pager);

		for (Employee emp : list) {
			System.out.println(emp);
		}

	}
	
	

	@Test
	public void testDelete() throws SQLException {

		dao.delete(10);

	}


/*
	@Test
	public void testInsert() throws SQLException {
		
		Department dept = new Department();
		dept.setDeptId(22);
				
		Job job = new Job();
		job.setJobId(2);
				
		Employee emp = new Employee("jack","13066668888",Date.valueOf("1992-7-18"),dept,job);
		
		dao.insert(emp);		
	}
	
	@Test
	public void testInsertMany() throws SQLException {
		
		for (int i = 16;i <= 20;i ++) {
			Department dept = new Department();
			dept.setDeptId(19);
					
			Job job = new Job();
			job.setJobId(1);
					
			Employee emp = new Employee("jack" + i,"13066668888",Date.valueOf("1992-7-18"),dept,job);
			
			dao.insert(emp);	
		}
	}
	
	@Test
	public void testUpdate() throws SQLException {

		Department department = new Department();
		department.setDeptId(19);
		
		Job job = new Job();
		job.setJobId(21);
		Employee emp = new Employee(21, "aaa", "11001234568",
				Date.valueOf("1994-6-19"), department, job);

		dao.update(emp);

	}

	@Test
	public void testQueryById() throws SQLException {

		Employee emp = dao.queryById(21);
		System.out.println(emp);

	}
	
	@Test
	public void testGetCount() throws SQLException {

		int count = dao.getCount();
		System.out.println(count);

	}
*/
}
