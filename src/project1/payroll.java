package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("serial")
public class payroll extends JFrame implements ActionListener, FocusListener {
	CheckboxGroup cbmf;
	Checkbox cbm, cbf;
	ResultSet rs = null;
	Statement stmt = null;
	Connection con = null;
	String user = "ayets";
	String pass = "setonji04";
	private JPanel pAdmin = new JPanel();
	private JLabel lblDate, lblTime, lbloDipping, lblcDipping, lblGender,
			lbldDifferent, lblSale, lblppLitre, lblrtTank, lbltdDifferent,
			lbltGain, lbltgSale, lblExpense;
	JLabel lbl1, lbldd;

	String [] gend={"Select","Male","Female"};
	
	
	private JTextField txtDate, txtTime, txtstaffID, txtfName, txtemail,
			txtpNumber, txtPosition, txtCert, txtgName, txtgPhone, txtAmount,
			txtBonus;
	TextArea txtOthers;
	PreparedStatement ps = null;
	String[] month1 = { "MONTH", "January", "February", "March", "April",
			"May", "June", "July", "August", "September", "October",
			"November", "December", };
	String[] yrs1 = { "YEAR", "2005", "2006", "2007", "2008", "2009", "2010",
			"2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018",
			"2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026",
			"2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034",
			"2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042",
			"2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050",
			"2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058",
			"2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066",
			"2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074",
			"2075", "2076", "2077", "2078", "2079", "2080" };

	JComboBox cmbMonth,cmbYear,cmbGender;
	

	JButton btnSave, btnRemove, btnPreview, btnExit, btnModify, btnNew,
			btnSearch;

	private java.util.Date currDate = new java.util.Date(); // Creating Object.
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",
			Locale.getDefault()); // Changing Format.
	private String d = sdf.format(currDate); // Storing Date.

	String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar
			.getInstance().getTime());

	// Statement for Getting the Required Table.
	private long id = 0; // To Hold the BookId.

	// Constructor of Class.

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public payroll() {
		setTitle("Staff Payroll System");
		setSize(397, 510);
		setLocation(100, 60);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				MainMenuFrame sam = new MainMenuFrame();
				sam.setVisible(true);
				dis_charge_report.setDefaultLookAndFeelDecorated(true);
				setVisible(false);

			}
		});
		pAdmin.setLayout(null);

		lblDate = new JLabel("<html><i><b>Date :</i></b></html>");
		lblDate.setForeground(Color.white);

		pAdmin.add(lblDate).setBounds(10, -40, 70, 120);

		txtDate = new JTextField(d);
		txtDate.setFont(new Font("Algerian", Font.ITALIC, 16));
		txtDate.setEditable(false);
		pAdmin.add(txtDate).setBounds(90, 12, 130, 20);

		lblTime = new JLabel("<html><i><b>Time :</i></b></html>");
		lblTime.setForeground(Color.white);
		pAdmin.add(lblTime).setBounds(10, -10, 70, 120);
		txtTime = new JTextField(timeStamp);
		txtTime.setEditable(false);
		txtTime.setFont(new Font("Algerian", Font.ITALIC, 14));
		pAdmin.add(txtTime).setBounds(90, 40, 130, 20);

		lblGender = new JLabel("<html><b><i>Gender :</i></b></html>");
		lblGender.setFont(new Font("Algerian", Font.ITALIC, 14));
		lblGender.setForeground(Color.white);
		pAdmin.add(lblGender).setBounds(250, 30, 100, 20);
		
	cmbGender =new JComboBox(gend);
	cmbGender.setFont(new Font("Algerian", Font.ITALIC, 14));
	pAdmin.add(cmbGender).setBounds(328, 37, 100, 20);
		
/*
		cbmf = new CheckboxGroup();
		cbm = new Checkbox("Male", cbmf, true);
		cbf = new Checkbox("Female", cbmf, false);
		cbm.setBounds(328, 37, 50, 15);
		add(cbm);
		cbf.setBounds(390, 37, 80, 15);
		add(cbf);*/

		btnSearch = new JButton("Search");
		pAdmin.add(btnSearch).setBounds(230, 66, 80, 25);
		btnSearch.addActionListener(this);

		lbloDipping = new JLabel("<html><i><b>staff ID:</i></b></html>");
		lbloDipping.setForeground(Color.white);
		pAdmin.add(lbloDipping).setBounds(0, 16, 180, 120);
		txtstaffID = new JTextField();

		pAdmin.add(txtstaffID).setBounds(95, 68, 100, 20);

		lblcDipping = new JLabel("<html><i><b>Staff full Name :</i></b></html>");
		lblcDipping.setForeground(Color.white);
		pAdmin.add(lblcDipping).setBounds(0, 45, 180, 120);
		txtfName = new JTextField();
		txtfName.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!((Character.isAlphabetic(c)) || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE))) {

					getToolkit().beep();
					ke.consume();
				}

			}
		});
		pAdmin.add(txtfName).setBounds(95, 96, 380, 20);

		lbldDifferent = new JLabel("<html><i><b>Email :</i></b></html>");
		lbldDifferent.setForeground(Color.white);
		pAdmin.add(lbldDifferent).setBounds(0, 75, 180, 120);
		txtemail = new JTextField();
		txtemail.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!((Character.isAlphabetic(c)) || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE))) {
					if (!(c == '0' || c == '1' || c == '2' || c == '3'
							|| c == '4' || c == '5' || c == '6' || c == '7'
							|| c == '8' || c == '9' || c == '_' || c == '@'
							|| c == '-' || c == '.')) {

						getToolkit().beep();
						ke.consume();
					}
				}

			}
		});
		pAdmin.add(txtemail).setBounds(95, 125, 230, 20);

		lblppLitre = new JLabel("<html><i><b>Phone Number :</i></b></html>");
		lblppLitre.setForeground(Color.white);
		lblppLitre.setFont(new Font("Algerian", Font.ITALIC, 14));
		pAdmin.add(lblppLitre).setBounds(15, 106, 180, 120);
		txtpNumber = new JTextField();

		txtpNumber.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
						|| c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
					getToolkit().beep();
					ke.consume();

				}
			}
		});
		pAdmin.add(txtpNumber).setBounds(159, 159, 230, 20);

		lblSale = new JLabel("<html><i><b>Position :</i></b></html>");
		lblSale.setForeground(Color.white);
		lblSale.setFont(new Font("Algerian", Font.ITALIC, 14));
		pAdmin.add(lblSale).setBounds(15, 136, 180, 120);
		txtPosition = new JTextField();
		// txtSale.setEditable(false);
		pAdmin.add(txtPosition).setBounds(159, 189, 230, 20);

		lblrtTank = new JLabel("<html><i><b>Certification :</i></b></html>");
		lblrtTank.setForeground(Color.white);
		lblrtTank.setFont(new Font("Algerian", Font.ITALIC, 14));
		pAdmin.add(lblrtTank).setBounds(15, 166, 180, 120);
		txtCert = new JTextField();
		// txtrtTank.setEditable(false);

		pAdmin.add(txtCert).setBounds(159, 220, 230, 20);

		lbltdDifferent = new JLabel(
				"<html><i><b>Guarantor Name :</i></b></html>");
		lbltdDifferent.setForeground(Color.YELLOW);
		lbltdDifferent.setFont(new Font("Algerian", Font.ITALIC, 12));
		pAdmin.add(lbltdDifferent).setBounds(0, 196, 180, 120);
		txtgName = new JTextField();
		// txttdDifferent.setEditable(false);
		pAdmin.add(txtgName).setBounds(159, 250, 230, 20);

		lbltGain = new JLabel("<html><i><b>Guarantor P_Number :</i></b></html>");
		lbltGain.setForeground(Color.YELLOW);
		lbltGain.setFont(new Font("Algerian", Font.ITALIC, 12));
		pAdmin.add(lbltGain).setBounds(0, 230, 180, 120);
		txtgPhone = new JTextField();
		// txttGain.setEditable(false);
		pAdmin.add(txtgPhone).setBounds(159, 280, 230, 20);

		JLabel l = new JLabel("<html><i><b>Salary Payment for Month & Year.");
		l.setBounds(0, 280, 900, 80);
		l.setFont(new Font("Algerian", Font.ITALIC, 15));
		l.setForeground(Color.RED);
		pAdmin.add(l);

		cmbMonth = new JComboBox(month1);
		cmbMonth.setFont(new Font("serif", Font.BOLD, 10));
		cmbMonth.setToolTipText("Select The Month ");
		cmbMonth.setBorder(BorderFactory.createBevelBorder(1, new Color(192,
				192, 255), new Color(192, 192, 255)));
		cmbMonth.setEditable(false);
		cmbMonth.setMaximumRowCount(5);
		pAdmin.add(cmbMonth).setBounds(313, 315, 80, 20);
		cmbYear = new JComboBox(yrs1);
		cmbYear.setFont(new Font("serif", Font.BOLD, 12));
		cmbYear.setToolTipText("Select The Year");
		cmbYear.setBorder(BorderFactory.createBevelBorder(1, new Color(192,
				192, 255), new Color(192, 192, 255)));
		cmbYear.setEditable(false);
		cmbYear.setMaximumRowCount(5);
		pAdmin.add(cmbYear).setBounds(399, 315, 80, 20);

		lbltgSale = new JLabel("<html><i><b>Amount(N) :</i></b></html>");
		lbltgSale.setForeground(Color.white);
		lbltgSale.setFont(new Font("Algerian", Font.ITALIC, 12));
		pAdmin.add(lbltgSale).setBounds(20, 310, 180, 90);
		txtAmount = new JTextField();
		txtAmount.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
						|| c == '5' || c == '6' || c == '7' || c == '8'
						|| c == '9' || c == '.')) {
					getToolkit().beep();
					ke.consume();

				}
			}
		});
		pAdmin.add(txtAmount).setBounds(100, 348, 120, 20);

		lblExpense = new JLabel("<html><i><b>Bonus :</i></b></html>");
		lblExpense.setForeground(Color.white);
		lblExpense.setFont(new Font("Algerian", Font.ITALIC, 12));
		pAdmin.add(lblExpense).setBounds(20, 330, 80, 120);

		txtBonus = new JTextField();
		txtBonus.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
						|| c == '5' || c == '6' || c == '7' || c == '8'
						|| c == '9' || c == '.')) {
					getToolkit().beep();
					ke.consume();

				}
			}
		});
		pAdmin.add(txtBonus).setBounds(100, 378, 120, 20);

		lblExpense = new JLabel("<html><i><b>Others  :</i></b></html>");
		lblExpense.setForeground(Color.white);
		lblExpense.setFont(new Font("Algerian", Font.ITALIC, 12));
		pAdmin.add(lblExpense).setBounds(20, 360, 80, 120);

		txtOthers = new TextArea();
		// txttgSale.setEditable(false);
		pAdmin.add(txtOthers).setBounds(100, 401, 350, 48);

		btnSave = new JButton("Save");
		pAdmin.add(btnSave).setBounds(0, 451, 65, 15);
		btnNew = new JButton("New");
		pAdmin.add(btnNew).setBounds(69, 451, 60, 15);
		btnModify = new JButton("Modify");
		pAdmin.add(btnModify).setBounds(135, 451, 80, 15);

		btnPreview = new JButton("Preview");
		pAdmin.add(btnPreview).setBounds(225, 451, 80, 15);
		btnRemove = new JButton("Remove");
		pAdmin.add(btnRemove).setBounds(310, 451, 85, 15);
		btnExit = new JButton("Exit");
		pAdmin.add(btnExit).setBounds(399, 451, 75, 15);

		lbl1 = new JLabel(new ImageIcon("images//2.jpg"));
		lbl1.setBounds(0, 0, 477, 150);
		pAdmin.add(lbl1);
		JLabel lbl2 = new JLabel(new ImageIcon("images//2.jpg"));
		lbl2.setBounds(0, 151, 477, 150);
		pAdmin.add(lbl2);
		JLabel lbl3 = new JLabel(new ImageIcon("images//2.jpg"));
		lbl3.setBounds(0, 285, 477, 200);
		pAdmin.add(lbl3);
		getContentPane().add(pAdmin, BorderLayout.CENTER);

		btnNew.addActionListener(this);
		btnSave.addActionListener(this);
		btnRemove.addActionListener(this);
		btnPreview.addActionListener(this);
		btnExit.addActionListener(this);
		btnModify.addActionListener(this);

	}

	public static void main(String[] args) {
		payroll sam = new payroll();
		sam.setSize(480, 500);
		sam.setVisible(true);
		sam.setResizable(false);
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
		Object obj = e.getSource();
/*
		try {

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager
					.getConnection(
							"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D://database//rakedomanagement.mdb;DriverID=22;READONLY=true) ",
							"", "");

			stmt = con.createStatement();

		}

		catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "Failed Connection", "Error",
					JOptionPane.ERROR_MESSAGE);
		}*/
		
		String url = "jdbc:mysql://localhost:3306/rakedomanagement";
		try {
			// con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver "
			// +
			// "(*.mdb)};"+"DBQ=D:\\database\\rakedomanagement.mdb","ayets","setonji04");

			con = DriverManager.getConnection(url, "root", "");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,
					"Failed Connection,ON your Local Server", "Error",
					JOptionPane.ERROR_MESSAGE);

			// e1.printStackTrace();
		}
		
		

		if (obj == btnExit) { // If Cancel Button Pressed Unload the From.
			MainMenuFrame sam = new MainMenuFrame();
			sam.setVisible(true);
			sam.setLocationRelativeTo(null);
			dis_charge_report.setDefaultLookAndFeelDecorated(true);
			setVisible(false);

		}
		if (obj == btnRemove) {
			RemoveInfo s = new RemoveInfo();
			s.setVisible(true);
			s.setLocation(100, 100);
			s.setSize(1200, 520);
			setVisible(false);

		}

		if (obj == btnPreview) {

			payroll_list l = new payroll_list();
			l.setSize(1320, 580);
			l.setLocation(20, 80);
			l.setVisible(true);
			setVisible(false);

		}

		if (obj == btnModify) {
			ModifyInfo sam = new ModifyInfo();
			sam.setSize(1200, 520);
			sam.setVisible(true);
			sam.setLocationRelativeTo(null);
			setVisible(false);

		}if (e.getSource() == btnSearch) {

			SearchRecord();

		}
		
		if (e.getSource() == btnSave) {

			insertUpdate();

		}
	}

	public void insertUpdate() {

		String url = "jdbc:mysql://localhost:3306/rakedomanagement";
		try {
			// con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver "
			// +
			// "(*.mdb)};"+"DBQ=D:\\database\\rakedomanagement.mdb","ayets","setonji04");

			con = DriverManager.getConnection(url, "root", "");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,
					"Failed Connection,ON your Local Server", "Error",
					JOptionPane.ERROR_MESSAGE);

			// e1.printStackTrace();
		}

		if (cmbMonth.getSelectedItem().equals("MONTH")
				|| cmbYear.getSelectedItem().equals("YEAR")) {
			Icon error = new ImageIcon("images//error.png");
			JOptionPane
					.showMessageDialog(
							null,
							"<html><font size=4 color=red>Month & Year can't be in thier Default Value <br><i><b> MONTH & YEAR </i></b></font></html>  ",
							"Warning", JOptionPane.ERROR_MESSAGE, error);
		} else if (!txtemail.getText().contains("@")) {
			Icon error = new ImageIcon("images//error.png");
			JOptionPane
					.showMessageDialog(
							null,
							"<html><font size=4 color=red>Invalid email address</font></html> \n\t\t example@gmail.com",
							"Invalid Input", JOptionPane.ERROR_MESSAGE, error);
		} else if (txtpNumber.getText().length() != 11
				|| txtgPhone.getText().length() != 11) {
			Icon error = new ImageIcon("images//error.png");
			JOptionPane
					.showMessageDialog(
							null,
							"<html><font size=4 color=red>Mobile Number must not exceed 11 digits </font></html> \n\t\t Please Enter Valid Mobile Number",
							"Invalid Input", JOptionPane.ERROR_MESSAGE, error);
		}

		else if (txtDate.getText().equals("") || txtTime.getText().equals("")
				|| txtfName.getText().equals("")
				|| txtstaffID.getText().equals("")
				|| txtemail.getText().equals("")
				|| txtAmount.getText().equals("")
				|| txtBonus.getText().equals("")
				|| txtCert.getText().equals("")
				|| txtgName.getText().equals("")
				|| txtgName.getText().equals("")
				|| txtgPhone.getText().equals("")
				|| txtOthers.getText().equals("")
				|| txtpNumber.getText().equals("")
				|| txtPosition.getText().equals("")) {
			Icon error = new ImageIcon("images//error.png");
			JOptionPane
					.showMessageDialog(
							null,
							"<html><font size=4 color=red><i><b>Fill all editable Fields</i></b></font></html>  ",
							"Warning", JOptionPane.ERROR_MESSAGE, error);
		}

		else {

			/*String gender1 = "";

			if (cbm.getState() == true) {
				gender1 = "Male";
			}
			if (cbf.getState() == true) {
				gender1 = "Female";
			}*/
			try {

				stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);

				String sql = " INSERT INTO `payroll`(`date`, `time`, `sid`, `fname`,`gender`, `email`, `number`, `position`, `cert`, `gname`, `gpnumber`, `month`, `year`, `amount`, `bonus`, `others`) VALUES ('"
						+ txtDate.getText()
						+ "','"
						+ txtTime.getText()
						+ "','"
						+ txtstaffID.getText()
						+ "','"
						+ txtfName.getText()
						+ "','"
						+ cmbGender.getSelectedItem()
						+ "','"
						+ txtemail.getText()
						+ "','"
						+ txtpNumber.getText()
						+ "','"
						+ txtPosition.getText()
						+ "','"
						+ txtCert.getText()
						+ "','"
						+ txtgName.getText()
						+ "','"
						+ txtgPhone.getText()
						+ "','"
						+ cmbMonth.getSelectedItem()
						+ "','"
						+ cmbYear.getSelectedItem()
						+ "','"
						+ txtAmount.getText()
						+ "','"
						+ txtBonus.getText()
						+ "','" + txtOthers.getText() + "')";

				ps = con.prepareStatement(sql);
				ps.executeUpdate();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(btnSave, "Saved into database");

			clearText();

		}

	}

public  void SearchRecord(){
     
	  String url = "jdbc:mysql://localhost:3306/rakedomanagement";
	  
	   
	   try {
		con = DriverManager.getConnection(url,"root","");
		/*con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
	            "(*.mdb)};"+"DBQ=D:\\database\\rakedomanagement.mdb","ayets","setonji04");
		*/
	   
		
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
		
	}
		String staffid=null,fname=null,phone=null,email=null,position=null,cert=null,gname=null,gpnumber=null,gender=null;
		
		  String query = "select * from payroll where sid like '"+txtstaffID.getText()+"'";
          
 
 
try{
   stmt= con.createStatement();
     ResultSet rs = stmt.executeQuery(query);
     
while(rs.next()){
    
 staffid = rs.getString("sid");
 
fname= rs.getString("fName");
email=rs.getString("email");
phone = rs.getString("number");
position = rs.getString("position");
cert = rs.getString("cert");
gname=rs.getString("gname");
gpnumber=rs.getString("gpnumber");
gender=rs.getString("gender");

    
}
//st.close();
//con.close();

}catch(Exception ex){

System.err.println(ex.getMessage());
}

txtstaffID.setText(staffid);

txtfName.setText(fname);
txtpNumber.setText(phone);
txtPosition.setText(position);
txtCert.setText(cert);
txtgName.setText(gname);
txtgPhone.setText(gpnumber);
cmbGender.setSelectedItem(gender);

if(txtfName .getText().equals("") && txtstaffID.getText().equals("") &&  txtemail.getText().equals("")&&  txtPosition.getText().equals("") ){

	txtfName.setText("");
    txtemail.setText("");
    txtpNumber.setText("");
    txtPosition.setText("");
    
    
   
    
    
    
}
else
{
	 txtfName.setText(fname);
   
    txtemail.setText(email);
    txtpNumber.setText(phone);
    
    txtPosition.setText(position);
    
}
try{
	stmt.close();
con.close();} 
catch(Exception ex){
	System.out.println("error");
}

}
  

	void clearText() {
		txtAmount.setText("");
		txtBonus.setText("");
		txtCert.setText("");
		txtemail.setText("");
		txtfName.setText("");
		txtgName.setText("");
		txtgPhone.setText("");
		txtOthers.setText("");
		txtpNumber.setText("");
		txtPosition.setText("");
		txtstaffID.setText("");
		cmbMonth.setSelectedItem("MONTH");
		cmbYear.setSelectedItem("YEAR");

	}

	// /////////////////////////////////////////////

	class ModifyInfo extends JFrame {
		Container c = getContentPane();
		JTable table;
		JPanel main;
		DefaultTableModel model;
		Payrolldialog mdl;
		String stcode;

		ModifyInfo() {
			setSize(900, 600);
			setTitle("Discharge Information");
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					payroll sam = new payroll();
					sam.setVisible(true);
					sam.setSize(490, 510);
					sam.setLocationRelativeTo(null);
					payroll_list.setDefaultLookAndFeelDecorated(true);
					setVisible(false);

				}
			});

			ModifyInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage(
					"images//mainicon.png"));
			JLabel l = new JLabel(
					"<html><font size=5 color=#800080><i>Select Row To Modify");
			JPanel title = new JPanel() {
				public void paintComponent(Graphics g) {

					Toolkit kit = Toolkit.getDefaultToolkit();
					Image img = kit.getImage("images//HEADER.gif");
					MediaTracker t = new MediaTracker(this);
					t.addImage(img, 1);
					while (true) {
						try {
							t.waitForID(1);
							break;
						} catch (Exception e) {
						}
					}
					g.drawImage(img, 0, 0, 1200, 100, null);
				}
			};
			title.add(l);
			c.add("North", title);

			main = new JPanel();
			main.setLayout(new BorderLayout());

			try {
				String url = "jdbc:mysql://localhost:3306/rakedomanagement";

				con = DriverManager.getConnection(url, "root", "");
				stmt = con.createStatement();
				ResultSet set = stmt.executeQuery("select * from payroll");
				int row = 0;
				int i = 0;
				while (set.next()) {
					row++;
				}
				DefaultTableModel model = new DefaultTableModel(new String[] {
						"sId", "Date", "Time ", "fName", "gender", "email",
						"phone_Num.", "Position", "Certification", "Guar.Name",
						"Guar.Number", "month", "year", "amount", "bonus",
						"others" }, row);

				table = new JTable(model);
				set = stmt.executeQuery("select * from payroll");
				while (set.next()) {
					model.setValueAt(set.getString(3).trim(), i, 0);
					model.setValueAt(set.getString(1).trim(), i, 1);
					model.setValueAt(set.getString(2).trim(), i, 2);
					model.setValueAt(set.getString(4).trim(), i, 3);
					model.setValueAt(set.getString(5).trim(), i, 4);
					model.setValueAt(set.getString(6).trim(), i, 5);
					model.setValueAt(set.getString(7).trim(), i, 6);
					model.setValueAt(set.getString(8).trim(), i, 7);
					model.setValueAt(set.getString(9).trim(), i, 8);
					model.setValueAt(set.getString(10).trim(), i, 9);
					model.setValueAt(set.getString(11).trim(), i, 10);
					model.setValueAt(set.getString(12).trim(), i, 11);
					model.setValueAt(set.getString(13).trim(), i, 12);
					model.setValueAt(set.getString(14).trim(), i, 13);
					model.setValueAt(set.getString(15).trim(), i, 14);
					model.setValueAt(set.getString(16).trim(), i, 15);

					i++;
				}
				table = new JTable(model);
			} catch (Exception ex) {
			}
			JScrollPane sp = new JScrollPane(table);
			main.add(sp);
			table.addMouseListener(new ModifyStudList());
			table.setSelectionMode(0);
			table.setToolTipText("Select The ROW For Modify");
			table.setBorder(BorderFactory.createBevelBorder(1, new Color(192,
					192, 255), new Color(192, 192, 255)));
			table.setColumnSelectionAllowed(false);
			table.setSelectionMode(1);
			table.setEditingColumn(3);
			table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			table.setForeground(Color.MAGENTA);
			table.setGridColor(new Color(0, 128, 192));
			// table.setBackground(new Color(0,128,192));
			table.getTableHeader().setReorderingAllowed(false);
			c.add(main);
		}

		class ModifyStudList extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				int ro = table.getSelectedRow();
				stcode = (String) table.getValueAt(ro, 0);
				mdl = new Payrolldialog(stcode);
				mdl.setSize(480, 508);
				mdl.setLocationRelativeTo(null);
				mdl.setResizable(false);
				mdl.setVisible(true);
				setVisible(false);
			}
		}

		class Payrolldialog extends JDialog implements ActionListener,
				FocusListener {
			ResultSet rs = null;
			Statement stmt = null;
			Connection con = null;
			String user = "ayets";
			String pass = "setonji04";
			private JPanel pAdmin = new JPanel();
			private JLabel lblDate, lblTime, lbloDipping, lblcDipping,
					lblGender, lbldDifferent, lblSale, lblppLitre, lblrtTank,
					lbltdDifferent, lbltGain, lbltgSale, lblExpense;
			JLabel lbl1, lbldd;

			private JTextField txtDate, txtTime, txtstaffID, txtfName,
					txtemail, txtpNumber, txtPosition, txtCert, txtgName,
					txtgPhone, txtAmount, txtBonus;
			TextArea txtOthers;
			PreparedStatement ps = null;
			String[] month1 = { "MONTH", "January", "February", "March",
					"April", "May", "June", "July", "August", "September",
					"October", "November", "December", };
			String[] yrs1 = { "YEAR", "2005", "2006", "2007", "2008", "2009",
					"2010", "2011", "2012", "2013", "2014", "2015", "2016",
					"2017", "2018", "2019", "2020", "2021", "2022", "2023",
					"2024", "2025", "2026", "2027", "2028", "2029", "2030",
					"2031", "2032", "2033", "2034", "2035", "2036", "2037",
					"2038", "2039", "2040", "2041", "2042", "2043", "2044",
					"2045", "2046", "2047", "2048", "2049", "2050", "2051",
					"2052", "2053", "2054", "2055", "2056", "2057", "2058",
					"2059", "2060", "2061", "2062", "2063", "2064", "2065",
					"2066", "2067", "2068", "2069", "2070", "2071", "2072",
					"2073", "2074", "2075", "2076", "2077", "2078", "2079",
					"2080" };
			String mstud = "";
			private JComboBox cmbMonth;
			private JComboBox cmbYear;
			private JComboBox cmbgender;
			JButton btnUpdate, btnClear, btnCancel;
			private String[] sex = { "Select", "Male", "Female" };

			private java.util.Date currDate = new java.util.Date(); // Creating
																	// Object.
			private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",
					Locale.getDefault()); // Changing Format.
			private String d = sdf.format(currDate); // Storing Date.

			String timeStamp = new SimpleDateFormat("hh :mm: ss")
					.format(Calendar.getInstance().getTime());

			// Statement for Getting the Required Table.
			private long id = 0; // To Hold the BookId.

			// Constructor of Class.

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Payrolldialog(String s) {
				mstud = s;
				setTitle("Staff Payroll System");

				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {

						payroll sam = new payroll();
						sam.setVisible(true);
						sam.setSize(490, 510);
						sam.setLocationRelativeTo(null);
						payroll_list.setDefaultLookAndFeelDecorated(true);
						setVisible(false);
					}
				});
				pAdmin.setLayout(null);

				lblDate = new JLabel("<html><i><b>Date(dd/mm/yyyy):</i></html>");
				lblDate.setForeground(Color.white);
				lblDate.setFont(new Font("serif", Font.ITALIC, 14));

				pAdmin.add(lblDate).setBounds(0, -40, 120, 120);

				txtDate = new JTextField();
				txtDate.setFont(new Font("Algerian", Font.ITALIC, 14));

				pAdmin.add(txtDate).setBounds(120, 12, 90, 20);

				lblTime = new JLabel("<html><i><b>Time(hh :mm: ss):</i></html>");
				lblTime.setForeground(Color.white);
				lblTime.setFont(new Font("serif", Font.ITALIC, 14));
				pAdmin.add(lblTime).setBounds(0, -10, 120, 120);
				txtTime = new JTextField();

				txtTime.setFont(new Font("Algerian", Font.ITALIC, 14));
				pAdmin.add(txtTime).setBounds(120, 40, 90, 20);
				// //////////////////////////////////////////////////////
				lblGender = new JLabel("<html><b><i>Gender :</i></b></html>");
				lblGender.setFont(new Font("Algerian", Font.ITALIC, 14));
				lblGender.setForeground(Color.white);
				pAdmin.add(lblGender).setBounds(250, 30, 100, 20);

				cmbgender = new JComboBox(sex);
				pAdmin.add(cmbgender).setBounds(328, 37, 100, 18);

				lbloDipping = new JLabel("<html><i><b>staff ID:</i></b></html>");
				lbloDipping.setForeground(Color.white);
				pAdmin.add(lbloDipping).setBounds(0, 16, 180, 120);
				txtstaffID = new JTextField();
				/*
				 * txtstaffID.addKeyListener (new KeyAdapter () { public void
				 * keyTyped (KeyEvent ke) { char c = ke.getKeyChar ();
				 * 
				 * 
				 * if (!(c == '0' || c == '1' || c == '2' || c == '3' || c ==
				 * '4' || c == '5' || c == '6' || c == '7' || c == '8' || c ==
				 * '9' ||c=='.')) { getToolkit().beep (); ke.consume ();
				 * 
				 * } }} );
				 */
				pAdmin.add(txtstaffID).setBounds(95, 68, 100, 20);

				lblcDipping = new JLabel(
						"<html><i><b>Staff full Name :</i></b></html>");
				lblcDipping.setForeground(Color.white);
				pAdmin.add(lblcDipping).setBounds(0, 45, 180, 120);
				txtfName = new JTextField();
				txtfName.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent ke) {
						char c = ke.getKeyChar();

						if (!((Character.isAlphabetic(c)) || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE))) {

							getToolkit().beep();
							ke.consume();
						}

					}
				});
				pAdmin.add(txtfName).setBounds(95, 96, 380, 20);

				lbldDifferent = new JLabel("<html><i><b>Email :</i></b></html>");
				lbldDifferent.setForeground(Color.white);
				pAdmin.add(lbldDifferent).setBounds(0, 75, 180, 120);
				txtemail = new JTextField();
				txtemail.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent ke) {
						char c = ke.getKeyChar();

						if (!((Character.isAlphabetic(c)) || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE))) {
							if (!(c == '0' || c == '1' || c == '2' || c == '3'
									|| c == '4' || c == '5' || c == '6'
									|| c == '7' || c == '8' || c == '9'
									|| c == '_' || c == '@' || c == '-' || c == '.')) {

								getToolkit().beep();
								ke.consume();
							}
						}

					}
				});
				pAdmin.add(txtemail).setBounds(95, 125, 230, 20);

				lblppLitre = new JLabel(
						"<html><i><b>Phone Number :</i></b></html>");
				lblppLitre.setForeground(Color.white);
				lblppLitre.setFont(new Font("Algerian", Font.ITALIC, 14));
				pAdmin.add(lblppLitre).setBounds(15, 106, 180, 120);
				txtpNumber = new JTextField();

				txtpNumber.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent ke) {
						char c = ke.getKeyChar();

						if (!(c == '0' || c == '1' || c == '2' || c == '3'
								|| c == '4' || c == '5' || c == '6' || c == '7'
								|| c == '8' || c == '9')) {
							getToolkit().beep();
							ke.consume();

						}
					}
				});
				pAdmin.add(txtpNumber).setBounds(159, 159, 230, 20);

				lblSale = new JLabel("<html><i><b>Position :</i></b></html>");
				lblSale.setForeground(Color.white);
				lblSale.setFont(new Font("Algerian", Font.ITALIC, 14));
				pAdmin.add(lblSale).setBounds(15, 136, 180, 120);
				txtPosition = new JTextField();
				// txtSale.setEditable(false);
				pAdmin.add(txtPosition).setBounds(159, 189, 230, 20);

				lblrtTank = new JLabel(
						"<html><i><b>Certification :</i></b></html>");
				lblrtTank.setForeground(Color.white);
				lblrtTank.setFont(new Font("Algerian", Font.ITALIC, 14));
				pAdmin.add(lblrtTank).setBounds(15, 166, 180, 120);
				txtCert = new JTextField();
				// txtrtTank.setEditable(false);

				pAdmin.add(txtCert).setBounds(159, 220, 230, 20);

				lbltdDifferent = new JLabel(
						"<html><i><b>Guarantor Name :</i></b></html>");
				lbltdDifferent.setForeground(Color.YELLOW);
				lbltdDifferent.setFont(new Font("Algerian", Font.ITALIC, 12));
				pAdmin.add(lbltdDifferent).setBounds(0, 196, 180, 120);
				txtgName = new JTextField();
				// txttdDifferent.setEditable(false);
				pAdmin.add(txtgName).setBounds(159, 250, 230, 20);

				lbltGain = new JLabel(
						"<html><i><b>Guarantor P_Number :</i></b></html>");
				lbltGain.setForeground(Color.YELLOW);
				lbltGain.setFont(new Font("Algerian", Font.ITALIC, 12));
				pAdmin.add(lbltGain).setBounds(0, 230, 180, 120);
				txtgPhone = new JTextField();
				// txttGain.setEditable(false);
				pAdmin.add(txtgPhone).setBounds(159, 280, 230, 20);

				JLabel l = new JLabel(
						"<html><i><b>Salary Payment for Month & Year.");
				l.setBounds(0, 280, 900, 80);
				l.setFont(new Font("Algerian", Font.ITALIC, 15));
				l.setForeground(Color.RED);
				pAdmin.add(l);

				cmbMonth = new JComboBox(month1);
				cmbMonth.setFont(new Font("serif", Font.BOLD, 10));
				cmbMonth.setToolTipText("Select The Month ");
				cmbMonth.setBorder(BorderFactory.createBevelBorder(1,
						new Color(192, 192, 255), new Color(192, 192, 255)));
				cmbMonth.setEditable(false);
				cmbMonth.setMaximumRowCount(5);
				pAdmin.add(cmbMonth).setBounds(313, 315, 80, 20);
				cmbYear = new JComboBox(yrs1);
				cmbYear.setFont(new Font("serif", Font.BOLD, 12));
				cmbYear.setToolTipText("Select The Year");
				cmbYear.setBorder(BorderFactory.createBevelBorder(1, new Color(
						192, 192, 255), new Color(192, 192, 255)));
				cmbYear.setEditable(false);
				cmbYear.setMaximumRowCount(5);
				pAdmin.add(cmbYear).setBounds(399, 315, 80, 20);

				lbltgSale = new JLabel("<html><i><b>Amount(N) :</i></b></html>");
				lbltgSale.setForeground(Color.white);
				lbltgSale.setFont(new Font("Algerian", Font.ITALIC, 12));
				pAdmin.add(lbltgSale).setBounds(20, 310, 180, 90);
				txtAmount = new JTextField();
				txtAmount.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent ke) {
						char c = ke.getKeyChar();

						if (!(c == '0' || c == '1' || c == '2' || c == '3'
								|| c == '4' || c == '5' || c == '6' || c == '7'
								|| c == '8' || c == '9' || c == '.')) {
							getToolkit().beep();
							ke.consume();

						}
					}
				});
				pAdmin.add(txtAmount).setBounds(100, 348, 120, 20);

				lblExpense = new JLabel("<html><i><b>Bonus :</i></b></html>");
				lblExpense.setForeground(Color.white);
				lblExpense.setFont(new Font("Algerian", Font.ITALIC, 12));
				pAdmin.add(lblExpense).setBounds(20, 330, 80, 120);

				txtBonus = new JTextField();
				txtBonus.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent ke) {
						char c = ke.getKeyChar();

						if (!(c == '0' || c == '1' || c == '2' || c == '3'
								|| c == '4' || c == '5' || c == '6' || c == '7'
								|| c == '8' || c == '9' || c == '.')) {
							getToolkit().beep();
							ke.consume();

						}
					}
				});
				pAdmin.add(txtBonus).setBounds(100, 378, 120, 20);

				lblExpense = new JLabel("<html><i><b>Others  :</i></b></html>");
				lblExpense.setForeground(Color.white);
				lblExpense.setFont(new Font("Algerian", Font.ITALIC, 12));
				pAdmin.add(lblExpense).setBounds(20, 360, 80, 120);

				txtOthers = new TextArea();
				// txttgSale.setEditable(false);
				pAdmin.add(txtOthers).setBounds(100, 401, 350, 48);

				btnUpdate = new JButton("Update");
				btnUpdate.addActionListener(this);
				pAdmin.add(btnUpdate).setBounds(100, 455, 80, 20);
				btnClear = new JButton("Clear");
				btnClear.addActionListener(this);
				pAdmin.add(btnClear).setBounds(190, 455, 80, 20);

				btnCancel = new JButton("Cancel");
				pAdmin.add(btnCancel).setBounds(290, 455, 80, 20);
				btnCancel.addActionListener(this);

				lbl1 = new JLabel(new ImageIcon("images//2.jpg"));
				lbl1.setBounds(0, 0, 477, 150);
				pAdmin.add(lbl1);
				JLabel lbl2 = new JLabel(new ImageIcon("images//2.jpg"));
				lbl2.setBounds(0, 155, 477, 150);
				pAdmin.add(lbl2);
				JLabel lbl3 = new JLabel(new ImageIcon("images//2.jpg"));
				lbl3.setBounds(0, 288, 477, 209);
				pAdmin.add(lbl3);
				getContentPane().add(pAdmin, BorderLayout.CENTER);

				String url = "jdbc:mysql://localhost:3306/rakedomanagement";

				try {
					con = DriverManager.getConnection(url, "root", "");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {

					stmt = con.createStatement();

					ResultSet minfo = stmt
							.executeQuery("select * from payroll order by date");

					String stco = "";
					while (minfo.next()) {
						stco = minfo.getString(3).trim();
						if (stco.equals(mstud))
							break;

					}
					txtstaffID.setText(stco);
					// txtstaffID.setText(minfo.getString(3));
					txtDate.setText(minfo.getString(1));
					txtTime.setText(minfo.getString(2));
					txtfName.setText(minfo.getString(4));
					cmbgender.setSelectedItem(minfo.getString(5));
					txtemail.setText(minfo.getString(6));
					txtpNumber.setText(minfo.getString(7));
					txtPosition.setText(minfo.getString(8).trim());
					txtCert.setText(minfo.getString(9));
					txtgName.setText(minfo.getString(10));
					txtgPhone.setText(minfo.getString(11));
					cmbMonth.setSelectedItem(minfo.getString(12));
					cmbYear.setSelectedItem(minfo.getString(13));
					txtAmount.setText(minfo.getString(14));
					txtBonus.setText(minfo.getString(15));
					txtOthers.setText(minfo.getString(16));

				} catch (Exception ed) {
					ed.printStackTrace();
					// ed.getMessage();
					// System.out.println(ed);

				}
			}

			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
				Object obj = e.getSource();

				if (obj == btnCancel) {
					payroll_list l = new payroll_list();
					l.setSize(1320, 580);
					// l.setLocation(20,80);
					l.setVisible(true);
					setVisible(false);

				}

			}

			public void UpdateRecords() {
				String url = "jdbc:mysql://localhost:3306/rakedomanagement";

				try {
					con = DriverManager.getConnection(url, "root", "");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// `date`, `time`, `sid`, `fname`,`gender`, `email`, `number`,
				// `position`, `cert`, `gname`, `gpnumber`, `month`, `year`,
				// `amount`, `bonus`, `others
				String update1 = "Update payroll set date = '"
						+ txtDate.getText() + "' where time = '"
						+ txtTime.getText() + "'";
				String update2 = "Update payroll set sid = '"
						+ txtstaffID.getText() + "' where time = '"
						+ txtTime.getText() + "'";
				String update3 = "Update payroll set gender = '"
						+ cmbgender.getSelectedItem() + "' where sid = '"
						+ txtstaffID.getText() + "'";
				String update12 = "Update payroll set amount = '"
						+ txtAmount.getText() + "' where sid = '"
						+ txtstaffID.getText() + "'";
				String update4 = "Update payroll set bonus = '"
						+ txtBonus.getText() + "' where sid = '"
						+ txtstaffID.getText() + "'";
				String update5 = "Update payroll set cert = '"
						+ txtCert.getText() + "' where sid = '"
						+ txtstaffID.getText() + "'";
				String update6 = "Update payroll set fname = '"
						+ txtfName.getText() + "' where sid = '"
						+ txtstaffID.getText() + "'";
				String update7 = "Update payroll set gname = '"
						+ txtgName.getText() + "' where sid = '"
						+ txtstaffID.getText() + "'";
				String update8 = "Update payroll set gpnumber = '"
						+ txtgPhone.getText() + "' where sid = '"
						+ txtstaffID.getText() + "'";
				String update9 = "Update payroll set others = '"
						+ txtOthers.getText() + "' where sid = '"
						+ txtstaffID.getText() + "'";
				String update10 = "Update payroll set number = '"
						+ txtpNumber.getText() + "' where sid = '"
						+ txtstaffID.getText() + "'";
				String update11 = "Update payroll set position = '"
						+ txtPosition.getText() + "' where sid = '"
						+ txtstaffID.getText() + "'";
				String update13 = "Update payroll set month = '"
						+ cmbMonth.getSelectedItem() + "' where sid = '"
						+ txtstaffID.getText() + "'";
				String update14 = "Update payroll set year = '"
						+ cmbYear.getSelectedItem() + "' where sid = '"
						+ txtstaffID.getText() + "'";

				try {
					stmt = con.createStatement();
					stmt.executeUpdate(update1);
					stmt.executeUpdate(update2);
					stmt.executeUpdate(update3);
					stmt.executeUpdate(update4);
					stmt.executeUpdate(update5);
					stmt.executeUpdate(update6);
					stmt.executeUpdate(update7);
					stmt.executeUpdate(update8);
					stmt.executeUpdate(update9);
					stmt.executeUpdate(update10);
					stmt.executeUpdate(update11);
					stmt.executeUpdate(update12);
					stmt.executeUpdate(update13);
					stmt.executeUpdate(update14);

					stmt.close();
					con.close();
				} catch (SQLException ex) {
					System.err.println(ex.getMessage());
				}
				JOptionPane.showMessageDialog(null, "Update Finished!");
				// fillEmpty();
				clearText();
				dispose();

				payroll sam = new payroll();
				sam.setVisible(true);
				sam.setSize(490, 510);
				sam.setLocationRelativeTo(null);
				payroll_list.setDefaultLookAndFeelDecorated(true);
				setVisible(false);

			}

			void fillEmpty() {
				txtAmount.setText("");
				txtBonus.setText("");
				txtCert.setText("");
				txtemail.setText("");
				txtfName.setText("");
				txtgName.setText("");
				txtgPhone.setText("");
				txtOthers.setText("");
				txtpNumber.setText("");
				txtPosition.setText("");
				txtstaffID.setText("");
				cmbMonth.setSelectedItem("MONTH");
				cmbYear.setSelectedItem("YEAR");
				cmbgender.setSelectedItem("Select");

			}

			// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

				if (obj == btnCancel) {
					ModifyInfo sam = new ModifyInfo();
					sam.setSize(1200, 520);
					sam.setVisible(true);
					sam.setLocationRelativeTo(null);
					setVisible(false);
					// TODO Auto-generated method stub
				}

				if (obj == btnClear) {

					fillEmpty();

				}

				if (obj == btnUpdate) {

					UpdateRecords();

				}

			}

		}
	}

	class RemoveInfo extends JFrame {

		Connection con = null;
		JTable table;
		Container mic = getContentPane();
		// JComboBox appyrstrm;
		// JComboBox appyredrm;
		JTable stud;
		// JComboBox cour;
		JPanel pan;
		DefaultTableModel model;
		RemoveDialog dlg;

		// String corname;
		RemoveInfo() {

			setTitle("Remove Payroll Information");
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					payroll sam = new payroll();
					sam.setVisible(true);
					sam.setSize(490, 510);
					sam.setLocationRelativeTo(null);
					payroll_list.setDefaultLookAndFeelDecorated(true);
					setVisible(false);

				}
			});
			RemoveInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage(
					"images//mainicon.png"));
			JLabel l = new JLabel(
					"<html><font size=5 color=#800080><i>Select Payroll To Remove");
			JPanel title = new JPanel() {
				public void paintComponent(Graphics g) {

					Toolkit kit = Toolkit.getDefaultToolkit();
					Image img = kit.getImage("images//HEADER.gif");
					MediaTracker t = new MediaTracker(this);
					t.addImage(img, 1);
					while (true) {
						try {
							t.waitForID(1);
							break;
						} catch (Exception e) {
						}
					}
					g.drawImage(img, 0, 0, 1800, 520, null);
				}
			};
			title.add(l);
			mic.add("North", title);
			pan = new JPanel();

			try {

				String url = "jdbc:mysql://localhost:3306/rakedomanagement";

				con = DriverManager.getConnection(url, "root", "");

				System.out.println("connected");
				Statement st = con.createStatement();
				ResultSet set = st.executeQuery("select * from payroll");

				int row = 0;
				int i = 0;
				while (set.next()) {
					/*
					 * model.setValueAt(stset.getString(1).trim(),i,0); String
					 * ft=stset.getString(2).trim();
					 * ft=ft+" "+stset.getString(4).trim();
					 * model.setValueAt(ft,i,1);
					 * model.setValueAt(stset.getString(6).trim(),i,2);
					 */
					row++;
				}

				model = new DefaultTableModel(new String[] { "Date", "Time",
						"sId ", "fName", "gender", "email", "phone_Num.",
						"Position", "Certification", "Guar.Name",
						"Guar.Number", "month", "year", "amount", "bonus",
						"others" }, row);
				table = new JTable(model);

				set = st.executeQuery("select * from payroll");

				while (set.next()) {
					model.setValueAt(set.getString(1).trim(), i, 0);
					model.setValueAt(set.getString(2).trim(), i, 1);
					model.setValueAt(set.getString(3).trim(), i, 2);
					model.setValueAt(set.getString(4).trim(), i, 3);
					model.setValueAt(set.getString(5).trim(), i, 4);
					model.setValueAt(set.getString(6).trim(), i, 5);
					model.setValueAt(set.getString(7).trim(), i, 6);
					model.setValueAt(set.getString(8).trim(), i, 7);
					model.setValueAt(set.getString(9).trim(), i, 8);
					model.setValueAt(set.getString(10).trim(), i, 9);
					model.setValueAt(set.getString(11).trim(), i, 10);
					model.setValueAt(set.getString(12).trim(), i, 11);
					model.setValueAt(set.getString(13).trim(), i, 12);
					model.setValueAt(set.getString(14).trim(), i, 13);
					model.setValueAt(set.getString(15).trim(), i, 14);
					model.setValueAt(set.getString(16).trim(), i, 15);

					i++;
				}
				// table=new JTable(model);

			} catch (Exception ex) {
				System.out.println("error");
			}
			stud = new JTable(model);
			stud.addMouseListener(new RemoveStudList());
			stud.setToolTipText("Select The Payroll to Remove");
			stud.doLayout();
			stud.setColumnSelectionAllowed(false);
			stud.setSelectionMode(1);
			stud.setEditingColumn(3);
			stud.setGridColor(Color.pink);
			stud.setRowMargin(3);
			stud.setSelectionBackground(Color.gray);
			stud.setSelectionForeground(Color.red);
			stud.setBackground(Color.cyan);
			stud.setShowHorizontalLines(false);
			stud.setShowVerticalLines(true);
			stud.setBorder(BorderFactory.createBevelBorder(1, new Color(192,
					192, 255), new Color(192, 192, 255)));
			JScrollPane spl = new JScrollPane(stud);
			mic.add(spl);

			addWindowListener(new WindowAdapter() {
				public void windowActivated(WindowEvent we) {
					try {

						ResultSet stset = stmt
								.executeQuery("select * from payroll where date like '"
										+ txtDate.getText() + "'");
						int row = 0;
						int i = 0;
						while (stset.next()) {
							row++;
						}
						model = new DefaultTableModel(new String[] { "Date",
								"Time", "Gender ", "Staff_ID", "f_Name",
								"Email", "phone_Num.", "Position",
								"Certification", "Guar.Name", "Guar.Number",
								"Amount", "Bonus", "Others", "Month", "Year" },
								row);
						stset = ps.executeQuery();

						while (stset.next()) {
							model.setValueAt(stset.getString(1).trim(), i, 0);
							model.setValueAt(stset.getString(2).trim(), i, 1);
							model.setValueAt(stset.getString(3).trim(), i, 2);
							model.setValueAt(stset.getString(4).trim(), i, 3);
							model.setValueAt(stset.getString(5).trim(), i, 4);
							model.setValueAt(stset.getString(6).trim(), i, 5);
							model.setValueAt(stset.getString(7).trim(), i, 6);
							model.setValueAt(stset.getString(8).trim(), i, 7);
							model.setValueAt(stset.getString(9).trim(), i, 8);
							model.setValueAt(stset.getString(10).trim(), i, 9);
							model.setValueAt(stset.getString(11).trim(), i, 10);
							model.setValueAt(stset.getString(12).trim(), i, 11);
							model.setValueAt(stset.getString(13).trim(), i, 12);
							model.setValueAt(stset.getString(14).trim(), i, 13);
							model.setValueAt(stset.getString(15).trim(), i, 14);
							model.setValueAt(stset.getString(16).trim(), i, 15);

							i++;

						}
						stud.setModel(model);

					} catch (Exception ex) {

					}
				}
			});

		}

		class RemoveStudList extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				int ro = stud.getSelectedRow();
				String stcode = (String) stud.getValueAt(ro, 0);
				dlg = new RemoveDialog(stcode);
				dlg.setVisible(true);

			}
		}

		class RemoveDialog extends JDialog {
			JButton rok;
			JButton rcan;
			JLabel ls;
			String rmstud;
			JPanel bp;
			public JComboBox cour;

			RemoveDialog(String s) {
				super(RemoveInfo.this, "Remove Payroll", true);
				rmstud = s;
				setSize(250, 150);
				setLocation(400, 280);
				bp = new JPanel();
				bp.setBackground(new Color(255, 197, 68));
				rok = new JButton("  Ok  ");
				rcan = new JButton("Cancel");
				bp.add(rok);
				bp.add(rcan);
				add(bp, "South");
				JPanel lp = new JPanel();
				lp.add(new JLabel(
						"<html><font size=4 color=#800080>Do You Want To Remove <br> Payroll Information </font></html>"));
				add(lp);
				RemoveStud rs = new RemoveStud();
				rok.addActionListener(rs);
				rcan.addActionListener(rs);

			}

			class RemoveStud implements ActionListener {
				String dur;

				public void actionPerformed(ActionEvent ev) {
					String cm = ev.getActionCommand();

					if (cm.equals("Cancel")) {

						dispose();
						System.out.println("You have clicked a cancel button");
					}
					if (cm.equals("  Ok  ")) {

						try {
							// String csn=(String)cour.getSelectedItem();
							PreparedStatement pts = con
									.prepareStatement("DELETE  FROM payroll WHERE date= ?");

							pts.setString(1, rmstud);
							pts.execute();
							// pts.close();
							int i = table.getSelectedRow();

							if (i >= 0) {
								model.removeRow(i);

							} else {

								System.out.println("samuel");
							}

							Icon error = new ImageIcon("images//error.png");

							JOptionPane
									.showMessageDialog(
											null,
											"<html><font size=4 color=red>Payroll Report</font></html> \n\t\t Deleted",
											"Deleted",
											JOptionPane.ERROR_MESSAGE, error);

							// bp.setVisible(false);
							setVisible(false);

							System.out.println("youuuuu");
							Statement st = con.createStatement();
							// st.executeUpdate(query);

							st.close();
							con.close();

						} catch (Exception ex) {
							System.err.println(ex.getMessage());
						}

					}
				}

			}

		}
	}
}

// //////////////////////////////PayrollDialog Method
/**/
