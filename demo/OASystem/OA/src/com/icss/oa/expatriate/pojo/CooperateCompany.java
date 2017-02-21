package com.icss.oa.expatriate.pojo;

public class CooperateCompany {
	private int cooperateCompanyId;
	private String cooperateCompanyName;
	private String cooperateCompanyPerson;
	private String cooperateCompanyAddress;
	private String cooperateCompanyTel;
	public CooperateCompany() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CooperateCompany(int cooperateCompanyId,
			String cooperateCompanyName, String cooperateCompanyPerson,
			String cooperateCompanyAddress, String cooperateCompanyTel) {
		super();
		this.cooperateCompanyId = cooperateCompanyId;
		this.cooperateCompanyName = cooperateCompanyName;
		this.cooperateCompanyPerson = cooperateCompanyPerson;
		this.cooperateCompanyAddress = cooperateCompanyAddress;
		this.cooperateCompanyTel = cooperateCompanyTel;
	}
	public CooperateCompany(String cooperateCompanyName,
			String cooperateCompanyPerson, String cooperateCompanyAddress,
			String cooperateCompanyTel) {
		super();
		this.cooperateCompanyName = cooperateCompanyName;
		this.cooperateCompanyPerson = cooperateCompanyPerson;
		this.cooperateCompanyAddress = cooperateCompanyAddress;
		this.cooperateCompanyTel = cooperateCompanyTel;
	}
	public int getCooperateCompanyId() {
		return cooperateCompanyId;
	}
	public void setCooperateCompanyId(int cooperateCompanyId) {
		this.cooperateCompanyId = cooperateCompanyId;
	}
	public String getCooperateCompanyName() {
		return cooperateCompanyName;
	}
	public void setCooperateCompanyName(String cooperateCompanyName) {
		this.cooperateCompanyName = cooperateCompanyName;
	}
	public String getCooperateCompanyPerson() {
		return cooperateCompanyPerson;
	}
	public void setCooperateCompanyPerson(String cooperateCompanyPerson) {
		this.cooperateCompanyPerson = cooperateCompanyPerson;
	}
	public String getCooperateCompanyAddress() {
		return cooperateCompanyAddress;
	}
	public void setCooperateCompanyAddress(String cooperateCompanyAddress) {
		this.cooperateCompanyAddress = cooperateCompanyAddress;
	}
	public String getCooperateCompanyTel() {
		return cooperateCompanyTel;
	}
	public void setCooperateCompanyTel(String cooperateCompanyTel) {
		this.cooperateCompanyTel = cooperateCompanyTel;
	}
	@Override
	public String toString() {
		return "CooperateCompany [cooperateCompanyId=" + cooperateCompanyId
				+ ", cooperateCompanyName=" + cooperateCompanyName
				+ ", cooperateCompanyPerson=" + cooperateCompanyPerson
				+ ", cooperateCompanyAddress=" + cooperateCompanyAddress
				+ ", cooperateCompanyTel=" + cooperateCompanyTel + "]";
	}

}
