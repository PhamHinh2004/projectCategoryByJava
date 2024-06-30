package model;

import java.util.Objects;

public class SanPham {
	private String maSanPham ;
	private String ten;
	private String hanSuDung;
	private String donViTinh;
	private double donGia;
	private String maNCC;
	private int  soLuong;
	private int trongLuong;
	
	public SanPham(String maSanPham, String ten, String hanSuDung, String donViTinh, double donGia, String maNCC,
			int soLuong, int trongLuong) {
		super();
		this.maSanPham = maSanPham;
		this.ten = ten;
		this.hanSuDung = hanSuDung;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
		this.maNCC = maNCC;
		this.soLuong = soLuong;
		this.trongLuong = trongLuong;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getHanSuDung() {
		return hanSuDung;
	}

	public void setHanSuDung(String hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(int trongLuong) {
		this.trongLuong = trongLuong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSanPham, other.maSanPham);
	}
	
	
}
