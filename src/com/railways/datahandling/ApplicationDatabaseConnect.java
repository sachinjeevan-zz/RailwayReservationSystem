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
	private static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/railways";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "iLearn@2021";
	private Connection appDbConnect;
	private static ApplicationDatabaseConnect applicationDatabaseConnectionObject = getAppDbConnectionObject();
	private ApplicationDatabaseConnect()
	{
		try
		{
			setAppDbConnect(DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD));
		}
		catch( SQLException e)
		{
			
		}
	}
	
	public Connection getAppDbConnect() {
		return appDbConnect;
	}

	public void setAppDbConnect(Connection appDbConnect) {
		this.appDbConnect = appDbConnect;
	}

	
	public static ApplicationDatabaseConnect getApplicationDatabaseConnectionObject() {
		return applicationDatabaseConnectionObject;
	}

	public static void setApplicationDatabaseConnectionObject(
			ApplicationDatabaseConnect applicationDatabaseConnectionObject) {
		ApplicationDatabaseConnect.applicationDatabaseConnectionObject = applicationDatabaseConnectionObject;
	}

	public static ApplicationDatabaseConnect getAppDbConnectionObject()
	{
		
		if(applicationDatabaseConnectionObject == null)
		{
			applicationDatabaseConnectionObject = new ApplicationDatabaseConnect();
		}
		return applicationDatabaseConnectionObject;
	}
	
	public void createPassengerTable()
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
		try(Statement sqlStatement = getAppDbConnect().createStatement()) 
		{
			sqlStatement.execute(createPassengerTableQuery);
		} 
		catch (SQLException e) 
		{

		}
	}
	
	public List<String> extractMailIdsFromPassengerTable()
	{
		String queryString = "select passenger_mail_id from railway_passengers;";
		List<String> passengerCredentials = new ArrayList<>();
		try(Statement statementObject = getAppDbConnect().createStatement()) 
		{
			statementObject.execute(queryString);
			ResultSet resultSet = statementObject.getResultSet();
			while(resultSet.next())
			{
				passengerCredentials.add(resultSet.getString("passenger_mail_id"));
			}
		} 
		catch (SQLException e) 
		{
			
		}
		return passengerCredentials;
	}
	
	public void createPassengerAccount(RailwayUserEntity railwayPassenger)
	{
		String mailId = railwayPassenger.getRailwayUserMailId();
		String password = railwayPassenger.getRailwayUserPassword();
		String queryString = "insert into railway_passengers(passenger_mail_id,passenger_password) values('"
				+ mailId + "','"+ password+"');";
		try(Statement statementObject = getAppDbConnect().createStatement()) 
		{
			statementObject.execute(queryString);
		} 
		catch (SQLException e) 
		{
			
		}
		
	}
	
	public Boolean checkLoginCredentials(RailwayUserEntity railwayPassenger)
	{
		String passengerMailId = railwayPassenger.getRailwayUserMailId();
		String passengerPassword = railwayPassenger.getRailwayUserPassword();
		String queryString = "select * from railway_passengers where passenger_mail_id='"
				+ passengerMailId + "' AND passenger_password='"
				+ passengerPassword+ "';";
		try(Statement statementObject = getAppDbConnect().createStatement()) 
		{
			statementObject.execute(queryString);
			return statementObject.getResultSet().first();
		} 
		catch (SQLException e) 
		{
			
		}
		return Boolean.FALSE;	
	}
	
	public void addTrainRow(String trainNumber, String trainName, String trainSourceStation, String trainDestinationStation, String trainTotalSeats, String trainSeatsAvailable, String trainIsPantryAvailable)
	{
		String queryString = "insert into railway_trains values("
				+ trainNumber + ",'" + trainName + "','" 
				+ trainSourceStation + "','" + trainDestinationStation 
				+ "'," + trainTotalSeats + "," + trainSeatsAvailable + "," 
				+ trainIsPantryAvailable + ");";
		try(Statement statementObject = getAppDbConnect().createStatement())
		{
			statementObject.execute(queryString);
		} 
		catch (SQLException e) 
		{

		}
	}
	
	public ResultSet retrieveTrainDetailsRange(Integer start, Integer end)
	{
		String queryString = "select * from railway_trains order by train_no limit "
							 + start + ","+ end + ";";
		ResultSet resultData = null;
		try(Statement statementObject = getAppDbConnect().createStatement()) 
		{
			statementObject.execute(queryString);
			resultData = statementObject.getResultSet();
		} 
		catch (SQLException e) 
		{
			
		}
		return resultData;
	}

}
