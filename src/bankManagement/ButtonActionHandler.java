package bankManagement;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ButtonActionHandler implements ActionListener {
    private Home_Page homePage;

    public ButtonActionHandler(Home_Page homePage) {
        this.homePage = homePage;
    }



    @Override
    public void actionPerformed(java.awt.event.ActionEvent ae) {
        if(ae.getSource() == homePage.logout){
            new Main().setVisible(true);
            homePage.dispose();
        } else if (ae.getSource() == homePage.pinChange) {
            String accountNumber = homePage.getAccountNumber();
            String currentPin = JOptionPane.showInputDialog("Enter your current pin");
            if (!currentPin.equals(this.homePage.getPinNumber())) {
                JOptionPane.showMessageDialog(null, "Entered current pin does not match with the pin of the logged-in user");
                return;
            } else if (currentPin == null) {
                return;
            }
            String newPin = JOptionPane.showInputDialog("Enter your new pin");
            String confirmNewPin = JOptionPane.showInputDialog("Confirm your new pin");
            if (!newPin.equals(confirmNewPin)) {
                JOptionPane.showMessageDialog(null, "New pin and confirm new pin does not match");
                return;
            }
            changePin(accountNumber, currentPin, newPin);

            JOptionPane.showMessageDialog(null, "Pin changed successfully");
        } else if (ae.getSource() == homePage.deposit){
            new Deposit(homePage.getAccountNumber(), homePage.getPinNumber()).setVisible(true);
            homePage.dispose();
        } else if (ae.getSource() == homePage.withdraw) {
            new Withdraw(homePage.getAccountNumber(), homePage.getPinNumber()).setVisible(true);
            homePage.dispose();
        } else if (ae.getSource() == homePage.transfer){
            new Transfer_Cash(homePage.getAccountNumber(), homePage.getPinNumber()).setVisible(true);
            homePage.dispose();
        } else if (ae.getSource() == homePage.transactionHistory){
            new Transaction_History(homePage.getAccountNumber(), homePage.getPinNumber()).setVisible(true);
            homePage.dispose();
        } else if (ae.getSource() == homePage.viewProfile){
            new View_Profile(homePage.getAccountNumber(), homePage.getPinNumber()).setVisible(true);
            homePage.dispose();
        } else if (ae.getSource() == homePage.deleteAccount){
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account? This action cannot be undone", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(response == JOptionPane.YES_OPTION) {
                new Delete_Account(homePage.getAccountNumber());
                new Main().setVisible(true);
                homePage.dispose();
            }
        } else if (ae.getSource() == homePage.loan){
            new Loan(homePage.getAccountNumber(), homePage.getPinNumber()).setVisible(true);
            homePage.dispose();
        } else if (ae.getSource() == homePage.payBill){
            new PayBill(homePage.getAccountNumber(), homePage.getPinNumber()).setVisible(true);
            homePage.dispose();
        }
    }

    public void changePin(String accountNumber, String currentPin, String newPin) {
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
                    } else if (key.equals("Pin Number")  && currentAccountNumber.equals(accountNumber) && value.equals(currentPin)) {
                        currentLine = "Pin Number: " + newPin;
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
}
