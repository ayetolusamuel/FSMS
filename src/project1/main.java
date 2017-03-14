package project1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class main {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Demo Frame/SuRu");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        final JLabel jLabel = new JLabel();
        final JComboBox box = new JComboBox();
        box.addItem("");
        box.addItem("Item 1");
        box.addItem("Item 2");
        box.addItem("Item 3");
        box.addItem("Item 4");
        box.addItem("Item 5");
        box.addItem("Item 6");
        box.addItem("Item 7");
        box.addItem("Item 8");
        box.addItem("Item 9");
        box.addItem("Item 10");
        contentPane.add(new JLabel("Select Here: "));
        contentPane.add(box);
        contentPane.add(new JLabel("Seleced Item: "));
        contentPane.add(jLabel);
        box.addItemListener(new ItemListener() {

          

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 400, 100);
        frame.setVisible(true);
    }
}