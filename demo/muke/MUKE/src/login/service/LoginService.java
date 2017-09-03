package login.service;

import java.sql.SQLException;

import login.dao.UserDao;
import login.daoimpl.UserDaoImpl;
import login.pojo.User;

public class LoginService {
	private UserDao dao = new UserDaoImpl();
	
	public User select(String uname,String upwd) throws SQLException{
		return dao.select(uname,upwd); 
	}
}
