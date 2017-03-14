package project1;

//LoginForm.java
// Created By: Jake Rodriguez Pomperada, MAED - Instructional Technology
// Email : jakerpomperada@yahoo.com
// May 14, 2009 Wednesday

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class LoginForm extends JFrame
{
	private JLabel labelPrompt;
	private JLabel labelUserName;
	private JLabel labelPassword;
	private JTextField userNameTextField;
	private JPasswordField passwordField;
	private JButton okButton;
	public String p="123"; // p for password
	public String u="123";  // u for username

	public LoginForm()
	{
		getContentPane().setLayout(new FlowLayout());

		labelPrompt=new JLabel("Enter User name and Password");
		getContentPane().add(labelPrompt);
		labelUserName=new JLabel("UserName");
		labelUserName.setHorizontalTextPosition(SwingConstants.LEFT);
		getContentPane().add(labelUserName);
		userNameTextField=new JTextField(10);
		getContentPane().add(userNameTextField);
		labelPassword=new JLabel("Password");
		getContentPane().add(labelPassword);
		passwordField=new JPasswordField(10);
		getContentPane().add(passwordField);
		okButton=new JButton("Login");
		getContentPane().add(okButton);

		//Register Action

		LoginHandler h=new LoginHandler();
		okButton.addActionListener(h);
		passwordField.addActionListener(h);
	}


	private class LoginHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==okButton||e.getSource()==passwordField)
			{
				if(	p.equals(passwordField.getText())&& u.equals(userNameTextField.getText()))
				{
					setVisible(false);
                 	     	JOptionPane.showMessageDialog(null,"Password Accepted...","Welcome to the System",JOptionPane.WARNING_MESSAGE);
	    	   	System.exit(0);
		     	}
		     	else
		     	JOptionPane.showMessageDialog(null,"Access Denied!","Intruder Detected",JOptionPane.WARNING_MESSAGE);
			System.exit(0);
			}

		}

	}
public static void main (String args[])
 		{
 				LoginForm lf=new LoginForm();
 				lf.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        	lf.setSize(200,150);
	        	lf.setLocation(200,150);
				lf.setVisible(true);
		}
 }

// End of Code