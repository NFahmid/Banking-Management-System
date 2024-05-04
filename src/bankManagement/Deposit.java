package bankManagement;

import javax.swing.*;
import java.awt.*;

public class Deposit extends GUI_Interface_2 {
    JLabel depositAmount;
    JTextField depositAmountText;
    JButton deposit, back;
    String accountNumber, pinNumber;

    Deposit(String accountNumber, String pinNumber){
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;

        depositAmount = new JLabel("Enter the amount you want to deposit:");
        depositAmount.setFont(new Font("Raleway", Font.BOLD, 22));
        depositAmount.setForeground(Color.BLACK);
        depositAmount.setBounds(300, 200, 600, 50);
        add(depositAmount);

        depositAmountText = new JTextField();
        depositAmountText.setBounds(300, 300, 420, 50);
        add(depositAmountText);

        deposit = new JButton("DEPOSIT");
        deposit.setBackground(Color.GREEN);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Raleway", Font.BOLD, 20));
        deposit.setBounds(300, 400, 150, 30);
        deposit.addActionListener(this::performAction);
        add(deposit);

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

    public static void main(String[] args) {
        new Deposit("", "").setVisible(true);
    }
}
