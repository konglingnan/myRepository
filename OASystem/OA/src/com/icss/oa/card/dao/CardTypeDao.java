package com.icss.oa.card.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.card.pojo.Card;
import com.icss.oa.card.pojo.CardType;
import com.icss.oa.common.DbUtil;

public class CardTypeDao {
	public void insert(CardType cardType) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql="INSERT INTO cardType VALUES(cardtype_seq.nextval,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		System.out.println(cardType.toString());
		pstmt.setString(1, cardType.getCardTypeName());
		pstmt.setInt(2, cardType.getEmployeeId());
		
		pstmt.executeUpdate();
	    conn.commit();
		pstmt.close();
		conn.close();
	}
	public void delete(int cardTypeId) throws SQLException {

		Connection conn = DbUtil.getConnection();
		String sql="DELETE FROM cardtype WHERE cardtype_Id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cardTypeId);
		pstmt.executeUpdate();
	    conn.commit();
		pstmt.close();
		conn.close();
	}
	public int max() throws SQLException {

		Connection conn = DbUtil.getConnection();
		String sql="select max(cardtype_id) from cardtype ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int max=rs.getInt(1);
		pstmt.executeUpdate();
	    conn.commit();
		pstmt.close();
		conn.close();
		return max;
	}	
	public void update(String name,String uname) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql="UPDATE cardtype set cardtype_name = ? where cardtype_name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, name);
		
		pstmt.setString(2, uname);
		
		pstmt.executeUpdate();
	    conn.commit();
		pstmt.close();
		conn.close();
	}
    

public ArrayList<CardType> queryAll(int employeeId) throws SQLException {
	
		
		ArrayList<CardType> list = new ArrayList<CardType>();

		Connection conn = DbUtil.getConnection();

		String sql = "SELECT * FROM cardType where employee_Id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, employeeId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {		
			CardType cardType=new CardType(rs.getInt(1),rs.getString(2),rs.getInt(3));
			list.add(cardType);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}
public ArrayList<CardType> queryAllName(int employeeId) throws SQLException {
	
	
	ArrayList<CardType> list = new ArrayList<CardType>();

	Connection conn = DbUtil.getConnection();

	String sql = "SELECT  cardtype_name FROM cardType WHERE employee_id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, employeeId);
	

	ResultSet rs = pstmt.executeQuery();
	
	while(rs.next()) {
		CardType cardType=new CardType();
		cardType.setCardTypeName(rs.getString(1));
		list.add(cardType);
	}
	
	rs.close();
	pstmt.close();
	conn.close();
	
	return list;
   }
public String queryName(int cardtype_id) throws SQLException {
	
	
	

	Connection conn = DbUtil.getConnection();

	String sql = "SELECT  cardtype_name FROM cardType WHERE cardtype_id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, cardtype_id);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	String fun=rs.getString(1);
	rs.close();
	pstmt.close();
	conn.close();
	
	return fun;
}
}
