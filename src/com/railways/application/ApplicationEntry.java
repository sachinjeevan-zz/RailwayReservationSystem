package com.railways.application;

import com.railways.datahandling.ApplicationDatabaseConnect;
import com.railways.userinterface.UserInterface;
import com.railways.users.RailwayPassengerService;

public class ApplicationEntry 
{
	public static void main(String[] args) 
	{
		 	UserInterface.homeScreen();
		 	ApplicationDatabaseConnect.extractMailIdsFromPassengerTable();
	}
}