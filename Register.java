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
    JLabel captchaLabel = new JLabel();
    JLabel captchaName = new JLabel("What is inside the image");
    String[] images1 = new String[]{"cat.jpg", "car.jpg", "earpod.jpg", "star.jpg","apple.jpg"};
    String[] images2 = new String[]{"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg", "8.jpg", "9.jpg"};
    String[] images3 = new String[]{"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg", "8.jpg", "9.jpg"};
    String[] answers = new String[] {"cat","car","earpod","star","apple"};
   
	
	JTextField nameTextField=new JTextField();
    JComboBox genderComboBox=new JComboBox(gender);
    JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();
    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");
    JTextField captchaAnswer = new JTextField();
 

	
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,sample,starB;
	JCheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9;
	Icon star;
	Icon pod1,b8Clicked;
	Icon pod2,b9Clicked;
	int pod1Captch,pod2Captch,captures;
	
    int index1 = (int) (Math.random() * (images1.length - 1));
    int index2 = (int) (Math.random() * (images2.length - 1));
    int index3 = (int) (Math.random() * (images3.length - 1));
    
	
	Icon ic1 = new ImageIcon(images1[index1]);
	Icon ic2 = new ImageIcon(images2[index2]);
	Icon ic3 = new ImageIcon(images3[index3]);
	
	
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
        captchaAnswer.setBounds(150,500,200,25);
		
		
		
		JLabel l1=new JLabel("Verify Captcha");  
		l1.setBounds(50,30,150,30);  
		l1.setFont(new Font("Roboto", Font.PLAIN, 20));
		JLabel l3=new JLabel();  
		l3.setBounds(380,320,200,20);  
		l3.setForeground(Color.red);  
		
		captchaLabel.setIcon(ic1);
		captchaLabel.setBounds(150,300,200,200);  
		captchaName.setBounds(170, 250, 200, 70);
		

		
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
	      add(captchaLabel);
	      add(captchaAnswer);
	      add(captchaName);
		
		
	      
	    registerButton.addActionListener(this);
	    resetButton.addActionListener(this);
		
		 
		 setLayout(null);   
		 setVisible(true);  
		
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}
	
public void actionPerformed(ActionEvent e){
		
		
        if(nameTextField == null) {
			
			registerButton.setEnabled(false);
		}
		if(passwordField == null) {
			registerButton.setEnabled(false);
		}
		if(confirmPasswordField == null) {
			registerButton.setEnabled(false);
		}
		if(emailTextField == null) {
			registerButton.setEnabled(false);
		}
		
		
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
            	  if(captchaLabel.getIcon().toString().equals(images1[0]))  {
            		  
            		  captchaName.setText("What is this animal");
                      
                	  if(captchaAnswer.getText().toString().equals(answers[0])){
                		  Pstatement.executeUpdate();
                          JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                	  }
                  }
            	  
                       if(captchaLabel.getIcon().toString().equals(images1[1]))  {
      
                      
                	  if(captchaAnswer.getText().toString().equals(answers[1])){
                		  Pstatement.executeUpdate();
                          JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                	  }
                  }
                       
                       if(captchaLabel.getIcon().toString().equals(images1[2]))  {
                    	      
                           
                     	  if(captchaAnswer.getText().toString().equals(answers[2])){
                     		  Pstatement.executeUpdate();
                               JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                     	  }
                       }
                       
                       if(captchaLabel.getIcon().toString().equals(images1[3]))  {
                    	      
                           
                     	  if(captchaAnswer.getText().toString().equals(answers[3])){
                     		  Pstatement.executeUpdate();
                               JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                     	  }
                       }
                       
                       if(captchaLabel.getIcon().toString().equals(images1[4]))  {
                    	      
                           
                     	  if(captchaAnswer.getText().toString().equals(answers[4])){
                     		  Pstatement.executeUpdate();
                               JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                     	  }
                       }
               
                  else {
                	  JOptionPane.showMessageDialog(null,"please verify captcha succesfully");
                  }
                  
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
