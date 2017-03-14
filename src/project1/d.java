package project1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class d extends JFrame {
  public d() {
    setSize(300, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final JTextArea textArea = new JTextArea();
    textArea.setText("Click Me!");

    textArea.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.NOBUTTON) {
          textArea.setText("No button clicked...");
        } else if (e.getButton() == MouseEvent.BUTTON1) {
          textArea.setText("Button 1 clicked...");
        } else if (e.getButton() == MouseEvent.BUTTON2) {
          textArea.setText("Button 2 clicked...");
        } else if (e.getButton() == MouseEvent.BUTTON3) {
          textArea.setText("Button 3 clicked...");
        }

        System.out.println("Number of click: " + e.getClickCount());
        System.out.println("Click position (X, Y):  " + e.getX() + ", " + e.getY());
      }
    });

    getContentPane().add(textArea);
  }

  public static void main(String[] args) {
    new d().setVisible(true);
  } }