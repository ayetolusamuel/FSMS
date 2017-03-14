/*import java.awt.BorderLayout;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class dia extends JDialog implements ActionListener {
	
JPanel pane=new JPanel();
JLabel lbldb4Discharge,lbldaDischarge,lbltldischarge,lblDate,lbltime,lblShortage,lblDepot,lblaDipping,lbledValue;
JTextField txtdb4Discharge,txtdaDischarge,txttldischarge,txtDate,txtTime,txtShortage,txtedValue;
	JTable table;
String dDate;
	JButton btnUpdate,btnClear,btnCancel;

private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);							//Storing Date.

Connection con=null;
Statement st=null;
PreparedStatement ps=null;

String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());

	
	dia(){
	//super(" Create Discharge Record" ,false,true,false,true);
	setSize(410,310);
	setLocation(120,120);
	setTitle("Discharge entering");

	addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				
				MainMenuFrame sam=new MainMenuFrame();
				sam.setVisible(true);
				dis_charge_report.setDefaultLookAndFeelDecorated(true);
				setVisible(false);}});
	
	StaffInfo.setDefaultLookAndFeelDecorated(true);
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
		pane.add(lblDate).setBounds(10,20,120,25);

		txtDate=new JTextField(d);
		txtDate.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		pane.add(txtDate).setBounds(120,22,120,20);
		
		
		lbltime=new JLabel("<html><i>Time(hh :mm : ss):");
		pane.add(lbltime).setBounds(10,50,120,25);
		txtTime=new JTextField(timeStamp);
		txtTime.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		pane.add(txtTime).setBounds(120,52,120,20);
		
		
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
	}
	public static void main(String[] args) {
		dia s=new dia();
		s.setVisible(true);
		s.setSize(340,310);
		s.setLocationRelativeTo(null);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}}*/