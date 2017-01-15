package inventory.dao;

import inventory.pojo.Inventorytype;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DbUtil;

public class InventorytypeDao {

	public void insert(Inventorytype inventorytype) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "insert into inventorytype values(inventorytype_seq.nextval,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		//pstmt.setInt(1, inventorytype.getInventorytypeId());
		pstmt.setString(1, inventorytype.getInventorytypeName());
		conn.commit();
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}



	public void delete(int inventorytypeId) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "delete from inventorytype where inventorytype_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, inventorytypeId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	public void update(Inventorytype inventorytype) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "update inventorytype set inventorytype_name=? where inventorytype_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, inventorytype.getInventorytypeName());
		pstmt.setInt(2, inventorytype.getInventorytypeId());

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
		
	public Inventorytype queryById(int inventorytypeId) throws SQLException {

		Inventorytype inventorytype = null;

		Connection conn = DbUtil.getConnection();

		String sql = "select * from inventorytype where inventorytype_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, inventorytypeId);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			inventorytype = new Inventorytype(rs.getInt(1),
					rs.getString(2));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return inventorytype;
	}
public ArrayList<Inventorytype> queryAll() throws SQLException {
		
		ArrayList<Inventorytype> list = new ArrayList<Inventorytype>();

		Connection conn = DbUtil.getConnection();

		String sql = "select * from inventorytype";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Inventorytype inventorytype = new Inventorytype(rs.getInt(1), rs.getString(2));
			list.add(inventorytype);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}

}


