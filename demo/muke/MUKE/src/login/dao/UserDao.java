package login.dao;

import java.sql.SQLException;
import login.pojo.User;
 
public interface UserDao {

	public User select(String uname,String upwd) throws SQLException;

	public Boolean register(String rtel, String rname,String rpwd) throws SQLException;
	
}
