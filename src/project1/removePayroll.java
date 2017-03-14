package project1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


class ModifyInfo extends JFrame
	{Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	
		Container c=getContentPane();
		JTable table;
		JPanel main;
		DefaultTableModel model;
		Payrolldialog mdl;
		String stcode;
		ModifyInfo()
		{
			setSize(900,600);
			setTitle("Discharge Information");
			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					payroll sam=new payroll();
					sam.setVisible(true);
					sam.setSize(490,510);
					sam.setLocationRelativeTo(null);
					payroll_list.setDefaultLookAndFeelDecorated(true);
					setVisible(false);
					
				}});
			
			ModifyInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
			JLabel l=new JLabel("<html><font size=5 color=#800080><i>Select Row To Modify");
			JPanel title=new JPanel()
			{
				public void paintComponent(Graphics g)
				{

					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("images//HEADER.gif");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,1200,100,null);
				}
			};
			title.add(l);
			c.add("North",title);

			main=new JPanel();
			main.setLayout(new BorderLayout());
			
			try
			{
				 String url = "jdbc:mysql://localhost:3306/rakedomanagement";
	 			
	 			con = DriverManager.getConnection(url,"root","");
	 			stmt=con.createStatement();
				ResultSet set=stmt.executeQuery("select * from payroll");
				int row=0;
				int i=0;
				while(set.next())
				{
					row++;
				}
				//DefaultTableModel model=new DefaultTableModel(new String[]{"Time","Date","Diping_b4_Discharge","Depot Value","Dip.After_Discharge","Total LTR Disharge","Shortage"},row);
				DefaultTableModel model=new DefaultTableModel(new String[]{"Date","Time","sId ","fName","gender","email","phone_Num.","Position","Certification","Guar.Name","Guar.Number","month","year","amount","bonus","others"},row);
				
				
				table=new JTable(model);
				set=stmt.executeQuery("select * from payroll");
				while(set.next())
				{
					model.setValueAt(set.getString(1).trim(),i,0);
					model.setValueAt(set.getString(2).trim(),i,1);
					model.setValueAt(set.getString(3).trim(),i,2);
					model.setValueAt(set.getString(4).trim(),i,3);
					model.setValueAt(set.getString(5).trim(),i,4);
					model.setValueAt(set.getString(6).trim(),i,5);
					model.setValueAt(set.getString(7).trim(),i,6);
					model.setValueAt(set.getString(8).trim(),i,7);
					model.setValueAt(set.getString(9).trim(),i,8);
					model.setValueAt(set.getString(10).trim(),i,9);
					model.setValueAt(set.getString(11).trim(),i,10);
					model.setValueAt(set.getString(12).trim(),i,11);
					model.setValueAt(set.getString(13).trim(),i,12);
					model.setValueAt(set.getString(14).trim(),i,13);
					model.setValueAt(set.getString(15).trim(),i,14);
					model.setValueAt(set.getString(16).trim(),i,15);
					
					
					i++;
				}
				table=new JTable(model);
			}
			catch(Exception ex)
			{
			}
			JScrollPane sp=new JScrollPane(table);
			main.add(sp);
			//table.addMouseListener(new ModifyStudList());
			table.setSelectionMode(0);
			table.setToolTipText("Select The ROW For Modify");
			table.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			table.setColumnSelectionAllowed(false);
			table.setSelectionMode(1);
			table.setEditingColumn(3);
			table.setFont(new Font("Times New Roman",Font.PLAIN,13));
			table.setForeground(Color.MAGENTA);
			table.setGridColor(new Color(0,128,192));
		  	//table.setBackground(new Color(0,128,192));
	        table.getTableHeader().setReorderingAllowed(false);
	        c.add(main);
		}}