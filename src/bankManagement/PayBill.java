package bankManagement;

import javax.swing.*;

public class PayBill extends JFrame {
    String accountNumber, pinNumber;
    PayBill(String accountNumber, String pinNumber){
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;
    }

    public static void main(String[] args) {
        new PayBill(" ", " ");
    }
}
