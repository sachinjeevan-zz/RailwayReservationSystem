package com.railways.userinterface;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.railways.navigator.RailwayNavigator;

public class ApplicationNavigatorWorkspaceView extends UserInterfaceView {
	
	public static void navigatorWorkspaceScreen()
	{
		JFrame navigatorWorkspaceFrame = createWindow("Train Reservation System",800,600);
		JPanel navigatorPanel = createPanel(5, 100, 195, 495);
		setNavigationPanel(navigatorPanel);
		navigatorPanel.setBackground(Color.gray);
		JPanel workspacePanel = createPanel(210, 100, 585, 495);
		setWorkspacePanel(workspacePanel);
		workspacePanel.setBackground(Color.gray);
		JPanel toolbarPanel = createPanel(5, 5, 790, 70);
		setToolbarPanel(toolbarPanel);
		toolbarPanel.setBackground(Color.gray);
		addComponentsToWindow(navigatorWorkspaceFrame, navigatorPanel, toolbarPanel, workspacePanel);
		getLoginScreen().setVisible(false);
		navigatorWorkspaceFrame.setVisible(true);
	}
	
	public static void addComponentsToNavigator(Map<String,List<String>> navigatorWorkspaceLabels)
	{
		setNavigatorWorkspaceLabels(navigatorWorkspaceLabels);
		Set<String> navigatorLabels = navigatorWorkspaceLabels.keySet();
		DefaultMutableTreeNode rootMenu = new DefaultMutableTreeNode("Railway Reservation System");
		for(String navigatorLabel:navigatorLabels)
		{
			DefaultMutableTreeNode navigatorLabelTreeNode = new DefaultMutableTreeNode(navigatorLabel);
			rootMenu.add(navigatorLabelTreeNode);
		}
		JTree newTree = new JTree(rootMenu);
		newTree.setVisible(true);
		getNavigationPanel().add(newTree);	
	}
}
