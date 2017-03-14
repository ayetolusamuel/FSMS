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
class StaffContact extends JFrame
{
	JPanel main=new JPanel();
	Container c=getContentPane();
	private JTable table;
	Connection conn;
	Statement st;
	JComboBox cmb;
	JButton print;
	JButton cancle;
	StaffContact()
	{
		setSize(620,520);
		setTitle("Staff's Contact");
		setLocation(240,80);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		//StudentByCourseReport.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
		c=getContentPane();

		main.setLayout(new BorderLayout());
		main.setBackground(new Color(245,240,255));
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Staff's Contact");
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
				StaffsInfo sam=new StaffsInfo();
				sam.setVisible(true);
				sam.setSize(800,690);
				sam.setLocation(100,20);
				
				
				
				
				
				
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
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D://database//rakedomanagement.mdb;DriverID=22;READONLY=true) ","","");

			String url = "jdbc:mysql://localhost:3306/rakedomanagement";
			try {
				// con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver "
				// +
				// "(*.mdb)};"+"DBQ=D:\\database\\rakedomanagement.mdb","ayets","setonji04");

				conn = DriverManager.getConnection(url, "root", "");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,
						"Failed Connection,ON your Local Server", "Error",
						JOptionPane.ERROR_MESSAGE);

				// e1.printStackTrace();
			}
			
			
			
			st=conn.createStatement();
			ResultSet set=st.executeQuery("select * from staff ");
			int row=0;
			int i=0;
			while(set.next())
			{
				row++;
			}
			DefaultTableModel model=new DefaultTableModel(new String[]{"Staff_ID","F_Name","Email ","Mobile Number "},row);
			table=new JTable(model);
			set=st.executeQuery("select * from staff");
			while(set.next())
			{
				model.setValueAt(set.getString(1).trim(),i,0);
				model.setValueAt(set.getString(2).trim(),i,1);
				model.setValueAt(set.getString(5).trim(),i,2);
				model.setValueAt(set.getString(7).trim(),i,3);
				
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
        table.getTableHeader().setReorderingAllowed(false);
        c.add(main);
	}
public static void main(String args []){
	StaffContact sa=new StaffContact();
	sa.setSize(1200, 520);
	sa.setLocation(12, 10);
	sa.setVisible(true);}
	
}








