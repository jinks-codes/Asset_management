package entity;
import java.util.Date;

public class reservations {
    private int reservation_id;
    private int asset_id;
    private int employee_id;
    private Date reservation_date;
    private Date start_date;
    private Date end_date;
    private String status;

    // Default Constructor
    public reservations(){}

    // Parameterized Constructor
    public reservations (int reservationId, int assetId, int employeeId, Date reservationDate, Date startDate, Date endDate, String status) {
        this.reservation_id = reservationId;
        this.asset_id = assetId;
        this.employee_id = employeeId;
        this.reservation_date = reservationDate;
        this.start_date = startDate;
        this.end_date = endDate;
        this.status = status;
    }

    // Getter methods
    public int getReservationId() {
        return reservation_id;
    }

    public int getAssetId() {
        return asset_id;
    }

    public int getEmployeeId() {
        return employee_id;
    }

    public Date getReservationDate() {
        return reservation_date;
    }

    public Date getStartDate() {
        return start_date;
    }

    public Date getEndDate() {
        return end_date;
    }

    public String getStatus() {
        return status;
    }

    // Setter methods
    public void setReservationId(int reservationId) {
        this.reservation_id = reservationId;
    }

    public void setAssetId(int assetId) {
        this.asset_id = assetId;
    }

    public void setEmployeeId(int employeeId) {
        this.employee_id = employeeId;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservation_date = reservationDate;
    }

    public void setStartDate(Date startDate) {
        this.start_date = startDate;
    }

    public void setEndDate(Date endDate) {
        this.end_date = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}