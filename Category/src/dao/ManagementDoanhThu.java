package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lib.ConnectDatabase;
import model.Account;
import model.DoanhThu;

public class ManagementDoanhThu {
	ArrayList<DoanhThu> list ;
	ConnectDatabase connect;
	public ManagementDoanhThu() {
		this.list = new ArrayList<>();
		this.connect = new ConnectDatabase();
	}
	
	public void add() {
		try {
			Connection c = this.connect.openConnectionDatabase();
			
			// step 2 tạo một đối tượng statement
			Statement state = c.createStatement();
			
			// step 3 excute 
			ResultSet result = state.executeQuery("select maSP, sp.ten , ncc.ten, sum(ct.soLuong*ct.donGia) from NhaCungCap ncc  join SanPham sp on ncc.maNCC = sp.maNCC\r\n"
					+ "			join ChiTietHoaDon ct on sp.maSanPham = ct.maSP\r\n"
					+ "			join HoaDon hd on  ct.maHoaDon = hd.maHoaDon\r\n"
					+ "			group by maSP, sp.ten , ncc.ten , ct.donGia, ct.soLuong");
			
			// step 4 excute từng account
			while(result.next()) {
				String maSanPham = result.getString(1);
				String ten = result.getString(2);
				String nhaCungCap = result.getString(3);
				double doanhThu = Double.parseDouble(result.getString(4));
				DoanhThu d = new DoanhThu(maSanPham, ten, doanhThu, nhaCungCap);
				if(list.contains(d)) {
					System.out.println("Đã bị trùng");
				}
				else {
					list.add(d);
				}
			}
			this.connect.closeConnectionDatabase(c);
																																		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<DoanhThu> getList(){
		return list;
	}
}
