import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numberbutton = new JButton[10];
    JButton[] functionbutton = new JButton[9];
    JButton add, sub, multi, div;
    JButton dec, equal, del, clr, neg;
    JPanel panel;

    Font font = new Font("Ink Free",Font.BOLD,32);

    double num1=0,num2=0,result=0;
    char operator;
   Main(){

       frame = new JFrame("Calculator");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(480,600);
       frame.setLayout(null);

       textfield = new JTextField();
       textfield.setBounds(50,20,350,50);
       textfield.setBackground(Color.lightGray);
       textfield.setBorder(BorderFactory.createLineBorder(Color.black));
       textfield.setFont(font);
       textfield.setEditable(false);

       add = new JButton("+");
       sub = new JButton("-");
       multi = new JButton("*");
       div = new JButton("/");
       dec = new JButton(".");
       equal = new JButton("=");
       del = new JButton("Delete");
       clr = new JButton("Clear");
       neg = new JButton("(-)");

       functionbutton[0] = add;
       functionbutton[1] = sub;
       functionbutton[2] = multi;
       functionbutton[3] = div;
       functionbutton[4] = dec;
       functionbutton[5] = equal;
       functionbutton[6] = del;
       functionbutton[7] = clr;
       functionbutton[8] = neg;

       for (int i =0;i<9;i++){
           functionbutton[i].addActionListener(this);
           functionbutton[i].setFont(font);
           functionbutton[i].setFocusable(false);
       }

       for (int i =0;i<10;i++){
           numberbutton[i] = new JButton(String.valueOf(i));
           numberbutton[i].addActionListener(this);
           numberbutton[i].setFont(font);
           numberbutton[i].setFocusable(false);
       }

       neg.setBounds(50,480,75,50);
       del.setBounds(132,480,130,50);
       clr.setBounds(268,480,130,50);

       panel = new JPanel();
       panel.setBounds(50,100,350,350);
       panel.setLayout(new GridLayout(4,4,10,10));
       //panel.setBackground(Color.GRAY);
       panel.add(numberbutton[1]);
       panel.add(numberbutton[2]);
       panel.add(numberbutton[3]);
       panel.add(add);
       panel.add(numberbutton[4]);
       panel.add(numberbutton[5]);
       panel.add(numberbutton[6]);
       panel.add(sub);
       panel.add(numberbutton[7]);
       panel.add(numberbutton[8]);
       panel.add(numberbutton[9]);
       panel.add(multi);
       panel.add(dec);
       panel.add(numberbutton[0]);
       panel.add(equal);
       panel.add(div);


       frame.add(panel);
       frame.add(neg);
       frame.add(del);
       frame.add(clr);
       frame.add(textfield);
       frame.setVisible(true);


       frame.add(textfield);


       frame.setVisible(true);


   }

    public static void main(String[] args) {

        Main calc = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for(int i =0; i<10;i++){

           if(e.getSource()==numberbutton[i]){
               textfield.setText(textfield.getText().concat(String.valueOf(i)));
           }
       }
       if(e.getSource()==dec){
           textfield.setText(textfield.getText().concat("."));
       }
       if(e.getSource()==add){
           num1=Double.parseDouble(textfield.getText());
           operator = '+';
           textfield.setText("");
        }
        if(e.getSource()==sub){
            num1=Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource()==multi){
            num1=Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource()==div){
            num1=Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource()==equal){
            num2 = Double.parseDouble(textfield.getText());

            switch (operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clr){
            textfield.setText("");
        }
        if(e.getSource()==del){
            String str = textfield.getText();
            textfield.setText("");
            for (int i = 0;i<str.length()-1;i++){
                textfield.setText(textfield.getText()+str.charAt(i));
            }
        }
        if(e.getSource()==neg){
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }

    }
}