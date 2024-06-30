package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lib.ConnectDatabase;
import model.Account;
import model.DoanhThu;

public class ManagementDoanhThuTheoThang {
	ArrayList<DoanhThu> list ;
	ConnectDatabase connect;
	public ManagementDoanhThuTheoThang() {
		this.list = new ArrayList<>();
		this.connect = new ConnectDatabase();
	}
	
	public void add() {
		try {
			Connection c = this.connect.openConnectionDatabase();
			
			// step 2 tạo một đối tượng statement
			Statement state = c.createStatement();
			
			// step 3 excute 
			ResultSet result = state.executeQuery("select maSP, ten, MONTH(ngayTao), YEAR(ngayTao) , sum(ct.soLuong*ct.donGia) from SanPham sp join ChiTietHoaDon ct on sp.maSanPham = ct.maSP join HoaDon hd on  ct.maHoaDon = hd.maHoaDon	\r\n"
					+ "	group by maSP, ten , ngayTao, ct.soLuong, ct.donGia");			
			
			// step 4 excute từng account
			while(result.next()) {
				String maSanPham = result.getString(1);
				String ten = result.getString(2);
				int month = Integer.parseInt(result.getString(3));
				int year = Integer.parseInt(result.getString(4));
				double doanhThu = Double.parseDouble(result.getString(5));
				DoanhThu d = new DoanhThu(maSanPham, ten, month, year, doanhThu);
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
	
	public void addListTheoThang( int thang , int nam) {
		try {
			Connection c = this.connect.openConnectionDatabase();
			
			// step 2 tạo một đối tượng statement
			String sql = "SELECT sp.maSP, sp.ten, MONTH(hd.ngayTao) AS Thang, YEAR(hd.ngayTao) AS Nam, SUM(ct.soLuong * ct.donGia) AS TongTien " +
		             "FROM SanPham sp " +
		             "JOIN ChiTietHoaDon ct ON sp.maSanPham = ct.maSP " +
		             "JOIN HoaDon hd ON ct.maHoaDon = hd.maHoaDon " +
		             "WHERE MONTH(hd.ngayTao) = ? AND YEAR(hd.ngayTao) = ? " +
		             "GROUP BY sp.maSP, sp.ten, MONTH(hd.ngayTao), YEAR(hd.ngayTao)";
				
			Statement statement = c.createStatement();
			ResultSet rs = statement.executeQuery("select maSP, ten, MONTH(ngayTao), YEAR(ngayTao) , sum(ct.soLuong*ct.donGia) from SanPham sp join ChiTietHoaDon ct on sp.maSanPham = ct.maSP join HoaDon hd on  ct.maHoaDon = hd.maHoaDon	\r\n"
					+ "	where  MONTH(ngayTao) = " + thang + " and YEAR(ngayTao) = " + nam + "\r\n"
					+ "	group by maSP, ten , ngayTao, ct.soLuong, ct.donGia");
		
				// Xử lý kết quả
				while (rs.next()) {
					// Lấy thông tin từ kết quả
					String maSanPham = rs.getString(1);
					String ten = rs.getString(2);
					int month = Integer.parseInt(rs.getString(3));
					int year = Integer.parseInt(rs.getString(4));
					double doanhThu = Double.parseDouble(rs.getString(5));
					
					DoanhThu d = new DoanhThu(maSanPham, ten, month, year, doanhThu);
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
