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
 * ����ҵ��
 * @author Administrator
 *
 */
public class InventoryService {
	
	private InventoryDao dao = new InventoryDao();
	
	/**
	 * ���Ӳ���
	 * @throws SQLException 
	 */
	public void addInventory(Inventory inventory) throws SQLException {
		dao.insert(inventory);
	}
	
	/**
	 * �޸Ĳ���
	 */
	public void updateInventory(Inventory inventory) throws SQLException {
		dao.update(inventory);
	}
	
	/**
	 * ɾ������
	 */
	public void deleteInventory(int inventoryId) throws SQLException {
		dao.delete(inventoryId);
	}
	
	/**
	 * ��ѯ�����Ĳ���
	 */
	public Inventory queryInventoryById(int inventoryId) throws SQLException {
		
		return dao.queryById(inventoryId);
       	}
	
	
    public int getInventoryCount() throws SQLException{
		
		return dao.getInventoryCount();
	}
    
	/**
	 * ��ѯ���в���
	 * @throws SQLException 
	 */
	public ArrayList<Inventory> queryAllInventory(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
	}
	
	/**
	 * ����excel����
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void exportExcel(OutputStream os) throws SQLException, IOException {
		
//		����������
		HSSFWorkbook wb = new HSSFWorkbook();
		
//		���������
		HSSFSheet sheet1 = wb.createSheet("��Ʒ����");
		
//		Ĭ���п�
		sheet1.setDefaultColumnWidth(15);
		
//		������
		String[] titles = {"��Ʒ���","��Ʒ����","��Ʒ����","��Ʒ�۸�","��Ʒ�������"};
		
//		�ж���
		HSSFRow titleRow = sheet1.createRow(0);
		
		for (int i = 0;i < titles.length;i ++) {
			titleRow.createCell(i).setCellValue(titles[i]);
		}
		
//		������
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