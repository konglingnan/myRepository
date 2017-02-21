package com.icss.oa.car.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleDriver;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.icss.oa.car.pojo.Car;
import com.icss.oa.car.service.CarService;
import com.icss.oa.common.DbUtil;

/**
 * 增加车辆数据访问接口
 * @author Administrator
 *
 */

@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 获得Servlet上下文对象
		ServletContext context = this.getServletContext();

		// 磁盘文件列表工厂对象
		DiskFileItemFactory fact = new DiskFileItemFactory();

		// Servlet文件上传对象
		ServletFileUpload upload = new ServletFileUpload(fact);

		try {
			// 设置最大上传文件大小为2M，超出大小会发生异常
			upload.setSizeMax(1024 * 1024 * 2);
			
			// 获得所有上传文件对象集合
			List<FileItem> list = upload.parseRequest( request);
			
//			获得表单数据
			String carId = list.get(0).getString(); //汽车id
			
			String carType = list.get(0).getString(); //汽车类型
			carType = new String(carType.getBytes("iso-8859-1"),"utf-8"); //转换为utf-8编码		
			
			String carTag = list.get(1).getString(); //车牌号	
			carTag = new String(carTag.getBytes("iso-8859-1"),"utf-8"); //转换为utf-8编码	
			
			FileItem carPic = list.get(2);//汽车图片数据
			InputStream fis = carPic.getInputStream();

			System.out.println(carType);
			System.out.println(carTag);
			System.out.println(fis);
			
//			封装数据
			Car car = new Car(carType, carTag, fis);
			
//			创建业务对象
			CarService service = new CarService();
			
			try {
				service.addCar(car);
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			
//			成功提示
			System.out.print("车辆增加成功！");
			
			fis.close();

//			删除临时数据文件
			carPic.delete();
			response.sendRedirect("QueryCar.html");
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
