package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class View_Profile extends GUI_Interface_2{
    String accountNumberText, pinNUmber;
    JButton back;

    View_Profile(String accountNumber, String pinNumber) {
        this.accountNumberText = accountNumber;
        this.pinNUmber = pinNumber;

        setTitle("View Profile");

        setLayout(new GridLayout(0, 1));

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/bankManagement/Signup.txt"));
            String line;
            boolean accountFound = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Account Number: " + accountNumber)) {
                    accountFound = true;
                }

                if (accountFound) {
                    String[] parts = line.split(": ");
                    if (parts.length >= 2) {
                        String key = parts[0];
                        String value = parts[1];

                        JLabel label = new JLabel(key + ": " + value);
                        label.setFont(new Font("DialogInput", Font.BOLD, 20));
                        add(label);
                    }
                }

                if (accountFound && line.isEmpty()) {
                    break;
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    back.doClick();
                }
            }
        });

        back = new JButton("Back");
        back.setFont(new Font("DialogInput", Font.BOLD, 20));
        back.setBounds(300, 400, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this::performAction);
        add(back);

        setSize(1080, 720);
        setLocation(220, 40);
        setVisible(true);
    }

    public void performAction(java.awt.event.ActionEvent ae){
        if (ae.getActionCommand().equals("Back")){
            new Home_Page(accountNumberText, pinNUmber).setVisible(true);
            dispose();
        }
    }
}