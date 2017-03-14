/*import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import StudentInfo.ModifyInfo;
import StudentInfo.ModifyInfo.ModifyDialog;
import StudentInfo.ModifyInfo.ModifyStudList;
import StudentInfo.ModifyInfo.SelectedCourse;
import StudentInfo.ModifyInfo.ModifyDialog.ModifyStud;


public class mouse extends JFrame{
	
	private JTable table;
	
	class TableHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent me)
		{
			int ro=table.getSelectedRow();
			String sel=(String)table.getValueAt(ro,0);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
			            "(*.mdb)};"+"DBQ=D:\\database\\Student_Info.mdb","ayets","setonji04");
				st=conn.createStatement();
				String cours=(String)courselist.getSelectedItem();
				ResultSet set=st.executeQuery("select * from "+cours+"_stud_info order by scode");
				String scd="";
				while(set.next())
				{
					scd=set.getString(1).trim();
					if(sel.equals(scd))
						break;
				}
				scode.setText(scd);
				sname.setText(set.getString(2));
				mname.setText(set.getString(3));
				lname.setText(set.getString(4));
				addfield1.setText(set.getString(5));
				String dat=set.getString(6);
				String day=dat.substring(0,2);
				if(day.charAt(0) == '0')
					day=String.valueOf(day.charAt(1));
				String mon=dat.substring(3,7);
				String yr=dat.substring(8,12);
				joindateday.setSelectedItem(day);
				joindatemon.setSelectedItem(mon);
				joindateyear.setSelectedItem(yr);
				mobno.setText(set.getString(7));
				totalfees.setText(set.getString(8));
				paidfees.setText(set.getString(9));
				addfees.setText(set.getString(10));
				remainfees.setText(set.getString(11));
				save.setEnabled(false);

			}
			catch(Exception ew)
			{
			}
			
			
			
			table.addMouseListener(new TableHandler());

			table.setToolTipText("Select the Student for more information");
			JScrollPane table1=new JScrollPane(table);
			table.doLayout();
			table.setColumnSelectionAllowed(false);
			table.setSelectionMode(1);
			table.setEditingColumn(3);
			table.setGridColor(Color.pink);
			table.setRowMargin(3);
			table.setSelectionBackground(new Color(194,253,254));
			table.setSelectionForeground(new Color(128,64,0));
			table.setShowHorizontalLines(false);
			table.setShowVerticalLines(false);
			table.getTableHeader().setReorderingAllowed(false);


		}
	}

	
	
	
	
	class ModifyInfo extends JFrame
	{
		Container mic=getContentPane();
		JComboBox appyrstmd;
		JComboBox appyredmd;
		JTable stud;
		JComboBox cour;
		JPanel pan;
		DefaultTableModel model;
		ModifyDialog mdl;
		String stcode;
		ModifyInfo()
		{
			final int width2=screenSize.width/3;
			final int height2=screenSize.height/3;
			setSize(width2+100, height2+100);
			setLocation(width2-20,height2-50);
			setTitle("Student Information");
			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					dispose();
				}
			});
			ModifyInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
			JLabel l=new JLabel("<html><font size=5 color=#800080><i>Select Student To Modify");
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
					g.drawImage(img,0,0,width2+100,height2+100,null);
				}
			};
			title.add(l);
			mic.add("North",title);

			pan=new JPanel();
			pan.setLayout(new GridBagLayout());
			GridBagConstraints cons=new GridBagConstraints();
			cons.fill=GridBagConstraints.BOTH;
			cons.anchor=GridBagConstraints.EAST;
			cons.weightx=10;
			cons.weighty=0;
			appyrstmd=new JComboBox();
			appyrstmd.setToolTipText("Select apperaed year");
			appyrstmd.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			appyredmd=new JComboBox();
			appyredmd.setToolTipText("Select apperaed year");
			appyredmd.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));


			cour=new JComboBox();
			cour.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));

			try
			{conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
		            "(*.mdb)};"+"DBQ=D:\\database\\Student_Info.mdb","ayets","setonji04");
			st=conn.createStatement();
				ResultSet set=st.executeQuery("select * from course_name");
				cour.removeAllItems();
				while(set.next())
				{
					cour.addItem(set.getString(2));
				}
				String cors=(String)cour.getSelectedItem();
				for(int y=1950;y<2100;y++)
				{
					appyrstmd.addItem(Integer.toString(y));
				}
				appyrstmd.setSelectedItem("2007");
				if(cors!=null)
				{
					int x=0;
					try
					{
						set=st.executeQuery("select * from course_name");
						String dur=null;
						while(set.next())
						{
							String cr=set.getString(2).trim();
							dur=set.getString(4).trim();
							if(cr.equals(cors))
								break;
						}
						if(dur.equals("Two Semester") || dur.equals("One Year"))
							x=1;
						else
						if(dur.equals("Four Semester") || dur.equals("Two Year"))
							x=2;
						else
						if(dur.equals("Six Semester") || dur.equals("Three Year"))
							x=3;
						else
						if(dur.equals("Eight Semester") || dur.equals("Four Year"))
							x=4;

						int y=Integer.parseInt((String)appyrstmd.getSelectedItem());
						y=y+x;
						appyredmd.addItem(Integer.toString(y));


					}
					catch(Exception ec)
					{
					}
				}
				st.close();
				String appyear=(String)appyrstmd.getSelectedItem()+"-"+(String)appyredmd.getSelectedItem();
				PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				ResultSet stset=ps.executeQuery();
				int row=0;
				int i=0;
				while(stset.next())
				{
					row++;
				}
				model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
				ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				stset=ps.executeQuery();
				while(stset.next())
				{
					model.setValueAt(stset.getString(1).trim(),i,0);
					String ft=stset.getString(2).trim();
					ft=ft+" "+stset.getString(4).trim();
					model.setValueAt(ft,i,1);
					model.setValueAt(stset.getString(6).trim(),i,2);
					i++;
				}
				stud=new JTable(model);
				ps.close();
				stud.addMouseListener(new ModifyStudList());
				stud.setToolTipText("Select The Student For Modify");
				stud.doLayout();
				stud.setColumnSelectionAllowed(false);
				stud.setSelectionMode(1);
				stud.setEditingColumn(3);
				stud.setGridColor(Color.pink);
				stud.setRowMargin(3);
				stud.setSelectionBackground(Color.gray);
				stud.setSelectionForeground(Color.red);
				stud.setShowHorizontalLines(false);
				stud.setShowVerticalLines(false);
				stud.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				JScrollPane spl=new JScrollPane(stud);
				mic.add(spl);

				cour.setMaximumRowCount(10);
				cons.anchor=GridBagConstraints.CENTER;
				cons.weightx=30;
				Box cor1 = Box.createHorizontalBox();
				cor1.add(Box.createGlue());
				cor1.add(new JLabel("Course"));
				cor1.add(Box.createHorizontalStrut(5));
				cor1.add(cour);
				cor1.add(Box.createHorizontalStrut(5));
				addOn(cor1,cons,0,0,2,1);

				cons.weightx=40;
				Box cor = Box.createHorizontalBox();
				cor.add(Box.createGlue());
				cor.add(new JLabel("Appered Year"));
				cor.add(Box.createHorizontalStrut(5));
				cor.add(appyrstmd);
				cor.add(Box.createHorizontalStrut(5));
				cor.add(new JLabel("TO"));
				cor.add(Box.createHorizontalStrut(5));
				cor.add(appyredmd);
				addOn(cor,cons,3,0,2,1);
				cons.weightx=100;
				cons.weighty=100;
				addOn(spl,cons,0,1,5,1);
				cour.addActionListener(new SelectedCourse());
				appyrstmd.addActionListener(new SelectedCourse());

				addWindowListener(new WindowAdapter()
				{
					public void windowActivated(WindowEvent we)
					{
						String cors=(String)cour.getSelectedItem();
						try
						{
							String appyear=(String)appyrstmd.getSelectedItem()+"-"+(String)appyredmd.getSelectedItem();
							PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
							ps.setString(1,appyear);
							ResultSet stset=ps.executeQuery();
							int row=0;
							int i=0;
							while(stset.next())
							{
								row++;
							}
							model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
							ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
							ps.setString(1,appyear);
							stset=ps.executeQuery();
							while(stset.next())
							{
								model.setValueAt(stset.getString(1).trim(),i,0);
								String ft=stset.getString(2).trim();
								ft=ft+" "+stset.getString(4).trim();
								model.setValueAt(ft,i,1);
								model.setValueAt(stset.getString(6).trim(),i,2);
								i++;
							}
							stud.setModel(model);
						}
						catch(Exception ex)
						{
						}
					}
				});

			}

			catch(Exception es)
			{
			}
		}
		public void addOn(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
		{
			cons.gridx=x;
			cons.gridy=y;
			cons.gridwidth=w;
			cons.gridheight=h;
			comp.setPreferredSize(comp.getPreferredSize());
			pan.add(comp,cons);
			mic.add(pan);
		}}
	
	
	class ModifyStudList extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			String cors=(String)cour.getSelectedItem();
			int ro=stud.getSelectedRow();
			stcode=(String)stud.getValueAt(ro,0);
			mdl=new ModifyDialog(stcode,cors);
			mdl.setVisible(true);
		}
	}
	class ModifyDialog extends JDialog
	{
		JButton mok;
		JButton mcan;
		JPanel mpan;
		String mstud;
		String corsname;
		Container cont;

		JTextField sco;
		JTextField stuname;
		JTextField midname;
		JTextField lastname;
		JTextArea addre;
		JTextField datetf;
		JTextField mnum;
		JTextField tfee;
		JTextField pfee;
		JTextField addfee;
		JTextField rfee;
		ModifyDialog(String s,String corsf)
		{
			super(ModifyInfo.this,"Modify Student",true);
			mstud=s;
			corsname=corsf;
			final int width2=screenSize.width/3;
			final int height2=screenSize.height/3;
			setSize(width2+100, height2+120);
			setLocation(width2-20,height2-50);
			cont=getContentPane();
			JPanel bp=new JPanel();
			bp.setBackground(new Color(255,197,68));
			mok=new JButton("  Ok  ");
			mcan=new JButton("Cancel");
			bp.add(mok);
			bp.add(mcan);
			cont.add(bp,"South");
			ModifyStud ms=new ModifyStud();
			mok.addActionListener(ms);
			mcan.addActionListener(ms);


			mpan=new JPanel();
			mpan.setLayout(new GridBagLayout());
			sco=new JTextField(10);
			sco.setToolTipText("Student Code");
			sco.setEditable(false);
			sco.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			stuname=new JTextField(20);
			stuname.addKeyListener(onlyText);
			stuname.setToolTipText("Enter Student Name");
			stuname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			midname=new JTextField(20);
			midname.addKeyListener(onlyText);
			midname.setToolTipText("Enter Student's Parent Name");
			midname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			lastname=new JTextField(20);
			lastname.addKeyListener(onlyText);
			lastname.setToolTipText("Enter Student's Last Name");
			lastname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			addre=new JTextArea(2,20);
			addre.setToolTipText("Enter Student's Address");
			addre.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			addre.setWrapStyleWord(true);
			addre.setLineWrap(true);
			JScrollPane addfd=new JScrollPane(addre);
			datetf=new JTextField(10);
			datetf.setToolTipText("Joining Date");
			datetf.setEditable(false);
			datetf.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			mnum=new JTextField(14);
			mnum.addKeyListener(onlyNumber);
			mnum.setToolTipText("Enter Mobile Number ");
			mnum.setBorder(BorderFactory.createBevelBorder(1,new Color(100,100,155),new Color(100,100,155)));
			mnum.setSelectionColor(Color.blue);
			mnum.setDisabledTextColor(Color.red);
			mnum.setCaretColor(Color.green);
			mnum.setSelectionColor(Color.pink);
			mnum.setFont(new Font("verdana", Font.BOLD, 12));
			tfee=new JTextField(8);
			tfee.setEditable(false);
			tfee.addKeyListener(onlyNumber);
			tfee.setToolTipText("Total Fees Of Course");
			tfee.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			pfee=new JTextField(8);
			pfee.addKeyListener(onlyNumber);
			pfee.setToolTipText("Enter the Recived Fees From Student");
			pfee.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			addfee=new JTextField(8);
			addfee.addKeyListener(onlyNumber);
			addfee.setToolTipText("Enter the Addition Fees of Course \n e.g. Late Fees , Subject backlog Fees , Fine of Liabrary");
			addfee.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			rfee=new JTextField(8);
			rfee.setEditable(false);
			rfee.addKeyListener(onlyNumber);
			rfee.setToolTipText("Remaining Fees Of Student");
			rfee.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));

			GridBagConstraints cons=new GridBagConstraints();
			cons.fill=GridBagConstraints.NONE;
			cons.anchor=GridBagConstraints.EAST;
			cons.weightx=10;
			cons.weighty=10;

			cons.insets = new Insets(0, 10, 5, 0);
			mdadd(new JLabel("Student Code  : "),cons,0,0,1,1);
			mdadd(new JLabel("Student Name  : "),cons,0,1,1,1);
			mdadd(new JLabel("Parent name  : "),cons,0,2,1,1);
			mdadd(new JLabel("Last Name  : "),cons,0,3,1,1);
			mdadd(new JLabel("Address  : "),cons,0,4,1,2);
			mdadd(new JLabel("Date Of Joining  : "),cons,0,6,1,1);
			mdadd(new JLabel("Mobile Number  : "),cons,0,7,1,1);
			mdadd(new JLabel("Total Fees  : "),cons,0,8,1,1);
			mdadd(new JLabel("Paid Fees  : "),cons,0,9,1,1);
			mdadd(new JLabel("Addition Fees  : "),cons,0,10,1,1);
			mdadd(new JLabel("Remaining Fees  : "),cons,0,11,1,1);

			cons.fill=GridBagConstraints.HORIZONTAL;
			cons.weightx = 50;
			cons.insets = new Insets(0, 10, 5, 40);
			mdadd(sco, cons, 1, 0, 1, 1);
			cons.insets = new Insets(0, 10, 1, 40);
			mdadd(stuname,cons,1,1,1,1);
			mdadd(midname,cons,1,2,1,1);
			mdadd(lastname,cons,1,3,1,1);
			cons.insets = new Insets(0, 10, 1, 100);
			cons.ipady = 20;
			mdadd(addfd,cons,1,4,1,2);
			cons.ipady=0;
			cons.insets = new Insets(0, 10, 1, 160);
			mdadd(datetf,cons,1,6,1,1);
			mdadd(mnum,cons,1,7,1,1);
			cons.ipady = 0;
			cons.insets=new Insets(0,10,1,40);
			mdadd(tfee,cons,1,8,1,1);
			mdadd(pfee,cons,1,9,1,1);
			mdadd(addfee,cons,1,10,1,1);
			mdadd(rfee,cons,1,11,1,1);

			try
			{
				st=conn.createStatement();
				ResultSet minfo=st.executeQuery("select * from "+corsname+"_stud_info order by scode");
				String stco="";
				while(minfo.next())
				{
					stco=minfo.getString(1).trim();
					if(stco.equals(mstud))
						break;
				}
				sco.setText(stco);
				stuname.setText(minfo.getString(2));
				midname.setText(minfo.getString(3));
				lastname.setText(minfo.getString(4));
				addre.setText(minfo.getString(5));
				datetf.setText(minfo.getString(6));
				mnum.setText(minfo.getString(7));
				tfee.setText(minfo.getString(8));
				pfee.setText(minfo.getString(9));
				addfee.setText(minfo.getString(10));
				rfee.setText(minfo.getString(11));

			}
			catch(Exception ed)
			{
				System.out.println(ed);
			}
		}
		public void mdadd(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
		{
			cons.gridx=x;
			cons.gridy=y;
			cons.gridwidth=w;
			cons.gridheight=h;
			comp.setPreferredSize(comp.getPreferredSize());
			mpan.add(comp,cons);
			cont.add(mpan);
		}
		class ModifyStud implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String minfo=e.getActionCommand();
				if(minfo.equals("  Ok  "))
				{
					boolean ok=false;
					try
					{
						String name=stuname.getText();
						String mdname=midname.getText();
						String ltname=lastname.getText();
						String address=addre.getText();
						String mobile=mnum.getText();
						int total=Integer.parseInt(tfee.getText());
						int paidfs=Integer.parseInt(pfee.getText());
						int additionfs=Integer.parseInt(addfee.getText());
						int remain=(total+additionfs)-paidfs;
						String totalf=Integer.toString(total);
						String paidfe=Integer.toString(paidfs);
						String additionfe=Integer.toString(additionfs);
						String remainf=Integer.toString(remain);
						if(remain<0)
						{
							Icon error=new ImageIcon("images//error.png");
							JOptionPane.showMessageDialog(ModifyDialog.this,"<html><font size=4 color=red>Paid Fees Over Than Total Fees </font></html> \n\t\t Please Enter Valid Ammount","Student Information",JOptionPane.ERROR_MESSAGE,error);
						}
						else
						if(name.equals("") || mdname.equals("") || ltname.equals("") || address.equals("")|| paidfe.equals(""))
						{
							Icon error=new ImageIcon("images//error.png");
							JOptionPane.showMessageDialog(ModifyDialog.this,"<html><font size=4 color=red>Field Can Not Be Blank </font></html> \n\t\t Please enter All Information","Student Information",JOptionPane.ERROR_MESSAGE,error);
						}
						else
						{
							String mobTest=mnum.getText().trim();
							boolean valid=false;
							if((mobTest.length() == 14)||(mobTest.length() == 11))
							{
								valid=true;
								if(mobTest.length() == 11)
								{
									char ch=mobTest.charAt(0);
									if(ch != '0')
									{
										valid=false;
										Icon error=new ImageIcon("images//error.png");
										JOptionPane.showMessageDialog(ModifyDialog.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Student Information",JOptionPane.ERROR_MESSAGE,error);
									}
								}
							}
							else
							{
								valid=false;
								Icon error=new ImageIcon("images//error.png");
								JOptionPane.showMessageDialog(ModifyDialog.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Student Information",JOptionPane.ERROR_MESSAGE,error);
							}
							if(valid==true)
							{
								String csn=(String)cour.getSelectedItem();
								PreparedStatement pm=conn.prepareStatement("update "+csn+"_stud_info set sname=? ,mname=? ,lname=? ,address=? ,mobno=? ,paidfees=? ,addfees=? ,remfees=? where scode=?");
								pm.setString(1,name);
								pm.setString(2,mdname);
								pm.setString(3,ltname);
								pm.setString(4,address);
								pm.setString(5,mobile);
								pm.setInt(6,paidfs);
								pm.setInt(7,additionfs);
								pm.setInt(8,remain);
								pm.setString(9,mstud);
								pm.execute();
							}
							mdl.dispose();
						}
					}
					catch(Exception es)
					{
						Icon error=new ImageIcon("images//error.png");
						JOptionPane.showMessageDialog(ModifyDialog.this,"<html><font size=4 color=red>Field Can Not Be Blank </font></html> \n\t\t Please enter All Information","Student Information",JOptionPane.ERROR_MESSAGE,error);
					}

				}
				else
				{
					mdl.dispose();
				}
			}
		}
	}
}
*/