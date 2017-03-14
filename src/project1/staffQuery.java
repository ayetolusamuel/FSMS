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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


import javax.swing.*;


public class staffQuery extends JFrame implements ActionListener{
	private JLabel lblDate,lblTime,lblsId,lblfName,lbliBy,lblDes,lblRemark;
	private JTextField txtDate,txtTime,txtsId,txtFName,txtiBy;
	private JTextArea txtRemark;
	private JPanel pane;
	private String[] des={"SELECT","ADMIN","SUPERVISOR","MD","CEO"};
private	JComboBox<String> name,cmbsID;

private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);
String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());


	private JButton btnSave,btnClear,btnExit,btnPreview,btnPrint,btnRemove;
	private Connection cn;
	private Statement st;
	private ResultSet rs;
	public staffQuery() {
		StaffsInfo.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setTitle("Staff Query");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
		
		/*addWindowListener(new WindowAdapter()
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
				g.drawImage(img,0,0,570,390,null);
			}
		};
		
		
		
		
		
		
		
		pane.setLayout(null);
		
		
		lblDate = new JLabel("<html><i>Date:");
		pane.add(lblDate).setBounds(10,10,100,25);
		txtDate =new JTextField(d);
		txtDate.setEditable(false);
		pane.add(txtDate).setBounds(80,12,100,20);
		

		lblTime = new JLabel("<html><i>Time:");
		pane.add(lblTime).setBounds(10,40,100,25);
		txtTime =new JTextField(timeStamp);
		txtTime.setEditable(false);
		pane.add(txtTime).setBounds(80,42,100,20);
		

		lblsId = new JLabel("<html><i>Staff ID:");
		pane.add(lblsId).setBounds(10,70,100,25);
		txtsId =new JTextField();
		cmbsID = new JComboBox();
		pane.add(cmbsID).setBounds(80,72,100,20);
		

		lblfName = new JLabel("<html><i>Full Name:");
		pane.add(lblfName).setBounds(10,100,100,25);
		txtFName =new JTextField();
		txtFName.setToolTipText("Staff Full Name");
		pane.add(txtFName).setBounds(80,102,350,20);
		
		
		lbliBy = new JLabel("<html><i>Input By:");
		pane.add(lbliBy).setBounds(10,160,100,25);
		txtiBy =new JTextField();
		txtiBy.setToolTipText("Inputer Full Name");
		pane.add(txtiBy).setBounds(80,162,350,20);
		
		lblDes = new JLabel("<html><i>Designation:");
		pane.add(lblDes).setBounds(6,130,90,25);
		
		
		name=new JComboBox<>(des);
		name.setFont(new Font("Times New Roman",Font.ITALIC,12));
		name.setForeground(Color.red);
		pane.add(name).setBounds(80,132,100,20);
		
		lblRemark = new JLabel("<html><i><b><br>Query:");
		name.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
		
		pane.add(lblRemark).setBounds(10,195,100,35);
		txtRemark =new JTextArea(2,20);
		txtRemark.setFont(new Font("Times New Roman",Font.ITALIC,14));
		txtRemark.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtRemark.setToolTipText("Enter Staff Report/Query");
		
		txtRemark.setWrapStyleWord(true);
		txtRemark.setLineWrap(true);
		
		JScrollPane addfield=new JScrollPane(txtRemark);
		pane.add(addfield).setBounds(80,192,460,100);
		
		btnSave =new JButton("Save");
		pane.add(btnSave).setBounds(10,300,80,20);
		btnSave.addActionListener(this);
		btnPreview =new JButton("Preview");
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
		pane.add(btnExit).setBounds(460,300,80,20);
		btnExit.addActionListener(this);
		
		
		
		
		getContentPane().add(pane,BorderLayout.CENTER);
	
	
	
	try{
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
rs = st.executeQuery("select * from staff ");
	
while (rs.next()) {
	
	cmbsID.addItem(rs.getString("staffid"));
	//txtifName.setText(rs.getString(txtifName.getText().equalsIgnoreCase(cmbtiID.setSelectedItem(getName()))));
	cmbsID.setFont(new Font("Times New Roman",Font.ITALIC,13));
	
}

}
	

catch(Exception e)
{
	System.out.println(e.toString());

}
		 		

}
	

	
public static void main(String[] args) {
	staffQuery sam =new staffQuery();
	sam.setVisible(true);
	sam.setSize(570,390);
	sam.setLocationRelativeTo(null);
	
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object obj = e.getSource();
	
	if(obj==btnExit){
		dispose();
		
	}
	
	
	
}}
