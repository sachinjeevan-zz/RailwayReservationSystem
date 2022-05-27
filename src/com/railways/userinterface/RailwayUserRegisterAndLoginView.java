package com.railways.userinterface;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.railways.users.RailwayBookingAgent;
import com.railways.users.RailwayPassengerService;
import com.railways.users.RailwayUserEntity;

public class RailwayUserRegisterAndLoginView extends UserInterfaceView
{	
	
	public static void userSelectionScreen()
	{
		JFrame selectionScreen = createWindow("Railway Reservation - User Selection" );
		setUserSelectionScreen(selectionScreen);
		JButton passengerButton = createButton("Passenger");
		setPassengerButton(passengerButton);
		JButton adminButton = createButton("Administrator");
		setAdminButton(adminButton);
		JButton bookingAgentButton = createButton("Booking Agent");
		setBookingAgentButton(bookingAgentButton);
		
		passengerButton.setBounds(100,85,200,50);
		adminButton.setBounds(100, 155, 200, 50);
		bookingAgentButton.setBounds(100,225,200,50);
		
		addComponentsToWindow(selectionScreen, passengerButton, adminButton, bookingAgentButton);
		
		selectionScreen.setLayout(null);
		selectionScreen.setVisible(true);
		onClickPassengerButton();
		onClickAdminButton();
		onClickBookingAgentButton();
	}
	
	public static void onClickPassengerButton()
	{
		getPassengerButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RailwayUserEntity.setRailwayUserRole("PASSENGER");
				getUserSelectionScreen().setVisible(false);
				homeScreen();
			}
		});
	}
	
	public static void onClickAdminButton()
	{
		getAdminButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RailwayUserEntity.setRailwayUserRole("ADMIN");
				getUserSelectionScreen().setVisible(false);
				homeScreen();
			}
		});
	}
	
	public static void onClickBookingAgentButton()
	{
		getBookingAgentButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RailwayUserEntity.setRailwayUserRole("BOOKING_AGENT");
				getUserSelectionScreen().setVisible(false);
				homeScreen();
			}
		});
	}
	
	public static void homeScreen()
	{
		JFrame railwaysHomeScreen = RailwayUserRegisterAndLoginView.createWindow("Railway Reservation Application");
	 	setHomeScreen(railwaysHomeScreen);
		JButton registerButton = RailwayUserRegisterAndLoginView.createButton("Register");
	 	setRegisterButton(registerButton);
	 	JButton loginButton = RailwayUserRegisterAndLoginView.createButton("Login");
	 	setLoginButton(loginButton);
	 	if(RailwayUserEntity.getRailwayUserRole()=="PASSENGER")
	 	{
	 		RailwayUserRegisterAndLoginView.addComponentsToWindow(railwaysHomeScreen, registerButton, loginButton);
	 		RailwayUserRegisterAndLoginView.buttonLocation(loginButton, 150, 180);
	 	}
	 	else
	 	{
	 		RailwayUserRegisterAndLoginView.addComponentsToWindow(railwaysHomeScreen, loginButton);
	 		RailwayUserRegisterAndLoginView.buttonLocation(loginButton, 150, 175);
	 	}
	 	
	 	RailwayUserRegisterAndLoginView.buttonLocation(registerButton, 150, 120);
	 	
	 	RailwayUserRegisterAndLoginView.onClickHomeScreenRegisterButton();
	 	RailwayUserRegisterAndLoginView.onClickHomeScreenLoginButton();
	}
	
	public static void registerScreen()
	{
		setRegisterScreen(null);
		JFrame registerScreen = RailwayUserRegisterAndLoginView.createWindow("Railway Reservation Application - register");
		setRegisterScreen(registerScreen);
		JLabel emailLabel = RailwayUserRegisterAndLoginView.createLabel("E-Mail");
		JLabel passwordLabel = RailwayUserRegisterAndLoginView.createLabel("Password");
		JTextField emailTextField = RailwayUserRegisterAndLoginView.createTextField("example@domain.com");
		JPasswordField passwordTextField = new JPasswordField("********");
		JButton registerButton = RailwayUserRegisterAndLoginView.createButton("Register");

		setEmailTextField(emailTextField);
		setPasswordTextField(passwordTextField);
		setRegisterScreenRegisterButton(registerButton);
		
		emailLabel.setBounds(50, 120, 60, 40);
		passwordLabel.setBounds(50, 180, 60, 40);
		
		emailTextField.setBounds(130, 120, 220, 40);
		passwordTextField.setBounds(130, 180, 220, 40);
		
		registerButton.setBounds(150, 240, 100, 40);
		
		RailwayUserRegisterAndLoginView.addComponentsToWindow(registerScreen, emailLabel, passwordLabel, emailTextField, passwordTextField, registerButton);
		RailwayUserRegisterAndLoginView.onClickRegisterScreenRegisterButton();
	}
	
	public static void loginScreen()
	{
		setLoginScreen(null);
		JFrame loginScreen = RailwayUserRegisterAndLoginView.createWindow("Railway Reservation Application - Login");
		setLoginScreen(loginScreen);
		JLabel emailLabel = RailwayUserRegisterAndLoginView.createLabel("E-Mail");
		JLabel passwordLabel = RailwayUserRegisterAndLoginView.createLabel("Password");
		JTextField emailTextField = RailwayUserRegisterAndLoginView.createTextField("example@domain.com");
		JPasswordField passwordTextField = new JPasswordField("********");
		JButton loginButton = RailwayUserRegisterAndLoginView.createButton("Login");

		setEmailTextField(emailTextField);
		setPasswordTextField(passwordTextField);
		setLoginScreenLoginButton(loginButton);
		
		emailLabel.setBounds(50, 120, 60, 40);
		passwordLabel.setBounds(50, 180, 60, 40);
		
		emailTextField.setBounds(130, 120, 220, 40);
		passwordTextField.setBounds(130, 180, 220, 40);
		
		loginButton.setBounds(150, 240, 100, 40);
		
		RailwayUserRegisterAndLoginView.addComponentsToWindow(loginScreen, emailLabel, passwordLabel, emailTextField, passwordTextField, loginButton);
		RailwayUserRegisterAndLoginView.onClickLoginScreenLoginButton();
	}
	
	public static void onClickHomeScreenRegisterButton()
	{
		getHomeScreenRegisterButton().addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				getHomeScreen().setVisible(false);
				RailwayUserRegisterAndLoginView.registerScreen();
			}
		});
	}
	
	public static void onClickHomeScreenLoginButton()
	{
		getHomeScreenLoginButton().addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				getHomeScreen().setVisible(false);
				RailwayUserRegisterAndLoginView.loginScreen();
			}
		});
	}
	
	public static void onClickRegisterScreenRegisterButton()
	{
		getRegisterScreenRegisterButton().addActionListener( new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				RailwayUserEntity passengerEntity = new RailwayUserEntity();
				passengerEntity.setRailwayUserMailId(getEmailTextField().getText());
				passengerEntity.setRailwayUserPassword(getPasswordTextField().getText());
				RailwayPassengerService railwayPassengerController = new RailwayPassengerService();
				railwayPassengerController.setPassengerDetails(passengerEntity);
				railwayPassengerController.passengerAccountCreation();
				
			}
		});
	}
	
	public static void onClickLoginScreenLoginButton()
	{
		getLoginScreenLoginButton().addActionListener( new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				RailwayUserEntity railwayPassengerEntity = new RailwayUserEntity();
				railwayPassengerEntity.setRailwayUserMailId(getEmailTextField().getText());
				railwayPassengerEntity.setRailwayUserPassword(getPasswordTextField().getText());
				RailwayPassengerService railwayPassengerController = new RailwayPassengerService();
				railwayPassengerController.setPassengerDetails(railwayPassengerEntity);
				railwayPassengerController.passengerLoginAccess();
			}
		});
	}
	
	public static void applicationLandingPage()
	{
		JFrame applicationLandingScreen = createWindow("Train Reservation System");
		JLabel loggedInStatus = new JLabel("Successfully logged in");
		loggedInStatus.setBounds(125,150,150,50);
		addComponentsToWindow(applicationLandingScreen, loggedInStatus);
		getLoginScreen().setVisible(false);
		applicationLandingScreen.setVisible(true);
	}
	
	public static void onClickRegisterScreenDialogBoxOkButton()
	{
		getUserEmailAlreadyExistOkButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getUserEmailAlreadyExistDialogBox().setVisible(false);
				getRegisterScreen().setVisible(false);
				getHomeScreen().setVisible(true);
			}
		});
	}
	
	public static void userAlreadyExistDialogBox()
	{
		JDialog userExistDialogBox = new JDialog(RailwayUserRegisterAndLoginView.getRegisterScreen(),"Email already exist",true);
		RailwayUserRegisterAndLoginView.setUserEmailAlreadyExistDialogBox(userExistDialogBox);
		userExistDialogBox.setLayout(new FlowLayout());
		JButton dialogOkButton = RailwayUserRegisterAndLoginView.createButton("OK");
		RailwayUserRegisterAndLoginView.setUserEmailAlreadyExistOkButton(dialogOkButton);
		JLabel mailAlreadyExistLabel = new JLabel("Email Already Exist");
		userExistDialogBox.add(mailAlreadyExistLabel);
		userExistDialogBox.add(dialogOkButton);
		userExistDialogBox.setSize(150, 100);
		RailwayUserRegisterAndLoginView.onClickRegisterScreenDialogBoxOkButton();
		userExistDialogBox.setVisible(true);
	}
	
	public static void userAccountSuccessfullyRegisteredDialogBox()
	{
		JDialog userCreatedDialogBox = new JDialog(RailwayUserRegisterAndLoginView.getRegisterScreen(),"Email already exist",true);
		RailwayUserRegisterAndLoginView.setUserCreatedDialogBox(userCreatedDialogBox);
		userCreatedDialogBox.setLayout(new FlowLayout());
		JButton dialogLoginButton = RailwayUserRegisterAndLoginView.createButton("Login Page");
		JButton dialogHomeButton = RailwayUserRegisterAndLoginView.createButton("Home Page");
		RailwayUserRegisterAndLoginView.setUserRegisteredLoginButton(dialogLoginButton);
		RailwayUserRegisterAndLoginView.setUserRegisteredHomeButton(dialogHomeButton);
		JLabel userAccountSuccessfullyCreatedLabel = new JLabel("Account is successfully registered");
		userCreatedDialogBox.add(userAccountSuccessfullyCreatedLabel);
		userCreatedDialogBox.add(dialogLoginButton);
		userCreatedDialogBox.add(dialogHomeButton);
		userCreatedDialogBox.setSize(250, 200);
		onClickAnyButtonInAccountCreationDialogBox();
		userCreatedDialogBox.setVisible(true);
	}
	
	private static void onClickAnyButtonInAccountCreationDialogBox()
	{
		getUserRegisteredLoginButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getUserCreatedDialogBox().setVisible(false);
				getRegisterScreen().setVisible(false);
				loginScreen();
			}
		});
		
		getUserRegisteredHomeButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getUserCreatedDialogBox().setVisible(false);
				getRegisterScreen().setVisible(false);
				getHomeScreen().setVisible(true);
			}
		});
	}
	
	private static void onClickOkButtonInInvalidEmailDialogBox(JButton dialogOkButton)
	{
		dialogOkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getInvalidEmailDialogWindow().setVisible(false);
			}
		});
	}
	
	public static void invalidEmailDialogBox()
	{
		JDialog railwayInvalidEmailDialogBox = new JDialog(getLoginScreen(),"Invalid Email or Password",true);
		RailwayUserRegisterAndLoginView.setInvalidEmailDialogWindow(railwayInvalidEmailDialogBox);
		railwayInvalidEmailDialogBox.setLayout(new FlowLayout());
		JButton dialogOkButton = createButton("OK");
		JLabel userAccountSuccessfullyCreatedLabel = new JLabel("Invalid Email or Password");
		railwayInvalidEmailDialogBox.add(userAccountSuccessfullyCreatedLabel);
		railwayInvalidEmailDialogBox.add(dialogOkButton);
		railwayInvalidEmailDialogBox.setSize(250, 200);
		onClickOkButtonInInvalidEmailDialogBox(dialogOkButton);
		railwayInvalidEmailDialogBox.setVisible(true);
	}
	
	
}
