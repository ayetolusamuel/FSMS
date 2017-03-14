package project1;


import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class CEOportal1 extends JFrame
{
	ImagePanel imagepanel;
	JPanel buttonpanel;
	private Image image;
   	private int current=1;
   	private int imageCount=36;
   	private int imageWidth;
   	private int imageHeight;
   	private Thread runner;
	CEOportal1()
	{
		setSize(600,600);
		setTitle("CEO Portal");
		setLocation(220,20);
		setDefaultCloseOperation(3);
		LoginFrame.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		Image img=Toolkit.getDefaultToolkit().getImage("images//mainicon.png");
		setIconImage(img);
		Container c=getContentPane();
		JPanel mainpanel=new JPanel();

		JPanel subpanel=new JPanel()
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
		JLabel l=new JLabel("<html><font size=5 color=#800080><i>CEO Portal");
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
		JButton emergency_contact=addButton("Staff Information",handler);
		emergency_contact.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		emergency_contact.setVisible(true);
		JButton student_info=addButton("Staff Payroll",handler);
		student_info.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton internal_report=addButton("Expenditure",handler);
		internal_report.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton memo_form=addButton("Discharge Portal",handler);
		memo_form.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton invetation_form=addButton("Payroll System",handler);
		invetation_form.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton staff_contact=addButton("",handler);
		staff_contact.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton md_Portal=addButton("Print Portal",handler);
		md_Portal.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		
		JButton gest_contact=addButton("",handler);
		gest_contact.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		
		JButton logout=addButton("",handler);
		logout.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));

		
		JButton exit=addButton("Back To MainMenu",handler);
		exit.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));

		c.add(mainpanel);
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
			
			Image img=Toolkit.getDefaultToolkit().getImage("images//developer.jpg");
			
			ic=new ImageIcon(img,"Center");
      		g.drawImage(img,0,140,300,350,null);
		}
	}

	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String action=e.getActionCommand();
			if(action.equals("Staff Information"))
			{
				StaffsInfo info=new StaffsInfo();
				info.setVisible(true);
				setVisible(false);
			}
			
			if(action.equals("Discharge"))
			{
			discharge_or report=new discharge_or();
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
			if(action.equals("About The Software"))
			{
				AboutDialog memo=new AboutDialog();
				memo.setLocationRelativeTo(null);
				memo.setSize(700, 400);
				//memo.setVisible(true);
				//setVisible(false);
			}
			if(action.equals("MD Portal"))
			{
				mdLogin sa=new mdLogin();
				sa.setVisible(true);
				sa.setSize(400,250);
				sa.setLocationRelativeTo(null);
				setVisible(false);
			}
			
			
			if(action.equals("Back To MainMenu"))
			{

				MainMenuFrame sam=new MainMenuFrame();
				sam.setVisible(true);
				dis_charge_report.setDefaultLookAndFeelDecorated(true);
				setVisible(false);
			}
			if(action.equals("Expenditure"))
			{
				Expenditure sa=new Expenditure();
				sa.setVisible(true);
				sa.setSize(570,540);
				sa.setLocationRelativeTo(null);
				setVisible(false);
			}
			if(action.equals("LOGOUT"))
			{
				LoginFrame sa=new LoginFrame();
				sa.setVisible(true);
				sa.setSize(400,300);
				sa.setLocationRelativeTo(null);
				setVisible(false);
			}
			
			if(action.equals("Admin Portal"))
			{
			mdLogin sa=new mdLogin();
			sa.setVisible(true);
			sa.setSize(400,250);
			sa.setLocationRelativeTo(null);
			setVisible(false);}
		
			/*if(action.equals("Emergency Contact"))
			{
				EmergencyContact emergency=new EmergencyContact();
				emergency.setVisible(true);
				setVisible(false);
			}
			if(action.equals("Staff Information"))
			{
				StaffContact staff=new StaffContact();
				staff.setVisible(true);
				setVisible(false);
			}
			if(action.equals("Gest Information"))
			{
				GestContact gest=new GestContact();
				gest.setVisible(true);
				setVisible(false);
			}*/
			if(action.equals("Exit"))
				System.exit(0);


		}
	}

public static void main(String args []){
	CEOportal1 sa=new CEOportal1();
	sa.setVisible(true);
	sa.setLocationRelativeTo(null);

}
}