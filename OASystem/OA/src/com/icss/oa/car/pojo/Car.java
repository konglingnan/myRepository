package com.icss.oa.car.pojo;

import java.io.InputStream;

/**
 * 汽车实体类
 * @author Administrator
 *
 */
public class Car {

	private int carId;

	private String carType;

	private String carTag;

	private InputStream carPic;
	
	public Car() {
		super();
	}

	public Car(String carType, String carTag, InputStream carPic) {
		super();
		this.carType = carType;
		this.carTag = carTag;
		this.carPic = carPic;
	}

	public Car(int carId, String carType, String carTag, InputStream carPic) {
		super();
		this.carId = carId;
		this.carType = carType;
		this.carTag = carTag;
		this.carPic = carPic;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarTag() {
		return carTag;
	}

	public void setCarTag(String carTag) {
		this.carTag = carTag;
	}

	public InputStream getCarPic() {
		return carPic;
	}

	public void setCarPic(InputStream carPic) {
		this.carPic = carPic;
	}
	

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carType=" + carType + ", carTag="
				+ carTag + ", cpPic=" + carPic + "]";
	}
}