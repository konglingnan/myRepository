package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import com.icss.oa.system.service.EmployeeService;

public class TestEmployeeService {
	
	private EmployeeService service = new EmployeeService();
	
	@Test
	public void testExportExcel() throws SQLException, IOException{
		
		FileOutputStream fos = new FileOutputStream("e:\\data.xls");
		
		service.exportExcel(fos);
	}
}
