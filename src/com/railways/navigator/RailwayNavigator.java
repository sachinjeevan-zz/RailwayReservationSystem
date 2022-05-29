package com.railways.navigator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RailwayNavigator {
	
	public static Map<String,Map<String,String>> parseNavigatorXml()
	{
		File navigatorXml = new File("C:\\Users\\Sachin Jeevan\\UltraMain\\RailwayReservationSystem\\src\\com\\railways\\xml\\Application.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		Map<String,Map<String,String>> navigatorWorkspace = new HashMap<>();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document docParser = dBuilder.parse(navigatorXml);
			Node menuNode = docParser.getElementsByTagName("Menu").item(0);
			NodeList navigatorNodes = menuNode.getChildNodes();
			for(int indexOfItem=0;indexOfItem<navigatorNodes.getLength();indexOfItem++)
			{
				Node currentNode = navigatorNodes.item(indexOfItem);
				if(currentNode.getNodeType()==Node.ELEMENT_NODE)
				{
					NamedNodeMap navigatorAttributes = currentNode.getAttributes();
					NodeList workspaceRef = currentNode.getChildNodes();
					Map<String,String> workspaceLabelNames = new HashMap<>();
					for(int indexOfWorkspaceIndex=0;indexOfWorkspaceIndex<workspaceRef.getLength();indexOfWorkspaceIndex++)
					{
						Node workspaceRefNode = workspaceRef.item(indexOfWorkspaceIndex);
						if(workspaceRefNode.getNodeType()==Node.ELEMENT_NODE)
						{
							NamedNodeMap workspaceAttributes = workspaceRefNode.getAttributes();
							workspaceLabelNames.put(workspaceAttributes.getNamedItem("label").getNodeValue(),workspaceAttributes.getNamedItem("icon").getNodeValue());
						}
						
					}
					navigatorWorkspace.put(navigatorAttributes.getNamedItem("label").getNodeValue(), workspaceLabelNames);
				}
			}
		} catch (ParserConfigurationException e) {
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return navigatorWorkspace;
	}
}
