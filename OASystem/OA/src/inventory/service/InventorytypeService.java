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
 * ����ҵ��
 * @author Administrator
 *
 */
public class InventorytypeService {
	
	private InventorytypeDao dao = new InventorytypeDao();
	
	/**
	 * ���Ӳ���
	 * @throws SQLException 
	 */
	public void addInventorytype(Inventorytype inventorytype) throws SQLException {
		dao.insert(inventorytype);
	}
	
	/**
	 * �޸Ĳ���
	 */
	public void updateInventorytype(Inventorytype inventorytype) throws SQLException {
		dao.update(inventorytype);
	}
	
	/**
	 * ɾ������
	 */
	public void deleteInventorytype(int inventorytypeId) throws SQLException {
		dao.delete(inventorytypeId);
	}
	
	/**
	 * ��ѯ�����Ĳ���
	 */
	public Inventorytype queryInventorytypeById(int inventorytypeId) throws SQLException {
		
		return dao.queryById(inventorytypeId);
	}
	
	/**
	 * ��ѯ���в���
	 * @throws SQLException 
	 */
	public ArrayList<Inventorytype> queryAllInventorytype() throws SQLException {
		
		return dao.queryAll();
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
		HSSFSheet sheet1 = wb.createSheet("�������");
		
//		Ĭ���п�
		sheet1.setDefaultColumnWidth(15);
		
//		������
		String[] titles = {"�����","�������"};
		
//		�ж���
		HSSFRow titleRow = sheet1.createRow(0);
		
		for (int i = 0;i < titles.length;i ++) {
			titleRow.createCell(i).setCellValue(titles[i]);
		}
		
//		������
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