package project1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.color.CMMException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

@SuppressWarnings("serial")
public class discharge_or extends JFrame implements ActionListener, MouseListener {
	
JPanel pane=new JPanel();
JLabel lbldb4Discharge,lbldaDischarge,lbltldischarge,lblDate,lbltime,lblShortage,lblDepot,lblaDipping,lbledValue,lblProduct,lbledv;
JTextField txtdb4Discharge,txtdaDischarge,txttldischarge,txtDate,txtTime,txtShortage,txtedv;
private JComboBox jmbProduct,txtedValue;
String[] name={"Select","PMS","AGO","DPK"};
	JTable table;
String dDate;
	JButton btnModify,btnSave,btnDelete,btnPrint,btnPreview,btnNew,btnRemove,btnCancel;
private String[] num={"Select","11000","33000","40000","45000","60000","Other"};

private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);							//Storing Date.

Connection con=null;
Statement st=null;
PreparedStatement ps=null;

String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());
private JLabel lblstat;
private JButton btnother;

	
	discharge_or(){
	setSize(410,310);
	setLocation(120,120);
	setTitle("Discharge entering");

	/*addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				
				MainMenuFrame sam=new MainMenuFrame();
				sam.setVisible(true);
				dis_charge_report.setDefaultLookAndFeelDecorated(true);
				setVisible(false);}});
	*/
	StaffsInfo.setDefaultLookAndFeelDecorated(true);
	setResizable(false);
	
	
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
		
		lblDate=new JLabel("<html><i>Current Date(dd/mm/yyyy):");
		lblDate.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(lblDate).setBounds(10,20,160,25);

		txtDate=new JTextField(d);
		pane.add(txtDate).setBounds(160,22,90,20);
		txtDate.setEditable(false);
		
		lbltime=new JLabel("Time:");
		lbltime.setForeground(Color.black);
		lbltime.setFont(new Font("Times New Roman",Font.ITALIC,18));
		pane.add(lbltime).setBounds(260,20,120,25);
		txtTime=new JTextField(timeStamp);
		pane.add(txtTime).setBounds(318,22,70,20);
		txtTime.setEditable(false);

		lblProduct = new JLabel("<html><i>Select The Product:");
		pane.add(lblProduct).setBounds(10,50,120,20);
		
		jmbProduct = new JComboBox(name);
		pane.add(jmbProduct).setBounds(160,52,70,20);
		
		
		
		
		
		
		
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
		
		lbledValue=new JLabel("<html><i>Select Depot Value");
		pane.add(lbledValue).setBounds(10,110,140,25);
		txtedValue=new JComboBox<String>(num);
		txtedValue.setFont(new Font("Times New Roman",Font.ITALIC,14));
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
		
		
		
		
		
		
		
		
	lbledv=new JLabel("Enter Depot Value");
		lbledv.setEnabled(false);
		pane.add(lbledv).setBounds(10,138,140,25);
		txtedv=new JTextField();
		txtedv.setEditable(true);
		txtedv.setEnabled(false);
		pane.add(txtedv).setBounds(160,142,120,20);
		
		
		lblstat = new JLabel("<html><b>Click for other<b>>>>");
		lblstat.setForeground(Color.red);
		pane.add(lblstat).setBounds(280,110,300,25);
		lblstat.setFont(new Font("Times New Roman",Font.ITALIC,12));
		
		btnother =new JButton(new ImageIcon("images//sam.GIF"));
		btnother.addMouseListener(this);
		btnother.setBackground(Color.red);
		btnother.setForeground(Color.red);
		pane.add(btnother).setBounds(370,115,38,15);
		btnother.addActionListener(this);
		
		
		
		
		lblaDipping=new JLabel("Total Ltr Discharge");
		
		pane.add(lblaDipping).setBounds(10,168,140,25);
		txttldischarge=new JTextField();
		txttldischarge.setEditable(false);
		pane.add(txttldischarge).setBounds(160,170,120,20);
		

		lbldaDischarge=new JLabel("Dipping after Discharge");
		pane.add(lbldaDischarge).setBounds(10,195,140,25);
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
		
		pane.add(txtdaDischarge).setBounds(160,197,120,20);
		
		
		JLabel st2=new JLabel("Litre");
		st2.setForeground(Color.red);
		pane.add(st2).setBounds(285,195,120,20);
		st2.setFont(new Font("Algerian",Font.ITALIC,12));
		
		
		
		lblShortage=new JLabel("Shortage");
		pane.add(lblShortage).setBounds(10,220,120,25);
		txtShortage=new JTextField();
		pane.add(txtShortage).setBounds(160,222,120,20);
		txtShortage.setEditable(false);
		JLabel st1=new JLabel("Litre");
		st1.setForeground(Color.red);
		pane.add(st1).setBounds(285,223,120,20);
		st1.setFont(new Font("Algerian",Font.ITALIC,12));
		
		btnSave=new JButton("Save");
		pane.add(btnSave).setBounds(0,248,70,20);
		btnSave.addActionListener(this);
		
		btnRemove=new JButton("Remove");
	   pane.add(btnRemove).setBounds(73,248,90,20);
		
		btnRemove.addActionListener(this);
		

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
	
	
	
	public static void main(String[] args) {
		discharge_or s=new discharge_or();
		s.setVisible(true);
		s.setSize(415,310);
		
		s.setLocationRelativeTo(null);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		
		
	}

public void mouseClicked(MouseEvent e) {
	//System.out.printf(" ");
	   
}
public void mousePressed(MouseEvent e) {
	//System.out.printf("B");
	//JOptionPane.showMessageDialog(btnPreview, "thanks");   
	lbledv.setEnabled(true);
	txtedv.setEnabled(true);
}
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	//System.out.printf("");
	   
}
public void mouseEntered(MouseEvent e) {
	
	//System.out.printf("");
	 //  System.out.println("yyyyyy");
	//System.out.printf("Mouse pressed; # of clicks: ");
         //   + e.getClickCount(), e);
	
	// TODO Auto-generated method stub
	/*btnPreview.addMouseListener(new MouseAdapter() {
		@SuppressWarnings("unused")
		public void mouseclicked(MouseEvent e){
			if(e.getButton()==MouseEvent.MOUSE_CLICKED){
				btnPreview.setText("no button clicked");
				
			}
			System.out.println("i love god");
		}
*/	//});
}
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.printf(" ");
	   
}
	
	
	void insertRecord(){
	
		
		
		
			 String sql="INSERT INTO  discharge(date,time,dippingb4,depot,dippingafter,tldischarge,shortage)values('"+txtDate.getText()+"','"+txtTime.getText()+"','"+txtdb4Discharge.getText()+"','"+txtedValue.getSelectedItem()+"','"+txtdaDischarge.getText()+"','"+txtdaDischarge.getText()+"','"+txtShortage.getText()+"')";
		        
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
/*
    	
  	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D://database//rakedomanagement.mdb;DriverID=22;READONLY=true) ","","");
*/
	   
    	 String url = "jdbc:mysql://localhost:3306/rakedomanagement";
			
			con = DriverManager.getConnection(url,"root","");
		
  
    }

    
    catch(Exception ex){
    
   JOptionPane.showMessageDialog(null, "Failed Connection","Error",JOptionPane.ERROR_MESSAGE);
}
		
		
		if(obj==btnSave){
			
		

		
		//JOptionPane.showMessageDialog(btnSave, " the total litre Discharge is " +txtaDipping.getText()+ " LITRE(S) \n and the shortage value is "+txtShortage.getText()+ " LITRE(S)");
	
		insertUpdate();
		//JOptionPane.showMessageDialog(null, "Saved into Database");
		//clearText();
		}
		//}
		

		if(obj==btnRemove){
			
			RemoveInfo s=new RemoveInfo();
			s.setVisible(true);
			s.setLocation(100,100);
			s.setSize(700,500);
			setVisible(false);
	}
		

		if(obj==btnModify){
			
			ModifyInfo s=new ModifyInfo();
			s.setVisible(true);
			s.setLocation(100,100);
			s.setSize(700,500);
			setVisible(false);
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
		
		else{
		}
		}
			
			
	//}


	
	
	
	
	
	public void insertUpdate(){
		
		 try{
			 String url = "jdbc:mysql://localhost:3306/rakedomanagement";
    			
    			con = DriverManager.getConnection(url,"root","");
    		
		    /*	
		  	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			    con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D://database//rakedomanagement.mdb;DriverID=22;READONLY=true) ","","");
*/
			    st=con.createStatement(); 
			
		    }
		   catch(Exception ex){
			    
			   JOptionPane.showMessageDialog(null, "Failed Connection","Error",JOptionPane.ERROR_MESSAGE);
			}
				
		 if(txtdaDischarge.getText().equals("")||txtDate.getText().equals("")||txtTime.getText().equals("")||txtdb4Discharge.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Fill all editable fields");
		 }
				else if(txtedValue.getSelectedItem().equals("Select")||jmbProduct.getSelectedItem().equals("Select")) {
		  JOptionPane.showMessageDialog(null, "<html><i>product & depot value <br> cant be in their default state <b>\"Select\"</b></html");
							
				}
	 else{
		

	 try {
		 
		

double depot =Double.parseDouble((String) txtedValue.getSelectedItem());

double afterDipping=Double.parseDouble(txtdaDischarge.getText());
double b4Discharge=Double.parseDouble(txtdb4Discharge.getText());


txttldischarge.setText(String.format("%.2f", (depot+b4Discharge)));
double total=Double.parseDouble(txttldischarge.getText());
txtShortage.setText(String.format("%.2f", (total)-(afterDipping)));




		 
		String sql=" INSERT INTO `discharge`(`date`, `time`, `product`,`dippingb4`, `depot`, `dippingafter`, `tldischarge`, `shortage`) VALUES ('"+txtDate.getText()+"','"+txtTime.getText()+"','"+jmbProduct.getSelectedItem()+"','"+txtdb4Discharge.getText()+"','"+txtedValue.getSelectedItem()+"','"+txtdaDischarge.getText()+"','"+txttldischarge.getText()+"','"+txtShortage.getText()+"')";
		
	ps=con.prepareStatement(sql);
	
		 ps.executeUpdate();
		 con.close();
		 ps.close();
		 
	 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

			
	
JOptionPane.showMessageDialog(btnSave, "Saved into database");

	      		    clearText();
	      		         
	      		      }                              
	      		      
	      			      
		
	}

	void clearText(){
		txtdb4Discharge.setText("");
		txtedValue.setName("Select");
		txtdaDischarge.setText("");
		txttldischarge.setText("");
		txtShortage.setText("");
		
		
	}
	
	


	class ModifyInfo extends JFrame
	{
		Container c=getContentPane();
		JTable stud;
		JPanel main;
		DefaultTableModel model;
		ModifyDialog mdl;
		String stcode;
		ModifyInfo()
		{
			
			setTitle("Discharge Information");
			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					
					 discharge_or sam=new discharge_or();
						sam.setVisible(true);
					dis_charge_report.setDefaultLookAndFeelDecorated(true);
					setVisible(false);}});
		
			ModifyInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
			JLabel l=new JLabel("<html><font size=5 color=#800080><i>Select Row To Modify");
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
					g.drawImage(img,0,0,700,100,null);
				}
			};
			title.add(l);
			c.add("North",title);

			main=new JPanel();
			main.setLayout(new BorderLayout());
			
			try
			{
				 String url = "jdbc:mysql://localhost:3306/rakedomanagement";
	 			
	 			con = DriverManager.getConnection(url,"root","");
	 			st=con.createStatement();
				ResultSet set=st.executeQuery("select * from discharge");
				int row=0;
				int i=0;
				while(set.next())
				{
					row++;
				}
				DefaultTableModel model=new DefaultTableModel(new String[]{"Date","Time","Product","Diping_b4_Discharge","Depot Value","Dip.After_Discharge","Total LTR Disharge","Shortage"},row);
				
				
				
				table=new JTable(model);
				set=st.executeQuery("select * from discharge");
				while(set.next())
				{
					model.setValueAt(set.getString(2).trim(),i,0);
					model.setValueAt(set.getString(1).trim(),i,1);
					model.setValueAt(set.getString(3).trim(),i,2);
					model.setValueAt(set.getString(4).trim(),i,3);
					model.setValueAt(set.getString(5).trim(),i,4);
					model.setValueAt(set.getString(6).trim(),i,5);
					model.setValueAt(set.getString(7).trim(),i,6);
					model.setValueAt(set.getString(8).trim(),i,7);
					i++;
				}
				table=new JTable(model);
			}
			catch(Exception ex)
			{
			}
			JScrollPane sp=new JScrollPane(table);
			main.add(sp);
			table.addMouseListener(new ModifyStudList());
			table.setSelectionMode(0);
			table.setToolTipText("Select The ROW For Modify");
			table.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			table.setColumnSelectionAllowed(false);
			table.setSelectionMode(1);
			table.setEditingColumn(3);
			table.setFont(new Font("Times New Roman",Font.PLAIN,13));
			table.setForeground(Color.MAGENTA);
			table.setGridColor(new Color(0,128,192));
		  //	table.setBackground(new Color(0,128,192));
	        table.getTableHeader().setReorderingAllowed(false);
	        c.add(main);
		}
			

		
		class ModifyStudList extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				int ro=table.getSelectedRow();
				stcode=(String)table.getValueAt(ro,0);
				mdl=new ModifyDialog(stcode);
				mdl.setVisible(true);
				setVisible(false);
			}
		}
			
		}
		
		
		

			class ModifyDialog extends JDialog implements ActionListener {
			
		JPanel pane=new JPanel();
		JLabel lbldb4Discharge,lbldaDischarge,lbltldischarge,lblDate,lbltime,lblShortage,lblDepot,lblaDipping,lbledValue;
		JTextField txtdb4Discharge,txtdaDischarge,txttldischarge,txtDate,txtTime,txtShortage,txtedValue;
			JTable table;
		String dDate;
		private JComboBox jmbProduct;
			JButton btnUpdate,btnClear,btnCancel;

		private java.util.Date currDate = new java.util.Date ();					//Creating Object.
		private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
		private String d = sdf.format (currDate);							//Storing Date.
		String mstud;
		Connection con=null;
		Statement st=null;
		PreparedStatement ps=null;

		String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());
		ModifyDialog(String s)
					{
			
			mstud=s;
			setSize(410,310);
			setLocation(120,120);
			setTitle("Discharge entering");

			addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						
						discharge_or sam=new discharge_or();
						sam.setVisible(true);
						sam.setLocationRelativeTo(null);
						dis_charge_report.setDefaultLookAndFeelDecorated(true);
						setVisible(false);}});
			
			StaffsInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			
			
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
				
		lblDate=new JLabel("<html><i>Date(dd/mm/yyyy):");
				pane.add(lblDate).setBounds(10,0,120,25);
				//pane.add(lblDate).setBounds(10,50,120,25);
				txtDate=new JTextField();
				txtDate.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				pane.add(txtDate).setBounds(120,2,120,20);
				
				
				lbltime=new JLabel("<html><i>Time(hh :mm : ss):");
				pane.add(lbltime).setBounds(10,30,120,25);
				//pane.add(lbltime).setBounds(10,20,120,25);
				
				txtTime=new JTextField();
				txtTime.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				pane.add(txtTime).setBounds(120,32,120,20);
				
				

				lblProduct=new JLabel("<html><i>Select The Product:");
				pane.add(lblProduct).setBounds(10,55,150,25);
				lblProduct.setFont(new Font("Times New Roman",Font.ITALIC,15));
				//pane.add(lbltime).setBounds(10,20,120,25);
				
				jmbProduct=new JComboBox(name);
				jmbProduct.setFont(new Font("Times New Roman",Font.ITALIC,15));
				jmbProduct.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				pane.add(jmbProduct).setBounds(160,55,120,20);
				
				
				
				
				
				lbldb4Discharge=new JLabel("Dipping b4 Discharge");
				pane.add(lbldb4Discharge).setBounds(10,80,120,25);
				txtdb4Discharge=new JTextField();
				txtdb4Discharge.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
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
				txtedValue.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
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
				txttldischarge=new JTextField();
				txttldischarge.setEditable(false);
				pane.add(txttldischarge).setBounds(160,164,120,20);
				

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
				
				
				
				
				btnUpdate=new JButton("Update");
				pane.add(btnUpdate).setBounds(0,248,90,20);
				btnUpdate.addActionListener(this);
				
				

				btnClear=new JButton("Clear");
				pane.add(btnClear).setBounds(100,248,90,20);
				btnClear.addActionListener(this);
				

				btnCancel=new JButton("Cancel");
				pane.add(btnCancel).setBounds(200,248,75,20);
				btnCancel.addActionListener(this);
			
			getContentPane().add(pane,BorderLayout.CENTER);
			
			 String url = "jdbc:mysql://localhost:3306/rakedomanagement";
 			
 			try {
				con = DriverManager.getConnection(url,"root","");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 		

			try {
				
				
				
		
				st=con.createStatement();
				
				
				ResultSet minfo=st.executeQuery("select * from discharge order by time");
				
				String stco="";
				while(minfo.next())
				{
					stco=minfo.getString(2).trim();
					if(stco.equals(mstud))
						break;}
			
				txtTime.setText(stco);
				txtDate.setText(minfo.getString(1).trim());
				jmbProduct.setSelectedItem(minfo.getString(3));
				txtdb4Discharge.setText(minfo.getString(4));
				txtedValue.setText(minfo.getString(5));
				txtdaDischarge.setText(minfo.getString(6));
				txttldischarge.setText(minfo.getString(7));
				txtShortage.setText(minfo.getString(8));
				
			}
			catch(Exception ed)
			{
				ed.printStackTrace();
				
			}
			} 
				
		


	    public  void UpdateRecords(){
	    if(jmbProduct.getSelectedItem().equals("Select")){
	    	 JOptionPane.showMessageDialog(null,"Invalid Product seleection!");
	    }
	    else{
double depot=Double.parseDouble(txtedValue.getText());
double afterDipping=Double.parseDouble(txtdaDischarge.getText());
double b4Discharge=Double.parseDouble(txtdb4Discharge.getText());
txttldischarge.setText(String.format("%.2f", (depot+b4Discharge)));
double total=Double.parseDouble(txttldischarge.getText());
txtShortage.setText(String.format("%.2f", (total-afterDipping)));


	      String update1 = "Update discharge set date = '" + txtDate.getText() +"' where time = '" + txtTime.getText() + "'" ;
	      String update2 = "Update discharge set product = '" + jmbProduct.getSelectedItem() +"' where time = '" + txtTime.getText() + "'" ;
	      String update3 = "Update discharge set dippingb4 = '" + txtdb4Discharge.getText() +"' where time = '" + txtTime.getText() + "'" ;
	      String update4 = "Update discharge set depot = '" + txtedValue.getText() +"' where time = '" + txtTime.getText() + "'" ;
	      String update5 = "Update discharge set dippingafter = '" + txtdaDischarge.getText() +"' where time = '" + txtTime.getText() + "'" ;
	      String update6= "Update discharge set tldischarge = '" + txttldischarge.getText() +"' where time = '" + txtTime.getText() + "'" ;
	      String update7 = "Update discharge set shortage = '" + txtShortage.getText() +"' where time = '" + txtTime.getText() + "'" ;
	    
	      
	      try{
	          st = con.createStatement();
	          st.executeUpdate(update1);
	          st.executeUpdate(update2);
	          st.executeUpdate(update3);
	          st.executeUpdate(update4);
	          st.executeUpdate(update5);
	          st.executeUpdate(update6);
	          st.executeUpdate(update7); 
	          
	          
	        st.close();
	          con.close();
	      }
	      catch(SQLException ex){
	          System.err.println(ex.getMessage());
	      }
	      JOptionPane.showMessageDialog(null,"Update Finished!");
	      txtTime.setText("");
	      txtdb4Discharge.setText("");
	     txtedValue.setText("");
	     txtdaDischarge.setText("");
	      txttldischarge.setText("");
	     txtShortage.setText("");
	     dispose();
	   
	     discharge_or sam=new discharge_or();
			sam.setVisible(true);
			sam.setSize(415,310);
			
			sam.setLocationRelativeTo(null);
			
			dis_charge_report.setDefaultLookAndFeelDecorated(true);
			setVisible(false);
			
	  }
	    }
		
		void fillEmpty(){
			txtdaDischarge.setText("");
			txtDate.setText("");
			txtTime.setText("");
			txtdb4Discharge.setText("");
			txtedValue.setText("");
			txtShortage.setText("");
			txttldischarge.setText("");}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object obj = e.getSource();
				
				if(obj==btnCancel){
				
					 discharge_or sam=new discharge_or();
					sam.setVisible(true);
					sam.setSize(415,310);
					sam.setLocationRelativeTo(null);
					dis_charge_report.setDefaultLookAndFeelDecorated(true);
					setVisible(false);
					
				}

				if(obj==btnClear){
				
					fillEmpty();
					
				}
				
				
				if(obj==btnUpdate){
					
					UpdateRecords();
					
				}
				
			}
			}
			
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 class RemoveInfo extends JFrame
	{
		 
		 Connection con=null;
		 JTable table;
		Container mic=getContentPane();
		JTable stud;
		JPanel pan;
		DefaultTableModel model;
		RemoveDialog dlg;
		String corname;
		RemoveInfo()
		{

			addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						
						discharge_or sam=new discharge_or();
						sam.setVisible(true);
						sam.setLocationRelativeTo(null);
						
						dis_charge_report.setDefaultLookAndFeelDecorated(true);
						setVisible(false);
						
						
						
					}
				});
			RemoveInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
			JLabel l=new JLabel("<html><font size=5 color=#800080><i>Select Discharge To Remove");
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
					g.drawImage(img,0,0,700,500,null);
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
			{
				
				 String url = "jdbc:mysql://localhost:3306/rakedomanagement";
	    			
	    			con = DriverManager.getConnection(url,"root","");
	    		
				/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D://database//rakedomanagement.mdb;DriverID=22;READONLY=true) ","","");
			*/Statement	st=con.createStatement();
				ResultSet set=st.executeQuery("select * from discharge");
				
				int row=0;
				int i=0;
				while(set.next())
				{
					row++;
				}
				
				model=new DefaultTableModel(new String[]{"Date","Time","Product","DippingB4Dis.","DepotValue","DippingAftre","Total LTR Dis","Shortage",""},row);
					
				table=new JTable(model);
				set=st.executeQuery("select * from discharge");
				
				while(set.next())
				{
					model.setValueAt(set.getString(1).trim(),i,0);
					model.setValueAt(set.getString(2).trim(),i,1);
					model.setValueAt(set.getString(3).trim(),i,2);
					model.setValueAt(set.getString(4).trim(),i,3);
					model.setValueAt(set.getString(5).trim(),i,4);
					model.setValueAt(set.getString(6).trim(),i,5);
					model.setValueAt(set.getString(7).trim(),i,6);
					model.setValueAt(set.getString(8).trim(),i,7);
					i++;
				}
				table=new JTable(model);
			}
			catch(Exception ex)
			{
			}
			JScrollPane sp=new JScrollPane(table);
			pan.add(sp);
			table.setSelectionMode(0);
			table.setFont(new Font("Times New Roman",Font.PLAIN,13));
			table.setForeground(Color.MAGENTA);
			table.setSelectionMode(0);
			table.setGridColor(new Color(0,128,192));
		  	table.setBackground(new Color(0,128,192));
	        table.getTableHeader().setReorderingAllowed(false);
	       
		add(pan);
		
				stud=new JTable(model);
				stud.addMouseListener(new RemoveStudList());
				stud.setToolTipText("Select The Discharge to Remove");
				stud.doLayout();
				stud.setColumnSelectionAllowed(false);
				stud.setSelectionMode(1);
				stud.setEditingColumn(3);
				stud.setFont(new Font("Times New Roman",Font.PLAIN,13));
				stud.setGridColor(new Color(0,128,192));
				stud.setGridColor(Color.pink);
				stud.setRowMargin(3);
				stud.setSelectionBackground(Color.green);
				stud.setSelectionForeground(Color.red);
				stud.setShowHorizontalLines(false);
				stud.setShowVerticalLines(false);
				
				stud.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				JScrollPane spl=new JScrollPane(stud);
				mic.add(spl);
				addWindowListener(new WindowAdapter()
				{
					public void windowActivated(WindowEvent we)
					{
							try
						{

								ResultSet stset=st.executeQuery("select * from discharge where date like '"+txtDate.getText()+"'");
							int row=0;
							int i=0;
							while(stset.next())
							{
								row++;
							}
							 model=new DefaultTableModel(new String[]{"Date","Time","Diping_b4_Dipping","Depot Value","Dip.b4_Dipping","Total LTR Disharge","Shortage"},row);
							stset=ps.executeQuery();
							
							while(stset.next())
							{
								
								model.setValueAt(stset.getString(1).trim(),i,0);
								model.setValueAt(stset.getString(2).trim(),i,1);
								model.setValueAt(stset.getString(3).trim(),i,2);
								model.setValueAt(stset.getString(4).trim(),i,3);
								model.setValueAt(stset.getString(5).trim(),i,4);
								model.setValueAt(stset.getString(6).trim(),i,2);
								model.setValueAt(stset.getString(7).trim(),i,6);
								
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
		
		
		/* public void cmdDelete_actionPerformed()
		  {
		  	int DResult = JOptionPane.showConfirmDialog (null,"Are you sure you want to delete record?");
		  	
		  	if (DResult == JOptionPane.YES_OPTION)
		  	{
		  	
				model.Edit("DELETE FROM ONE WHERE UniqueNr Like '" + Unique + "'");
				panBottom.setVisible (false);	
					try
		  			{
		  	
		  					model.setQuery("Select * From One");
		  		
		  	
		  			}
		  			catch(Exception err) 
		  			{
		  					err.printStackTrace ();
		  		
		  			}				
			}			
		  }
		*/
		
		
		
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	 class RemoveStudList extends MouseAdapter
		{
			private String unique;

			public void mouseClicked(MouseEvent e)
			{
				int ro=stud.getSelectedRow();
				String stcode=(String)stud.getValueAt(ro,0);
				dlg=new RemoveDialog(stcode);
				unique = String.valueOf(model.getValueAt(ro,1));
			  	
				dlg.setVisible(true);


			}
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	 class RemoveDialog extends JDialog
		{
		private String unique;
			JButton rok;
			JButton rcan;
			JLabel ls;
			String rmstud;
			JPanel bp;
			RemoveDialog(String s)
			{
				super(RemoveInfo.this,"Remove Discharge",true);
				rmstud=s;
				setSize(250,150);
				setLocation(400,280);
				 bp=new JPanel();
				bp.setBackground(new Color(255,197,68));
				rok=new JButton("  Ok  ");
				rcan=new JButton("Cancel");
				bp.add(rok);
				bp.add(rcan);
				add(bp,"South");
				JPanel lp=new JPanel();
				lp.add(new JLabel("<html><font size=4 color=#800080>Do You Want To Remove <br>    Discharge Information </font></html>"));
				add(lp);
				RemoveStud rs=new RemoveStud();
				rok.addActionListener(rs);
				rcan.addActionListener(rs);
				}
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			 class RemoveStud implements ActionListener
			{
				String dur;
				public void actionPerformed(ActionEvent ev)
				{
					String cm=ev.getActionCommand();
					
					if(cm.equals("Cancel")){
						dispose();
						//System.out.println("samuel");
					}
					if(cm.equals("  Ok  "))
					{
						System.out.println("yyyyyyyyyyyyyyy");
						/*//if (DResult == JOptionPane.YES_OPTION)
					  //	{
					  	
							model.Edit("DELETE FROM ONE WHERE UniqueNr Like '" + unique + "'");
							//panBottom.setVisible (false);	
								try
					  			{
					  	
					  					model.setQuery("Select * From One");
					  		
					  	
					  			}
					  			catch(Exception err) 
					  			{
					  					err.printStackTrace ();
					  		
					  			}				
						}			
						*/
						
						try{
							String cour = null;
							
							System.out.println("yyyyyyyyyyyyyyy");
							
							
									//PreparedStatement pts2=con.prepareStatement("DELETE  FROM discharge WHERE date= ?");
							PreparedStatement pts2=con.prepareStatement("DELETE FROM discharge WHERE date Like '" + cour + "'");
							
							//model.setQuery("Select * From discharge");
							model=(DefaultTableModel) st.executeQuery("select * from discharge");
							
							//pts2.setString(1,rmstud);
										//unique = String.valueOf(model.getValueAt(Row,2));
									  	
									//	pts2.execute();
										
										
										
										//pts2.close();

									//	Icon error=new ImageIcon("images//error.png");
										
										//JOptionPane.showMessageDialog(null,"<html><font size=4 color=red>Discharge Report</font></html> \n\t\t Deleted","Deleted",JOptionPane.ERROR_MESSAGE,error);
										
										//bp.setVisible(false);
										//setVisible(false);
										
										
						        	
						            
						        }catch(Exception ex){
						        	 System.err.println(ex.getMessage());
						        }
								//dlg.dispose();
					}
				
					/*else
					{
						//dlg.dispose();
					}*/
					//dlg.dispose();
				}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
				private void clearText() {
		// TODO Auto-generated method stub
		txtdaDischarge.setText("");
		txtedValue.setName("");
		txtShortage.setText("");
		txtdaDischarge.setText("");
		txtdb4Discharge.setText("");
		
	}
				

	}
		}
	}
}