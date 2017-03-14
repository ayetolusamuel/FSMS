package project1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


import javax.swing.*;



public class print extends JFrame implements ActionListener,MouseListener{
	private JLabel lblDate,lblTime,lbliID,lblifName,lblExp,lblOther,lblstat;
	private JTextField txtDate,txtTime,txtiID,txtifName,txtExp1,txtExp2,txtExp3,txtExp4,txtExp5;
	private JTextArea txtRemark,txtOther;
	private JPanel pane;
	Connection cn=null;
	Container con;
	PreparedStatement ps=null;
	ResultSet rs=null;
	java.sql.Statement st=null;
	private String[] exp={"SELECT","Land Use Charge","Staffs Salaries/allowance","Forces","PHCN"," "};
private	JComboBox<String> expendicture,cmbtiID;

private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);
String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());


	private JButton btnSave,btnClear,btnExit,btnPreview,btnPrint,btnRemove,btnother;
	public print() {
		StaffsInfo.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setTitle("Expenditure");
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
				g.drawImage(img,0,0,800,500,null);
			}
		};
		
		
		
		
		
		
		
		pane.setLayout(null);
		
		/*
		lblDate = new JLabel("<html><i>Date:");
		pane.add(lblDate).setBounds(10,10,100,25);
		txtDate =new JTextField(d);
		txtDate.setEditable(false);
		txtDate.setFont(new Font("Times New Roman",Font.ITALIC,12));
		pane.add(txtDate).setBounds(80,12,100,20);
		

		lblTime = new JLabel("<html><i>Time:");
		
		pane.add(lblTime).setBounds(10,40,100,25);
		txtTime =new JTextField(timeStamp);
		txtTime.setFont(new Font("Times New Roman",Font.ITALIC,12));
		txtTime.setEditable(false);
		pane.add(txtTime).setBounds(80,42,100,20);
		

		lbliID = new JLabel("<html><i>Admin ID:");
		pane.add(lbliID).setBounds(10,70,100,25);
		lbliID.setFont(new Font("Times New Roman",Font.ITALIC,12));
		cmbtiID =new JComboBox<String>();
		pane.add(cmbtiID).setBounds(100,72,100,20);
		

		lblifName = new JLabel("<html><i>Full Name:");
		lblifName.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(lblifName).setBounds(10,100,100,25);
		txtifName =new JTextField();
		txtifName.setToolTipText("Full Name");
		pane.add(txtifName).setBounds(100,102,350,20);
		
		
		lblExp = new JLabel("<html><i>Expendicture:");
		pane.add(lblExp).setBounds(10,130,100,25);
		lblExp.setFont(new Font("Times New Roman",Font.ITALIC,13));
		
		
		expendicture = new JComboBox<String>(exp);
		expendicture.setEditable(false);
		expendicture.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(expendicture).setBounds(100,132,200,20);
		
		txtExp1 =new JTextField();
		txtExp1.setFont(new Font("Times New Roman",Font.ITALIC,12));
		pane.add(txtExp1).setBounds(330,132,100,20);
		
		expendicture = new JComboBox<String>(exp);
		expendicture.setEditable(false);
		expendicture.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(expendicture).setBounds(100,162,200,20);
		txtExp2 =new JTextField();
		txtExp2.setFont(new Font("Times New Roman",Font.ITALIC,12));
		pane.add(txtExp2).setBounds(330,162,100,20);
		
		
		
		
		
		expendicture = new JComboBox<String>(exp);
		expendicture.setEditable(false);
		expendicture.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(expendicture).setBounds(100,192,200,20);
		
		txtExp3 =new JTextField();
		txtExp3.setFont(new Font("Times New Roman",Font.ITALIC,12));
		pane.add(txtExp3).setBounds(330,192,100,20);
		
		
		
		expendicture = new JComboBox<String>(exp);
		expendicture.setEditable(false);
		expendicture.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(expendicture).setBounds(100,222,200,20);
		
		txtExp4 =new JTextField();
		txtExp4.setFont(new Font("Times New Roman",Font.ITALIC,12));
		pane.add(txtExp4).setBounds(330,222,100,20);
		
		
		
		expendicture = new JComboBox<String>(exp);
		expendicture.setEditable(false);
		expendicture.setFont(new Font("Times New Roman",Font.ITALIC,13));
		pane.add(expendicture).setBounds(100,252,200,20);
		txtExp5 =new JTextField();
		txtExp5.setFont(new Font("Times New Roman",Font.ITALIC,12));
		pane.add(txtExp5).setBounds(330,252,100,20);
		
		
		
		lblstat = new JLabel("<html><b>Click the button for others<b><i>=====>");
		lblstat.setForeground(Color.red);
		pane.add(lblstat).setBounds(40,295,300,25);
		lblstat.setFont(new Font("Times New Roman",Font.ITALIC,18));
		
		btnother =new JButton(new ImageIcon("images//sam.GIF"));
		
		btnother.setBackground(Color.red);
		btnother.setForeground(Color.red);
		pane.add(btnother).setBounds(300,300,80,20);
		btnother.addActionListener(this);
		*/
		
		
		txtOther = new JTextArea(2,20);
		//txtOther.setEnabled(false);
		//txtOther.setText("Null");
		txtOther.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtOther.setFont(new Font("Times New Roman",Font.ITALIC,14));
		pane.add(txtOther).setBounds(0,10,700,400);
		txtOther.setWrapStyleWord(true);
		txtOther.setLineWrap(true);
		
		txtOther.setText ("Type Info : " +txtOther.getText()/* (String)  AllTypeInfo.getSelectedItem()*/ + "\t" + " \t" + "\n" +
				"\n");
	
		
		String Text = "";
		if ( ! txtOther.isVisible() ) {
			txtOther.setText ("Type Info : " +txtOther.getText() /*(String)  AllTypeInfo.getSelectedItem()*/  +"\t" + " \t" + "\n" +
						"\n");
			
			//txtOther.setText(t);
		}
		Text = Text + "Product ID" + " \t" + "Product Name" + " \t\t\t\t\t" + "Quantity" + " \t" + "Unit Price" +"\n";

	//	txtOther.add(Text());
	/*	if(expendicture.equals("Others")){
			txtOther.setEnabled(true);
			lblOther.setEnabled(true);
			
		}else if(expendicture.equals("SELECT")){
			System.out.println("invalid selection");
			
		}
		*/
		/*
		lblRemark = new JLabel("<html><i>Report<b>/</b><br>Query:");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String pilote = "com.mysql.jdbc.Driver";
jComboBoxType.addItemListener(new ItemState());
jComboBoxMenaces.addItemListener(new ItemState());
try {
    Class.forName(pilote); 
    Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root"," "); 

    Statement instruction = connexion.createStatement(); 
    String a=jTextFieldNom.getText();


    String SQL = "select description from table where nomcol="+a+";"; 
    ResultSet rs = instruction.executeQuery(SQL);
    instruction = connexion.createStatement();


    int rowsEffected = instruction.executeUpdate(SQL);
    jTextArea1.append(rs.getString("description"));                                     
}
		pane.add(lblRemark).setBounds(10,195,100,35);
		txtRemark =new JTextArea(2,20);
		txtRemark.setFont(new Font("Times New Roman",Font.ITALIC,14));
		txtRemark.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtRemark.setToolTipText("Enter Staff Report/Query");
		
		txtRemark.setWrapStyleWord(true);
		txtRemark.setLineWrap(true);*/
		
		/*JScrollPane addfield=new JScrollPane(txtRemark);
		pane.add(addfield).setBounds(80,192,460,100);
		*/
		btnSave =new JButton("Save");
		btnSave.setEnabled(false);
		pane.add(btnSave).setBounds(10,450,80,20);
		btnSave.addActionListener(this);
		btnPreview =new JButton("");
		btnPreview.setText("<html><font color=black><i>Preview</font></html>");
		pane.add(btnPreview).setBounds(100,450,80,20);
		btnPreview.addActionListener(this);
		btnPrint =new JButton("Print");
		pane.add(btnPrint).setBounds(190,450,80,20);
		btnPrint.addActionListener(this);
		btnRemove =new JButton("Remove");
		pane.add(btnRemove).setBounds(280,450,80,20);
		btnRemove.addActionListener(this);
		btnClear =new JButton("Clear");
		pane.add(btnClear).setBounds(370,450,80,20);
		btnClear.addActionListener(this);
		btnExit =new JButton("Exit");
		btnExit.addActionListener(this);
		pane.add(btnExit).setBounds(460,450,80,20);
		
		//btnother.addMouseListener(this);
	
		
		con=getContentPane();
	    
		con.add( new textExpenditure(),BorderLayout.NORTH);
		
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
			     
			  //  JOptionPane.showMessageDialog(null, "Failed Connection","Error",JOptionPane.ERROR_MESSAGE);
			    	 }
	fill_fields();
	}

public void fill_fields(){
	try

{
		
     st=cn.createStatement();
	rs = st.executeQuery("select * from staff ");
		
	while (rs.next()) {
		
		cmbtiID.addItem(rs.getString("staffid"));
		//txtifName.setText(rs.getString(txtifName.getText().equalsIgnoreCase(cmbtiID.setSelectedItem(getName()))));
		cmbtiID.setFont(new Font("Times New Roman",Font.ITALIC,13));
		
    }
	
}
		
	
	catch(Exception e)
	{
		System.out.println(e.toString());
	
	}
			 		
	
	}
	
public static void main(String[] args) {
	print sam =new print();
	sam.setVisible(true);
	sam.setSize(800,540);
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
	txtOther.setEnabled(true);
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.printf("");
	   
}
@Override
public void mouseEntered(MouseEvent e) {
	
	System.out.printf("");
	   
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
