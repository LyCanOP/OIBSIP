package ATMInterface;

import java.awt.Color;

import javax.swing.JFrame;

public class ATMInterface extends JFrame {
    ATMInterface(){
        setTitle("ATM INTERFACE");
        setSize(1080,720);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
    }
}
