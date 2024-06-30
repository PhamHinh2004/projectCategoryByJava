package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lib.ConnectDatabase;
import model.NhanVien;

public class ManagementNhanVien {

	private ArrayList<NhanVien> ds;

    public ManagementNhanVien()
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
				String manhanVien = result.getString(1);
				String ten = result.getString(2);
				String sdt = result.getString(3);
				String diaChi = result.getString(4);
				String gioiTinh = result.getString(5);
				
				NhanVien nv = new NhanVien(manhanVien, ten, sdt, diaChi, gioiTinh);
				
				if(ds.contains(nv)) {
					System.out.println("Da bi trung");
				}
				else {
					ds.add(nv);
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
    
    public boolean kiemTra(NhanVien nv) {
    	if(ds.contains(nv)) {
    		return false;
    	}
    	return true;
    }
    
    public boolean themVaoList(NhanVien nv) {
    		this.ds.add(nv);
    		return this.themVaoDataBase(nv);
    }
    
    public boolean themVaoDataBase(NhanVien nhanVien) {
			try {
				String manhanVien = nhanVien.getMaNV();
				String ten = nhanVien.getTen();
				String sdt = nhanVien.getSoDienThoai();
				String diaChi = nhanVien.getDiaChi();
				String gioiTinh = nhanVien.getGioiTinh();
				
			ConnectDatabase con = new ConnectDatabase();
				Connection c = con.openConnectionDatabase();
				String sql = "INSERT INTO Nhanvien (maNV, ten, soDienThoai, diaChi, gioiTinh) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement pstmt = c.prepareStatement(sql);
				pstmt.setString(1, manhanVien);
				pstmt.setString(2, ten);
				pstmt.setString(3, sdt);
				pstmt.setString(4, diaChi);
				pstmt.setString(5, gioiTinh);
				pstmt.executeUpdate();
			con.closeConnectionDatabase(c);
			return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return false;
			}
    }
    
    public boolean xoaNhanVien(NhanVien nv) {
			if(this.kiemTra(nv)==false) {
				if(!this.xoaDataBase(nv)) {
					return false;
				}
				this.ds.remove(nv);
			}
			return true;
    }
    
    public int getLocation(NhanVien nv) {
    	return ds.indexOf(nv);
    }
    
    public boolean  xoaDataBase(NhanVien nv){
    	try {	
			String manhanVien = nv.getMaNV();
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			String sql = "DELETE FROM Nhanvien WHERE maNV = ?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, manhanVien);
			pstmt.executeUpdate();
			con.closeConnectionDatabase(c);
			   return true;
		} catch (SQLException e) {
			return false;
		}
    }
    
    public boolean updateNhanVien(NhanVien nv) {
    	for (NhanVien nhanVien : ds) {
			if(nhanVien.getMaNV().compareToIgnoreCase(nv.getMaNV())==0) {
				nhanVien.setTen(nv.getTen());
				nhanVien.setDiaChi(nv.getDiaChi());
				nhanVien.setGioiTinh(nv.getGioiTinh());
				nhanVien.setSoDienThoai(nv.getSoDienThoai());
				return true;
			}
		}
    	return false;
    }
    
    public boolean updateDatabase(NhanVien nhanVien) {
		try {
			String manhanVien = nhanVien.getMaNV();
			String ten = nhanVien.getTen();
			String sdt = nhanVien.getSoDienThoai();
			String diaChi = nhanVien.getDiaChi();
			String gioiTinh = nhanVien.getGioiTinh();
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			String sql = "UPDATE Nhanvien SET ten = ?, soDienThoai = ?, diaChi = ?, gioiTinh = ? WHERE maNV = ?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, ten);
			pstmt.setString(2, sdt);
			pstmt.setString(3, diaChi);
			pstmt.setString(4, gioiTinh);
			pstmt.setString(5, manhanVien);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }
    
}
