package com.railways.users;

import java.sql.SQLException;
import java.util.List;

import com.railways.datahandling.ApplicationDatabaseConnect;
import com.railways.datahandling.FileDataHandling;
import com.railways.userinterface.UserInterface;

public class RailwayPassengerService {
	private RailwayPassengerEntity  passengerDetails;

	public RailwayPassengerEntity getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(RailwayPassengerEntity passengerDetails) {
		this.passengerDetails = passengerDetails;
	}
	
	public void passengerAccountCreation()
	{
		List<String> passengerMailIds =  ApplicationDatabaseConnect.extractMailIdsFromPassengerTable();
		String mailId = passengerDetails.getPassengerMailId();
		
		if(!passengerMailIds.contains(mailId))
		{
			ApplicationDatabaseConnect.createPassengerAccount(passengerDetails);
			UserInterface.userAccountSuccessfullyRegisteredDialogBox();
		}
		else
		{
			UserInterface.userAlreadyExistDialogBox();
		}
	}
	
	public static void createPassengerTableSchema()
	{
		try {
			ApplicationDatabaseConnect.createPassengerTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
