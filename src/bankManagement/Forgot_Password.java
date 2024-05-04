package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Forgot_Password extends JFrame{
    JLabel form, accountNumber, email, newPassword, confirmPassword;
    JTextField accountNumberText, emailText, newPasswordText, confirmPasswordText;
    JButton submit, back;

    Forgot_Password() {
        setLayout(null);

        form = new JLabel("FORGOT PASSWORD");
        form.setFont(new Font("Monospaced", Font.BOLD, 38));
        form.setForeground(Color.BLUE);
        form.setBounds(250, 20, 600, 50);
        add(form);

        accountNumber = new JLabel("ACCOUNT NUMBER");
        accountNumber.setFont(new Font("DialogInput", Font.BOLD, 20));
        accountNumber.setForeground(Color.BLUE);
        accountNumber.setBounds(100, 100, 200, 30);
        add(accountNumber);

        accountNumberText = new JTextField();
        accountNumberText.setBounds(300, 100, 200, 30);
        add(accountNumberText);

        email = new JLabel("EMAIL");
        email.setFont(new Font("DialogInput", Font.BOLD, 20));
        email.setForeground(Color.BLUE);
        email.setBounds(100, 150, 150, 30);
        add(email);

        emailText = new JTextField();
        emailText.setBounds(300, 150, 200, 30);
        add(emailText);

        newPassword = new JLabel("NEW PASSWORD");
        newPassword.setFont(new Font("DialogInput", Font.BOLD, 20));
        newPassword.setForeground(Color.BLUE);
        newPassword.setBounds(100, 200, 200, 30);
        add(newPassword);

        newPasswordText = new JTextField();
        newPasswordText.setBounds(300, 200, 200, 30);
        add(newPasswordText);

        confirmPassword = new JLabel("CONFIRM PASSWORD");
        confirmPassword.setFont(new Font("DialogInput", Font.BOLD, 20));
        confirmPassword.setForeground(Color.BLUE);
        confirmPassword.setBounds(100, 250, 200, 30);
        add(confirmPassword);

        confirmPasswordText = new JTextField();
        confirmPasswordText.setBounds(300, 250, 200, 30);
        add(confirmPasswordText);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Raleway", Font.BOLD, 20));
        submit.setBounds(300, 300, 150, 30);
        submit.addActionListener(this::actionPerformed);
        add(submit);

        back = new JButton("BACK");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.setBounds(300, 300, 150, 30);
        back.addActionListener(this::actionPerformed);
        add(back);

        getContentPane().setBackground(new java.awt.Color(204, 204, 255));

        setSize (800, 400);
        setVisible(true);
        setLocation (350, 200);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == submit) {
            String accountNum = accountNumberText.getText();
            String emailInput = emailText.getText();
            String newPassword = newPasswordText.getText();
            String confirmPassword = confirmPasswordText.getText();

            if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "New password and confirm password do not match");
                return;
            }

            File signupFile = new File("src/bankManagement/Signup.txt");
            File tempFile = new File("src/bankManagement/Temp.txt");

            try {
                BufferedReader reader = new BufferedReader(new FileReader(signupFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String currentLine;

                while((currentLine = reader.readLine()) != null) {
                    if( currentLine.contains("Email: " + emailInput) && currentLine.contains("Account Number: " + accountNum)) {
                        String oldPin = currentLine.substring(currentLine.indexOf("Pin Number: ") + 12, currentLine.indexOf("Pin Number: ") + 16);
                        currentLine = currentLine.replace("Pin Number: " + oldPin, "Pin Number: " + newPassword);
                    }
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
                writer.close();
                reader.close();

                if (!signupFile.delete()) {
                    JOptionPane.showMessageDialog(null, "Could not delete original file");
                    return;
                }

                if (!tempFile.renameTo(signupFile)) {
                    JOptionPane.showMessageDialog(null, "Could not rename temporary file");
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Pin changed successfully");

        } else if (e.getSource() == back) {
            new Login();
            dispose();
        }
    }

    public static void main(String[] args) {
        new Forgot_Password().setVisible(true);
    }
}
