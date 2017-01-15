package com.icss.oa.system.service;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.DepartmentDao;
import com.icss.oa.system.pojo.Department;

/**
 * 部门业务
 * @author Administrator
 *
 */
public class DepartmentService {
	
	private DepartmentDao dao = new DepartmentDao();
	
	/**
	 * 增加部门
	 * @throws SQLException 
	 */
	public void addDept(Department dept) throws SQLException {
		dao.insert(dept);
	}
	
	/**
	 * 修改部门
	 */
	public void updateDept(Department dept) throws SQLException {
		dao.update(dept);
	}
	
	/**
	 * 删除部门
	 */
	public void deleteDept(int deptId) throws SQLException {
		dao.delete(deptId);
	}
	
	/**
	 * 查询单独的部门
	 */
	public Department queryDeptById(int deptId) throws SQLException {
		
		return dao.queryById(deptId);
	}

	/**
	 * 查询所有部门////////////分页
	 * @throws SQLException 
	 */
	public ArrayList<Department> queryAllDept(Pager pager) throws SQLException {

		return dao.queryAll(pager);
	}

	/**
	 * 查询所有部门
	 * @throws SQLException 
	 */
	public ArrayList<Department> queryAllDept() throws SQLException {

		return dao.queryAll();
	}
	
	public int getDeptCount() throws SQLException{
		
		return dao.getDeptCount();
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
		HSSFSheet sheet1 = wb.createSheet("部门数据");
		
//		默认列宽
		sheet1.setDefaultColumnWidth(15);
		
//		标题行
		String[] titles = {"部门编号","部门名称","部门描述"};
		
//		行对象
		HSSFRow titleRow = sheet1.createRow(0);
		
		for (int i = 0;i < titles.length;i ++) {
			titleRow.createCell(i).setCellValue(titles[i]);
		}
		
//		数据行
		ArrayList<Department> list = dao.queryAll();
		
		for (int i = 0;i < list.size();i ++) {
			HSSFRow row =  sheet1.createRow(i + 1);
			row.createCell(0).setCellValue(list.get(i).getDeptId());
			row.createCell(1).setCellValue(list.get(i).getDeptName());
			row.createCell(2).setCellValue(list.get(i).getDeptDesc());
		}
		
		wb.write(os);
		os.close();
	}

}