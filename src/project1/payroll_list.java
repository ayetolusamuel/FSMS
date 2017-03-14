package project1;



import javax.swing.*;
import javax.swing.plaf.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.plaf.metal.*;

import java.sql.*;
import java.io.*;

import javax.swing.event.*;
import javax.swing.table.*;

import java.awt.print.*;
class payroll_list extends JFrame
{
	JPanel main=new JPanel();
	Container c=getContentPane();
	private JTable table;
	Connection conn;
	Statement st;
	JComboBox cmb;
	JButton print;
	JButton cancle;
	payroll_list()
	{
		setSize(620,520);
		setTitle("Payroll List");
		setLocation(240,80);

		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					StaffsInfo sam=new StaffsInfo();
					sam.setVisible(true);
					sam.setLocationRelativeTo(null);
					payroll_list.setDefaultLookAndFeelDecorated(true);
					setVisible(false);
					
				}
			});
		//StudentByCourseReport.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
		c=getContentPane();

		main.setLayout(new BorderLayout());
		main.setBackground(new Color(245,240,255));
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Payroll Report");
		JPanel title=new JPanel()
		{
			public void paintComponent(Graphics g)
			{

				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//Gradien.jpg");
				
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
				g.drawImage(img,0,0,1350,50,null);
			}
		};
		title.add(l);
		main.add("North",title);
		Icon prt=new ImageIcon("images//PRINT.png");
		print=new JButton("Print",prt);
		print.setToolTipText("Print");
		cancle=new JButton("Exit");
		cancle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				payroll sam=new payroll();
				sam.setVisible(true);
				sam.setSize(490,510);
				sam.setLocationRelativeTo(null);
				payroll_list.setDefaultLookAndFeelDecorated(true);
				setVisible(false);
				
				
			}
		});
		print.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				PrinterJob jb=PrinterJob.getPrinterJob();
				jb.printDialog();
				
			}
		});
		cancle.setToolTipText("Exit");
		JPanel butpan=new JPanel();
		butpan.add(print);
		butpan.add(cancle);
		butpan.setBackground(new Color(255,197,68));
		c.add("South",butpan);
		try
		{
			
			

   			String url = "jdbc:mysql://localhost:3306/rakedomanagement";
   			
   				//con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
   			          // "(*.mdb)};"+"DBQ=D:\\database\\rakedomanagement.mdb","ayets","setonji04");
   				
   			conn = DriverManager.getConnection(url,"root","");
   		
   			System.out.println("connected");
			/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D://database//rakedomanagement.mdb;DriverID=22;READONLY=true) ","","");
		*/	st=conn.createStatement();
			ResultSet set=st.executeQuery("select * from payroll ");
			int row=0;
			int i=0;
			while(set.next())
			{
				row++;
			}
			// model=new DefaultTableModel(new String[]{"Date","Time","sId ","fNAme","gender","email","phone_Num.","Position","Certification","Guar.Name","Guar.Number","month","year","amount","bonus","others"},row);
				
			DefaultTableModel model=new DefaultTableModel(new String[]{"Date","Time","staffId ","fName","gender","email","phone_Num.","Position","Certification","Guar.Name","Guar.Number","month","year","amount","bonus","others"},row);
			table=new JTable(model);
			set=st.executeQuery("select * from payroll");
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
		table.setSelectionMode(0);
		table.setFont(new Font("Times New Roman",Font.PLAIN,13));
		table.setForeground(Color.MAGENTA);
		table.setGridColor(new Color(0,128,192));
	  	//table.setBackground(new Color(0,128,192));
        table.getTableHeader().setReorderingAllowed(true);
        c.add(main);
	}
public static void main(String args []){
	payroll_list sa=new payroll_list();
	sa.setSize(1200, 520);
	sa.setLocation(12, 10);
	sa.setVisible(true);}
	
}








