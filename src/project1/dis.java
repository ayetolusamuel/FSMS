/*

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import mouse.ModifyInfo;
import mouse.ModifyDialog.ModifyStud;


import mouse.ModifyDialog;
import mouse.ModifyInfo;
import mouse.ModifyStudList;


@SuppressWarnings("serial")
public class Discharge extends JFrame implements ActionListener {
	
JPanel pane=new JPanel();
JLabel lbldb4Discharge,lbldaDischarge,lbltldischarge,lblDate,lbltime,lblShortage,lblDepot,lblaDipping,lbledValue;
JTextField txtdb4Discharge,txtdaDischarge,txttldischarge,txtDate,txtTime,txtShortage,txtaDipping,txtedValue;
	
String dDate;
	JButton btnModify,btnSave,btnDelete,btnPrint,btnPreview,btnNew,btnClear,btnCancel;

private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);							//Storing Date.

Connection con=null;
Statement st=null;
PreparedStatement ps=null;

String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());

	
	Discharge(){
	//super(" Create Discharge Record" ,false,true,false,true);
	setSize(410,310);
	setLocation(120,120);
	setTitle("Discharge entering");
		pane=new JPanel(){
		
		public void paintComponent(Graphics g)
		{
			Toolkit kit=Toolkit.getDefaultToolkit();
			Image img=kit.getImage("images//reg.jpg");
			
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
			g.drawImage(img,0,0,415,310,null);
		}
		}
	
	;
		pane.setLayout(null);
		
lblDate=new JLabel("Date(dd/mm/yyyy) : ");
		pane.add(lblDate).setBounds(40,20,120,25);

		txtDate=new JTextField(d);
		pane.add(txtDate).setBounds(160,22,120,20);
		txtDate.setEditable(false);
		
		lbltime=new JLabel("Time");
		pane.add(lbltime).setBounds(90,50,120,25);
		txtTime=new JTextField(timeStamp);
		pane.add(txtTime).setBounds(160,52,120,20);
		txtTime.setEditable(false);

		lbldb4Discharge=new JLabel("Dipping b4 Discharge");
		pane.add(lbldb4Discharge).setBounds(10,80,120,25);
		txtdb4Discharge=new JTextField();
		txtdb4Discharge.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				
				if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
					 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9'|| c=='.')) {
					getToolkit().beep ();
					ke.consume ();
				}
			}
		}}
		);
		
		pane.add(txtdb4Discharge).setBounds(160,82,120,20);
		
		lbledValue=new JLabel("Enter Depot Value");
		//lbledValue.setVisible(false);
		pane.add(lbledValue).setBounds(10,110,140,25);
		txtedValue=new JTextField();
		txtedValue.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				
				if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
					 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9'|| c=='.')) {
					getToolkit().beep ();
					ke.consume ();
				}
			}
		}}
		);
		
		pane.add(txtedValue).setBounds(160,112,120,20);
		
		
		
		
		
		
		
		

		lblaDipping=new JLabel("Total Ltr Discharge");
		
		pane.add(lblaDipping).setBounds(10,162,140,25);
		txtaDipping=new JTextField();
		txtaDipping.setEditable(false);
		pane.add(txtaDipping).setBounds(160,164,120,20);
		

		lbldaDischarge=new JLabel("Dipping after Discharge");
		pane.add(lbldaDischarge).setBounds(10,135,140,25);
		txtdaDischarge=new JTextField();
		txtdaDischarge.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				
				if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
					 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9'|| c=='.')) {
					getToolkit().beep ();
					ke.consume ();
				}
			}
		}}
		);
		
		pane.add(txtdaDischarge).setBounds(160,137,120,20);
		
		
		JLabel st2=new JLabel("Litre");
		st2.setForeground(Color.red);
		pane.add(st2).setBounds(285,165,120,20);
		st2.setFont(new Font("Algerian",Font.ITALIC,12));
		
		
		
		lblShortage=new JLabel("Shortage");
		pane.add(lblShortage).setBounds(10,190,120,25);
		
		txtShortage=new JTextField();
		pane.add(txtShortage).setBounds(160,192,120,20);
		txtShortage.setEditable(false);
		
		JLabel st1=new JLabel("Litre");
		st1.setForeground(Color.red);
		pane.add(st1).setBounds(285,193,120,20);
		st1.setFont(new Font("Algerian",Font.ITALIC,12));
		
		
		
		
		btnSave=new JButton("Save");
		pane.add(btnSave).setBounds(0,248,70,20);
		btnSave.addActionListener(this);
		
		

		btnClear=new JButton("Clear");
	pane.add(btnClear).setBounds(75,248,70,20);
		
		btnClear.addActionListener(this);
		

		btnModify =new JButton("Modify");
	pane.add(btnModify).setBounds(150,248,79,20);
		
	btnModify.addActionListener(this);

		btnPreview=new JButton("Preview");
	pane.add(btnPreview).setBounds(230,248,85,20);
		
	btnPreview.addActionListener(this);
	
		btnCancel=new JButton("Cancel");
		pane.add(btnCancel).setBounds(320,248,75,20);
		btnCancel.addActionListener(this);
		
		
	
	
	getContentPane().add(pane,BorderLayout.CENTER);
	}
	
	
	
	class ModifyDialog extends JDialog
	{
		
		//public class Discharge extends JFrame implements ActionListener {
			
			JPanel pane=new JPanel();
			JLabel lbldb4Discharge,lbldaDischarge,lbltldischarge,lblDate,lbltime,lblShortage,lblDepot,lblaDipping,lbledValue;
			JTextField txtdb4Discharge,txtdaDischarge,txttldischarge,txtDate,txtTime,txtShortage,txtaDipping,txtedValue;
				
				JButton btnModify,btnSave,btnDelete,btnPrint,btnPreview,btnNew,btnClear,btnCancel;

			private java.util.Date currDate = new java.util.Date ();					//Creating Object.
			private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
			private String d = sdf.format (currDate);							//Storing Date.

			Connection con=null;
			Statement st=null;
			PreparedStatement ps=null;
			String mstud;
			String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());

				
				ModifyDialog(String s,String corsf){
					super(ModifyInfo.this,"Modify Student",true);
					
					//super(" Create Discharge Record" ,false,true,false,true);
					
					ModifyStud ms=new ModifyStud();
					mok.addActionListener(ms);
					mcan.addActionListener(ms);

				setSize(410,310);
				setLocation(120,120);
				setTitle("Discharge entering");
					pane=new JPanel(){
					
					public void paintComponent(Graphics g)
					{
						Toolkit kit=Toolkit.getDefaultToolkit();
						Image img=kit.getImage("images//reg.jpg");
						
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
						g.drawImage(img,0,0,415,310,null);
					}
					}
				
				;
					pane.setLayout(null);
					
			lblDate=new JLabel("Date(dd/mm/yyyy) : ");
					pane.add(lblDate).setBounds(40,20,120,25);

					txtDate=new JTextField(d);
					pane.add(txtDate).setBounds(160,22,120,20);
					txtDate.setEditable(false);
					
					lbltime=new JLabel("Time");
					pane.add(lbltime).setBounds(90,50,120,25);
					txtTime=new JTextField(timeStamp);
					pane.add(txtTime).setBounds(160,52,120,20);
					txtTime.setEditable(false);

					lbldb4Discharge=new JLabel("Dipping b4 Discharge");
					pane.add(lbldb4Discharge).setBounds(10,80,120,25);
					txtdb4Discharge=new JTextField();
					txtdb4Discharge.addKeyListener (new KeyAdapter () {
						public void keyTyped (KeyEvent ke) {
							char c = ke.getKeyChar ();
							
							if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
								 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
								            c == '5' || c == '6' || c == '7' || c == '8' || c == '9'|| c=='.')) {
								getToolkit().beep ();
								ke.consume ();
							}
						}
					}}
					);
					
					pane.add(txtdb4Discharge).setBounds(160,82,120,20);
					
					lbledValue=new JLabel("Enter Depot Value");
					//lbledValue.setVisible(false);
					pane.add(lbledValue).setBounds(10,110,140,25);
					txtedValue=new JTextField();
					txtedValue.addKeyListener (new KeyAdapter () {
						public void keyTyped (KeyEvent ke) {
							char c = ke.getKeyChar ();
							
							if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
								 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
								            c == '5' || c == '6' || c == '7' || c == '8' || c == '9'|| c=='.')) {
								getToolkit().beep ();
								ke.consume ();
							}
						}
					}}
					);
					
					pane.add(txtedValue).setBounds(160,112,120,20);
					
					
					
					
					
					
					
					

					lblaDipping=new JLabel("Total Ltr Discharge");
					
					pane.add(lblaDipping).setBounds(10,162,140,25);
					txtaDipping=new JTextField();
					txtaDipping.setEditable(false);
					pane.add(txtaDipping).setBounds(160,164,120,20);
					

					lbldaDischarge=new JLabel("Dipping after Discharge");
					pane.add(lbldaDischarge).setBounds(10,135,140,25);
					txtdaDischarge=new JTextField();
					txtdaDischarge.addKeyListener (new KeyAdapter () {
						public void keyTyped (KeyEvent ke) {
							char c = ke.getKeyChar ();
							
							if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
								 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
								            c == '5' || c == '6' || c == '7' || c == '8' || c == '9'|| c=='.')) {
								getToolkit().beep ();
								ke.consume ();
							}
						}
					}}
					);
					
					pane.add(txtdaDischarge).setBounds(160,137,120,20);
					
					
					JLabel st2=new JLabel("Litre");
					st2.setForeground(Color.red);
					pane.add(st2).setBounds(285,165,120,20);
					st2.setFont(new Font("Algerian",Font.ITALIC,12));
					
					
					
					lblShortage=new JLabel("Shortage");
					pane.add(lblShortage).setBounds(10,190,120,25);
					
					txtShortage=new JTextField();
					pane.add(txtShortage).setBounds(160,192,120,20);
					txtShortage.setEditable(false);
					
					JLabel st1=new JLabel("Litre");
					st1.setForeground(Color.red);
					pane.add(st1).setBounds(285,193,120,20);
					st1.setFont(new Font("Algerian",Font.ITALIC,12));
					
					
				
				
				getContentPane().add(pane,BorderLayout.CENTER);
				
				
	
				try
				{
					st=con.createStatement();
					ResultSet minfo=st.executeQuery("select * from "+corsname+"_stud_info order by scode");
					
					String stco="";
					while(minfo.next())
					{
						stco=minfo.getString(1).trim();
						if(stco.equals(mstud))
							break;
					}
					txtDate.setText(stco);
					txtTime.setText(minfo.getString(2));
					txtaDipping.setText(minfo.getString(3));
					txtdb4Discharge.setText(minfo.getString(4));
					txtdaDischarge.setText(minfo.getString(5));
				txttldischarge.setText(minfo.getString(6));
					txtShortage.setText(minfo.getString(7));
					txtedValue.setText(minfo.getString(8));
					
				}
				catch(Exception ed)
				{
					System.out.println(ed);
				}
		
		
		
		
		
		
	}
		
	
	}
	
	class ModifyInfo extends JFrame
	{
		Container mic=getContentPane();
		//JComboBox appyrstmd;
		//JComboBox appyredmd;
		JTable stud;
		//JComboBox cour;
		JPanel pan;
		DefaultTableModel model;
		ModifyDialog mdl;
		String stcode;
		ModifyInfo()
		{
			
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
					//g.drawImage(img,0,0,width2+100,height2+100,null);
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
			
			try
			{con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
		            "(*.mdb)};"+"DBQ=D:\\database\\Student_Info.mdb","ayets","setonji04");
			st=con.createStatement();
				ResultSet set=st.executeQuery("select * from course_name");
				cour.removeAllItems();
				while(set.next())
				{
					//cour.addItem(set.getString(2));
				}
				String cors=(String)cour.getSelectedItem();
				for(int y=1950;y<2100;y++)
				{
					//appyrstmd.addItem(Integer.toString(y));
				}
				//appyrstmd.setSelectedItem("2007");
			catch (Exception e) {
				// TODO: handle exception
			}
				
				st.close();
				String appyear=(String)appyrstmd.getSelectedItem()+"-"+(String)appyredmd.getSelectedItem();
				PreparedStatement ps=cons.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				ResultSet stset=ps.executeQuery();
				int row=0;
				int i=0;
				while(stset.next())
				{
					row++;
				}
				model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
				ps=cons.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
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

				
				//cour.addActionListener(new SelectedCourse());
				//appyrstmd.addActionListener(new SelectedCourse());

				addWindowListener(new WindowAdapter()
				{
					public void windowActivated(WindowEvent we)
					{
						String cors=(String)cour.getSelectedItem();
						try
						{
							String appyear=(String)appyrstmd.getSelectedItem()+"-"+(String)appyredmd.getSelectedItem();
							PreparedStatement ps=cons.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
							ps.setString(1,appyear);
							ResultSet stset=ps.executeQuery();
							int row=0;
							int i=0;
							while(stset.next())
							{
								row++;
							}
							model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
							ps=cons.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
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
	}}
	public static void main(String[] args) {
		Discharge s=new Discharge();
		s.setVisible(true);
		s.setSize(415,310);
		
		s.setLocationRelativeTo(null);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		
		
	}
	
	
	void insertRecord(){
	
		
		
		
			 String sql="INSERT INTO  discharge(date,time,dippingb4,depot,dippingafter,tldischarge,shortage)values('"+txtDate.getText()+"','"+txtTime.getText()+"','"+txtdb4Discharge.getText()+"','"+txtedValue.getText()+"','"+txtdaDischarge.getText()+"','"+txtaDipping.getText()+"','"+txtShortage.getText()+"')";
		        
				try {
					ps=con.prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			          try {
					ps.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	Object obj = e.getSource();
		

    try{

    	
  	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D://database//rakedomanagement.mdb;DriverID=22;READONLY=true) ","","");

	    st=con.createStatement(); 
	st = con.createStatement();
  
    }

    
    catch(Exception ex){
    
   JOptionPane.showMessageDialog(null, "Failed Connection","Error",JOptionPane.ERROR_MESSAGE);
}
		
		
		if(obj==btnSave){
			
		if(txtdaDischarge.getText().equals("")||txtDate.getText().equals("")||txtTime.getText().equals("")||txtdb4Discharge.getText().equals("")||txtedValue.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Fill all editable fields");
		}
		
		else{
		
		

		
		double depot=Double.parseDouble(txtedValue.getText());
		double afterDipping=Double.parseDouble(txtdaDischarge.getText());
		double b4Discharge=Double.parseDouble(txtdb4Discharge.getText());
		txtaDipping.setText(String.format("%.2f", (depot+b4Discharge)));
		double total=Double.parseDouble(txtaDipping.getText());
		txtShortage.setText(String.format("%.2f", (total-afterDipping)));
		//JOptionPane.showMessageDialog(btnSave, " the total litre Discharge is " +txtaDipping.getText()+ " LITRE(S) \n and the shortage value is "+txtShortage.getText()+ " LITRE(S)");
	
	insertRecord();
		JOptionPane.showMessageDialog(null, "Saved into Database");
		clearText();
		}
		}
		

		if(obj==btnClear){
			
			
		}
		
		
		if(obj==btnCancel){
			MainMenuFrame sam=new MainMenuFrame();
			sam.setVisible(true);
			dis_charge_report.setDefaultLookAndFeelDecorated(true);
			setVisible(false);
			
		}
		
		if(obj==btnPreview){
		      
					dis_charge_report l = new 	dis_charge_report();
			               l.setVisible(true);
			               l.setSize(1200, 520);
			           	l.setLocation(12, 10);
			           	 dispose();
			          
		}
		
	
			
			
		}
			 
	
	private void clearText() {
		// TODO Auto-generated method stub
		txtaDipping.setText("");
		txtedValue.setText("");
		txtShortage.setText("");
		txtdaDischarge.setText("");
		txtdb4Discharge.setText("");
		
	}
	
}}
*/