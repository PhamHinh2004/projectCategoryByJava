package test;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.GUI_TimKiemSanPham;
import view.Gui_Home;
import view.Gui_Login;
import view.main_BanHang;

public class test {
	public static void main(String[] args) {
//		new Gui_Login();
		try {
	        // Set cross-platform Java L&F (also called "Metal")
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	} 
	catch (UnsupportedLookAndFeelException e) {
	   // handle exception
	}
	catch (ClassNotFoundException e) {
	   // handle exception
	}
	catch (InstantiationException e) {
	   // handle exception
	}
	catch (IllegalAccessException e) {
	   // handle exception
	}   	
		new Gui_Login();
	}
}	
	