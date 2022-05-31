package com.railways.users;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.railways.datahandling.ApplicationDatabaseConnect;
import com.railways.navigator.RailwayNavigator;
import com.railways.userinterface.ApplicationNavigatorWorkspaceView;
import com.railways.userinterface.MovingTextLabel;
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
			ApplicationNavigatorWorkspaceView.navigatorWorkspaceScreen();
			
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
