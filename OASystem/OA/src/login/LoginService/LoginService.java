package login.LoginService;

import java.sql.SQLException;

import login.LoginDao.LoginDao;

import com.icss.oa.system.pojo.Employee;

/**
 * �����½ҵ��
 * @author Administrator
 *
 */
public class LoginService {
	/**
	 * 
	 * @param Login ��Ҫ��֤�ĵ�½����
	 * @return -1�˺Ż��������   0����Ա��¼   ��1��+8����ͨ�û�id
	 * @throws SQLException
	 */

	private LoginDao dao = new LoginDao();
	
	
	public int checkLogin(Employee login) throws SQLException {
		
		return dao.queryByempId(login);
		
	}

}



