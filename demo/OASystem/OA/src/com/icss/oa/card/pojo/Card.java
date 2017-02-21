package com.icss.oa.card.pojo;

public class Card {

	private int cardId;
	private String cardName;	
	private String phone;
	private String address;
	private String cardQQ;
	private String eMail;
	private String company;
	private String identity;
	private int cardTypeId;
	public int getCardTypeId() {
		return cardTypeId;
	}
	public void setCardTypeId(int cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cadId) {
		this.cardId = cadId;
	}
	public Card(String cardName, String phone, String address, String cardQQ,
			String eMail, String company, String identity, int cardTypeId) {
		super();
		this.cardName = cardName;
		this.phone = phone;
		this.address = address;
		this.cardQQ = cardQQ;
		this.eMail = eMail;
		this.company = company;
		this.identity = identity;
		this.cardTypeId = cardTypeId;
	}
	public Card(int cardId, String cardName, String phone, String address,
			String cardQQ, String eMail, String company, String identity) {
		super();
		this.cardId = cardId;
		this.cardName = cardName;
		this.phone = phone;
		this.address = address;
		this.cardQQ = cardQQ;
		this.eMail = eMail;
		this.company = company;
		this.identity = identity;
	}
	public Card(String cardName, String phone, String address, String cardQQ,
			String eMail, String company, String identity) {
		super();
		this.cardName = cardName;
		this.phone = phone;
		this.address = address;
		this.cardQQ = cardQQ;
		this.eMail = eMail;
		this.company = company;
		this.identity = identity;
	}
	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardName=" + cardName + ", phone="
				+ phone + ", address=" + address + ", cardQQ=" + cardQQ
				+ ", eMail=" + eMail + ", company=" + company + ", identity="
				+ identity + ", cardTypeId=" + cardTypeId + "]";
	}
	public Card(int cardId, String cardName, String phone, String address,
			String cardQQ, String eMail, String company, String identity,
			int cardTypeId) {
		super();
		this.cardId = cardId;
		this.cardName = cardName;
		this.phone = phone;
		this.address = address;
		this.cardQQ = cardQQ;
		this.eMail = eMail;
		this.company = company;
		this.identity = identity;
		this.cardTypeId = cardTypeId;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardQQ() {
		return cardQQ;
	}
	public void setCardQQ(String cardQQ) {
		this.cardQQ = cardQQ;
	}
	public String geteMail() {
		return eMail;
	}

	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

}
