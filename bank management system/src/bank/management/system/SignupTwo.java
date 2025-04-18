package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField pinTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, income, education, occupation;
    String formno;

    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FROM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details:");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22 ));
        additionalDetails.setBounds(290, 80, 500, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String valReligion[] = {"Muslim", "Hindu", "Christian", "Buddhism", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Income:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 190, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel dob = new JLabel("Education:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String educationValues[] = {"Non-Graduate", "Graduate", "Post-Graduate", "PHD", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 240, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);


        JLabel gender = new JLabel("Occupation:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 150, 30);
        add(gender);

        String occupationValues[] = {"Student", "Salaried", "Business", "Retired", "Self-Employed","Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 290, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel pin = new JLabel("NID no:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 340, 150, 30);
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        pinTextField.setBounds(300, 340, 400, 30);
        add(pinTextField);

        JLabel marital = new JLabel("Senior Citizen:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 300, 30);
        add(marital);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 390, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 390, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);

        JLabel address = new JLabel("Existing Account:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 440, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 440, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(eyes);
        accountgroup.add(eno);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String spincode = pinTextField.getText();

        try{
            Conn c = new Conn();
            String query = "Insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+spincode+"', '"+seniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);

            // SignuoThree Object
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String args[]){
        new SignupTwo("");
    }
}
