package ATMInterface;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

public class ATMInterface extends JFrame {
    private int amount;
    private static final String FILE_NAME = "D:\\GitHub\\REpos\\OIBSIP\\ATMInterface\\Data.txt";
    private String date,time;

    
    ATMInterface(){
        setTitle("ATM INTERFACE");
        setSize(1080,720);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);

        amount = getBalance();
        Date dateObj = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        
        date = dateFormat.format(dateObj);
        time = timeFormat.format(dateObj);

        System.out.println(date);
        System.out.println(time);
        
    }

    private int getBalance() {
        String line = "0";
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            line = reader.readLine();
            } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(line);
    }

    public static void main(String[] args) {
        new ATMInterface();
    }
}
