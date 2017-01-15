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
 * ����ҵ��
 * @author Administrator
 *
 */
public class CarService {
	
	private CarDao dao = new CarDao();
	
	/**
	 * ���ӳ���
	 * @throws SQLException 
	 */
	public void addCar(Car car) throws SQLException {
		dao.insert(car);
	}
	
	/**
	 * �޸ĳ���
	 */
	public void updateCar(Car car) throws SQLException {
		dao.update(car);
	}
	
	/**
	 * ɾ������ 
	 */
	public void deleteCar(int carId) throws SQLException {
		dao.delete(carId);
	}

	/**
	 * ��ѯ�������� 
	 */
	public Car queryCarById(int carId) throws SQLException {
		
		return dao.queryById(carId);
	}

	/**
	 * ��ѯ�������� 
	 */
	public Car queryTCarById(int carId) throws SQLException {
		
		return dao.queryTById(carId);
	}
	
	/**
	 * ��ѯ���г��� 
	 * @throws SQLException 
	 */
	public ArrayList<Car> queryAll() throws SQLException {
		
		return dao.queryAll();
	}

	/**
	 * ��ѯ���г���
	 * @throws SQLException 
	 */
	public ArrayList<Car> queryAll(Pager pager) throws SQLException {

		return dao.queryAll(pager);
	}

	public int getCarCount() throws SQLException{
		
		return dao.getCarCount();
	}

	/**
	 * ����������Ƭid��ѯ����ͼƬ����
	 * @throws SQLException 
	 */
	public Car queryPic(int carId) throws SQLException {
		
		return dao.queryById(carId);

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
		String[] titles = {"�������","��������","���ƺ�"};
		
//		�ж���
		HSSFRow titleRow = sheet1.createRow(0);
		
		for (int i = 0;i < titles.length;i ++) {
			titleRow.createCell(i).setCellValue(titles[i]);
		}
		
//		������
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