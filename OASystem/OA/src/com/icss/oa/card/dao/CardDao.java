package com.icss.oa.card.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.card.pojo.Card;
import com.icss.oa.card.pojo.CardType;
import com.icss.oa.card.service.CardTypeService;
import com.icss.oa.common.DbUtil;
import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Department;

public class CardDao {
	public void insert(Card card) throws SQLException{
		CardTypeService cardType=new CardTypeService();
		
		Connection conn = DbUtil.getConnection();
		String sql="INSERT INTO card VALUES(card_seq.nextval,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		System.out.println(card.toString());
		pstmt.setString(1, card.getCardName());
		pstmt.setString(2, card.getPhone());
		pstmt.setString(3, card.getAddress());
		pstmt.setString(4, card.getCardQQ());
		pstmt.setString(5, card.geteMail());
		pstmt.setString(6, card.getCompany());
		pstmt.setString(7, card.getIdentity());
		pstmt.setInt(8,card.getCardTypeId());
		//System.out.print(card.toString()+cardType.max());
		pstmt.executeUpdate();
	    conn.commit();
		pstmt.close();
		conn.close();
	}
	public void delete(int cardId) throws SQLException {

		Connection conn = DbUtil.getConnection();
		String sql="DELETE FROM card WHERE card_Id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cardId);
		pstmt.executeUpdate();
	    conn.commit();
		pstmt.close();
		conn.close();
	}
	public Card queryById(int cardId) throws SQLException {

		Connection conn = DbUtil.getConnection();
		String sql="SELECt * FROM card Where card_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cardId);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		Card card=new Card(rs.getInt(1),rs.getString(2),rs.getString(3),
				rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)
				,rs.getString(8),rs.getInt(9));
		pstmt.executeUpdate();
	    conn.commit();
		pstmt.close();
		conn.close();
		return card;
	}
	public void update(Card card) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql="UPDATE card set card_name = ?,phone = ?,address = ?,card_qq = ?,email=?,company=?,identity=? where 	card_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, card.getCardName());
		pstmt.setString(2, card.getPhone());
		pstmt.setString(3, card.getAddress());
		pstmt.setString(4, card.getCardQQ());
		pstmt.setString(5, card.geteMail());
		pstmt.setString(6, card.getCompany());
		pstmt.setString(7, card.getIdentity());
		
		pstmt.setInt(8, card.getCardId());
		pstmt.executeUpdate();
	    conn.commit();
		pstmt.close();
		conn.close();	
	}
    public int getCount(int employee,String cardTypeName) throws SQLException{
       Connection conn = DbUtil.getConnection();
	   String sql = "select count(*) from card where cardtype_id in(select cardtype_id from cardtype  where employee_id=? and cardtype_name=?)";
	   PreparedStatement pstmt = conn.prepareStatement(sql);
	   pstmt.setInt(1, employee);
		
	   pstmt.setString(2, cardTypeName);
	   ResultSet rs = pstmt.executeQuery();
	   
	   int num=0;
	   if(rs.next())num=rs.getInt(1);
	   System.out.print("ddddddd"+num);
	   rs.close();
	   pstmt.close();
	   conn.close();
	   return num;
    }

   public ArrayList<Card> queryAll(Pager pager,int employee,String cardTypeName) throws SQLException {
		
		ArrayList<Card> list = new ArrayList<Card>();

		Connection conn = DbUtil.getConnection();

		String sql ="select * from" +
				"(select rownum rnum, card_id,card_name,phone,address,card_qq,email,company,identity,cardtype_id from card " +
				"where  cardtype_id in " +
				"(select  cardtype_id from cardtype where employee_id=? and cardtype_name=?))" +
				" where rnum between " +
				"? and ?  ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, employee);
		pstmt.setString(2, cardTypeName);
		pstmt.setInt(3, pager.getStart());
		pstmt.setInt(4, pager.getEnd());
		ResultSet rs = pstmt.executeQuery();	
		
		while(rs.next()) {
			
			Card card=new Card(rs.getInt(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getInt(10));
			
			list.add(card);
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}
   public ArrayList<Card> queryType(CardType cardType) throws SQLException{
	   ArrayList<Card> list = new ArrayList<Card>();

		Connection conn = DbUtil.getConnection();

		//String sql = "SELECT * FROM card WHERE employee_id=?";
		StringBuffer sql =new StringBuffer();
		sql.append("select * from" +
				"(select card_id,card_name,phone,address,card_qq,company,identity,cardtype_id,rownum rnum " +
				"from card where  cardtype_id in " +
				"(select  cardtype_id from cardtype where employee_id=1 and cardtype_name='111')" +
				") where rnum between ? and ? ;");
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Card card=new Card(rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)
					,rs.getString(8),rs.getInt(9));
			list.add(card);
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;  
	} 
}
