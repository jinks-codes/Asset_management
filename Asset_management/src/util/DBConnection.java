
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private static final String url = "jdbc:mysql://localhost:3307/asset_management?"
                + "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String userName = "root";
    private static final String password = "895627@Aj";

    // Method to get a database connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to the database successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // Method to close a database connection
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

