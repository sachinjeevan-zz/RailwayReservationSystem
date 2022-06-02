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

public class RailwayNavigator 
{
	private static final String APPLICATION_XML_LOCATION = "C:\\Users\\Sachin Jeevan\\UltraMain\\RailwayReservationSystem\\src\\com\\railways\\xml\\Application.xml";
	private static final String DISALLOW_DOC_TYPE = "http://apache.org/xml/features/disallow-doctype-decl";
	private static final String EXTERNAL_GENERAL_ENTITIES = "http://xml.org/sax/features/external-general-entities";
	private static final String EXTERNAL_PARAMETER_ENTITIES = "http://xml.org/sax/features/external-parameter-entities";
	public static Map<String,Map<String,String>> parseNavigatorXml()
	{
		File applicationXml = new File(APPLICATION_XML_LOCATION);
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		
		Map<String,Map<String,String>> navigatorWorkspaceDetails = new HashMap<>();
		try 
		{
			docBuilderFactory.setFeature(DISALLOW_DOC_TYPE,true);
			docBuilderFactory.setFeature(EXTERNAL_GENERAL_ENTITIES,false);
			docBuilderFactory.setFeature(EXTERNAL_PARAMETER_ENTITIES,false);
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
					workspaceDetails = new HashMap<>();
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
			
		} 
		catch (ParserConfigurationException | SAXException | IOException e) 
		{
			
		}
		return navigatorWorkspaceDetails;
	}
}
