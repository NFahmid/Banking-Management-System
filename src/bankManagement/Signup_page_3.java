package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Random;

public class Signup_page_3 extends GUI_Interface{
    JLabel form, congrats, l1, l3, pin, rePin, question, balance;
    JTextField pinText, rePinText, balanceText;
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7;
    int accountNumber;


    Signup_page_3(){

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

        Random random = new Random();
        accountNumber = random.nextInt(1111100000, 1111199999);

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
        add(pinText);

        rePin = new JLabel("Re-enter your 4 digit pin number:");
        rePin.setFont(new Font("Raleway", Font.BOLD, 20));
        rePin.setForeground(Color.black);
        rePin.setBounds(100, 300, 400, 30);
        add(rePin);

        rePinText = new JTextField();
        rePinText.setBounds(560, 300, 200, 30);
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
        checkBox1.setBackground(Color.WHITE);
        checkBox1.setBounds(100, 450, 200, 30);
        add(checkBox1);

        checkBox2 = new JCheckBox("Internet Banking");
        checkBox2.setBackground(Color.WHITE);
        checkBox2.setBounds(350, 450, 200, 30);
        add(checkBox2);

        checkBox3 = new JCheckBox("Mobile Banking");
        checkBox3.setBackground(Color.WHITE);
        checkBox3.setBounds(100, 500, 200, 30);
        add(checkBox3);

        checkBox4 = new JCheckBox("Email Alerts");
        checkBox4.setBackground(Color.WHITE);
        checkBox4.setBounds(350, 500, 200, 30);
        add(checkBox4);

        checkBox5 = new JCheckBox("Cheque Book");
        checkBox5.setBackground(Color.WHITE);
        checkBox5.setBounds(100, 550, 200, 30);
        add(checkBox5);

        checkBox6 = new JCheckBox("E-Statement");
        checkBox6.setBackground(Color.WHITE);
        checkBox6.setBounds(350, 550, 200, 30);
        add(checkBox6);

        checkBox7 = new JCheckBox("I hereby declare that the above entered details correct to the best of my knowledge.");
        checkBox7.setBackground(new java.awt.Color(204, 204, 255));
        checkBox7.setBounds(100, 600, 600, 30);
        add(checkBox7);

        JButton submit = new JButton("Submit");
        submit.setBackground(new java.awt.Color(204, 204, 255));
        submit.setForeground(Color.BLACK);
        submit.setBounds(250, 650, 100, 30);
        submit.addActionListener(this::performAction);
        add(submit);

        JButton back = new JButton("Back");
        back.setBackground(new java.awt.Color(204, 204, 255));
        back.setForeground(Color.BLACK);
        back.setBounds(400, 650, 100, 30);
        back.addActionListener(this::performAction);
        add(back);

    }

        public void performAction(java.awt.event.ActionEvent ae){
            if (pinText.getText().isEmpty() || rePinText.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else if (!pinText.getText().matches("[0-9]+") || !rePinText.getText().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "Pin number must be a number");
            } else if ( pinText.getText().length() != 4 || rePinText.getText().length() != 4){
                JOptionPane.showMessageDialog(null, "Pin number must be 4 digits long");
            }  else if (!pinText.getText().equals(rePinText.getText())){
                JOptionPane.showMessageDialog(null, "Entered pin numbers do not match");
            } else if (!checkBox7.isSelected()){
                JOptionPane.showMessageDialog(null, "You need to agree to the terms and conditions to proceed");
            } else if (Double.parseDouble(balanceText.getText()) < 1000){
                JOptionPane.showMessageDialog(null, "Minimum balance of 1000 is required to open an account");
            }else {
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
                        bufferedWriter.close();
                        JOptionPane.showMessageDialog(null, "Account created successfully");
                        setVisible(false);
                        new Login();
                    } else if (ae.getActionCommand().equals("Back")) {
                        setVisible(false);
                        new Signup_page_2();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    public static void main(String[] args) {
        new Signup_page_3();
    }
}
