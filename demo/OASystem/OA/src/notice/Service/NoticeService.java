package notice.Service;



import java.sql.SQLException;
import java.util.ArrayList;

import notice.Dao.NoticeDao;
import notice.Pojo.Notice;

import com.icss.oa.common.Pager;

/**
 * ����ҵ��
 * @author Administrator
 *
 */
public class  NoticeService  {
	
	private NoticeDao dao = new NoticeDao();
	
	/**
	 * ���Ӳ���
	 * @throws SQLException 
	 */
	public void addNotice(Notice notice) throws SQLException {
		dao.insert(notice);
	}
	
	/**
	 * �޸Ĳ���
	 */
	public void updateNotice(Notice notice) throws SQLException {
		dao.update(notice);
	}
	
	/**
	 * ɾ������
	 */
	public void deleteNotice(int notice_id) throws SQLException {
		dao.delete(notice_id);
	}
	
	/**
	 * ��ѯ�����Ĳ���
	 */
	public Notice queryNoticeById(int notice_id) throws SQLException {
		
		return dao.queryById(notice_id);
	}
	
	/**
	 * ��ҳ��ѯ���в���
	 * @throws SQLException 
	 */
	public ArrayList<Notice> queryNoticeByPage(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
	}
	/**
	 * ����ܼ�¼��
	 * @throws SQLException 
	 */
	public int getNoticeCount() throws SQLException {
		return dao.getCount();
	}

}