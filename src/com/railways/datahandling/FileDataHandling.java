package com.railways.datahandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.railways.userinterface.UserInterfaceView;
import com.railways.users.RailwayUserEntity;

public class FileDataHandling {
	
	private static final String PASSENGER_CSV_URL =  "C:\\Users\\Sachin Jeevan\\Desktop\\RailwayReservation\\PassengerDetails.csv";
	private static final String TRAIN_CSV_URL = "C:\\Users\\Sachin Jeevan\\UltraMain\\RailwayReservationSystem\\src\\com\\railways\\xml\\TrainDetails.csv";
	public static String getPassengercsvurl() {
		return PASSENGER_CSV_URL;
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
					UserInterfaceView.contactAdminDialogBox(UserInterfaceView.getLoginScreen());
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
	
	public static void insertRowInPassengerCsv(RailwayUserEntity passengerDetails) 
	{
		includeHeaderInPassengerCsv();
		try(FileWriter userFileWriter = new FileWriter(getPassengercsvurl()) ) 
		{
			userFileWriter.append("\n");
			userFileWriter.append(passengerDetails.getRailwayUserId()+",");
			userFileWriter.append(passengerDetails.getRailwayUserName()+",");
			userFileWriter.append(passengerDetails.getRailwayUserMailId()+",");
			userFileWriter.append(passengerDetails.getRailwayUserPassword()+",");
			userFileWriter.append(passengerDetails.getRailwayUserGender()+",");
			userFileWriter.append(passengerDetails.getRailwayUserAge()+",");
			userFileWriter.append(passengerDetails.getRailwayUserMobileNumber()+",");
			userFileWriter.flush();
		} 
		catch (IOException e) {
			UserInterfaceView.contactAdminDialogBox(UserInterfaceView.getRegisterScreen());
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
			UserInterfaceView.contactAdminDialogBox(UserInterfaceView.getRegisterScreen());
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
			UserInterfaceView.contactAdminDialogBox(UserInterfaceView.getRegisterScreen());
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
			UserInterfaceView.contactAdminDialogBox(UserInterfaceView.getLoginScreen());
		}
		return Boolean.FALSE;
	}
	
	public static void extractdataFromCsvAndImportToDb()
	{
		File newFile = new File(TRAIN_CSV_URL);
		try(FileReader newFileReader = new FileReader(newFile);BufferedReader trainCsvReader = new BufferedReader(newFileReader)) 
		{
			trainCsvReader.readLine();
			String currentLine;
			while((currentLine = trainCsvReader.readLine())!=null)
			{
				String[] trainDetails = currentLine.split(",");
				String trainNumber = trainDetails[0];
				String trainName = trainDetails[1];
				String trainSourceStation = trainDetails[2];
				String trainDestinationStation = trainDetails[3];
				String trainTotalSeats = trainDetails[4];
				String trainSeatsAvailable = trainDetails[4];
				String trainIsPantryAvailable = "1";
				ApplicationDatabaseConnect.getApplicationDatabaseConnectionObject().addTrainRow(trainNumber, trainName, trainSourceStation, trainDestinationStation, trainTotalSeats, trainSeatsAvailable, trainIsPantryAvailable);
			}
		} 
		catch (IOException e) 
		{
			
		}
	}
}
