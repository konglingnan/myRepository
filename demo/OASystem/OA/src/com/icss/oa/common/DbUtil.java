package com.icss.oa.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * ���ݿ⹤����
 * 
 * @author Administrator
 * 
 */
public class DbUtil {

	// ���������߳������
	private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	/**
	 * �������ݿ�����
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		// 1 �ӱ����߳��л������
		Connection conn = threadLocal.get();

		// 2 ��Ϊ�ջ�ر�ʱ��������
		try {
			if (conn == null || conn.isClosed()) {
				// ��������
				DriverManager.registerDriver(new OracleDriver());

				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "scott";
				String password = "tiger";

				conn = DriverManager.getConnection(url, user, password);

				// �������뱾���̰߳�
				threadLocal.set(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * �ر�����
	 */
	public static void close() {
		
		// �ӱ����߳��л������
		Connection conn = threadLocal.get();
		
		try {
			// �����Ӳ�Ϊ�� �� û�ر�ʱ
			if (conn != null && !conn.isClosed()) {
				// �����
				threadLocal.set(null);
				// �ر�����
				conn.close();
				
				//��ӡ�������
				System.out.println("�ر����ݿ����ӣ�" + conn);
				System.out.println("-----------------------------------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}