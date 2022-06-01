package com.railways.userinterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.railways.users.RailwayPassengerService;
import com.railways.users.RailwayUserEntity;

public class RailwayUserRegisterAndLoginView extends UserInterfaceView
{	
	
	public static void userSelectionScreen()
	{
		JFrame selectionScreen = createWindow("Railway Reservation - User Selection" );
		setUserSelectionScreen(selectionScreen);
		JButton passengerButton = createButton("Passenger Home Screen        ");
		setPassengerButton(passengerButton);
		passengerButton.setSize(200, 50);
		
		JButton adminButton = createButton("Administrator Home Screen  ");
		setAdminButton(adminButton);
		adminButton.setSize(200, 50);
		
		JButton bookingAgentButton = createButton("Booking Agent Home Screen");
		setBookingAgentButton(bookingAgentButton);
		GridBagConstraints gridConstraints = new GridBagConstraints();
		selectionScreen.setLayout(new GridBagLayout());
	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.setMinimumSize(new Dimension(400,200));
	    panel.add(passengerButton);
	    panel.add(Box.createRigidArea(new Dimension(0, 15)));
	    panel.add(adminButton);
	    panel.add(Box.createRigidArea(new Dimension(0, 15)));
	    panel.add(bookingAgentButton);
	    panel.setBorder(null);
	    selectionScreen.add(panel, gridConstraints);
	    selectionScreen.setSize(400, 400);
	    selectionScreen.setLocationRelativeTo(null);
	    selectionScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		railwaysHomeScreen.setLocationRelativeTo(null);
		setHomeScreen(railwaysHomeScreen);
		JButton registerButton = RailwayUserRegisterAndLoginView.createButton("Click Here to Register");
	 	setRegisterButton(registerButton);
	 	JButton loginButton = RailwayUserRegisterAndLoginView.createButton("Click Here to Login    ");
	 	setLoginButton(loginButton);
	 	GridBagConstraints gridConstraints = new GridBagConstraints();
	    gridConstraints.gridwidth = 1;
	    railwaysHomeScreen.setLayout(new GridBagLayout());
	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.setMinimumSize(new Dimension(400,200));
	 	if(RailwayUserEntity.getRailwayUserRole()=="PASSENGER")
	 	{
	 		
		    panel.add(registerButton);
		    panel.add(Box.createRigidArea(new Dimension(0, 15)));
		    panel.add(loginButton);
	 	}
	 	else
	 	{
		    panel.add(loginButton);
	 	}
	 	panel.setBorder(null);
	    railwaysHomeScreen.add(panel, gridConstraints);
	    railwaysHomeScreen.setSize(getUserSelectionScreen().getWidth(), getUserSelectionScreen().getHeight());
	    railwaysHomeScreen.setLocationRelativeTo(null);
	    railwaysHomeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    railwaysHomeScreen.setVisible(true);
	    railwaysHomeScreen.setLocationRelativeTo(null);
	 	
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
		registerScreen.setLocationRelativeTo(null);
		RailwayUserRegisterAndLoginView.addComponentsToWindow(registerScreen, emailLabel, passwordLabel, emailTextField, passwordTextField, registerButton);
		RailwayUserRegisterAndLoginView.onClickRegisterScreenRegisterButton();
	}
	
	public static void loginScreen()
	{
		setLoginScreen(null);
		JFrame loginScreen = RailwayUserRegisterAndLoginView.createWindow("Railway Reservation Application - Login");
		setLoginScreen(loginScreen);
		loginScreen.setLocationRelativeTo(null);
		JLabel emailLabel = RailwayUserRegisterAndLoginView.createLabel("E-Mail");
		JLabel passwordLabel = RailwayUserRegisterAndLoginView.createLabel("Password");
		JTextField emailTextField = RailwayUserRegisterAndLoginView.createTextField("example@domain.com");
		JPasswordField passwordTextField = new JPasswordField("********");
		JButton loginButton = RailwayUserRegisterAndLoginView.createButton("Login");

		setEmailTextField(emailTextField);
		setPasswordTextField(passwordTextField);
		setLoginScreenLoginButton(loginButton);
		loginScreen.setLocationRelativeTo(null);
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
