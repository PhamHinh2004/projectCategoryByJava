package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Login_Action;
import dao.ManagementAccount;
import model.Account;

public class Gui_Login extends JFrame{
	private JTextField textUser;
	private JPasswordField textPass;
	ManagementAccount managementAccount ;
	public Gui_Login() {
		this.setSize(400,250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.managementAccount = new ManagementAccount();
		/*
		 * tao 1 panel để chứa toàn bộ các label vào form 
		 */
		JPanel formLogin = new JPanel();
		Box boxFormLogin = Box.createHorizontalBox();
		
		/*
		 * tạo 1 panel để chứa các label 
		 *
		 */
		JPanel panelLabel = new JPanel();
		Box boxPanelLabel = Box.createVerticalBox();
		JLabel labelUser = new JLabel("User:");
		labelUser.setFont(new Font("Arial",Font.BOLD,16));
		JLabel labelPass = new JLabel("Password:");
		labelPass.setFont(new Font("Arial",Font.BOLD,16));
		boxPanelLabel.add(Box.createVerticalStrut(5));
		boxPanelLabel.add(labelUser);
		boxPanelLabel.add(Box.createVerticalStrut(25));
		boxPanelLabel.add(labelPass);
		panelLabel.add(boxPanelLabel);
		
		/*
		 * 
		 * tạo 1 panel để chứa toàn bộ các  jtextfield nhập 
		 */
		JPanel panelText = new JPanel();
		Box boxPanelText = Box.createVerticalBox();
		textUser = new  JTextField(20);
//		textUser.add
		textPass = new  JPasswordField(20);
		boxPanelText.add(textUser);
		boxPanelText.add(Box.createVerticalStrut(15));
		boxPanelText.add(textPass);
		panelText.add(boxPanelText);
		
		// add panelLabel và text vào panelLogin
		boxFormLogin.add(panelLabel);
		boxFormLogin.add(panelText);
		formLogin.add(boxFormLogin);
		
		
		JPanel panelButton = new JPanel();
		Box boxPanelButton = Box.createHorizontalBox();
		JButton buttonLogin = new JButton("LOGIN");
		buttonLogin.setFont(new Font("Arial",Font.BOLD,18));
		JButton buttonClose = new JButton("CLose");
		buttonClose.setFont(new Font("Arial",Font.BOLD,18));
		
		boxPanelButton.add(buttonLogin);
		boxPanelButton.add(Box.createHorizontalStrut(100));
		boxPanelButton.add(buttonClose);
		panelButton.add(boxPanelButton);
		
		this.add(formLogin,BorderLayout.CENTER);
		this.add(panelButton,BorderLayout.SOUTH);
		this.setVisible(true);
		
		// add action for buttons 
		ActionListener  ac = new Login_Action(this);
		buttonLogin.addActionListener(ac);
		buttonClose.addActionListener(ac);
		
		//get data account from database
		managementAccount.add();
	}
	
	public boolean checkLogin() {
		ArrayList<Account> list = managementAccount.getList();
		String username = this.textUser.getText();
		char[] charsPassword = this.textPass.getPassword();
		String password = ""; 
		for(int i=0; i < charsPassword.length ;i++ ) {
			password += charsPassword[i];	
		}
		
		for (Account account : list) {
			if(account.getUserName().compareToIgnoreCase(username)==0) {
				if(account.getPassWord().compareToIgnoreCase(password)==0) {
					return true;
				}
				else {
					JOptionPane.showMessageDialog(this,"Nhập sai password!!!");
					this.textPass.requestFocus();
					return false;
				}
			}
		}
		JOptionPane.showMessageDialog(this, "tài khoản không tồn tại" );
		return false;
	}
}
