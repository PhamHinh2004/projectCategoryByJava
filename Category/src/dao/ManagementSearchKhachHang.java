package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lib.ConnectDatabase;
import model.KhachHang;

public class ManagementSearchKhachHang {
	
	private ArrayList<KhachHang> ds;

    public ManagementSearchKhachHang()
    {
        ds = new ArrayList<KhachHang>();
    }
    
	
    public void addDuLieuTuDatabase() {
    	try {
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			Statement state = c.createStatement();
			
			ResultSet result = state.executeQuery("select * from KhachHang");
			
			while(result.next()) {
				String maKhachHang = result.getString(1);
				String ten = result.getString(2);
				String sdt = result.getString(3);
				String diaChi = result.getString(4);
				String gioiTinh = result.getString(5);
				KhachHang kh = new KhachHang(maKhachHang, ten, sdt, diaChi, gioiTinh);
				
				if(ds.contains(kh)) {
					System.out.println("Da bi trung");
				}
				else {
					ds.add(kh);
				}
			}
			con.closeConnectionDatabase(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public ArrayList<KhachHang> getList(){
    	return ds;
    }
    
	public KhachHang timTheoMaKH(String id)
    {
    	for(KhachHang x: ds)
    		if(x.getMaKH().equals(id))
    			return x;
    	return null;
    }
    
    public boolean  timTheoMaKHDataBase(KhachHang kh){
    	try {	
			String maKhachHang = kh.getMaKH();
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			String sql = "SELECT FROM KhachHang WHERE maKH = ?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, maKhachHang);
			pstmt.executeUpdate();
			con.closeConnectionDatabase(c);
			   return true;
		} catch (SQLException e) {
			return false;
		}
    }
    
    public KhachHang timTheoTenKH(String ten)
    {
    	for(KhachHang x: ds)
    		if(x.getTen().trim().equalsIgnoreCase(ten))
    			return x;
    	return null;
    }
    
    public boolean  timTheoTenKHDataBase(KhachHang kh){
    	try {	
			String ten = kh.getTen();
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			String sql = "SELECT FROM KhachHang WHERE ten = ?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, ten);
			pstmt.executeUpdate();
			con.closeConnectionDatabase(c);
			   return true;
		} catch (SQLException e) {
			return false;
		}
    }
    
    public boolean timKiemTheoMa(String ma) {
    	try {	
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			Statement state = c.createStatement();
			ResultSet rs = state.executeQuery("select * from KhachHang where maKH like " + "'%"+ma+"%'");
			while(rs.next()) {
				String maKhachHang = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String diaChi = rs.getString(4);
				String gioiTinh = rs.getString(5);
				KhachHang kh = new KhachHang(maKhachHang, ten, sdt, diaChi, gioiTinh);
				
				if(ds.contains(kh)) {
					System.out.println("Da bi trung");
				}
				else {
					ds.add(kh);
				}
			}
			con.closeConnectionDatabase(c);
			 return true;
		} catch (SQLException e) {
			return false;
		}
    }
    
    public boolean timKiemTen(String ten) {
    	try {	
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			Statement state = c.createStatement();
			ResultSet rs = state.executeQuery("select * from KhachHang where ten like N'%"+ten+"%' ");
			while(rs.next()) {
				String maKhachHang = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				String sdt = rs.getString(3);
				String diaChi = rs.getString(4);
				String gioiTinh = rs.getString(5);
				KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, sdt, diaChi, gioiTinh);
				
				if(ds.contains(kh)) {
					System.out.println("Da bi trung");
				}
				else {
					ds.add(kh);
				}
			}
			con.closeConnectionDatabase(c);
			 return true;
		} catch (SQLException e) {
			return false;
		}
    }
    
    public boolean timKiemSDT(String sdt) {
    	try {	
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			Statement state = c.createStatement();
			ResultSet rs = state.executeQuery("select * from KhachHang where soDienThoai like " + "N'%"+sdt+"%'");
			while(rs.next()) {
				String maKhachHang = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				String soDienThoai = rs.getString(3);
				String diaChi = rs.getString(4);
				String gioiTinh = rs.getString(5);
				KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, soDienThoai, diaChi, gioiTinh);
				
				if(ds.contains(kh)) {
					System.out.println("Da bi trung");
				}
				else {
					ds.add(kh);
				}
			}
			con.closeConnectionDatabase(c);
			 return true;
		} catch (SQLException e) {
			return false;
		}
    }
}
