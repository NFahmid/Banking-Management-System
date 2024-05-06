package bankManagement;

import javax.swing.*;

public class Employees extends JFrame {
    Employees(){
        setLayout(null);

        JLabel l1 = new JLabel("EMPLOYEES");
        l1.setBounds(400, 20, 200, 30);
        add(l1);

        

        setSize(1080, 720);
        setLocation(350, 10);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employees();
    }
}
