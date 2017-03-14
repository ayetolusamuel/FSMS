package project1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class admindailyrecord extends JFrame implements ActionListener,MouseListener{
	private JLabel lblDate,lblTime,lbliID,lblifName,lblExp,lblOther;
	private JTextField txtDate,txtTime,txttiID,txtifName,txtcMetre,txtoMetre,txtlOver;
	
	private JPanel pane;
	Connection cn=null;
	Container con;
	PreparedStatement ps=null;
	ResultSet rs=null;
	java.sql.Statement st=null;
	
	private String[] exp={" ","DPR ","Land Use Charge","Staffs Salaries/allowance","Taxes","Fire Services","Weighing & Measure","Maintenance","Forces","PHCN","Fire Services Charge","Others"};
private	JComboBox<String> cmbProduct;
String[] name={"Select","PMS","AGO","DPK"};

private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);
String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());


	private JButton btnSave,btnClear,btnExit,btnPreview,btnPrint,btnRemove,btnother;
	public admindailyrecord() {
		StaffsInfo.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setTitle("Daily Dipping Record<DDR>");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
		
	/*	addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				
				StaffsInfo sam=new StaffsInfo();
				sam.setVisible(true);
				dis_charge_report.setDefaultLookAndFeelDecorated(true);
				setVisible(false);
				
				
				
			}
		});
		*/
		
		pane=new JPanel()
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
				g.drawImage(img,0,0,570,650,null);
			}
		};
		
		
		
		
		
		
		
		pane.setLayout(null);
		
		
		lblDate = new JLabel("<html><i>Date:");
		lblDate.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(lblDate).setBounds(10,10,100,25);
		txtDate =new JTextField(d);
		txtDate.setEditable(false);
		txtDate.setFont(new Font("Times New Roman",Font.ITALIC,12));
		pane.add(txtDate).setBounds(80,12,100,20);
		

		lblTime = new JLabel("<html><i>Time:");
		lblTime.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(lblTime).setBounds(10,40,100,25);
		txtTime =new JTextField(timeStamp);
		txtTime.setFont(new Font("Times New Roman",Font.ITALIC,12));
		txtTime.setEditable(false);
		pane.add(txtTime).setBounds(80,42,100,20);
		

		lbliID = new JLabel("<html><i>Admin ID:");
		pane.add(lbliID).setBounds(10,70,100,25);
		lbliID.setFont(new Font("Times New Roman",Font.ITALIC,12));
		txttiID =new JTextField();
		
		
		
		pane.add(txttiID).setBounds(100,72,100,20);
		

		lblifName = new JLabel("<html><i>Full Name:");
		lblifName.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(lblifName).setBounds(10,100,100,25);
	
		txtifName =new JTextField();
		pane.add(txtifName).setBounds(100,102,350,20);
		
		lblifName = new JLabel("<html><i>Product:");
		lblifName.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(lblifName).setBounds(10,130,100,25);
		cmbProduct = new JComboBox(name);
		pane.add(cmbProduct).setBounds(100,132,120,20);
		

		
		lblExp = new JLabel("<html><i>Opening Dipping:");
		pane.add(lblExp).setBounds(10,160,100,25);
		lblExp.setFont(new Font("Times New Roman",Font.ITALIC,13));
		
		
		txtoMetre = new JTextField();
		txtoMetre.setEditable(true);
		txtoMetre.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(txtoMetre).setBounds(110,162,200,20);
		
		lblExp = new JLabel("<html><i>Closing Dipping:");
		pane.add(lblExp).setBounds(10,190,100,25);
		lblExp.setFont(new Font("Times New Roman",Font.ITALIC,13));
		txtcMetre = new JTextField();
		txtcMetre.setEditable(true);
		txtcMetre.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(txtcMetre).setBounds(110,192,200,20);
		
		
		lblExp = new JLabel("<html><i>Total Ltr Sold:");
		pane.add(lblExp).setBounds(10,220,100,25);
		lblExp.setFont(new Font("Times New Roman",Font.ITALIC,13));
		txtlOver = new JTextField();
		txtlOver.setEditable(false);
		txtlOver.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(txtlOver).setBounds(110,222,200,20);
		
		
		
		lblExp = new JLabel("<html><i>Amount Litre Sold:");
		pane.add(lblExp).setBounds(0,250,130,25);
		lblExp.setFont(new Font("Times New Roman",Font.ITALIC,13));
		txtlOver = new JTextField();
		txtlOver.setEditable(false);
		txtlOver.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(txtlOver).setBounds(110,252,200,20);
		
		
		
		
		
		
		
		btnSave =new JButton("Save");
		btnSave.setEnabled(false);
		pane.add(btnSave).setBounds(10,300,80,20);
		btnSave.addActionListener(this);
		btnPreview =new JButton("");
		btnPreview.setText("<html><font color=black><i>Preview</font></html>");
		pane.add(btnPreview).setBounds(100,300,80,20);
		btnPreview.addActionListener(this);
		btnPrint =new JButton("Print");
		pane.add(btnPrint).setBounds(190,300,80,20);
		btnPrint.addActionListener(this);
		btnRemove =new JButton("Remove");
		pane.add(btnRemove).setBounds(280,300,80,20);
		btnRemove.addActionListener(this);
		btnClear =new JButton("Clear");
		pane.add(btnClear).setBounds(370,300,80,20);
		btnClear.addActionListener(this);
		btnExit =new JButton("Exit");
		btnExit.addActionListener(this);
		pane.add(btnExit).setBounds(460,300,80,20);
		

	
		
		getContentPane().add(pane,BorderLayout.CENTER);
		
		
	try{
			 /*
			     	
			   	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 	    con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D://database//rakedomanagement.mdb;DriverID=22;READONLY=true) ","","");
			 */
		//Class.forName("com.jdbc.odbc.JdbcOdbcDriver").newInstance();
			     	 String url = "jdbc:mysql://localhost:3306/rakedomanagement";
			 			
			 			cn =  DriverManager.getConnection(url,"root","");
			 			 st=cn.createStatement();
			    }

			     
			     catch(Exception ex){
			     
			    JOptionPane.showMessageDialog(null, "Failed Connection","Error",JOptionPane.ERROR_MESSAGE);}
	fill_fields();
	}

public void fill_fields(){
	try

{
		
     st=cn.createStatement();
     
    /* String SQL = "Select " +
				"staff" +
			"From " +
				"[Type] " +
			"Where " +
				"fname = '" + txtifName.getText() + "' ";
     
     String query= "Select * from staff"+
     "where "+
    		 "staff ='"+cmbtiID.getSelectedIndex()+"'";
     cmbtiID.addItem(rs.getString("staffid"));
     */
	//rs = st.executeQuery(query);
	
	
	rs = st.executeQuery("select * from staff "+"");
	
	
	
	while (rs.next()) {
		
		
		
		
		//cmbtiID.addItem(rs.getString("staffid"));
		//cmbifName.addItem( rs.getString( "fname" ) );
		
		//txtifName.setText(rs.getString(txtifName.getText()));
		//cmbtiID.setFont(new Font("Times New Roman",Font.ITALIC,13));
		
    }
	
}
		
	
	catch(Exception e)
	{
		System.out.println(e.toString());
	
	}
			 		
	
	}
	
public static void main(String[] args) {
	admindailyrecord sam =new admindailyrecord();
	sam.setVisible(true);
	sam.setSize(570,390);
	sam.setResizable(true);
	sam.setLocationRelativeTo(null);
	//sam.add(c);
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object obj = e.getSource();
	
	if(obj==btnExit){
		dispose();
		
	}else if(obj==btnPrint){
		System.out.println("printing in point");
		
	}
	
	
	
	
}
@Override
public void mouseClicked(MouseEvent e) {
	System.out.printf(" ");
	   
}
@Override
public void mousePressed(MouseEvent e) {
	//System.out.printf("B");
	//JOptionPane.showMessageDialog(btnPreview, "thanks");   
	lblOther.setEnabled(true);
	//txtOther.setEnabled(true);
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.printf("");
	   
}
@Override
public void mouseEntered(MouseEvent e) {
	
	System.out.printf("");
	   
	
	
	double dtoLitre=Double.parseDouble(txtoMetre.getText());
	double dtcLitre=Double.parseDouble(txtcMetre.getText());
	 txtlOver.setText(String.format("%.2f", ((dtcLitre)-(dtoLitre))));
	
	 
	 
	 //double dtLitre =  Double.parseDouble(txtppLitre.getText());
	 //txtSale.setText(String.format("%.2f", (((dtcLitre-dtoLitre)*(dtLitre)))));

	
	
	
	
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
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.printf(" ");
	   
}}
