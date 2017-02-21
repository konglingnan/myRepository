package com.icss.oa.expatriate.pojo;
/*
 * Õ‚≈…º«¬º
 */
public class ExpatriateRecord {
	private int expatriateRecordId;
	private Expatriate expatriate;
	private CooperateCompany cooperateCompany;
	
	public ExpatriateRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpatriateRecord(int expatriateRecordId, Expatriate expatriate,
			CooperateCompany cooperateCompany) {
		super();
		this.expatriateRecordId = expatriateRecordId;
		this.expatriate = expatriate;
		this.cooperateCompany = cooperateCompany;
	}

	public ExpatriateRecord(Expatriate expatriate,
			CooperateCompany cooperateCompany) {
		super();
		this.expatriate = expatriate;
		this.cooperateCompany = cooperateCompany;
	}

	public int getExpatriateRecordId() {
		return expatriateRecordId;
	}

	public void setExpatriateRecordId(int expatriateRecordId) {
		this.expatriateRecordId = expatriateRecordId;
	}

	public Expatriate getExpatriate() {
		return expatriate;
	}

	public void setExpatriate(Expatriate expatriate) {
		this.expatriate = expatriate;
	}

	public CooperateCompany getCooperateCompany() {
		return cooperateCompany;
	}

	public void setCooperateCompany(CooperateCompany cooperateCompany) {
		this.cooperateCompany = cooperateCompany;
	}
	
	
	
}
