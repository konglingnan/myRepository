package com.icss.oa.car.service;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.icss.oa.car.dao.DistributeCarDao;
import com.icss.oa.car.pojo.DistributeCar;
import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Department;
import com.icss.oa.system.pojo.Employee;

public class DistributeCarService {

	private DistributeCarDao dao = new DistributeCarDao();
	
	/**
	 * ����Ա��
	 * @param emp
	 * @throws SQLException 
	 */
	public void addDis(DistributeCar distributeCar) throws SQLException {
		
		dao.insert(distributeCar);
		
	}

	public void updateDis(DistributeCar distributeCar) throws SQLException {
		
		dao.update(distributeCar);
		
	}

	public void deleteDis(int distributeCarId) throws SQLException {
		
		dao.delete(distributeCarId);
		
	}

	public DistributeCar queryDisById(int distributeCarId) throws SQLException {
		
		return dao.queryById(distributeCarId);
		
	}
	
	public int getDisCount() throws SQLException{
		
		return dao.getDisCount();
	}

	/**
	 * ��ѯ��������
	 * @throws SQLException 
	 */
	public ArrayList<DistributeCar> queryAllDis(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
		
	}
	

	/**
	 * ��ѯ����δ��
	 * @throws SQLException 
	 */
	public ArrayList<DistributeCar> queryAllDising(Pager pager) throws SQLException {
		
		return dao.queryAllDising(pager);
		
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
		HSSFSheet sheet1 = wb.createSheet("�ɷ���������");
		
//		Ĭ���п�
		sheet1.setDefaultColumnWidth(15);
		
//		������
		String[] titles = {"�ɳ����","·��","��ʼʱ��","����ʱ��","״̬","�ó�Ա��","�ɷ��ó�"};
		
//		�ж���
		HSSFRow titleRow = sheet1.createRow(0);
		
		for (int i = 0;i < titles.length;i ++) {
			titleRow.createCell(i).setCellValue(titles[i]);
		}
		
//		������
		ArrayList<DistributeCar> list = dao.queryAll();
		
		for (int i = 0;i < list.size();i ++) {
			HSSFRow row =  sheet1.createRow(i + 1);
			row.createCell(0).setCellValue(list.get(i).getdistributeCarId());
			row.createCell(1).setCellValue(list.get(i).getRoute());
			row.createCell(2).setCellValue(list.get(i).getStartDate());
			row.createCell(3).setCellValue(list.get(i).getEndDate());
			row.createCell(4).setCellValue(list.get(i).getState());
			row.createCell(5).setCellValue(list.get(i).getEmployee().getEmpName());
			row.createCell(6).setCellValue(list.get(i).getCar().getCarType());
		}
		
		wb.write(os);
		os.close();
	}

}