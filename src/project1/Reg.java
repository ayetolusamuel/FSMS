package project1;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.*;


class Reg extends JFrame implements ActionListener{
	private JLabel lblDate,lblsfName,lblcsId,lblcsfName,lblatt;
	private JPanel pRegister;
	private JTextField txtDate,txtcsfName,txtsfName;
	String[] att={"Present","Absent"};
Choice catt;
	JComboBox cmbsId;
	
	private JButton btnSave,btnCancel;
	Connection conn;
	Statement st;

	//private 

private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);							//Storing Date.

String timeStamp = new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime());

	
	Reg(){
		pRegister =new JPanel(){
			
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//plain.jpg");
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
				g.drawImage(img,0,0,700,750,null);
			}
		}
		
		;
		/*public void paintComponent(Graphics g)
		{
			Toolkit kit=Toolkit.getDefaultToolkit();
			Image img=kit.getImage("images//backu.jpg");
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
			g.drawImage(img,0,0,700,250,null);
		}
		}
	
	;*/
		pRegister.setLayout(null);
		
		
		lblDate =new JLabel("<html><i>Staff ID:");
		lblDate.setForeground(Color.white);
		lblDate.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
		pRegister.add(lblDate).setBounds(0, 30, 300, 25);
		txtDate=new JTextField();
		txtDate.setEditable(false);
		pRegister.add(txtDate).setBounds(0, 50, 75, 20);
		
		
		
		
		lblsfName =new JLabel("<html><i>Full Name");
		lblsfName.setForeground(Color.white);
		lblsfName.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
		pRegister.add(lblsfName).setBounds(85, 30, 300, 25);
		txtsfName=new JTextField();
		txtsfName.setEditable(false);
		pRegister.add(txtsfName).setBounds(85, 50, 270, 20);
		
		
		lblatt =new JLabel("<html><i><b>Attendance");
		lblatt.setForeground(Color.white);
		lblatt.setFont(new Font("Comic Sans MS",Font.ITALIC,15));
		pRegister.add(lblatt).setBounds(420, 30, 300, 25);
		 catt = new Choice();
		catt.add("Present");
		catt.add("Absent");
		pRegister.add(catt).setBounds(420, 50, 100, 20);
		
		
		
		lblcsId =new JLabel("<html><i>Cover Staff ID:");
		lblcsId.setForeground(Color.white);
		lblcsId.setVisible(false);
		lblcsId.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
		pRegister.add(lblcsId).setBounds(0, 80, 300, 25);
		
		
		
		cmbsId=new JComboBox();
		cmbsId.setVisible(false);
		pRegister.add(cmbsId).setBounds(120, 84, 120, 20);
		
		
		
		
		
		lblcsfName =new JLabel("<html><i>Cover Full Name:");
		lblcsfName.setForeground(Color.white);
		lblcsfName.setVisible(false);
		lblcsfName.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
		pRegister.add(lblcsfName).setBounds(0, 110, 300, 25);
		txtcsfName=new JTextField();
		txtcsfName.setEditable(false);
		txtcsfName.setVisible(false);
		pRegister.add(txtcsfName).setBounds(120, 112, 270, 20);
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		lblsID =new JLabel("<html><i>Staff ID");
		lblsID.setForeground(Color.white);
		lblsID.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
		pRegister.add(lblsID).setBounds(230, 40, 300, 25);
		
		
		
		
		*/
		
		
		
		
		
		
		
		
		
		
		/*
		
		cmbsID=new JComboBox(att);
		pRegister.add(cmbsID).setBounds(240, 60, 90, 20);
		*/
		/*
		lblAttendance =new JLabel("<html><i>Attendance");
		lblAttendance.setForeground(Color.white);
		lblAttendance.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
		pRegister.add(lblAttendance).setBounds(350, 40, 300, 25);
		lblCover =new JLabel("<html><i>Cover");
		lblCover.setForeground(Color.white);
		lblCover.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
		pRegister.add(lblCover).setBounds(480, 40, 300, 25);
		lblcsId=new JLabel("<html><i>Cover_Staff_ID");
		lblcsId.setForeground(Color.white);
		lblcsId.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
		pRegister.add(lblcsId).setBounds(550, 40, 300, 25);
		
		*/
/*
		
		txtTime=new JTextField(timeStamp);
		txtTime.setEditable(false);
		pRegister.add(txtTime).setBounds(130, 60, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 60, 90, 20);
		cmbAttendance1=new JComboBox(att);
		pRegister.add(cmbAttendance1).setBounds(360, 60, 90, 20);
		cmbCover1=new JComboBox(Cover);
		pRegister.add(cmbCover1).setBounds(480, 60, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 60, 90, 20);
		
		
		*/
		
		
		
		
		btnSave=new JButton(new ImageIcon("images//sav.png"));
		
	
		pRegister.add(btnSave).setBounds(220, 145, 70, 20);
		
		
		btnSave.addActionListener(this);
		btnCancel=new JButton("<html><i>Cancel");
	btnCancel.setFont(new Font("Comic Sans MS",Font.BOLD,19));
		pRegister.add(btnCancel).setBounds(300, 145, 90, 20);
		btnCancel.addActionListener(this);
		
		
		
		/*
		JLabel	lbl1 = new JLabel(new ImageIcon("images//reg.jpg"));
		
		lbl1.setBounds(0,0,400,500);
		pRegister.add(lbl1);
		*/
		//pRegister.add(lbl1).setBounds(500, 40, 300, 25);
		///reg.jpg
		
		
		
	getContentPane().add(pRegister,BorderLayout.CENTER);
	}
	
	
	
	class TableHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent me)
		{
			
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
			            "(*.mdb)};"+"DBQ=D:\\database\\Student_Info.mdb","ayets","setonji04");
				st=conn.createStatement();
			
			}
				catch (Exception e) {
					// TODO: handle exception
				}
			/*if(cmbAttendance.getSelectedItem().equals("Present") ){
				cmbCover1.setSelectedItem("No");
			}*/
		}}
		

	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {

Object obj = e.getSource();
		
		if(obj==btnSave){
			
		}
		
		if(obj==btnCancel){
			MainMenuFrame sam=new MainMenuFrame();
			sam.setVisible(true);
			dis_charge_report.setDefaultLookAndFeelDecorated(true);
			setVisible(false);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		Reg sa =new Reg();
		sa.setSize(700,280);
		//sa.setLocation(180,0);
		sa.setLocationRelativeTo(null);
		sa.setVisible(true);
	}
	
	
}