package OnlineReservationSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JButton;
import javax.swing.JPanel;

class Painter extends JPanel implements ActionListener {
    JButton b1;
    private static final long serialVersionUID = 1L;
    private static final PropertyChangeSupport pcs = new PropertyChangeSupport(new Object());
    private static boolean userLoggedIn = false;

    String finalName, finalSrcStation, finalDesStation, finalTime, finalPrice;
    Long finalPrnNo, finalPhoneNo;


    Painter(){
        b1 = new JButton();
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        add(b1);
        b1.addActionListener(this);
        b1.setText("< Back");
        b1.setBounds(20, 50, 250, 50);
        setUserLoggedIn(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(200, 150, 650, 350);
        g.drawRect(200, 150, 275, 75);
        g.drawRect(550, 400, 275, 75);
        g.drawString("Prn No"+finalPrnNo, 230, 170);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        setUserLoggedIn(true);
    }

    public void getValues(String Name,String SrcStation,String DesStation,String Time,Long PrnNo,Long PhoneNo, String Price){
        finalName = Name;
        finalSrcStation = SrcStation;
        finalDesStation = DesStation;
        finalTime = Time;
        finalPrnNo = PrnNo;
        finalPhoneNo = PhoneNo;
        finalPrice = Price;
    }

    public static void setUserLoggedIn(boolean loggedIn) {
        boolean oldValue = userLoggedIn;
        userLoggedIn = loggedIn;
        pcs.firePropertyChange("userLoggedIn", oldValue, userLoggedIn);
    }

    public static boolean isUserLoggedIn() {
        return userLoggedIn;
    }

    public static void addLoginChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public static void removeLoginChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

}
