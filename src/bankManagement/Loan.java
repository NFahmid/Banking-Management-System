package bankManagement;

import javax.swing.*;

public class Loan extends JFrame {
    String accountNumber, pinNumber;
    Loan(String accountNumber, String pinNumber){
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;

    }

    public static void main(String[] args) {
        new Loan(" ", " ");
    }
}
