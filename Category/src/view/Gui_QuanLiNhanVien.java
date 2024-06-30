package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.BaoCaoTheoThang_ACtion;
import controller.QuanLiNhanVien_Action;
import dao.ManagementNhanVien;
import model.NhanVien;


public class Gui_QuanLiNhanVien extends JFrame{

	public  JPanel pnNorth, pnCenter;
	public JPanel pnTitle;
	public JLabel lbTitle;
	public JPanel pnMaNV;
	public JLabel lbMaNV;
	public JTextField textMaNV;
	public JLabel lbTen;
	public JTextField textTen;
	public JRadioButton radNam;
	public JRadioButton radNu;
	public JPanel pnText;
	public Container pnTen;
	public Container pnPhai;
	public JPanel pnWest;
	public JPanel pnCase;
	public JButton btnThem;
	public JButton btnXoa;
	public JPanel pnTopCase;
	public JButton btnSua;
	public JButton btnRefesh;
	public JPanel pnBotCase;
	public JPanel pnContainerCase;
	public JPanel pnDiaChi;
	public JLabel lbDiaChi;
	public JTextField textDiaChi;
	public JPanel pnSDT;
	public JLabel lbSDT;
	public JTextField textSDT;
	public JLabel lbPhai;
	public DefaultTableModel modelNV;
	public JTable tableNV;
	ManagementNhanVien manage ;
	private ButtonGroup group;
	private ImageIcon icon;
	public Gui_QuanLiNhanVien() {
		this.manage = new ManagementNhanVien();
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
		pnMaNV = new JPanel();
		pnMaNV.add(lbMaNV = new JLabel("Mã nhân viên:  "));
		pnMaNV.add(textMaNV = new JTextField(20));
	
		pnTen = new Panel();
		pnTen.add(lbTen = new JLabel("Tên nhân viên:"));
		pnTen.add(textTen = new JTextField(20));
		
		pnSDT = new JPanel();
		pnSDT.add(lbSDT = new JLabel("Số điện thoại: "));
		pnSDT.add(textSDT = new JTextField(20));
		
		
		pnDiaChi = new JPanel();
		pnDiaChi.add(lbDiaChi = new JLabel("Địa chỉ:            "));
		pnDiaChi.add(textDiaChi = new JTextField(20));
		
		pnPhai = new JPanel();
		pnPhai.add(lbPhai = new JLabel("Giới tính:                                                   "));
		pnPhai.add(radNam = new JRadioButton("Nam"));
		pnPhai.add(radNu = new JRadioButton("Nữ"));
		group = new ButtonGroup();
		group.add(radNam);
		group.add(radNu);
		
		
		pnText = new JPanel();
		pnText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Box boxText = Box.createVerticalBox();
		boxText.add(pnMaNV);
		boxText.add(Box.createVerticalStrut(20));
		boxText.add(pnTen);
		boxText.add(Box.createVerticalStrut(20));
		boxText.add(pnSDT);
		boxText.add(Box.createVerticalStrut(20));
		boxText.add(pnDiaChi);
		boxText.add(Box.createVerticalStrut(20));
		boxText.add(pnPhai);
		boxText.add(Box.createVerticalStrut(20));
		pnText.add(boxText);
		pnWest.add(pnText, BorderLayout.CENTER);
		
		//case
			pnContainerCase = new JPanel();
			pnContainerCase.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			pnWest.add(pnContainerCase, BorderLayout.SOUTH);
			
			pnCase = new JPanel();
			pnCase.setLayout(new GridLayout(2, 2, 40, 20));
			pnContainerCase.add(pnCase);
			
			pnCase.add(btnThem = new JButton("Thêm"));
			pnCase.add(btnXoa = new JButton("Xóa"));
			
	
			pnCase.add(btnSua = new JButton("Sửa"));
			pnCase.add(btnRefesh = new JButton("Refesh"));
		
		//Title
			pnTitle = new JPanel();
			pnTitle.add(lbTitle = new JLabel("QUẢN LÝ NHÂN VIÊN"));
			Font f = new Font("Arial", Font.BOLD, 22);
			lbTitle.setFont(f);
			lbTitle.setForeground(Color.BLUE);
			pnCenter.add(pnTitle, BorderLayout.NORTH);
			
		//table
			String[] cols = {"Mã NV", "Tên nhân viên", "Số điện thoại", "Địa chỉ", "Giới tính"};
			modelNV = new DefaultTableModel(cols, 0);
			tableNV = new JTable(modelNV);
			JScrollPane scroll;
			pnCenter.add(scroll = new JScrollPane(tableNV), BorderLayout.CENTER);
		
		
			//add action 
			ActionListener ac = new QuanLiNhanVien_Action(this);
			MouseListener mouse = new QuanLiNhanVien_Action(this);
			home.addActionListener(ac);
			signOut.addActionListener(ac);
			close.addActionListener(ac);
			hoaDon.addActionListener(ac);
			managementProduct.addActionListener(ac);
			findProduct.addActionListener(ac);
//			loaiSanPham.addActionListener(ac);
			nhaCC.addActionListener(ac);
			quanLiHoaDon.addActionListener(ac);
			quanLiNhanVien.addActionListener(ac);
			findNhanVien.addActionListener(ac);
			quanLiKhachHang.addActionListener(ac);
			finKhachHang.addActionListener(ac);
			baoCaoTheoThang.addActionListener(ac);
			baoCaoDoanhThu.addActionListener(ac);
			btnThem.addActionListener(ac);
			btnXoa.addActionListener(ac);
			btnSua.addActionListener(ac);
			btnRefesh.addActionListener(ac);
			tableNV.addMouseListener(mouse);
		// setting to show screen
		this.setSize(800, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		/*
		 * 
		 * lấy dữ liệu từ database
		 */
		this.manage.addDuLieuTuDatabase();
		this.writeOnTable();
	}
	
	public void refesh() {
		//ten
		this.textTen.setText("");
		this.textTen.setEditable(true);
		this.textTen.setEnabled(true);
		
		//ma			
		this.textMaNV.setText("");
		this.textMaNV.setEditable(true);
		this.textMaNV.setEnabled(true);
		
		// số điện thoại 
		this.textSDT.setText("");
		this.textSDT.setEditable(true);
		this.textSDT.setEnabled(true);
		
		// địa chỉ
		this.textDiaChi.setText("");
		this.textDiaChi.setEditable(true);
		this.textDiaChi.setEnabled(true);
		
		// gioi tinh
		this.group.clearSelection();
	}
	
	public void writeOnTable() {
		ArrayList<NhanVien> list = this.manage.getList();
		for (NhanVien nhanVien : list) {
			String manhanVien = nhanVien.getMaNV();
			String ten = nhanVien.getTen();
			String sdt = nhanVien.getSoDienThoai();
			String diaChi = nhanVien.getDiaChi();
			String gioiTinh = nhanVien.getGioiTinh();
			
			String object[] = {manhanVien, ten, sdt, diaChi, gioiTinh};
			this.modelNV.addRow(object);
		}
	}
	
	public NhanVien getNhanVien() {
		String manhanVien = this.textMaNV.getText();
		String ten = this.textTen.getText();
		String sdt = this.textSDT.getText();
		String diaChi =  this.textDiaChi.getText();
		if(this.radNam.isSelected()) {
			return new NhanVien(manhanVien, ten, sdt, diaChi, "Nam");
		}
		else {
			return new NhanVien(manhanVien, ten, sdt, diaChi, "Nữ");
		}
	}
	
	public boolean themNhanVien() {
		NhanVien nhanVien = this.getNhanVien();
		String manhanVien = nhanVien.getMaNV();
		String ten = nhanVien.getTen();
		String sdt = nhanVien.getSoDienThoai();
		String diaChi = nhanVien.getDiaChi();
		String gioiTinh = nhanVien.getGioiTinh();
		
		String object[] = {manhanVien, ten, sdt, diaChi, gioiTinh};
		if(this.manage.kiemTra(nhanVien)) {
			this.modelNV.addRow(object);
			if(this.manage.themVaoList(nhanVien)) {
				return true;
			}
		}
		return false;
	}
	
	public void thongTinVaoBang(NhanVien nv) {
				//ten
				this.textTen.setText(nv.getTen());
				//ma			
				this.textMaNV.setText(nv.getMaNV());
				this.textMaNV.setEnabled(false);
				// số điện thoại 
				this.textSDT.setText(nv.getSoDienThoai());
				// địa chỉ
				this.textDiaChi.setText(nv.getDiaChi());
				// gioi tinh
				if(nv.getGioiTinh().compareToIgnoreCase("Nam")==0) {
					this.radNam.setSelected(true);
				}
				else {
					this.radNu.setSelected(true);
				}
	}
	
	public boolean  xoa() {
			NhanVien nv = this.getNhanVien();
			int location = this.manage.getLocation(nv);
			if(!this.manage.xoaNhanVien(nv)) {
				JOptionPane.showMessageDialog(this, "Không thể xóa tài khoản admin");
			}	
			else {
				this.modelNV.removeRow(location);
				return true;
			}
			return false;
	}
	
	public boolean updateNhanVien() {
		NhanVien nv = this.getNhanVien(); 
		if(this.manage.updateDatabase(nv)) {
			if(this.manage.updateNhanVien(nv)){
				this.modelNV.setRowCount(0);
				this.writeOnTable();
				return true;
			}
			
		}
		return false;
	}
	
	public boolean chinhQuy() {
		String manhanVien = this.textMaNV.getText();
		String ten = this.textTen.getText();
		String sdt = this.textSDT.getText();
		String diaChi =  this.textDiaChi.getText();
		if(manhanVien.length()==0 || !manhanVien.matches("^NV[0-9]+$")) {
			JOptionPane.showMessageDialog(this, "Mã phải có NV + số tt");
			textMaNV.requestFocus();
			return false;
		}
		else if(ten.length()==0) {
			JOptionPane.showMessageDialog(this, "tên không để trống");
			textTen.requestFocus();
			return false;
		}
		else if(sdt.length()==0 || !sdt.matches("^[0-9]{10}$")) {
			JOptionPane.showMessageDialog(this, "Không được để trống và tối đa 10 số ");
			return false;
		}
		else if(diaChi.length()==0) {
			JOptionPane.showMessageDialog(this, "Không được để trống địa chỉ ");
			return false;
		}
		if(!this.radNam.isSelected()&& !this.radNu.isSelected()) {
			JOptionPane.showMessageDialog(this, "Phải chọn giới tính");
			return false;
		}
		return true;
	}
	
}

