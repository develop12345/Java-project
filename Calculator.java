package project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calc extends JFrame implements ActionListener{

    JFrame frame= new JFrame();                                                //frame of calculator.
    JTextField text = new JTextField();                                       //textField to show operations and result.
    JButton[] numberButton= new JButton[10];                                 //Buttons for number 0 to 9.
    JButton[] functionButton= new JButton[9];                                // Buttons to perform function of calculator.
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equalButton, delButton, clrButton;
    JPanel panel= new JPanel();                                            //panel that will contain buttons.

    Font myFont= new Font("Times new roman", Font.BOLD, 30);  //font that can be reused.

    double num1=0, num2=0, result=0;                                   // numbers to perform operations and give result.
    char operator;                                                    // character that will shows different operator.

    // constructor
    Calc() {

        text.setBounds(50,25,300,50);
        text.setFont(myFont);
        text.setForeground(Color.green);
        text.setBackground(Color.BLACK);
        text.setEditable(false);


        //creating object of buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("DLT");
        clrButton = new JButton("CLR");

        // setting button objects on JButton array of functionButton object according to index.
        functionButton[0]= addButton;
        functionButton[1]= subButton;
        functionButton[2]= mulButton;
        functionButton[3]= divButton;
        functionButton[4]= decButton;
        functionButton[5]= equalButton;
        functionButton[6]= delButton;
        functionButton[7]= clrButton;

        // adding action listener to functionButton arrays so that we can perform actions when we click on function buttons .
        for(int i=0; i<8; i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }

        // now setting numberButtons array
        for(int i=0; i<10; i++){
            numberButton[i]= new JButton(String.valueOf(i));   // creating number button objects and assigning it to indexes of numberButton.
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }

        //setting bounds and position of delete and clear button.
        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        // creating panel that will contain our function and number buttons.
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4, 4,10,10));  //grid layout will make layouts for our buttons in which we have 4 rows and columns

        panel.setBackground(Color.BLACK);
        //now adding buttons to panel we have to add them in order in which we want to arrange them in calculator.
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equalButton);
        panel.add(divButton);

        this.add(panel);
        this.add(delButton);
        this.add(clrButton);
        this.add(text);
        this.setTitle("Calc by SHYAM");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(420,550);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLACK);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0; i<10; i++){
            if(e.getSource()==numberButton[i]){
                text.setText(text.getText().concat(String.valueOf(i)));
                //if we click on number button than text field will get the value of that number.
            }
        }
        if(e.getSource()==decButton){
            text.setText(text.getText().concat("."));
        }
        if(e.getSource()==addButton){
           num1= Double.parseDouble(text.getText());
           operator='+';
           text.setText("");
           // Now if we click on + button it will assign as operator + and text on the text field get empty.
        }
        if(e.getSource()==subButton){
            num1= Double.parseDouble(text.getText());
            operator='-';
            text.setText("");
        }
        if(e.getSource()==mulButton){
            num1= Double.parseDouble(text.getText());
            operator='*';
            text.setText("");
        }
        if(e.getSource()==divButton){
            num1= Double.parseDouble(text.getText());
            operator='/';
            text.setText("");
        }
        if(e.getSource()==equalButton){
            num2= Double.parseDouble(text.getText());
           switch (operator){
               case '+':
                   result= num1+num2;
                   break;
               case'-':
                   result= num1-num2;
                   break;
               case'*':
                   result= num1*num2;
                   break;
               case'/':
                   result= num1/num2;
                   break;
           }
           text.setText(String.valueOf(result));
           num1=result;
        }

        if(e.getSource()==clrButton){
            text.setText(""); // to clear the string.
        }
       if(e.getSource()==delButton){
           String string= text.getText(); //this string will contain our text
           text.setText("");              //this will clear text
           for(int i=0; i<string.length()-1; i++){
               text.setText(text.getText()+string.charAt(i));  //this will get text one smaller than string length.
           }
       }
    }
}

public class Calculator {
    public static void main(String[] args) {
        Calc project= new Calc();
    }
}
