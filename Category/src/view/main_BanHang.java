package view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.BanHang_Action;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class main_BanHang extends JFrame {
    private JTextField txtTenSanPham, txtMaHoaDon, txtSoLuong, txtDonGia, txtTienKhachTra, txtTongTienHoaDon, txtTienDuCuaKhach, txtThanhTien;
    private JComboBox<String> cboMaKH, cboMaNV, cboMaSP;
    private JButton btnThemSanPham, btnXoa, btnUpdate, btnThoat, btnThanhToan, btnReload;
    private JTable table;
    private DefaultTableModel tableModel;
    
    // Khai báo biến boolean để theo dõi trạng thái thanh toán
    private boolean thanhToanThanhCong = false;

    
    private Connection connection;
    
    private int soLuongTonKho; // Biến để lưu trữ số lượng tồn kho của sản phẩm
	private ImageIcon icon;

    public main_BanHang() {
        initializeComponents();
        initDatabase(); // Khởi tạo kết nối cơ sở dữ liệu trước khi gọi các phương thức khác
        setupLayout();
        setTitle("Bán Hàng");
		this.setSize(800, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
     	/*
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
    		
    		ActionListener ac = new BanHang_Action(this);
    		  home.addActionListener(ac);
    			signOut.addActionListener(ac);
    			close.addActionListener(ac);
    			hoaDon.addActionListener(ac);
    			managementProduct.addActionListener(ac);
    			findProduct.addActionListener(ac);
//    			loaiSanPham.addActionListener(ac);
    			nhaCC.addActionListener(ac);
    			quanLiHoaDon.addActionListener(ac);
    			quanLiNhanVien.addActionListener(ac);
    			findNhanVien.addActionListener(ac);
    			quanLiKhachHang.addActionListener(ac);
    			finKhachHang.addActionListener(ac);
    			baoCaoTheoThang.addActionListener(ac);
    			baoCaoDoanhThu.addActionListener(ac);
        
        // Hiển thị mã hoá đơn mới khi khởi tạo giao diện
        displayNextInvoiceNumber();
        
        setVisible(true);
        
        initDatabase();
        loadMaKH();
        loadMaNV();
        loadMaSP();
        
        
    }

    private void initializeComponents() {
        txtTenSanPham = new JTextField();
        txtMaHoaDon = new JTextField();
        txtSoLuong = new JTextField();
        txtDonGia = new JTextField();
        txtTienKhachTra = new JTextField("0");
        txtTongTienHoaDon = new JTextField();
        txtThanhTien = new JTextField();
        txtTienDuCuaKhach = new JTextField();
        

        // Set editability
        txtTenSanPham.setEditable(false);
        txtMaHoaDon.setEditable(false);
        txtDonGia.setEditable(false);
        txtTienDuCuaKhach.setEditable(false);
        txtTongTienHoaDon.setEditable(false);
        txtThanhTien.setEditable(false);// Đây là trường cần set không chỉnh sửa được

        cboMaKH = new JComboBox<>();
        cboMaNV = new JComboBox<>();
        cboMaSP = new JComboBox<>();

        btnThemSanPham = new JButton("Thêm Sản Phẩm");
        btnXoa = new JButton("Xóa");
        btnUpdate = new JButton("Cập Nhật");
        btnThoat = new JButton("Thoát");
        btnThanhToan = new JButton("Thanh Toán");
        btnReload = new JButton("Reload");

        Vector<String> headers = new Vector<>();
        headers.add("Mã Sản Phẩm");
        headers.add("Tên Sản Phẩm");
        headers.add("Số Lượng");
        headers.add("Tiền");

        Vector<Vector<String>> data = new Vector<>(); // Sample data

        tableModel = new DefaultTableModel(data, headers);
        table = new JTable(tableModel);
    }


    private void setupLayout() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2));
        //inputPanel.setLayout();
        
        // Add components to input panel
        inputPanel.add(new JLabel("Mã Hóa Đơn:"));
        inputPanel.add(txtMaHoaDon);
        inputPanel.add(new JLabel("Tên Sản Phẩm:"));
        inputPanel.add(txtTenSanPham);
        inputPanel.add(new JLabel("Mã Khách Hàng:"));
        inputPanel.add(cboMaKH);
        inputPanel.add(new JLabel("Mã Nhân Viên:"));
        inputPanel.add(cboMaNV);
        inputPanel.add(new JLabel("Mã Sản Phẩm:"));
        inputPanel.add(cboMaSP);
        inputPanel.add(new JLabel("Số Lượng:"));
        inputPanel.add(txtSoLuong);
        inputPanel.add(new JLabel("Đơn Giá:"));
        inputPanel.add(txtDonGia);
        inputPanel.add(new JLabel("Tiền Khách Trả:"));
        inputPanel.add(txtTienKhachTra);
        inputPanel.add(new JLabel("Tổng Tiền Hóa Đơn:"));
        inputPanel.add(txtTongTienHoaDon);
        inputPanel.add(new JLabel("Thành Tiền:"));
        inputPanel.add(txtThanhTien);
        inputPanel.add(new JLabel("Tiền Dư Của Khách:"));
        inputPanel.add(txtTienDuCuaKhach);


        // Add more input fields or JComboBoxes here...
        
        cboMaSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMaSP = cboMaSP.getSelectedItem().toString();
                // Thực hiện truy vấn dữ liệu từ bảng SanPham dựa trên selectedMaSP
                try {
                    String query = "SELECT ten, donGia, soLuong FROM SanPham WHERE maSanPham = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, selectedMaSP);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        String tenSanPham = resultSet.getString("ten");
                        String donGia = resultSet.getString("donGia");
                        // Cập nhật giá trị cho txtTenSanPham và txtDonGia
                        txtTenSanPham.setText(tenSanPham);
                        txtDonGia.setText(donGia);

                        int soLuongTonKho = resultSet.getInt("soLuong");
                        System.out.println("Số lượng tồn kho của sản phẩm _ " +tenSanPham+ " _ là: "+ soLuongTonKho); // In ra console
                    }
                    resultSet.close();
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        
        
        
        
     // Xử lý sự kiện khi người dùng nhập số lượng sản phẩm
        txtSoLuong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra nếu số lượng là số nguyên dương và nhỏ hơn số lượng tồn kho
                try {
                    int soLuong = Integer.parseInt(txtSoLuong.getText());
                    if (soLuong > 0 && soLuong <= soLuongTonKho) {
                        // Tính toán tổng tiền hóa đơn
                        double tongTien = Double.parseDouble(txtDonGia.getText()) * soLuong;
                        // Làm tròn tổng tiền hóa đơn thành số nguyên
                        long tongTienRounded = Math.round(tongTien);
                        // Hiển thị tổng tiền hóa đơn
                        txtTongTienHoaDon.setText(String.valueOf(tongTienRounded));
                        // Tính toán và hiển thị thành tiền sau khi cộng thuế VAT 10%
                        double thanhTien = tongTien * 1.1;
                        // Làm tròn thành tiền thành số nguyên
                        long thanhTienRounded = Math.round(thanhTien);
                        txtThanhTien.setText(String.valueOf(thanhTienRounded));
                    } else {
                        JOptionPane.showMessageDialog(main_BanHang.this, "Số lượng không hợp lệ! Số nguyên không âm ! Nhỏ hơn hoặc bằng Lượng Tồn Kho được in trên system !");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(main_BanHang.this, "Vui lòng nhập số nguyên dương!");
                }
            }
        });


        
     // Xử lý sự kiện khi người dùng nhập số tiền khách trả
        txtTienKhachTra.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    // Lấy số tiền khách trả từ JTextField
                    double tienKhachTra = Double.parseDouble(txtTienKhachTra.getText());
                    // Kiểm tra xem số tiền khách trả có phải là số nguyên không âm hay không
                    if (tienKhachTra >= 0 && tienKhachTra == (int) tienKhachTra) {
                        // Tính toán số tiền dư của khách hàng
                        double tienDuCuaKhach = tienKhachTra - Double.parseDouble(txtThanhTien.getText());
                        // Cập nhật dữ liệu vào JTextField Tiền Dư Của Khách
                        txtTienDuCuaKhach.setText(String.valueOf(tienDuCuaKhach));
                    } else {
                        JOptionPane.showMessageDialog(main_BanHang.this, "Vui lòng nhập số nguyên không âm!");
                        txtTienKhachTra.requestFocusInWindow(); // Di chuyển con trỏ về ô nhập liệu tiền khách trả
                        txtTienKhachTra.selectAll(); // Chọn toàn bộ nội dung trong ô nhập liệu
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(main_BanHang.this, "Vui lòng nhập số nguyên không âm!");
                    txtTienKhachTra.requestFocusInWindow(); // Di chuyển con trỏ về ô nhập liệu tiền khách trả
                    txtTienKhachTra.selectAll(); // Chọn toàn bộ nội dung trong ô nhập liệu
                }
            }
        });


        

        btnThemSanPham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra dữ liệu từ các JTextField
                String maSanPham = cboMaSP.getSelectedItem().toString();
                String tenSanPham = txtTenSanPham.getText();
                String soLuongText = txtSoLuong.getText();
                String thanhTienText = txtThanhTien.getText();
                
                // Kiểm tra nếu có một trong các trường dữ liệu trống
                if (maSanPham.isEmpty() || tenSanPham.isEmpty() || soLuongText.isEmpty() || thanhTienText.isEmpty()) {
                    JOptionPane.showMessageDialog(main_BanHang.this, "Vui lòng nhập đầy đủ thông tin!");
                    return; // Dừng lại nếu có một trường dữ liệu trống
                }
                
                // Kiểm tra nếu số lượng và thành tiền không phải là số dương
                try {
                    int soLuong = Integer.parseInt(soLuongText);
                    double thanhTien = Double.parseDouble(thanhTienText);
                    
                    if (soLuong <= 0 || thanhTien <= 0) {
                        JOptionPane.showMessageDialog(main_BanHang.this, "Số lượng và thành tiền phải là số dương!");
                        return; // Dừng lại nếu số lượng hoặc thành tiền không phải là số dương
                    }
                    
                    // Thêm dữ liệu vào bảng
                    Object[] rowData = {maSanPham, tenSanPham, soLuong, thanhTien};
                    tableModel.addRow(rowData);

                    // Cập nhật tiền dư của khách hàng
                    double tienKhachTra = Double.parseDouble(txtTienKhachTra.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(main_BanHang.this, "Số lượng và thành tiền phải là số!");
                }
            }
        });




   
        
        btnThanhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra xem đã có sản phẩm được thêm vào hóa đơn chưa
                if (tableModel.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(main_BanHang.this, "Quý khách chưa thêm sản phẩm!!!");
                    return; // Dừng lại và không tiếp tục xử lý
                }

                // Tính toán tổng tiền hóa đơn từ dữ liệu trong bảng
                double thanhTien = calculateTotalBill();

                // Lấy số tiền khách trả từ JTextField
                double tienKhachTra = Double.parseDouble(txtTienKhachTra.getText());

                double tienDuCuaKhach = tienKhachTra - thanhTien;
                txtTienDuCuaKhach.setText(String.valueOf(tienDuCuaKhach));

                if (tienKhachTra >= thanhTien) {
                    JOptionPane.showMessageDialog(main_BanHang.this, "Cảm ơn quý khách đã ủng hộ shop!!!");

                    // Sau khi thanh toán thành công
                    thanhToanThanhCong = true; // Cập nhật trạng thái thanh toán thành công

                    // Lưu hoá đơn vào file
                    saveInvoiceToFile();

                    // Hiển thị thông báo và mở file hoá đơn
                    String filePath = "C:\\Users\\phamv\\OneDrive\\Desktop\\hoa_don.txt.txt";
                    File file = new File(filePath);
                    if (file.exists()) {
                        try {
                            Desktop.getDesktop().open(file);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(main_BanHang.this, "Không thể mở file hoá đơn!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(main_BanHang.this, "Không tìm thấy file hoá đơn!");
                    }
                } else {
                    JOptionPane.showMessageDialog(main_BanHang.this, "Số tiền quý khách đưa không đủ !!! Bill : " + thanhTien + "!!!" + " Còn Thiếu : " +(thanhTien-tienKhachTra));
                }
            }
        });


        
        
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị hộp thoại xác nhận trước khi thoát
                int choice = JOptionPane.showConfirmDialog(main_BanHang.this, "Bạn có chắc chắn muốn thoát?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    // Thoát khỏi ứng dụng
                    System.exit(0);
                }
            }
        });
        
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(main_BanHang.this, "Vui lòng chọn dòng cần xóa!");
                    return;
                }
                int choice = JOptionPane.showConfirmDialog(main_BanHang.this, "Bạn chắc muốn xóa dòng này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(main_BanHang.this, "Thực hiện xóa dòng!");
                    tableModel.removeRow(selectedRow);
                }
            }
        });
        
     
     // Thêm sự kiện ActionListener cho nút "Cập Nhật"
     // Thêm sự kiện ActionListener cho nút "Cập Nhật"
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra trạng thái thanh toán
                if (thanhToanThanhCong) {
                    int choice = JOptionPane.showConfirmDialog(main_BanHang.this, "Bạn có chắc muốn cập nhật sản phẩm?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(main_BanHang.this, "Thực hiện cập nhật sản phẩm!");
                        updateSanPhamTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(main_BanHang.this, "Vui lòng thanh toán trước khi cập nhật!");
                }
            }
        });



        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(main_BanHang.this, "Reload lại chương trình?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(main_BanHang.this, "Reload lại chương trình!");
                    // Đóng và mở lại chương trình
                    dispose(); // Đóng cửa sổ hiện tại
                    new main_BanHang(); // Mở lại chương trình
                }
            }
        });





        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        // Add buttons to button panel
        buttonPanel.add(btnThemSanPham);
        buttonPanel.add(btnXoa);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnThoat);
        buttonPanel.add(btnThanhToan);
        buttonPanel.add(btnReload);
        // Add more buttons here...

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Load data to JComboBox
        loadMaKH();
        loadMaNV();
        loadMaSP();
    }

    
    private void updateSanPhamTable() {
        try {
            // Lặp qua từng dòng trong JTable
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String maSanPham = tableModel.getValueAt(i, 0).toString(); // Lấy mã sản phẩm từ cột "Mã Sản Phẩm"
                int soLuong = Integer.parseInt(tableModel.getValueAt(i, 2).toString()); // Lấy số lượng từ cột "Số Lượng"

                // Cập nhật số lượng tồn kho của sản phẩm
                // Trước tiên, bạn cần lấy số lượng tồn kho hiện tại từ cơ sở dữ liệu
                String query = "SELECT soLuong FROM SanPham WHERE maSanPham = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, maSanPham);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int soLuongTonKho = resultSet.getInt("soLuong");
                    // Tính toán số lượng tồn kho mới sau khi cập nhật
                    int soLuongMoi = soLuongTonKho - soLuong;
                    // Cập nhật số lượng tồn kho mới vào bảng SanPham
                    String updateQuery = "UPDATE SanPham SET soLuong = ? WHERE maSanPham = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    updateStatement.setInt(1, soLuongMoi);
                    updateStatement.setString(2, maSanPham);
                    updateStatement.executeUpdate();
                    updateStatement.close();
                }
                resultSet.close();
                statement.close();
            }
            // Hiển thị thông báo khi cập nhật thành công
            JOptionPane.showMessageDialog(main_BanHang.this, "Cập nhật số lượng sản phẩm thành công!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Xử lý lỗi SQL
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            // Xử lý lỗi chuyển đổi kiểu dữ liệu
        }
    }



    private void initDatabase() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://PHAMHINH\\SQLEXPRESS:1433;databaseName =Grocery;encrypt=true;trustServerCertificate=true";
			String userName = "sa";				
			String password = "hinh12345";
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadMaKH() {
        try {
            String query = "SELECT maKH FROM KhachHang";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String maKH = resultSet.getString("maKH");
                if (!containsItem(cboMaKH, maKH)) { // Kiểm tra trước khi thêm vào
                    cboMaKH.addItem(maKH);
                }
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Phương thức kiểm tra một mục có tồn tại trong JComboBox hay không
    private boolean containsItem(JComboBox<String> comboBox, String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    private void loadMaNV() {
        try {
            String query = "SELECT maNV FROM NhanVien";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String maNV = resultSet.getString("maNV");
                if (!containsItem(cboMaNV, maNV)) { // Kiểm tra trước khi thêm vào
                    cboMaNV.addItem(maNV);
                }
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadMaSP() {
        try {
            String query = "SELECT maSanPham, soLuong FROM SanPham"; // Thay đổi tên cột trong truy vấn SQL
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String maSP = resultSet.getString("maSanPham");
                if (!containsItem(cboMaSP, maSP)) { // Kiểm tra trước khi thêm vào
                    cboMaSP.addItem(maSP);
                }
                int soLuongTonKho = resultSet.getInt("soLuong");
                // Lưu giá trị số lượng tồn kho vào biến soLuongTonKho
                if (maSP.equals(cboMaSP.getSelectedItem())) {
                    this.soLuongTonKho = soLuongTonKho;
                }
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
 // Phương thức để lấy hoá đơn cuối cùng
    private String getLatestInvoiceNumber() {
        String latestInvoiceNumber = "";
        try {
            String query = "SELECT TOP 1 maHoaDon FROM HoaDon ORDER BY maHoaDon DESC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                latestInvoiceNumber = resultSet.getString("maHoaDon");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return latestInvoiceNumber;
    }

    // Phương thức để tạo mã hoá đơn mới
    private String generateNextInvoiceNumber(String latestInvoiceNumber) {
        String nextInvoiceNumber = "";
        if (!latestInvoiceNumber.isEmpty()) {
            // Lấy phần số thứ tự cuối cùng từ mã hoá đơn cuối cùng
            String numberPart = latestInvoiceNumber.substring(2);
            int number = Integer.parseInt(numberPart) + 1;
            nextInvoiceNumber = "DH" + number;
        } else {
            // Nếu không có hoá đơn nào trong database, bắt đầu từ số 1
            nextInvoiceNumber = "DH1";
        }
        return nextInvoiceNumber;
    }
    

    // Phương thức để hiển thị mã hoá đơn mới
    private void displayNextInvoiceNumber() {
        String latestInvoiceNumber = getLatestInvoiceNumber();
        String nextInvoiceNumber = generateNextInvoiceNumber(latestInvoiceNumber);
        txtMaHoaDon.setText(nextInvoiceNumber);
    }
    
    
    
 // Phương thức tính tổng tiền hóa đơn từ dữ liệu trong bảng
    private double calculateTotalBill() {
        double totalBill = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double thanhTien = Double.parseDouble(tableModel.getValueAt(i, 3).toString());
            totalBill += thanhTien;
        }
        return totalBill;
    }
    
    
    

    
    
    private void handleUpdateButton() {
        try {
            // Lấy dữ liệu từ JTable
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            String maSP = cboMaSP.getSelectedItem().toString();
            String maHoaDon = txtMaHoaDon.getText();
            
            // In ra dữ liệu để kiểm tra
            System.out.println("Số lượng: " + soLuong);
            System.out.println("Mã sản phẩm: " + maSP);
            System.out.println("Mã hóa đơn: " + maHoaDon);
            
            // Tạo mã CTHD mới
            String maCTHD = generateNextCTHDNumber(); // Hàm này cần được triển khai để tạo mã mới
            
            // Thêm dữ liệu vào bảng ChiTietHoaDon
            String query = "INSERT INTO ChiTietHoaDon (maCTHD, soLuong, maSP, maHoaDon) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, maCTHD);
            statement.setInt(2, soLuong);
            statement.setString(3, maSP);
            statement.setString(4, maHoaDon);
            statement.executeUpdate();
            statement.close();
            
            // Cập nhật thông tin trên JTable hoặc làm bất kỳ xử lý nào khác ở đây
            
            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công vào bảng ChiTietHoaDon!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Xử lý lỗi SQL
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            // Xử lý lỗi chuyển đổi kiểu dữ liệu
        }
    }


    private String generateMaCTHD() {
        String maHoaDon = txtMaHoaDon.getText(); // Lấy mã hóa đơn từ giao diện
        int rowCount = tableModel.getRowCount(); // Số lượng dòng hiện có trong bảng
        String newMaCTHD = ""; // Mã CTHD mới

        // Tạo mã CTHD mới bằng cách kết hợp mã hóa đơn và số lượng dòng + 1
        newMaCTHD = maHoaDon + (rowCount + 1);

        return newMaCTHD;
    }






    // Phương thức để tạo mã chi tiết hoá đơn mới
    private String generateNextCTHDNumber() {
        String latestCTHDNumber = "";
        try {
            String query = "SELECT TOP 1 maCTHD FROM ChiTietHoaDon ORDER BY maCTHD DESC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                latestCTHDNumber = resultSet.getString("maCTHD");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        // Lấy phần số thứ tự cuối cùng từ mã chi tiết hoá đơn cuối cùng
        String numberPart = latestCTHDNumber.substring(4); // Bỏ qua ký tự đầu tiên "CTHD"
        int number = Integer.parseInt(numberPart) + 1;
        String nextCTHDNumber = "CTHD" + number;
        
        return nextCTHDNumber;
    }

 // Phương thức để lưu hoá đơn vào file
    private void saveInvoiceToFile() {
        try {
            String filePath = "C:\\Users\\phamv\\OneDrive\\Desktop\\hoa_don.txt.txt";
            FileWriter writer = new FileWriter(filePath);

            // Ghi thông tin hoá đơn vào file
            writer.write("----- Hoá Đơn -----");
            writer.write("\n");
            // Ghi thông tin chi tiết từng sản phẩm trong hoá đơn
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String maSanPham = tableModel.getValueAt(i, 0).toString();
                String tenSanPham = tableModel.getValueAt(i, 1).toString();
                String soLuong = tableModel.getValueAt(i, 2).toString();
                String thanhTien = tableModel.getValueAt(i, 3).toString();

                writer.write("Mã SP: " + maSanPham + ", Tên SP: " + tenSanPham + ", Số lượng: " + soLuong + ", Thành tiền: " + thanhTien);
                writer.write("\n");
            }
            // Ghi tổng tiền và thông tin thanh toán vào file
            writer.write("Tổng tiền: " + txtTongTienHoaDon.getText());
            writer.write("\n");
            
            
            
            // Lấy giá trị tổng tiền từ JTextField
            double tongTien = Double.parseDouble(txtTongTienHoaDon.getText());
            // Tính tổng tiền sau khi nhân cho 110%
            double tongTienSauThue = tongTien * 1.1;
            // Làm tròn tổng tiền sau khi nhân cho 110% lên đến hàng đơn vị
            double tongTienSauThueRounded = Math.ceil(tongTienSauThue);
            // Ghi thông tin tổng tiền sau khi nhân cho 110% (làm tròn lên) vào file
            writer.write("Thành tiền với thuế VAT 10%: " + (int)tongTienSauThueRounded);
            writer.write("\n");
            writer.write("Tiền khách trả: " + txtTienKhachTra.getText());
            writer.write("\n");
            writer.write("Tiền dư của khách: " + txtTienDuCuaKhach.getText());
            writer.write("\n");
            // Tạo đối tượng LocalDateTime để lấy thời gian hiện tại
            LocalDateTime currentTime = LocalDateTime.now();
            // Định dạng thời gian theo ý muốn (ví dụ: "yyyy-MM-dd HH:mm:ss")
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            // Chuyển đổi thời gian sang chuỗi dạng định dạng đã chỉ định
            String formattedTime = currentTime.format(formatter);
            // Ghi thời gian xuất hoá đơn vào file
            writer.write("Thời gian xuất hoá đơn: " + formattedTime);
            writer.write("\n");
            
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(main_BanHang.this, "Không thể lưu hoá đơn vào file!");
        }
    }




    public static void main(String[] args) {
        main_BanHang banHang = new main_BanHang(); // Khởi tạo đối tượng main_BanHang
        SwingUtilities.invokeLater(() -> banHang.setVisible(true)); // Hiển thị giao diện
    }


}
