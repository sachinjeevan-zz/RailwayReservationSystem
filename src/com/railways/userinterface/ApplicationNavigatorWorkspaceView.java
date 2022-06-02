package com.railways.userinterface;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import com.railways.navigator.RailwayNavigator;

public class ApplicationNavigatorWorkspaceView extends UserInterfaceView {
	
	public static void navigatorWorkspaceScreen()
	{
		JFrame navigatorWorkspaceFrame = createWindow("Train Reservation System",800,600);
		setNavigatorWorkspaceFrame(navigatorWorkspaceFrame);
		JPanel navigatorPanel = createPanel(5, 55, 195, 495);
		setNavigationPanel(navigatorPanel);
		JPanel workspacePanel = createPanel(210, 55, 570, 495);
		setWorkspacePanel(workspacePanel);
		JPanel toolbarPanel = createPanel(5, 5, 770, 30);
		setToolbarPanel(toolbarPanel);
		addComponentsToWindow(navigatorWorkspaceFrame, navigatorPanel, toolbarPanel, workspacePanel);
		getLoginScreen().setVisible(false);
		navigatorWorkspaceFrame.setVisible(true);
		Map<String,Map<String,String>> navigatorWorkspaceLabels = RailwayNavigator.parseNavigatorXml();
		ApplicationNavigatorWorkspaceView.addComponentsToNavigator(navigatorWorkspaceLabels);
		new MovingTextLabel();
	}
	
	public static void addComponentsToNavigator(Map<String,Map<String,String>> navigatorWorkspaceLabels)
	{
		setNavigatorWorkspaceLabels(navigatorWorkspaceLabels);
		Set<String> navigatorLabels = navigatorWorkspaceLabels.keySet();
		DefaultMutableTreeNode rootMenu = new DefaultMutableTreeNode("Ultramain Express");
		for(String navigatorLabel:navigatorLabels)
		{
			DefaultMutableTreeNode navigatorLabelTreeNode = new DefaultMutableTreeNode(navigatorLabel);
			rootMenu.add(navigatorLabelTreeNode);
		}
		JTree newTree = new JTree(rootMenu);
		newTree.addTreeSelectionListener(listener(newTree));
		newTree.setVisible(true);
		newTree.setFont(new Font(newTree.getFont().getFontName(),  Font.BOLD, 16));
		getNavigationPanel().add(newTree);	
	}
	
	private static TreeSelectionListener listener(JTree tree) 
	{
		  TreeSelectionListener objTreeListener = new TreeSelectionListener() 
		  {
			  @Override
			  public void valueChanged(TreeSelectionEvent e) 
			  {
				  DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				  if (node == null)
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
			JButton workspaceButton = new JButton(eachWorkspaceItem,newIcon);
			workspaceButton.setUI(new StyledButtonUI());
			getWorkspacePanel().add(workspaceButton);
			
			workspaceButton.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					
					getNavigatorWorkspaceFrame().setVisible(false);
					TabEntryView.tabEntryViewWindow(workspaceButton);					
				}
			});
		}
	}
	 
}
