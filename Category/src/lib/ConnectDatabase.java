	package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	public Connection openConnectionDatabase() {
		Connection c = null;
		
		 try {
			 // cung cấp địa chỉ sql server 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			// cung cấp địa chỉ tên sql server
			String url = "jdbc:sqlserver://PHAMHINH\\SQLEXPRESS:1433;databaseName =Grocery;encrypt=true;trustServerCertificate=true";
			String userName = "sa";				
			String password = "hinh12345";
			
			c = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return c;
	}
	public void closeConnectionDatabase(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
