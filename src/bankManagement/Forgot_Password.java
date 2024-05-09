package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

public class Forgot_Password extends JFrame{
    JLabel form, accountNumber, email, newPassword, confirmPassword;
    JTextField accountNumberText, emailText, newPasswordText, confirmPasswordText;
    JButton submit, back;

    Forgot_Password() {
        setLayout(null);

        form = new JLabel("FORGOT PASSWORD FORM");
        form.setFont(new Font("Raleway", Font.BOLD, 22));
        form.setForeground(Color.BLACK);
        form.setBounds(350, 100, 600, 50);
        add(form);

        accountNumber = new JLabel("Account Number:");
        accountNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        accountNumber.setForeground(Color.BLACK);
        accountNumber.setBounds(300, 200, 200, 50);
        add(accountNumber);

        accountNumberText = new JTextField();
        accountNumberText.setBounds(500, 215, 200, 25);
        add(accountNumberText);

        email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setForeground(Color.BLACK);
        email.setBounds(300, 250, 200, 50);
        add(email);

        emailText = new JTextField();
        emailText.setBounds(500, 265, 200, 25);
        add(emailText);

        newPassword = new JLabel("New Password:");
        newPassword.setFont(new Font("Raleway", Font.BOLD, 20));
        newPassword.setForeground(Color.BLACK);
        newPassword.setBounds(300, 300, 200, 50);
        add(newPassword);

        newPasswordText = new JTextField();
        newPasswordText.setBounds(500, 315, 200, 25);
        add(newPasswordText);

        confirmPassword = new JLabel("Confirm Password:");
        confirmPassword.setFont(new Font("Raleway", Font.BOLD, 20));
        confirmPassword.setForeground(Color.BLACK);
        confirmPassword.setBounds(300, 350, 200, 50);
        add(confirmPassword);

        confirmPasswordText = new JTextField();
        confirmPasswordText.setBounds(500, 365, 200, 25);
        confirmPassword.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submit.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    back.doClick();
                }
            }
        });
        add(confirmPasswordText);


        submit = new JButton("SUBMIT");
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Raleway", Font.BOLD, 20));
        submit.setBounds(300, 450, 150, 30);
        submit.addActionListener(this::actionPerformed);
        add(submit);


        back = new JButton("BACK");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.setBounds(570, 450, 150, 30);
        back.addActionListener(this::actionPerformed);
        add(back);

        revalidate();
        repaint();

        getContentPane().setBackground(new java.awt.Color(204, 204, 255));

        setSize(1080, 720);
        setLocation(220, 40);
        setVisible(true);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == submit) {
            String accountNumber = accountNumberText.getText();
            String email = emailText.getText();
            String newPassword = newPasswordText.getText();
            String confirmPassword = confirmPasswordText.getText();

            try {
                if (accountNumber.equals("") || email.equals("") || newPassword.equals("") || confirmPassword.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    if (newPassword.equals(confirmPassword)) {
                        File inputFile = new File("src/bankManagement/Signup.txt");
                        File tempFile = new File("src/bankManagement/temp.txt");

                        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                        String line;
                        String currentAccountNumber = null;
                        String currentEmail = null;
                        while ((line = reader.readLine()) != null) {
                            String[] data = line.split(": ");
                            if (data[0].equals("Account Number")) {
                                currentAccountNumber = data[1];
                            } else if (data[0].equals("Email")) {
                                currentEmail = data[1];
                            } else if (data[0].equals("Pin Number") && currentAccountNumber.equals(accountNumber) && currentEmail.equals(email)) {
                                line = "Pin Number: " + newPassword;
                                JOptionPane.showMessageDialog(null, "Password changed successfully");
                                new Login().setVisible(true);
                                setVisible(false);
                            }
                            writer.write(line + System.lineSeparator());
                        }
                        reader.close();
                        writer.close();

                        if (!inputFile.delete()) {
                            JOptionPane.showMessageDialog(null, "Could not delete original file");
                            return;
                        }

                        if (!tempFile.renameTo(inputFile)) {
                            JOptionPane.showMessageDialog(null, "Could not rename temporary file");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Password does not match");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            new Login().setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Forgot_Password().setVisible(true);
    }
}
