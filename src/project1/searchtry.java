/*
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



class Search_Staff extends JFrame
{
	JPanel main=new JPanel();
	Container c=getContentPane();
	private JTable table;
	Connection conn;
	Connection conn2;
	String sID=null;
	Statement st;
	JButton ok;
	DefaultTableModel model;
	Search_Staff(String sid)
	{
		setSize(800,590);
		setTitle("Search Result");
		setLocation(24,80);
	
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				
				
				
				 StaffInfo sa=new  StaffInfo();
				 sa.setLocationRelativeTo(null);
				 
				sa.setVisible(true);
				MainMenuFrame sam=new MainMenuFrame();
				sam.setVisible(true);
				dis_charge_report.setDefaultLookAndFeelDecorated(true);
				setVisible(false);
				
				
				
			}
		});
		try
		{
			setAlwaysOnTop(true);
		}
		catch(Exception es){}
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));

		main.setLayout(new BorderLayout());
		main.setBackground(new Color(245,240,255));
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Search Result");
		JPanel title=new JPanel()
		{
			public void paintComponent(Graphics g)
			{

				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//Gradient2.jpg");
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
				g.drawImage(img,0,0,620,50,null);
			}
		};
		title.add(l);
		main.add("North",title);
		ok=new JButton("Ok");
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		ok.setToolTipText("Ok");
		JPanel butpan=new JPanel();
		butpan.add(ok);
		butpan.setBackground(new Color(255,197,68));
		c.add("South",butpan);
		
	
		
		try
		{
			String url = "jdbc:mysql://localhost:3306/rakedomanagement";
			conn = DriverManager.getConnection(url,"root","");
				st=conn.createStatement();
				
			ResultSet set=st.executeQuery("select * from staff");
			
			int row=0;
			int i=0;

			PreparedStatement prs=null;
			while(set.next())
			{
			
				//prs=conn.prepareStatement("select * from staff where staffid=?");
			
				
				prs.setString(1,sid);
				ResultSet ss=prs.executeQuery();
				while(ss.next())
				{
					row++;
				}

			}
			set.close();

			// Display search Result On Table
			//model=new DefaultTableModel(new String[]{"staff_Id","F_Name","Position","Email","Mobile No","Guarantor_Name","Guar.Mobile No"},row);
			//set=st.executeQuery("select * from staff");
			while(set.next())
			{
				
				// String query = "select * from details where sid like '".getText()+"'";
				model=new DefaultTableModel(new String[]{"staff_Id","F_Name","Position","Email","Mobile No","Guarantor_Name","Guar.Mobile No"},row);
				
			prs=conn.prepareStatement("select * from staff where staffid=? ");
				prs.setString(1,sid);
				
				ResultSet ss=prs.executeQuery();
				while(ss.next())
				{
					
					model.setValueAt(ss.getString(1).trim(),i,0);
					model.setValueAt(ss.getString(2).trim(),i,1);
					model.setValueAt(ss.getString(3).trim(),i,2);
					model.setValueAt(ss.getString(4).trim(),i,3);
					model.setValueAt(ss.getString(5).trim(),i,4);
					model.setValueAt(ss.getString(6).trim(),i,5);
					model.setValueAt(ss.getString(7).trim(),i,6);
					
					
					

					model.setValueAt(ss.getString(1).trim(),i,0);
					model.setValueAt(ss.getString(2).trim(),i,1);
					model.setValueAt(ss.getString(4).trim(),i,2);
					model.setValueAt(ss.getString(5).trim(),i,3);
					model.setValueAt(ss.getString(7).trim(),i,4);
					model.setValueAt(ss.getString(13).trim(),i,5);
					model.setValueAt(ss.getString(14).trim(),i,6);
					
					
					
					
					
					//i++;
				}
			}
		}
		catch(Exception ex)
		{

		}
		table=new JTable(model);
		JScrollPane sp=new JScrollPane(table);
		main.add(sp);
		table.setSelectionMode(0);
		table.setFont(new Font("Times New Roman",Font.PLAIN,13));
		table.setForeground(Color.cyan);
		//table.setGridColor(new Color(0,128,192));
		table.setBackground(Color.red);
	  	table.setBackground(new Color(0,128,192));
        table.getTableHeader().setReorderingAllowed(false);
        c.add(main);
	}
	

}*/