package project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class note extends JFrame implements KeyListener {

    JLabel l;
    JTextArea area;
    note(){
        l= new JLabel();
        l.setBounds(150, 10,200,30);

        area= new JTextArea();
        area.setBounds(50,50, 400, 400);

        area.setFont(new Font("Times new roman", Font.BOLD, 30));
        area.addKeyListener(this);
        setBackground(Color.BLACK);
        setSize(500, 500);
        add(l); add(area);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Creating a string by fetching the text from TextArea
      String s= area.getText();

      // Creating String 'word' which will get substrings of 's' , Substring will be given as an array to 'word'
      //    Substring will be decided whenever space is added to string.
        String word[]= s.split("\\s");

        // Printing words and characters of text area.
        l.setText ("Words: " + word.length + " Characters:" + s.length());
    }
}

public class Word_counter {
    public static void main(String[] args) {
     new note();
    }
}
