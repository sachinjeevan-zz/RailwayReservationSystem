package com.railways.datahandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.railways.users.RailwayUserEntity;

public class ApplicationDatabaseConnect 
{
	private final String DATABASE_URL = "jdbc:mariadb://localhost:3306/railways";
	private final String DATABASE_USERNAME = "root";
	private final String DATABASE_PASSWORD = "iLearn@2021";
	private static Connection appDbConnect;
	private static ApplicationDatabaseConnect applicationDatabaseConnectionObject = getAppDbConnectionObject();
	private ApplicationDatabaseConnect()
	{
		try
		{
			appDbConnect = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
		}
		catch( SQLException e)
		{
			
		}
	}
	
	public static ApplicationDatabaseConnect getAppDbConnectionObject()
	{
		
		if(applicationDatabaseConnectionObject == null)
		{
			applicationDatabaseConnectionObject = new ApplicationDatabaseConnect();
		}
		return applicationDatabaseConnectionObject;
	}
	
	public static void createPassengerTable() throws SQLException
	{
		String createPassengerTableQuery = "CREATE TABLE railway_passengers("
				+ "passenger_id varchar(30),"
				+ "passenger_name varchar(50),"
				+ "passenger_mail_id varchar(30),"
				+ "passenger_password varchar(30),"
				+ "passenger_gender varchar(10),"
				+ "passenger_age int,"
				+ "passenger_mobile_number bigint"
				+ ");";
		Statement sqlStatement = appDbConnect.createStatement();
		sqlStatement.execute(createPassengerTableQuery);
	}
	
	public static List<String> extractMailIdsFromPassengerTable()
	{
		String queryString = "select passenger_mail_id from railway_passengers;";
		Statement statementObject;
		List<String> passengerCredentials = new ArrayList<>();
		try {
			statementObject = appDbConnect.createStatement();
			statementObject.execute(queryString);
			ResultSet resultSet = statementObject.getResultSet();
			while(resultSet.next())
			{
				passengerCredentials.add(resultSet.getString("passenger_mail_id"));
			}
		} catch (SQLException e) {
			
		}
		return passengerCredentials;
	}
	
	public static void createPassengerAccount(RailwayUserEntity railwayPassenger)
	{
		String mailId = railwayPassenger.getRailwayUserMailId();
		String password = railwayPassenger.getRailwayUserPassword();
		String queryString = "insert into railway_passengers(passenger_mail_id,passenger_password) values('"
				+ mailId + "','"+ password+"');";
		try {
			Statement statementObject = appDbConnect.createStatement();
			statementObject.execute(queryString);
		} catch (SQLException e) {
			
		}
		
	}
	
	public static Boolean checkLoginCredentials(RailwayUserEntity railwayPassenger)
	{
		String passengerMailId = railwayPassenger.getRailwayUserMailId();
		String passengerPassword = railwayPassenger.getRailwayUserPassword();
		
		String queryString = "select * from railway_passengers where passenger_mail_id='"
				+ passengerMailId + "' AND passenger_password='"
						+ passengerPassword+ "';";
		
		try {
			Statement statementObject = appDbConnect.createStatement();
			statementObject.execute(queryString);
			return statementObject.getResultSet().first();
		} catch (SQLException e) {
			
		}
		
		return Boolean.FALSE;
		
	}
	public static void addTrainRow(String trainNumber, String trainName, String trainSourceStation, String trainDestinationStation, String trainTotalSeats, String trainSeatsAvailable, String trainIsPantryAvailable) throws SQLException
	{
		String queryString = "insert into railway_trains values(" + trainNumber + ",'" + trainName + "','" + trainSourceStation + "','" + trainDestinationStation + "'," + trainTotalSeats + "," + trainSeatsAvailable + "," + trainIsPantryAvailable + ");";
		Statement statementObject = appDbConnect.createStatement();
		statementObject.execute(queryString);
	}
	
	public static ResultSet retrieveTrainDetailsRange(Integer start, Integer end)
	{
		String queryString = "select * from railway_trains order by train_no limit "+ start + ","+end + ";";
		ResultSet resultData = null;
		try {
			Statement statementObject = appDbConnect.createStatement();
			statementObject.execute(queryString);
			resultData = statementObject.getResultSet();
			
		} catch (SQLException e) {
			
		}
		return resultData;
	}
	
	@Override
	public void finalize()
	{
		try {
			appDbConnect.close();
		} catch (SQLException e) {
			
		}
	}

}
