package bankManagement;

import javax.swing.*;
import java.awt.*;

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
            String amount = withdrawAmountText.getText();
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
                        String newBalance = String.valueOf(currentBalanceInt - amountInt);
                        updateBalance(accountNumber, pinNumber, newBalance);

                        JOptionPane.showMessageDialog(null, "Amount withdrawn successfully");
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



    public static void main(String[] args) {
        new Withdraw("", "").setVisible(true);
    }

}


