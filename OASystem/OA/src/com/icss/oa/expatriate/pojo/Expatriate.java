package com.icss.oa.expatriate.pojo;

public class Expatriate {
	private int expatriateId;
	private String expatriateName;
	private String expatriateSkill;
	private Float expatriateSalary;
	private String expatriateState;
	
	public Expatriate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expatriate(int expatriateId, String expatriateName,
			String expatriateSkill, Float expatriateSalary,
			String expatriateState) {
		super();
		this.expatriateId = expatriateId;
		this.expatriateName = expatriateName;
		this.expatriateSkill = expatriateSkill;
		this.expatriateSalary = expatriateSalary;
		this.expatriateState = expatriateState;
	}

	public Expatriate(String expatriateName, String expatriateSkill,
			Float expatriateSalary, String expatriateState) {
		super();
		this.expatriateName = expatriateName;
		this.expatriateSkill = expatriateSkill;
		this.expatriateSalary = expatriateSalary;
		this.expatriateState = expatriateState;
	}

	public Expatriate(String expatriateName, String expatriateSkill,
			Float expatriateSalary) {
		super();
		this.expatriateName = expatriateName;
		this.expatriateSkill = expatriateSkill;
		this.expatriateSalary = expatriateSalary;
	}

	public int getExpatriateId() {
		return expatriateId;
	}

	public void setExpatriateId(int expatriateId) {
		this.expatriateId = expatriateId;
	}

	public String getExpatriateName() {
		return expatriateName;
	}

	public void setExpatriateName(String expatriateName) {
		this.expatriateName = expatriateName;
	}

	public String getExpatriateSkill() {
		return expatriateSkill;
	}

	public void setExpatriateSkill(String expatriateSkill) {
		this.expatriateSkill = expatriateSkill;
	}

	public Float getExpatriateSalary() {
		return expatriateSalary;
	}

	public void setExpatriateSalary(Float expatriateSalary) {
		this.expatriateSalary = expatriateSalary;
	}

	public String getExpatriateState() {
		return expatriateState;
	}

	public void setExpatriateState(String expatriateState) {
		this.expatriateState = expatriateState;
	}

	@Override
	public String toString() {
		return "Expatriate [expatriateId=" + expatriateId + ", expatriateName="
				+ expatriateName + ", expatriateSkill=" + expatriateSkill
				+ ", expatriateSalary=" + expatriateSalary
				+ ", expatriateState=" + expatriateState + "]";
	}
	
}
