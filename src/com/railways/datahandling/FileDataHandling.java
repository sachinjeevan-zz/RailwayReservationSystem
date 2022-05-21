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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import com.railways.userinterface.UserInterface;

public class FileDataHandling {
	
	public static ArrayList<String> retrieveUserDataFromCsvColumn(FileReader userFileReader, Integer columnNumber)
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
	public static void userRegisterDetailsWriteinCsv(String passengerMailId, String passengerPassword)
	{
		try
		{
			File userFile = new File("C:\\Users\\Sachin Jeevan\\Desktop\\RailwayReservation\\PassengerDetails.csv");
			FileWriter userFileWriter = new FileWriter(userFile,true);
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
			FileReader userFileReader = new FileReader(userFile);
			ArrayList<String> userMailIds = retrieveUserDataFromCsvColumn(userFileReader, 2);
			if(!userMailIds.contains(passengerMailId))
			{
				userFileWriter.append("\n");
				userFileWriter.append(",,"+passengerMailId+",");
				userFileWriter.append(passengerPassword+",");
				userFileWriter.flush();
				userFileWriter.close();
			}
			else
			{
				JDialog userExistDialogBox = new JDialog(UserInterface.getRegisterScreen(),"Email already exist",true);
				userExistDialogBox.setLayout(new FlowLayout());
				JButton dialogOkButton = UserInterface.createButton("OK");
				JLabel mailAlreadyExistLabel = new JLabel("Email Already Exist");
				userExistDialogBox.add(mailAlreadyExistLabel);
				userExistDialogBox.add(dialogOkButton);
				userExistDialogBox.setSize(150, 100);
				userExistDialogBox.setVisible(true);
				dialogOkButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						userExistDialogBox.setVisible(false);
					}
				});
			}
			
			
		}
		catch(IOException f)
		{
			System.out.println("There exist a issue with accessing the mentioned file.");
		}
	}
}
