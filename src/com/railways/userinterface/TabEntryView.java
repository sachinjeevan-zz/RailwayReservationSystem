package com.railways.userinterface;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TabEntryView extends UserInterfaceView
{
	public static void tabEntryViewWindow(JButton currentButton)
	{
		JFrame currentWindow = createWindow(currentButton.getName(), 815, 640);
		JPanel toolbarPanel = createPanel(10,10,780,50);
		//toolbarPanel.setBackground(Color.GRAY);
		JPanel frontBackButtonPanel = createPanel(10,70,780,50);
		//frontBackButtonPanel.setBackground(Color.GRAY);
		JPanel tablePaginationPanel = createPanel(10,130,780,50);
		//tablePaginationPanel.setBackground(Color.GRAY);
		JPanel viewTablePanel = createPanel(10,180,780,200);
		//viewTablePanel.setBackground(Color.GRAY);
		JPanel entryPanel = createPanel(10,390,780,200);
		//entryPanel.setBackground(Color.GRAY);
		
		addComponentsToWindow(currentWindow, toolbarPanel, frontBackButtonPanel, tablePaginationPanel, viewTablePanel, entryPanel );
		currentWindow.setLayout(null);
		currentWindow.setVisible(true);
		if(currentButton.getName()=="Display Train")
		{
			
		}
	}
}
