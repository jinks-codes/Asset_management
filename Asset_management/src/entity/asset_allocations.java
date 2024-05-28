package entity;

import java.util.Date;

public class asset_allocations {
    private int allocation_id;
    private int asset_id;
    private int employee_id;
    private Date allocation_date;
    private Date return_date;

    // Default Constructor
    public asset_allocations() {
    }

    // Parameterized Constructor
    public asset_allocations(int allocationId, int assetId, int employeeId, Date allocationDate, Date returnDate) {
        this.allocation_id = allocationId;
        this.asset_id = assetId;
        this.employee_id = employeeId;
        this.allocation_date = allocationDate;
        this.return_date = returnDate;
    }

    // Getters and Setters
    public int getAllocationId() {
        return allocation_id;
    }

    public void setAllocationId(int allocationId) {
        this.allocation_id = allocationId;
    }

    public int getAssetId() {
        return asset_id;
    }

    public void setAssetId(int assetId) {
        this.asset_id = assetId;
    }

    public int getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId(int employeeId) {
        this.employee_id = employeeId;
    }

    public Date getAllocationDate() {
        return allocation_date;
    }

    public void setAllocationDate(Date allocationDate) {
        this.allocation_date = allocationDate;
    }

    public Date getReturnDate() {
        return return_date;
    }

    public void setReturnDate(Date returnDate) {
        this.return_date = returnDate;
    }
}
