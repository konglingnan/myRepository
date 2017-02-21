package test;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.icss.oa.car.pojo.Car;
import com.icss.oa.car.service.CarService;

/**
 * ≤‚ ‘∆˚≥µ’’∆¨DAO¿‡
 * @author Administrator
 *
 */
public class TestCarPicDao {
	
	private CarService service = new CarService();

	@Test
	public void testInsert() throws FileNotFoundException, SQLException {
		
		ArrayList<Car> list = service.queryAll();
		System.out.println(list.toString());
		
	}

}