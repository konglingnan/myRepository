package login.LoginDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icss.oa.common.DbUtil;
import com.icss.oa.system.dao.EmployeeDao;
import com.icss.oa.system.pojo.Employee;
/**
 * ��¼DAO��
 * @author Administrator
 *
 */
public class LoginDao {
	/**
	 * �����û�����ѯ��������
	 * @param adminName
	 * @return
	 * @throws SQLException
	 */

	public int queryByempId(Employee login) throws SQLException {
		
		Employee e = null;
		
		int flag = 0;//��ͨ�û� 
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "select * from manager where employee_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, login.getEmpId());
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			
			flag = 1;//�����ǹ���Ա
		}
		else{
			
			flag = 0;//���ǹ���Ա 
		}

		String sql1 = "select * from employee where employee_id=?";
		
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		
		pstmt1.setInt(1, login.getEmpId());			
		ResultSet rs1 = pstmt1.executeQuery();
		
		if(rs1.next()){
			e = new Employee(rs1.getInt(1),null,null,null,rs1.getString(5),null,null);
		}
		rs1.close();
		pstmt.close();
		conn.close();
		
		EmployeeDao dao = new EmployeeDao();

		e = dao.queryById(login.getEmpId());
		
		System.out.println(e.toString());
		
		if (e == null || !e.getEmpPasswd().equals(login.getEmpPasswd())) {
			return -1;
		} else if (e.getEmpPasswd().equals(login.getEmpPasswd()) && flag == 0) { //��ͨ�û� 
			return login.getEmpId();
		} else {//����Ա�˺ŵ�½�ɹ�
			return 0;
		}
		
	}

}