package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;

public class Signup_page_2 extends GUI_Interface{
    JLabel form, accountType, contactNumber, Income, Occupation, education, NID, existingAccount, nomineeName, nomineeRelation, nomineeAge, nomineeAddress, nomineeContact, nomineeNID;
    JTextField incomeText, panText, NIDText, contactNumberText, nomineeNameText, nomineeRelationText, nomineeAgeText, nomineeAddressText, nomineeContactText, nomineeNIDText;
    JComboBox accountTypeCombo, occupationCombo, educationCombo;
    JRadioButton yes, no, yes1, no1;
    ButtonGroup seniorCitizenGroup, existingAccountGroup;
    int accountNumber;


    Signup_page_2(int accountNumber){
        this.accountNumber = accountNumber;

         form = new JLabel("Page 2");
        form.setFont(new Font("Monospaced", Font.BOLD, 38));
        form.setForeground(Color.BLUE);
        form.setBounds(350, 20, 200, 50);
        add(form);

         accountType = new JLabel("ACCOUNT TYPE");
        accountType.setFont(new Font("DialogInput", Font.BOLD, 20));
        accountType.setForeground(Color.BLUE);
        accountType.setBounds(100, 80, 200, 30);
        add(accountType);

         accountTypeCombo = new JComboBox(new String[]{"Savings", "Current", "Fixed Deposit", "Recurring Deposit"});
        accountTypeCombo.setBounds(550, 80, 200, 30);
        add(accountTypeCombo);

         contactNumber = new JLabel("ContactNumber(01XXXXXXXXX): ");
        contactNumber.setFont(new Font("DialogInput", Font.BOLD, 20));
        contactNumber.setForeground(Color.BLUE);
        contactNumber.setBounds(100, 130, 500, 30);
        add(contactNumber);

         contactNumberText = new JTextField();
        contactNumberText.setBounds(550, 130, 200, 30);
        add(contactNumberText);

         Income = new JLabel("INCOME");
        Income.setFont(new Font("DialogInput", Font.BOLD, 20));
        Income.setForeground(Color.BLUE);
        Income.setBounds(100, 180, 200, 30);
        add(Income);

         incomeText = new JTextField();
        incomeText.setBounds(550, 180, 200, 30);
        add(incomeText);

        Occupation = new JLabel("Occupation: ");
        Occupation.setFont(new Font("DialogInput", Font.BOLD, 20));
        Occupation.setForeground(Color.BLUE);
        Occupation.setBounds(100, 230, 200, 30);
        add(Occupation);

        occupationCombo = new JComboBox(new String[]{"Student", "Business", "Service", "Retired", "Others"});
        occupationCombo.setBounds(550, 230, 200, 30);
        add(occupationCombo);

        education = new JLabel("Education: ");
        education.setFont(new Font("DialogInput", Font.BOLD, 20));
        education.setForeground(Color.BLUE);
        education.setBounds(100, 280, 200, 30);
        add(education);

        educationCombo = new JComboBox(new String[]{"Primary", "Secondary", "Higher Secondary", "Graduate", "Post Graduate", "Others"});
        educationCombo.setBounds(550, 280, 200, 30);
        add(educationCombo);

        NID = new JLabel("NID number: ");
        NID.setFont(new Font("DialogInput", Font.BOLD, 20));
        NID.setForeground(Color.BLUE);
        NID.setBounds(100, 330, 200, 30);
        add(NID);

        NIDText = new JTextField();
        NIDText.setBounds(550, 330, 200, 30);
        add(NIDText);

        existingAccount = new JLabel("Do you have an existing account?");
        existingAccount.setFont(new Font("DialogInput", Font.BOLD, 20));
        existingAccount.setForeground(Color.BLUE);
        existingAccount.setBounds(100, 380, 450, 30);
        add(existingAccount);

        yes1 = new JRadioButton("Yes");
        yes1.setFont(new Font("Raleway", Font.BOLD, 20));
        yes1.setBounds(550, 380, 100, 30);
        yes1.setBackground(new java.awt.Color(204, 204, 255));
        add(yes1);

        no1 = new JRadioButton("No");
        no1.setFont(new Font("Raleway", Font.BOLD, 20));
        no1.setBounds(650, 380, 100, 30);
        no1.setBackground(new java.awt.Color(204, 204, 255));
        add(no1);

        existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(yes1);
        existingAccountGroup.add(no1);

        nomineeName = new JLabel("Nominee Name: ");
        nomineeName.setFont(new Font("DialogInput", Font.BOLD, 20));
        nomineeName.setForeground(Color.BLUE);
        nomineeName.setBounds(100, 430, 350, 30);
        add(nomineeName);

        nomineeNameText = new JTextField();
        nomineeNameText.setBounds(550, 430, 200, 30);
        add(nomineeNameText);

        nomineeRelation = new JLabel("Nominee Relation: ");
        nomineeRelation.setFont(new Font("DialogInput", Font.BOLD, 20));
        nomineeRelation.setForeground(Color.BLUE);
        nomineeRelation.setBounds(100, 480, 350, 30);
        add(nomineeRelation);

        nomineeRelationText = new JTextField();
        nomineeRelationText.setBounds(550, 480, 200, 30);
        add(nomineeRelationText);

        nomineeAge = new JLabel("Nominee Age: ");
        nomineeAge.setFont(new Font("DialogInput", Font.BOLD, 20));
        nomineeAge.setForeground(Color.BLUE);
        nomineeAge.setBounds(100, 530, 350, 30);
        add(nomineeAge);

        nomineeAgeText = new JTextField();
        nomineeAgeText.setBounds(550, 530, 200, 30);
        add(nomineeAgeText);

        nomineeAddress = new JLabel("Nominee Address: ");
        nomineeAddress.setFont(new Font("DialogInput", Font.BOLD, 20));
        nomineeAddress.setForeground(Color.BLUE);
        nomineeAddress.setBounds(100, 580, 350, 30);
        add(nomineeAddress);

        nomineeAddressText = new JTextField();
        nomineeAddressText.setBounds(550, 580, 200, 30);
        add(nomineeAddressText);

        nomineeContact = new JLabel("Nominee Contact: ");
        nomineeContact.setFont(new Font("DialogInput", Font.BOLD, 20));
        nomineeContact.setForeground(Color.BLUE);
        nomineeContact.setBounds(100, 630, 350, 30);
        add(nomineeContact);

        nomineeContactText = new JTextField();
        nomineeContactText.setBounds(550, 630, 200, 30);
        add(nomineeContactText);

        nomineeNID = new JLabel("Nominee NID/ Passport number:");
        nomineeNID.setFont(new Font("DialogInput", Font.BOLD, 20));
        nomineeNID.setForeground(Color.BLUE);
        nomineeNID.setBounds(100, 680, 350, 30);
        add(nomineeNID);

        nomineeNIDText = new JTextField();
        nomineeNIDText.setBounds(550, 680, 200, 30);
        add(nomineeNIDText);

        JButton next = new JButton("Next");
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.setBounds(500, 730, 100, 30);
        next.addActionListener(this::performAction);
        add(next);

        JButton back = new JButton("Back");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 730, 100, 30);
        back.addActionListener(this::performAction);
        add(back);

        revalidate();
        repaint();
    }

    public void performAction(java.awt.event.ActionEvent ae){
        if (ae.getActionCommand().equals("Next")){
            if(incomeText.getText().isEmpty() || panText.getText().isEmpty() || NIDText.getText().isEmpty() ||
                    accountTypeCombo.getSelectedItem() == null || contactNumberText.getText() == null ||
                    occupationCombo.getSelectedItem() == null || educationCombo.getSelectedItem() == null
                    || existingAccountGroup.getSelection() == null) {
                JOptionPane.showMessageDialog(this, "All fields must be filled before proceeding.");
            } if (contactNumberText.getText() != null && contactNumberText.getText().length() != 11){
                JOptionPane.showMessageDialog(this, "Contact number format not correct.");
            } if (NIDText.getText() != null && NIDText.getText().length() != 10){
                JOptionPane.showMessageDialog(this, "NID number must be 10 characters long.");
            } if (incomeText.getText() != null && !incomeText.getText().matches("[0-9]+")){
                JOptionPane.showMessageDialog(this, "Income must be a number.");
            } if (NIDText.getText() != null && !NIDText.getText().matches("[0-9]+")){
                JOptionPane.showMessageDialog(this, "NID number must be a number.");
            } if (contactNumberText.getText() != null && !contactNumberText.getText().matches("[0-9]+")){
                JOptionPane.showMessageDialog(this, "Contact number must be a number.");
            }  if (yes1.isSelected() && no1.isSelected()){
                JOptionPane.showMessageDialog(this, "Select only one option for Existing Account.");
            } else {
                try{
                    FileWriter file = new FileWriter("src/bankManagement/Signup.txt", true);
                    file.write("Account Type: " + accountTypeCombo.getSelectedItem() + "\n");
                    file.write("contactNumber of account: " + contactNumberText.getText() + "\n");
                    file.write("Income: " + incomeText.getText() + "\n");
                    file.write("Occupation: " + occupationCombo.getSelectedItem() + "\n");
                    file.write("Education: " + educationCombo.getSelectedItem() + "\n");
                    file.write("NID number: " + NIDText.getText() + "\n");
                    if(yes1.isSelected()){
                        file.write("Existing Account: Yes\n");
                    } else {
                        file.write("Existing Account: No\n");
                    }
                    file.write("Nominee Name: " + nomineeNameText.getText() + "\n");
                    file.write("Nominee Relation: " + nomineeRelationText.getText() + "\n");
                    file.write("Nominee Age: " + nomineeAgeText.getText() + "\n");
                    file.write("Nominee Address: " + nomineeAddressText.getText() + "\n");
                    file.write("Nominee Contact: " + nomineeContactText.getText() + "\n");
                    file.write("Nominee NID: " + nomineeNIDText.getText() + "\n");
                    file.close();

                    new Signup_page_3(accountNumber);
                    setVisible(false);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else if ( ae.getActionCommand().equals("Back")){
            new Signup();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Signup_page_2(0);
    }
}
