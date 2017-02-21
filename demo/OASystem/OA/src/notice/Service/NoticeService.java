package notice.Service;



import java.sql.SQLException;
import java.util.ArrayList;

import notice.Dao.NoticeDao;
import notice.Pojo.Notice;

import com.icss.oa.common.Pager;

/**
 * 部门业务
 * @author Administrator
 *
 */
public class  NoticeService  {
	
	private NoticeDao dao = new NoticeDao();
	
	/**
	 * 增加部门
	 * @throws SQLException 
	 */
	public void addNotice(Notice notice) throws SQLException {
		dao.insert(notice);
	}
	
	/**
	 * 修改部门
	 */
	public void updateNotice(Notice notice) throws SQLException {
		dao.update(notice);
	}
	
	/**
	 * 删除部门
	 */
	public void deleteNotice(int notice_id) throws SQLException {
		dao.delete(notice_id);
	}
	
	/**
	 * 查询单独的部门
	 */
	public Notice queryNoticeById(int notice_id) throws SQLException {
		
		return dao.queryById(notice_id);
	}
	
	/**
	 * 分页查询所有部门
	 * @throws SQLException 
	 */
	public ArrayList<Notice> queryNoticeByPage(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
	}
	/**
	 * 获得总记录数
	 * @throws SQLException 
	 */
	public int getNoticeCount() throws SQLException {
		return dao.getCount();
	}

}