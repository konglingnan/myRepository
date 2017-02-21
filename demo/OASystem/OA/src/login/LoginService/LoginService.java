package login.LoginService;

import java.sql.SQLException;

import login.LoginDao.LoginDao;

import com.icss.oa.system.pojo.Employee;

/**
 * 管理登陆业务
 * @author Administrator
 *
 */
public class LoginService {
	/**
	 * 
	 * @param Login 需要验证的登陆数据
	 * @return -1账号或密码错误   0管理员登录   【1，+8）普通用户id
	 * @throws SQLException
	 */

	private LoginDao dao = new LoginDao();
	
	
	public int checkLogin(Employee login) throws SQLException {
		
		return dao.queryByempId(login);
		
	}

}



