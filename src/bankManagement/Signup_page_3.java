package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Signup_page_3 extends GUI_Interface{

    JLabel form, congrats, l1, l3, pin, rePin, question, balance;
    JTextField pinText, rePinText, balanceText;
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7;
    JButton submit, back;
    int accountNumber;

    public boolean isValidMoneyString(String moneyStr) {
        String pattern = "^[0-9,]+$";
        return Pattern.matches(pattern, moneyStr);
    }

    
    public int convertToInteger(String moneyStr) {
        String moneyStrNoCommas = moneyStr.replace(",", "");
        return Integer.parseInt(moneyStrNoCommas);
    }

    
    public boolean checkIfGreaterThan(String moneyStr, int amount) {
        if (!isValidMoneyString(moneyStr)) {
            throw new IllegalArgumentException("Invalid money format");
        }

        int moneyValue = convertToInteger(moneyStr);
        return moneyValue > amount;
    }


    Signup_page_3(int accountNumber){
        this.accountNumber = accountNumber;

        setTitle("Signup Page 3/3");

        form = new JLabel("Page 3: ACCOUNT DETAILS");
        form.setFont(new Font("Raleway", Font.BOLD, 38));
        form.setForeground(Color.BLUE);
        form.setBounds(150, 20, 600, 50);
        add(form);

        congrats = new JLabel("CONGRATULATIONS, YOUR ACCOUNT HAS BEEN CREATED");
        congrats.setFont(new Font("Raleway", Font.BOLD, 22));
        congrats.setForeground(Color.BLUE);
        congrats.setBounds(100, 80, 700, 50);
        add(congrats);


         l1 = new JLabel("ACCOUNT NUMBER: " + accountNumber);
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l1.setForeground(Color.BLACK);
        l1.setBounds(100, 150, 800, 30);
        add(l1);

        l3 = new JLabel("NOTE IT DOWN FOR FUTURE REFERENCE");
        l3.setFont(new Font("Raleway", Font.BOLD, 15));
        l3.setForeground(Color.BLUE);
        l3.setBounds(100, 200, 600, 30);
        add(l3);

        pin = new JLabel("Please enter your 4 digit pin number:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setForeground(Color.black);
        pin.setBounds(100, 250, 400, 30);
        add(pin);

        pinText = new JTextField();
        pinText.setBounds(560, 250, 200, 30);
        pinText.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    rePinText.requestFocus();
                }
            }
        });
        add(pinText);

        rePin = new JLabel("Re-enter your 4 digit pin number:");
        rePin.setFont(new Font("Raleway", Font.BOLD, 20));
        rePin.setForeground(Color.black);
        rePin.setBounds(100, 300, 400, 30);
        add(rePin);

        rePinText = new JTextField();
        rePinText.setBounds(560, 300, 200, 30);
        rePinText.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    balanceText.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    pinText.requestFocus();
                }
            }
        });
        add(rePinText);

        balance = new JLabel("Enter the amount of money you want to deposit:");
        balance.setFont(new Font("Raleway", Font.BOLD, 20));
        balance.setForeground(Color.black);
        balance.setBounds(100, 350, 500, 30);
        add(balance);

        balanceText = new JTextField();
        balanceText.setBounds(560, 350, 200, 30);
        add(balanceText);

        question = new JLabel("Select the services you want to avail:");
        question.setFont(new Font("Raleway", Font.BOLD, 20));
        question.setForeground(Color.black);
        question.setBounds(100, 400, 500, 30);
        add(question);

        checkBox1 = new JCheckBox("ATM CARD");
        checkBox1.setBackground(new java.awt.Color(204, 204, 255));
        checkBox1.setBounds(100, 450, 200, 30);
        add(checkBox1);

        checkBox2 = new JCheckBox("Internet Banking");
        checkBox2.setBackground(new java.awt.Color(204, 204, 255));
        checkBox2.setBounds(350, 450, 200, 30);
        add(checkBox2);

        checkBox3 = new JCheckBox("Mobile Banking");
        checkBox3.setBackground(new java.awt.Color(204, 204, 255));
        checkBox3.setBounds(100, 500, 200, 30);
        add(checkBox3);

        checkBox4 = new JCheckBox("Email Alerts");
        checkBox4.setBackground(new java.awt.Color(204, 204, 255));
        checkBox4.setBounds(350, 500, 200, 30);
        add(checkBox4);

        checkBox5 = new JCheckBox("Cheque Book");
        checkBox5.setBackground(new java.awt.Color(204, 204, 255));
        checkBox5.setBounds(100, 550, 200, 30);
        add(checkBox5);

        checkBox6 = new JCheckBox("E-Statement");
        checkBox6.setBackground(new java.awt.Color(204, 204, 255));
        checkBox6.setBounds(350, 550, 200, 30);
        add(checkBox6);

        checkBox7 = new JCheckBox("You need to agree to the Terms and Conditions to continue.");
        checkBox7.setBackground(new java.awt.Color(204, 204, 255));
        checkBox7.setBounds(100, 600, 600, 30);
        add(checkBox7);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submit.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    back.doClick();
                }
            }
        });

        submit = new JButton("Submit");
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.BLACK);
        submit.setBounds(250, 650, 100, 30);
        submit.addActionListener(this::performAction);
        add(submit);

        back = new JButton("Back");
        back.setBackground(Color.GREEN);
        back.setForeground(Color.BLACK);
        back.setBounds(400, 650, 100, 30);
        back.addActionListener(this::performAction);
        add(back);

        revalidate();
        repaint();

    }

        public void performAction(java.awt.event.ActionEvent ae){
            if (pinText.getText().isEmpty() || rePinText.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else if (!pinText.getText().matches("[0-9]+") || !rePinText.getText().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "Pin number must be a number");
            } else if ( pinText.getText().length() != 4 || rePinText.getText().length() != 4){
                JOptionPane.showMessageDialog(null, "Pin number must be 4 digits long");
            } else if (!pinText.getText().equals(rePinText.getText())){
                JOptionPane.showMessageDialog(null, "Entered pin numbers do not match");
            } else if (!checkBox7.isSelected()){
                JOptionPane.showMessageDialog(null, "You need to agree to the terms and conditions to proceed");
            } else if (!checkIfGreaterThan(balanceText.getText(), 1000)) {
                JOptionPane.showMessageDialog(null, "You have to deposit minimum 1,000 taka");
            }  else {
                try {
                    if (ae.getActionCommand().equals("Submit")) {
                        FileWriter file = new FileWriter("src/bankManagement/Signup.txt", true);
                        BufferedWriter bufferedWriter = new BufferedWriter(file);
                        bufferedWriter.write("Account Number: " + accountNumber);
                        bufferedWriter.newLine();
                        bufferedWriter.write("Pin Number: " + pinText.getText());
                        bufferedWriter.newLine();
                        bufferedWriter.write("Balance: " + balanceText.getText());
                        bufferedWriter.newLine();
                        bufferedWriter.write("Loan: 0");
                        bufferedWriter.newLine();
                        bufferedWriter.write("Services: ");
                        if (checkBox1.isSelected()) {
                            bufferedWriter.write("ATM Card, ");
                        }
                        if (checkBox2.isSelected()) {
                            bufferedWriter.write("Internet Banking, ");
                        }
                        if (checkBox3.isSelected()) {
                            bufferedWriter.write("Mobile Banking, ");
                        }
                        if (checkBox4.isSelected()) {
                            bufferedWriter.write("Email Alerts, ");
                        }
                        if (checkBox5.isSelected()) {
                            bufferedWriter.write("Cheque Book, ");
                        }
                        if (checkBox6.isSelected()) {
                            bufferedWriter.write("E-Statement, ");
                        }
                        bufferedWriter.newLine();
                        bufferedWriter.write("--------------------------------------------------");
                        bufferedWriter.newLine();
                        bufferedWriter.write("\n");
                        bufferedWriter.close();

                        LocalDateTime myDateObj = LocalDateTime.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        String formattedDate = myDateObj.format(myFormatObj);

                        String accountNumberString = String.valueOf(accountNumber);

                        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("src/accountManager/" + accountNumberString + ".txt", true));
                        bufferedWriter1.write("Account Number: " + accountNumber + " created on " + formattedDate);
                        bufferedWriter1.newLine();
                        bufferedWriter1.write("Case \t Amount \t Time \t \t \t \t \t \t \t Balance \t Description");
                        bufferedWriter1.newLine();
                        bufferedWriter1.write("Initial deposit: \tTk " + balanceText.getText() + " \t" + formattedDate + " \tTk " + balanceText.getText() + " \tInitial deposit");
                        bufferedWriter1.newLine();
                        bufferedWriter1.close();

                        JOptionPane.showMessageDialog(null, "Account created successfully");
                        setVisible(false);
                        new Main();
                    } else if (ae.getActionCommand().equals("Back")) {
                        setVisible(false);
                        revalidate();
                        repaint();
                        new Signup_page_2(accountNumber);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    public static void main(String[] args) {
        new Signup_page_3(0);
    }
}
