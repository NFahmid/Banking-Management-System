package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Random;

public class Signup_page_3 extends JFrame{
    JLabel form, congrats, l1, l3, pin, rePin, question;
    JTextField pinText, rePinText;
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7;
    int accountNumber;


    Signup_page_3(){
        setLayout(null);

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
        pinText.setBounds(460, 250, 200, 30);
        add(pinText);

         rePin = new JLabel("Re-enter your 4 digit pin number:");
        rePin.setFont(new Font("Raleway", Font.BOLD, 20));
        rePin.setForeground(Color.black);
        rePin.setBounds(100, 300, 400, 30);
        add(rePin);

         rePinText = new JTextField();
        rePinText.setBounds(460, 300, 200, 30);
        add(rePinText);

         question = new JLabel("Please select the services you want:");
        question.setFont(new Font("Raleway", Font.BOLD, 20));
        question.setForeground(Color.BLUE);
        question.setBounds(100, 350, 400, 30);
        add(question);

         checkBox1 = new JCheckBox("ATM CARD");
        checkBox1.setBackground(new Color(204, 204, 255));
        checkBox1.setBounds(100, 400, 200, 30);
        add(checkBox1);

         checkBox2 = new JCheckBox("Internet Banking");
        checkBox2.setBackground(new Color(204, 204, 255));
        checkBox2.setBounds(350, 400, 200, 30);
        add(checkBox2);

         checkBox3 = new JCheckBox("Mobile Banking");
        checkBox3.setBackground(new Color(204, 204, 255));
        checkBox3.setBounds(100, 450, 200, 30);
        add(checkBox3);

         checkBox4 = new JCheckBox("Email Alerts");
        checkBox4.setBackground(new Color(204, 204, 255));
        checkBox4.setBounds(350, 450, 200, 30);
        add(checkBox4);

         checkBox5 = new JCheckBox("Cheque Book");
        checkBox5.setBackground(new Color(204, 204, 255));
        checkBox5.setBounds(100, 500, 200, 30);
        add(checkBox5);

         checkBox6 = new JCheckBox("E-Statement");
        checkBox6.setBackground(new Color(204, 204, 255));
        checkBox6.setBounds(350, 500, 200, 30);
        add(checkBox6);

         checkBox7 = new JCheckBox("I have read and agree to the terms and conditions of the bank.");
        checkBox7.setBackground(new Color(204, 204, 255));
        checkBox7.setBounds(100, 550, 600, 20);
        add(checkBox7);

        JButton next = new JButton("Submit");
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.setBounds(500, 600, 100, 30);
        next.addActionListener(this::actionPerformed);
        add(next);

        JButton back = new JButton("Back");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 600, 100, 30);
        back.addActionListener(this::actionPerformed);
        add(back);

        setSize (800, 800);
        setLocation(350, 10);
        setVisible(true);

        getContentPane().setBackground(new java.awt.Color(204, 204, 255));
    }

        public void actionPerformed(java.awt.event.ActionEvent ae){
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
            } else {
                try {
                    if (ae.getActionCommand().equals("Submit")) {
                        FileWriter file = new FileWriter("src/bankManagement/Signup.txt", true);
                        BufferedWriter bufferedWriter = new BufferedWriter(file);
                        bufferedWriter.write("Account Number: " + accountNumber);
                        bufferedWriter.newLine();
                        bufferedWriter.write("Pin Number: " + pinText.getText());
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
