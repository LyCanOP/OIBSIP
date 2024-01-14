package GuessNo;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainGuesserGame extends JFrame {

    JLabel l1,l2,l3,l4;
    JButton b1,b2,b3;
    DefaultComboBoxModel<String> dificulty,noOfGuess;
    JComboBox<String> diffculty,noOfGuesses;

    private String highScore;
    private int[] highScores;
    private int currentLevel;//will store how many choices are selected + diffculty
    private static final String FILE_NAME = "data.txt";


    MainGuesserGame(){
        setVisible(true);
        setSize(1280,720);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Guess the number Game");
        getContentPane().setBackground(Color.red);

        setState(JFrame.ICONIFIED);
        setState(JFrame.NORMAL);

        highScores = new int[4];
        getHighScoreFromFile();
        

        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();

        String[] temp = {"Easy(0-99)","Medium(0-999)","Hard(0-9999)"};
        dificulty = new DefaultComboBoxModel<>(temp);

        String[] temp2 = {"5","10","15","20","30","40"};
        noOfGuess = new DefaultComboBoxModel<>(temp2);

        diffculty = new JComboBox<>(dificulty);
        noOfGuesses = new JComboBox<>(noOfGuess);


        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        l4.setVisible(true);
        b1.setVisible(true);
        b2.setVisible(true);
        b3.setVisible(true);

        l1.setBounds(270, 100, 800, 200);
        l1.setText("Guess the Number");
        l1.setForeground(Color.cyan);
        l1.setFont(new Font("Comic Sans MS", 1, 80));

        l2.setBounds(500, 280, 200, 150);
        l2.setText("High Score : ");
        
        b1.setBounds(300, 300, 500, 200);
        b2.setBounds(300, 300, 500, 200);
        b1.setText("Hello");
        b2.setText("Hello");
        
        add(l1);
        add(l2);
        add(b1);
        add(b2);
    }

    private void getHighScoreFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int level = 1;
            while ((line = reader.readLine()) != null && level <= highScores.length) {
                int score = Integer.parseInt(line);
                highScores[level - 1] = score;
                level++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    void Homepage(){
        
    }
    public static void main(String[] args) {
        MainGuesserGame obj = new MainGuesserGame();
        
    }
}
