package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Admin_Login extends JFrame {
    JButton viewListButton, viewTransactionHistoryButton;
    JTextArea view;

    Admin_Login() {
        setLayout(null);

        getContentPane().setBackground(new java.awt.Color(204, 204, 255));

        setSize(1080, 720);
        setLocation(220, 40);
        setVisible(true);

        viewListButton = new JButton("VIEW LIST OF ACCOUNTS");
        viewListButton.setBackground(Color.BLUE);
        viewListButton.setForeground(Color.WHITE);
        viewListButton.setBounds(250, 270, 200, 30);
        viewListButton.addActionListener(this::actionPerformed);
        add(viewListButton);

        viewTransactionHistoryButton = new JButton("VIEW TRANSACTION HISTORY");
        viewTransactionHistoryButton.setBackground(Color.BLUE);
        viewTransactionHistoryButton.setForeground(Color.WHITE);
        viewTransactionHistoryButton.setBounds(250, 320, 200, 30);
        viewTransactionHistoryButton.addActionListener(this::actionPerformed);
        add(viewTransactionHistoryButton);

        view = new JTextArea();
        view.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(view);
        scrollPane.setBounds(500, 10, 500, 500);
        add(scrollPane);

    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == viewListButton) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("src/bankManagement/Signup.txt"));
                String line = reader.readLine();

                view.setText("");

                while (line != null) {
                    view.append(line + "\n");
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == viewTransactionHistoryButton) {
            try {
                String accountNumber = JOptionPane.showInputDialog("Enter Account Number: ");

                BufferedReader reader = new BufferedReader(new FileReader("src/accountManager/" + accountNumber + ".txt"));
                String line = reader.readLine();

                view.setText("");

                while (line != null) {
                    view.append(line + "\n");
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Admin_Login().setVisible(true);
    }
}
