package project1;


/************************************************
 *
 * Author: <Ayetolu_Samuel_Setonji>
 * Assignment: <Date Example(DateChooser)>
 * Class: <DateExample>
 *
 ************************************************/

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class DateExample extends JFrame {

	private JPanel pane;

	public DateExample() {
		pane = new JPanel();
		pane.setLayout(null);
		JDateChooser sam1 = new JDateChooser();
		sam1.setToolTipText("Select the date");

		pane.add(sam1).setBounds(10, 50, 120, 15);

		getContentPane().add(pane, BorderLayout.CENTER);

		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DateExample sam = new DateExample();
		sam.setVisible(true);
		sam.setSize(200, 300);
		sam.setLocationRelativeTo(null);
	}
}
