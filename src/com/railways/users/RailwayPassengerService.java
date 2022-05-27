package com.railways.users;

import java.sql.SQLException;
import java.util.List;

import com.railways.datahandling.ApplicationDatabaseConnect;
import com.railways.datahandling.FileDataHandling;
import com.railways.userinterface.RailwayUserRegisterAndLoginView;

public class RailwayPassengerService {
	private RailwayUserEntity  passengerDetails;

	public RailwayUserEntity getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(RailwayUserEntity passengerDetails) {
		this.passengerDetails = passengerDetails;
	}
	
	public void passengerAccountCreation()
	{
		List<String> passengerMailIds =  ApplicationDatabaseConnect.extractMailIdsFromPassengerTable();
		String mailId = passengerDetails.getRailwayUserMailId();
		
		if(!passengerMailIds.contains(mailId))
		{
			ApplicationDatabaseConnect.createPassengerAccount(passengerDetails);
			RailwayUserRegisterAndLoginView.userAccountSuccessfullyRegisteredDialogBox();
		}
		else
		{
			RailwayUserRegisterAndLoginView.userAlreadyExistDialogBox();
		}
	}
	
	public void passengerLoginAccess()
	{
		if(ApplicationDatabaseConnect.checkLoginCredentials(passengerDetails))
		{
			RailwayUserRegisterAndLoginView.applicationLandingPage();
		}
		else
		{
			RailwayUserRegisterAndLoginView.invalidEmailDialogBox();
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
