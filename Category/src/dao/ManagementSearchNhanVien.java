package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lib.ConnectDatabase;
import model.KhachHang;
import model.NhanVien;

public class ManagementSearchNhanVien {
	
	private ArrayList<NhanVien> ds;

    public ManagementSearchNhanVien()
    {
        ds = new ArrayList<NhanVien>();
    }
    
	
    public void addDuLieuTuDatabase() {
    	try {
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			Statement state = c.createStatement();
			
			ResultSet result = state.executeQuery("select * from Nhanvien");
			
			while(result.next()) {
				String maNhanVien = result.getString(1);
				String ten = result.getString(2);
				String sdt = result.getString(3);
				String diaChi = result.getString(4);
				String gioiTinh = result.getString(5);
				NhanVien kh = new NhanVien(maNhanVien, ten, sdt, diaChi, gioiTinh);
				
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
    
    public ArrayList<NhanVien> getList(){
    	return ds;
    }
    
	public NhanVien timTheoMaNV(String id)
    {
    	for(NhanVien x: ds)
    		if(x.getMaNV().equals(id))
    			return x;
    	return null;
    }
    
    public boolean  timTheoMaNVDataBase(NhanVien nv){
    	try {	
			String maNhanVien = nv.getMaNV();
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			String sql = "SELECT * FROM Nhanvien WHERE maNV = ?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, maNhanVien);
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
			ResultSet rs = state.executeQuery("select * from Nhanvien where maNV like " + "N'%"+ma+"%'");
			while(rs.next()) {
				String maKhachHang = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String diaChi = rs.getString(4);
				String gioiTinh = rs.getString(5);
				NhanVien nv = new NhanVien(maKhachHang, ten, sdt, diaChi, gioiTinh);
				
				if(ds.contains(nv)) {
					System.out.println("Da bi trung");
				}
				else {
					ds.add(nv);
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
			ResultSet rs = state.executeQuery("select * from Nhanvien where ten like N'%"+ten+"%' ");
			while(rs.next()) {
				String maKhachHang = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				String sdt = rs.getString(3);
				String diaChi = rs.getString(4);
				String gioiTinh = rs.getString(5);
				NhanVien nv = new NhanVien(maKhachHang, tenKhachHang, sdt, diaChi, gioiTinh);
				
				if(ds.contains(nv)) {
					System.out.println("Da bi trung");
				}
				else {
					ds.add(nv);
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
			ResultSet rs = state.executeQuery("select * from Nhanvien where soDienThoai like " + "N'%"+sdt+"%'");
			while(rs.next()) {
				String maKhachHang = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				String soDienThoai = rs.getString(3);
				String diaChi = rs.getString(4);
				String gioiTinh = rs.getString(5);
				NhanVien nv = new NhanVien(maKhachHang, tenKhachHang, soDienThoai, diaChi, gioiTinh);
				
				if(ds.contains(nv)) {
					System.out.println("Da bi trung");
				}
				else {
					ds.add(nv);
				}
			}
			con.closeConnectionDatabase(c);
			 return true;
		} catch (SQLException e) {
			return false;
		}
    }
    
}
