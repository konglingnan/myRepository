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
 * ���ӳ������ݷ��ʽӿ�
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
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// ���Servlet�����Ķ���
		ServletContext context = this.getServletContext();

		// �����ļ��б�������
		DiskFileItemFactory fact = new DiskFileItemFactory();

		// Servlet�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(fact);

		try {
			// ��������ϴ��ļ���СΪ2M��������С�ᷢ���쳣
			upload.setSizeMax(1024 * 1024 * 2);
			
			// ��������ϴ��ļ����󼯺�
			List<FileItem> list = upload.parseRequest( request);
			
//			��ñ�����
			String carId = list.get(0).getString(); //����id
			
			String carType = list.get(0).getString(); //��������
			carType = new String(carType.getBytes("iso-8859-1"),"utf-8"); //ת��Ϊutf-8����		
			
			String carTag = list.get(1).getString(); //���ƺ�	
			carTag = new String(carTag.getBytes("iso-8859-1"),"utf-8"); //ת��Ϊutf-8����	
			
			FileItem carPic = list.get(2);//����ͼƬ����
			InputStream fis = carPic.getInputStream();

			System.out.println(carType);
			System.out.println(carTag);
			System.out.println(fis);
			
//			��װ����
			Car car = new Car(carType, carTag, fis);
			
//			����ҵ�����
			CarService service = new CarService();
			
			try {
				service.addCar(car);
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			
//			�ɹ���ʾ
			System.out.print("�������ӳɹ���");
			
			fis.close();

//			ɾ����ʱ�����ļ�
			carPic.delete();
			response.sendRedirect("QueryCar.html");
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
