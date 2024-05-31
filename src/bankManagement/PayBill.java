package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PayBill extends GUI_Interface_2 {
    String accountNumber, pinNumber;
    double balance;
    JButton utility, creditCard, mobileTopUp, insaurance, ISP, back;
    JLabel title;
    PayBill(String accountNumber, String pinNumber){
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;

        getCurrentBalance(accountNumber, pinNumber);

        setTitle("Bill Payment");

        title = new JLabel("Choose the type of bill you want to pay");
        title.setBounds(320, 40, 500, 40);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.BLACK);
        add(title);

        utility = new JButton("Utility");
        utility.setBounds(410, 140, 200, 40);
        utility.setFont(new Font("Arial", Font.BOLD, 20));
        utility.addActionListener(this::performAction);
        utility.setForeground(Color.BLACK);
        add(utility);

        creditCard = new JButton("Credit Card");
        creditCard.setBounds(410, 220, 200, 40);
        creditCard.setFont(new Font("Arial", Font.BOLD, 20));
        creditCard.addActionListener(this::performAction);
        creditCard.setForeground(Color.BLACK);
        add(creditCard);

        mobileTopUp = new JButton("Mobile Top Up");
        mobileTopUp.setBounds(410, 300, 200, 40);
        mobileTopUp.setFont(new Font("Arial", Font.BOLD, 20));
        mobileTopUp.addActionListener(this::performAction);
        mobileTopUp.setForeground(Color.BLACK);
        add(mobileTopUp);

        insaurance = new JButton("Insurance");
        insaurance.setBounds(410, 380, 200, 40);
        insaurance.setFont(new Font("Arial", Font.BOLD, 20));
        insaurance.addActionListener(this::performAction);
        insaurance.setForeground(Color.BLACK);
        add(insaurance);

        ISP = new JButton("ISP");
        ISP.setBounds(410, 460, 200, 40);
        ISP.setFont(new Font("Arial", Font.BOLD, 20));
        ISP.addActionListener(this::performAction);
        ISP.setForeground(Color.BLACK);
        add(ISP);

        back = new JButton("Back");
        back.setBounds(410, 540, 200, 40);
        back.setFont(new Font("Arial", Font.BOLD, 20));
        back.addActionListener(this::performAction);
        back.setBackground(Color.GREEN);
        back.setForeground(Color.BLACK);
        add(back);

        revalidate();
        repaint();

    }

    public void performAction(ActionEvent ae){
        if (ae.getSource() == utility){
            String type = JOptionPane.showInputDialog("Enter the type of utility bill you want to pay: \n Water, Gas, Electricity or Cable.");
            if (type == null){
                return;
            }
            String accNumber = JOptionPane.showInputDialog("Enter the account number of the receiver: ");
            if (accNumber == null){
                return;
            }

            String amount = JOptionPane.showInputDialog("Enter the amount of the bill: ");
            if (amount == null){
                return;
            }

            double amount1 = Double.parseDouble(amount);
            if (amount1 > balance){
                JOptionPane.showMessageDialog(null, "Insufficient balance");
            } else {
                balance -= amount1;
                updateBalance(accountNumber, pinNumber, balance);
                updateTransactionHistory(accountNumber, amount1, balance, "Utility Bill paid for " + type + " to account number: " + accNumber);
                JOptionPane.showMessageDialog(null, "Bill paid successfully");
            }
        } else if (ae.getSource() == creditCard){
            String cardNumber = JOptionPane.showInputDialog("Enter the credit card number: \n XXXX-XXXX-XXXX-XXXX");
            if (!cardNumber.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}")){
                JOptionPane.showMessageDialog(null, "Invalid card number");
                return;
            }
            if (cardNumber == null){
                return;
            }

            String amount = JOptionPane.showInputDialog("Enter the amount of the bill: ");
            if (amount == null){
                return;
            }

            double amount1 = Double.parseDouble(amount);
            if (amount1 > balance){
                JOptionPane.showMessageDialog(null, "Insufficient balance");
            } else {
                balance -= amount1;
                updateBalance(accountNumber, pinNumber, balance);
                updateTransactionHistory(accountNumber, amount1, balance, "Credit Card Bill paid for card number: " + cardNumber);
                JOptionPane.showMessageDialog(null, "Bill paid successfully");
            }
        } else if (ae.getSource() == mobileTopUp){
            String phoneNumber = JOptionPane.showInputDialog("Enter the phone number: \n 01XXXXXXXXX");
            if (!phoneNumber.matches("01\\d{9}")){
                JOptionPane.showMessageDialog(null, "Invalid phone number");
                return;
            }
            if (phoneNumber == null){
                return;
            }

            String amount = JOptionPane.showInputDialog("Enter the amount: ");
            if (amount == null){
                return;
            }

            double amount1 = Double.parseDouble(amount);
            if (amount1 > balance){
                JOptionPane.showMessageDialog(null, "Insufficient balance");
            } else {
                balance -= amount1;
                updateBalance(accountNumber, pinNumber, balance);
                updateTransactionHistory(accountNumber, amount1, balance, "Mobile Top Up to phone number: " + phoneNumber);
                JOptionPane.showMessageDialog(null, "Bill paid successfully");
            }
        } else if (ae.getSource() == insaurance){
            String policyNumber = JOptionPane.showInputDialog("Enter your 6 digit policy number: ");
            if (!policyNumber.matches("\\d{6}")){
                JOptionPane.showMessageDialog(null, "Invalid policy number");
                return;
            }
            if (policyNumber == null){
                return;
            }

            String amount = JOptionPane.showInputDialog("Enter the amount: ");
            if (amount == null){
                return;
            }

            double amount1 = Double.parseDouble(amount);
            if (amount1 > balance){
                JOptionPane.showMessageDialog(null, "Insufficient balance");
            } else {
                balance -= amount1;
                updateBalance(accountNumber, pinNumber, balance);
                updateTransactionHistory(accountNumber, amount1, balance, "Insurance Bill paid to policy number: " + policyNumber );
                JOptionPane.showMessageDialog(null, "Bill paid successfully");
            }
        } else if (ae.getSource() == ISP){
            String ISPname = JOptionPane.showInputDialog("Enter the name of the ISP: ");
            if (ISPname == null){
                return;
            }

            String ISP_ID = JOptionPane.showInputDialog("Enter your 4 digits ISP ID: ");
            if (!ISP_ID.matches("\\d{4}")){
                JOptionPane.showMessageDialog(null, "Invalid ISP ID");
                return;
            }
            if (ISP_ID == null){
                return;
            }

            String amount = JOptionPane.showInputDialog("Enter the amount: ");
            if (amount == null){
                return;
            }

            double amount1 = Double.parseDouble(amount);
            if (amount1 > balance){
                JOptionPane.showMessageDialog(null, "Insufficient balance");
            } else {
                balance -= amount1;
                updateBalance(accountNumber, pinNumber, balance);
                updateTransactionHistory(accountNumber, amount1, balance, "ISP Bill paid to ISP: " + ISPname + " ISP_ID: " + ISP_ID);
                JOptionPane.showMessageDialog(null, "Bill paid successfully");
            }
        } else if (ae.getSource() == back){
            new Home_Page(accountNumber, pinNumber).setVisible(true);
            setVisible(false);
        }
    }

    public void updateBalance(String accountNumber, String pinNumber, double balance) {
        try {
            File inputFile = new File("src/bankManagement/Signup.txt");
            File tempFile = new File("src/bankManagement/SignupTemp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            String currentAccountNumber = null;
            String currentPin = null;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts[0].equals("Account Number")) {
                    currentAccountNumber = parts[1];
                } else if (parts[0].equals("Pin Number")) {
                    currentPin = parts[1];
                } else if (parts[0].equals("Balance") && currentAccountNumber.equals(accountNumber) && currentPin.equals(pinNumber)) {
                    line = "Balance: " + balance;
                }
                writer.write(line + System.lineSeparator());
            }

            reader.close();
            writer.close();

            if (!inputFile.delete()) {
                JOptionPane.showMessageDialog(null, "Could not delete original file");
                return;
            }

            if (!tempFile.renameTo(inputFile)) {
                JOptionPane.showMessageDialog(null, "Could not rename temporary file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateTransactionHistory(String accountNumber, double amount, double balance, String status){
        String accountNumber1 = accountNumber;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/accountManager/" + accountNumber1 + ".txt", true));

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = now.format(formatter);

            writer.write("Bill: \tTk " + amount + "\t" + formatDateTime + "\t" + balance + "\t" + status);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new PayBill(" ", " ");
    }
}
