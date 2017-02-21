package inventory.pojo;

public class Inventory {
	private int inventoryId;
	private String inventoryName;
	private int inventoryNum;
	private float inventoryPrice;
	private int inventorytypeId;

	public Inventory() {
		super();
	}
	 
	public Inventory(int inventoryId, String inventoryName,
			int inventoryNum, float inventoryPrice,  int inventorytypeId) {
		super();
		this.inventoryId = inventoryId;
		this.inventoryName = inventoryName;
		this.inventoryNum = inventoryNum;
		this.inventoryPrice = inventoryPrice;
		this.inventorytypeId = inventorytypeId;
	}
	

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public int getInventoryNum() {
		return inventoryNum;
	}

	public void setInventoryNum(int inventoryNum) {
		this.inventoryNum = inventoryNum;
	}

	public float getInventoryPrice() {
		return inventoryPrice;
	}

	public void setInventoryPrice(float inventoryPrice) {
		this.inventoryPrice = inventoryPrice;
	}

	public int getInventorytypeId() {
		return inventorytypeId;
	}

	public void setInventorytypeId(int inventorytypeId) {
		this.inventorytypeId = inventorytypeId;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", inventoryName="
				+ inventoryName + ", inventoryNum=" + inventoryNum
				+ ", inventoryPrice=" + inventoryPrice + ", inventorytypeId="
				+ inventorytypeId + "]";
	}
	
	
	

}
