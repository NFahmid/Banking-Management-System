package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Loan extends GUI_Interface_2 {
    String accountNumber, pinNumber;

    JButton takeALoan, repayLoan, back;

    JLabel loanLabel, balanceLabel;

    double loanAmount1 = 0;
    double balance, loanBalance;

    Loan(String accountNumber, String pinNumber){
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;

        try{

            BufferedReader reader1 = new BufferedReader(new FileReader("src/bankManagement/Signup.txt"));
            String line1;
            String currentAccountNumber = null;
            String currentPin = null;
            while ((line1 = reader1.readLine()) != null) {
                String[] parts = line1.split(": ");
                if (parts[0].equals("Account Number")) {
                    currentAccountNumber = parts[1];
                } else if (parts[0].equals("Pin Number")) {
                    currentPin = parts[1];
                } else if (parts[0].equals("Balance") && currentAccountNumber.equals(accountNumber) && currentPin.equals(pinNumber)) {
                    balance = Double.parseDouble(parts[1]);
                } else if (parts[0].equals("Loan") && currentAccountNumber.equals(accountNumber) && currentPin.equals(pinNumber)) {
                    loanBalance = Double.parseDouble(parts[1]);
                }
            }
            reader1.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        setTitle("Loan");

        loanLabel = new JLabel("LOAN AMOUNT: " + loanBalance);
        loanLabel.setBounds(400, 100, 500, 40);
        loanLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loanLabel.setForeground(Color.BLACK);
        add(loanLabel);

        balanceLabel = new JLabel("BALANCE: " + balance);
        balanceLabel.setBounds(420, 150, 500, 40);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        balanceLabel.setForeground(Color.BLACK);
        add(balanceLabel);

        JLabel text = new JLabel("NB: You have to repay the loan with 5% interest");
        text.setBounds(300, 200, 500, 40);
        text.setFont(new Font("Arial", Font.BOLD, 20));
        text.setForeground(Color.RED);
        add(text);

        takeALoan = new JButton("Take a loan");
        takeALoan.setBounds(300, 350, 200, 40);
        takeALoan.setForeground(Color.BLACK);
        takeALoan.addActionListener(this::performAction);
        add(takeALoan);

        repayLoan = new JButton("REPAY LOAN");
        repayLoan.setBounds(550, 350, 200, 40);
        repayLoan.setForeground(Color.BLACK);
        repayLoan.addActionListener(this::performAction);
        add(repayLoan);

        back = new JButton("BACK");
        back.setBounds(400, 450, 250, 40);
        back.setForeground(Color.BLACK);
        back.addActionListener(this::performAction);
        add(back);

        revalidate();
        repaint();

    }

    public void performAction(ActionEvent ae) {
        if (ae.getSource() == takeALoan) {
            String loanAmount = JOptionPane.showInputDialog("Enter the amount you want to take as loan");
            if (loanAmount == null) {
                return;
            }
            loanAmount1 = Double.parseDouble(loanAmount);

            if (loanBalance > 0) {
                JOptionPane.showMessageDialog(null, "Please repay your previous loan");
            } else {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);

                loanBalance = loanAmount1 + loanAmount1*0.05;

                updateLoanBalance(accountNumber, pinNumber, loanBalance, balance + loanAmount1);

                JOptionPane.showMessageDialog(null, "Loan of " + loanAmount  + " with an interest of 5% and have to repay " + (loanBalance + loanAmount1) + " on " + date);

                updateTransactionHistory(accountNumber, loanAmount1, balance + loanAmount1, "Loan taken");

                balanceLabel.setText("BALANCE: " + (balance + loanAmount1));
                loanLabel.setText("LOAN AMOUNT: " + loanBalance);
            }

        } else if (ae.getSource() == repayLoan) {
            String repayLoan = JOptionPane.showInputDialog("Enter the amount you want to repay");
            if (repayLoan == null) {
                return;
            }
            double repayLoan1 = Double.parseDouble(repayLoan);

            if (repayLoan1 > loanBalance) {
                JOptionPane.showMessageDialog(null, "You are paying more than your loan amount");
            }else if (repayLoan1 > balance) {
                JOptionPane.showMessageDialog(null, "Not enough balance in your account");
            } else if (repayLoan1 < 0) {
                JOptionPane.showMessageDialog(null, "Invalid amount");
            } else {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);

                updateLoanBalance(accountNumber, pinNumber, loanBalance - repayLoan1, balance - repayLoan1);

                JOptionPane.showMessageDialog(null, "Loan of " + repayLoan1 + " repaid successfully with 5% interest. " );

                updateTransactionHistory(accountNumber, repayLoan1, balance - repayLoan1, "Loan repaid");

                balanceLabel.setText("BALANCE: " + (balance - repayLoan1));
                loanLabel.setText("LOAN AMOUNT: " + (loanBalance - repayLoan1));

                loanBalance -= repayLoan1;
            }

        } else if (ae.getSource() == back) {
            new Home_Page(accountNumber, pinNumber).setVisible(true);
            dispose();
        }
    }

    public void updateLoanBalance(String accountNumber, String pinNumber, double loanBalance, double balance) {
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
                } else if (parts[0].equals("Loan") && currentAccountNumber.equals(accountNumber) && currentPin.equals(pinNumber)) {
                    line = "Loan: " + loanBalance;
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

    public void updateTransactionHistory(String accountNumber, double loanBalance, double balance, String status){
        String accountNumber1 = accountNumber;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/accountManager/" + accountNumber1 + ".txt", true));

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = now.format(formatter);

            writer.write("Loan: \tTk " + loanBalance + "\t" + formatDateTime + "\t" + balance + "\t" + status);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Loan("", "");
    }
}
