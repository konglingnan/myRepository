package register.service;

import java.sql.SQLException;

import login.dao.UserDao;
import login.daoimpl.UserDaoImpl;
import login.pojo.User;

public class RegisterService {
	private UserDao dao = new UserDaoImpl();

	public Boolean register(String rtel, String rname,String rpwd) throws SQLException{
		return dao.register(rtel,rname,rpwd); 
	}

}
