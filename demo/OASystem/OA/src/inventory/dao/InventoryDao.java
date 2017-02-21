package inventory.dao;

import inventory.pojo.Inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DbUtil;
import com.icss.oa.common.Pager;

public class InventoryDao {

	public void insert(Inventory inventory) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "insert into  inventory values(inventory_seq.nextval,?,?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		//pstmt.setInt(1, inventory.getInventoryId());
		pstmt.setString(1, inventory.getInventoryName());
		pstmt.setInt(2, inventory.getInventoryNum());
		pstmt.setFloat(3, inventory.getInventoryPrice());
		pstmt.setInt(4, inventory.getInventorytypeId());

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}



	public void delete(int inventoryId) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "delete from inventory where inventory_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, inventoryId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	public void update(Inventory inventory) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "update inventory set inventory_name=?,num=?,price=?,inventorytype_Id=? where inventory_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, inventory.getInventoryName());
		pstmt.setInt(2, inventory.getInventoryNum());
		pstmt.setFloat(3, inventory.getInventoryPrice());
		pstmt.setInt(4, inventory.getInventorytypeId());
		pstmt.setInt(5, inventory.getInventoryId());
		conn.commit();
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
		
	public Inventory queryById(int inventoryId) throws SQLException {

		Inventory inventory = null;

		Connection conn = DbUtil.getConnection();

		String sql = "select * from inventory where inventory_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, inventoryId);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			inventory = new Inventory(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4),
					rs.getInt(5));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return inventory;
	}
public ArrayList<Inventory> queryAll() throws SQLException {
		
		ArrayList<Inventory> list = new ArrayList<Inventory>();

		Connection conn = DbUtil.getConnection();

		String sql = "select * from inventory";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Inventory inventory = new Inventory(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4),rs.getInt(5));
			list.add(inventory);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}
/**
 * 分页查询所有数据
 * 
 * @return
 * @throws SQLException
 */
public ArrayList<Inventory> queryAll(Pager pager) throws SQLException {

	ArrayList<Inventory> list = new ArrayList<Inventory>();

	Connection conn = DbUtil.getConnection();

	String sql="SELECT * FROM (select rownum rnum,inventory_id,inventory_name,num,price,inventorytype_id from inventory ) where rnum between ? and ?";

	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.setInt(1, pager.getStart());
	pstmt.setInt(2, pager.getEnd());

	ResultSet rs = pstmt.executeQuery();

	while (rs.next()) {
		

		Inventory inventory = new Inventory(rs.getInt(2), rs.getString(3), rs.getInt(4),
				rs.getFloat(5),rs.getInt(6));
		
		list.add(inventory);
	}

	rs.close();
	pstmt.close();
	conn.close();

	return list;
}
public int getInventoryCount() throws SQLException {
	
	Connection conn = DbUtil.getConnection();
	
	String sql = "SELECT COUNT(*) FROM inventory";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	ResultSet rs = pstmt.executeQuery();
	
	rs.next();
	
	int count = rs.getInt(1);
	
	rs.close();
	pstmt.close();
	conn.close();
	
	return count;	
}



}


