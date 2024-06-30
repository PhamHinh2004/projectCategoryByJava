package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.SearchKhachHang_Action;
import dao.*;
import model.*;


public class Gui_TimKiemKhachHang extends JFrame{

	public JPanel pnNorth, pnCenter;
	public JPanel pnTitle;
	public JLabel lbTitle;
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
	public JPanel pnMaKH;
	public JLabel lbMaKH;
	public JTextField textMaKH;
	public DefaultTableModel modelKH;
	public JTable tableKH;
	public ManagementSearchKhachHang  manage;
	int stt = 1;
	public JButton btnLuu;
	public ButtonGroup group;
	public JButton btnTimKiem;
	private JTextField textPhai;
	private ImageIcon icon;
	public Gui_TimKiemKhachHang() {
		this.manage = new ManagementSearchKhachHang();
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
			pnMaKH = new JPanel();
			pnMaKH.add(lbMaKH = new JLabel("Mã khách hàng:  "));
			pnMaKH.add(textMaKH = new JTextField(20));
			
		
			pnTen = new Panel();
			pnTen.add(lbTen = new JLabel("Tên khách hàng:"));
			pnTen.add(textTen = new JTextField(20));
			
			pnSDT = new JPanel();
			pnSDT.add(lbSDT = new JLabel("Số điện thoại:    "));
			pnSDT.add(textSDT = new JTextField(20));
			
			
			pnDiaChi = new JPanel();
			pnDiaChi.add(lbDiaChi = new JLabel("Địa chỉ:               "));
			pnDiaChi.add(textDiaChi = new JTextField(20));
			textDiaChi.setEnabled(false);
			
	
			pnPhai = new JPanel();
			pnPhai.add(lbPhai = new JLabel("Giới tính:              "));
			pnPhai.add(textPhai = new JTextField(20));
			textPhai.setEnabled(false);
			
	//		pnPhai.add(radNam = new JRadioButton("Nam"));
	//		pnPhai.add(radNu = new JRadioButton("Nữ"));
	//		group = new ButtonGroup();
	//		group.add(radNam);
	//		group.add(radNu);
			
			
			pnText = new JPanel();
			pnText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			Box boxText = Box.createVerticalBox();
			boxText.add(pnMaKH);
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
			pnTitle.add(lbTitle = new JLabel("TÌM KIẾM KHÁCH HÀNG"));
			Font f = new Font("Arial", Font.BOLD, 27);
			lbTitle.setFont(f);
			lbTitle.setForeground(Color.BLUE);
			pnCenter.add(pnTitle, BorderLayout.NORTH);
			
		//table
			String[] cols = {"Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Giới tính"};
			modelKH = new DefaultTableModel(cols, 0);
			tableKH = new JTable(modelKH);
			JScrollPane scroll;
			pnCenter.add(scroll = new JScrollPane(tableKH), BorderLayout.CENTER);
		
		/*
		 * 
		 * add action listener
		 */
			ActionListener ac = new SearchKhachHang_Action(this);
			MouseListener mouse = new SearchKhachHang_Action(this);
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
			btnTimKiem.addActionListener(ac);
			btnRefesh.addActionListener(ac);
			tableKH.addMouseListener(mouse);
			
		this.setSize(800, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.manage.addDuLieuTuDatabase();
		this.writeOnTable();
	}
	
	public void thongTinVaoBang(KhachHang kh) {
		//ten
		this.textTen.setText(kh.getTen());
		//ma			
		this.textMaKH.setText(kh.getMaKH());
		this.textMaKH.setEnabled(false);
		// số điện thoại 
		this.textSDT.setText(kh.getSoDienThoai());
		// địa chỉ
		this.textDiaChi.setText(kh.getDiaChi());
		// gioi tinh
		this.textPhai.setText(kh.getGioiTinh());
	}


	public void refesh() {
		this.modelKH.setRowCount(0);
		//ten
		this.textTen.setText("");
	
		
		//ma			
		this.textMaKH.setText("");
		this.textMaKH.setEnabled(true);
		this.textMaKH.setEditable(true);
		// số điện thoại 
		this.textSDT.setText("");
		
		// địa chỉ
		this.textDiaChi.setText("");
		
		// gioi tinh
		this.textPhai.setText("");
	}
	
	public void timKiemKH() {
		String ma = textMaKH.getText();
		if (ma != null && !ma.trim().equals("")) 
		{
			KhachHang kh = manage.timTheoMaKH(ma);
			if (kh != null) 
			{
				modelKH.addRow(new Object[] {kh.getMaKH(), kh.getTen(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getGioiTinh()});
				textMaKH.setText(null);
			}
			else 
				JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên",  "Tìm nhân viên", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void writeOnTable() {
		ArrayList<KhachHang> list = this.manage.getList();
		this.modelKH.setRowCount(0);
		for (KhachHang kh : list) {
			String maKH = kh.getMaKH();
			String ten = kh.getTen();
			String sdt = kh.getSoDienThoai();
			String diaChi = kh.getDiaChi();
			String gioiTinh = kh.getGioiTinh();
			
			String object[] = {maKH, ten, sdt, diaChi, gioiTinh};
			this.modelKH.addRow(object);
		}
	}
	
	
	
	public boolean timKiemTheoMa() {
		String ma = this.textMaKH.getText();
		ManagementSearchKhachHang manage = new ManagementSearchKhachHang();
		manage.timKiemTheoMa(ma);
		ArrayList<KhachHang> list = manage.getList();
		this.modelKH.setRowCount(0);
		for (KhachHang kh : list) {
			String maKH = kh.getMaKH();
			String ten = kh.getTen();
			String sdt = kh.getSoDienThoai();
			String diaChi = kh.getDiaChi();
			String gioiTinh = kh.getGioiTinh();
			
			String object[] = {maKH, ten, sdt, diaChi, gioiTinh};
			this.modelKH.addRow(object);
		}
		if(this.modelKH.getRowCount()!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean timKiemTen() {
		String ten = this.textTen.getText();
		ManagementSearchKhachHang manage = new ManagementSearchKhachHang();
		manage.timKiemTen(ten);
		ArrayList<KhachHang> list = manage.getList();
		this.modelKH.setRowCount(0);
		for (KhachHang kh : list) {
			String maKH = kh.getMaKH();
			String tenKhachHang = kh.getTen();
			String sdt = kh.getSoDienThoai();
			String diaChi = kh.getDiaChi();
			String gioiTinh = kh.getGioiTinh();
			
			String object[] = {maKH, tenKhachHang, sdt, diaChi, gioiTinh};
			this.modelKH.addRow(object);
		}
		if(this.modelKH.getRowCount()!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean timKiemSoDienThoai() {
		String sdt = this.textSDT.getText();
		ManagementSearchKhachHang manage = new ManagementSearchKhachHang();
		manage.timKiemSDT(sdt);
		ArrayList<KhachHang> list = manage.getList();
		this.modelKH.setRowCount(0);
		for (KhachHang kh : list) {
			String maKH = kh.getMaKH();
			String tenKhachHang = kh.getTen();
			String sdtKhachHang = kh.getSoDienThoai();
			String diaChi = kh.getDiaChi();
			String gioiTinh = kh.getGioiTinh();
			
			String object[] = {maKH, tenKhachHang, sdtKhachHang, diaChi, gioiTinh};
			this.modelKH.addRow(object);
		}
		if(this.modelKH.getRowCount()!=0) {
			return true;
		}
		else {
			return false;
		}
	}
}