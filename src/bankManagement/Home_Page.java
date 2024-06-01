package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Home_Page extends JFrame {
    JButton deposit, withdraw, transfer, pinChange, transactionHistory, viewProfile, logout, deleteAccount, loan, payBill;
    private String pinNumber, accountNumber, balance, name;

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    Home_Page(String accountNumber, String pinNumber){
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;

        try{

            BufferedReader reader1 = new BufferedReader(new FileReader("src/bankManagement/Signup.txt"));
            String line1;
            String currentAccountNumber = null;
            String currentPin = null;
            while ((line1 = reader1.readLine()) != null) {
                String[] parts = line1.split(": ");
                if (parts[0].equals("Account Number")) {
                    currentAccountNumber = parts[1];
                } else if (parts[0].equals("Pin Number")) {
                    currentPin = parts[1];
                } else if (parts[0].equals("Balance") && currentAccountNumber.equals(accountNumber) && currentPin.equals(pinNumber)) {
                    balance = parts[1];
                } else if (parts[0].equals("Name") && currentAccountNumber.equals(accountNumber)) {
                    name = parts[1];
                }
            }
            reader1.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        ImageIcon backgroundImage = new ImageIcon("src/icons/transactions.jpg");
        Image img = backgroundImage.getImage().getScaledInstance(1080, 720, Image.SCALE_DEFAULT);
        ImageIcon background = new ImageIcon(img);


        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1080, 720);

        add(backgroundLabel);

        JLabel greeting = new JLabel("Welcome back ");
        greeting.setFont(new Font("Raleway", Font.BOLD, 38));
        greeting.setForeground(Color.BLUE);
        greeting.setBounds(350, 50, 600, 50);
        backgroundLabel.add(greeting);

        JLabel name = new JLabel(this.name);
        name.setFont(new Font("Raleway", Font.BOLD, 38));
        name.setForeground(Color.BLUE);
        name.setBounds(350, 100, 600, 50);
        backgroundLabel.add(name);

        JLabel l1 = new JLabel("Balance: " + balance);
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setForeground(Color.BLUE);
        l1.setBounds(400, 150, 600, 50);
        backgroundLabel.add(l1);

        deposit = new JButton("DEPOSIT");
        deposit.setBackground(Color.BLUE);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("Raleway", Font.BOLD, 20));
        deposit.setBounds(200, 250, 250, 50);
        deposit.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    withdraw.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    pinChange.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    logout.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    deposit.doClick();
                }
            }
        });
        backgroundLabel.add(deposit);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBackground(Color.BLUE);
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 20));
        withdraw.setBounds(600, 250, 250, 50);
        withdraw.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    deposit.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    transactionHistory.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    logout.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    withdraw.doClick();
                }
            }
        });
        backgroundLabel.add(withdraw);

        transfer = new JButton("TRANSFER");
        transfer.setBackground(Color.BLUE);
        transfer.setForeground(Color.WHITE);
        transfer.setFont(new Font("Raleway", Font.BOLD, 20));
        transfer.setBounds(600, 550, 250, 50);
        transfer.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    loan.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    payBill.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    deleteAccount.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    logout.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    transfer.doClick();
                }
            }
        });
        backgroundLabel.add(transfer);

        pinChange = new JButton("CHANGE PIN");
        pinChange.setBackground(Color.BLUE);
        pinChange.setForeground(Color.WHITE);
        pinChange.setFont(new Font("Raleway", Font.BOLD, 20));
        pinChange.setBounds(200, 350, 250, 50);
        pinChange.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    deposit.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    transactionHistory.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    viewProfile.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    logout.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pinChange.doClick();
                }
            }
        });
        backgroundLabel.add(pinChange);

        transactionHistory = new JButton("TRANSACTION HISTORY");
        transactionHistory.setBackground(Color.BLUE);
        transactionHistory.setForeground(Color.WHITE);
        transactionHistory.setFont(new Font("Raleway", Font.BOLD, 15));
        transactionHistory.setBounds(600, 350, 250, 50);
        transactionHistory.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    withdraw.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    pinChange.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    loan.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    logout.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    transactionHistory.doClick();
                }
            }
        });
        backgroundLabel.add(transactionHistory);

        viewProfile = new JButton("VIEW PROFILE");
        viewProfile.setBackground(Color.BLUE);
        viewProfile.setForeground(Color.WHITE);
        viewProfile.setFont(new Font("Raleway", Font.BOLD, 20));
        viewProfile.setBounds(200, 450, 250, 50);
        viewProfile.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    pinChange.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    loan.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    payBill.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    logout.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    viewProfile.doClick();
                }
            }
        });
        backgroundLabel.add(viewProfile);

        logout = new JButton("LOGOUT");
        logout.setBackground(Color.GREEN);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Oswarld", Font.BOLD, 20));
        logout.setBounds(200, 650, 250, 50);
        logout.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    payBill.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    deleteAccount.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    logout.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    logout.doClick();
                }
            }
        });
        backgroundLabel.add(logout);

        deleteAccount = new JButton("DELETE ACCOUNT");
        deleteAccount.setBackground(Color.RED);
        deleteAccount.setForeground(Color.WHITE);
        deleteAccount.setFont(new Font("Oswarld", Font.BOLD, 20));
        deleteAccount.setBounds(600, 650, 250, 50);
        deleteAccount.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    transfer.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    logout.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    logout.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    deleteAccount.doClick();
                }
            }
        });
        backgroundLabel.add(deleteAccount);

        payBill = new JButton("PAY BILL");
        payBill.setBackground(Color.BLUE);
        payBill.setForeground(Color.WHITE);
        payBill.setFont(new Font("Oswarld", Font.BOLD, 20));
        payBill.setBounds(200, 550, 250, 50);
        payBill.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    viewProfile.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    transfer.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    logout.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    logout.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    payBill.doClick();
                }
            }
        });
        backgroundLabel.add(payBill);

        loan = new JButton("LOAN");
        loan.setBackground(Color.BLUE);
        loan.setForeground(Color.WHITE);
        loan.setFont(new Font("Oswarld", Font.BOLD, 20));
        loan.setBounds(600, 450, 250, 50);
        loan.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    transactionHistory.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    viewProfile.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    transfer.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    logout.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loan.doClick();
                }
            }
        });
        backgroundLabel.add(loan);


        ButtonActionHandler buttonActionHandler = new ButtonActionHandler(this);
        deposit.addActionListener(buttonActionHandler);
        withdraw.addActionListener(buttonActionHandler);
        pinChange.addActionListener(buttonActionHandler);
        loan.addActionListener(buttonActionHandler);
        payBill.addActionListener(buttonActionHandler);
        logout.addActionListener(buttonActionHandler);
        transfer.addActionListener(buttonActionHandler);
        transactionHistory.addActionListener(buttonActionHandler);
        viewProfile.addActionListener(buttonActionHandler);
        deleteAccount.addActionListener(buttonActionHandler);



        setSize(1080, 760);
        setLocation(220, 20);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Home_Page("", "");
    }
}
