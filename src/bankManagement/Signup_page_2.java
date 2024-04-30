package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Signup_page_2 extends JFrame{
    Signup_page_2(){
        setLayout(null);

        JLabel form = new JLabel("Page 2: ACCOUNT DETAILS");
        form.setFont(new Font("Monospaced", Font.BOLD, 38));
        form.setForeground(Color.BLUE);
        form.setBounds(230, 20, 600, 50);
        add(form);

        JLabel accountType = new JLabel("ACCOUNT TYPE");
        accountType.setFont(new Font("DialogInput", Font.BOLD, 20));
        accountType.setForeground(Color.BLUE);
        accountType.setBounds(100, 140, 200, 30);
        add(accountType);

        JComboBox accountTypeCombo = new JComboBox(new String[]{"Savings", "Current"});
        accountTypeCombo.setBounds(350, 140, 200, 30);
        add(accountTypeCombo);

        JLabel Category = new JLabel("CATEGORY");
        Category.setFont(new Font("DialogInput", Font.BOLD, 20));
        Category.setForeground(Color.BLUE);
        Category.setBounds(100, 190, 200, 30);
        add(Category);

        JComboBox categoryCombo = new JComboBox(new String[]{"General", "OBC", "SC", "ST", "Others"});
        categoryCombo.setBounds(350, 190, 200, 30);
        add(categoryCombo);

        JLabel Income = new JLabel("INCOME");
        Income.setFont(new Font("DialogInput", Font.BOLD, 20));
        Income.setForeground(Color.BLUE);
        Income.setBounds(100, 240, 200, 30);
        add(Income);

        JTextField incomeText = new JTextField();
        incomeText.setBounds(350, 240, 200, 30);
        add(incomeText);

        JLabel pan = new JLabel("PAN NUMBER");
        pan.setFont(new Font("DialogInput", Font.BOLD, 20));
        pan.setForeground(Color.BLUE);
        pan.setBounds(100, 290, 200, 30);
        add(pan);

        JTextField panText = new JTextField();
        panText.setBounds(350, 290, 200, 30);
        add(panText);

        JLabel Occupation = new JLabel("OCCUPATION");
        Occupation.setFont(new Font("DialogInput", Font.BOLD, 20));
        Occupation.setForeground(Color.BLUE);
        Occupation.setBounds(100, 340, 200, 30);
        add(Occupation);

        JComboBox occupationCombo = new JComboBox(new String[]{"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"});
        occupationCombo.setBounds(350, 340, 200, 30);
        add(occupationCombo);

        JLabel education = new JLabel("EDUCATION");
        education.setFont(new Font("DialogInput", Font.BOLD, 20));
        education.setForeground(Color.BLUE);
        education.setBounds(100, 390, 200, 30);
        add(education);

JComboBox educationCombo = new JComboBox(new String[]{"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"});
        educationCombo.setBounds(350, 390, 200, 30);
        add(educationCombo);

        JLabel NID = new JLabel("NID number");
        NID.setFont(new Font("DialogInput", Font.BOLD, 20));
        NID.setForeground(Color.BLUE);
        NID.setBounds(100, 440, 300, 30);
        add(NID);

        JTextField NIDText = new JTextField();
        NIDText.setBounds(350, 440, 200, 30);
        add(NIDText);

        JLabel seniorCitizen = new JLabel("Senior Citizen?");
        seniorCitizen.setFont(new Font("DialogInput", Font.BOLD, 20));
        seniorCitizen.setForeground(Color.BLUE);
        seniorCitizen.setBounds(100, 490, 300, 30);
        add(seniorCitizen);

        JRadioButton yes = new JRadioButton("Yes");
        yes.setFont(new Font("DialogInput", Font.BOLD, 20));
        yes.setBounds(350, 490, 100, 30);
        yes.setBackground(new java.awt.Color(204, 204, 255));
        add(yes);

        JRadioButton no = new JRadioButton("No");
        no.setFont(new Font("DialogInput", Font.BOLD, 20));
        no.setBounds(450, 490, 100, 30);
        no.setBackground(new java.awt.Color(204, 204, 255));
        add(no);

        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(yes);
        seniorCitizenGroup.add(no);

        JLabel existingAccount = new JLabel("Existing Account?");
        existingAccount.setFont(new Font("DialogInput", Font.BOLD, 20));
        existingAccount.setForeground(Color.BLUE);
        existingAccount.setBounds(100, 540, 300, 30);
        add(existingAccount);

        JRadioButton yes1 = new JRadioButton("Yes");
        yes1.setFont(new Font("DialogInput", Font.BOLD, 20));
        yes1.setBounds(350, 540, 100, 30);
        yes1.setBackground(new java.awt.Color(204, 204, 255));
        add(yes1);

        JRadioButton no1 = new JRadioButton("No");
        no1.setFont(new Font("DialogInput", Font.BOLD, 20));
        no1.setBounds(450, 540, 100, 30);
        no1.setBackground(new java.awt.Color(204, 204, 255));
        add(no1);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(yes1);
        existingAccountGroup.add(no1);

        JButton next = new JButton("Next");
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.setBounds(550, 600, 100, 30);
        next.addActionListener(this::actionPerformed);
        add(next);

        JButton back = new JButton("Back");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setBounds(400, 600, 100, 30);
        back.addActionListener(this::actionPerformed);
        add(back);


        getContentPane().setBackground(new java.awt.Color(204, 204, 255));

        setSize(800, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(java.awt.event.ActionEvent ae){
        if ( ae.getActionCommand().equals("Next")){

        } else if ( ae.getActionCommand().equals("Back")){
            new Signup();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Signup_page_2();
    }
}
