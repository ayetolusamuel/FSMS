package project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AboutDialog extends JDialog
{
	JButton ok;
	AboutDialog()
	{
	//	super(JFrame.this,"About",true);
		setSize(200,200);
		setTitle("About");
		ok=new JButton("Ok");
		JPanel p=new JPanel();
		p.add(new JLabel("<html><font size=7 color=#00FFFF>Filling Station Management System <br> Developed By : Ayetolu Samuel Setonji"));
		add(p);
		add("South",ok);
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
	}
	public void paintComponent(Graphics g)
	{
		Image img=Toolkit.getDefaultToolkit().getImage("images//mainicon.gif");
		ImageIcon ic=new ImageIcon(img,"Center");
      	g.drawImage(img,20,30,20,30,null);
	}
}