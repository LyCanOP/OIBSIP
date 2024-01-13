package GuessNo;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainGuesserGame extends JFrame {

    JLabel l1,l2,l3,l4;
    JButton b1,b2,b3;

    MainGuesserGame(){
        this.setVisible(true);
        this.setSize(1280,720);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Guess the number Game");
        this.getContentPane().setBackground(Color.CYAN);

        this.setState(JFrame.ICONIFIED);
        this.setState(JFrame.NORMAL);

        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();
        
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        l4.setVisible(true);
        b1.setVisible(true);
        b2.setVisible(true);
        b3.setVisible(true);

        l1.setBounds(300, 300, 500, 200);
        l1.setText("Hello");
        this.add(l1);
    }

    void Homepage(){
        
    }
    public static void main(String[] args) {
        MainGuesserGame obj = new MainGuesserGame();
        
    }
}
