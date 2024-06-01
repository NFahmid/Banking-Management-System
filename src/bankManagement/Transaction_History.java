package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Transaction_History extends JFrame {
    String accountNumber, pinNumber;
    JButton back;
    Transaction_History(String accountNumber, String pinNumber){
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;

        setTitle("Transaction History");

        setLayout(new BorderLayout());

        JTextArea transaction= new JTextArea();
        transaction.setBounds(0, 0, 1000, 720);
        transaction.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(transaction);
        add(scrollPane, BorderLayout.CENTER);

        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/accountManager/" + accountNumber + ".txt"));
            String line = reader.readLine();
            while (line != null){
                transaction.append(line + "\n");
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        getContentPane().setBackground(new java.awt.Color(204, 204, 255));

        setSize(1080, 720);
        setLocation(220, 40);
        setVisible(true);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    back.doClick();
                }
            }
        });

        back = new JButton("Back");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Oswarld", Font.BOLD, 20));
        back.setBounds(600, 450, 250, 50);
        back.addActionListener(this::performAction);
        add(back, BorderLayout.SOUTH);

        revalidate();
        repaint();

    }

    public void performAction(java.awt.event.ActionEvent ae){
        if(ae.getSource() == back){
            new Home_Page(accountNumber, pinNumber).setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new Transaction_History("", "");
    }
}
