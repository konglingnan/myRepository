package com.icss.oa.card.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.card.dao.CardDao;
import com.icss.oa.card.pojo.Card;
import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.DepartmentDao;
import com.icss.oa.system.pojo.Department;

/**
 * ����ҵ��
 * @author Administrator
 *
 */
public class CardService {
	
	private CardDao dao = new CardDao();
	
	/**
	 * ���Ӳ���
	 * @throws SQLException 
	 */
	public void addCard(Card card) throws SQLException {
		dao.insert(card);
	}
	
	/**
	 * �޸Ĳ���
	 */
	public void updateCard(Card card) throws SQLException {
		dao.update(card);
	}
	
	/**
	 * ɾ������
	 */
	public void deleteCard(int cardId) throws SQLException {
		dao.delete(cardId);
	}
	
	/**
	 * ��ѯ�����Ĳ���
	 */
	public Card queryCardTypeById(int cardTypeId) throws SQLException {
		
		//return dao.queryById(cardTypeId);
		return null;
		
	}
	public Card queryCardById(int cardId) throws SQLException {
		
		return dao.queryById(cardId);
		
		
	}
    public int getCount(int employee,String cardTypeName) throws SQLException {
		
		//return dao.queryById(cardTypeId);
		return dao.getCount(employee,cardTypeName);
		
	}
	
	/**
	 * ��ѯ���в���
	 * @throws SQLException 
	 */
	public ArrayList<Card> queryAllCard(Pager pager,int employee,String cardTypeName) throws SQLException {
		
		return dao.queryAll(pager,employee,cardTypeName);
	}

}