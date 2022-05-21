package com.railways.userinterface;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.railways.datahandling.FileDataHandling;

public class UserInterface {
	
	
	private static JButton homeScreenRegisterButton;
	private static JButton homeScreenLoginButton;
	private static JButton registerScreenRegisterButton;
	private static JTextField emailTextField;
	private static JPasswordField passwordTextField;
	private static JFrame homeScreen;
	private static JFrame registerScreen;
	
	
	public static JButton getRegisterButton() {
		return homeScreenRegisterButton;
	}

	public static void setRegisterButton(JButton registerButton) {
		UserInterface.homeScreenRegisterButton = registerButton;
	}

	public static JButton getLoginButton() {
		return homeScreenLoginButton;
	}

	public static void setLoginButton(JButton loginButton) {
		UserInterface.homeScreenLoginButton = loginButton;
	}

	public static JFrame getHomeScreen() {
		return homeScreen;
	}

	public static void setHomeScreen(JFrame homeScreen) {
		UserInterface.homeScreen = homeScreen;
	}

	public static JButton getHomeScreenRegisterButton() {
		return homeScreenRegisterButton;
	}

	public static void setHomeScreenRegisterButton(JButton homeScreenRegisterButton) {
		UserInterface.homeScreenRegisterButton = homeScreenRegisterButton;
	}

	public static JButton getHomeScreenLoginButton() {
		return homeScreenLoginButton;
	}

	public static void setHomeScreenLoginButton(JButton homeScreenLoginButton) {
		UserInterface.homeScreenLoginButton = homeScreenLoginButton;
	}

	public static JButton getRegisterScreenRegisterButton() {
		return registerScreenRegisterButton;
	}

	public static void setRegisterScreenRegisterButton(JButton registerScreenRegisterButton) {
		UserInterface.registerScreenRegisterButton = registerScreenRegisterButton;
	}

	public static JTextField getEmailTextField() {
		return emailTextField;
	}

	public static void setEmailTextField(JTextField emailTextField) {
		UserInterface.emailTextField = emailTextField;
	}

	public static JPasswordField getPasswordTextField() {
		return passwordTextField;
	}

	public static void setPasswordTextField(JPasswordField passwordTextField) {
		UserInterface.passwordTextField = passwordTextField;
	}

	public static JFrame getRegisterScreen() {
		return registerScreen;
	}

	public static void setRegisterScreen(JFrame registerScreen) {
		UserInterface.registerScreen = registerScreen;
	}

	public static JFrame createWindow(String nameOfWindow)
	{
		JFrame newWindow = new JFrame(nameOfWindow);
		newWindow.setSize(400,400);
		newWindow.setVisible(true);
		newWindow.setLayout(null);
		return newWindow;
	}
	
	public static JButton createButton(String nameOfButton, int widthOfButton, int heightOfButton)
	{
		JButton newButton = new JButton(nameOfButton);
		newButton.setSize(widthOfButton, heightOfButton);
		return newButton;
	}
	
	public static JButton createButton(String nameOfButton)
	{
		return createButton(nameOfButton,100,40);
	}
	
	public static void buttonLocation(JButton applicationButton,int xAxisLocation,int yAxisLocation)
	{
		
		applicationButton.setBounds(xAxisLocation,yAxisLocation,applicationButton.getWidth(),applicationButton.getHeight());
	}
	
	public static void addButtonToWindow(JFrame applicationWindow, Component ...applicationButtons)
	{
		for(int buttonNumber=0;buttonNumber<applicationButtons.length;buttonNumber++)
		{
			applicationWindow.add(applicationButtons[buttonNumber]);
		}
		
	}
	
	public static void homeScreen()
	{
		JFrame railwaysHomeScreen = UserInterface.createWindow("Railway Reservation Application");
	 	setHomeScreen(railwaysHomeScreen);
		JButton registerButton = UserInterface.createButton("Register");
	 	setRegisterButton(registerButton);
	 	JButton loginButton = UserInterface.createButton("Login");
	 	setLoginButton(loginButton);
	 	UserInterface.addButtonToWindow(railwaysHomeScreen, registerButton, loginButton);
	 	UserInterface.buttonLocation(registerButton, 150, 120);
	 	UserInterface.buttonLocation(loginButton, 150, 180);
	 	UserInterface.onClickHomeScreenRegisterButton();
	}
	
	public static JLabel createLabel(String nameOfLabel)
	{
		return new JLabel(nameOfLabel);
	}
	
	public static JTextField createTextField(String nameOfTextField)
	{
		return new JTextField(nameOfTextField);
	}
	
	public static void registerScreen()
	{
		JFrame registerScreen = UserInterface.createWindow("Railway Reservation Application - register");
		setRegisterScreen(registerScreen);
		JLabel emailLabel = UserInterface.createLabel("E-Mail");
		JLabel passwordLabel = UserInterface.createLabel("Password");
		JTextField emailTextField = UserInterface.createTextField("example@domain.com");
		JPasswordField passwordTextField = new JPasswordField("********");
		JButton registerButton = UserInterface.createButton("Register");

		setEmailTextField(emailTextField);
		setPasswordTextField(passwordTextField);
		setRegisterScreenRegisterButton(registerButton);
		
		emailLabel.setBounds(50, 120, 60, 40);
		passwordLabel.setBounds(50, 180, 60, 40);
		
		emailTextField.setBounds(130, 120, 220, 40);
		passwordTextField.setBounds(130, 180, 220, 40);
		
		registerButton.setBounds(150, 240, 100, 40);
		
		UserInterface.addButtonToWindow(registerScreen, emailLabel, passwordLabel, emailTextField, passwordTextField, registerButton);
		UserInterface.onClickRegisterScreenRegisterButton();
	}
	
	public static void onClickHomeScreenRegisterButton()
	{
		homeScreenRegisterButton.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				homeScreen.setVisible(false);
				UserInterface.registerScreen();
			}
		});
	}
	
	public static void onClickRegisterScreenRegisterButton()
	{
		registerScreenRegisterButton.addActionListener( new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				FileDataHandling.userRegisterDetailsWriteinCsv(emailTextField.getText(), passwordTextField.getText());
				System.out.println(emailTextField.getText());
				System.out.println(passwordTextField.getText());
			}
		});
	}
	}
