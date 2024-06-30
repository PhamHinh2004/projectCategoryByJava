package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import model.KhachHang;
import view.GUI_TimKiemSanPham;
import view.Gui_BaoCaoDoanhThu;
import view.Gui_BaoCaoTheoThang;
import view.Gui_Home;
import view.Gui_Login;
import view.Gui_QuanLiKhachHang;
import view.Gui_QuanLiNhanVien;
import view.Gui_TimKiemKhachHang;
import view.Gui_TimKiemNhanVien;
import view.main_BanHang;
import view.main_NhaCungCap;
import view.main_SanPham;

public class SearchNhanVien_Action implements ActionListener, MouseListener{

	Gui_TimKiemNhanVien view ;
	
	public SearchNhanVien_Action(Gui_TimKiemNhanVien view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				// TODO Auto-generated method stub
		String str = e.getActionCommand();
    	if(str.trim().compareToIgnoreCase("TRANG CHỦ")==0) {
			this.view.setVisible(false);
			new Gui_Home();
		}
		else if(str.trim().compareToIgnoreCase("Đăng Xuất")==0) {
			this.view.setVisible(false);
			new Gui_Login();
		}
		else if(str.compareToIgnoreCase("Đóng")==0) {
			System.exit(0);
		}
		else if(str.compareToIgnoreCase("Quản lí sản phẩm")==0) {
			this.view.setVisible(false);
			new main_SanPham().setVisible(true);
		}
		else if(str.compareToIgnoreCase("Tìm kiếm sản phẩm")==0) {
			this.view.setVisible(false);
			new GUI_TimKiemSanPham();
		}
		else if(str.compareToIgnoreCase("Nhà cung cấp")==0) {
			this.view.setVisible(false);
			new main_NhaCungCap().setVisible(true);
		}
		else if(str.compareToIgnoreCase("Quản lí hóa đơn")==0) {
			this.view.setVisible(false);
			new main_BanHang().setVisible(true);
		}
		else if(str.compareToIgnoreCase("Quản lí Nhân Viên")==0) {
			this.view.setVisible(false);
			new Gui_QuanLiNhanVien();
		}
		else if(str.compareToIgnoreCase("Tìm kiếm Nhân Viên")==0) {
			this.view.setVisible(false);
			new Gui_TimKiemNhanVien();
		}
		else if(str.compareToIgnoreCase("Quản lí khách hàng")==0) {
			this.view.setVisible(false);
			new Gui_QuanLiKhachHang();
		}
		else if(str.compareToIgnoreCase("Tìm kiếm khách hàng")==0) {
			this.view.setVisible(false);
			new Gui_TimKiemKhachHang();
		}
		else if(str.compareToIgnoreCase("Báo cáo theo tháng")==0) {
			this.view.setVisible(false);
			new Gui_BaoCaoTheoThang();
		}
		else if(str.compareToIgnoreCase("Báo cáo Doanh thu")==0) {
			this.view.setVisible(false);
			new Gui_BaoCaoDoanhThu();
		}
						else if(str.compareToIgnoreCase("Tìm kiếm")==0) {
							if(this.view.textMaNV.getText().length()!=0) {
								if(this.view.timKiemTheoMa()) {
									JOptionPane.showMessageDialog(this.view, "Tìm kiếm thấy thành công!!!");
								}
								else {
									JOptionPane.showMessageDialog(this.view, "Tìm kiếm không thành công!!!");
									this.view.writeOnTable();
								}
							}
							else if(this.view.textTen.getText().length()!=0) {
								if(this.view.timKiemTen()) {
									JOptionPane.showMessageDialog(this.view, "Tìm kiếm thấy thành công!!!");
								}
								else {
									JOptionPane.showMessageDialog(this.view, "Tìm kiếm không thành công!!!");
									this.view.writeOnTable();
								}
							}
							else if(this.view.textSDT.getText().length()!=0) {
								if(this.view.timKiemSoDienThoai()) {
									JOptionPane.showMessageDialog(this.view, "Tìm kiếm thấy thành công!!!");
								}
								else {
									JOptionPane.showMessageDialog(this.view, "Tìm kiếm không thành công!!!");
									this.view.writeOnTable();
								}
							}
						}
						else if(str.compareToIgnoreCase("Refesh")==0) {
							this.view.refesh();
							this.view.writeOnTable();
						}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int location = this.view.tableNV.getSelectedRow();
		String maKH = (String) this.view.modelNV.getValueAt(location, 0);
		String ten = (String) this.view.modelNV.getValueAt(location, 1);
		String sdt = (String) this.view.modelNV.getValueAt(location, 2);
		String diaChi = (String) this.view.modelNV.getValueAt(location, 3);
		String gioiTinh = (String) this.view.modelNV.getValueAt(location, 4);
		
		this.view.thongTinVaoBang(new KhachHang(maKH, ten, sdt, diaChi, gioiTinh));
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
