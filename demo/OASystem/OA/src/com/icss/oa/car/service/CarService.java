package com.icss.oa.car.service;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.icss.oa.car.dao.CarDao;
import com.icss.oa.car.pojo.Car;
import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Department;

/**
 * 车辆业务
 * @author Administrator
 *
 */
public class CarService {
	
	private CarDao dao = new CarDao();
	
	/**
	 * 增加车辆
	 * @throws SQLException 
	 */
	public void addCar(Car car) throws SQLException {
		dao.insert(car);
	}
	
	/**
	 * 修改车辆
	 */
	public void updateCar(Car car) throws SQLException {
		dao.update(car);
	}
	
	/**
	 * 删除车辆 
	 */
	public void deleteCar(int carId) throws SQLException {
		dao.delete(carId);
	}

	/**
	 * 查询单独车辆 
	 */
	public Car queryCarById(int carId) throws SQLException {
		
		return dao.queryById(carId);
	}

	/**
	 * 查询单独车辆 
	 */
	public Car queryTCarById(int carId) throws SQLException {
		
		return dao.queryTById(carId);
	}
	
	/**
	 * 查询所有车辆 
	 * @throws SQLException 
	 */
	public ArrayList<Car> queryAll() throws SQLException {
		
		return dao.queryAll();
	}

	/**
	 * 查询所有车辆
	 * @throws SQLException 
	 */
	public ArrayList<Car> queryAll(Pager pager) throws SQLException {

		return dao.queryAll(pager);
	}

	public int getCarCount() throws SQLException{
		
		return dao.getCarCount();
	}

	/**
	 * 根据汽车照片id查询汽车图片数据
	 * @throws SQLException 
	 */
	public Car queryPic(int carId) throws SQLException {
		
		return dao.queryById(carId);

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
		HSSFSheet sheet1 = wb.createSheet("车辆数据");
		
//		默认列宽
		sheet1.setDefaultColumnWidth(15);
		
//		标题行
		String[] titles = {"车辆编号","车辆类型","车牌号"};
		
//		行对象
		HSSFRow titleRow = sheet1.createRow(0);
		
		for (int i = 0;i < titles.length;i ++) {
			titleRow.createCell(i).setCellValue(titles[i]);
		}
		
//		数据行
		ArrayList<Car> list = dao.excelQueryAll();
		
		for (int i = 0;i < list.size();i ++) {
			HSSFRow row =  sheet1.createRow(i + 1);
			row.createCell(0).setCellValue(list.get(i).getCarId());
			row.createCell(1).setCellValue(list.get(i).getCarType());
			row.createCell(2).setCellValue(list.get(i).getCarTag());
		}
		
		wb.write(os);
		os.close();
	}

}