package bankManagement;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GUI_Interface_2 extends JFrame {
    GUI_Interface_2() {
        setLayout(null);

        getContentPane().setBackground(new java.awt.Color(204, 204, 255));

        setSize(1080, 720);
        setLocation(220, 40);
        setVisible(true);
    }

    public String getCurrentBalance(String accountNumber, String pinNumber) {
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
                    } else if (key.equals("Pin Number")) {
                        currentPinNumber = value;
                    } else if (key.equals("Balance") && currentAccountNumber.equals(accountNumber) && currentPinNumber.equals(pinNumber)) {
                        return value;
                    }
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateBalance(String accountNumber, String pinNumber, String newBalance) {
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
                    } else if (key.equals("Pin Number")) {
                        currentPinNumber = value;
                    } else if (key.equals("Balance") && currentAccountNumber.equals(accountNumber) && currentPinNumber.equals(pinNumber)) {
                        currentLine = "Balance: " + newBalance;
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

    public abstract void performAction(java.awt.event.ActionEvent ae);
}
