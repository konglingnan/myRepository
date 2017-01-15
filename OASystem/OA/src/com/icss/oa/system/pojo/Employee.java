package com.icss.oa.system.pojo;

import java.sql.Date;

/**
 * 员工实体类
 * @author Administrator
 *
 */
public class Employee {
	
	private int empId;
	
	private String empName;
	
	private String empSex;
	
	private Date empBirth;
	
	private String empPasswd;
	
	private Department dept; //多对一
	
	private Job job; //多对一

	public Employee() {
		super();
	}

	public Employee(int empId, String empName, String empSex,
			Date empBirth, String empPassword, Department dept, Job job) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSex = empSex;
		this.empBirth = empBirth;
		this.empPasswd = empPassword;
		this.dept = dept;
		this.job = job;
	}

	public Employee(String empName, String empSex,
			Date empBirth, String empPasswd, Department dept, Job job) {
		super();
		this.empName = empName;
		this.empSex = empSex;
		this.empBirth = empBirth;
		this.empPasswd = empPasswd;
		this.dept = dept;
		this.job = job;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSex() {
		return empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public Date getEmpBirth() {
		return empBirth;
	}

	public void setEmpBirth(Date empBirth) {
		this.empBirth = empBirth;
	}

	public String getEmpPasswd() {
		return empPasswd;
	}

	public void setEmpPasswd(String empPasswd) {
		this.empPasswd = empPasswd;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empSex=" + empSex + ", empBirth=" + empBirth + ", empPasswd=" + empPasswd
				+ ", dept=" + dept + ", job=" + job + "]";
	}	
	
}