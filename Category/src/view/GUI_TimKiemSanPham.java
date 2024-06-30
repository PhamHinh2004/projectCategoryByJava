package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.*;
import dao.*;
import model.*;


public class GUI_TimKiemSanPham extends JFrame {

	public  JPanel pnNorth, pnCenter;
	public JPanel pnTitle;
	public JLabel lbTitle;
	public JLabel lbTen;
	public JTextField textTen;
	public JPanel pnText;
	public Container pnTen;
	public JPanel pnWest;
	public JPanel pnCase;
	public JButton btnThem;
	public JButton btnXoa;
	public JPanel pnTopCase;
	public JButton btnSua;
	public JButton btnRefesh;
	public JPanel pnBotCase;
	public JPanel pnContainerCase;
	public ButtonGroup group;
	public JTextField textPhai;
	public JButton btnTimKiem;
	public JPanel pnMaSP;
	public JLabel lbMaSP;
	public JTextField textMaSP;
	public JPanel pnHSD;
	public JLabel lbHSD;
	public JTextField textHSD;
	public JPanel pnDonViTinh;
	public JLabel lbDonViTinh;
	public JTextField textDonViTinh;
	public JPanel pnTrongLuong;
	public JLabel lbTrongLuong;
	public JTextField textTrongLuong;
	public JPanel pnSoLuong;
	public JLabel lbSoLuong;
	public JTextField textSoLuong;
	public JPanel pnNCC;
	public JLabel lbNCC;
	public JTextField textNCC;
	public JPanel pnDonGia;
	public JLabel lbDonGia;
	public JTextField textDonGia;
	public DefaultTableModel modelSP;
	public JTable tableSP;
	public ManagementSearchSanPham search;
	private Icon icon;
	public GUI_TimKiemSanPham() {
		this.search = new ManagementSearchSanPham();

		/*
		 * create 1 menu bar
		 */
		JMenuBar bar = new JMenuBar();
		Font fontSize = new Font("Arial", Font.BOLD, 20);
		
		// systerm 
		JMenu systerm = new JMenu("HỆ THỐNG");
		systerm.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\system.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		systerm.setIcon(icon);
		JMenuItem signOut = new JMenuItem("ĐĂNG XUẤT");
		signOut.setFont(fontSize);
		icon =  new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\images.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		signOut.setIcon(icon);
		JMenuItem close = new JMenuItem("ĐÓNG");
		close.setFont(fontSize);
		icon =  new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\z5378552494510_cc76a869d92ee96074e3b593308c5055.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		close.setIcon(icon);
		JMenuItem home = new JMenuItem("TRANG CHỦ");
		home.setFont(fontSize);
        icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\z5378543057473_19f299666e9775ed276966e668568934.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        home.setIcon(icon);	
        
        systerm.add(home);
		systerm.add(signOut);
		systerm.add(close);
//		
		// sản phẩm
		JMenu product = new JMenu("SẢN PHẨM");
		product.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\product.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		product.setIcon(icon);
		JMenuItem managementProduct = new JMenuItem("QUẢN LÍ SẢN PHẨM");
		managementProduct.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\quanLiSp.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		managementProduct.setIcon(icon);
		JMenuItem findProduct = new JMenuItem("TÌM KIẾM SẢN PHẨM");
		findProduct.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\finSP.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		findProduct.setIcon(icon);
		JMenuItem nhaCC = new JMenuItem("NHÀ CUNG CẤP");
		nhaCC.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\ncc.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		nhaCC.setIcon(icon);
		product.add(managementProduct);
		product.add(findProduct);
		product.add(nhaCC);
		
		// Hoa đơn 
		JMenu hoaDon = new JMenu("HÓA ĐƠN");
		hoaDon.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\hoaDon.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		hoaDon.setIcon(icon);
		JMenuItem quanLiHoaDon = new JMenuItem("QUẢN LÍ HÓA ĐƠN");
		quanLiHoaDon.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\qlHoaDon.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		quanLiHoaDon.setIcon(icon);
		hoaDon.add(quanLiHoaDon);
		
		// Nhân viên
		JMenu nhanVien = new JMenu("NHÂN VIÊN");
		nhanVien.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\nv.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		nhanVien.setIcon(icon);
		JMenuItem quanLiNhanVien = new  JMenuItem("QUẢN LÍ NHÂN VIÊN");
		quanLiNhanVien.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\qlnv.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		quanLiNhanVien.setIcon(icon);
		
		JMenuItem findNhanVien = new JMenuItem("TÌM KIẾM NHÂN VIÊN");
		findNhanVien.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\findnv.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		findNhanVien.setIcon(icon);
		nhanVien.add(quanLiNhanVien);
		nhanVien.add(findNhanVien);
		
		// khách hàng
		JMenu khachHang = new JMenu("KHÁCH HÀNG");
		khachHang.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\kh.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		khachHang.setIcon(icon);
		JMenuItem quanLiKhachHang = new  JMenuItem("QUẢN LÍ KHÁCH HÀNG");
		quanLiKhachHang.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\qlKH.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		quanLiKhachHang.setIcon(icon);
		JMenuItem finKhachHang = new JMenuItem("TÌM KIẾM KHÁCH HÀNG");
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\findkh.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		finKhachHang.setIcon(icon);
		finKhachHang.setFont(fontSize);
		khachHang.add(quanLiKhachHang);
		khachHang.add(finKhachHang);
		
		//báo cáo 
		JMenu baoCao = new  JMenu("BÁO CÁO");
		baoCao.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\baocao.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		baoCao.setIcon(icon);
		JMenuItem baoCaoTheoThang = new  JMenuItem("BÁO CÁO THEO THÁNG");
		baoCaoTheoThang.setFont(fontSize);
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\baocaoThang.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		baoCaoTheoThang.setIcon(icon);
		JMenuItem baoCaoDoanhThu = new  JMenuItem("BÁO CÁO DOANH THU");
		icon = new ImageIcon(new ImageIcon("C:\\Users\\phamv\\Downloads\\baoCaoDoanhThu.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		baoCaoDoanhThu.setIcon(icon);
		baoCaoDoanhThu.setFont(fontSize);
		baoCao.add(baoCaoTheoThang);
		baoCao.add(baoCaoDoanhThu);
		
		bar.add(systerm);
		bar.add(new JSeparator());
		bar.add(product);
		bar.add(new JSeparator());
		bar.add(hoaDon);
		bar.add(new JSeparator());
		bar.add(nhanVien);
		bar.add(new JSeparator());
		bar.add(khachHang);
		bar.add(new JSeparator());
		bar.add(baoCao);
		
		this.setJMenuBar(bar);
		
		//Content
		pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		add(pnCenter, BorderLayout.CENTER);

		//Show
		pnWest = new JPanel();
		pnWest.setLayout(new BorderLayout());
		pnWest.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnCenter.add(pnWest, BorderLayout.WEST);
		
		//Text
		pnMaSP = new JPanel();
		pnMaSP.add(lbMaSP = new JLabel("Mã sản phẩm:  "));
		pnMaSP.add(textMaSP = new JTextField(20));
	
		pnTen = new Panel();
		pnTen.add(lbTen = new JLabel("Tên sản phẩm: "));
		pnTen.add(textTen = new JTextField(20));
		
		pnHSD = new JPanel();
		pnHSD.add(lbHSD = new JLabel("Hạn sử dụng:   "));
		pnHSD.add(textHSD = new JTextField(20));
		textHSD.setEnabled(false);
		
		pnDonViTinh = new JPanel();
		pnDonViTinh.add(lbDonViTinh = new JLabel("Đơn vị tính:      "));
		pnDonViTinh.add(textDonViTinh = new JTextField(20));
		textDonViTinh.setEnabled(false);
		
		pnTrongLuong = new JPanel();
		pnTrongLuong.add(lbTrongLuong = new JLabel("Trọng lượng:     "));
		pnTrongLuong.add(textTrongLuong = new JTextField(20));
		textTrongLuong.setEnabled(false);
		
		pnDonGia = new JPanel();
		pnDonGia.add(lbDonGia = new JLabel("Đơn giá:           "));
		pnDonGia.add(textDonGia = new JTextField(20));
		textDonGia.setEnabled(false);
		
		pnSoLuong = new JPanel();
		pnSoLuong.add(lbSoLuong = new JLabel("Số lượng:           "));
		pnSoLuong.add(textSoLuong = new JTextField(20));
		textSoLuong.setEnabled(false);
		
		pnNCC = new JPanel();
		pnNCC.add(lbNCC = new JLabel("Nhà cung cấp:      "));
		pnNCC.add(textNCC = new JTextField(20));
		textNCC.setEnabled(false);
		
		
		
		pnText = new JPanel();
		pnText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Box boxText = Box.createVerticalBox();
		
		boxText.add(pnMaSP);
		boxText.add(Box.createVerticalStrut(20));
		boxText.add(pnTen);
		boxText.add(Box.createVerticalStrut(20));
		boxText.add(pnHSD);
		boxText.add(Box.createVerticalStrut(20));
		boxText.add(pnDonViTinh);
		boxText.add(Box.createVerticalStrut(20));
		boxText.add(pnTrongLuong);
		boxText.add(Box.createVerticalStrut(20));
		boxText.add(pnDonGia);
		boxText.add(Box.createVerticalStrut(20));
		boxText.add(pnSoLuong);
		boxText.add(Box.createVerticalStrut(20));
		boxText.add(pnNCC);
		boxText.add(Box.createVerticalStrut(20));
		
		pnText.add(boxText);
		pnWest.add(pnText, BorderLayout.NORTH);
		
		//case
		pnContainerCase = new JPanel();
		pnContainerCase.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnWest.add(pnContainerCase, BorderLayout.CENTER);
		
		pnCase = new JPanel();
		pnCase.setLayout(new GridLayout(1, 2, 40, 20));
		pnContainerCase.add(pnCase);
		
		pnCase.add(btnTimKiem = new JButton("Tìm kiếm"));
		pnCase.add(btnRefesh = new JButton("Refesh"));
		
		//Title
			pnTitle = new JPanel();
			pnTitle.add(lbTitle = new JLabel("TÌM KIẾM SẢN PHẨM"));
			Font f = new Font("Arial", Font.BOLD, 27);
			lbTitle.setFont(f);
			lbTitle.setForeground(Color.BLUE);
			pnCenter.add(pnTitle, BorderLayout.NORTH);
			
		//table
			String[] cols = {"Mã sản phẩm", "Tên sản phẩm", "Hạn sử dụng", "Trọng Lượng", "Đơn vị tính", "Số lượng", "Đơn giá", "Nhà cung cấp"};
			modelSP = new DefaultTableModel(cols, 0);
			tableSP = new JTable(modelSP);
			JScrollPane scroll;
			pnCenter.add(scroll = new JScrollPane(tableSP), BorderLayout.CENTER);
		
		
			//add action 
			ActionListener ac = new SearchSanPham_Action(this);
			MouseListener mouse = new SearchSanPham_Action(this);
			home.addActionListener(ac);
			signOut.addActionListener(ac);
			close.addActionListener(ac);
			hoaDon.addActionListener(ac);
			managementProduct.addActionListener(ac);
			findProduct.addActionListener(ac);
			nhaCC.addActionListener(ac);
			quanLiHoaDon.addActionListener(ac);
			quanLiNhanVien.addActionListener(ac);
			findNhanVien.addActionListener(ac);
			quanLiKhachHang.addActionListener(ac);
			finKhachHang.addActionListener(ac);
			baoCaoTheoThang.addActionListener(ac);
			baoCaoDoanhThu.addActionListener(ac);
			tableSP.addMouseListener(mouse);
			btnTimKiem.addActionListener(ac);
			btnRefesh.addActionListener(ac);
			
		// setting to show screen
		this.setSize(800, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		/*
		 * 
		 * lấy dữ liệu từ database
		 */
		this.search.addDuLieuTuDatabase();
		this.writeOnTable();
	}
	
	public void refesh() {
		this.modelSP.setRowCount(0);
		this.textMaSP.setText("");
		this.textMaSP.setEditable(true);
		this.textMaSP.setEnabled(true);
		
		this.textTen.setText("");
		this.textTen.setEditable(true);
		this.textTen.setEnabled(true);
					
		 
		this.textHSD.setText("");
		
		this.textDonViTinh.setText("");
		
		this.textTrongLuong.setText("");
		
		this.textSoLuong.setText("");
		
		this.textDonGia.setText("");
		
		this.textNCC.setText("");
		
	}
	
	public void writeOnTable() {
		ArrayList<SanPham> list = this.search.getList();
		for (SanPham sp : list) {
			String maSP = sp.getMaSanPham();
			String ten = sp.getTen();
			String hsd = sp.getHanSuDung();
			String donViTinh = sp.getDonViTinh();
			String soLuong =  String.valueOf(sp.getSoLuong());
			String donGia = String.valueOf(sp.getDonGia());
			String trongLuong = String.valueOf(sp.getTrongLuong());
			String ncc = String.valueOf(sp.getMaNCC());
			
			String object[] = {maSP, ten, hsd, trongLuong, donViTinh, soLuong, donGia , ncc};
			this.modelSP.addRow(object);
		}
	}
	
	
	public void thongTinVaoBang(SanPham sp) {
				this.textTen.setText(sp.getTen());
				this.textMaSP.setText(sp.getMaSanPham());
				this.textMaSP.setEnabled(false);
				this.textHSD.setText(sp.getHanSuDung());
				this.textDonViTinh.setText(sp.getDonViTinh());
				this.textSoLuong.setText(String.valueOf(sp.getSoLuong()));
				this.textDonGia.setText(String.valueOf(sp.getDonGia()));
				this.textTrongLuong.setText(String.valueOf(sp.getTrongLuong()));
				this.textNCC.setText(String.valueOf(sp.getMaNCC()));
				
	}

	public boolean timKiemTheoMa() {
		String ma = this.textMaSP.getText();
		ManagementSearchSanPham manage = new ManagementSearchSanPham();
		manage.timKiemTheoMa(ma);
		ArrayList<SanPham> list = manage.getList();
		this.modelSP.setRowCount(0);
		for (SanPham sp : list) {
			String maSp = sp.getMaSanPham();
			String tenSp = sp.getTen();
			String hsd = sp.getHanSuDung();
			int trongLuong = sp.getTrongLuong();
			String donViTinh = sp.getDonViTinh();
			int soLuong = sp.getSoLuong();
			double donGia = sp.getDonGia();
			String ncc = sp.getMaNCC();
			String object[] = {maSp, tenSp, hsd, trongLuong+"", donViTinh, soLuong+"", donGia+"", ncc};
			this.modelSP.addRow(object);
		}
		if(this.modelSP.getRowCount()!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean timKiemTheoTen() {
		String ten = this.textTen.getText();
		ManagementSearchSanPham manage = new ManagementSearchSanPham();
		manage.timKiemTheoTen(ten);
		ArrayList<SanPham> list = manage.getList();
		this.modelSP.setRowCount(0);
		for (SanPham sp : list) {
			String maSp = sp.getMaSanPham();
			String tenSp = sp.getTen();
			String hsd = sp.getHanSuDung();
			int trongLuong = sp.getTrongLuong();
			String donViTinh = sp.getDonViTinh();
			int soLuong = sp.getSoLuong();
			double donGia = sp.getDonGia();
			String ncc = sp.getMaNCC();
			String object[] = {maSp, tenSp, hsd, trongLuong+"", donViTinh, soLuong+"", donGia+"", ncc};
			this.modelSP.addRow(object);
		}
		if(this.modelSP.getRowCount()!=0) {
			return true;
		}
		else {
			return false;
		}
	}


}

