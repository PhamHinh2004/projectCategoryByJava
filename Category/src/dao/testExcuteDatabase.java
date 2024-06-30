package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lib.ConnectDatabase;

public class testExcuteDatabase {
	ConnectDatabase connect ;
	public testExcuteDatabase() {
		try {
			this.connect = new ConnectDatabase();
			Connection c = connect.openConnectionDatabase();
			
			Statement state = c.createStatement();
			ResultSet result = state.executeQuery("select ncc.ten from [Nha Cung Cap] ncc join [San Pham] s on ncc.maNCC = s.maNCC");
			while(result.next()) {
				System.out.println(result.getString(1));
			}
			this.connect.closeConnectionDatabase(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
