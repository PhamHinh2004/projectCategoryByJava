package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Gui_Home;
import view.Jmenu;

public class Jmenu_ACtion implements ActionListener {
	Jmenu jmenu;
	

	public Jmenu_ACtion(Jmenu jmenu) {
		super();
		this.jmenu = jmenu;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if(str.trim().compareToIgnoreCase("Đăng Xuất")==0) {
			System.out.println("Hiển thị sigin");
		}
		else if(str.compareToIgnoreCase("Đóng")==0) {
			System.exit(0);
		}
		else if(str.compareToIgnoreCase("Quản lí sản phẩm")==0) {
			System.out.println("quản lí sản phẩm");
		}
		else if(str.compareToIgnoreCase("Tìm kiếm")==0) {
			System.out.println("Tìm kiếm sản phẩm");
		}
		else if(str.compareToIgnoreCase("Loại sản phẩm")==0) {
			System.out.println("Loại sản phẩm");
		}
		else if(str.compareToIgnoreCase("Nhà cung cấp")==0) {
			System.out.println("nhà cung cấp");
		}
		else if(str.compareToIgnoreCase("Quản lí hóa đơn")==0) {
			System.out.println("Quản lí hóa đơn");
		}
		else if(str.compareToIgnoreCase("Quản lí Nhân Viên")==0) {
			System.out.println("Quản lí nhân viên");
		}
		else if(str.compareToIgnoreCase("Tìm kiếm Nhân Viên")==0) {
			System.out.println("Tìm kiếm Nhân Viên");
		}
		else if(str.compareToIgnoreCase("Quản lí khách hàng")==0) {
			System.out.println("Quản lí khách hàng");
		}
		else if(str.compareToIgnoreCase("Tìm kiếm khách hàng")==0) {
			System.out.println("Tìm kiếm khách hàng");
		}
		else if(str.compareToIgnoreCase("Báo cáo theo tháng")==0) {
			System.out.println("Báo cáo theo tháng");
		}
		else if(str.compareToIgnoreCase("Báo cáo Doanh thu")==0) {
			System.out.println("Báo cáo Doanh thu");
		}
	}

}
