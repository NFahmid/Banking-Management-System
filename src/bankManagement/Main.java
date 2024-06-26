package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

public class Main extends JFrame{
    private JButton login, signUp, clear, forgotPassword, exit;
    private JTextField accountNoTextField;
    private JPasswordField pinNoTextField;
    private JToggleButton showPassword;

    Main(){
        setTitle("Login Page");

        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo2.png"));
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(image);
        JLabel label = new JLabel(icon1);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel title = new JLabel("WELCOME TO CIPHER BANK");
        title.setFont(new Font("Monospaced", Font.BOLD, 38));
        title.setForeground(Color.BLUE);
        title.setBounds(200, 20, 600, 50);
        add(title);

        JLabel l4 = new JLabel("Please enter your credentials to login");
        l4.setFont(new Font("Monospaced", Font.BOLD, 20));
        l4.setForeground(Color.BLUE);
        l4.setBounds(200, 70, 600, 50);
        add(l4);

        JLabel accountNo = new JLabel("Account No. :");
        accountNo.setFont(new Font("DialogInput", Font.BOLD, 20));
        accountNo.setForeground(Color.BLUE);
        accountNo.setBounds(50, 150, 200, 30);
        add(accountNo);

        JLabel pinNo = new JLabel("PIN:");
        pinNo.setFont(new Font("DialogInput", Font.BOLD, 20));
        pinNo.setForeground(Color.BLUE);
        pinNo.setBounds(50, 200, 150, 30);
        add(pinNo);

        accountNoTextField = new JTextField();
        accountNoTextField.setBounds(250, 150, 200, 30);
        accountNoTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pinNoTextField.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });
        add(accountNoTextField);

        pinNoTextField = new JPasswordField();
        pinNoTextField.setBounds(250, 200, 200, 30);
        pinNoTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login.doClick();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });
        add(pinNoTextField);

        login = new JButton("LOGIN");
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.setBounds(250, 270, 100, 30);
        login.addActionListener(this::performAction);
        add(login);

        signUp = new JButton("SIGN UP");
        signUp.setBackground(Color.BLUE);
        signUp.setForeground(Color.WHITE);
        signUp.setBounds(400, 270, 100, 30);
        signUp.addActionListener(this::performAction);
        add(signUp);

        clear = new JButton("Clear");
        clear.setBackground(Color.BLUE);
        clear.setForeground(Color.WHITE);
        clear.setBounds(250, 320, 100, 30);
        clear.addActionListener(this::performAction);
        add(clear);

        showPassword = new JToggleButton("Show Password");
        showPassword.setBackground(Color.GREEN);
        showPassword.setForeground(Color.BLACK);
        showPassword.setBounds(460, 200, 150, 30);
        showPassword.addActionListener(this::performAction);
        add(showPassword);

        forgotPassword = new JButton("Forgot Password");
        forgotPassword.setBackground(Color.BLUE);
        forgotPassword.setForeground(Color.WHITE);
        forgotPassword.setBounds(460, 150, 150, 30);
        forgotPassword.addActionListener(this::performAction);
        add(forgotPassword);

        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setBounds(400, 320, 100, 30);
        exit.addActionListener(e -> System.exit(0));
        add(exit);

        getContentPane().setBackground(new java.awt.Color(204, 204, 255));

        setSize (800, 400);
        setVisible(true);
        setLocation (350, 200);

    }

    public void performAction(java.awt.event.ActionEvent ae) {
        if ( ae.getSource() == login){
            try {
                BufferedReader reader = new BufferedReader(new FileReader("src/bankManagement/Signup.txt"));
                String line;
                String enteredAccountNumber = accountNoTextField.getText();
                String enteredPin = new String(pinNoTextField.getPassword());
                String currentAccountNumber = null;
                boolean loginSuccessful = false;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(": ");
                    if (parts.length >= 2) {
                        String key = parts[0];
                        String value = parts[1];

                        if (key.equals("Account Number")) {
                            currentAccountNumber = value;
                        } else if (key.equals("Pin Number") && value.equals(enteredPin) && currentAccountNumber.equals(enteredAccountNumber)) {
                            loginSuccessful = true;
                            break;
                        }
                    }
                }

                if (loginSuccessful) {
                    String accountNumber = accountNoTextField.getText();
                    String pin = new String(pinNoTextField.getPassword());
                    new Home_Page(accountNumber, pin).setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid account number or pin");
                }

                reader.close();
            }  catch (IOException e){
                e.printStackTrace();
            } catch (NullPointerException e){
                JOptionPane.showMessageDialog(null, "Invalid account number or pin");
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if ( ae.getSource() == signUp){
            try {
                FileWriter fileWriter = new FileWriter("src/bankManagement/Signup.txt", true);
            } catch (IOException e){
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
            Signup signup = new Signup();
            signup.setVisible(true);
            setVisible(false);
        } else if ( ae.getSource() == clear){
            accountNoTextField.setText("");
            pinNoTextField.setText("");
        } else if ( ae.getSource() == showPassword){
            if (showPassword.isSelected()){
                pinNoTextField.setEchoChar((char)0);
            } else {
                pinNoTextField.setEchoChar('*');
            }
        } else if ( ae.getSource() == forgotPassword){
            new Forgot_Password().setVisible(true);
            setVisible(false);
        } else if ( ae.getSource() == exit){
            System.exit(0);
        }
    }



    public static void main(String[] args) {
        new Main();
    }
}
