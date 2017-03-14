package project1;



import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("serial")
public class samsam extends JFrame implements ActionListener, FocusListener {
	
	ResultSet rs=null;
	PreparedStatement ps=null;
 	Statement stmt = null;
	Connection con = null;
		
	private JPanel pAdmin = new JPanel ();
	private JLabel lblDate,lblTime,lblsId,lblfName,lblEmail,lblPosition,lblphone,lblCert,lblgName,lblgphone,lblAmount,lblBonus,lblOthers;
	JLabel lbl1,lbldd;
	
	private JTextField txtDate, txtTime,txtstaffID,txtfName,txtemail,txtPosition,txtphone,txtCert,txtgName,txtgphone,txtAmount,txtBonus,txtOthers;

String[] month1={"MONTH","January","February","March","April","May","June","July","August","September","October","November","December",};
String[] yrs1={"YEAR","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037","2038","2039","2040","2041","2042","2043","2044","2045","2046","2047","2048","2049","2050","2051","2052","2053","2054","2055","2056","2057","2058","2059","2060","2061","2062","2063","2064","2065","2066","2067","2068","2069","2070","2071","2072","2073","2074","2075","2076","2077","2078","2079","2080"};

JComboBox cmbMonth;
JComboBox cmbYear;

JButton btnSave,btnClear,btnPreview,btnExit,btnModify,btnNew;



private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);							//Storing Date.

String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());






	@SuppressWarnings({ "unchecked", "rawtypes" })
	public samsam () {
		//super (Title, Resizable, Closable, Maximizable, Iconifiable)
		//ssuper ("Create Admin Discharge Record", false, true, false, true);
		setSize(397,510);
		setLocation(100, 60);
		pAdmin.setLayout(null);
		
		
		lblDate=new JLabel("<html><i><b>Date :</i></b></html>");
		lblDate.setForeground(Color.white);
		
		pAdmin.add(lblDate).setBounds(10, -40, 70, 120);
		
		txtDate=new JTextField(d);
		txtDate.setFont(new Font("Algerian",Font.ITALIC,16));
		txtDate.setEditable(false);
		pAdmin.add(txtDate).setBounds(90, 12, 130, 20);
		

		lblTime=new JLabel("<html><i><b>Time :</i></b></html>");
		lblTime.setForeground(Color.white);
		pAdmin.add(lblTime).setBounds(10, -10, 70, 120);
		txtTime=new JTextField(timeStamp);
		txtTime.setEditable(false);
		 txtTime.setFont(new Font("Algerian",Font.ITALIC,14));
		pAdmin.add(txtTime).setBounds(90, 40, 130, 20);
		

		lblsId=new JLabel("<html><i><b>staff ID:</i></b></html>");
		lblsId.setForeground(Color.white);
		pAdmin.add(lblsId).setBounds(0, 16, 180, 120);
		txtstaffID=new JTextField();
		
		pAdmin.add(txtstaffID).setBounds(95, 68, 100, 20);
		
		

		lblfName=new JLabel("<html><i><b>Staff full Name :</i></b></html>");
		lblfName.setForeground(Color.white);
		pAdmin.add(lblfName).setBounds(0, 45, 180, 120);
		txtfName=new JTextField();
		
		pAdmin.add(txtfName).setBounds(95, 96, 380, 20);
		
		
		lblEmail=new JLabel("<html><i><b>Email :</i></b></html>");
		lblEmail.setForeground(Color.white);
		pAdmin.add(lblEmail).setBounds(0, 75, 180, 120);
		txtemail=new JTextField();

		pAdmin.add(txtemail).setBounds(95, 125, 230, 20);
		
		
		
		lblphone=new JLabel("<html><i><b>Phone Number :</i></b></html>");
		lblphone.setForeground(Color.white);
		lblphone.setFont(new Font("Algerian",Font.ITALIC,14));
		pAdmin.add(	lblphone).setBounds(15, 106, 180, 120);
		txtphone=new JTextField();
		
		/*txtppLitre.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
			
			
					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
				            c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
					getToolkit().beep ();
					ke.consume ();
				
			}
		}}
		);*/
		pAdmin.add(	txtphone).setBounds(159, 159, 230, 20);
		 
		
		
		
		
		lblPosition=new JLabel("<html><i><b>Position :</i></b></html>");
		lblPosition.setForeground(Color.white);
		 lblPosition.setFont(new Font("Algerian",Font.ITALIC,14));
		pAdmin.add(	lblPosition).setBounds(15, 136, 180, 120);
		txtPosition=new JTextField();
		//txtSale.setEditable(false);
		pAdmin.add(txtPosition).setBounds(159, 189, 230, 20);
		 
		
		lblCert=new JLabel("<html><i><b>Certification :</i></b></html>");
		lblCert.setForeground(Color.white);
		lblCert.setFont(new Font("Algerian",Font.ITALIC,14));
		pAdmin.add(	lblCert).setBounds(15, 166, 180, 120);
		txtCert=new JTextField();
		//txtrtTank.setEditable(false);
		txtCert.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
			
			
					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
				            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' ||c=='.')) {
					getToolkit().beep ();
					ke.consume ();
				
			}
		}}
		);
		pAdmin.add(txtCert).setBounds(159, 220, 230, 20);
		 
		
		lblgName=new JLabel("<html><i><b>Guarantor Name :</i></b></html>");
		lblgName.setForeground(Color.YELLOW);
		lblgName.setFont(new Font("Algerian",Font.ITALIC,12));
		pAdmin.add(	lblgName).setBounds(0, 196, 180, 120);
		txtgName=new JTextField();
		//txttdDifferent.setEditable(false);
		pAdmin.add(txtgName).setBounds(159, 250, 230, 20);
		 
		
		
		lblgphone=new JLabel("<html><i><b>Guarantor P_Number :</i></b></html>");
		lblgphone.setForeground(Color.YELLOW);
		lblgphone.setFont(new Font("Algerian",Font.ITALIC,12));
		pAdmin.add(	lblgphone).setBounds(0, 230, 180, 120);
		txtgphone=new JTextField();
		//txttGain.setEditable(false);
		pAdmin.add(txtgphone).setBounds(159, 280, 230, 20);
		 
		
		
		JLabel l=new JLabel("<html><i><b>Salary Payment for Month & Year.");
		l.setBounds(0,280,900,80);
		l.setFont(new Font("Algerian",Font.ITALIC,15));
		l.setForeground(Color.RED);
		pAdmin.add(l);
		
		cmbMonth=new JComboBox(month1);
	   	cmbMonth.setFont(new Font("serif",Font.BOLD,12));
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
	   	
		
		
		
		
		
		
			

		lblAmount=new JLabel("<html><i><b>Amount(N) :</i></b></html>");
		lblAmount.setForeground(Color.white);
		lblAmount.setFont(new Font("Algerian",Font.ITALIC,12));
		pAdmin.add(	lblAmount).setBounds(20, 310, 180, 90);
		txtAmount=new JTextField();
		//txttgSale.setEditable(false);
		pAdmin.add(txtAmount).setBounds(100, 348, 120, 20);
		 

		lblBonus=new JLabel("<html><i><b>Bonus :</i></b></html>");
		lblBonus.setForeground(Color.white);
		lblBonus.setFont(new Font("Algerian",Font.ITALIC,12));
		pAdmin.add(lblBonus).setBounds(20, 330, 80, 120);
		
		txtBonus =new JTextField();
		//txttgSale.setEditable(false);
		pAdmin.add(txtBonus).setBounds(100, 378, 120, 20);
		 


		lblOthers=new JLabel("<html><i><b>Others  :</i></b></html>");
		lblOthers.setForeground(Color.white);
		lblOthers.setFont(new Font("Algerian",Font.ITALIC,12));
		pAdmin.add(lblOthers).setBounds(20, 360, 80, 120);
		
		txtOthers=new JTextField();
		//txttgSale.setEditable(false);
		pAdmin.add(txtOthers).setBounds(100, 410, 120, 20);
		 


		
		btnSave=new JButton("Save");
		pAdmin.add(btnSave).setBounds(0, 451, 65, 15);
		btnNew=new JButton("New");
		pAdmin.add(btnNew).setBounds(69, 451, 60, 15);
		btnModify=new JButton("Modify");
		pAdmin.add(btnModify).setBounds(135, 451, 80, 15);
		
		btnPreview=new JButton("Preview");
		pAdmin.add(btnPreview).setBounds(225, 451, 80, 15);
		btnClear=new JButton("Clear");
		pAdmin.add(btnClear).setBounds(310, 451, 75, 15);
		btnExit=new JButton("Exit");
		pAdmin.add(btnExit).setBounds(390, 451, 75, 15);
		
		
		
	
		 		lbl1 = new JLabel(new ImageIcon("images//2.jpg"));
		 		lbl1.setBounds(0,0,477,150);
		 		pAdmin.add(lbl1);
		 		JLabel lbl2 = new JLabel(new ImageIcon("images//2.jpg"));
		 		lbl2.setBounds(0,151,477,150);
				pAdmin.add(lbl2);
				JLabel lbl3 = new JLabel(new ImageIcon("images//2.jpg"));
				lbl3.setBounds(0,285,477,200);
				pAdmin.add(lbl3);
				getContentPane().add (pAdmin, BorderLayout.CENTER);

				btnNew.addActionListener(this);
		btnSave.addActionListener(this);
		btnClear.addActionListener(this);
		btnPreview.addActionListener(this);
		btnExit.addActionListener(this);
	

	}
	
	

	@SuppressWarnings("unused")
	private void txtClear () {

	/*txtoDipping.setText ("");
		txtcDipping.setText ("");
		*/
		
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
		Object obj = e.getSource();
		

	    try{

        	
      	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D://database//rakedomanagement.mdb;DriverID=22;READONLY=true) ","","");
	
		    stmt=con.createStatement(); 
		   
	    }

	    
	    catch(Exception ex){
	    
	   JOptionPane.showMessageDialog(null, "Failed Connection","Error",JOptionPane.ERROR_MESSAGE);
	}


		
		
		
		
		
		
		
		
		
		
		
		
		
		if (obj == btnExit) {		//If Cancel Button Pressed Unload the From.
			MainMenuFrame sam=new MainMenuFrame();
			sam.setVisible(true);
			dis_charge_report.setDefaultLookAndFeelDecorated(true);
			setVisible(false);
			
			
			
		}
		if(obj==btnClear){
			txtClear();
			
		}
		if(obj==btnPreview){
			
			payroll_list l=new payroll_list();
			l.setSize(1320,580);
			l.setLocation(20,80);
				l.setVisible(true);
				setVisible(false);

			}
			
	            
			
		
        if(e.getSource()==btnSave){

        	SaveRecord();

        }
	}
            void SaveRecord(){
            	///////
            	
            	
            	
            	

        	    try{

                	
              	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        		    con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D://database//rakedomanagement.mdb;DriverID=22;READONLY=true) ","","");
        	
        		    stmt=con.createStatement(); 
        		   
        	    }

        	    
        	    catch(Exception ex){
        	    
        	   JOptionPane.showMessageDialog(null, "Failed Connection","Error",JOptionPane.ERROR_MESSAGE);
        	}

        	    
                try{
            String s1="",s2="",s3="",s4="",s5="" ,s6="",s7="",s8="",s9="",s10="",s11="",s12="",s13="",s14="",s15="";
            String date=txtDate.getText();
            String time=txtTime.getText();
            String staffID=txtstaffID.getText();
            String fName=txtfName.getText();
            String email=txtemail.getText();
            String phone=txtphone.getText();
            String position=txtPosition.getText();  
            String cert=txtCert.getText();
            String gName=txtgName.getText();
            String gPhone=txtgphone.getText();
            String amount=txtAmount.getText();
            String bonus=txtBonus.getText();
            String others=txtOthers.getText();
            Object month=cmbMonth.getSelectedItem();
            Object year=cmbYear.getSelectedItem();
                    
            
            
                 if(date.length()==0 && time.length()==0 && staffID.length()==0 && fName.length()==0 && email.length()==0 && phone.length()==0 && position.length()==0 && cert.length()==0){
                     
                     JOptionPane.showMessageDialog(null, "Please Required All Field ?", "Error",JOptionPane.ERROR_MESSAGE);
                
                 }
                
                else if(!s1.equals("'") || !s2.equals("'") ||!s3.equals("'") ||!s4.equals("'")||!s5.equals("'") ||!s6.equals("'")||!s7.equals("'")||!s8.equals("'")||!s9.equals("'")||!s10.equals("'")||!s11.equals("'")||!s12.equals("'")||!s13.equals("'")||!s14.equals("'")||!s15.equals("'")){
                   
                       
                    String query =("insert into payroll values('"+date+"','"+time+"','"+staffID+"','"+fName+"','"+email+"' ,'"+phone+"' ,'"+position+"' ,'"+cert+"' ,'"+gName+"' ,'"+gPhone+"' ,'"+amount+"' ,'"+bonus+"' ,'"+others+"' ,'"+month+"' ,'"+year+"')");
                    stmt = con.createStatement();
                    stmt.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Registration Successfully....", "Message",JOptionPane.INFORMATION_MESSAGE);
                }} catch (Exception e) {
    					// TODO: handle exception
                    	 System.out.println("ssss");
    				}

                
                }
/*

                   
           	 String query="INSERT INTO 'samsam'('date','time')values('"+txtDate.getText()+"','"+txtTime.getText()+"')";
           	// stmt.executeUpdate(query);
           	 
            }catch (Exception e2) {
					// TODO: handle exception
				
            System.out.println("i lovbe jesus");
            }
                
                try {
               	 
               	  JOptionPane.showMessageDialog(null, "Registration Successfully....", "Message",JOptionPane.INFORMATION_MESSAGE);
                     

				} catch (Exception e2) {
					// TODO: handle exception
				}
               
                
              
   	
           
            
}}*/
        		
        		
            
            /*	if(txtoDipping.getText().equals("") || txtcDipping.getText().equals("")||txtppLitre.getText().equals("")||txtrtTank.getText().equals("")){
            		JOptionPane.showMessageDialog(null, "Fill All empty Field");
            	}
            	
            	 else if (cmbMonth.getSelectedItem().equals("Month") ||cmbYear.getSelectedItem().equals("Year") ){
            		
            		 JOptionPane.showMessageDialog(null, "invalid month & year selection ");
            	}
            	
            	else {
            		
            		*/
            		

			
		 
public static void main(String[] args) {
	samsam sam=new samsam();
	
	sam.setSize(490,510);
	
	
	sam.setVisible(true);
	sam.setLocationRelativeTo(null);
	sam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
}
            
            
            
            
            
            
            
            
            
       /*     
            
                	// String sql="INSERT INTO  staff(staffId,fName,address,position,email,sofOrigin,phone,cert,lgArea,dob,doe,dor,gname,gpnumber,gaddress,gender)values('"+txtsId.getText()+"','"+txtfName.getText()+"','"+txtAddress.getText()+"','"+txtPosition.getText()+"','"+txtEmail.getText()+"','"+txtsOfOrigin.getText()+"','"+txtpNumber.getText()+"','"+txtCert.getText()+"','"+txtlgovArea.getText()+"','"+txtdOfBirth.getText()+"','"+txtdOfemployment.getText()+"','"+txtdOfRegistration.getText()+"','"+txtgName.getText()+"','"+txtgpNumber.getText()+"','"+txtgAddress.getText()+"','"+cgender.getSelectedItem()+"')";
                	// String query="INSERT INTO samsam(date,time)VALUES('"+txtDate.getText()+"','"+txtTime.getText()+"')";
        	
        	
    		
    	 	//String sql="INSERT INTO  payroll(date,time,staffID,fName,email,phone,position,cert,gName,gPhone,amount,bonus,others,month,year)values('"+txtDate.getText()+"','"+txtTime.getText()+"','"+txtoDipping.getText()+"','"+txtcDipping.getText()+"','"+txtdDifferent.getText()+"','"+txtppLitre.getText()+"','"+txtSale.getText()+"','"+txtrtTank.getText()+"','"+txttdDifferent.getText()+"','"+txttGain.getText()+"','"+txttgSale.getText()+"','"+txtBonus.getText()+"','"+txtOthers.getText()+"','"+cmbMonth.getSelectedItem()+"','"+cmbYear.getSelectedItem()+"')";
    	 	//String sql=" INSERT INTO `dailystaffreport`(`staffid`, `fname`, `phone`, `email`, `oCounter`, `cCounter`, `ppLitre`, `date`, `time`, `sale`, `litre`, `product`, `pump`, `nozzle`, `address`,`report`) VALUES ('"+txtsId.getText()+"','"+txtfName.getText()+"','"+txtpNumber.getText()+"','"+txtEmail.getText()+"','"+txtoCounter.getText()+"','"+txtcCounter.getText()+"','"+txtppLitre.getText()+"','"+txtdate.getText()+"','"+txttime.getText()+"','"+txtSale.getText()+"','"+txtLitre.getText()+"','"+cProduct.getSelectedItem()+"','"+cPump.getSelectedItem()+"','"+cnNumber.getSelectedItem()+"','"+txtAddress.getText()+"','"+txtReport.getText()+"')";
    	 	//String sql=" INSERT INTO `payroll`(`date`, `time`, `staffID`, `fName`, `email`) VALUES ('"+txtDate.getText()+"','"+txtTime.getText()+"','"+txtstaffID.getText()+"','"+txtfName.getText()+"','"+txtemail.getText()+"')";
    	 				String sql="INSERT INTO samsam(date,time)values('"+txtDate.getText()+"','"+txtTime.getText()+"')";
    	 				//String sql="INSERT INTO staff(staffId,fName)values('"+txtDate.getText()+"','"+txtTime.getText()+"')";
    	 			 	
    	 				
    	 				//String sql=" INSERT INTO details(sn,fname,dob,gender,hq,pfn,email,attendance,state,gradea, gradeb, gradec, graded, gradee,percentage,remark)values('"+txtsId.getText()+"','"+txtfName.getText()+"','"+txtDob.getText()+"','"+cmbgender.getSelectedItem()+"','"+txtHQ.getText()+"','"+txtPFN.getText()+"','"+txtEmail.getText()+"','"+cmbAttendance.getSelectedItem()+"','"+cmbState.getSelectedItem()+"','"+cA.getSelectedIndex()+"','"+cB.getSelectedIndex()+"','"+cC.getSelectedIndex()+"','"+cD.getSelectedIndex()+"','"+cE.getSelectedIndex()+"','"+txtPercent.getText()+"','"+txtRemark.getText()+"')";
*/