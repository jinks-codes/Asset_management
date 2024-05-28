package main;

import dao.AssetManagementService;
import dao.AssetManagementServiceIMPL;
import entity.assets;
import myException.AssetNotMaintainedException;
import myException.AssetNotFoundException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AssetManagementApp {
    private static AssetManagementService assetManagementService;

    public static void main(String[] args) throws AssetNotFoundException,AssetNotMaintainedException, SQLException {
        assetManagementService = new AssetManagementServiceIMPL();
        Scanner scanner = new Scanner(System.in);
        
        int choice;
        do {
        	System.out.println("           -------------------------");
            System.out.println("             Asset Management Menu:");
            System.out.println("           -------------------------");
            System.out.println("1. Add Asset");
            System.out.println("2. Update Asset");
            System.out.println("3. Delete Asset");
            System.out.println("4. Allocate Asset");
            System.out.println("5. Deallocate Asset");
            System.out.println("6. Perform Maintenance");
            System.out.println("7. Reserve Asset");
            System.out.println("8. Withdraw Reservation");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addAsset(scanner);
                    break;
                case 2:
                    updateAsset(scanner);
                    break;
                case 3:
                    deleteAsset(scanner);
                    break;
                case 4:
                    allocateAsset(scanner);
                    break;
                case 5:
                    deallocateAsset(scanner);
                    break;
                case 6:
                    performMaintenance(scanner);
                    break;
                case 7:
                    reserveAsset(scanner);
                    break;
                case 8:
                	withdrawReservation(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        
        scanner.close();
    }

   


		




		private static void addAsset(Scanner scanner) throws AssetNotFoundException, SQLException{
		    // Get input from user to create asset object
		    System.out.println("Enter asset details:");
		    System.out.print("Asset ID: ");
		    int asset_id = scanner.nextInt();
		    scanner.nextLine(); // Consume newline
		    
		    System.out.print("Name: ");
		    String name = scanner.nextLine();
		    
		    System.out.print("Type: ");
		    String type = scanner.nextLine();
		    
		    System.out.print("Serial Number: ");
		    int serial_number = scanner.nextInt();
		    scanner.nextLine();
		    System.out.print("Purchase Date (YYYY-MM-DD): ");
		    String purchaseDateStr = scanner.nextLine();
		    Date purchase_date = null;
		    try {
		        purchase_date = new SimpleDateFormat("yyyy-MM-dd").parse(purchaseDateStr);
		    } catch (ParseException e) {
		        System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
		        return; // Exit method if date format is invalid
		    }
		    java.sql.Date sqlPurchaseDate = new java.sql.Date(purchase_date.getTime());
		    
		    System.out.print("Location: ");
		    String location = scanner.nextLine();
		    
		    System.out.print("Status: ");
		    String status = scanner.nextLine();
		    
		    System.out.print("Owner ID: ");
		    int owner_id = scanner.nextInt();
		    scanner.nextLine(); // Consume newline
		    
		    // Create Asset object
		    assets asset = new assets( asset_id,  type , name, serial_number, location, status, owner_id,sqlPurchaseDate);
		    
		    if (assetManagementService.addAsset(asset)) {
			    System.out.println("Asset added successfully.");
			} else {
			    System.out.println("Failed to add asset.");
			}
		}
		
		private static void updateAsset(Scanner scanner)throws AssetNotFoundException {
			System.out.println("Enter asset details to update:");
			System.out.println("Asset ID");
			int asset_id = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Name: ");
			String name = scanner.nextLine();
			
			System.out.println("Type: ");
			String type = scanner.nextLine();
			
			System.out.println("Serial Number: ");
			int serial_number = scanner.nextInt();
			System.out.println("");
			scanner.nextLine();
			System.out.print("Purchase Date (YYYY-MM-DD): ");
		    String purchaseDateStr = scanner.nextLine();
		    Date purchase_date = null;
		    try {
		        purchase_date = new SimpleDateFormat("yyyy-MM-dd").parse(purchaseDateStr);
		    } catch (ParseException e) {
		        System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
		        return; // Exit method if date format is invalid
		    }
		    java.sql.Date sqlPurchaseDate = new java.sql.Date(purchase_date.getTime());
		   
		    
			System.out.println("Location: ");
			String location = scanner.nextLine();
			
			System.out.println("Status: ");
			String status = scanner.nextLine();
			
			System.out.println("Owner ID: ");
			int owner_id = scanner.nextInt();
		    
			//creating asset object
			assets asset = new assets(asset_id,type,name,serial_number,location, status,owner_id,sqlPurchaseDate);
			
			if(assetManagementService.updateAsset(asset)) {
				System.out.println("Asset updated successfully.");
			}
			else {
				System.out.println("Failed to update asset.");
			}
	
		}
		
		private static void deleteAsset(Scanner scanner)throws AssetNotFoundException {
			System.out.println("Enter Asset ID:");
			int asset_id = scanner.nextInt();
			
			if(assetManagementService.deleteAsset(asset_id)) {
				System.out.println("Asset deleted Successfully");
			}
			else {
				System.out.println("Failed to delete Asset");
			}
		}
		
		private static void allocateAsset(Scanner scanner)throws AssetNotFoundException {
			
			
			System.out.print("Allocation Date (YYYY-MM-DD): ");
		    String AllocationDate = scanner.nextLine();
			Date allocation_date=null;
			try {
		        allocation_date = new SimpleDateFormat("yyyy-MM-dd").parse(AllocationDate);
		    } catch (ParseException e) {
		        System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
		        return; // Exit method if date format is invalid
		    }
		    java.sql.Date sqlallocation_date = new java.sql.Date(allocation_date.getTime());
		    
		    System.out.println("Enter Asset ID: ");
			int asset_id=scanner.nextInt();
			System.out.println("Enter Employee ID: ");
			int employee_id=scanner.nextInt();
			System.out.println("");
		    
			if(assetManagementService.allocateAsset(asset_id,employee_id, sqlallocation_date)) {
				System.out.println("Asset allocated Successfully");
			}
			else {
				System.out.println("Failed to allocate Asset");
			}
			
			
		}
		
		private static void deallocateAsset(Scanner scanner) throws AssetNotFoundException {
			System.out.print("Return Date (YYYY-MM-DD): ");
		    String ReturnDate = scanner.nextLine();
			Date return_date=null;
			try {
		        return_date = new SimpleDateFormat("yyyy-MM-dd").parse(ReturnDate);
		    } catch (ParseException e) {
		        System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
		        return; // Exit method if date format is invalid
		    }
		    java.sql.Date sqlreturn_date = new java.sql.Date(return_date.getTime());
		    
		    System.out.println("Enter Asset ID: ");
			int asset_id=scanner.nextInt();
			System.out.println("Enter Employee ID: ");
			int employee_id=scanner.nextInt();
			System.out.println("");
		    
			if(assetManagementService.deallocateAsset(asset_id,employee_id, sqlreturn_date)) {
				System.out.println("Asset deallocated Successfully");
			}
			else {
				System.out.println("Failed to deallocate Asset");
			}
			
		}

		 private static void reserveAsset(Scanner scanner)throws AssetNotFoundException {
				System.out.println("Enter asset ID");
				int asset_id = scanner.nextInt();
				System.out.println("Employee ID");
				int employee_id = scanner.nextInt();
				System.out.println("");
				scanner.nextLine();
				
				System.out.println("Enter Reservation Date (yyyy-MM-dd)");
				String reservationDAteStr =scanner.nextLine();
				Date reservationDate =null;
				try { reservationDate = new SimpleDateFormat("yyyy-MM-dd").parse(reservationDAteStr);
				}catch(ParseException e) { System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format");
					 return;	
				}
				java.sql.Date sqlreservationDate =new java.sql.Date(reservationDate.getTime());
				
				
				System.out.println("Enter Start Date");
				String startDateStr =scanner.nextLine();
				Date StartDate =null;
				try {
					StartDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);
				}
				catch(ParseException e){
					System.out.println("Invalid Date Format . Please enter date in YYYY-MM-DD format");
					return;
				}
				java.sql.Date sqlstartDate = new java.sql.Date(StartDate.getTime());
				
				System.out.println("Enter End Date");
				String enddateStr =scanner.nextLine();
				Date EndDate =null;
				try {
					EndDate = new SimpleDateFormat("yyyy-MM-dd").parse(enddateStr);
				}catch(ParseException e) {
					System.out.println("Invalid Date Format . Please enter date in YYYY-MM-DD format");
					return;
				}
				java.sql.Date sqlendDate = new java.sql.Date(EndDate.getTime());
				
				
				if(assetManagementService.reserveAsset(asset_id,employee_id,sqlreservationDate,sqlstartDate,sqlendDate)) {
					System.out.println("Asset Reserved Successfully");
				}
				else {
					System.out.println("Failed to Reserve Asset");
				}
			}

			private static void performMaintenance(Scanner scanner) throws AssetNotFoundException, AssetNotMaintainedException{
				System.out.println("Ente Asset ID");
				int asset_id = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Maintainance Date (yyyy-mm-dd)format");
				String M_dateStr= scanner.nextLine();
				Date M_date =null;
				try {
					M_date = new SimpleDateFormat("yyyy-MM-dd").parse(M_dateStr);
				}
				catch(ParseException e) {
					System.out.println("Invalid Date Format . Please enter date in YYYY-MM-DD format");
					return;
				}
				java.sql.Date sqlM_date = new java.sql.Date(M_date.getTime());
				
				System.out.println(" Enter Description");
				String Description = scanner.nextLine();
				
				System.out.println(" Enter Cost");
				Double cost=scanner.nextDouble();
				
				if(assetManagementService.performMaintenance(asset_id, sqlM_date,Description,cost)) {
					System.out.println("Added Maintainance Record Succesfully");
				}
				else {
					System.out.println("Failed to add Maintainance Record");
				}

				
			}
			
			private static void withdrawReservation(Scanner scanner) {
				System.out.println("Enter Reservation ID");
				int reservationID = scanner.nextInt();
				
				if(assetManagementService.withdrawReservation(reservationID)) {
					System.out.println("Reservation Withdrawl Successful");
				}
				else {
					System.out.println("Fail to withdrawl reservation");
				}
				
			}

			

			

			

			
}
