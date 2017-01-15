package com.icss.oa.system.pojo;

/**
 *  µÃÂ¿‡
 * 
 * @author Administrator
 * 
 */
public class Department {

	private int deptId;

	private String deptName;

	private String deptDesc;
	
	private String deptTel;

	public Department() {
		super();
	}

	public Department(String deptName, String deptDesc, String deptTel) {
		super();
		this.deptName = deptName;
		this.deptDesc = deptDesc;
		this.deptTel = deptTel;
	}

	public Department(int deptId, String deptName, String deptDesc, String deptTel) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptDesc = deptDesc;
		this.deptTel = deptTel;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public String getDeptTel() {
		return deptTel;
	}

	public void setDeptTel(String deptTel) {
		this.deptTel = deptTel;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName
				+ ", deptDesc=" + deptDesc + ", deptTel=" + deptTel + "]";
	}	
}