package entity;

import java.util.Date;

public class maintenance_records {
    private int maintenance_id;
    private int asset_id;
    private Date maintenance_date;
    private String description;
    private double cost;

    // Default Constructor
    public maintenance_records() {
    }

    // Parameterized Constructor
    public maintenance_records(int maintenanceId, int assetId, Date maintenanceDate, String description, double cost) {
        this.maintenance_id = maintenanceId;
        this.asset_id = assetId;
        this.maintenance_date = maintenanceDate;
        this.description = description;
        this.cost = cost;
    }

    // Getters and Setters
    public int getMaintenanceId() {
        return maintenance_id;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenance_id = maintenanceId;
    }

    public int getAssetId() {
        return asset_id;
    }

    public void setAssetId(int assetId) {
        this.asset_id = assetId;
    }

    public Date getMaintenanceDate() {
        return maintenance_date;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenance_date = maintenanceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
