package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transfer_Cash extends GUI_Interface_2{
    String accountNumberText, pinNumber;
    JTextField transferaccountNumberText, amountText;
    JButton transfer, back;


    Transfer_Cash(String accountNumber, String pinNumber) {
        this.accountNumberText = accountNumber;
        this.pinNumber = pinNumber;

        setTitle("Transfer Cash");

        setLayout(null);

        JLabel form = new JLabel("TRANSFER CASH");
        form.setFont(new java.awt.Font("Monospaced", 1, 38));
        form.setForeground(new java.awt.Color(0, 0, 255));
        form.setBounds(375, 150, 400, 50);
        add(form);

        JLabel accountNumberLabel = new JLabel("Enter Account Number: ");
        accountNumberLabel.setFont(new java.awt.Font("DialogInput", 1, 20));
        accountNumberLabel.setForeground(new java.awt.Color(0, 0, 255));
        accountNumberLabel.setBounds(400, 250, 300, 30);
        add(accountNumberLabel);

        transferaccountNumberText = new JTextField();
        transferaccountNumberText.setBounds(350, 300, 350, 30);
        add(transferaccountNumberText);

        JLabel amountLabel = new JLabel("Enter Amount: ");
        amountLabel.setFont(new java.awt.Font("DialogInput", 1, 20));
        amountLabel.setForeground(new java.awt.Color(0, 0, 255));
        amountLabel.setBounds(450, 350, 300, 30);
        add(amountLabel);

         amountText = new JTextField();
        amountText.setBounds(350, 400, 350, 30);
        add(amountText);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    transfer.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    back.doClick();
                }
            }
        });

         transfer = new JButton("Transfer");
        transfer.setFont(new java.awt.Font("DialogInput", 1, 20));
        transfer.setBounds(350, 450, 150, 30);
        transfer.setBackground(Color.GREEN);
        transfer.setForeground(Color.BLACK);
        transfer.addActionListener(this::performAction);
        add(transfer);

         back = new JButton("Back");
        back.setFont(new java.awt.Font("DialogInput", 1, 20));
        back.setBounds(550, 450, 150, 30);
        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.addActionListener(this::performAction);
        add(back);

        revalidate();
        repaint();
    }

    public void performAction(java.awt.event.ActionEvent e) {
        if (e.getSource() == transfer) {
            String amount = amountText.getText();
            String transferAccountNumber = transferaccountNumberText.getText();
            if (amount.equals("") || transferAccountNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount and account number");
            } else if (transferAccountNumber.equals(accountNumberText)){
                JOptionPane.showMessageDialog(null, "You cannot transfer to your own account");
            } else if (!accountFinder(transferAccountNumber)) {
                JOptionPane.showMessageDialog(null, "Account number not found");
            } else {
                String currentBalance = getCurrentBalance(accountNumberText, pinNumber);
                if (currentBalance == null) {
                    JOptionPane.showMessageDialog(null, "Could not retrieve current balance");
                } else {
                    try {
                        Double currentBalanceInt = Double.parseDouble(currentBalance);
                        Double amountInt = Double.parseDouble(amount);
                        if (currentBalanceInt < amountInt) {
                            JOptionPane.showMessageDialog(null, "Insufficient balance");
                        } else {
                            String newBalance = String.valueOf(currentBalanceInt - amountInt);
                            updateBalance(accountNumberText, pinNumber, newBalance);

                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String formatDateTime = now.format(formatter);

                            String accountNumber = this.accountNumberText;
                            BufferedWriter writer = new BufferedWriter(new FileWriter("src/accountManager/" + accountNumber + ".txt", true));
                            writer.write("Transferred: \tTk" + amount + "\t" + formatDateTime + "\t" + newBalance + "\tTransferred to " + transferAccountNumber);
                            writer.newLine();
                            writer.close();

                            String transferAccountBalance = getTransferCurrentBalance(transferAccountNumber);
                            if (transferAccountBalance == null) {
                                JOptionPane.showMessageDialog(null, "Could not retrieve transfer account balance");
                            } else {
                                Double transferAccountBalanceInt = Double.parseDouble(transferAccountBalance);
                                String newTransferAccountBalance = String.valueOf(transferAccountBalanceInt + amountInt);
                                transferBalance(transferAccountNumber, newTransferAccountBalance);

                                String transferAccount = transferAccountNumber;
                                BufferedWriter transferWriter = new BufferedWriter(new FileWriter("src/accountManager/" + transferAccount + ".txt", true));
                                transferWriter.write("Received: \tTk" + amount + "\t" + formatDateTime + "\t" + newTransferAccountBalance + "\tReceived from " + accountNumber);
                                transferWriter.newLine();
                                transferWriter.close();

                                JOptionPane.showMessageDialog(null, "Amount transferred successfully");
                                this.setVisible(false);
                                new Home_Page(accountNumberText, pinNumber).setVisible(true);
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid amount");
                    } catch (IOException ex){
                        ex.printStackTrace();
                    }
                }
            }
        } else if (e.getSource() == back) {
            this.setVisible(false);
            new Home_Page(accountNumberText, pinNumber).setVisible(true);
        }
    }

    public boolean accountFinder(String accountNumber){
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
                    }

                    if (currentAccountNumber.equals(accountNumber)) {
                        return true;
                    }
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        new Transfer_Cash("", "").setVisible(true);
    }
}
