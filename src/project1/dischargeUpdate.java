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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.*;



@SuppressWarnings("serial")
public class dischargeUpdate extends JFrame implements ActionListener {
	
JPanel pane=new JPanel();
JLabel lbldb4Discharge,lbldaDischarge,lbltldischarge,lblDate,lbltime,lblShortage,lblDepot,lblaDipping,lbledValue;
JTextField txtdb4Discharge,txtdaDischarge,txttldischarge,txtDate,txtTime,txtShortage,txtaDipping,txtedValue;
	
	JButton btnModify,btnClear,btnCancel;

private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);							//Storing Date.

Connection con=null;
Statement st=null;
PreparedStatement ps=null;

String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());

	
	dischargeUpdate(){
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
		
		
		

		btnClear=new JButton("Clear");
	pane.add(btnClear).setBounds(160,248,70,20);
		
		btnClear.addActionListener(this);
		

		btnModify =new JButton("Modify");
	pane.add(btnModify).setBounds(75,248,79,20);
		
	btnModify.addActionListener(this);

		
		btnCancel=new JButton("Cancel");
		pane.add(btnCancel).setBounds(240,248,75,20);
		btnCancel.addActionListener(this);
		
		
		
	/*	
		JLabel lblimage1 = new JLabel(new ImageIcon("images//back1.jpg"));
		
		lblimage1.setBounds(100,-50,400,250);
		pane.add(lblimage1);
JLabel lblimage2 = new JLabel(new ImageIcon("images//back1.jpg"));
		
		lblimage2.setBounds(-60,60,220,250);
		pane.add(lblimage2);
	
		
JLabel lblimage3 = new JLabel(new ImageIcon("images//sa.jpg"));
		
		lblimage3.setBounds(108,60,400,250);
		pane.add(lblimage3);
JLabel lblimage4 = new JLabel(new ImageIcon("images//sa.jpg"));
		
		lblimage4.setBounds(-60,-50,400,250);
		pane.add(lblimage4);
	
		
		*/
	
	getContentPane().add(pane,BorderLayout.CENTER);
	}
	
	
	public static void main(String[] args) {
		dischargeUpdate s=new dischargeUpdate();
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
		
		

		if(obj==btnClear){
			
			
		}
		
		
		if(obj==btnCancel){
			MainMenuFrame sam=new MainMenuFrame();
			sam.setVisible(true);
			dis_charge_report.setDefaultLookAndFeelDecorated(true);
			setVisible(false);
			
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
	
}
