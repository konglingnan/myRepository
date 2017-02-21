package inventory.service;

import inventory.dao.InventoryDao;
import inventory.pojo.Inventory;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.icss.oa.common.Pager;

/**
 * 部门业务
 * @author Administrator
 *
 */
public class InventoryService {
	
	private InventoryDao dao = new InventoryDao();
	
	/**
	 * 增加部门
	 * @throws SQLException 
	 */
	public void addInventory(Inventory inventory) throws SQLException {
		dao.insert(inventory);
	}
	
	/**
	 * 修改部门
	 */
	public void updateInventory(Inventory inventory) throws SQLException {
		dao.update(inventory);
	}
	
	/**
	 * 删除部门
	 */
	public void deleteInventory(int inventoryId) throws SQLException {
		dao.delete(inventoryId);
	}
	
	/**
	 * 查询单独的部门
	 */
	public Inventory queryInventoryById(int inventoryId) throws SQLException {
		
		return dao.queryById(inventoryId);
       	}
	
	
    public int getInventoryCount() throws SQLException{
		
		return dao.getInventoryCount();
	}
    
	/**
	 * 查询所有部门
	 * @throws SQLException 
	 */
	public ArrayList<Inventory> queryAllInventory(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
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
		HSSFSheet sheet1 = wb.createSheet("物品数据");
		
//		默认列宽
		sheet1.setDefaultColumnWidth(15);
		
//		标题行
		String[] titles = {"物品编号","物品名称","物品数量","物品价格","物品库存类型"};
		
//		行对象
		HSSFRow titleRow = sheet1.createRow(0);
		
		for (int i = 0;i < titles.length;i ++) {
			titleRow.createCell(i).setCellValue(titles[i]);
		}
		
//		数据行
		ArrayList<Inventory> list = dao.queryAll();
		
		for (int i = 0;i < list.size();i ++) {
			HSSFRow row =  sheet1.createRow(i + 1);
			row.createCell(0).setCellValue(list.get(i).getInventoryId());
			row.createCell(1).setCellValue(list.get(i).getInventoryName());
		}
		
		wb.write(os);
		os.close();
	}

}