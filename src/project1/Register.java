package project1;

import java.awt.BorderLayout;
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


class Register extends JFrame implements ActionListener{
	private JLabel lblNumber,lblDate,lblTime,lblsID,lblAttendance,lblCover,lblcsId;
	private JPanel pRegister;
	private JTextField txtDate,txtTime;
	String[] att={"Select","Present","Absent"};
	private JComboBox cmbsID,cmbAttendance,cmbCover,cmbcsID,cmbsList;
	String [] Cover={"Yes","No"};
	String num[]={"5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
	private JButton btnSave,btnCancel;
	Connection conn;
	Statement st;
	private JComboBox cmbAttendance1,cmbCover1;
	//private 

private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);							//Storing Date.

String timeStamp = new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime());

	
	Register(){
		pRegister =new JPanel(){
			
			/*public void paintComponent(Graphics g)
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
				g.drawImage(img,0,0,700,750,null);
			}
		}
		
		;*/
		
		public void paintComponent(Graphics g)
		{
			Toolkit kit=Toolkit.getDefaultToolkit();
			Image img=kit.getImage("images//back3.jpg");
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
			g.drawImage(img,0,10,700,750,null);
		}
		}
	
	;
		pRegister.setLayout(null);
		lblNumber=new JLabel("<html><i>Seleect Number Of Staff On Duty");
		lblNumber.setFont(new Font("Algerian",Font.PLAIN,12));
		lblNumber.setForeground(Color.white);
		pRegister.add(lblNumber).setBounds(10, 10, 300, 25);
		cmbsList=new JComboBox(num);
	cmbsList.setFont(new Font("Comic Sans MS",Font.ITALIC,16));
	cmbsList.setForeground(Color.ORANGE);
	cmbsList.setBackground(Color.WHITE);
	pRegister.add(cmbsList).setBounds(225, 13, 50, 20);
		
		
		
		
		lblDate =new JLabel("<html><i>Date");
		lblDate.setForeground(Color.white);
		lblDate.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
		pRegister.add(lblDate).setBounds(50, 40, 300, 25);
		lblTime =new JLabel("<html><i>Time");
		lblTime.setForeground(Color.white);
		lblTime.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
		pRegister.add(lblTime).setBounds(140, 40, 300, 25);
		lblsID =new JLabel("<html><i>Staff ID");
		lblsID.setForeground(Color.white);
		lblsID.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
		pRegister.add(lblsID).setBounds(230, 40, 300, 25);
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
		
		JLabel	lbl1 =new JLabel("<html><i>1.");
		lbl1.setForeground(Color.white);
		lbl1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl1).setBounds(8, 58, 30, 25);
	
		
		txtDate=new JTextField(d);
		txtDate.setEditable(false);
		pRegister.add(txtDate).setBounds(40, 60, 80, 20);
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
		
		
		
		
		JLabel	lbl2 =new JLabel("<html><i>2.");
		lbl2.setForeground(Color.white);
		lbl2.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl2).setBounds(8, 88, 30, 25);
		JTextField txtDate1=new JTextField();
		pRegister.add(txtDate1).setBounds(40, 90, 80, 20);
		JTextField txtTime1=new JTextField();
		pRegister.add(txtTime1).setBounds(130, 90, 80, 20);
		JComboBox cmbsID1=new JComboBox();
		pRegister.add(cmbsID1).setBounds(240, 90, 90, 20);
		JComboBox cmbAttendance1=new JComboBox(att);
		pRegister.add(cmbAttendance1).setBounds(360, 90, 90, 20);
		JComboBox cmbCover1=new JComboBox(Cover);
		pRegister.add(cmbCover1).setBounds(480, 90, 50, 20);
		JComboBox cmbcsID1=new JComboBox();
		pRegister.add(cmbcsID1).setBounds(560, 90, 90, 20);

		
		JLabel	lbl3 =new JLabel("<html><i>3.");
		lbl3.setForeground(Color.white);
		lbl3.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl3).setBounds(8, 118, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 120, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 120, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 120, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 120, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 120, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 120, 90, 20);
		
		
		JLabel	lbl4 =new JLabel("<html><i>4.");
		lbl4.setForeground(Color.white);
		lbl4.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl4).setBounds(8, 148, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 150, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 150, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 150, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 150, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 150, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 150, 90, 20);
		
		
		JLabel	lbl5 =new JLabel("<html><i>5.");
		lbl5.setForeground(Color.white);
		lbl5.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl5).setBounds(8, 178, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 180, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 180, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 180, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 180, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 180, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 180, 90, 20);
		
		
		
		JLabel	lbl6 =new JLabel("<html><i>6.");
		lbl6.setForeground(Color.white);
		lbl6.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl6).setBounds(8, 208, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 210, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 210, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 210, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 210, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 210, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 210, 90, 20);
		
		
		
		JLabel	lbl7 =new JLabel("<html><i>7.");
		lbl7.setForeground(Color.white);
		lbl7.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl7).setBounds(8, 238, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 240, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 240, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 240, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 240, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 240, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 240, 90, 20);
		
		
		JLabel	lbl8 =new JLabel("<html><i>8.");
		lbl8.setForeground(Color.white);
		lbl8.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl8).setBounds(8, 268, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 270, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 270, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 270, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 270, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 270, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560,270, 90, 20);
		
		
		JLabel	lbl9 =new JLabel("<html><i>9.");
		lbl9.setForeground(Color.white);
		lbl9.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl9).setBounds(8, 298, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 300, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 300, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 300, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 300, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 300, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 300, 90, 20);
		
		
		JLabel	lbl10 =new JLabel("<html><i>10.");
		lbl10.setForeground(Color.white);
		lbl10.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl10).setBounds(8, 328, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 330, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 330, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 330, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 330, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 330, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 330, 90, 20);
		
		JLabel	lbl11 =new JLabel("<html><i>11.");
		lbl11.setForeground(Color.white);
		lbl11.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl11).setBounds(8, 358, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 360, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 360, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 360, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 360, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 360, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 360, 90, 20);
		
		
		
		JLabel	lbl12 =new JLabel("<html><i>12.");
		lbl12.setForeground(Color.white);
		lbl12.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl12).setBounds(8, 388, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 390, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 390, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 390, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 390, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 390, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 390, 90, 20);
		
		JLabel	lbl13 =new JLabel("<html><i>13.");
		lbl13.setForeground(Color.white);
		lbl13.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl13).setBounds(8, 418, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 420, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 420, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 420, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 420, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 420, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 420, 90, 20);
		
		JLabel	lbl14 =new JLabel("<html><i>14.");
		lbl14.setForeground(Color.white);
		lbl14.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl14).setBounds(8, 448, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 450, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 450, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 450, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360,450, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480,450, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 450, 90, 20);
		
		JLabel	lbl15 =new JLabel("<html><i>15.");
		lbl15.setForeground(Color.white);
		lbl15.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl15).setBounds(8, 478, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 480, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 480, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 480, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 480, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 480, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 480, 90, 20);
		
		
		JLabel	lbl16 =new JLabel("<html><i>16.");
		lbl16.setForeground(Color.white);
		lbl16.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl16).setBounds(8, 508, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 510, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 510, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 510, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 510, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 510, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 510, 90, 20);
		
		JLabel	lbl17 =new JLabel("<html><i>17.");
		lbl17.setForeground(Color.white);
		lbl17.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl17).setBounds(8, 538, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 540, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 540, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 540, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 540, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 540, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 540, 90, 20);
		
		
		JLabel	lbl18 =new JLabel("<html><i>18.");
		lbl18.setForeground(Color.white);
		lbl18.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl18).setBounds(8, 568, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 570, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 570, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 570, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 570, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 570, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 570, 90, 20);
		
		JLabel	lbl19 =new JLabel("<html><i>19.");
		lbl19.setForeground(Color.white);
		lbl19.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl19).setBounds(8, 598, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 600, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 600, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 600, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 600, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 600, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 600, 90, 20);
		
		
		JLabel	lbl20 =new JLabel("<html><i>20.");
		lbl20.setForeground(Color.white);
		lbl20.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		pRegister.add(lbl20).setBounds(8, 628, 30, 25);
		txtDate=new JTextField();
		pRegister.add(txtDate).setBounds(40, 630, 80, 20);
		txtTime=new JTextField();
		pRegister.add(txtTime).setBounds(130, 630, 80, 20);
		cmbsID=new JComboBox();
		pRegister.add(cmbsID).setBounds(240, 630, 90, 20);
		cmbAttendance=new JComboBox(att);
		pRegister.add(cmbAttendance).setBounds(360, 630, 90, 20);
		cmbCover=new JComboBox(Cover);
		pRegister.add(cmbCover).setBounds(480, 630, 50, 20);
		cmbcsID=new JComboBox();
		pRegister.add(cmbcsID).setBounds(560, 630, 90, 20);
		
		
		
		btnSave=new JButton("<html><i>Save");
	btnSave.setFont(new Font("Comic Sans MS",Font.BOLD,19));
		pRegister.add(btnSave).setBounds(220, 665, 90, 25);
		btnSave.addActionListener(this);
		btnCancel=new JButton("<html><i>Cancel");
	btnCancel.setFont(new Font("Comic Sans MS",Font.BOLD,19));
		pRegister.add(btnCancel).setBounds(350, 665, 90, 25);
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
			if(cmbAttendance.getSelectedItem().equals("Present") ){
				cmbCover1.setSelectedItem("No");
			}
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
		Register sa =new Register();
		sa.setSize(700,750);
		sa.setLocation(180,0);
		//sa.setLocationRelativeTo(null);
		sa.setVisible(true);
	}
	
	
}