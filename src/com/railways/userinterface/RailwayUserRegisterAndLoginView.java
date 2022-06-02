package com.railways.userinterface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

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
	    selectionScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    selectionScreen.setVisible(true);
	    
		onClickPassengerButton();
		onClickAdminButton();
		onClickBookingAgentButton();
	}
	
	public static void onClickPassengerButton()
	{
		getPassengerButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				getUserSelectionScreen().setVisible(false);
				homeScreen("PASSENGER");
			}
		});
	}
	
	public static void onClickAdminButton()
	{
		getAdminButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				getUserSelectionScreen().setVisible(false);
				homeScreen("ADMIN");
			}
		});
	}
	
	public static void onClickBookingAgentButton()
	{
		getBookingAgentButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				getUserSelectionScreen().setVisible(false);
				homeScreen("BOOKING_AGENT");
			}
		});
	}
	
	public static void homeScreen(String userRole)
	{
		JFrame railwaysHomeScreen = createWindow("Railway Reservation Application");
		railwaysHomeScreen.setLocationRelativeTo(null);
		setHomeScreen(railwaysHomeScreen);
		JButton registerButton = createButton("Click Here to Register");
	 	setRegisterButton(registerButton);
	 	JButton loginButton = createButton("Click Here to Login    ");
	 	setLoginButton(loginButton);
	 	GridBagConstraints gridConstraints = new GridBagConstraints();
	    railwaysHomeScreen.setLayout(new GridBagLayout());
	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.setMinimumSize(new Dimension(400,200));
	 	if("PASSENGER".equals(userRole))
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
	    railwaysHomeScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    railwaysHomeScreen.setVisible(true);
	 	buttonLocation(registerButton, 150, 120);
	 	
	 	onClickHomeScreenRegisterButton();
	 	onClickHomeScreenLoginButton();
	}
	
	public static void registerScreen()
	{
		JFrame registerScreen = createWindow("Railway Reservation Application - Register");
		setRegisterScreen(registerScreen);
		registerScreen.setLocationRelativeTo(null);
		JLabel emailLabel = createLabel("E-Mail      ");
		JLabel passwordLabel = createLabel("Password");
		JTextField emailTextField = createTextField("example@domain.com");

		JPasswordField passwordTextField = new JPasswordField("********");
		JButton registerButton = createButton("Register");
		JPanel registerScreenEmailPanel = new JPanel();
		registerScreenEmailPanel.setLayout(new BoxLayout(registerScreenEmailPanel, BoxLayout.X_AXIS));
		registerScreenEmailPanel.setMinimumSize(new Dimension(300,40));
		
		JPanel registerScreenPasswordPanel = new JPanel();
		registerScreenPasswordPanel.setLayout(new BoxLayout(registerScreenPasswordPanel, BoxLayout.X_AXIS));
		registerScreenPasswordPanel.setMinimumSize(new Dimension(300,40));
		
		JPanel registerScreenOkButtonPanel = new JPanel();
		registerScreenOkButtonPanel.setLayout(new BoxLayout(registerScreenOkButtonPanel, BoxLayout.X_AXIS));
		registerScreenOkButtonPanel.setMinimumSize(new Dimension(300,40));
		
		setEmailTextField(emailTextField);
		setPasswordTextField(passwordTextField);
		setRegisterScreenRegisterButton(registerButton);
		registerScreenEmailPanel.add(emailLabel);
		registerScreenEmailPanel.add(Box.createRigidArea(new Dimension(20,0)));
		registerScreenEmailPanel.add(emailTextField);
		registerScreenPasswordPanel.add(passwordLabel);
		registerScreenPasswordPanel.add(Box.createRigidArea(new Dimension(20,0)));
		registerScreenPasswordPanel.add(passwordTextField);
		registerScreenOkButtonPanel.add(registerButton);
		GridBagConstraints gridConstraints = new GridBagConstraints();
		JPanel registerScreenPanel = new JPanel();
		registerScreenPanel.setLayout(new BoxLayout(registerScreenPanel, BoxLayout.Y_AXIS));
		registerScreenPanel.add(registerScreenEmailPanel);
		registerScreenPanel.add(Box.createRigidArea(new Dimension(0,20)));
		registerScreenPanel.add(registerScreenPasswordPanel);
		registerScreenPanel.add(Box.createRigidArea(new Dimension(0,20)));
		registerScreenPanel.add(registerScreenOkButtonPanel);
		registerScreenOkButtonPanel.setMinimumSize(new Dimension(400,200));
		registerScreen.add(registerScreenPanel,gridConstraints);
		registerScreen.setLayout(new GridBagLayout());
		registerScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		registerScreen.setVisible(true);
		onClickRegisterScreenRegisterButton();
	}
	
	public static void loginScreen()
	{
		JFrame loginScreen = createWindow("Railway Reservation Application - Login");
		setLoginScreen(loginScreen);
		loginScreen.setLocationRelativeTo(null);
		JLabel emailLabel = createLabel("E-Mail      ");
		JLabel passwordLabel = createLabel("Password");
		JTextField emailTextField = createTextField("example@domain.com");

		JPasswordField passwordTextField = new JPasswordField("********");
		JButton loginButton = createButton("Login");
		JPanel loginScreenEmailPanel = new JPanel();
		loginScreenEmailPanel.setLayout(new BoxLayout(loginScreenEmailPanel, BoxLayout.X_AXIS));
		loginScreenEmailPanel.setMinimumSize(new Dimension(300,40));
		
		JPanel loginScreenPasswordPanel = new JPanel();
		loginScreenPasswordPanel.setLayout(new BoxLayout(loginScreenPasswordPanel, BoxLayout.X_AXIS));
		loginScreenPasswordPanel.setMinimumSize(new Dimension(300,40));
		
		JPanel loginScreenOkButtonPanel = new JPanel();
		loginScreenOkButtonPanel.setLayout(new BoxLayout(loginScreenOkButtonPanel, BoxLayout.X_AXIS));
		loginScreenOkButtonPanel.setMinimumSize(new Dimension(300,40));
		
		setEmailTextField(emailTextField);
		setPasswordTextField(passwordTextField);
		setLoginScreenLoginButton(loginButton);
		loginScreenEmailPanel.add(emailLabel);
		loginScreenEmailPanel.add(Box.createRigidArea(new Dimension(20,0)));
		loginScreenEmailPanel.add(emailTextField);
		loginScreenPasswordPanel.add(passwordLabel);
		loginScreenPasswordPanel.add(Box.createRigidArea(new Dimension(20,0)));
		loginScreenPasswordPanel.add(passwordTextField);
		loginScreenOkButtonPanel.add(loginButton);
		GridBagConstraints gridConstraints = new GridBagConstraints();
		JPanel loginScreenPanel = new JPanel();
		loginScreenPanel.setLayout(new BoxLayout(loginScreenPanel, BoxLayout.Y_AXIS));
		loginScreenPanel.add(loginScreenEmailPanel);
		loginScreenPanel.add(Box.createRigidArea(new Dimension(0,20)));
		loginScreenPanel.add(loginScreenPasswordPanel);
		loginScreenPanel.add(Box.createRigidArea(new Dimension(0,20)));
		loginScreenPanel.add(loginScreenOkButtonPanel);
		loginScreenPanel.setMinimumSize(new Dimension(400,200));
		loginScreen.add(loginScreenPanel,gridConstraints);
		loginScreen.setLayout(new GridBagLayout());
		loginScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		loginScreen.setVisible(true);
		onClickLoginScreenLoginButton();
	}
	
	public static void onClickHomeScreenRegisterButton()
	{
		getHomeScreenRegisterButton().addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				getHomeScreen().setVisible(false);
				registerScreen();
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
				loginScreen();
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
		JDialog userExistDialogBox = new JDialog(getRegisterScreen(),"Email already exist",true);
		userExistDialogBox.setLocationRelativeTo(null);
		setUserEmailAlreadyExistDialogBox(userExistDialogBox);
		userExistDialogBox.setLayout(new FlowLayout());
		JButton dialogOkButton = createButton("OK");
		setUserEmailAlreadyExistOkButton(dialogOkButton);
		JLabel mailAlreadyExistLabel = new JLabel("Account with the entered e-mail already exist");
		userExistDialogBox.add(mailAlreadyExistLabel);
		userExistDialogBox.add(dialogOkButton);
		userExistDialogBox.setSize(new Dimension(275, 100));
		onClickRegisterScreenDialogBoxOkButton();
		userExistDialogBox.setVisible(true);
	}
	
	public static void userAccountSuccessfullyRegisteredDialogBox()
	{
		JDialog userCreatedDialogBox = new JDialog(getRegisterScreen(),"Email already exist",true);
		setUserCreatedDialogBox(userCreatedDialogBox);
		userCreatedDialogBox.setLayout(new FlowLayout());
		JButton dialogLoginButton = createButton("Login Page");
		JButton dialogHomeButton = createButton("Home Page");
		setUserRegisteredLoginButton(dialogLoginButton);
		setUserRegisteredHomeButton(dialogHomeButton);
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
		setInvalidEmailDialogWindow(railwayInvalidEmailDialogBox);
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
