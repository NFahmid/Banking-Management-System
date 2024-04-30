import javax.swing.*;

public class Login extends javax.swing.JFrame{

    Login(){
        setTitle("AMAR BANK ATM");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));

        setSize (800, 400);
        setVisible(true);
        setLocation (350, 200);


    }

    public static void main(String[] args) {
        new Login();
    }
}
