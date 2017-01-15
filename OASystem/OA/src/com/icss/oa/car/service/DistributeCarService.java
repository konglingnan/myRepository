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
	 * 增加员工
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
	 * 查询所有已派
	 * @throws SQLException 
	 */
	public ArrayList<DistributeCar> queryAllDis(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
		
	}
	

	/**
	 * 查询所有未派
	 * @throws SQLException 
	 */
	public ArrayList<DistributeCar> queryAllDising(Pager pager) throws SQLException {
		
		return dao.queryAllDising(pager);
		
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
		HSSFSheet sheet1 = wb.createSheet("派发车辆数据");
		
//		默认列宽
		sheet1.setDefaultColumnWidth(15);
		
//		标题行
		String[] titles = {"派车编号","路线","开始时间","结束时间","状态","用车员工","派发用车"};
		
//		行对象
		HSSFRow titleRow = sheet1.createRow(0);
		
		for (int i = 0;i < titles.length;i ++) {
			titleRow.createCell(i).setCellValue(titles[i]);
		}
		
//		数据行
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