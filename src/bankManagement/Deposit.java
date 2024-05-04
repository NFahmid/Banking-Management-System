package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Deposit extends JFrame {
    JLabel depositAmount;
    JTextField depositAmountText;
    JButton deposit, back;
    String accountNumber, pinNumber;

    Deposit(String accountNumber, String pinNumber){
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon backgroundImage = new ImageIcon("src/icons/transactions.jpg");
        Image img = backgroundImage.getImage().getScaledInstance(1080, 720, Image.SCALE_DEFAULT);
        ImageIcon background = new ImageIcon(img);

        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1080, 720);

        add(backgroundLabel);

        depositAmount = new JLabel("Enter the amount you want to deposit:");
        depositAmount.setFont(new Font("Raleway", Font.BOLD, 22));
        depositAmount.setForeground(Color.BLACK);
        depositAmount.setBounds(300, 200, 600, 50);
        backgroundLabel.add(depositAmount);

        depositAmountText = new JTextField();
        depositAmountText.setBounds(300, 300, 420, 50);
        backgroundLabel.add(depositAmountText);

        deposit = new JButton("DEPOSIT");
        deposit.setBackground(Color.GREEN);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Raleway", Font.BOLD, 20));
        deposit.setBounds(300, 400, 150, 30);
        deposit.addActionListener(this::actionPerformed);
        backgroundLabel.add(deposit);

        back = new JButton("BACK");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.setBounds(570, 400, 150, 30);
        back.addActionListener(this::actionPerformed);
        backgroundLabel.add(back);

        setSize(1080, 720);
        setLocation(220, 40);
        setVisible(true);

    }

    public void actionPerformed(java.awt.event.ActionEvent ae){
        if (ae.getSource() == deposit){
            String amount = depositAmountText.getText();
            if (amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                String currentBalance = getCurrentBalance(accountNumber, pinNumber);
                if (currentBalance == null) {
                    JOptionPane.showMessageDialog(null, "Could not retrieve current balance");
                } else {
                    try {
                        Double currentBalanceInt = Double.parseDouble(currentBalance);
                        Double amountInt = Double.parseDouble(amount);
                        String newBalance = String.valueOf(currentBalanceInt + amountInt);
                        updateBalance(accountNumber, pinNumber, newBalance);

                        JOptionPane.showMessageDialog(null, "Amount deposited successfully");
                        this.setVisible(false);
                        new Home_Page(accountNumber, pinNumber).setVisible(true);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid number format");
                    }
                }
            }
        } else if (ae.getSource() == back){
            this.setVisible(false);
            new Home_Page(accountNumber, pinNumber).setVisible(true);
        }
    }

    public String getCurrentBalance(String accountNumber, String pinNumber) {
        File signupFile = new File("src/bankManagement/Signup.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(signupFile));

            String currentLine;
            String currentAccountNumber = null;
            String currentPinNumber = null;

            while((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(": ");
                if (parts.length >= 2) {
                    String key = parts[0];
                    String value = parts[1];

                    if (key.equals("Account Number")) {
                        currentAccountNumber = value;
                    } else if (key.equals("Pin Number")) {
                        currentPinNumber = value;
                    } else if (key.equals("Balance") && currentAccountNumber.equals(accountNumber) && currentPinNumber.equals(pinNumber)) {
                        return value;
                    }
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateBalance(String accountNumber, String pinNumber, String newBalance) {
        File signupFile = new File("src/bankManagement/Signup.txt");

        try {
            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(signupFile));

            String currentLine;
            String currentAccountNumber = null;
            String currentPinNumber = null;

            while((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(": ");
                if (parts.length >= 2) {
                    String key = parts[0];
                    String value = parts[1];

                    if (key.equals("Account Number")) {
                        currentAccountNumber = value;
                    } else if (key.equals("Pin Number")) {
                        currentPinNumber = value;
                    } else if (key.equals("Balance") && currentAccountNumber.equals(accountNumber) && currentPinNumber.equals(pinNumber)) {
                        currentLine = "Balance: " + newBalance;
                    }
                }
                lines.add(currentLine);
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(signupFile));
            for (String line : lines) {
                writer.write(line + System.getProperty("line.separator"));
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("", "").setVisible(true);
    }
}
