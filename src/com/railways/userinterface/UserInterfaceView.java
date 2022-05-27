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

public class UserInterfaceView {
	
	private static JButton homeScreenRegisterButton;
	private static JButton homeScreenLoginButton;
	private static JButton registerScreenRegisterButton;
	private static JTextField emailTextField;
	private static JPasswordField passwordTextField;
	private static JFrame homeScreen;
	private static JFrame registerScreen;
	private static JDialog userEmailAlreadyExistDialogBox;
	private static JButton userEmailAlreadyExistOkButton;
	private static JFrame loginScreen;
	private static JButton loginScreenLoginButton;
	private static JDialog userCreatedDialogBox;
	private static JButton userRegisteredLoginButton;
	private static JButton userRegisteredHomeButton;
	private static JDialog contactAdminDialogBox;
	private static JDialog invalidEmailDialogWindow;
	private static JFrame userSelectionScreen;
	private static JButton passengerButton;
	private static JButton adminButton;
	private static JButton bookingAgentButton;
	
	public static JButton getRegisterButton() {
		return homeScreenRegisterButton;
	}

	public static void setRegisterButton(JButton registerButton) {
		UserInterfaceView.homeScreenRegisterButton = registerButton;
	}

	public static JButton getLoginButton() {
		return homeScreenLoginButton;
	}

	public static void setLoginButton(JButton loginButton) {
		UserInterfaceView.homeScreenLoginButton = loginButton;
	}

	public static JFrame getHomeScreen() {
		return homeScreen;
	}

	public static void setHomeScreen(JFrame homeScreen) {
		UserInterfaceView.homeScreen = homeScreen;
	}

	public static JButton getHomeScreenRegisterButton() {
		return homeScreenRegisterButton;
	}

	public static void setHomeScreenRegisterButton(JButton homeScreenRegisterButton) {
		UserInterfaceView.homeScreenRegisterButton = homeScreenRegisterButton;
	}

	public static JButton getHomeScreenLoginButton() {
		return homeScreenLoginButton;
	}

	public static void setHomeScreenLoginButton(JButton homeScreenLoginButton) {
		UserInterfaceView.homeScreenLoginButton = homeScreenLoginButton;
	}

	public static JButton getRegisterScreenRegisterButton() {
		return registerScreenRegisterButton;
	}

	public static void setRegisterScreenRegisterButton(JButton registerScreenRegisterButton) {
		UserInterfaceView.registerScreenRegisterButton = registerScreenRegisterButton;
	}

	public static JTextField getEmailTextField() {
		return emailTextField;
	}

	public static void setEmailTextField(JTextField emailTextField) {
		UserInterfaceView.emailTextField = emailTextField;
	}

	public static JPasswordField getPasswordTextField() {
		return passwordTextField;
	}

	public static void setPasswordTextField(JPasswordField passwordTextField) {
		UserInterfaceView.passwordTextField = passwordTextField;
	}

	public static JFrame getRegisterScreen() {
		return registerScreen;
	}

	public static void setRegisterScreen(JFrame registerScreen) {
		UserInterfaceView.registerScreen = registerScreen;
	}

	public static JDialog getUserEmailAlreadyExistDialogBox() {
		return userEmailAlreadyExistDialogBox;
	}

	public static void setUserEmailAlreadyExistDialogBox(JDialog userEmailAlreadyExistDialogBox) {
		UserInterfaceView.userEmailAlreadyExistDialogBox = userEmailAlreadyExistDialogBox;
	}

	public static JButton getUserEmailAlreadyExistOkButton() {
		return userEmailAlreadyExistOkButton;
	}

	public static void setUserEmailAlreadyExistOkButton(JButton userEmailAlreadyExistOkButton) {
		UserInterfaceView.userEmailAlreadyExistOkButton = userEmailAlreadyExistOkButton;
	}

	public static JFrame getLoginScreen() {
		return loginScreen;
	}

	public static void setLoginScreen(JFrame loginScreen) {
		UserInterfaceView.loginScreen = loginScreen;
	}

	public static JButton getLoginScreenLoginButton() {
		return loginScreenLoginButton;
	}

	public static void setLoginScreenLoginButton(JButton loginScreenLoginButton) {
		UserInterfaceView.loginScreenLoginButton = loginScreenLoginButton;
	}

	public static JDialog getUserCreatedDialogBox() {
		return userCreatedDialogBox;
	}

	public static void setUserCreatedDialogBox(JDialog userCreatedDialogBox) {
		UserInterfaceView.userCreatedDialogBox = userCreatedDialogBox;
	}

	public static JButton getUserRegisteredLoginButton() {
		return userRegisteredLoginButton;
	}

	public static void setUserRegisteredLoginButton(JButton userRegisteredLoginButton) {
		UserInterfaceView.userRegisteredLoginButton = userRegisteredLoginButton;
	}

	public static JButton getUserRegisteredHomeButton() {
		return userRegisteredHomeButton;
	}

	public static void setUserRegisteredHomeButton(JButton userRegisteredHomeButton) {
		UserInterfaceView.userRegisteredHomeButton = userRegisteredHomeButton;
	}

	public static JDialog getContactAdminDialogBox() {
		return contactAdminDialogBox;
	}

	public static void setContactAdminDialogBox(JDialog contactAdminDialogBox) {
		UserInterfaceView.contactAdminDialogBox = contactAdminDialogBox;
	}

	public static JDialog getInvalidEmailDialogWindow() {
		return invalidEmailDialogWindow;
	}

	public static void setInvalidEmailDialogWindow(JDialog invalidEmailDialogWindow) {
		UserInterfaceView.invalidEmailDialogWindow = invalidEmailDialogWindow;
	}

	public static JFrame getUserSelectionScreen() {
		return userSelectionScreen;
	}

	public static void setUserSelectionScreen(JFrame userSelectionScreen) {
		UserInterfaceView.userSelectionScreen = userSelectionScreen;
	}

	public static JButton getPassengerButton() {
		return passengerButton;
	}

	public static void setPassengerButton(JButton passengerButton) {
		UserInterfaceView.passengerButton = passengerButton;
	}

	public static JButton getAdminButton() {
		return adminButton;
	}

	public static void setAdminButton(JButton adminButton) {
		UserInterfaceView.adminButton = adminButton;
	}

	public static JButton getBookingAgentButton() {
		return bookingAgentButton;
	}

	public static void setBookingAgentButton(JButton bookingAgentButton) {
		UserInterfaceView.bookingAgentButton = bookingAgentButton;
	}
	
	static JFrame createWindow(String nameOfWindow)
	{
		JFrame newWindow = new JFrame(nameOfWindow);
		newWindow.setSize(400,400);
		newWindow.setVisible(true);
		newWindow.setLayout(null);
		return newWindow;
	}
	
	static JButton createButton(String nameOfButton, int widthOfButton, int heightOfButton)
	{
		JButton newButton = new JButton(nameOfButton);
		newButton.setSize(widthOfButton, heightOfButton);
		return newButton;
	}
	
	static JButton createButton(String nameOfButton)
	{
		return createButton(nameOfButton,100,40);
	}
	
	static void buttonLocation(JButton applicationButton,int xAxisLocation,int yAxisLocation)
	{
		
		applicationButton.setBounds(xAxisLocation,yAxisLocation,applicationButton.getWidth(),applicationButton.getHeight());
	}
	
	static void addComponentsToWindow(JFrame applicationWindow, Component ...applicationButtons)
	{
		for(int buttonNumber=0;buttonNumber<applicationButtons.length;buttonNumber++)
		{
			applicationWindow.add(applicationButtons[buttonNumber]);
		}
		
	}
	
	static JLabel createLabel(String nameOfLabel)
	{
		return new JLabel(nameOfLabel);
	}
	
	static JTextField createTextField(String nameOfTextField)
	{
		return new JTextField(nameOfTextField);
	}
	public static void contactAdminDialogBox(JFrame currentScreen)
	{
		JDialog railwayContactAdminDialogBox = new JDialog(currentScreen,"Contact Administrator",true);
		RailwayUserRegisterAndLoginView.setContactAdminDialogBox(railwayContactAdminDialogBox);
		railwayContactAdminDialogBox.setLayout(new FlowLayout());
		JButton dialogOkButton = RailwayUserRegisterAndLoginView.createButton("OK");
		JLabel userAccountSuccessfullyCreatedLabel = new JLabel("Please contact administration");
		railwayContactAdminDialogBox.add(userAccountSuccessfullyCreatedLabel);
		railwayContactAdminDialogBox.add(dialogOkButton);
		railwayContactAdminDialogBox.setSize(250, 200);
		onClickOkButtonInContactAdminDialogBox(dialogOkButton);
		railwayContactAdminDialogBox.setVisible(true);
	}
	
	private static void onClickOkButtonInContactAdminDialogBox(JButton dialogOkButton)
	{
		dialogOkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContactAdminDialogBox().setVisible(false);
			}
		});
	}
}
