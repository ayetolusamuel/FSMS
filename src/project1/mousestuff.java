package project1;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class mousestuff extends JFrame {

	private JPanel mousepanel;
	private JLabel statusbar;
	
	mousestuff(){
		
		super("Title");
		
		mousepanel=new JPanel();
		mousepanel.setBackground(Color.white);
		add(mousepanel,BorderLayout.CENTER);
		
		statusbar=new JLabel("default");
		
		add(statusbar,BorderLayout.SOUTH);
		Handlerclass handler=new Handlerclass();
		mousepanel.addMouseListener(handler);
		mousepanel.addMouseMotionListener(handler);
	}
	private class Handlerclass implements MouseListener,MouseMotionListener{
		public void mouseClicked(MouseEvent event){
			statusbar.setText(String.format("Clicked at %d,%d",event.getX(),event.getY()));
			JOptionPane.showMessageDialog(null,"Password Accepted...","Welcome to the System",JOptionPane.WARNING_MESSAGE);
		}
		
		
		public void mousePressed(MouseEvent event){
			statusbar.setText("you pressed down the mouse ");
			
		}
		public void mouseRelease(MouseEvent event){
			statusbar.setText("You released the Button");
		}
		
		public void mouseEntered(MouseEvent event){
			statusbar.setText("You entered the area");
			mousepanel.setBackground(Color.red);
			System.out.println("i love you");
		}
		public void mouseExited(MouseEvent event){
			statusbar.setText("the mouse has left the window");
			mousepanel.setBackground(Color.white);
		}
		public void mouseDragged(MouseEvent event){
			statusbar.setText("you dragging  the mouse ");
		}
		
		public void mouseMoved(MouseEvent event){
			statusbar.setText("you are moving the mouse ");
		}


		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static void main(String[] args) {
		mousestuff sa=new mousestuff();
		sa.setVisible(true);
		sa.setSize(500,500);
		sa.setLocation(100,100);
		
		
		
	}
	
	
	
	
	
}
