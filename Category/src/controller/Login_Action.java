package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Gui_Home;
import view.Gui_Login;


public class Login_Action implements ActionListener {
	Gui_Login view ;
	
	public Login_Action(Gui_Login gui) {
		super();
		this.view = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if(str.compareToIgnoreCase("LOGIN")==0) {
			if(this.view.checkLogin()) {
				this.view.setVisible(false);
				new Gui_Home();
			}
		}
		else {
			System.exit(0);
		}
	}
	
}
