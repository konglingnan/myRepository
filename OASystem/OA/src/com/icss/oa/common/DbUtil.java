package com.icss.oa.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * 数据库工具类
 * 
 * @author Administrator
 * 
 */
public class DbUtil {

	// 创建本地线程类对象
	private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	/**
	 * 返回数据库连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		// 1 从本地线程中获得连接
		Connection conn = threadLocal.get();

		// 2 在为空或关闭时创建连接
		try {
			if (conn == null || conn.isClosed()) {
				// 创建连接
				DriverManager.registerDriver(new OracleDriver());

				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "scott";
				String password = "tiger";

				conn = DriverManager.getConnection(url, user, password);

				// 将连接与本地线程绑定
				threadLocal.set(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * 关闭连接
	 */
	public static void close() {
		
		// 从本地线程中获得连接
		Connection conn = threadLocal.get();
		
		try {
			// 在连接不为空 且 没关闭时
			if (conn != null && !conn.isClosed()) {
				// 解除绑定
				threadLocal.set(null);
				// 关闭连接
				conn.close();
				
				//打印测试语句
				System.out.println("关闭数据库连接：" + conn);
				System.out.println("-----------------------------------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}