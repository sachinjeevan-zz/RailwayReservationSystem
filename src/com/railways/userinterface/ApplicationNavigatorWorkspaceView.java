package com.railways.userinterface;

import java.awt.Color;
import java.awt.Image;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

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
	
	public static void addComponentsToNavigator(Map<String,Map<String,String>> navigatorWorkspaceLabels)
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
		newTree.addTreeSelectionListener(listener(newTree));
		newTree.setVisible(true);
		getNavigationPanel().add(newTree);	
	}
	
	private static TreeSelectionListener listener(JTree tree) 
	{
		  TreeSelectionListener objTreeListener = new TreeSelectionListener() 
		  {
			  @SuppressWarnings("unused")
			  @Override
			  public void valueChanged(TreeSelectionEvent e) 
			  {
				  DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				  if (node == null)
					  // Nothing is selected.
					  return;

				  Object nodeInfo = node.getUserObject();
				  String nodeLabelName;
				  if (node.isLeaf()) 
				  {
					  nodeLabelName = nodeInfo.toString();
					  addComponentsToWorkspace(nodeLabelName);
				  } 
			  }
		  };
		  return objTreeListener;
	}
	
	private static void addComponentsToWorkspace(String navigatorLabelName)
	{
		Map<String,Map<String,String>> navigatorWorkspaceMapping = getNavigatorWorkspaceLabels();
		Set<String> currentWorkspaceItems = navigatorWorkspaceMapping.get(navigatorLabelName).keySet();
		getWorkspacePanel().removeAll();
		getWorkspacePanel().revalidate();
		getWorkspacePanel().repaint();
		for(String eachWorkspaceItem:currentWorkspaceItems)
		{
			ImageIcon newIcon = new ImageIcon(getIconLocation()+navigatorWorkspaceMapping.get(navigatorLabelName).get(eachWorkspaceItem));
			Image newImage = newIcon.getImage();
			newImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			newIcon = new ImageIcon(newImage);
			System.out.println(newIcon.toString());
			JButton workspaceButton = new JButton(eachWorkspaceItem,newIcon);
			workspaceButton.setUI(new StyledButtonUI());
			getWorkspacePanel().add(workspaceButton);
		}
	}
	 
	 
}
