package login.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DbUtil;
import login.dao.UserDao;
import login.pojo.User;
 
public class UserDaoImpl implements UserDao {

//	登录查找
	@Override
	public User select(String uname,String upwd) throws SQLException{
		
		Connection conn = DbUtil.getConnection();
		
		StringBuffer sb = new StringBuffer();		
		sb.append("SELECT * ");
		sb.append("FROM user where user_id = ? and user_password = ? ");
		
		PreparedStatement pstm=conn.prepareStatement(sb.toString());
		pstm.setString(1,uname);
		pstm.setString(2,upwd);
		ResultSet rs=pstm.executeQuery();
		User user=null;
//		ArrayList<User> list=new ArrayList<User>();
		if(rs.next()){
			user=new User();
			user.setUser_id(rs.getInt(1));
			user.setUser_name(rs.getString(2));
			user.setUser_password(rs.getString(3));
			user.setUser_email(rs.getString(4));
//			list.add(user);
		}
		return user;
	}
	
//	注册
	@Override
	public Boolean register(String rtel, String rname,String rpwd) throws SQLException{
		
		Connection conn = DbUtil.getConnection();
		
		StringBuffer sb = new StringBuffer();		
		sb.append("SELECT * ");
		sb.append("FROM user where user_id = ?");
		
		PreparedStatement pstm=conn.prepareStatement(sb.toString());
		pstm.setString(1,rtel);
		ResultSet rs=pstm.executeQuery();
		Boolean result = null;
		
		if(rs.next()){
			result = false;
		}else {
			sb = new StringBuffer();		
			sb.append("insert into user ");
			sb.append("values(?,?,?,?)");
			
			pstm=conn.prepareStatement(sb.toString());
			System.out.println(sb.toString());
			pstm.setString(1,rtel);
			pstm.setString(2,rname);
			pstm.setString(3,rpwd);
			pstm.setString(4,"");
			pstm.executeUpdate();
			result = true;
		}
		return result;
	}
}
