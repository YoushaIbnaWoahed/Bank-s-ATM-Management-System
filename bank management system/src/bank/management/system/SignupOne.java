package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addressTextField, cityTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, other, single, married, others;
    JDateChooser dateChooser;

    SignupOne(){

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L );

        JLabel formno = new JLabel("APPLICATION FORM NO: " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38 ));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel persondetails = new JLabel("Page 1: Fill up all the Personal Details:");
        persondetails.setFont(new Font("Raleway", Font.BOLD, 22 ));
        persondetails.setBounds(290, 80, 500, 30);
        add(persondetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 100, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(630, 290, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 100, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 300, 30);
        add(marital);

        single = new JRadioButton("Single");
        single.setBounds(300, 390, 100, 30);
        single.setBackground(Color.WHITE);
        add(single);

        married = new JRadioButton("Married");
        married.setBounds(450, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        others = new JRadioButton("Other");
        others.setBounds(630, 390, 100, 30);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(single);
        maritalgroup.add(married);
        maritalgroup.add(others);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 100, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 100, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel pincode = new JLabel("City Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 540, 200, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        pincodeTextField.setBounds(300, 540, 400, 30);
        add(pincodeTextField);


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
        String formno = " " + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (other.isSelected()) {
            gender = "Other";
        }

        String email = emailTextField.getText();
        String marital = null;
        if(single.isSelected()){
            marital = "Single";
        } else if (married.isSelected()) {
            marital = "Married";
        } else if (others.isSelected()) {
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = pincodeTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "All Information are Required");
            }
            else {
                Conn c = new Conn();
                String query = "Insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pincode+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String args[]){
        new SignupOne();
    }
}
