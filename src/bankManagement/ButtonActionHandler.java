package bankManagement;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;

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
            String currentPin = JOptionPane.showInputDialog("Enter your current pin");
            if (!currentPin.equals(this.homePage.getPinNumber())) {
                JOptionPane.showMessageDialog(null, "Entered current pin does not match with the pin of the logged-in user");
                return;
            }
            String newPin = JOptionPane.showInputDialog("Enter your new pin");
            changePin(currentPin, newPin);

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

    public void changePin(String currentPin, String newPin) {
        File signupFile = new File("src/bankManagement/Signup.txt");
        File tempFile = new File("src/bankManagement/Temp.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/bankManagement/Signup.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/bankManagement/Temp.txt"));

            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                if(currentLine.contains("Pin Number: " + currentPin)) {
                    currentLine = "Pin Number: " + newPin;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

            try {
                Files.delete(signupFile.toPath());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (!tempFile.renameTo(signupFile))
                System.out.println("Could not rename file");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
