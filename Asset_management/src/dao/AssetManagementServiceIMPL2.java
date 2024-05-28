package dao;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import myException.AssetNotFoundException;

import dao.AssetManagementService;
import entity.asset_allocations;
import entity.maintenance_records;
import entity.assets;

import util.DBConnection;


public class AssetManagementServiceIMPL implements AssetManagementService {
	
	private Connection conn;
	 public AssetManagementServiceIMPL2() {
	        this.conn = DBConnection.getConnection();
	    }

	@Override
	public boolean addAsset(assets asset)throws AssetNotFoundException {
        String query = "INSERT INTO assets (asset_id, name, type, serial_number, purchase_date, location, status, owner_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, asset.getasset_id());
            stmt.setString(2, asset.getName());
            stmt.setString(3, asset.getType());
            stmt.setInt(4, asset.getSerial_Number());
            stmt.setDate(5, new java.sql.Date(asset.getPurchase_date().getTime()));
            stmt.setString(6, asset.getLocation());
            stmt.setString(7, asset.getStatus());
            stmt.setInt(8, asset.getOwnerId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public boolean updateAsset(assets asset)throws AssetNotFoundException {
	    String query = "UPDATE assets SET name = ?, type = ?, serial_number = ?, purchase_date = ?, location = ?, status = ?, owner_id = ? WHERE asset_id = ?";
	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setString(1, asset.getName());
	        stmt.setString(2, asset.getType());
	        stmt.setInt(3, asset.getSerial_Number());
	        stmt.setDate(4, new java.sql.Date(asset.getPurchase_date().getTime()));
	        stmt.setString(5, asset.getLocation());
	        stmt.setString(6, asset.getStatus());
	        stmt.setInt(7, asset.getOwnerId());
	        stmt.setInt(8, asset.getasset_id());
	        return stmt.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean deleteAsset(int assetId)throws AssetNotFoundException {
	    String query = "DELETE FROM assets WHERE asset_id = ?";
	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, assetId);
	        return stmt.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	@Override
	public boolean allocateAsset(int assetId, int employeeId, Date allocationDate)throws AssetNotFoundException {
	    String query = "INSERT INTO asset_allocations (asset_id, employee_id, allocation_date) VALUES (?, ?, ?)";
	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, assetId);
	        stmt.setInt(2, employeeId);
	        stmt.setDate(3, new java.sql.Date(allocationDate.getTime()));
	        return stmt.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean deallocateAsset(int assetId, int employeeId, Date returnDate)throws AssetNotFoundException {
	    String query = "UPDATE asset_allocations SET return_date = ? WHERE asset_id = ? AND employee_id = ?";
	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setDate(1,  new java.sql.Date(returnDate.getTime()));
	        stmt.setInt(2, assetId);
	        stmt.setInt(3, employeeId);
	        return stmt.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	@Override
	public boolean performMaintenance(int assetId, Date maintenanceDate, String description, double cost) throws AssetNotFoundException{
	    String query = "INSERT INTO maintenance_records (asset_id, maintenance_date, description, cost) VALUES (?, ?, ?, ?)";
	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, assetId);
	        stmt.setDate(2, new java.sql.Date(maintenanceDate.getTime()));
	        stmt.setString(3, description);
	        stmt.setDouble(4, cost);
	        return stmt.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean reserveAsset(int assetId, int employeeId, Date reservationDate, Date startDate, Date endDate) {
	    String query = "INSERT INTO reservations (asset_id, employee_id, reservation_date, start_date, end_date, status) VALUES (?, ?, ?, ?, ?, 'pending')";
	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, assetId);
	        stmt.setInt(2, employeeId);
	        stmt.setDate(3, new java.sql.Date(reservationDate.getTime()));
	        stmt.setDate(4, new java.sql.Date(startDate.getTime()));
	        stmt.setDate(5, new java.sql.Date(endDate.getTime()));
	        return stmt.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean withdrawReservation(int reservationId) {
	    String query = "DELETE FROM reservations WHERE reservation_id = ?";
	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, reservationId);
	        return stmt.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
