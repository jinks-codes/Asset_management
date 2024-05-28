package dao;

import java.sql.Date;
import java.sql.SQLException;

import myException.AssetNotFoundException;
import myException.AssetNotMaintainedException;
import entity.assets;

public interface AssetManagementService {
    boolean addAsset(assets asset)throws AssetNotFoundException, SQLException ;
    boolean updateAsset(assets asset)throws AssetNotFoundException;
    boolean deleteAsset(int assetId)throws AssetNotFoundException;
    boolean allocateAsset(int assetId, int employeeId, Date allocationDate)throws AssetNotFoundException;
    boolean deallocateAsset(int assetId, int employeeId, Date returnDate)throws AssetNotFoundException;
    boolean performMaintenance(int assetId, Date maintenanceDate, String description, double cost)throws AssetNotFoundException,AssetNotMaintainedException;
    boolean reserveAsset(int assetId, int employeeId, Date reservationDate, Date startDate, Date endDate)throws AssetNotFoundException;
    boolean withdrawReservation(int reservationId);
	
}