package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Home_Page extends JFrame {
    JButton deposit, withdraw, viewBalance, transferHistory, pinChange, transactionHistory, viewProfile, logout;
    String pinNumber;
    Home_Page(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon backgroundImage = new ImageIcon("src/icons/transactions.jpg");
        Image img = backgroundImage.getImage().getScaledInstance(1080, 720, Image.SCALE_DEFAULT);
        ImageIcon background = new ImageIcon(img);


        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1080, 720);

        add(backgroundLabel);

        JLabel greeting = new JLabel("WELCOME TO AMAR BANK");
        greeting.setFont(new Font("Raleway", Font.BOLD, 38));
        greeting.setForeground(Color.BLUE);
        greeting.setBounds(300, 20, 600, 50);
        backgroundLabel.add(greeting);

        JLabel l1 = new JLabel("Select an option:");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setForeground(Color.BLUE);
        l1.setBounds(400, 80, 600, 50);
        backgroundLabel.add(l1);

        deposit = new JButton("DEPOSIT");
        deposit.setBackground(Color.BLUE);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("Raleway", Font.BOLD, 20));
        deposit.setBounds(200, 150, 250, 50);
        deposit.addActionListener(this::actionPerformed);
        backgroundLabel.add(deposit);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBackground(Color.BLUE);
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 20));
        withdraw.setBounds(600, 150, 250, 50);
        withdraw.addActionListener(this::actionPerformed);
        backgroundLabel.add(withdraw);

        viewBalance = new JButton("VIEW BALANCE");
        viewBalance.setBackground(Color.BLUE);
        viewBalance.setForeground(Color.WHITE);
        viewBalance.setFont(new Font("Raleway", Font.BOLD, 20));
        viewBalance.setBounds(200, 250, 250, 50);
        viewBalance.addActionListener(this::actionPerformed);
        backgroundLabel.add(viewBalance);

        transferHistory = new JButton("TRANSFER HISTORY");
        transferHistory.setBackground(Color.BLUE);
        transferHistory.setForeground(Color.WHITE);
        transferHistory.setFont(new Font("Raleway", Font.BOLD, 20));
        transferHistory.setBounds(600, 250, 250, 50);
        transferHistory.addActionListener(this::actionPerformed);
        backgroundLabel.add(transferHistory);

        pinChange = new JButton("CHANGE PIN");
        pinChange.setBackground(Color.BLUE);
        pinChange.setForeground(Color.WHITE);
        pinChange.setFont(new Font("Raleway", Font.BOLD, 20));
        pinChange.setBounds(200, 350, 250, 50);
        pinChange.addActionListener(this::actionPerformed);
        backgroundLabel.add(pinChange);

        transactionHistory = new JButton("TRANSACTION HISTORY");
        transactionHistory.setBackground(Color.BLUE);
        transactionHistory.setForeground(Color.WHITE);
        transactionHistory.setFont(new Font("Raleway", Font.BOLD, 20));
        transactionHistory.setBounds(600, 350, 250, 50);
        transactionHistory.addActionListener(this::actionPerformed);
        backgroundLabel.add(transactionHistory);

        viewProfile = new JButton("VIEW PROFILE");
        viewProfile.setBackground(Color.BLUE);
        viewProfile.setForeground(Color.WHITE);
        viewProfile.setFont(new Font("Raleway", Font.BOLD, 20));
        viewProfile.setBounds(200, 450, 250, 50);
        viewProfile.addActionListener(this::actionPerformed);
        backgroundLabel.add(viewProfile);

        logout = new JButton("LOGOUT");
        logout.setBackground(Color.BLUE);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Oswarld", Font.BOLD, 20));
        logout.setBounds(600, 450, 250, 50);
        logout.addActionListener(this::actionPerformed);
        backgroundLabel.add(logout);

        setSize(1080, 720);
        setLocation(220, 40);
        setVisible(true);
    }

    public void actionPerformed(java.awt.event.ActionEvent ae){

        if(ae.getSource() == logout){
            new Login().setVisible(true);
            dispose();
        } else if (ae.getSource() == pinChange) {
            String currentPin = JOptionPane.showInputDialog("Enter your current pin");
            if (!currentPin.equals(this.pinNumber)) {
                JOptionPane.showMessageDialog(null, "Entered current pin does not match with the pin of the logged-in user");
                return;
            }
            String newPin = JOptionPane.showInputDialog("Enter your new pin");
            changePin(currentPin, newPin);

            JOptionPane.showMessageDialog(null, "Pin changed successfully");
        }
    }

    public void changePin(String currentPin, String newPin) {
        File signupFile = new File("src/bankManagement/Signup.txt");
        File tempFile = new File("src/bankManagement/Temp.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/bankManagement/Signup.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/bankManagement/Temp.txt"));

            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                if(currentLine.contains("Pin Number: " + currentPin)) {
                    currentLine = currentLine.replace("Pin Number: " + currentPin, "Pin Number: " + newPin);
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Home_Page("");
    }
}
