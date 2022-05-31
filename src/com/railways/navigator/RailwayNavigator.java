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
	private final static String APPLICATION_XML_LOCATION = "C:\\Users\\Sachin Jeevan\\UltraMain\\RailwayReservationSystem\\src\\com\\railways\\xml\\Application.xml";
	public static Map<String,Map<String,String>> parseNavigatorXml()
	{
		File applicationXml = new File(APPLICATION_XML_LOCATION);
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		Map<String,Map<String,String>> navigatorWorkspaceDetails = new HashMap<String, Map<String,String>>();
		try 
		{
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document docParser = docBuilder.parse(applicationXml);
			NodeList rootNodeList = docParser.getElementsByTagName("Menu");
			Node rootNode = rootNodeList.item(0);
			NodeList navigatorNodeList = rootNode.getChildNodes();
			Node currentNavigatorNode;
			NodeList workspaceNodeList;
			Map<String,String> workspaceDetails;
			Node currentWorkspaceNode;
			Integer indexOfNavigatorNode;
			Integer indexOfWorkspaceNode;
			NamedNodeMap workspaceAttributes;
			for(indexOfNavigatorNode=0;indexOfNavigatorNode<navigatorNodeList.getLength();indexOfNavigatorNode++)
			{
				currentNavigatorNode = navigatorNodeList.item(indexOfNavigatorNode);
				if(currentNavigatorNode.getNodeType() == Node.ELEMENT_NODE)
				{
					workspaceNodeList = currentNavigatorNode.getChildNodes();
					workspaceDetails = new HashMap<String, String>();
					for(indexOfWorkspaceNode = 0; indexOfWorkspaceNode< workspaceNodeList.getLength(); indexOfWorkspaceNode++)
					{
						currentWorkspaceNode = workspaceNodeList.item(indexOfWorkspaceNode);
						if(currentWorkspaceNode.getNodeType()==Node.ELEMENT_NODE)
						{
							workspaceAttributes = currentWorkspaceNode.getAttributes();
							workspaceDetails.put(workspaceAttributes.getNamedItem("label").getNodeValue(), workspaceAttributes.getNamedItem("icon").getNodeValue());
						}
					}
					navigatorWorkspaceDetails.put(currentNavigatorNode.getAttributes().getNamedItem("label").getNodeValue(), workspaceDetails);
				}
				
			}
			
		} catch (ParserConfigurationException e) {
			
		} catch (SAXException e) {
			
		} catch (IOException e) {
			
		}
		return navigatorWorkspaceDetails;
	}
}
