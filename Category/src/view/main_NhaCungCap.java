package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class main_NhaCungCap extends JFrame implements ActionListener {
    private Connection connection;
    private DefaultTableModel tableModel;
    private JTextField txtMaNCC, txtTen, txtDiaChi, txtSoDienThoai;
    private JButton btnThem, btnXoa, btnUpdate, btnThoat;
    private JButton btnReload;
    private JTable table;
	private ImageIcon icon;

    public main_NhaCungCap() {
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
        JLabel lblTieuDe = new JLabel("THÔNG TIN NHÀ CUNG CẤP");
        pnlNorth.add(lblTieuDe);
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
        lblTieuDe.setForeground(Color.BLUE);

        JPanel pnlCenter = new JPanel(new BorderLayout());
        add(pnlCenter, BorderLayout.CENTER);

//        tableModel = new DefaultTableModel();
//        table = new JTable(tableModel);
//        JScrollPane scrollPane = new JScrollPane(table);
//        pnlCenter.add(scrollPane, BorderLayout.CENTER);

        
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel); // Thêm dòng này để khởi tạo table
        JScrollPane scrollPane = new JScrollPane(table);
        pnlCenter.add(scrollPane, BorderLayout.CENTER);
        
        
        
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

        // Thêm các JTextField vào giao diện
        JPanel pnlInputs = new JPanel(new GridLayout(4, 2));
        pnlCenter.add(pnlInputs, BorderLayout.NORTH);

        pnlInputs.add(new JLabel("Mã nhà cung cấp:"));
        txtMaNCC = new JTextField();
        pnlInputs.add(txtMaNCC);

        pnlInputs.add(new JLabel("Tên nhà cung cấp:"));
        txtTen = new JTextField();
        pnlInputs.add(txtTen);

        pnlInputs.add(new JLabel("Địa chỉ:"));
        txtDiaChi = new JTextField();
        pnlInputs.add(txtDiaChi);

        pnlInputs.add(new JLabel("Số điện thoại:"));
        txtSoDienThoai = new JTextField();
        pnlInputs.add(txtSoDienThoai);

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

        initDatabase();
        loadData();
        
     // Xử lý sự kiện khi lựa chọn hàng trong JTable
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                    int selectedRow = table.getSelectedRow();
                    txtMaNCC.setText(table.getValueAt(selectedRow, 0).toString());
                    txtTen.setText(table.getValueAt(selectedRow, 1).toString());
                    txtDiaChi.setText(table.getValueAt(selectedRow, 2).toString());
                    txtSoDienThoai.setText(table.getValueAt(selectedRow, 3).toString());
                }
            }
        });
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
            String selectQuery = "SELECT * FROM NhaCungCap";
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
            // Lấy dữ liệu từ các JTextField
            String maNCC = txtMaNCC.getText();
            String tenNCC = txtTen.getText();
            String diaChi = txtDiaChi.getText();
            String soDienThoai = txtSoDienThoai.getText();
            
            
            // Kiểm tra các điều kiện
            if (maNCC.isEmpty() || !maNCC.matches("NCC\\d{1,}")) {
                JOptionPane.showMessageDialog(this, "Mã NCC không hợp lệ! Bắt đầu = NCC theo sau là số !");
                return;
            }

            if (tenNCC.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tên không được để trống!");
                return;
            }

            if (diaChi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!");
                return;
            }

            if (soDienThoai.isEmpty() || !soDienThoai.matches("\\d{11}")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ! Bao gồm 11 số");
                return;
            }
            
            // Kiểm tra xem mã NCC có trùng không
            try {
                String query = "SELECT COUNT(*) FROM NhaCungCap WHERE maNCC = ?";
                PreparedStatement checkStatement = connection.prepareStatement(query);
                checkStatement.setString(1, maNCC);
                ResultSet resultSet = checkStatement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(this, "Mã NCC đã tồn tại!");
                    return;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            // Thêm dữ liệu vào SQL
            try {
                String insertQuery = "INSERT INTO NhaCungCap (maNCC, ten, diaChi, soDienThoai) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(insertQuery);
                statement.setString(1, maNCC);
                statement.setString(2, tenNCC);
                statement.setString(3, diaChi);
                statement.setString(4, soDienThoai);
                statement.executeUpdate();
                statement.close();
                
                // Hiển thị thông báo thêm thành công
                JOptionPane.showMessageDialog(this, "Thêm thành công! Vui lòng Reload lại chương trình!");
                
                // Kiểm tra nếu tableModel chưa có dữ liệu thì mới load
                if (tableModel.getRowCount() == 0) {
                    loadData();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } // Xử lý sự kiện khi button Xóa được nhấn
     else if (e.getSource() == btnXoa) {
        // Lấy số hàng đã chọn trong bảng
        int selectedRow = table.getSelectedRow();
        
        // Kiểm tra xem có hàng nào được chọn không
        if (selectedRow != -1) {
            // Lấy mã nhà cung cấp của hàng được chọn
            String maNCC = (String) table.getValueAt(selectedRow, 0);
            
            // Kiểm tra xem mã nhà cung cấp có được tham chiếu trong bảng SanPham không
            boolean isReferenced = checkIfReferenced(maNCC);
            
            // Nếu mã nhà cung cấp được tham chiếu, hiển thị cảnh báo
            if (isReferenced) {
                JOptionPane.showMessageDialog(this, "Dữ liệu maNCC đã tham chiếu tới bảng SanPham! Không thể xóa!",
                    "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            } else {
                // Tiến hành xóa dữ liệu từ cơ sở dữ liệu
                try {
                    String deleteQuery = "DELETE FROM NhaCungCap WHERE maNCC = ?";
                    PreparedStatement statement = connection.prepareStatement(deleteQuery);
                    statement.setString(1, maNCC);
                    int rowsDeleted = statement.executeUpdate();
                    statement.close();
                    
                    // Kiểm tra xem hàng đã được xóa thành công hay không
                    if (rowsDeleted > 0) {
                        // Xóa hàng từ tableModel
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
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }


        
        else if (e.getSource() == btnUpdate) {
        	// Lấy dữ liệu từ các JTextField
            String maNCC = txtMaNCC.getText();
            String tenNCC = txtTen.getText();
            String diaChi = txtDiaChi.getText();
            String soDienThoai = txtSoDienThoai.getText();

            // Kiểm tra các điều kiện
            if (tenNCC.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tên không được để trống!");
                return;
            }

            if (diaChi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!");
                return;
            }

            if (soDienThoai.isEmpty() || !soDienThoai.matches("\\d{11}")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ! Bao gồm 11 số");
                return;
            }
            
            // Kiểm tra xem có hàng được chọn không
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để cập nhật!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Lấy mã NCC của hàng được chọn
            String selectedMaNCC = (String) table.getValueAt(selectedRow, 0);
            
            // Kiểm tra xem mã NCC đã được thay đổi hay không
            if (!selectedMaNCC.equals(maNCC)) {
                JOptionPane.showMessageDialog(this, "Không được phép thay đổi mã NCC khi cập nhật!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Tiến hành cập nhật dữ liệu vào SQL
            try {
                String updateQuery = "UPDATE NhaCungCap SET ten = ?, diaChi = ?, soDienThoai = ? WHERE maNCC = ?";
                PreparedStatement statement = connection.prepareStatement(updateQuery);
                statement.setString(1, tenNCC);
                statement.setString(2, diaChi);
                statement.setString(3, soDienThoai);
                statement.setString(4, maNCC);
                int rowsUpdated = statement.executeUpdate();
                statement.close();

                // Kiểm tra xem hàng đã được cập nhật thành công hay không
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Cập nhật dữ liệu thành công!");
                    // Cập nhật lại dữ liệu trong tableModel
                    tableModel.setValueAt(tenNCC, selectedRow, 1);
                    tableModel.setValueAt(diaChi, selectedRow, 2);
                    tableModel.setValueAt(soDienThoai, selectedRow, 3);
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật dữ liệu thất bại!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật dữ liệu vào cơ sở dữ liệu!");
            }
        } else if (e.getSource() == btnReload) {
            // Nút Reload được nhấn, cập nhật lại dữ liệu từ SQL
            tableModel.setRowCount(0); // Xóa hết dữ liệu hiện tại trong tableModel
            loadData(); // Load lại dữ liệu từ SQL vào tableModel
        } else if (e.getSource() == btnThoat) {
            System.exit(0);
        }
        
        
        else if (e.getSource() == btnReload) {
            // Nút Reload được nhấn, cập nhật lại dữ liệu từ SQL
            tableModel.setRowCount(0); // Xóa hết dữ liệu hiện tại trong tableModel
            loadData(); // Load lại dữ liệu từ SQL vào tableModel
        } else if (e.getSource() == btnThoat) {
            System.exit(0);
        }
    }
    
    private boolean checkIfReferenced(String maNCC) {
        try {
            String query = "SELECT COUNT(*) FROM SanPham WHERE maNCC = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, maNCC);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new main_NhaCungCap().setVisible(true);
        });
    }
}
