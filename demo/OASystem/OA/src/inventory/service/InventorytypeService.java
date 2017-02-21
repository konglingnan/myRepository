package inventory.service;

import inventory.dao.InventorytypeDao;
import inventory.pojo.Inventorytype;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 部门业务
 * @author Administrator
 *
 */
public class InventorytypeService {
	
	private InventorytypeDao dao = new InventorytypeDao();
	
	/**
	 * 增加部门
	 * @throws SQLException 
	 */
	public void addInventorytype(Inventorytype inventorytype) throws SQLException {
		dao.insert(inventorytype);
	}
	
	/**
	 * 修改部门
	 */
	public void updateInventorytype(Inventorytype inventorytype) throws SQLException {
		dao.update(inventorytype);
	}
	
	/**
	 * 删除部门
	 */
	public void deleteInventorytype(int inventorytypeId) throws SQLException {
		dao.delete(inventorytypeId);
	}
	
	/**
	 * 查询单独的部门
	 */
	public Inventorytype queryInventorytypeById(int inventorytypeId) throws SQLException {
		
		return dao.queryById(inventorytypeId);
	}
	
	/**
	 * 查询所有部门
	 * @throws SQLException 
	 */
	public ArrayList<Inventorytype> queryAllInventorytype() throws SQLException {
		
		return dao.queryAll();
	}
	
	/**
	 * 导出excel报表
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void exportExcel(OutputStream os) throws SQLException, IOException {
		
//		工作簿对象
		HSSFWorkbook wb = new HSSFWorkbook();
		
//		工作表对象
		HSSFSheet sheet1 = wb.createSheet("库存数据");
		
//		默认列宽
		sheet1.setDefaultColumnWidth(15);
		
//		标题行
		String[] titles = {"库存编号","库存类型"};
		
//		行对象
		HSSFRow titleRow = sheet1.createRow(0);
		
		for (int i = 0;i < titles.length;i ++) {
			titleRow.createCell(i).setCellValue(titles[i]);
		}
		
//		数据行
		ArrayList<Inventorytype> list = dao.queryAll();
		
		for (int i = 0;i < list.size();i ++) {
			HSSFRow row =  sheet1.createRow(i + 1);
			row.createCell(0).setCellValue(list.get(i).getInventorytypeId());
			row.createCell(1).setCellValue(list.get(i).getInventorytypeName());
		}
		
		wb.write(os);
		os.close();
	}

}