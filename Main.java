package com.captcha;

import com.captcha.Register;
import com.captcha.Login;
import java.awt.event.*;  
import java.awt.*;  
import javax.swing.*;  
import java.sql.*;
import java.io.*;

class Main extends JFrame implements ActionListener{
	
	JButton registerPageButton = new JButton("REGISTER");
	JButton loginPageButton = new JButton("LOGIN");
	
	Main() {
		
		setTitle("Welcome");
		
		 registerPageButton.setBounds(100,300,100,35);
	     loginPageButton.setBounds(300,300,100,35);
	     
	     add(registerPageButton);
	     add(loginPageButton);
	     
	     registerPageButton.addActionListener(this);
	     loginPageButton.addActionListener(this);
		 
	     setBounds(200,200,500,700);
		 setLayout(null);    
	     setVisible(true);  
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== registerPageButton) {
			Register obj = new Register();
			setVisible(false);
			
		}
		
		if(e.getSource()== loginPageButton) {
			Login obj = new Login();
			setVisible(false);
			
		}
	}
     
	
	
	
	public static void main(String args[]){  
		new Main();  
		}
}
