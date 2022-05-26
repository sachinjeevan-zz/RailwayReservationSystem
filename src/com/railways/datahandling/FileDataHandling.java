package com.railways.datahandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.railways.userinterface.UserInterface;
import com.railways.users.RailwayPassengerEntity;

public class FileDataHandling {
	
	private static final String passengerCsvUrl =  "C:\\Users\\Sachin Jeevan\\Desktop\\RailwayReservation\\PassengerDetails.csv";
	
	public static String getPassengercsvurl() {
		return passengerCsvUrl;
	}

	private static ArrayList<String> retrieveUserDataFromCsvColumn(FileReader userFileReader, Integer columnNumber)
	{
			BufferedReader userBufferedReader = new BufferedReader(userFileReader);
			try {
				userBufferedReader.readLine();
 			} catch (IOException e1) {
				
			}
			String lineReadFromCsv;
			ArrayList<String> userColumnData = new ArrayList<>();
			try {
				while((lineReadFromCsv = userBufferedReader.readLine())!=null)
				{
					userColumnData.add(lineReadFromCsv.split(",")[columnNumber]);
				}
			} catch (IOException e) {
				
			}finally
			{
				try {
					userBufferedReader.close();
				} catch (IOException e) {
					UserInterface.contactAdminDialogBox(UserInterface.getLoginScreen());
				}
			}
			return userColumnData;
		
	}
	
	private static HashMap<String,String> retrieveUserMailAndPassword(FileReader userFileReader)
	{
		HashMap<String,String> userEmailPasswordMap = new HashMap<>();
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
		finally
		{
			try {
				userBufferedReader.close();
			} catch (IOException e) {
				
			}
		}
		return userEmailPasswordMap;
	}
	
	public static void insertRowInPassengerCsv(RailwayPassengerEntity passengerDetails) 
	{
		includeHeaderInPassengerCsv();
		try(FileWriter userFileWriter = new FileWriter(getPassengercsvurl()) ) 
		{
			userFileWriter.append("\n");
			userFileWriter.append(passengerDetails.getPassengerId()+",");
			userFileWriter.append(passengerDetails.getPassengerName()+",");
			userFileWriter.append(passengerDetails.getPassengerMailId()+",");
			userFileWriter.append(passengerDetails.getPassengerPassword()+",");
			userFileWriter.append(passengerDetails.getPassengerGender()+",");
			userFileWriter.append(passengerDetails.getPassengerAge()+",");
			userFileWriter.append(passengerDetails.getPassengerMobileNumber()+",");
			userFileWriter.flush();
		} 
		catch (IOException e) {
			UserInterface.contactAdminDialogBox(UserInterface.getRegisterScreen());
		}
	}
	
	private static void includeHeaderInPassengerCsv()
	{
		File userFile = new File(getPassengercsvurl());
		try(FileWriter userFileWriter = new FileWriter(userFile,true))
		{
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
		}
		catch(IOException e)
		{
			UserInterface.contactAdminDialogBox(UserInterface.getRegisterScreen());
		}
	}
	
	public static List<String> extractAllMailIds()
	{
		
		ArrayList<String> userMailIds = null;
		File userFile = new File(getPassengercsvurl());
		try(FileReader userFileReader = new FileReader(userFile))
		{
			userMailIds = retrieveUserDataFromCsvColumn(userFileReader, 2);
		}
		catch(IOException f)
		{
			UserInterface.contactAdminDialogBox(UserInterface.getRegisterScreen());
		}
		return userMailIds;
	}
	
	public static Boolean userLoginDetailsReadinCsv(String userMailId, String userPassword)
	{
		File userFile = new File(getPassengercsvurl());
		try(FileReader userFileReader = new FileReader(userFile)) 
		{
			HashMap<String,String> userEmailAndPasswordMap = retrieveUserMailAndPassword(userFileReader);
			if(userEmailAndPasswordMap.containsKey(userMailId) && userEmailAndPasswordMap.get(userMailId).equals(userPassword))
			{
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
			
		} 
		catch (IOException e) 
		{
			UserInterface.contactAdminDialogBox(UserInterface.getLoginScreen());
		}
		return Boolean.FALSE;
	}
}
