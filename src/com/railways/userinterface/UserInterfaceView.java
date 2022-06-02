package com.railways.userinterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.Serializable;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

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
	private static JPanel toolbarPanel;
	private static JPanel navigationPanel;
	private static JPanel workspacePanel;
	private static Map<String,Map<String,String>> navigatorWorkspaceLabels;
	private static JLabel scrollingMessage;
	private static final String ICON_LOCATION = "C:\\Users\\Sachin Jeevan\\UltraMain\\RailwayReservationSystem\\src\\com\\railways\\icons\\";
	private static JFrame navigatorWorkspaceFrame;
	private static JPanel viewTablePanel;
	private static Integer viewTableLowLimit;
	private static Integer viewTableHighLimit;
	private static JTextField trainNumber;
	private static JTextField trainName;
	private static JTextField trainSourceStation;
	private static JTextField trainDestinationStation;
	private static JTextField trainAvailableSeats;
	private static JTextField trainIsPantryAvailable;
	
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
	
	public static JPanel getToolbarPanel() {
		return toolbarPanel;
	}

	public static void setToolbarPanel(JPanel toolbarPanel) {
		UserInterfaceView.toolbarPanel = toolbarPanel;
	}

	public static JPanel getNavigationPanel() {
		return navigationPanel;
	}

	public static void setNavigationPanel(JPanel navigationPanel) {
		UserInterfaceView.navigationPanel = navigationPanel;
	}

	public static JPanel getWorkspacePanel() {
		return workspacePanel;
	}

	public static void setWorkspacePanel(JPanel workspacePanel) {
		UserInterfaceView.workspacePanel = workspacePanel;
	}

	public static Map<String, Map<String,String>> getNavigatorWorkspaceLabels() {
		return navigatorWorkspaceLabels;
	}

	public static void setNavigatorWorkspaceLabels(Map<String, Map<String,String>> navigatorWorkspaceLabels) {
		UserInterfaceView.navigatorWorkspaceLabels = navigatorWorkspaceLabels;
	}

	public static JLabel getScrollingMessage() {
		return scrollingMessage;
	}

	public static void setScrollingMessage(JLabel scrollingMessage) {
		UserInterfaceView.scrollingMessage = scrollingMessage;
	}

	public static String getIconLocation() {
		return ICON_LOCATION;
	}

	public static JFrame getNavigatorWorkspaceFrame() {
		return navigatorWorkspaceFrame;
	}

	public static void setNavigatorWorkspaceFrame(JFrame navigatorWorkspaceFrame) {
		UserInterfaceView.navigatorWorkspaceFrame = navigatorWorkspaceFrame;
	}

	public static JPanel getViewTablePanel() {
		return viewTablePanel;
	}

	public static void setViewTablePanel(JPanel viewTablePanel) {
		UserInterfaceView.viewTablePanel = viewTablePanel;
	}

	public static Integer getViewTableLowLimit() {
		return viewTableLowLimit;
	}

	public static void setViewTableLowLimit(Integer viewTableLowLimit) {
		UserInterfaceView.viewTableLowLimit = viewTableLowLimit;
	}

	public static Integer getViewTableHighLimit() {
		return viewTableHighLimit;
	}

	public static void setViewTableHighLimit(Integer viewTableHighLimit) {
		UserInterfaceView.viewTableHighLimit = viewTableHighLimit;
	}

	public static JTextField getTrainNumber() {
		return trainNumber;
	}

	public static void setTrainNumber(JTextField trainNumber) {
		UserInterfaceView.trainNumber = trainNumber;
	}

	public static JTextField getTrainName() {
		return trainName;
	}

	public static void setTrainName(JTextField trainName) {
		UserInterfaceView.trainName = trainName;
	}

	public static JTextField getTrainSourceStation() {
		return trainSourceStation;
	}

	public static void setTrainSourceStation(JTextField trainSourceStation) {
		UserInterfaceView.trainSourceStation = trainSourceStation;
	}

	public static JTextField getTrainDestinationStation() {
		return trainDestinationStation;
	}

	public static void setTrainDestinationStation(JTextField trainDestinationStation) {
		UserInterfaceView.trainDestinationStation = trainDestinationStation;
	}

	public static JTextField getTrainAvailableSeats() {
		return trainAvailableSeats;
	}

	public static void setTrainAvailableSeats(JTextField trainAvailableSeats) {
		UserInterfaceView.trainAvailableSeats = trainAvailableSeats;
	}

	public static JTextField getTrainIsPantryAvailable() {
		return trainIsPantryAvailable;
	}

	public static void setTrainIsPantryAvailable(JTextField trainIsPantryAvailable) {
		UserInterfaceView.trainIsPantryAvailable = trainIsPantryAvailable;
	}

	static JFrame createWindow(String nameOfWindow, int width, int height)
	{
		JFrame newWindow = new JFrame(nameOfWindow);
		newWindow.setSize(width,height);
		newWindow.setVisible(true);
		newWindow.setLayout(null);
		return newWindow;
	}
	
	static JFrame createWindow(String nameOfWindow)
	{
		return createWindow(nameOfWindow, 400, 400);
	}
	
	static JButton createButton(String nameOfButton, int widthOfButton, int heightOfButton,Icon iconImage)
	{
		JButton newButton = new JButton(nameOfButton);
		newButton.setSize(widthOfButton, heightOfButton);
		newButton.setUI(new StyledButtonUI());
		newButton.setIcon(iconImage);
		newButton.setFont(new Font(newButton.getFont().getFontName(),  Font.BOLD, 14));
		return newButton;
	}
	static JButton createButton(String nameOfButton, Icon iconImage)
	{
		return createButton(nameOfButton,100,40,iconImage);
	}
	
	static JButton createButton(String nameOfButton)
	{
		return createButton(nameOfButton,null);
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
		JLabel newLabel = new JLabel(nameOfLabel);
		newLabel.setFont(new Font(newLabel.getFont().getFontName(),  Font.BOLD, 13));
		return newLabel;
}
	
	static JTextField createTextField(String nameOfTextField)
	{
		JTextField newTextField = new JTextField(nameOfTextField);
		newTextField.setFont(new Font(newTextField.getFont().getFontName(),  Font.BOLD, 12));
		return newTextField;
	}
	public static void contactAdminDialogBox(JFrame currentScreen)
	{
		JDialog railwayContactAdminDialogBox = new JDialog(currentScreen,"Contact Administrator",true);
		setContactAdminDialogBox(railwayContactAdminDialogBox);
		railwayContactAdminDialogBox.setLayout(new FlowLayout());
		JButton dialogOkButton = createButton("OK");
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
	
	static JPanel createPanel(Integer xAxisPanel, Integer yAxisPanel, Integer widthPanel, Integer heightPanel)
	{
		JPanel newPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		newPanel.setBounds(xAxisPanel, yAxisPanel, widthPanel, heightPanel);
		Border blackline = BorderFactory.createLineBorder(Color.GRAY);
		newPanel.setBorder(blackline);
		return newPanel;
	}

}

class StyledButtonUI extends BasicButtonUI {

    @Override
    public void installUI (JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
    }

    @Override
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }

    private void paintBackground (Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(c.getBackground().darker());
        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
        g.setColor(c.getBackground());
        g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
    }
    
}

class RoundJTextField extends JTextField implements Serializable
{
	private static final long serialVersionUID = 1L;
	private transient Shape shape;
	
    public RoundJTextField(int size) 
    {
        super(size);
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         super.paintComponent(g);
    }
    
    @Override
    protected void paintBorder(Graphics g) 
    {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    
    @Override
    public boolean contains(int x, int y) 
    {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, (float)getWidth()-1, (float)getHeight()-1, 15, 15);
         }
         return shape.contains(x, y);
    }
}
class CenterDialogBox extends JDialog  
{  
	private static final long serialVersionUID = 1L;

	@Override
	public void setSize(int width, int height)  
	{  
	  super.setSize(width, height);  
	   
	  Toolkit toolkit = Toolkit.getDefaultToolkit();  
	  Dimension screenSize = toolkit.getScreenSize();  
	  
	  int x = (screenSize.width - getWidth()) / 2;  
	  int y = (screenSize.height - getHeight()) / 2;  
	    
	  setLocation(x, y);     
	 }  
	  
	 @Override
	 public void setSize(Dimension size)  
	 {  
	  setSize(size.width, size.height);  
	 }  
}  