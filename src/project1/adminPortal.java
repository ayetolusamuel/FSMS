package project1;


import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class adminPortal extends JFrame
{
	ImagePanel imagepanel;
	JPanel buttonpanel;
	private Image image;
   	private int current=1;
   	private int imageCount=36;
   	private int imageWidth;
   	private int imageHeight;
   	private Thread runner;
	adminPortal()
	{
		setSize(600,400);
		setTitle("Filling Management System");
		setLocation(220,20);
		setDefaultCloseOperation(3);
		//LoginFrame.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		Image img=Toolkit.getDefaultToolkit().getImage("images//mainicon.png");
		setIconImage(img);
	
		Container c=getContentPane();
		JPanel mainpanel=new JPanel();
		mainpanel.setLayout(null);

		JPanel subpanel=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				
				Image img=kit.getImage("images//back3.jpg");
				
				//Image img=kit.getImage("images//title_background.jpg");
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
				g.drawImage(img,0,0,309,450,null);
			}
		};
		 buttonpanel=new JPanel()
		 {
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//title_background.jpg");
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
				g.drawImage(img,0,0,600,600,null);
			}
		 };
		imagepanel=new ImagePanel();
		subpanel.setBackground(new Color(245, 240, 255));
		imagepanel.setBackground(new Color(245, 240, 255));

		mainpanel.setLayout(new BorderLayout());
		JLabel l=new JLabel("<html><i><font size=5 color=#800080><i>Admin Portal");
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
				g.drawImage(img,0,0,600,50,null);
			}
		};
		title.add(l);
		mainpanel.add(title,"North");
		mainpanel.add(subpanel);
		subpanel.setLayout(new GridLayout(1,2,10,10));
		subpanel.add(imagepanel);
		subpanel.add(buttonpanel);
		buttonpanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonpanel.setLayout(new GridLayout(12,0,20,12));
		buttonpanel.add(new JLabel(""));
		ButtonHandler handler=new ButtonHandler();
		JButton emergency_contact=addButton("Search Staff",handler);
		emergency_contact.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		emergency_contact.setVisible(true);
		JButton student_info=addButton("Register Report",handler);
		student_info.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		
		JButton daily_Report=addButton("Daily Report",handler);
		daily_Report.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		//JButton internal_report=addButton("Payroll Report",handler);
		
		JButton internal_report=addButton("Payroll Report",handler);
		
		internal_report.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton memo_form=addButton("Staff Contact",handler);
		memo_form.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton invetation_form=addButton("Discharge Report",handler);
		invetation_form.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton staff_contact=addButton("Remove/Update Staff",handler);
		staff_contact.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton gest_contact=addButton("Print",handler);
		gest_contact.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton exit=addButton("BACK",handler);
		exit.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));

		c.add(mainpanel);
		getContentPane().add(mainpanel,BorderLayout.CENTER);
		
		
	}
	JButton addButton(String s,ActionListener listen)
	{
		JButton  b=new JButton(s);
		b.addActionListener(listen);
		buttonpanel.add(b);
		return b;
	}
	class ImagePanel extends JPanel
	{
		ImageIcon ic;
		ImagePanel()
		{
			setLayout(new BorderLayout());

		}
		public void paintComponent(Graphics g)
		{
			//Image img=Toolkit.getDefaultToolkit().getImage("images//n66.jpg");
			Image img=Toolkit.getDefaultToolkit().getImage("images//developer.jpg");
			
			ic=new ImageIcon(img,"Center");
      		g.drawImage(img,0,140,300,300,null);
		}
	}

	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String action=e.getActionCommand();
			if(action.equals("Search Staff"))
			{
				StaffsInfo info=new StaffsInfo();
				info.setVisible(true);
				setVisible(false);
			}
			
			if(action.equals("Register Report"))
			{
				Discharge report=new Discharge();
				report.setVisible(true);
				report.setSize(410,310);
				report.setLocationRelativeTo(null);
				setVisible(false);
			}
			if(action.equals("Payroll System"))
			{
				payroll report=new payroll();
				report.setVisible(true);
				report.setSize(493,510);
				report.setLocationRelativeTo(null);
				setVisible(false);
			}
			if(action.equals("BACK"))
			{MainMenuFrame sam=new MainMenuFrame();
			sam.setVisible(true);
			dis_charge_report.setDefaultLookAndFeelDecorated(true);
			setVisible(false);
			
			}
			/*
			if(action.equals("Exit"))
				//MainMenuFrame s=	new MainMenuFrame();
				//setVisible(true);
				
				System.exit(0);
*/
		}
	}

public static void main(String args []){
	adminPortal sa=new adminPortal();
	sa.setVisible(true);
	sa.setSize(600,440);
	sa.setTitle("Filling Management System");
	//sa.setLocation(220,20);
	
	sa.setLocationRelativeTo(null);
}
}