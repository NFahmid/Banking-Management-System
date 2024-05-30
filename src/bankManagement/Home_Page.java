package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Home_Page extends JFrame {
    JButton deposit, withdraw, viewBalance, transfer, pinChange, transactionHistory, viewProfile, logout, deleteAccount, loan, payBill;
    String pinNumber, accountNumber;
    Home_Page(String accountNumber, String pinNumber){
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;

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
        deposit.addActionListener(this::performAction);
        backgroundLabel.add(deposit);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBackground(Color.BLUE);
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 20));
        withdraw.setBounds(600, 150, 250, 50);
        withdraw.addActionListener(this::performAction);
        backgroundLabel.add(withdraw);

        viewBalance = new JButton("VIEW BALANCE");
        viewBalance.setBackground(Color.BLUE);
        viewBalance.setForeground(Color.WHITE);
        viewBalance.setFont(new Font("Raleway", Font.BOLD, 20));
        viewBalance.setBounds(200, 250, 250, 50);
        viewBalance.addActionListener(this::performAction);
        backgroundLabel.add(viewBalance);

        transfer = new JButton("TRANSFER");
        transfer.setBackground(Color.BLUE);
        transfer.setForeground(Color.WHITE);
        transfer.setFont(new Font("Raleway", Font.BOLD, 20));
        transfer.setBounds(600, 250, 250, 50);
        transfer.addActionListener(this::performAction);
        backgroundLabel.add(transfer);

        pinChange = new JButton("CHANGE PIN");
        pinChange.setBackground(Color.BLUE);
        pinChange.setForeground(Color.WHITE);
        pinChange.setFont(new Font("Raleway", Font.BOLD, 20));
        pinChange.setBounds(200, 350, 250, 50);
        pinChange.addActionListener(this::performAction);
        backgroundLabel.add(pinChange);

        transactionHistory = new JButton("TRANSACTION HISTORY");
        transactionHistory.setBackground(Color.BLUE);
        transactionHistory.setForeground(Color.WHITE);
        transactionHistory.setFont(new Font("Raleway", Font.BOLD, 15));
        transactionHistory.setBounds(600, 350, 250, 50);
        transactionHistory.addActionListener(this::performAction);
        backgroundLabel.add(transactionHistory);

        viewProfile = new JButton("VIEW PROFILE");
        viewProfile.setBackground(Color.BLUE);
        viewProfile.setForeground(Color.WHITE);
        viewProfile.setFont(new Font("Raleway", Font.BOLD, 20));
        viewProfile.setBounds(200, 450, 250, 50);
        viewProfile.addActionListener(this::performAction);
        backgroundLabel.add(viewProfile);

        logout = new JButton("LOGOUT");
        logout.setBackground(Color.BLUE);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Oswarld", Font.BOLD, 20));
        logout.setBounds(600, 450, 250, 50);
        logout.addActionListener(this::performAction);
        backgroundLabel.add(logout);

        deleteAccount = new JButton("DELETE ACCOUNT");
        deleteAccount.setBackground(Color.BLUE);
        deleteAccount.setForeground(Color.WHITE);
        deleteAccount.setFont(new Font("Oswarld", Font.BOLD, 20));
        deleteAccount.setBounds(400, 650, 250, 50);
        deleteAccount.addActionListener(this::performAction);
        backgroundLabel.add(deleteAccount);

        payBill = new JButton("PAY BILL");
        payBill.setBackground(Color.BLUE);
        payBill.setForeground(Color.WHITE);
        payBill.setFont(new Font("Oswarld", Font.BOLD, 20));
        payBill.setBounds(200, 550, 250, 50);
        payBill.addActionListener(this::performAction);
        backgroundLabel.add(payBill);

        loan = new JButton("LOAN");
        loan.setBackground(Color.BLUE);
        loan.setForeground(Color.WHITE);
        loan.setFont(new Font("Oswarld", Font.BOLD, 20));
        loan.setBounds(600, 550, 250, 50);
        loan.addActionListener(this::performAction);
        backgroundLabel.add(loan);

        setSize(1080, 760);
        setLocation(220, 20);
        setVisible(true);
    }

    public void performAction(java.awt.event.ActionEvent ae){

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
        } else if (ae.getSource() == deposit){
            new Deposit(accountNumber, pinNumber).setVisible(true);
            dispose();
        } else if (ae.getSource() == withdraw) {
            new Withdraw(accountNumber, pinNumber).setVisible(true);
            dispose();
        } else if (ae.getSource() == viewBalance){
            new View_Balance(accountNumber, pinNumber).setVisible(true);
            dispose();
        } else if (ae.getSource() == transfer){
            new Transfer_Cash(accountNumber, pinNumber).setVisible(true);
            dispose();
        } else if (ae.getSource() == transactionHistory){
            new Transaction_History(accountNumber, pinNumber).setVisible(true);
            dispose();
        } else if (ae.getSource() == viewProfile){
            new View_Profile(accountNumber, pinNumber).setVisible(true);
            dispose();
        } else if (ae.getSource() == deleteAccount){
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account? This action cannot be undone", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(response == JOptionPane.YES_OPTION) {
                new Delete_Account(accountNumber);
                new Login().setVisible(true);
                dispose();
            }
        } else if (ae.getSource() == loan){
            new Loan(accountNumber, pinNumber).setVisible(true);
            dispose();
        } else if (ae.getSource() == payBill){
            new PayBill(accountNumber, pinNumber).setVisible(true);
            dispose();
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
                    currentLine = "Pin Number: " + newPin;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

            if (!signupFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            if (!tempFile.renameTo(signupFile))
                System.out.println("Could not rename file");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Home_Page("", "");
    }
}
