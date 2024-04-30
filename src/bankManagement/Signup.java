package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Signup extends JFrame {
    Signup(){
        setLayout(null);

        JLabel form = new JLabel("SIGN UP FORM");
        form.setFont(new Font("Monospaced", Font.BOLD, 38));
        form.setForeground(Color.BLUE);
        form.setBounds(250, 20, 600, 50);
        add(form);

        JLabel personalDetails = new JLabel("Page 1: PERSONAL DETAILS");
        personalDetails.setFont(new Font("Monospaced", Font.BOLD, 22));
        personalDetails.setForeground(Color.BLUE);
        personalDetails.setBounds(230, 80, 600, 50);
        add(personalDetails);

        JLabel name = new JLabel("NAME");
        name.setFont(new Font("DialogInput", Font.BOLD, 20));
        name.setForeground(Color.BLUE);
        name.setBounds(100, 140, 100, 30);
        add(name);

        JTextField nameText = new JTextField();
        nameText.setBounds(300, 140, 200, 30);
        add(nameText);

        JLabel fatherName = new JLabel("FATHER'S NAME");
        fatherName.setFont(new Font("DialogInput", Font.BOLD, 20));
        fatherName.setForeground(Color.BLUE);
        fatherName.setBounds(100, 190, 200, 30);
        add(fatherName);

        JTextField fatherNameText = new JTextField();
        fatherNameText.setBounds(300, 190, 200, 30);
        add(fatherNameText);

        JLabel motherName = new JLabel("MOTHER'S NAME");
        motherName.setFont(new Font("DialogInput", Font.BOLD, 20));
        motherName.setForeground(Color.BLUE);
        motherName.setBounds(100, 240, 200, 30);
        add(motherName);

        JTextField motherNameText = new JTextField();
        motherNameText.setBounds(300, 240, 200, 30);
        add(motherNameText);

        JLabel dob = new JLabel("DATE OF BIRTH");
        dob.setFont(new Font("DialogInput", Font.BOLD, 20));
        dob.setForeground(Color.BLUE);
        dob.setBounds(100, 290, 200, 30);
        add(dob);

        JTextField dobText = new JTextField();
        dobText.setBounds(300, 290, 200, 30);
        add(dobText);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("DialogInput", Font.BOLD, 20));
        gender.setForeground(Color.BLUE);
        gender.setBounds(100, 340, 200, 30);
        add(gender);

        JRadioButton male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 20));
        male.setBounds(300, 340, 100, 30);
        male.setBackground(new java.awt.Color(204, 204, 255));
        add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD, 20));
        female.setBounds(400, 340, 100, 30);
        female.setBackground(new java.awt.Color(204, 204, 255));
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("DialogInput", Font.BOLD, 20));
        email.setForeground(Color.BLUE);
        email.setBounds(100, 390, 200, 30);
        add(email);

        JTextField emailText = new JTextField();
        emailText.setBounds(300, 390, 200, 30);
        add(emailText);

        JLabel maritalStatus = new JLabel("MARITAL STATUS");
        maritalStatus.setFont(new Font("DialogInput", Font.BOLD, 20));
        maritalStatus.setForeground(Color.BLUE);
        maritalStatus.setBounds(100, 440, 200, 30);
        add(maritalStatus);

        JRadioButton married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.BOLD, 20));
        married.setBounds(300, 440, 100, 30);
        married.setBackground(new java.awt.Color(204, 204, 255));
        add(married);

        JRadioButton unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway", Font.BOLD, 20));
        unmarried.setBounds(400, 440, 200, 30);
        unmarried.setBackground(new java.awt.Color(204, 204, 255));
        add(unmarried);

        ButtonGroup maritalStatusGroup = new ButtonGroup();
        maritalStatusGroup.add(married);
        maritalStatusGroup.add(unmarried);

        JLabel address = new JLabel("ADDRESS");
        address.setFont(new Font("DialogInput", Font.BOLD, 20));
        address.setForeground(Color.BLUE);
        address.setBounds(100, 490, 200, 30);
        add(address);

        JTextField addressText = new JTextField();
        addressText.setBounds(300, 490, 200, 30);
        add(addressText);

        JLabel city = new JLabel("CITY");
        city.setFont(new Font("DialogInput", Font.BOLD, 20));
        city.setForeground(Color.BLUE);
        city.setBounds(100, 540, 200, 30);
        add(city);

        JTextField cityText = new JTextField();
        cityText.setBounds(300, 540, 200, 30);
        add(cityText);

        JLabel zipCode = new JLabel("ZIP CODE");
        zipCode.setFont(new Font("DialogInput", Font.BOLD, 20));
        zipCode.setForeground(Color.BLUE);
        zipCode.setBounds(100, 590, 200, 30);
        add(zipCode);

        JTextField zipCodeText = new JTextField();
        zipCodeText.setBounds(300, 590, 200, 30);
        add(zipCodeText);

        JLabel Religion = new JLabel("RELIGION");
        Religion.setFont(new Font("DialogInput", Font.BOLD, 20));
        Religion.setForeground(Color.BLUE);
        Religion.setBounds(100, 640, 200, 30);
        add(Religion);

        JComboBox religion = new JComboBox(new String[]{"Muslim", "Hindu", "Christian", "Other"});
        religion.setBounds(300, 640, 200, 30);
        add(religion);

        JButton next = new JButton("Next");
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.setBounds(500, 690, 100, 30);
        next.addActionListener(this::actionPerformed);
        add(next);

        JButton back = new JButton("Back");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 690, 100, 30);
        back.addActionListener(this::actionPerformed);
        add(back);


        getContentPane().setBackground(new java.awt.Color(204, 204, 255));

        setSize(800, 800);
        setLocation(350, 10);
        setVisible(true);


    }

    public void actionPerformed(java.awt.event.ActionEvent ae){
        if(ae.getActionCommand().equals("Next")){
            new Signup_page_2();
            setVisible(false);
        } else {
            new Login();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
