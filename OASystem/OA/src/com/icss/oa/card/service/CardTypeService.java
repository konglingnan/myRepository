package com.icss.oa.card.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.card.dao.CardDao;
import com.icss.oa.card.dao.CardTypeDao;
import com.icss.oa.card.pojo.Card;
import com.icss.oa.card.pojo.CardType;
import com.icss.oa.system.dao.DepartmentDao;
import com.icss.oa.system.pojo.Department;

/**
 * 部门业务
 * @author Administrator
 *
 */
public class CardTypeService {
	
	private CardTypeDao dao = new CardTypeDao();
	
	/**
	 * 增加部门
	 * @throws SQLException 
	 */
	public int max() throws SQLException{
		return dao.max();
	}
	public void addCardType(CardType cardType) throws SQLException {
		dao.insert(cardType);
	}
	
	/**
	 * 修改部门
	 */
	public void updateCardType(String name,String uname) throws SQLException {
		dao.update(name,uname);
	}
	
	/**
	 * 删除部门
	 */
	public void deleteCardType(int cardTypeId) throws SQLException {
		dao.delete(cardTypeId);
	}
	
	/**
	 * 查询单独的部门
	 */
	public String queryName(int cardTypeID) throws SQLException {
		
		return dao.queryName(cardTypeID);
		
	}
	 
	public ArrayList<CardType> queryCardTypeByEmployeeId(int employeeId) throws SQLException {
		
		return dao.queryAllName(employeeId);
		
	}
	/**
	 * 查询所有部门
	 * @throws SQLException 
	 */
	public ArrayList<CardType> queryAllCardType(int employeeId) throws SQLException {
		
		return dao.queryAll(employeeId);
		
	}
    public ArrayList<CardType> queryAllCardTypeName(int employeeId) throws SQLException {
		
		return dao.queryAllName(employeeId);
		
	}
    

}