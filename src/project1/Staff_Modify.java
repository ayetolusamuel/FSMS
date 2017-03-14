package project1;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Staff_Modify extends JDialog {
private JLabel lblsId,lblfName,lblPosition,lblsofOrigin,lblpNumber,lblLGA,lblDOE,lblCert,lblAddress,lblGender,lblEmail,lblgName,lblgpNumber,lblgAddress;
	private JPanel main;
private	JTextField txtsCode,txtfName,txtEmail,txtpNumber,txtLGA,txtCert,txtgName,txtgpNumber,txtPosition;
	private JComboBox cmbsofOrigin,cmbdDay,cmbdMonth,cmbdYear;
	JTextArea addfield1,gAddress;
	private JButton btnUpdate,btnClear,btnCancel;
	
	String[] Day1={"DAYS","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String[] month1={"MONTH","January","February","March","April","May","June","July","August","September","October","November","December",};
	String[] yrs1={"YEAR","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};

	
	String[] state={"select","Abia" ,"Adamawa","Akwa-Ibom","Bauchi","Bayelsa","Benue","Borno","Cross-River","Delta","Ekiti","Ebonyi","Edo","Enugu","Gombe","Imo","Jigawa","Kaduna","Kastina","Kano","Kebbi","Kogi","Kwara","Lagos","Nassarawa","Niger","Ogun","Ondo","Osun","Oyo","Plateau","Rivers","Sokoto","Taraba","Yobe","Zamfara","FCT"};
	PreparedStatement ps=null;
	CheckboxGroup cbmf;
	Checkbox cbm,cbf;

	Staff_Modify(){
		main=new JPanel();
		main=new JPanel()
		{
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
				g.drawImage(img,0,0,800,650,null);
			}
		};
		
		
		
		
		main.setLayout(null);
	
	
	
	
	
	
	lblsId=new JLabel("<html><b><i>Staff ID Number:</i></b></html>");
	main.add(lblsId).setBounds(10,60,500,20);
	//scode=new JTextField();
	txtsCode=new JTextField(10);
	txtsCode.setEditable(false);
	txtsCode.setToolTipText("Staff Identification Number");
	txtsCode.setFont(new Font("Times New Roman",Font.ITALIC,18));
	txtsCode.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	main.add(txtsCode).setBounds(120,62,200,20);
	
	lblfName=new JLabel("<html><b><i>Staff Full name :</i></b></html>");
	main.add(lblfName).setBounds(10,90,500,20);
	txtfName=new JTextField(20);
	main.add(txtfName).setBounds(120,92,550,20);
	//sname.addKeyListener(onlyText);
	txtfName.setFont(new Font("Times New Roman",Font.ITALIC,18));
	txtfName.setToolTipText("Enter Staff full Name");
	txtfName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	
	
	
	lblPosition=new JLabel("<html><b><i>Position :</i></b></html>");
	//main.add(lblPosition).setBounds(10,210,500,20);
	main.add(lblPosition).setBounds(10,240,500,20);
	
	txtPosition=new JTextField(20);
	txtPosition.setFont(new Font("Times New Roman",Font.ITALIC,18));
	//lname.addKeyListener(onlyText);
	txtPosition.setToolTipText("Enter Staff Email Address");
	txtPosition.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	main.add(txtPosition).setBounds(120,242,200,20);
	
	
	lblEmail=new JLabel("<html><b><i>Email :</i></b></html>");
	//main.add(lblEmail).setBounds(10,240,500,20);
	main.add(lblEmail).setBounds(10,210,500,20);
	
	txtEmail=new JTextField(20);
	txtEmail.setFont(new Font("Times New Roman",Font.ITALIC,18));
	//txtEmail.addKeyListener(onlyText);
	txtEmail.setToolTipText("Enter Staff Email Address");
	txtEmail.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	main.add(txtEmail).setBounds(120,212,500,20);
	
	//
	
	
	lblpNumber=new JLabel("<html><b><i>Phone Number :</i></b></html>");
	main.add(lblpNumber).setBounds(380,240,500,20);
	txtpNumber=new JTextField(20);
	//txtpNumber.addKeyListener(onlyText);
	txtpNumber.setFont(new Font("Times New Roman",Font.ITALIC,18));
	txtpNumber.setToolTipText("Enter Staff Phone number ");
	txtpNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	main.add(txtpNumber).setBounds(490,242,200,20);

	lblsofOrigin=new JLabel("<html><b><i>State Of Origin :</i></b></html>");
	main.add(lblsofOrigin).setBounds(10,270,500,20);
	cmbsofOrigin=new JComboBox(state);
	cmbsofOrigin.setFont(new Font("serif",Font.ITALIC,15));
	cmbsofOrigin.setToolTipText("Select The State");
	cmbsofOrigin.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	cmbsofOrigin.setEditable(false);
	cmbsofOrigin.setMaximumRowCount(5);
	main.add(cmbsofOrigin).setBounds(120,270,100,25);
	
	
	lblLGA=new JLabel("<html><b><i>Local Govt. Area :</i></b></html>");
	main.add(lblLGA).setBounds(10,310,500,20);
	txtLGA=new JTextField(20);
	//txtLGA.addKeyListener(onlyText);
	txtLGA.setToolTipText("Enter Local Government Area");
	txtLGA.setFont(new Font("Times New Roman",Font.ITALIC,18));
	
	txtLGA.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	main.add(txtLGA).setBounds(120,312,200,20);
	
	lblGender=new JLabel("<html><b><i>Gender :</i></b></html>");
	main.add(lblGender).setBounds(380,310,100,20);


   	
   	cbmf=new CheckboxGroup();
   	cbm=new Checkbox("Male",cbmf,true);
   	cbf=new Checkbox("Female",cbmf,false);
   	cbm.setBounds(590,315,50,15);
   	add(cbm);
   	cbf.setBounds(490,315,80,15);
   	add(cbf);
	
	lblDOE=new JLabel("<html><b><i>Date Of Birth :</i></b></html>");
   	main.add(lblDOE).setBounds(10,350,200,20);
   	cmbdDay=new JComboBox(Day1);
   	cmbdDay.setFont(new Font("serif",Font.BOLD,12));
   	cmbdDay.setToolTipText("Select The Day");
   	cmbdDay.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
   	cmbdDay.setEditable(false);
   	cmbdDay.setMaximumRowCount(5);
   	main.add(cmbdDay).setBounds(120,350,65,20);
   	cmbdMonth=new JComboBox(month1);
   	cmbdMonth.setFont(new Font("Times New Roman",Font.ITALIC,13));
	 cmbdMonth.setToolTipText("Select The Month");
   	cmbdMonth.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
   	cmbdMonth.setEditable(false);
   	cmbdMonth.setMaximumRowCount(5);
   	main.add(cmbdMonth).setBounds(185,350,80,20);
   	cmbdYear=new JComboBox(yrs1);
   	cmbdYear.setFont(new Font("Times New Roman",Font.ITALIC,13));
	cmbdYear.setToolTipText("Select The Year");
   	cmbdYear.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
   	cmbdYear.setEditable(false);
   	cmbdYear.setMaximumRowCount(5);
   	main.add(cmbdYear).setBounds(265,350,80,20);
   	
   	
 	
	lblDOE=new JLabel("<html><b><i>Date Of Employment :</i></b></html>");
   	main.add(lblDOE).setBounds(380,350,200,20);
   	cmbdDay=new JComboBox(Day1);
   	cmbdDay.setFont(new Font("serif",Font.BOLD,12));
   	cmbdDay.setToolTipText("Select The Day");
   	cmbdDay.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
   	cmbdDay.setEditable(false);
   	cmbdDay.setMaximumRowCount(5);
   	main.add(cmbdDay).setBounds(510,350,65,20);
   	cmbdMonth=new JComboBox(month1);
   	cmbdMonth.setFont(new Font("serif",Font.BOLD,12));
   	cmbdMonth.setToolTipText("Select The Month ");
   	cmbdMonth.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
   	cmbdMonth.setEditable(false);
   	cmbdMonth.setMaximumRowCount(5);
   	main.add(cmbdMonth).setBounds(572,350,80,20);
   	cmbdYear=new JComboBox(yrs1);
   	cmbdYear.setFont(new Font("serif",Font.BOLD,12));
   	cmbdYear.setToolTipText("Select The Year");
   	cmbdYear.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
   	cmbdYear.setEditable(false);
   	cmbdYear.setMaximumRowCount(5);
   	main.add(cmbdYear).setBounds(650,350,80,20);

   	lblCert=new JLabel("<html><b><i>Certification :</i></b></html>");
	main.add(lblCert).setBounds(380,270,500,20);
	txtCert=new JTextField(20);
	//txtCert.addKeyListener(onlyText);
	txtCert.setFont(new Font("Times New Roman",Font.ITALIC,18));
	
	txtCert.setToolTipText("Enter Staff Certification");
	txtCert.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	main.add(txtCert).setBounds(490,272,200,20);
	
	lblAddress=new JLabel("<html><b><i>Address :</i></b></html>");
	main.add(lblAddress).setBounds(10,120,500,20);
	
	
	
	addfield1=new JTextArea(2,20);
	addfield1.setToolTipText("Enter Staff Address");
	addfield1.setFont(new Font("Times New Roman",Font.ITALIC,18));
	addfield1.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	addfield1.setWrapStyleWord(true);
	addfield1.setLineWrap(true);
	
	JScrollPane addfield=new JScrollPane(addfield1);
	main.add(addfield).setBounds(120,122,550,80);
	

   

	JLabel l=new JLabel("<html><font size=6 color=#800080><i>Enter The  Guarantor Details Below Correctly.");
	l.setBounds(100,370,900,80);
	main.add(l);
		
	JLabel lbl1 = new JLabel(new ImageIcon("images//HEADER.gif"));
	lbl1.setBounds(0,390,900,50);
	main.add(lbl1);
	
	lblgName=new JLabel("<html><b><i>Guarantor Name :</i></b></html>");
	main.add(lblgName).setBounds(10,450,500,20);
	txtgName=new JTextField();
	txtgName.setToolTipText("Enter The Guarantor Full Name");
	txtgName.setFont(new Font("Times New Roman",Font.ITALIC,18));
	txtgName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	main.add(txtgName).setBounds(120,452,500,23);
	
	lblgpNumber=new JLabel("<html><b><i>Phone Number :</i></b></html>");
	main.add(lblgpNumber).setBounds(10,480,500,20);
	txtgpNumber=new JTextField(20);
	//txtgpNumber.addKeyListener(onlyText);
	txtgpNumber.setFont(new Font("Times New Roman",Font.ITALIC,18));
	txtgpNumber.setToolTipText("Enter The Guarantor Phone number ");
	txtgpNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	main.add(txtgpNumber).setBounds(120,482,200,20);
	
	
	lblgAddress=new JLabel("<html><b><i>Address :</i></b></html>");
	main.add(lblgAddress).setBounds(10,510,500,20);
	gAddress=new JTextArea(2,20);
	gAddress.setFont(new Font("Times New Roman",Font.ITALIC,18));
	gAddress.setToolTipText("Enter The Guarantor Address");
	gAddress.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	gAddress.setWrapStyleWord(true);
	gAddress.setLineWrap(true);
	
	JScrollPane gAddress1=new JScrollPane(gAddress);
	
	main.add(gAddress1).setBounds(120,512,550,80);
	
	btnUpdate=new JButton("Update");
	main.add(btnUpdate).setBounds(250,610,100,20);
	
	btnClear=new JButton("Clear");
	main.add(btnClear).setBounds(380,610,100,20);
	
	btnCancel=new JButton("Cancel");
	main.add(btnCancel).setBounds(500,610,100,20);
	
	
	getContentPane().add(main,BorderLayout.CENTER);
	
	}
	public static void main(String[] args) {
		
		Staff_Modify sa=new Staff_Modify();
		
		sa.setSize(800,660);
		sa.setLocation(20,20);
		sa.setVisible(true);
		sa.setResizable(false);
		
	}
}
