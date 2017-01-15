package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class TestInsert {

	public static void main(String[] args) throws SQLException, IOException {
		
		DriverManager.registerDriver(new OracleDriver());
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		String sql = "insert into car_picture values (?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, 35);
		pstmt.setString(2,"汽车后屁股");
		
//		获得图片的二进制数据
		File file = new File("e:\\3.jpg");
		long length = file.length();
		FileInputStream fis = new FileInputStream(file);		
		pstmt.setBinaryStream(3, fis, length);
		
		pstmt.setInt(4, 23);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();		
		fis.close();
	}

}
