package com.captcha;

import java.awt.event.*;  

import java.awt.*;  
import javax.swing.*;  
import java.sql.*;

class Login extends JFrame implements ActionListener{
	
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passLabel = new JLabel("PASSWORD");
   
    JTextField userTextField = new JTextField();
    JPasswordField passPasswordField = new JPasswordField();
    JButton loginButton1=new JButton("LOGIN");

	

	Login() {
		super("LOGIN PAGE");
		setBounds(700,200,500,300);
		
		userLabel.setBounds(80,20,100,70);
        passLabel.setBounds(80,75,100,70);
        userTextField.setBounds(200,43,165,23);
        passPasswordField.setBounds(200,100,165,23);
        loginButton1.setBounds(200,200,100,35);
	 
          add(userLabel);
          add(userTextField);
          add(passLabel);
          add(passPasswordField);
	      add(loginButton1);
	      
	      
	      loginButton1.addActionListener(this);
	
		 
		 setLayout(null);   
		 setVisible(true);  
		
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==loginButton1) 
		{
			
			
			try {
		    Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","venkat");
			Statement stmt=con.createStatement();
			String sql="Select * from student where sname='"+userTextField.getText()+"' and password='"+passPasswordField.getText().toString()+"'";
			ResultSet rs=stmt.executeQuery(sql); 
			if(rs.next())
				JOptionPane.showMessageDialog(null, "Login Successfully");
			else
				JOptionPane.showMessageDialog(null, "Incorrect UserName & Password");
			con.close();
			} 
			catch(Exception e1) {System.out.print(e1);}
		}

	}
	
	
	public static void main(String args[]){  
		new Login(); 
		}
}
