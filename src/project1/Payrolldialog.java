package project1;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Payrolldialog extends JDialog implements ActionListener, FocusListener {
	CheckboxGroup	cbmf;
	Checkbox cbm,cbf;
	ResultSet rs=null;
 	Statement stmt = null;
	Connection con = null;
		String user="ayets";
		String pass="setonji04";
	private JPanel pAdmin = new JPanel ();
	private JLabel lblDate,lblTime,lbloDipping,lblcDipping,lblGender,lbldDifferent,lblSale,lblppLitre,lblrtTank,lbltdDifferent,lbltGain,lbltgSale,lblExpense;
	JLabel lbl1,lbldd;
	
	private JTextField txtDate, txtTime,txtstaffID,txtfName,txtemail,txtpNumber,txtPosition,txtCert,txtgName,txtgPhone,txtAmount,txtBonus;
	TextArea txtOthers;
PreparedStatement ps=null;
String[] month1={"MONTH","January","February","March","April","May","June","July","August","September","October","November","December",};
String[] yrs1={"YEAR","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037","2038","2039","2040","2041","2042","2043","2044","2045","2046","2047","2048","2049","2050","2051","2052","2053","2054","2055","2056","2057","2058","2059","2060","2061","2062","2063","2064","2065","2066","2067","2068","2069","2070","2071","2072","2073","2074","2075","2076","2077","2078","2079","2080"};

JComboBox cmbMonth;
JComboBox cmbYear;

JButton btnUpdate,btnClear,btnCancel;



private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);							//Storing Date.

String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());





	
			//Statement for Getting the Required Table.
	private long id = 0;			//To Hold the BookId.

	//Constructor of Class.

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Payrolldialog () {
		setTitle("Staff Payroll System");
		setSize(397,510);
		setLocation(100, 60);
	/*	addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				
				MainMenuFrame sam=new MainMenuFrame();
				sam.setVisible(true);
				dis_charge_report.setDefaultLookAndFeelDecorated(true);
				setVisible(false);
				
				
				
			}
		});*/
		pAdmin.setLayout(null);
		
		
		lblDate=new JLabel("<html><i><b>Date(dd/mm/yyyy):</i></html>");
		lblDate.setForeground(Color.white);
		lblDate.setFont(new Font("serif",Font.ITALIC,14));
		
		pAdmin.add(lblDate).setBounds(0, -40, 120, 120);
		
		txtDate=new JTextField();
		txtDate.setFont(new Font("Algerian",Font.ITALIC,16));
		
		pAdmin.add(txtDate).setBounds(120, 12, 90, 20);
		

		lblTime=new JLabel("<html><i><b>Time(hh :mm: ss):</i></html>");
		lblTime.setForeground(Color.white);
		lblTime.setFont(new Font("serif",Font.ITALIC,14));
		pAdmin.add(lblTime).setBounds(0, -10, 120, 120);
		txtTime=new JTextField();
	
		 txtTime.setFont(new Font("Algerian",Font.ITALIC,14));
		pAdmin.add(txtTime).setBounds(120, 40, 90, 20);
		
		lblGender=new JLabel("<html><b><i>Gender :</i></b></html>");
		lblGender.setFont(new Font("Algerian",Font.ITALIC,14));
		lblGender.setForeground(Color.white);
		pAdmin.add(lblGender).setBounds(250,30,100,20);


	   	
		cbmf=new CheckboxGroup();
		cbm=new Checkbox("Male",cbmf,true);
		cbf=new Checkbox("Female",cbmf,false);
	   	cbm.setBounds(328,37,50,15);
	   	add(cbm);
	   	cbf.setBounds(390,37,80,15);
	   	add(cbf);

		lbloDipping=new JLabel("<html><i><b>staff ID:</i></b></html>");
		lbloDipping.setForeground(Color.white);
		pAdmin.add(lbloDipping).setBounds(0, 16, 180, 120);
		txtstaffID=new JTextField();
		/*txtstaffID.addKeyListener (new KeyAdapter () {
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
				
				
						if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' ||c=='.')) {
						getToolkit().beep ();
						ke.consume ();
					
				}
			}}
			);*/
		pAdmin.add(txtstaffID).setBounds(95, 68, 100, 20);
		
		

		lblcDipping=new JLabel("<html><i><b>Staff full Name :</i></b></html>");
		lblcDipping.setForeground(Color.white);
		pAdmin.add(lblcDipping).setBounds(0, 45, 180, 120);
		txtfName=new JTextField();
		txtfName.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				
				if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_SPACE))) {
					
					 	getToolkit().beep ();
					ke.consume ();
				}
			
		}}
		);
		pAdmin.add(txtfName).setBounds(95, 96, 380, 20);
		
		
		
		lbldDifferent=new JLabel("<html><i><b>Email :</i></b></html>");
		lbldDifferent.setForeground(Color.white);
		pAdmin.add(lbldDifferent).setBounds(0, 75, 180, 120);
		txtemail=new JTextField();
		txtemail.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				
				if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_SPACE))) {
					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
				            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' ||c=='_'||c=='@'||c=='-'||c=='.')) {
				
					
					
					 	getToolkit().beep ();
					ke.consume ();
				}}
			
		}}
		);
		pAdmin.add(txtemail).setBounds(95, 125, 230, 20);
		
		
		
		lblppLitre=new JLabel("<html><i><b>Phone Number :</i></b></html>");
		lblppLitre.setForeground(Color.white);
		lblppLitre.setFont(new Font("Algerian",Font.ITALIC,14));
		pAdmin.add(	lblppLitre).setBounds(15, 106, 180, 120);
		txtpNumber=new JTextField();
		
		txtpNumber.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
			
			
					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
				            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' )) {
					getToolkit().beep ();
					ke.consume ();
				
			}
		}}
		);
		pAdmin.add(	txtpNumber).setBounds(159, 159, 230, 20);
		 
		
		
		
		
		lblSale=new JLabel("<html><i><b>Position :</i></b></html>");
		lblSale.setForeground(Color.white);
		 lblSale.setFont(new Font("Algerian",Font.ITALIC,14));
		pAdmin.add(	lblSale).setBounds(15, 136, 180, 120);
		txtPosition=new JTextField();
		//txtSale.setEditable(false);
		pAdmin.add(txtPosition).setBounds(159, 189, 230, 20);
		 
		
		lblrtTank=new JLabel("<html><i><b>Certification :</i></b></html>");
		lblrtTank.setForeground(Color.white);
		lblrtTank.setFont(new Font("Algerian",Font.ITALIC,14));
		pAdmin.add(	lblrtTank).setBounds(15, 166, 180, 120);
		txtCert=new JTextField();
		//txtrtTank.setEditable(false);
		
		pAdmin.add(txtCert).setBounds(159, 220, 230, 20);
		 
		
		lbltdDifferent=new JLabel("<html><i><b>Guarantor Name :</i></b></html>");
		lbltdDifferent.setForeground(Color.YELLOW);
		lbltdDifferent.setFont(new Font("Algerian",Font.ITALIC,12));
		pAdmin.add(	lbltdDifferent).setBounds(0, 196, 180, 120);
		txtgName=new JTextField();
		//txttdDifferent.setEditable(false);
		pAdmin.add(txtgName).setBounds(159, 250, 230, 20);
		 
		
		
		lbltGain=new JLabel("<html><i><b>Guarantor P_Number :</i></b></html>");
		lbltGain.setForeground(Color.YELLOW);
		lbltGain.setFont(new Font("Algerian",Font.ITALIC,12));
		pAdmin.add(	lbltGain).setBounds(0, 230, 180, 120);
		txtgPhone=new JTextField();
		//txttGain.setEditable(false);
		pAdmin.add(txtgPhone).setBounds(159, 280, 230, 20);
		 
		
		
		JLabel l=new JLabel("<html><i><b>Salary Payment for Month & Year.");
		l.setBounds(0,280,900,80);
		l.setFont(new Font("Algerian",Font.ITALIC,15));
		l.setForeground(Color.RED);
		pAdmin.add(l);
		
		cmbMonth=new JComboBox(month1);
	   	cmbMonth.setFont(new Font("serif",Font.BOLD,10));
	   	cmbMonth.setToolTipText("Select The Month ");
	   	cmbMonth.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	   	cmbMonth.setEditable(false);
	   	cmbMonth.setMaximumRowCount(5);
	   	pAdmin.add(cmbMonth).setBounds(313,315,80,20);
	   	cmbYear=new JComboBox(yrs1);
	   	cmbYear.setFont(new Font("serif",Font.BOLD,12));
	   	cmbYear.setToolTipText("Select The Year");
	   	cmbYear.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	   	cmbYear.setEditable(false);
	   	cmbYear.setMaximumRowCount(5);
	   	pAdmin.add(cmbYear).setBounds(399,315,80,20);
	   	
		
		
		
		
		
		
			

		lbltgSale=new JLabel("<html><i><b>Amount(N) :</i></b></html>");
		lbltgSale.setForeground(Color.white);
		lbltgSale.setFont(new Font("Algerian",Font.ITALIC,12));
		pAdmin.add(	lbltgSale).setBounds(20, 310, 180, 90);
		txtAmount=new JTextField();
		txtAmount.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
			
			
					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
				            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' ||c=='.')) {
					getToolkit().beep ();
					ke.consume ();
				
			}
		}}
		);
		pAdmin.add(txtAmount).setBounds(100, 348, 120, 20);
		 

		lblExpense=new JLabel("<html><i><b>Bonus :</i></b></html>");
		lblExpense.setForeground(Color.white);
		lblExpense.setFont(new Font("Algerian",Font.ITALIC,12));
		pAdmin.add(lblExpense).setBounds(20, 330, 80, 120);
		
		txtBonus =new JTextField();
		txtBonus.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
			
			
					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
				            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' ||c=='.')) {
					getToolkit().beep ();
					ke.consume ();
				
			}
		}}
		);
		pAdmin.add(txtBonus).setBounds(100, 378, 120, 20);
		 


		lblExpense=new JLabel("<html><i><b>Others  :</i></b></html>");
		lblExpense.setForeground(Color.white);
		lblExpense.setFont(new Font("Algerian",Font.ITALIC,12));
		pAdmin.add(lblExpense).setBounds(20, 360, 80, 120);
		
		txtOthers=new TextArea();
		//txttgSale.setEditable(false);
		pAdmin.add(txtOthers).setBounds(100, 401, 350, 48);
		 

		btnUpdate=new JButton("Update");
		pAdmin.add(btnUpdate).setBounds(100, 455, 80, 20);
		btnClear=new JButton("Clear");
		pAdmin.add(btnClear).setBounds(190, 455, 80, 20);
		
		btnCancel=new JButton("Cancel");
		pAdmin.add(btnCancel).setBounds(290, 455, 80, 20);
		
		
		
	
		 		lbl1 = new JLabel(new ImageIcon("images//2.jpg"));
		 		lbl1.setBounds(0,0,477,150);
		 		pAdmin.add(lbl1);
		 		JLabel lbl2 = new JLabel(new ImageIcon("images//2.jpg"));
		 		lbl2.setBounds(0,155,477,150);
				pAdmin.add(lbl2);
				JLabel lbl3 = new JLabel(new ImageIcon("images//2.jpg"));
				lbl3.setBounds(0,288,477,209);
				pAdmin.add(lbl3);
				getContentPane().add (pAdmin, BorderLayout.CENTER);

				
	}
	




public static void main(String[] args) {
Payrolldialog sam=new Payrolldialog();

sam.setSize(490,515);


sam.setVisible(true);
sam.setLocationRelativeTo(null);

}





@Override
public void focusGained(FocusEvent e) {
	// TODO Auto-generated method stub
	
}





@Override
public void focusLost(FocusEvent e) {
	// TODO Auto-generated method stub
	
}





@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
	





}