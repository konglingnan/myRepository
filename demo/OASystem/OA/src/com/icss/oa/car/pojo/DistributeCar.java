package com.icss.oa.car.pojo;
import java.sql.Date;

import com.icss.oa.system.pojo.Employee;
/*
 * ≈…∑¢≥µ¡æ¿‡
 * 
   distributecar_id  NUMBER(6) PRIMARY KEY,
   cause VARCHAR2(30),
   leader VARCHAR2(10),
   route VARCHAR2(30),
   apply_date DATE,
   start_date DATE,
   end_date DATE,
   state VARCHAR2(10),
   employee_id NUMBER(6)REFERENCES employee(employee_id),
   car_id NUMBER(6)REFERENCES car(car_id)
 * 
 */
public class DistributeCar {
	private int distributeCarId;
	private String route;
	private Date startDate;
	private Date endDate;
	private String state;
	private Employee employee;
	private Car car;

	public DistributeCar() {
		super();
	}

	public DistributeCar(String route, Date startDate, Date endDate, 
			String state, Employee employee, Car car) {
		super();
		this.route = route;
		this.startDate = startDate;
		this.endDate = endDate;
		this.state = state;
		this.employee = employee;
		this.car = car;
	}

	public DistributeCar(int distributeCarId, String route,
			Date startDate, Date endDate,
			String state, Employee employee, Car car) {
		super();
		this.distributeCarId = distributeCarId;
		this.route = route;
		this.startDate = startDate;
		this.endDate = endDate;
		this.state = state;
		this.employee = employee;
		this.car = car;
	}

	public int getdistributeCarId() {
		return distributeCarId;
	}

	public void setdistributeCarId(int distributeCarId) {
		this.distributeCarId = distributeCarId;
	}


	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "DistributeCar [distributeCarId=" + distributeCarId + ", route=" + route
				+ ", startDate=" + startDate
				+ ", endDate=" + endDate + ", state=" + state + ", employee="
				+ employee + ", car=" + car + "]";
	}
}
