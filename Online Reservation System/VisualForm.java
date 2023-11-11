package OnlineReservationSystem;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VisualForm extends JFrame implements ActionListener {

    JFrame frame;
    JPanel headingName, displayPanel;
    JLabel title, l1, l2, l3, l4, l5, l6;
    JButton b1, b2, b3, b4, b5, b6;
    JTextField t1, t2, t3, t4, t5, t6;
    JPasswordField passwordField;
    DefaultComboBoxModel<String> comboBoxModel1, comboBoxModel2;
    JComboBox<String> trains1, trains2;

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);
    private static final String DATABASE_URL_Users = "jdbc:ucanaccess://D:/EDUCATION/INTERNSHIP/OASIS INFOBYTE/OnlineReservationSystem/Users.accdb";
    private static final String DATABASE_URL_Trains = "jdbc:ucanaccess://D:/EDUCATION/INTERNSHIP/OASIS INFOBYTE/OnlineReservationSystem/Train.accdb";
    private static final String INSERT_QUERY_Users = "INSERT INTO Users (Name, Username, Email, Password) VALUES (?, ?, ?, ?)";
    private static final String SELECT_QUERY_Users = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
    String fromStation, toStation;

    VisualForm() {
        // Main frame
        frame = new JFrame("Online Reservation System");
        frame.setSize(1080, 720);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Heading (ONLINE RESERVATION WITH BLACK BACKGROUND)
        headingName = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headingName.setBackground(Color.BLACK);

        title = new JLabel("ONLINE    RESERVATION    SYSTEM");
        title.setFont(new Font("Courier", Font.PLAIN, 40));
        title.setForeground(Color.WHITE);

        headingName.add(title);
        // Heading Finished

        frame.add(headingName, BorderLayout.NORTH);

        displayPanel = new JPanel(null);
        displayPanel.setBackground(Color.DARK_GRAY);
        displayPanel.setPreferredSize(new Dimension(1080, 720));
        displayPanel.setVisible(true);
        this.initlizeAndAddElements();
    }

    public void createLoginPage() {

        // setting buttons for login/signup
        b1.setText("Login");
        b2.setText("New User, Sign Up?");

        // initializing text-fields;
        l1.setText("Enter Name");
        l2.setText("Enter Password");

        b1.setVisible(true);
        b2.setVisible(true);
        l1.setVisible(true);
        l2.setVisible(true);
        t1.setVisible(true);
        passwordField.setVisible(true);

        b1.setBounds(450, 350, 150, 50);
        b2.setBounds(450, 450, 150, 50);
        t1.setBounds(550, 100, 170, 35);
        passwordField.setBounds(550, 200, 170, 35);
        l1.setBounds(300, 100, 250, 35);
        l2.setBounds(300, 200, 250, 35);

        frame.add(displayPanel, BorderLayout.CENTER);
        frame.setState(Frame.ICONIFIED);
        frame.setState(Frame.NORMAL);

    }

    private void initlizeAndAddElements() {

        passwordField = new JPasswordField();

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();

        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();
        b4 = new JButton();
        b5 = new JButton();
        b6 = new JButton();

        // adding action listener
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        l5 = new JLabel();
        l6 = new JLabel();

        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Courier", Font.PLAIN, 20));
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Courier", Font.PLAIN, 20));
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Courier", Font.PLAIN, 20));
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Courier", Font.PLAIN, 20));
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("Courier", Font.PLAIN, 20));
        l6.setForeground(Color.WHITE);
        l6.setFont(new Font("Courier", Font.PLAIN, 20));

        comboBoxModel1 = new DefaultComboBoxModel<>();
        comboBoxModel1.addElement("------------Select------------");
        comboBoxModel1.addElement("Mumbai");
        comboBoxModel1.addElement("Pune");
        comboBoxModel1.addElement("Nashik");
        comboBoxModel2 = new DefaultComboBoxModel<>();
        comboBoxModel2.addElement("------------Select------------");
        comboBoxModel2.addElement("Mumbai");
        comboBoxModel2.addElement("Pune");
        comboBoxModel2.addElement("Nashik");
        trains1 = new JComboBox<>(comboBoxModel1);
        trains2 = new JComboBox<>(comboBoxModel2);

        trains1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fromStation = trains1.getSelectedItem().toString();
            }
        });
        trains2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toStation = trains2.getSelectedItem().toString();
            }
        });

        displayPanel.add(passwordField);

        displayPanel.add(b1);
        displayPanel.add(b2);
        displayPanel.add(b3);
        displayPanel.add(b4);
        displayPanel.add(b5);
        displayPanel.add(b6);

        displayPanel.add(t1);
        displayPanel.add(t2);
        displayPanel.add(t3);
        displayPanel.add(t4);
        displayPanel.add(t5);
        displayPanel.add(t6);

        displayPanel.add(l1);
        displayPanel.add(l2);
        displayPanel.add(l3);
        displayPanel.add(l4);
        displayPanel.add(l5);
        displayPanel.add(l6);

        displayPanel.add(trains1);
        displayPanel.add(trains2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value = e.getActionCommand();
        System.out.println(value);
        switch (value) {
            case "Login":
                if (!t1.getText().isEmpty()) {
                    if (checkLogin()) {
                        System.out.println("Pass");
                        this.setInvisible();
                        this.Homepage();
                    } else if (t1.getText().equals("Admin") && t2.getText().equals("yes")) {
                        this.AdminPage();
                    }
                }

                break;

            case "New User, Sign Up?":
                this.setInvisible();
                this.signupPage();
                break;
            case "Sign Up":
                if (!signUpValidate()) {
                    System.out.println("Fail");
                    break;
                }
                this.addUser();
            case "Cancel return Login Page":
                this.setInvisible();
                this.createLoginPage();
                break;
            case "Search Train":
                this.setInvisible();
                this.searchTrain();
                break;
            case "Go":
                this.searchTrain(fromStation, toStation);
                break;
            default:
                break;
        }
    }

    private void searchTrain(String fromStation2, String toStation2) {
        if (!fromStation2.equals(toStation2)) {
            l3.setVisible(false);
            try {
                Connection connection = DriverManager.getConnection(DATABASE_URL_Trains);

                fetchTrainData(connection, fromStation2, toStation2);

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            l3.setText("Same Soucre and Destination");
            l3.setVisible(true);
            l3.setBounds(350, 375, 250, 50);
        }
    }

    private void searchTrain() {
        l1.setVisible(true);
        l2.setVisible(true);
        trains1.setVisible(true);
        trains2.setVisible(true);
        b1.setVisible(true);

        l1.setText("From : ");
        l2.setText("To : ");
        b1.setText("Go");

        l1.setBounds(300, 150, 250, 50);
        trains1.setBounds(450, 150, 250, 50);
        l2.setBounds(300, 225, 250, 50);
        trains2.setBounds(450, 225, 250, 50);
        b1.setBounds(350, 300, 250, 50);

    }

    private boolean checkLogin() {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL_Users);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY_Users);
            preparedStatement.setString(1, t1.getText());
            preparedStatement.setString(2, new String(passwordField.getPassword()));

            ResultSet resultSet = preparedStatement.executeQuery();

            boolean isValidLogin = resultSet.next();

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return isValidLogin;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void addUser() {
        String name = t1.getText();
        String username = t2.getText();
        String email = t3.getText();
        String password = t4.getText();

        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL_Users);

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY_Users);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert data.");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private boolean signUpValidate() {
        if (!t1.getText().isEmpty()) {
            if (!t2.getText().isEmpty()) {
                if (!t3.getText().isEmpty() && emailValidate()) {
                    if (!t4.getText().isEmpty() && !t5.getText().isEmpty() && t4.getText().equals(t5.getText())) {
                        return true;
                    } else {
                        System.out.println("Password does not match");
                        return false;
                    }
                } else {
                    System.out.println("Email wrong");
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean emailValidate() {
        Matcher matcher = pattern.matcher(t3.getText());
        return matcher.matches();
    }

    private void setInvisible() {
        passwordField.setVisible(false);

        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);
        b4.setVisible(false);
        b5.setVisible(false);
        b6.setVisible(false);

        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        l5.setVisible(false);
        l6.setVisible(false);

        t1.setVisible(false);
        t2.setVisible(false);
        t3.setVisible(false);
        t4.setVisible(false);
        t5.setVisible(false);
        t6.setVisible(false);

        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");

        trains1.setVisible(false);
        trains2.setVisible(false);
    }

    private void signupPage() {

        l1.setBounds(300, 50, 250, 35);
        l2.setBounds(300, 100, 250, 35);
        l3.setBounds(300, 150, 250, 35);
        l4.setBounds(300, 200, 250, 35);
        l5.setBounds(300, 250, 250, 35);

        t1.setBounds(500, 50, 250, 35);
        t2.setBounds(500, 100, 250, 35);
        t3.setBounds(500, 150, 250, 35);
        t4.setBounds(500, 200, 250, 35);
        t5.setBounds(500, 250, 250, 35);

        b1.setBounds(400, 350, 250, 50);
        b2.setBounds(400, 450, 250, 50);
        b1.setVisible(true);
        b2.setVisible(true);

        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        l4.setVisible(true);
        l5.setVisible(true);

        t1.setVisible(true);
        t2.setVisible(true);
        t3.setVisible(true);
        t4.setVisible(true);
        t5.setVisible(true);

        l1.setText("Enter Name : ");
        l2.setText("Enter Username : ");
        l3.setText("Enter Email : ");
        l4.setText("Enter Password : ");
        l5.setText("Comfirm Password : ");

        b1.setText("Sign Up");
        b2.setText("Cancel return Login Page");

    }

    private void AdminPage() {
        b1.setVisible(true);
        b2.setVisible(true);
        b3.setVisible(true);
        b4.setVisible(true);
        b5.setVisible(true);

        b1.setText("Add Train");
        b2.setText("Delete Train");
        b3.setText("Update Train");
        b4.setText("Search Train");
        b5.setText("Logout");

        b1.setBounds(400, 100, 250, 50);
        b2.setBounds(400, 200, 250, 50);
        b3.setBounds(400, 300, 250, 50);
        b4.setBounds(400, 400, 250, 50);
        b5.setBounds(400, 500, 250, 50);
    }

    private void Homepage() {
        b1.setVisible(true);
        b2.setVisible(true);
        b3.setVisible(true);
        b4.setVisible(true);
        b5.setVisible(true);
        b6.setVisible(true);

        b1.setText("Search Train");
        b2.setText("Make a Reservation");
        b3.setText("Cancel Reservation");
        b4.setText("View Reserved Train Ticket");
        b5.setText("View all Trains");
        b6.setText("Logout");

        b1.setBounds(400, 50, 250, 50);
        b2.setBounds(400, 125, 250, 50);
        b3.setBounds(400, 200, 250, 50);
        b4.setBounds(400, 275, 250, 50);
        b5.setBounds(400, 350, 250, 50);
        b6.setBounds(400, 425, 250, 50);
    }

    private void fetchTrainData(Connection connection, String sourceStation, String destinationStation)
            throws SQLException {
        String query = "SELECT TrainID, TrainName, SourceStation, DestinationStation, Time1, Time2, Time3 " +
                "FROM TrainTable " +
                "WHERE SourceStation = ? AND DestinationStation = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sourceStation);
            preparedStatement.setString(2, destinationStation);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                l3.setVisible(true);
                l3.setText("No trains found for the given route.");
                l3.setBounds(350, 375, 450, 50);
            } else {

                System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%-20s\n", "TrainID", "TrainName", "SourceStation",
                        "DestinationStation", "Time1", "Time2", "Time3");
                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------");

                while (resultSet.next()) {
                    int trainID = resultSet.getInt("TrainID");
                    String trainName = resultSet.getString("TrainName");
                    String srcStation = resultSet.getString("SourceStation");
                    String destStation = resultSet.getString("DestinationStation");
                    Time t1 = resultSet.getTime("Time1");
                    Time t2 = resultSet.getTime("Time2");
                    Time t3 = resultSet.getTime("Time3");

                    System.out.printf("%-10d%-20s%-20s%-20s%-20s%-20s%-20s\n", trainID, trainName, srcStation, destStation,
                            t1, t2, t3);
                }
            }
        }
    }
}
