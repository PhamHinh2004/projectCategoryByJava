package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class main_SanPham extends JFrame implements ActionListener {
    private Connection connection;
    private DefaultTableModel tableModel;
    private JTextField txtMaSP, txtTen, txtHanSuDung, txtDonViTinh, txtDonGia, txtTrongLuong, txtSoLuong;
    private JButton btnThem, btnXoa, btnUpdate, btnThoat;
    private JButton btnReload;
    private JComboBox<String> cboMaNCC;
    private JTable table;
	private ImageIcon icon;

    public main_SanPham() {
        setTitle("Quản lý sản phẩm");
		this.setSize(800, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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
		
        table = new JTable();
        
        
        JPanel pnlNorth = new JPanel();
        add(pnlNorth, BorderLayout.NORTH);
        JLabel lblTieuDe = new JLabel("THÔNG TIN SẢN PHẨM");
        pnlNorth.add(lblTieuDe);
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
        lblTieuDe.setForeground(Color.BLUE);

        JPanel pnlCenter = new JPanel(new BorderLayout());
        add(pnlCenter, BorderLayout.CENTER);

//        tableModel = new DefaultTableModel();
//        JTable table = new JTable(tableModel);
//        JScrollPane scrollPane = new JScrollPane(table);
//        pnlCenter.add(scrollPane, BorderLayout.CENTER);
        
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel); // Thay đổi ở đây
        JScrollPane scrollPane = new JScrollPane(table);
        pnlCenter.add(scrollPane, BorderLayout.CENTER);
        
     // Thêm sự kiện lắng nghe cho JTable để xử lý khi dòng được chọn
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        txtMaSP.setText(table.getValueAt(selectedRow, 0).toString());
                        txtTen.setText(table.getValueAt(selectedRow, 1).toString());
                        txtHanSuDung.setText(table.getValueAt(selectedRow, 2).toString());
                        txtDonViTinh.setText(table.getValueAt(selectedRow, 3).toString());
                        // Lấy giá trị của cột maNCC từ dòng được chọn trong JTable
                        String maNCCValue = table.getValueAt(selectedRow, 5).toString();

                        // Duyệt qua các phần tử trong JComboBox để tìm giá trị đó
                        for (int i = 0; i < cboMaNCC.getItemCount(); i++) {
                            if (cboMaNCC.getItemAt(i).equals(maNCCValue)) {
                                // Nếu tìm thấy giá trị, đặt selectedIndex của JComboBox là vị trí của giá trị đó trong JComboBox
                                cboMaNCC.setSelectedIndex(i);
                                break;
                            }
                        }
                        txtDonGia.setText(table.getValueAt(selectedRow, 4).toString());
                        txtTrongLuong.setText(table.getValueAt(selectedRow, 7).toString());
                        txtSoLuong.setText(table.getValueAt(selectedRow, 6).toString());

                    }
                }
            }
        });
        

        

        JPanel pnlSouth = new JPanel();
        add(pnlSouth, BorderLayout.SOUTH);
        btnThem = new JButton("Thêm");
        btnXoa = new JButton("Xóa");
        btnUpdate = new JButton("Lưu");
        btnThoat = new JButton("Thoát");
        pnlSouth.add(btnThem);
        pnlSouth.add(btnXoa);
        pnlSouth.add(btnUpdate);
        pnlSouth.add(btnThoat);
        
        btnReload = new JButton("Reload");
        pnlSouth.add(btnReload);
        btnReload.addActionListener(this);

        // Thêm mã nhà cung cấp vào JComboBox và khởi tạo ActionListener cho nó
        JPanel pnlInputs = new JPanel(new GridLayout(8, 2));
        pnlCenter.add(pnlInputs, BorderLayout.NORTH);

        pnlInputs.add(new JLabel("Mã sản phẩm:"));
        txtMaSP = new JTextField();
        pnlInputs.add(txtMaSP);

        pnlInputs.add(new JLabel("Tên sản phẩm:"));
        txtTen = new JTextField();
        pnlInputs.add(txtTen);

        pnlInputs.add(new JLabel("Hạn sử dụng:"));
        txtHanSuDung = new JTextField();
        pnlInputs.add(txtHanSuDung);

        pnlInputs.add(new JLabel("Đơn vị tính:"));
        txtDonViTinh = new JTextField();
        pnlInputs.add(txtDonViTinh);

        pnlInputs.add(new JLabel("Mã nhà cung cấp:"));
        cboMaNCC = new JComboBox<>();
        pnlInputs.add(cboMaNCC);
        initDatabase(); // Gọi phương thức để khởi tạo kết nối với cơ sở dữ liệu
        loadMaNCC(); // Gọi phương thức để load mã nhà cung cấp vào JComboBox
        loadData(); // Load dữ liệu sản phẩm từ cơ sở dữ liệu

        // Thêm phần "Thêm mới..." vào JComboBox
        cboMaNCC.addItem("Thêm mới...");
        
        

        pnlInputs.add(new JLabel("Đơn giá:"));
        txtDonGia = new JTextField();
        pnlInputs.add(txtDonGia);

        pnlInputs.add(new JLabel("Trọng lượng:"));
        txtTrongLuong = new JTextField();
        pnlInputs.add(txtTrongLuong);

        pnlInputs.add(new JLabel("Số lượng:"));
        txtSoLuong = new JTextField();
        pnlInputs.add(txtSoLuong);
        
        // Xử lý sự kiện cho JComboBox
        cboMaNCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> cb = (JComboBox<String>) e.getSource();
                String selectedMaNCC = (String) cb.getSelectedItem();
                if (selectedMaNCC.equals("Thêm mới...")) {
                    // Hiển thị thông báo
                    int option = JOptionPane.showConfirmDialog(null, "Thêm mới nhà cung cấp?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        // Gọi class main_NhaCungCap()
                        new main_NhaCungCap_SanPham().setVisible(true);
                    } else {
                        // Chọn lại giá trị trước đó trong JComboBox
                        cb.setSelectedIndex(0);
                    }
                }
            }
        });
        
        
        // Thêm sự kiện ActionListener cho nút Update (đã đổi tên từ btnLuu thành btnUpdate)
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUpdateButton(); // Gọi phương thức xử lý sự kiện cho nút "Update"
            }
        });
        

        // Xử lý sự kiện cho các nút
        home.addActionListener(this);
		signOut.addActionListener(this);
		close.addActionListener(this);
		hoaDon.addActionListener(this);
		managementProduct.addActionListener(this);
		findProduct.addActionListener(this);
//		loaiSanPham.addActionListener(ac);
		nhaCC.addActionListener(this);
		quanLiHoaDon.addActionListener(this);
		quanLiNhanVien.addActionListener(this);
		findNhanVien.addActionListener(this);
		quanLiKhachHang.addActionListener(this);
		finKhachHang.addActionListener(this);
		baoCaoTheoThang.addActionListener(this);
		baoCaoDoanhThu.addActionListener(this);
        btnThem.addActionListener(this);
        btnXoa.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnThoat.addActionListener(this);
        
        
        
        initDatabase(); // Gọi phương thức để khởi tạo kết nối với cơ sở dữ liệu
        loadData(); // Load dữ liệu sản phẩm từ cơ sở dữ liệu
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

    private void loadData() {
        try {
            String selectQuery = "SELECT * FROM SanPham";
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();

            // Clear all existing rows in tableModel
            tableModel.setRowCount(0);

            // Add columns if not already added
            if (tableModel.getColumnCount() == 0) {
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    tableModel.addColumn(metaData.getColumnLabel(i));
                }
            }

            // Add data rows
            while (resultSet.next()) {
                Object[] row = new Object[tableModel.getColumnCount()];
                for (int i = 1; i <= tableModel.getColumnCount(); i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(row);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadMaNCC() {
        try {
            String query = "SELECT maNCC FROM NhaCungCap";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String maNCC = resultSet.getString("maNCC");
                cboMaNCC.addItem(maNCC); // Thêm mã nhà cung cấp vào JComboBox
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	String str = e.getActionCommand();
    	if(str.trim().compareToIgnoreCase("TRANG CHỦ")==0) {
			this.setVisible(false);
			new Gui_Home();
		}
		else if(str.trim().compareToIgnoreCase("Đăng Xuất")==0) {
			this.setVisible(false);
			new Gui_Login();
		}
		else if(str.compareToIgnoreCase("Đóng")==0) {
			System.exit(0);
		}
		else if(str.compareToIgnoreCase("Quản lí sản phẩm")==0) {
			this.setVisible(false);
			new main_SanPham().setVisible(true);
		}
		else if(str.compareToIgnoreCase("Tìm kiếm sản phẩm")==0) {
			this.setVisible(false);
			new GUI_TimKiemSanPham();
		}
		else if(str.compareToIgnoreCase("Nhà cung cấp")==0) {
			this.setVisible(false);
			new main_NhaCungCap().setVisible(true);
		}
		else if(str.compareToIgnoreCase("Quản lí hóa đơn")==0) {
			this.setVisible(false);
			new main_BanHang().setVisible(true);
		}
		else if(str.compareToIgnoreCase("Quản lí Nhân Viên")==0) {
			this.setVisible(false);
			new Gui_QuanLiNhanVien();
		}
		else if(str.compareToIgnoreCase("Tìm kiếm Nhân Viên")==0) {
			this.setVisible(false);
			new Gui_TimKiemNhanVien();
		}
		else if(str.compareToIgnoreCase("Quản lí khách hàng")==0) {
			this.setVisible(false);
			new Gui_QuanLiKhachHang();
		}
		else if(str.compareToIgnoreCase("Tìm kiếm khách hàng")==0) {
			this.setVisible(false);
			new Gui_TimKiemKhachHang();
		}
		else if(str.compareToIgnoreCase("Báo cáo theo tháng")==0) {
			this.setVisible(false);
			new Gui_BaoCaoTheoThang();
		}
		else if(str.compareToIgnoreCase("Báo cáo Doanh thu")==0) {
			this.setVisible(false);
			new Gui_BaoCaoDoanhThu();
		}
		else if (e.getSource() == btnThem) {
            // Lấy dữ liệu từ các JTextField và JComboBox
            String maSP = txtMaSP.getText();
            String tenSP = txtTen.getText();
            String hanSD = txtHanSuDung.getText();
            String donViTinh = txtDonViTinh.getText();
            String maNCC = cboMaNCC.getSelectedItem().toString();

//            double donGia = Double.parseDouble(txtDonGia.getText());
//            double trongLuong = Double.parseDouble(txtTrongLuong.getText());
//            int soLuong = Integer.parseInt(txtSoLuong.getText());

            // Kiểm tra các điều kiện
            if (maSP.isEmpty() || !maSP.matches("SP[A-Z]+\\d+")) {
                JOptionPane.showMessageDialog(this, "Mã sản phẩm không hợp lệ! Bắt đầu bằng SP _ CHỮ IN HOA _ Kết thúc là số!");
                return;
            }

            if (tenSP.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống!");
                return;
            }

            if (hanSD.isEmpty() || !hanSD.matches("\\d+ (ngày|tháng|năm|ngay|thang|nam)")) {
                JOptionPane.showMessageDialog(this, "Hạn sử dụng không hợp lệ!");
                return;
            }

            if (donViTinh.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Đơn vị tính không được để trống!");
                return;
            }
            
            // Kiểm tra và chuyển đổi dữ liệu đầu vào
            double donGia, trongLuong;
            int soLuong;
            try {
                donGia = Double.parseDouble(txtDonGia.getText());
                trongLuong = Double.parseDouble(txtTrongLuong.getText());
                soLuong = Integer.parseInt(txtSoLuong.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!Đơn giá_Trọng Lượng_Số Lượng!");
                return;
            }

            if (donGia < 0) {
                JOptionPane.showMessageDialog(this, "Đơn giá phải là số không âm!");
                return;
            }


            if (soLuong < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên không âm!");
                return;
            }

            if (trongLuong < 0) {
                JOptionPane.showMessageDialog(this, "Trọng lượng phải là số không âm!");
                return;
            }


            
            // Kiểm tra mã sản phẩm đã tồn tại chưa
            try {
                String checkQuery = "SELECT COUNT(*) FROM SanPham WHERE maSanPham = ?";
                PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
                checkStatement.setString(1, maSP);
                ResultSet resultSet = checkStatement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại!");
                    return;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return;
            }

            // Thêm dữ liệu vào SQL
            try {
                String insertQuery = "INSERT INTO SanPham (maSanPham, ten, hanSuDung, trongLuong, soLuong, donViTinh, donGia, maNCC) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(insertQuery);
                statement.setString(1, maSP);
                statement.setString(2, tenSP);
                statement.setString(3, hanSD);
                statement.setDouble(4, trongLuong);
                statement.setInt(5, soLuong);
                statement.setString(6, donViTinh);
                statement.setDouble(7, donGia);
                statement.setString(8, maNCC);
                statement.executeUpdate();
                statement.close();

                // Kiểm tra nếu tableModel chưa có dữ liệu thì mới load
                if (tableModel.getRowCount() == 0) {
                    loadData();
                }
                JOptionPane.showMessageDialog(this, "Thêm thành công! Vui lòng reload lại chương trình!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } // Xử lý sự kiện khi button Xóa được nhấn
        else if (e.getSource() == btnXoa) {
            // Get the selected row index
            int selectedRow = table.getSelectedRow();
            
            // Check if a row is selected
            if (selectedRow != -1) {
                // Get the primary key value of the selected row
                String maSP = (String) table.getValueAt(selectedRow, 0);
                
                // Kiểm tra xem mã sản phẩm có tham chiếu đến bảng khác không
                boolean isReferenced = checkIfReferenced(maSP);
                
                // Nếu mã sản phẩm được tham chiếu, hiển thị cảnh báo
                if (isReferenced) {
                    JOptionPane.showMessageDialog(this, "Dữ liệu maSP đã tham chiếu tới bảng ChiTietHoaDon_DonHang! Không thể xóa!",
                        "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Xóa dữ liệu từ SQL và cập nhật giao diện
                    try {
                        String deleteQuery = "DELETE FROM SanPham WHERE maSanPham = ?";
                        PreparedStatement statement = connection.prepareStatement(deleteQuery);
                        statement.setString(1, maSP);
                        int rowsDeleted = statement.executeUpdate();
                        statement.close();
                        
                        // Check if the row was deleted successfully
                        if (rowsDeleted > 0) {
                            // Remove the row from the JTable
                            tableModel.removeRow(selectedRow);
                            JOptionPane.showMessageDialog(this, "Xóa dữ liệu thành công!");
                        } else {
                            JOptionPane.showMessageDialog(this, "Xóa dữ liệu thất bại!");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Lỗi khi xóa dữ liệu từ cơ sở dữ liệu!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa trước!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }

	        

        else if (e.getSource() == btnUpdate) {
            handleUpdateButton(); // Gọi phương thức xử lý sự kiện cho nút "Update"
        }
        
        else if (e.getSource() == btnReload) {
            // Nút Reload được nhấn, cập nhật lại dữ liệu từ SQL
            tableModel.setRowCount(0); // Xóa hết dữ liệu hiện tại trong tableModel
            loadData(); // Load lại dữ liệu từ SQL vào tableModel
        }else if (e.getSource() == btnThoat) {
            System.exit(0);
        }
    }
    
 // Phương thức kiểm tra xem mã sản phẩm có tham chiếu tới bảng khác hay không
    private boolean checkIfReferenced(String maSP) {
        try {
            // Kiểm tra xem mã sản phẩm có tồn tại trong bảng DonHang
            String queryDonHang = "SELECT COUNT(*) FROM DonHang WHERE maSP = ?";
            PreparedStatement statementDonHang = connection.prepareStatement(queryDonHang);
            statementDonHang.setString(1, maSP);
            ResultSet resultSetDonHang = statementDonHang.executeQuery();
            resultSetDonHang.next();
            int countDonHang = resultSetDonHang.getInt(1);
            statementDonHang.close();
            
            // Kiểm tra xem mã sản phẩm có tồn tại trong bảng ChiTietHoaDon
            String queryChiTietHoaDon = "SELECT COUNT(*) FROM ChiTietHoaDon WHERE maSP = ?";
            PreparedStatement statementChiTietHoaDon = connection.prepareStatement(queryChiTietHoaDon);
            statementChiTietHoaDon.setString(1, maSP);
            ResultSet resultSetChiTietHoaDon = statementChiTietHoaDon.executeQuery();
            resultSetChiTietHoaDon.next();
            int countChiTietHoaDon = resultSetChiTietHoaDon.getInt(1);
            statementChiTietHoaDon.close();
            
            // Trả về true nếu mã sản phẩm được tham chiếu trong bảng DonHang hoặc ChiTietHoaDon
            return countDonHang > 0 || countChiTietHoaDon > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
 // Phương thức kiểm tra dữ liệu đầu vào trước khi cập nhật
    private boolean validateInput() {
        String tenSP = txtTen.getText();
        String hanSD = txtHanSuDung.getText();
        String donViTinh = txtDonViTinh.getText();
        String donGiaStr = txtDonGia.getText();
        String trongLuongStr = txtTrongLuong.getText();
        String soLuongStr = txtSoLuong.getText();
        
        // Kiểm tra dữ liệu đầu vào
        if (tenSP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống!");
            return false;
        }
        
        if (hanSD.isEmpty() || !hanSD.matches("\\d+ (ngày|tháng|năm|ngay|thang|nam)")) {
            JOptionPane.showMessageDialog(this, "Hạn sử dụng không hợp lệ!");
            return false;
        }
        
        if (donViTinh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Đơn vị tính không được để trống!");
            return false;
        }
        
        // Kiểm tra và chuyển đổi dữ liệu đầu vào
        double donGia, trongLuong;
        int soLuong;
        try {
            donGia = Double.parseDouble(donGiaStr);
            trongLuong = Double.parseDouble(trongLuongStr);
            soLuong = Integer.parseInt(soLuongStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ! Đơn giá, Trọng lượng và Số lượng phải là số!");
            return false;
        }
        
        if (donGia < 0) {
            JOptionPane.showMessageDialog(this, "Đơn giá phải là số không âm!");
            return false;
        }
        
        if (soLuong < 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên không âm!");
            return false;
        }
        
        if (trongLuong < 0) {
            JOptionPane.showMessageDialog(this, "Trọng lượng phải là số không âm!");
            return false;
        }
        
        return true;
    }

    
    
    // Phương thức xử lý sự kiện cho nút "Update"
    private void handleUpdateButton() {
    	// Kiểm tra dữ liệu đầu vào trước khi cập nhật
        if (!validateInput()) {
            return; // Kết thúc phương thức nếu dữ liệu đầu vào không hợp lệ
        }
        
        // Lấy mã sản phẩm hiện tại từ JTextField
        String maSPHienTai = txtMaSP.getText();
        
        // Lấy mã sản phẩm được chọn trên JTable
        int selectedRow = table.getSelectedRow();
        String maSPDuocChon = (String) table.getValueAt(selectedRow, 0); // Giả sử cột 0 chứa mã sản phẩm
        
        // Kiểm tra xem người dùng đã thay đổi mã sản phẩm hay không
        if (!maSPHienTai.equals(maSPDuocChon)) {
            JOptionPane.showMessageDialog(null, "Không được sửa đổi mã sản phẩm !!!");
            return; // Kết thúc phương thức nếu mã sản phẩm đã được thay đổi
        }
        
        // Lấy mã sản phẩm từ JTable
        String maSP = maSPDuocChon;
        
        // Lấy dữ liệu từ các JTextField và JComboBox
        String tenSP = txtTen.getText();
        String hanSD = txtHanSuDung.getText();
        String donViTinh = txtDonViTinh.getText();
        String maNCC = cboMaNCC.getSelectedItem().toString();
        double donGia, trongLuong;
        int soLuong;
        try {
            donGia = Double.parseDouble(txtDonGia.getText());
            trongLuong = Double.parseDouble(txtTrongLuong.getText());
            soLuong = Integer.parseInt(txtSoLuong.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ!");
            return;
        }

        // Kiểm tra và cập nhật dữ liệu trong cơ sở dữ liệu
        try {
            String updateQuery = "UPDATE SanPham SET ten = ?, hanSuDung = ?, trongLuong = ?, soLuong = ?, donViTinh = ?, donGia = ?, maNCC = ? WHERE maSanPham = ?";
            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.setString(1, tenSP);
            statement.setString(2, hanSD);
            statement.setDouble(3, trongLuong);
            statement.setInt(4, soLuong);
            statement.setString(5, donViTinh);
            statement.setDouble(6, donGia);
            statement.setString(7, maNCC);
            statement.setString(8, maSP);
            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Dữ liệu đã được cập nhật thành công!");
                loadData(); // Load lại dữ liệu từ cơ sở dữ liệu để cập nhật JTable
            } else {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu nào được cập nhật!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật dữ liệu!");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new main_SanPham().setVisible(true);
        });
    }
}
