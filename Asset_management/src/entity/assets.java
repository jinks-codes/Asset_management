package entity;

import java.util.Date;



public class assets {
	
	private int asset_id;
	private String type;
	private String name;
	private int serial_number;
	private Date purchase_date;
	private String location;
	private String status;
	private int owner_id;
	
	public assets(){}
	
	
	public assets( int asset_id, String type ,String name,int serial_number, String location, String status,int owner_id,Date purchase_date) {
		this.asset_id=asset_id;
		this.type=type;
		this.name=name;
		this.serial_number=serial_number;
		this.purchase_date=purchase_date;
		this.location=location;
		this.status=status;
		this.owner_id=owner_id;
	}
	
	public int getasset_id() {
        return asset_id;
    }

    public void setasset_id(int asset_id) {
        this.asset_id = asset_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSerial_Number() {
        return serial_number;
    }

    public void setSerialNumber(int serial_number) {
        this.serial_number = serial_number;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchaseDate(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOwnerId() {
        return owner_id;
    }

    public void setOwnerId(int owner_id) {
        this.owner_id = owner_id;
    }
}
	
