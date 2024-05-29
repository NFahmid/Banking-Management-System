package bankManagement;

import javax.swing.*;
import java.awt.*;

public class Loan extends GUI_Interface_2 {
    String accountNumber, pinNumber;

    JButton takeALoan, repayLoan, back;

    Loan(String accountNumber, String pinNumber){
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;

        setTitle("Loan");

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

    public void performAction(java.awt.event.ActionEvent ae) {
        if (ae.getSource() == takeALoan) {

        } else if (ae.getSource() == repayLoan) {

        } else if (ae.getSource() == back) {
            new Home_Page(accountNumber, pinNumber);
            dispose();
        }
    }

    public static void main(String[] args) {
        new Loan(" ", " ");
    }
}
