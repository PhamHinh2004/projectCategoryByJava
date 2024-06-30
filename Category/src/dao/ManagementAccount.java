package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lib.ConnectDatabase;
import model.Account;

public class ManagementAccount {
	ArrayList<Account> list ;
	ConnectDatabase connect;
	public ManagementAccount() {
		this.list = new ArrayList<>();
		this.connect = new ConnectDatabase();
	}
	
	public void add() {
		try {
			Connection c = this.connect.openConnectionDatabase();
			
			// step 2 tạo một đối tượng statement
			Statement state = c.createStatement();
			
			// step 3 excute 
			ResultSet result = state.executeQuery("select * from [dbo].[Account]");
			
			// step 4 excute từng account
			while(result.next()) {
				String id = result.getString(1);
				String username = result.getNString(2);
				String password = result.getNString(3);
				Account account = new Account(id, username, password);
				if(list.contains(account)) {
					System.out.println("Đã bị trùng");
				}
				else {
					list.add(account);
				}
			}
			this.connect.closeConnectionDatabase(c);		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Account> getList(){
		return list;
	}
	
	
}
