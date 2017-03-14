package project1;



import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
class Search_Dialog extends JFrame implements ActionListener
{
	ResultSet rs=null;
	Connection con=null;
	Statement st=null;
	PreparedStatement ps=null;

	
	JTextField txtsId;
	JButton ok;
	JButton cancel;
	JPanel cntpan;
	Container c;
	JLabel lblsId;
	Search_Dialog()
	
	{
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				
				
				
				 StaffsInfo sa=new  StaffsInfo();
				 sa.setLocationRelativeTo(null);
				 sa.setVisible(true);
				setVisible(false);
				
			}
		});
		
		c=getContentPane();
		cntpan=new JPanel();
		cntpan.setLayout(null);
		
		
		c.add(cntpan);
		lblsId=new JLabel("<html><i>Staff Name");
		lblsId.setFont(new Font("Times New Roman",Font.PLAIN,16));
		cntpan.add(lblsId).setBounds(90,10,100,20);
		txtsId=new JTextField();
		txtsId.setFont(new Font("Times New Roman",Font.ITALIC,20));
		cntpan.add(txtsId).setBounds(180,12,100,20);
		
		ok=new JButton("Search");
		ok.addActionListener(this);
		ok.setFont(new Font("Times New Roman",Font.PLAIN,16));
		cntpan.add(ok).setBounds(60,60,100,20);
		
		
		cancel=new JButton("Cancel");
		cancel.addActionListener(this);
		cancel.setFont(new Font("Times New Roman",Font.PLAIN,16));
		cntpan.add(cancel).setBounds(180,60,100,20);
		
		JLabel lbl1 = new JLabel(new ImageIcon("images//icon2.jpg"));
		lbl1.setBounds(-150,-30,400,120);
		cntpan.add(lbl1);
		JLabel lbl2 = new JLabel(new ImageIcon("images//plain.jpg"));
		lbl2.setBounds(0,0,400,120);
		cntpan.add(lbl2);
		 
		 
		getContentPane().add(cntpan,BorderLayout.CENTER);
	
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		Object obj = e.getSource();
		
		if(obj==cancel){

			 StaffsInfo sa=new  StaffsInfo();
			 sa.setLocationRelativeTo(null);
			 sa.setVisible(true);
			setVisible(false);
			
			
		}
		else if(txtsId.getText().length()==0){
			Icon error=new ImageIcon("images//error.png");
			JOptionPane.showMessageDialog(null,"<html><font size=4 color=red>Staff field cant be empty</font></html>","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE,error);
	
		}
			
		
		else if(obj==ok){
			String ftext=txtsId.getText().trim();
			System.out.println("record founds");
			dispose();
			JOptionPane.showMessageDialog(null, "Record Found");
			Search_Staff ss=new Search_Staff(ftext);
			
			
			ss.setVisible(true);
			
			
		//OptionPane.showConfirmDialog(null, "Result Found");
		
			dispose();
			}
		else
		{
			System.out.println("No such Staff");
		}
	}


public static void main(String[] args) {
		
		Search_Dialog sa=new Search_Dialog();
		sa.setVisible(true);
		sa.setSize(400, 140);
		sa.setLocationRelativeTo(null);
		sa.setResizable(true);
		
		
	
	
}}