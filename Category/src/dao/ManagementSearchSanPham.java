package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lib.ConnectDatabase;
import model.*;

public class ManagementSearchSanPham {
	
	private ArrayList<SanPham> ds;

    public ManagementSearchSanPham()
    {
        ds = new ArrayList<SanPham>();
    }
    
	
    public void addDuLieuTuDatabase() {
    	try {
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			Statement state = c.createStatement();
			
			ResultSet rs = state.executeQuery("select maSanPham, sp.ten, hanSuDung, donViTinh, donGia, ncc.ten, soLuong, trongLuong \r\n"
					+ "	from SanPham sp join  NhaCungCap ncc on sp.maNCC = ncc.maNCC ");
			
			while(rs.next()) {
			String maSanPham = rs.getString(1);
			String tenSanPham = rs.getString(2);
			String hsd = rs.getString(3);
			String donViTinh = rs.getString(4);
			double donGia = Double.parseDouble(rs.getString(5));
			String tenNhaCungCap = rs.getString(6);
			int soLuong = Integer.parseInt(rs.getString(7));
			int trongLuong = Integer.parseInt(rs.getString(8));
			
			SanPham sp = new SanPham(maSanPham, tenSanPham, hsd, donViTinh, donGia, tenNhaCungCap, soLuong, trongLuong);
			
			if(ds.contains(sp)) {
				System.out.println("Da bi trung");
			}
			else {
				ds.add(sp);
			}
		}
			con.closeConnectionDatabase(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    
 
	public boolean timKiemTheoMa(String ma) {
		try {	
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			Statement state = c.createStatement();
			ResultSet rs = state.executeQuery("select maSanPham, sp.ten, hanSuDung, donViTinh, donGia, ncc.ten, soLuong, trongLuong \r\n"
					+ "	from SanPham sp join  NhaCungCap ncc on sp.maNCC = ncc.maNCC \r\n"
					+ "	where maSanPham like N'%" + ma+ "%'");
			while(rs.next()) {
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				String hsd = rs.getString(3);
				String donViTinh = rs.getString(4);
				double donGia = Double.parseDouble(rs.getString(5));
				String tenNhaCungCap = rs.getString(6);
				int soLuong = Integer.parseInt(rs.getString(7));
				int trongLuong = Integer.parseInt(rs.getString(8));
				
				SanPham sp = new SanPham(maSanPham, tenSanPham, hsd, donViTinh, donGia, tenNhaCungCap, soLuong, trongLuong);
				
				if(ds.contains(sp)) {
					System.out.println("Da bi trung");
				}
				else {
					ds.add(sp);
				}
			}
			con.closeConnectionDatabase(c);
			 return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public boolean timKiemTheoTen(String ten) {
		try {	
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			Statement state = c.createStatement();
			ResultSet rs = state.executeQuery("select maSanPham, sp.ten, hanSuDung, donViTinh, donGia, ncc.ten, soLuong, trongLuong \r\n"
					+ "	from SanPham sp join  NhaCungCap ncc on sp.maNCC = ncc.maNCC \r\n"
					+ "	where sp.ten like N'%" + ten+ "%'");
			while(rs.next()) {
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				String hsd = rs.getString(3);
				String donViTinh = rs.getString(4);
				double donGia = Double.parseDouble(rs.getString(5));
				String tenNhaCungCap = rs.getString(6);
				int soLuong = Integer.parseInt(rs.getString(7));
				int trongLuong = Integer.parseInt(rs.getString(8));
				
				SanPham sp = new SanPham(maSanPham, tenSanPham, hsd, donViTinh, donGia, tenNhaCungCap, soLuong, trongLuong);
				
				if(ds.contains(sp)) {
					System.out.println("Da bi trung");
				}
				else {
					ds.add(sp);
				}
			}
			con.closeConnectionDatabase(c);
			 return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	public ArrayList<SanPham> getList(){
		return ds;
	}
}
