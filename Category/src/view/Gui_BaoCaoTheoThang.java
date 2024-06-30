package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.BaoCaoTheoThang_ACtion;
import controller.Jmenu_ACtion;
import dao.ManagementAccount;
import dao.ManagementDoanhThuTheoThang;
import model.DoanhThu;

public class Gui_BaoCaoTheoThang extends JFrame{
	 public JTextField textMonth;
	 public JTextField textYear;
	 public JLabel labelDoangThu;
	 public ManagementDoanhThuTheoThang manage;
	 public DefaultTableModel model;
	 public JTable table;
	private ImageIcon icon;
	public Gui_BaoCaoTheoThang() {
		this.setSize(800, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.manage = new ManagementDoanhThuTheoThang();
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
		
		/*
		 *	create giao Diện 
		 *
		 */
		JPanel panelHeading = new JPanel();
		JLabel labelHeading = new JLabel("THỐNG KÊ THEO THÁNG");
		labelHeading.setFont(new Font("Arial",Font.ITALIC, 30));
		labelHeading.setForeground(Color.RED);
		panelHeading.add(labelHeading);
		
		
		/*
		 * tạo table thống kê vào giao diện
		 */
		JPanel panelThongKe = new JPanel();
		Box boxThongKe = Box.createVerticalBox();
		
		// panel chứa các button nhập thông tin tìm kiếm 
		JPanel panelTools = new JPanel();
		panelTools.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Chọn tác vụ"));
		Box boxTools = Box.createHorizontalBox();
		JLabel labelMonth = new JLabel("Tháng");
		labelMonth.setFont(new Font("Arial",Font.BOLD,18));
		textMonth = new  JTextField(15);
		textMonth.setFont(new Font("Arial",Font.BOLD,18));
		JLabel labelYear = new JLabel("Năm");
		labelYear.setFont(new Font("Arial",Font.BOLD,18));
		textYear = new  JTextField(15);
		textYear.setFont(new Font("Arial",Font.BOLD,18));
		JButton buttonFind = new JButton("Tìm kiếm");
		buttonFind.setFont(new Font("Arial",Font.BOLD,18));
		JButton buttonXoaTrang = new  JButton("Xóa trắng");
		buttonXoaTrang.setFont(new Font("Arial",Font.BOLD,18));
		
		boxTools.add(labelMonth);
		boxTools.add(Box.createHorizontalStrut(10));
		boxTools.add(textMonth);
		boxTools.add(Box.createHorizontalStrut(30));
		boxTools.add(labelYear);
		boxTools.add(Box.createHorizontalStrut(10));
		boxTools.add(textYear);
		boxTools.add(Box.createHorizontalStrut(20));
		boxTools.add(buttonFind);
		boxTools.add(Box.createHorizontalStrut(20));
		boxTools.add(buttonXoaTrang);
		boxTools.add(Box.createHorizontalStrut(20));
		panelTools.add(boxTools);
		
		// table
//		JPanel panelTable = new JPanel();
		String heading[] = {"Mã sản phẩm", "Tên sản phẩm", "Tháng", "Năm", "Doanh Thu"};
		model = new DefaultTableModel(heading, 0);
		table = new JTable(model);
		JScrollPane scroll;
		
		/*
		 * panel tổng doanh thu
		 * 
		 */
		JPanel panelTongDoanhThu = new JPanel();
		panelTongDoanhThu.setLayout(new FlowLayout(FlowLayout.LEFT));
		labelDoangThu = new JLabel("Tổng doanh thu : ");
		labelDoangThu.setFont(new Font("Arial",Font.BOLD, 20));
		panelTongDoanhThu.add(labelDoangThu);
		
		// add into panelThongKe;
		boxThongKe.add(Box.createVerticalStrut(20));
		boxThongKe.add(panelTools);
		boxThongKe.add(Box.createVerticalStrut(15));
		boxThongKe.add(scroll = new JScrollPane(table));
		boxThongKe.add(Box.createVerticalStrut(5));
		boxThongKe.add(panelTongDoanhThu);
		panelThongKe.add(boxThongKe);
		
		// add tât cả các chức năng vào giao diện
		this.add(panelHeading, BorderLayout.NORTH);
		this.add(panelThongKe, BorderLayout.CENTER);
		
		//add action 
		ActionListener ac = new BaoCaoTheoThang_ACtion(this);
		home.addActionListener(ac);
		signOut.addActionListener(ac);
		close.addActionListener(ac);
		hoaDon.addActionListener(ac);
		managementProduct.addActionListener(ac);
		findProduct.addActionListener(ac);
//		loaiSanPham.addActionListener(ac);
		nhaCC.addActionListener(ac);
		quanLiHoaDon.addActionListener(ac);
		quanLiNhanVien.addActionListener(ac);
		findNhanVien.addActionListener(ac);
		quanLiKhachHang.addActionListener(ac);
		finKhachHang.addActionListener(ac);
		baoCaoTheoThang.addActionListener(ac);
		baoCaoDoanhThu.addActionListener(ac);
		buttonFind.addActionListener(ac);
		buttonXoaTrang.addActionListener(ac);
		
		/*
		 * hiển thị giao diện
		 */
		this.setVisible(true);
		this.manage.add();
		this.addSanPhamVaoBang();
	}
	
	public boolean  ThongKe() {
		int thang = Integer.parseInt(this.textMonth.getText());
		int nam = Integer.parseInt(this.textYear.getText());
		ArrayList<DoanhThu> list = new ArrayList<>();
		ManagementDoanhThuTheoThang manager = new ManagementDoanhThuTheoThang();
		manager.addListTheoThang(thang, nam);
		list = manager.getList();
		String labelTongDoanhThu = "Tổng doanh thu : "; 
		double money = 0; 
		this.model.setRowCount(0);
		for (DoanhThu doanhThu : list) {
			String object[] = {doanhThu.getMasanPham(), doanhThu.getTenSanPham(), doanhThu.getMonth()+"", doanhThu.getYear()+""
					, doanhThu.getDoanhThu()+"VND"};
			money += doanhThu.getDoanhThu();
			model.addRow(object);
		}
		this.labelDoangThu.setText(labelTongDoanhThu+money+"");
		if(money != 0) {
			return true;
		}
		return false;
	}
	
	public void addSanPhamVaoBang() {
		ArrayList<DoanhThu> list = this.manage.getList();
		String labelTongDoanhThu = "Tổng doanh thu : "; 
		double money = 0; 
		for (DoanhThu doanhThu : list) {
			String object[] = {doanhThu.getMasanPham(), doanhThu.getTenSanPham(), doanhThu.getMonth()+"", doanhThu.getYear()+""
					, doanhThu.getDoanhThu()+"VND"};
			money += doanhThu.getDoanhThu();
			model.addRow(object);
		}
		this.labelDoangThu.setText(labelTongDoanhThu+money+"");
		if(money==0) {
			JOptionPane.showMessageDialog(this,"Không có sản phẩm!!");
		}
	}
	
	public boolean xetChinhQuy() {
		try {
			int thang = Integer.parseInt(this.textMonth.getText());
			int nam = Integer.parseInt(this.textYear.getText());
			if(thang<1 || thang >12 ) {
				JOptionPane.showMessageDialog(this, "Tháng chỉ nằm trong khoảng từ tháng 1 đến tháng 12");
				this.textMonth.requestFocus();
				return false;
			}
			else if(nam > LocalDate.now().getYear()) {
				JOptionPane.showMessageDialog(this, "Bạn chỉ có thể nhập năm thấp hơn hoặc bằng năm hiện tại");
				this.textYear.requestFocus();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Chỉ được phép nhập số và không được để chống");
			return false;
		}
		return true;
	}
	
	// xóa trắng
	public void xoaTrang() {
		this.model.setRowCount(0);
		textMonth.setText("");
		textYear.setText("");
	}
	
}
