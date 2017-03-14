package project1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;



public class mdLogin extends JFrame implements ActionListener{
	private JLabel lblUsername,lblPassword,lblPosition,lblAuth;
	private JTextField txtUsername,txtPosition;
	private JPasswordField txtPassword,txtAuth;
	private JComboBox cmbPosition;
	Statement st=null;
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	private JPanel pAdminLogin;
	String[] auth ={"Select","Admin","MD","CEO"};
	private JButton btnLogin,btnCancel;
	
	public mdLogin() {
		pAdminLogin =new JPanel(){
			
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//back3.jpg");
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
				g.drawImage(img,0,0,400,250,null);
			}
		}
		
		;
		setTitle("Login Portal");
		Image img=Toolkit.getDefaultToolkit().getImage("images//mainicon.png");
		setIconImage(img);
		pAdminLogin.setLayout(null);
		lblUsername=new JLabel("<html><i>UserName :");
		lblUsername.setFont(new Font("Comic Sans MS",Font.ITALIC,16));
		lblUsername.setForeground(Color.white);
		pAdminLogin.add(lblUsername).setBounds(15, 30, 120, 20);
		txtUsername=new JTextField();
		txtUsername.setFont(new Font("Comic Sans MS",Font.ITALIC,16));
		pAdminLogin.add(txtUsername).setBounds(140, 33, 120, 20);
		
		
		
		lblPassword=new JLabel("<html><i>Password :");
		lblPassword.setForeground(Color.white);
		lblPassword.setFont(new Font("Comic Sans MS",Font.ITALIC,16));
		pAdminLogin.add(lblPassword).setBounds(15, 70, 120, 20);
		txtPassword= new JPasswordField();
		txtPassword.setFont(new Font("Comic Sans MS",Font.ITALIC,16));
		pAdminLogin.add(txtPassword).setBounds(140, 73, 120, 20);
	
		lblPosition=new JLabel("<html><i>Position :");
		lblPosition.setForeground(Color.white);
		lblPosition.setFont(new Font("Comic Sans MS",Font.ITALIC,16));
		pAdminLogin.add(lblPosition).setBounds(15, 110, 120, 20);
		cmbPosition=new JComboBox<>(auth);
		cmbPosition.setFont(new Font("Comic Sans MS",Font.ITALIC,16));
		pAdminLogin.add(cmbPosition).setBounds(140, 113, 120, 20);
	
		lblAuth=new JLabel("<html><i>AUTH. Code :");
		lblAuth.setForeground(Color.white);
		lblAuth.setFont(new Font("Comic Sans MS",Font.ITALIC,16));
		pAdminLogin.add(lblAuth).setBounds(15, 150, 120, 20);
		txtAuth=new JPasswordField();
		txtAuth.setFont(new Font("Comic Sans MS",Font.ITALIC,16));
		pAdminLogin.add(txtAuth).setBounds(140, 153, 124, 20);
		
		
		
		btnLogin=new JButton("<html><i>LOGIN");
		btnLogin.setFont(new Font("Comic Sans MS",Font.ITALIC,16));
		pAdminLogin.add(btnLogin).setBounds(15, 190, 120, 20);
		btnLogin.addActionListener(this);
		
		btnCancel=new JButton("<html><i>CANCEL");
		btnCancel.setFont(new Font("Comic Sans MS",Font.ITALIC,16));
		pAdminLogin.add(btnCancel).setBounds(150, 190, 120, 20);
		btnCancel.addActionListener(this);
		
		getContentPane().add(pAdminLogin,BorderLayout.CENTER);
		cmbPosition.setName("MD");
		}
	
   
	 @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e){
		 
		 try
			{
			conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
		            "(*.mdb)};"+"DBQ=D:\\database\\rakedomanagement.mdb","ayets","setonji04");
         
			}catch (Exception e2) {
				// TODO: handle exception
			}
			  
		 
		
			 
		 if(e.getSource()==btnLogin){
		        
      	   if(!(txtUsername.getText().equals(""))&& (!(txtPassword.getText().equals(""))  && (!(txtAuth.getText().equals(""))))){
      		   
      	  
      	   }
      	   else
      		   System.out.println("error");
      	
      		  
      
      	   
      	   try
     		{
     			      st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

     		      			      String user = txtUsername.getText();
     		      					user = user.trim();
     		      			      

     		      					String pass = txtPassword.getText();

     		      					String auth = txtAuth.getText();
     		      					auth = auth.trim();
     		      			      
     		      			      String sql= "select * from adminLogin where username= '" + user + "' and password ='" + pass + "' and authcode='"+auth+"'";
     		      			      
     		      			        try
     		      		      {
     		      		          ps=conn.prepareStatement(sql);
     		      		          rs= ps.executeQuery();
     		      		     if (rs.next()){
     		                  this.hide();
     		                 if(cmbPosition.getSelectedItem().equals("CEO")){

      		             		CEOportal1 frm=new CEOportal1();
      		             		frm.setVisible(true);
      		             		frm.setSize(570,540);
      		             		frm.setLocationRelativeTo(null);
      		             		setVisible(false);

      		             		}
      		        	   else if(cmbPosition.getSelectedItem().equals("Admin")){

      		             		adminPortal frm=new adminPortal();
      		             		frm.setVisible(true);
      		             		setVisible(false);

      		             		}
      		             		else if(cmbPosition.getSelectedItem().equals("MD")){
      		             		mdPortal frm=new  mdPortal();
      		             		frm.setVisible(true);
      		             		setVisible(false);
      		             		}
     		                 
      		             		else if(cmbPosition.getSelectedItem().equals("Select")){
      	  		      		    	 JOptionPane.showMessageDialog(null, "Position value must not be in its default value.");
      	  		      		    	 
      	  		      		   mdLogin sa =new mdLogin();
      	  		      		sa.setSize(400,250);
      	  		      		sa.setLocationRelativeTo(null);
      	  		      		sa.setVisible(true);
      	  		      		    	 
      	  		      		     }
     		                 
      		             		else{
      		             			
      		             		
      		             		}
     		               }
     		      		     
     		      		  else if(cmbPosition.getSelectedItem().equals("Select")){
  		      		    	 JOptionPane.showMessageDialog(null, "Position value must be in its default value.");
  		      		    	 
  		      		     }
     		      		     else if(user.length()==0 ||pass.length()==0 || auth.length()==0){
     		      		    	 JOptionPane.showMessageDialog(null, "username, password and AuthCode can't be empty.");
     		      		    	 
     		      		     }
     		      		     
     		      		     
     		      		   else{
     		      			Icon warning=new ImageIcon("images//warning.png");
     						
     		      			JOptionPane.showMessageDialog(null,"<html><b><i>Login failed!Enter Details Correctly & Try Again","Re-Try",JOptionPane.WARNING_MESSAGE,warning);
     		               
     		      			//System.out.println("Login failed! Try Again");	
  		             		
     		                   }
     		      		      }catch(SQLException | HeadlessException ex){
     		      		         JOptionPane.showMessageDialog(null, ex); 
     		      		          
     		      		    }                                     
     		      		    }   
     		      			      
     		     
     		        catch(Exception ex){
     		            
     		           JOptionPane.showMessageDialog(null, "Failed Connection","Error",JOptionPane.ERROR_MESSAGE);
     		        }
     		        }

         
         if(e.getSource()==btnCancel){
             
            
        	 MainMenuFrame frm=new MainMenuFrame();
       frm.setVisible(true);
               
             setVisible(false);
             
         }}
         
			
public static void main(String[] args) {
mdLogin sa =new mdLogin();
sa.setSize(400,250);
sa.setLocationRelativeTo(null);
sa.setVisible(true);
}
}
