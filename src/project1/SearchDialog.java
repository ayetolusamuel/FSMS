/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class SearchDialog extends JFrame
{
	//JTextField txtfName;
	JTextField txtsId;
	JButton ok;
	JButton cancle;
	JPanel cntpan;
	Container c;
	int width;
	int height;
	Dimension screenSize;
	SearchDialog()
	{
		//super(f,"Search Staff",true);
		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/3;
		height=screenSize.height/3;
		setSize(340,180);
		setLocation(width,height);
		txtsId=new JTextField(10);
		//txtfName=new JTextField(10);
		Icon prt=new ImageIcon("images//SEARCH.png");
		ok=new JButton("Search",prt);
		cancle=new JButton("Cancel");
		JPanel p=new JPanel();
		p.add(ok);
		p.add(cancle);
		p.setBackground(new Color(255,197,68));
		add(p,"South");
		c=getContentPane();
		cntpan=new JPanel();
		cntpan.setLayout(new GridBagLayout());
		JPanel image=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//icon2.jpg");
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
				g.drawImage(img,10,18,70,70,null);
			}
		};
		GridBagConstraints cons=new GridBagConstraints();
		cons.fill=GridBagConstraints.BOTH;
		cons.anchor=GridBagConstraints.EAST;
		cons.weightx=50;
		cons.weighty=100;
		add(image,cons,0,0,1,4);
		cons.weightx=0;
		cons.weighty=20;
		cons.fill=GridBagConstraints.NONE;
		cons.anchor=GridBagConstraints.WEST;
		cons.ipadx=20;
		cons.ipady=10;
		cons.insets=new Insets(10,4,0,4);
		add(new JLabel("Staff_Id"),cons,1,0,1,1);

		cons.anchor=GridBagConstraints.EAST;
		add(txtsId,cons,2,0,1,1);
		cons.insets=new Insets(0,4,6,4);
		//add(new JLabel("F_Name"),cons,1,1,1,1);
		//add(txtfName,cons,2,1,1,1);
		add(new JLabel(""),cons,2,2,1,1);

		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String sIdtext=txtsId.getText().trim();
				//String fNametext=txtfName.getText().trim();
				Search_Staff ss=new Search_Staff(sIdtext);
				ss.setVisible(true);
				dispose();
			}
		});
		cancle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});


	}
	public void add(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
	{
		cons.gridx=x;
		cons.gridy=y;
		cons.gridwidth=w;
		cons.gridheight=h;
		comp.setPreferredSize(comp.getPreferredSize());
		cntpan.add(comp,cons);
		c.add(cntpan);
	}
public static void main(String[] args) {
		
		SearchDialog sa=new SearchDialog();
		sa.setVisible(true);
		sa.setSize(400, 200);
		sa.setResizable(true);
		
		
	}

}*/