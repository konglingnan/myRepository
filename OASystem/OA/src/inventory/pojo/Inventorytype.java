package inventory.pojo;

public class Inventorytype {
	private int inventorytypeId; 	
	private String inventorytypeName;
	public Inventorytype() {
		super();
	}
	public Inventorytype(int inventorytypeId, String inventorytypeName) {
		super();
		this.inventorytypeId = inventorytypeId;
		this.inventorytypeName = inventorytypeName;
	}
	public String getInventorytypeName() {
		return inventorytypeName;
	}
	public void setInventorytypeName(String inventorytypeName) {
		this.inventorytypeName = inventorytypeName;
	}
	public int getInventorytypeId() {
		return inventorytypeId;
	}
	public void setInventorytypeId(int inventorytypeId) {
		this.inventorytypeId = inventorytypeId;
	}
	@Override
	public String toString() {
		return "Inventorytype [inventorytypeId=" + inventorytypeId
				+ ", inventorytypeName=" + inventorytypeName + "]";
	}
	


}
