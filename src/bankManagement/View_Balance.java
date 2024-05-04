package bankManagement;

import javax.swing.*;

public class View_Balance extends GUI_Interface_2{
    String accountNumber, pinNumber;
    JButton back;

    View_Balance(String accountNumber, String pinNumber){
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;

        String currentBalance = getCurrentBalance(accountNumber, pinNumber);
        if (currentBalance == null) {
            JOptionPane.showMessageDialog(null, "Could not retrieve current balance");
        } else {
            JLabel balance = new JLabel("Your current balance is: " + currentBalance);
            balance.setFont(new java.awt.Font("Raleway", java.awt.Font.BOLD, 22));
            balance.setForeground(java.awt.Color.BLACK);
            balance.setBounds(300, 200, 600, 50);
            add(balance);
        }

        back = new JButton("BACK");
        back.setBackground(java.awt.Color.BLUE);
        back.setForeground(java.awt.Color.WHITE);
        back.setFont(new java.awt.Font("Raleway", java.awt.Font.BOLD, 20));
        back.setBounds(570, 400, 150, 30);
        back.addActionListener(this::performAction);
        add(back);

        revalidate();
        repaint();
    }

    public void performAction(java.awt.event.ActionEvent ae){
        if (ae.getSource() == back){
            new Home_Page(accountNumber, pinNumber).setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new View_Balance("", "").setVisible(true);
    }
}
