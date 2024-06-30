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
import model.DoanhThu;
import model.KhachHang;
import model.NhanVien;

public class ManagementKhachHang {

	private ArrayList<KhachHang> ds;

    public ManagementKhachHang()
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
    
    public boolean kiemTra(KhachHang kh) {
    	if(ds.contains(kh)) {
    		return false;
    	}
    	return true;
    }
    
    public boolean themVaoList(KhachHang kh) {
    	if(kiemTra(kh)) {
    		if(	this.themVaoDataBase(kh)) {
    			this.ds.add(kh);
    			return true;
    		}		
    	}
    	return false;
    }
    
    public boolean themVaoDataBase(KhachHang khachHang) {
			try {
				String maKhachHang = khachHang.getMaKH();
				String ten = khachHang.getTen();
				String sdt = khachHang.getSoDienThoai();
				String diaChi = khachHang.getDiaChi();
				String gioiTinh = khachHang.getGioiTinh();
				
			ConnectDatabase con = new ConnectDatabase();
				Connection c = con.openConnectionDatabase();
				String sql = "INSERT INTO KhachHang (maKH, ten, soDienThoai, diaChi, gioiTinh) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement pstmt = c.prepareStatement(sql);
				pstmt.setString(1, maKhachHang);
				pstmt.setString(2, ten);
				pstmt.setString(3, sdt);
				pstmt.setString(4, diaChi);
				pstmt.setString(5, gioiTinh);
				pstmt.executeUpdate();
			con.closeConnectionDatabase(c);
			return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				return false;
			}
    }
    
    public boolean xoaKhachHang(KhachHang kh) {
			if(this.kiemTra(kh)==false) {
				if(!this.xoaDataBase(kh)) {
					return false;
				}
				this.ds.remove(kh);
			}
			return true;
    }
    
    public int getLocation(KhachHang kh) {
    	return ds.indexOf(kh);
    }
    
    public boolean  xoaDataBase(KhachHang kh){
    	try {	
			String maKhachHang = kh.getMaKH();
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			String sql = "DELETE FROM KhachHang WHERE maKH = ?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, maKhachHang);
			pstmt.executeUpdate();
			con.closeConnectionDatabase(c);
			   return true;
		} catch (SQLException e) {
			return false;
		}
    }
    
    public boolean updateKhachHang(KhachHang kh) {
    	for (KhachHang khachHang : ds) {
			if(khachHang.getMaKH().compareToIgnoreCase(kh.getMaKH())==0) {
				khachHang.setTen(kh.getTen());
				khachHang.setDiaChi(kh.getDiaChi());
				khachHang.setGioiTinh(kh.getGioiTinh());
				khachHang.setSoDienThoai(kh.getSoDienThoai());
				return true;
			}
		}
    	return false;
    }
    
    public boolean updateDatabase(KhachHang kh) {
		try {
			String maKhachHang = kh.getMaKH();
			String ten = kh.getTen();
			String sdt = kh.getSoDienThoai();
			String diaChi = kh.getDiaChi();
			String gioiTinh = kh.getGioiTinh();
			ConnectDatabase con = new ConnectDatabase();
			Connection c = con.openConnectionDatabase();
			String sql = "UPDATE KhachHang SET ten = ?, soDienThoai = ?, diaChi = ?, gioiTinh = ? WHERE maKH = ?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, ten);
			pstmt.setString(2, sdt);
			pstmt.setString(3, diaChi);
			pstmt.setString(4, gioiTinh);
			pstmt.setString(5, maKhachHang);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }

	

}
