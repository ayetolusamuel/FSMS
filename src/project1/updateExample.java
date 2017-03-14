package project1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class updateExample extends JFrame implements ActionListener{
	private JLabel lblName,lblEmail;
	private JTextField txtName,txtEmail;
	private JPanel pane;
	Connection conn;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;
	
	private JButton btnLogin,btnCancel;
	public updateExample() {
		pane=new JPanel();
		pane.setLayout(null);
		lblName =new JLabel("<html><i>Name :");
		pane.add(lblName).setBounds(12,10,100,25);
		txtName =new JTextField();
		pane.add(txtName).setBounds(80,12,120,20);
		
		lblEmail =new JLabel("<html><i>Email :");
		pane.add(lblEmail).setBounds(12,40,100,25);
		txtEmail =new JTextField();
		pane.add(txtEmail).setBounds(80,42,120,20);
		
		
		
		btnLogin=new JButton("Login");
		pane.add(btnLogin).setBounds(30,80,100,25);
btnLogin.addActionListener(this);
		btnCancel=new JButton("Cancel");
		pane.add(btnCancel).setBounds(140,80,100,25);
		btnCancel.addActionListener(this);
		
		getContentPane().add(pane,BorderLayout.CENTER);
		
		
	try {
		conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D://database//samuel.mdb;DriverID=22;READONLY=true) ","","");
	System.out.println("Connected");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
	try {
		rs = st.executeQuery("SELECT * from login WHERE attendance = '" +"Present"+ "' ");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static void main(String[] args) {
		updateExample sa =new updateExample();
		sa.setVisible(true);
		sa.setSize(300,200);
		sa.setLocationRelativeTo(null); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
