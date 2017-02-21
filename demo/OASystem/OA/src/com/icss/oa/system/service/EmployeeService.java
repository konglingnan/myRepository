package com.icss.oa.system.service;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.EmployeeDao;
import com.icss.oa.system.pojo.Department;
import com.icss.oa.system.pojo.Employee;

/**
 * 员工业务
 * @author Administrator
 *
 */
public class EmployeeService {
	
	private EmployeeDao dao = new EmployeeDao();
	
	/**
	 * 增加员工
	 * @param emp
	 * @throws SQLException 
	 */
	
	public void addEmp(Employee emp) throws SQLException {
		
		dao.insert(emp);
		
	}

	public void updateEmp(Employee emp) throws SQLException {
		
		dao.update(emp);
		
	}

	public void deleteEmp(int empId) throws SQLException {
		
		dao.delete(empId);
		
	}

	public Employee queryEmpById(int empId) throws SQLException {
		
		return dao.queryById(empId);
		
	}
	public int getEmpCount() throws SQLException{
		
		return dao.getEmpCount();
	}

	/**
	 * 查询所有
	 * @throws SQLException 
	 */
	public ArrayList<Employee> queryAllEmp(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
		
	}

	/**
	 * 查询所有
	 * @throws SQLException 
	 */
	public ArrayList<Employee> queryAllEmp() throws SQLException {
		
		return dao.queryAll();
		
	}

	/**
	 * 导出excel报表
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void exportExcel(OutputStream os) throws SQLException, IOException {
		
//		工作簿对象
		HSSFWorkbook wb = new HSSFWorkbook();
		
//		工作表对象
		HSSFSheet sheet1 = wb.createSheet("员工数据");
		
//		默认列宽
		sheet1.setDefaultColumnWidth(15);
		
//		标题行
		String[] titles = {"员工编号","员工姓名","性别","出生日期","职务","部门"};
		
//		行对象
		HSSFRow titleRow = sheet1.createRow(0);
		
		for (int i = 0;i < titles.length;i ++) {
			titleRow.createCell(i).setCellValue(titles[i]);
		}
		
//		数据行
		ArrayList<Employee> list = dao.query();
		
		for (int i = 0; i < list.size(); i ++) {
			HSSFRow row =  sheet1.createRow(i + 1);
			row.createCell(0).setCellValue(list.get(i).getEmpId());
			row.createCell(1).setCellValue(list.get(i).getEmpName());
			row.createCell(2).setCellValue(list.get(i).getEmpSex());
			row.createCell(3).setCellValue(list.get(i).getEmpBirth());
			row.createCell(5).setCellValue(list.get(i).getDept().getDeptName());
			row.createCell(4).setCellValue(list.get(i).getJob().getJobName());

		}
		wb.write(os);
		os.close();
	}
}