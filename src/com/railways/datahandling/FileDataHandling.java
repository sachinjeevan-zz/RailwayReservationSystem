package com.railways.datahandling;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import com.railways.userinterface.UserInterface;

public class FileDataHandling {
	
	private static ArrayList<String> retrieveUserDataFromCsvColumn(FileReader userFileReader, Integer columnNumber)
	{
			BufferedReader userBufferedReader = new BufferedReader(userFileReader);
			try {
				userBufferedReader.readLine();
 			} catch (IOException e1) {
				
			}
			String lineReadFromCsv;
			ArrayList<String> userMailIds = new ArrayList<>();
			try {
				while((lineReadFromCsv = userBufferedReader.readLine())!=null)
				{
					userMailIds.add(lineReadFromCsv.split(",")[columnNumber]);
				}
			} catch (IOException e) {
				
			}finally
			{
				try {
					userBufferedReader.close();
				} catch (IOException e) {
					
				}
				
			}
			return userMailIds;
		
	}
	
	private static HashMap<String,String> retrieveUserMailAndPassword(FileReader userFileReader)
	{
		HashMap<String,String> userEmailPasswordMap = new HashMap<String, String>();
		BufferedReader userBufferedReader = new BufferedReader(userFileReader);
		try {
			userBufferedReader.readLine();
		} catch (IOException e) {

		}
		String currentLineInScv;
		String[] splittedString;
		try {
			while((currentLineInScv = userBufferedReader.readLine())!=null)
			{
				splittedString = currentLineInScv.split(",");
				userEmailPasswordMap.put(splittedString[2], splittedString[3]);
			}
		} catch (IOException e) {
			
		}
		return userEmailPasswordMap;
	}
	
	public static void userRegisterDetailsWriteinCsv(String userMailId, String userPassword)
	{
		FileWriter userFileWriter = null;
		FileReader userFileReader = null;
		try
		{
			File userFile = new File("C:\\Users\\Sachin Jeevan\\Desktop\\RailwayReservation\\PassengerDetails.csv");
			userFileWriter = new FileWriter(userFile,true);
			if(userFile.length() == 0 )
			{
				userFileWriter.append("passengerId,");
				userFileWriter.append("passengerName,");
				userFileWriter.append("passengerMailId,");
				userFileWriter.append("passengerPassword,");
				userFileWriter.append("passengerGender,");
				userFileWriter.append("passengerAge,");
				userFileWriter.append("passengerMobileNumber,");
			}
			userFileReader = new FileReader(userFile);
			ArrayList<String> userMailIds = retrieveUserDataFromCsvColumn(userFileReader, 2);
			if(!userMailIds.contains(userMailId))
			{
				userFileWriter.append("\n");
				userFileWriter.append(",,"+userMailId+",");
				userFileWriter.append(userPassword+",");
				userFileWriter.flush();
				userFileWriter.close();
			}
			else
			{
				JDialog userExistDialogBox = new JDialog(UserInterface.getRegisterScreen(),"Email already exist",true);
				UserInterface.setUserEmailAlreadyExistDialogBox(userExistDialogBox);
				userExistDialogBox.setLayout(new FlowLayout());
				JButton dialogOkButton = UserInterface.createButton("OK");
				UserInterface.setUserEmailAlreadyExistOkButton(dialogOkButton);
				JLabel mailAlreadyExistLabel = new JLabel("Email Already Exist");
				userExistDialogBox.add(mailAlreadyExistLabel);
				userExistDialogBox.add(dialogOkButton);
				userExistDialogBox.setSize(150, 100);
				UserInterface.onClickRegisterScreenDialogBoxOkButton();
				userExistDialogBox.setVisible(true);
			}
			
			
		}
		catch(IOException f)
		{
			System.out.println("There exist a issue with accessing the mentioned file.");
		}
		finally
		{
			try {
				userFileWriter.close();
			} catch (IOException e) {

			}
			try {
				userFileReader.close();
			} catch (IOException e) {
	
			}
		}
	}
	
	public static Boolean userLoginDetailsReadinCsv(String userMailId, String userPassword)
	{
		File userFile = new File("C:\\Users\\Sachin Jeevan\\Desktop\\RailwayReservation\\PassengerDetails.csv");
		FileReader userFileReader;
		try {
			userFileReader = new FileReader(userFile);
			HashMap userEmailAndPasswordMap = retrieveUserMailAndPassword(userFileReader);
			if(userEmailAndPasswordMap.containsKey(userMailId) && userEmailAndPasswordMap.get(userMailId).equals(userPassword))
			{
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
			
		} catch (FileNotFoundException e) {
			
		}
		return Boolean.FALSE;
	}
}
