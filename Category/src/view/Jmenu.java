package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Jmenu_ACtion;

public class Jmenu extends JFrame{
	public Jmenu() {
		this.setSize(800, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar bar = new JMenuBar();
		Font fontSize = new Font("Arial", Font.BOLD, 20);
		// systerm 
		JMenu systerm = new JMenu("Hệ thống");
		systerm.setFont(fontSize);
		JMenuItem signOut = new JMenuItem("Đăng Xuất");
		signOut.setFont(fontSize);
		JMenuItem close = new JMenuItem("Đóng");
		
		close.setFont(fontSize);
		systerm.add(signOut);
		systerm.add(close);
		
		// sản phẩm
		JMenu product = new JMenu("Sản Phẩm");
		product.setFont(fontSize);
		JMenuItem managementProduct = new JMenuItem("Quản lí sản phẩm");
		managementProduct.setFont(fontSize);
		JMenuItem findProduct = new JMenuItem("Tìm kiếm");
		findProduct.setFont(fontSize);
		JMenuItem loaiSanPham = new JMenuItem("Loại sản phẩm");
		loaiSanPham.setFont(fontSize);
		JMenuItem nhaCC = new JMenuItem("Nhà cung cấp");
		nhaCC.setFont(fontSize);
		
		product.add(managementProduct);
		product.add(findProduct);
		product.add(loaiSanPham);
		product.add(nhaCC);
		
		// Hoa đơn 
		JMenu hoaDon = new JMenu("Hóa đơn");
		hoaDon.setFont(fontSize);
		JMenuItem quanLiHoaDon = new JMenuItem("Quản lí hóa đơn");
		quanLiHoaDon.setFont(fontSize);
		
		hoaDon.add(quanLiHoaDon);
		
		// Nhân viên
		JMenu nhanVien = new JMenu("Nhân Viên");
		nhanVien.setFont(fontSize);
		JMenuItem quanLiNhanVien = new  JMenuItem("Quản lí Nhân Viên");
		quanLiNhanVien.setFont(fontSize);
		JMenuItem findNhanVien = new JMenuItem("Tìm kiếm Nhân Viên");
		findNhanVien.setFont(fontSize);
		nhanVien.add(quanLiNhanVien);
		nhanVien.add(findNhanVien);
		
		// khách hàng
		JMenu khachHang = new JMenu("Khách hàng");
		khachHang.setFont(fontSize);
		JMenuItem quanLiKhachHang = new  JMenuItem("Quản lí khách hàng");
		quanLiKhachHang.setFont(fontSize);
		JMenuItem finKhachHang = new JMenuItem("Tìm kiếm khách hàng");
		finKhachHang.setFont(fontSize);
		khachHang.add(quanLiKhachHang);
		khachHang.add(finKhachHang);
		
		//báo cáo 
		JMenu baoCao = new  JMenu("Báo cáo");
		baoCao.setFont(fontSize);
		JMenuItem baoCaoTheoThang = new  JMenuItem("Báo cáo theo tháng");
		baoCaoTheoThang.setFont(fontSize);
		JMenuItem baoCaoDoanhThu = new  JMenuItem("Báo cáo Doanh thu");
		baoCaoDoanhThu.setFont(fontSize);
		baoCao.add(baoCaoTheoThang);
		baoCao.add(baoCaoDoanhThu);
		
		bar.add(systerm);
		bar.add(product);
		bar.add(nhanVien);
		bar.add(khachHang);
		bar.add(baoCao);
		
		this.setJMenuBar(bar);
		this.setVisible(true);
		
		//add action 
		ActionListener ac = new Jmenu_ACtion(this);
		signOut.addActionListener(ac);
		close.addActionListener(ac);
		managementProduct.addActionListener(ac);
		findProduct.addActionListener(ac);
		loaiSanPham.addActionListener(ac);
		nhaCC.addActionListener(ac);
		quanLiHoaDon.addActionListener(ac);
		quanLiNhanVien.addActionListener(ac);
		findNhanVien.addActionListener(ac);
		quanLiKhachHang.addActionListener(ac);
		finKhachHang.addActionListener(ac);
		baoCaoTheoThang.addActionListener(ac);
		baoCaoDoanhThu.addActionListener(ac);
	}
}
