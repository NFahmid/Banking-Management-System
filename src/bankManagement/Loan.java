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

    double loanAmount, loanBalance;
    double balance;

    Loan(String accountNumber, String pinNumber){
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/loanManagement/" + accountNumber + ".txt"));

            String lastLine = null;
            String line;

            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }

            if (lastLine != null){
                String[] parts = lastLine.split("\t");
                loanAmount = Double.parseDouble(parts[0]);
                loanBalance = Double.parseDouble(parts[2]);
            }

            reader.close();

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
                }
            }
            reader1.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        setTitle("Loan");

        System.out.println(balance);

        loanLabel = new JLabel("LOAN AMOUNT: " + loanBalance);
        loanLabel.setBounds(400, 100, 500, 40);
        loanLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loanLabel.setForeground(Color.BLACK);
        add(loanLabel);

        balanceLabel = new JLabel("BALANCE: " + balance);
        balanceLabel.setBounds(400, 150, 500, 40);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        balanceLabel.setForeground(Color.BLACK);
        add(balanceLabel);

        takeALoan = new JButton("Take a loan");
        takeALoan.setBounds(300, 250, 200, 40);
        takeALoan.setForeground(Color.BLACK);
        takeALoan.addActionListener(this::performAction);
        add(takeALoan);

        repayLoan = new JButton("REPAY LOAN");
        repayLoan.setBounds(550, 250, 200, 40);
        repayLoan.setForeground(Color.BLACK);
        repayLoan.addActionListener(this::performAction);
        add(repayLoan);

        back = new JButton("BACK");
        back.setBounds(400, 350, 250, 40);
        back.setForeground(Color.BLACK);
        back.addActionListener(this::performAction);
        add(back);

        revalidate();
        repaint();

    }

    public void performAction(ActionEvent ae) {
        if (ae.getSource() == takeALoan) {
            try{
                if (loanBalance > 0){
                    JOptionPane.showMessageDialog(this, "You have an outstanding loan of " + loanBalance + " to pay");
                    return;
                } else {
                    String loanAmountString = JOptionPane.showInputDialog(this, "Enter the amount you want to take as loan");
                    loanAmount = Double.parseDouble(loanAmountString);

                    if (loanAmount > 0){
                        loanBalance = loanAmount + (loanAmount * 0.05);
                        JOptionPane.showMessageDialog(this, "You have taken a loan of " + loanAmount + " with a 10% interest rate. You will have to pay " + loanBalance + " in total");
                        balance = balance + loanAmount;
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid amount entered");
                    }
                }

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                BufferedWriter writer = new BufferedWriter(new FileWriter("src/loanManagement/" + accountNumber + ".txt", true));
                writer.write(loanAmount + "\t" + formattedDate + "\t" + loanBalance + "\t" + "Took a loan");
                writer.newLine();
                writer.close();

                BufferedWriter writer1 = new BufferedWriter(new FileWriter("src/bankManagement/temp.txt"));
                BufferedReader reader = new BufferedReader(new FileReader("src/bankManagement/Signup.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(": ");
                    if (parts.length >= 2) {
                        String key = parts[0];
                        String value = parts[1];

                        if (key.equals("Account Number") && value.equals(accountNumber)) {
                            String[] parts1 = line.split(": ");
                            if (parts1.length >= 2) {
                                String key1 = parts1[0];
                                String value1 = parts1[1];

                                if (key1.equals("Loan Balance")) {
                                    writer1.write("Loan Balance: " + (loanBalance + loanAmount));
                                } else if (key1.equals("Balance")) {
                                    writer1.write("Balance: " + balance);
                                } else {
                                    writer1.write(line);
                                }
                            }
                        } else {
                            writer1.write(line);
                        }
                    }
                    writer1.newLine();
                }
                writer1.close();
                reader.close();

                File inputFile = new File("src/bankManagement/Signup.txt");
                File tempFile = new File("src/bankManagement/temp.txt");

                if (!inputFile.delete()) {
                    JOptionPane.showMessageDialog(null, "Could not delete original file");
                    return;
                }

                if (!tempFile.renameTo(inputFile)) {
                    JOptionPane.showMessageDialog(null, "Could not rename temporary file");
                }

                loanLabel.setText("LOAN AMOUNT: " + loanBalance);
                balanceLabel.setText("BALANCE: " + balance);

            } catch (IOException e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == repayLoan) {
            try {
                String loanAmountString = JOptionPane.showInputDialog(this, "Enter the amount you want to repay");
                double repayAmount = Double.parseDouble(loanAmountString);

                if (loanBalance == 0){
                    JOptionPane.showMessageDialog(this, "You don't have any loan");
                } else if (repayAmount > loanBalance){
                    JOptionPane.showMessageDialog(this, "You can't repay more than your loan balance");
                    return;
                } else if (repayAmount == loanBalance){
                    JOptionPane.showMessageDialog(this, "You have successfully repaid your loan");
                    balance = balance - loanBalance;
                } else {
                    JOptionPane.showMessageDialog(this, "You have successfully repaid " + repayAmount + " of your loan");
                    balance = balance - repayAmount;
                }

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                BufferedWriter writer = new BufferedWriter(new FileWriter("src/loanManagement/" + accountNumber + ".txt", true));
                writer.write(repayAmount + "\t" + formattedDate + "\t" + (loanBalance - repayAmount) + "\t" + "Repayed loan");
                writer.newLine();
                writer.close();

                BufferedWriter writer1 = new BufferedWriter(new FileWriter("src/bankManagement/temp.txt"));
                BufferedReader reader = new BufferedReader(new FileReader("src/bankManagement/Signup.txt"));
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(": ");
                    if (parts.length >= 2) {
                        String key = parts[0];
                        String value = parts[1];

                        if (key.equals("Account Number") && value.equals(accountNumber)) {
                            String[] parts1 = line.split(": ");
                            if (parts1.length >= 2) {
                                String key1 = parts1[0];
                                String value1 = parts1[1];

                                if (key1.equals("Loan Balance")) {
                                    writer1.write("Loan Balance: " + (loanBalance - repayAmount));
                                } else if (key1.equals("Balance")) {
                                    writer1.write("Balance: " + balance);
                                } else {
                                    writer1.write(line);
                                }
                            }
                        } else {
                            writer1.write(line);
                        }
                    }
                    writer1.newLine();
                }
                writer1.close();
                reader.close();

                File inputFile = new File("src/bankManagement/Signup.txt");
                File tempFile = new File("src/bankManagement/temp.txt");

                if (!inputFile.delete()) {
                    JOptionPane.showMessageDialog(null, "Could not delete original file");
                    return;
                }

                if (!tempFile.renameTo(inputFile)) {
                    JOptionPane.showMessageDialog(null, "Could not rename temporary file");
                }

                loanBalance -= repayAmount;
                loanLabel.setText("LOAN AMOUNT: " + loanBalance);
                balanceLabel.setText("BALANCE: " + balance);

            } catch (IOException e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            new Home_Page(accountNumber, pinNumber);
            dispose();
        }
    }

    public static void main(String[] args) {
        new Loan(" ", " ");
    }
}
