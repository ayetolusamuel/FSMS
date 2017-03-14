package project1;


import java.awt.event.*;
import java.awt.*;
class TextValid extends KeyAdapter
{
	public void keyTyped(KeyEvent e)
	{
		
	/*	char c = ke.getKeyChar ();
		
		if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_SPACE)) {

			if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
		            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c=='.'||c==',')) {
			
			 	getToolkit().beep ();
			ke.consume ();
		}
		}
}}
);
		
		
		
		
		*/
		
		
		
		
		
		
		
		char ch=e.getKeyChar();
		if (! ((Character.isAlphabetic (ch)) || (ch == KeyEvent.VK_BACK_SPACE)||ch==KeyEvent.VK_SPACE)) {

		if((ch >= 'a' && ch <='z')||(ch >='A' && ch <='Z'))
		{
		}
		else
		{
			 Toolkit.getDefaultToolkit().beep();
			e.consume();
		}
	}
}}