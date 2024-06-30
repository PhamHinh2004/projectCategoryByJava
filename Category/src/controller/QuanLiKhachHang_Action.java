package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

//import view.Gui_BaoCaoDoanhThu;
//import view.Gui_BaoCaoTheoThang;
//import view.Gui_Login;
import view.*;
import model.*;
import dao.*;

public class QuanLiKhachHang_Action implements ActionListener, MouseListener{
	Gui_QuanLiKhachHang view ;
	
	
	public QuanLiKhachHang_Action(Gui_QuanLiKhachHang view) {
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
				else if(str.compareToIgnoreCase("Thêm")==0) {
					if(this.view.chinhQuy()) {
						if(this.view.themKhachHang()) {
							JOptionPane.showMessageDialog(this.view, "Thêm thành công !!!");
							this.view.refesh();
						}
						else {
							JOptionPane.showMessageDialog(this.view, "Không được trùng mã !!!");
						}
					}
				}
				else if(str.compareToIgnoreCase("Xóa")==0) {
					if(this.view.xoa()) {
						this.view.refesh();
						JOptionPane.showMessageDialog(this.view, "Xóa thành công !!!");
						this.view.refesh();
					}
				}
				else if(str.compareToIgnoreCase("Sửa")==0) {
					if(this.view.chinhQuy()) {
						if(this.view.updateKhachHang()) {
							JOptionPane.showMessageDialog(this.view, "Cập nhật thành công");
							this.view.refesh();
						}
						else {
							JOptionPane.showMessageDialog(this.view, "Cập nhật không thành công");
							this.view.refesh();
						}
					}
				}
				else if(str.compareToIgnoreCase("Refesh")==0) {
					this.view.refesh();
				}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		int location = this.view.tableKH.getSelectedRow();
		String maKH = (String) this.view.modelKH.getValueAt(location, 0);
		String ten = (String) this.view.modelKH.getValueAt(location, 1);
		String sdt = (String) this.view.modelKH.getValueAt(location, 2);
		String diaChi = (String) this.view.modelKH.getValueAt(location, 3);
		String gioiTinh = (String) this.view.modelKH.getValueAt(location, 4);
		
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
