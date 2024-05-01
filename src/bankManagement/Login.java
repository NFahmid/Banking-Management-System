package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;

public class Login extends javax.swing.JFrame{
    JButton login, signUp, clear, showPassword, forgotPassword;
    JTextField accountNoTextField;
    JPasswordField pinNoTextField;

    Login(){
        setTitle("AMAR BANK ATM");
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo2.jpg"));
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(image);
        JLabel label = new JLabel(icon1);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel title = new JLabel("WELCOME TO AMAR BANK");
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
        add(accountNoTextField);

        pinNoTextField = new JPasswordField();
        pinNoTextField.setBounds(250, 200, 200, 30);
        add(pinNoTextField);

        login = new JButton("LOGIN");
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.setBounds(250, 270, 100, 30);
        login.addActionListener(this::actionPerformed);
        add(login);

        signUp = new JButton("SIGN UP");
        signUp.setBackground(Color.BLUE);
        signUp.setForeground(Color.WHITE);
        signUp.setBounds(400, 270, 100, 30);
        signUp.addActionListener(this::actionPerformed);
        add(signUp);

        clear = new JButton("Clear");
        clear.setBackground(Color.BLUE);
        clear.setForeground(Color.WHITE);
        clear.setBounds(300, 320, 150, 30);
        clear.addActionListener(this::actionPerformed);
        add(clear);

        showPassword = new JButton("Show Password");
        showPassword.setBackground(Color.BLUE);
        showPassword.setForeground(Color.WHITE);
        showPassword.setBounds(460, 200, 150, 30);
        showPassword.addActionListener(this::actionPerformed);
        add(showPassword);

        forgotPassword = new JButton("Forgot Password");
        forgotPassword.setBackground(Color.BLUE);
        forgotPassword.setForeground(Color.WHITE);
        forgotPassword.setBounds(460, 150, 150, 30);
        forgotPassword.addActionListener(this::actionPerformed);
        add(forgotPassword);

        getContentPane().setBackground(Color.BLACK);

        setSize (800, 400);
        setVisible(true);
        setLocation (350, 200);


    }

    public void actionPerformed(java.awt.event.ActionEvent ae) {
        if ( ae.getSource() == login){

        } else if ( ae.getSource() == signUp){
            try {
                FileWriter fileWriter = new FileWriter("src/bankManagement/Signup.txt", true);
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
            pinNoTextField.setEchoChar((char) 0);
        } else if ( ae.getSource() == forgotPassword){

        }
    }



    public static void main(String[] args) {
        new Login();
    }
}
