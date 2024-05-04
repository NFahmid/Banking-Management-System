package bankManagement;

import javax.swing.*;
import java.awt.*;

public abstract class GUI_Interface extends JFrame {
    GUI_Interface() {
        setLayout(null);

        getContentPane().setBackground(new java.awt.Color(204, 204, 255));

        setSize(800, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public abstract void performAction(java.awt.event.ActionEvent ae);
}
