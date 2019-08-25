package com.captcha;

import java.awt.event.*;  
import java.awt.*;  
import javax.swing.*;  
import java.sql.*;
import java.io.*;

public class Register extends JFrame implements ActionListener {
	
	String[] gender= {"Male","Female"};
	JLabel nameLabel = new JLabel("NAME");
	JLabel genderLabel = new JLabel("GENDER");
	JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel confirmPasswordLabel=new JLabel("CONFIRM PASSWORD");
    JLabel emailLabel=new JLabel("EMAIL");
	
	JTextField nameTextField=new JTextField();
    JComboBox genderComboBox=new JComboBox(gender);
    JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();
    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");
 

	
	
	Register() 
	{
		setTitle("Register");
		setBounds(700,200,500,700);
		
		nameLabel.setBounds(80,20,40,70);
        genderLabel.setBounds(80,70,80,70);
        passwordLabel.setBounds(80,120,100,70);
        confirmPasswordLabel.setBounds(80,170,140,70);
        emailLabel.setBounds(80,220,100,70);
        nameTextField.setBounds(250,43,165,23);
        genderComboBox.setBounds(250,93,165,23);
        passwordField.setBounds(250,143,165,23);
        confirmPasswordField.setBounds(250,193,165,23);
        emailTextField.setBounds(250,243,165,23);
        registerButton.setBounds(100,600,100,35);
        resetButton.setBounds(300,600,100,35);  
     	
		
		

		
	     add(nameLabel);
	      add(genderLabel);
	      add(passwordLabel);
	      add(confirmPasswordLabel);
	      add(emailLabel);
	      add(nameTextField);
	      add(genderComboBox);
	      add(passwordField);
	      add(confirmPasswordField);
	      add(emailTextField);
	      add(registerButton);
	      add(resetButton);
	    
		
		
	      
	    registerButton.addActionListener(this);
	    resetButton.addActionListener(this);
		
		 
		 setLayout(null);   
		 setVisible(true);  
		
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}
	
public void actionPerformed(ActionEvent e){
		
		
		
		
		if(e.getSource()==registerButton) 
		{
			
			
			try {
		    Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","venkat");
			PreparedStatement Pstatement=connection.prepareStatement("insert into student values(?,?,?,?,?)");
			  
			  Pstatement.setString(1,nameTextField.getText());
              Pstatement.setString(2,genderComboBox.getSelectedItem().toString());
              Pstatement.setString(3,passwordField.getText());
              Pstatement.setString(4,confirmPasswordField.getText());
              Pstatement.setString(5,emailTextField.getText());
              
              if(passwordField.getText().equals(confirmPasswordField.getText()))
              {
		   Pstatement.executeUpdate();
                   JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                  
              }
              else
              {
                  JOptionPane.showMessageDialog(null,"password did not match");
              }
              
             

          } catch (Exception e1) {
              e1.printStackTrace();
          }

      if(e.getSource()==resetButton)
      {
          //Clearing Fields
          nameTextField.setText("");
          genderComboBox.setSelectedItem("Male");
          passwordField.setText("");
          confirmPasswordField.setText("");
          emailTextField.setText("");
             
             																					
		}
		
		
	}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new Register();
	}

}
