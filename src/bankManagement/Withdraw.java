package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Withdraw extends GUI_Interface_2 {
JLabel withdrawAmount;
    JTextField withdrawAmountText;
    JButton withdraw, back;
    String accountNumber, pinNumber;

    Withdraw(String accountNumber, String pinNumber){
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;


        withdrawAmount = new JLabel("Enter the amount you want to withdraw:");
        withdrawAmount.setFont(new Font("Raleway", Font.BOLD, 22));
        withdrawAmount.setForeground(Color.BLACK);
        withdrawAmount.setBounds(300, 200, 600, 50);
        add(withdrawAmount);

        withdrawAmountText = new JTextField(20);
        withdrawAmountText.setBounds(300, 300, 420, 50);
        add(withdrawAmountText);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBackground(Color.GREEN);
        withdraw.setForeground(Color.BLACK);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 20));
        withdraw.setBounds(300, 400, 150, 30);
        withdraw.addActionListener(this::performAction);
        add(withdraw);

        back = new JButton("BACK");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.setBounds(570, 400, 150, 30);
        back.addActionListener(this::performAction);
        add(back);

        revalidate();
        repaint();
    }
    public void performAction(java.awt.event.ActionEvent ae){
        if (ae.getSource() == withdraw){
            String currentBalance = getCurrentBalance(accountNumber, pinNumber);
            String amount = withdrawAmountText.getText();

            Double amount1 = Double.parseDouble(withdrawAmountText.getText());
            Double currentBalance1 = Double.parseDouble(getCurrentBalance(accountNumber, pinNumber));

            if (amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else if ( amount1 > currentBalance1){
                JOptionPane.showMessageDialog(null, "Insufficient balance");
            } else if (amount1 < 0){
                JOptionPane.showMessageDialog(null, "Invalid amount");
            } else if (amount.equals("0")){
                JOptionPane.showMessageDialog(null, "Amount cannot be 0");
            } else {
                if (currentBalance == null) {
                    JOptionPane.showMessageDialog(null, "Could not retrieve current balance");
                } else {
                    try {
                        Double currentBalanceInt = Double.parseDouble(currentBalance);
                        Double amountInt = Double.parseDouble(amount);
                        String newBalance = String.valueOf(currentBalanceInt - amountInt);
                        updateBalance(accountNumber, pinNumber, newBalance);

                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        String date = now.format(dtf);

                        String accountNumber = this.accountNumber;
                        BufferedWriter writer = new BufferedWriter(new FileWriter("src/accountManager/" + accountNumber + ".txt", true));
                        writer.write("Withdraw: \tTk " + amount + "\t" + date + "\t" + newBalance + "\t" + "Withdraw from own account");
                        writer.newLine();
                        writer.close();

                        JOptionPane.showMessageDialog(null, "Amount withdrawn successfully");
                        this.setVisible(false);
                        new Home_Page(accountNumber, pinNumber).setVisible(true);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid number format");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (ae.getSource() == back){
            this.setVisible(false);
            new Home_Page(accountNumber, pinNumber).setVisible(true);
        }
    }



    public static void main(String[] args) {
        new Withdraw("", "").setVisible(true);
    }

}


