package model;

import java.util.Objects;

public class DoanhThu {
	private String masanPham ;
	private String tenSanPham;
	private int month;
	private int year;
	private double doanhThu;
	private String nhaCungCap;
	
	public DoanhThu(String masanPham, String tenSanPham, int month, int year, double doanhThu) {
		super();
		this.masanPham = masanPham;
		this.tenSanPham = tenSanPham;
		this.month = month;
		this.year = year;
		this.doanhThu = doanhThu;
	}
	
	
	public DoanhThu(String masanPham, String tenSanPham, double doanhThu, String nhaCungCap) {
		super();
		this.masanPham = masanPham;
		this.tenSanPham = tenSanPham;
		this.doanhThu = doanhThu;
		this.nhaCungCap = nhaCungCap;
	}


	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}


	public String getMasanPham() {
		return masanPham;
	}

	public void setMasanPham(String masanPham) {
		this.masanPham = masanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(masanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoanhThu other = (DoanhThu) obj;
		return Objects.equals(masanPham, other.masanPham);
	}
	
	
}
