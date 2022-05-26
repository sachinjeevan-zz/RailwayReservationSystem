package com.railways.datahandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.railways.users.RailwayPassengerEntity;

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
	
	public static void extractMailIdsFromPassengerTable()
	{
		String queryString = "select passenger_mail_id, passenger_password from railway_passengers;";
		Statement statementObject;
		try {
			statementObject = appDbConnect.createStatement();
			statementObject.execute(queryString);
			System.out.println(statementObject.getResultSet());
		} catch (SQLException e) {
			
		}
	}
	
	public static void createPassengerAccount(RailwayPassengerEntity railwayPassenger)
	{
		String mailId = railwayPassenger.getPassengerMailId();
		String password = railwayPassenger.getPassengerPassword();
		String queryString = "insert into railway_passengers(passenger_mail_id,passenger_password) values('"
				+ mailId + "','"+ password+"');";
		try {
			Statement statementObject = appDbConnect.createStatement();
			statementObject.execute(queryString);
		} catch (SQLException e) {
			
		}
		
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
