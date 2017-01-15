package com.icss.oa.card.pojo;

public class CardType {
	private int cardTypeId;
	private String cardTypeName;
	private int employeeId;
	public CardType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardType(int cardTypeId, String cardTypeName, int employeeId) {
		super();
		this.cardTypeId = cardTypeId;
		this.cardTypeName = cardTypeName;
		this.employeeId = employeeId;
	}
	public int getCardTyepeId() {
		return cardTypeId;
	}
	public void setCardTyepeID(int cardTypeId) {
		this.cardTypeId = cardTypeId;
	}
	public String getCardTypeName() {
		return cardTypeName;
	}
	public CardType(String cardTypeName, int employeeId) {
		super();
		this.cardTypeName = cardTypeName;
		this.employeeId = employeeId;
	}
	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "CardType [cardTypeId=" + cardTypeId + ", cardTypeName="
				+ cardTypeName + ", employeeId=" + employeeId + "]";
	}
}
