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
 * ����ҵ��
 * @author Administrator
 *
 */
public class DepartmentService {
	
	private DepartmentDao dao = new DepartmentDao();
	
	/**
	 * ���Ӳ���
	 * @throws SQLException 
	 */
	public void addDept(Department dept) throws SQLException {
		dao.insert(dept);
	}
	
	/**
	 * �޸Ĳ���
	 */
	public void updateDept(Department dept) throws SQLException {
		dao.update(dept);
	}
	
	/**
	 * ɾ������
	 */
	public void deleteDept(int deptId) throws SQLException {
		dao.delete(deptId);
	}
	
	/**
	 * ��ѯ�����Ĳ���
	 */
	public Department queryDeptById(int deptId) throws SQLException {
		
		return dao.queryById(deptId);
	}

	/**
	 * ��ѯ���в���////////////��ҳ
	 * @throws SQLException 
	 */
	public ArrayList<Department> queryAllDept(Pager pager) throws SQLException {

		return dao.queryAll(pager);
	}

	/**
	 * ��ѯ���в���
	 * @throws SQLException 
	 */
	public ArrayList<Department> queryAllDept() throws SQLException {

		return dao.queryAll();
	}
	
	public int getDeptCount() throws SQLException{
		
		return dao.getDeptCount();
	}

	/**
	 * ����excel����
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void exportExcel(OutputStream os) throws SQLException, IOException {
		
//		����������
		HSSFWorkbook wb = new HSSFWorkbook();
		
//		���������
		HSSFSheet sheet1 = wb.createSheet("��������");
		
//		Ĭ���п�
		sheet1.setDefaultColumnWidth(15);
		
//		������
		String[] titles = {"���ű��","��������","��������"};
		
//		�ж���
		HSSFRow titleRow = sheet1.createRow(0);
		
		for (int i = 0;i < titles.length;i ++) {
			titleRow.createCell(i).setCellValue(titles[i]);
		}
		
//		������
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