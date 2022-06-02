package com.railways.users;

import java.util.List;

import com.railways.datahandling.ApplicationDatabaseConnect;
import com.railways.userinterface.ApplicationNavigatorWorkspaceView;
import com.railways.userinterface.RailwayUserRegisterAndLoginView;

public class RailwayPassengerService 
{
	private RailwayUserEntity  passengerDetails;

	public RailwayUserEntity getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(RailwayUserEntity passengerDetails) {
		this.passengerDetails = passengerDetails;
	}
	
	public void passengerAccountCreation()
	{
		List<String> passengerMailIds =  ApplicationDatabaseConnect.getApplicationDatabaseConnectionObject().extractMailIdsFromPassengerTable();
		String mailId = passengerDetails.getRailwayUserMailId();
		if(!passengerMailIds.contains(mailId))
		{
			ApplicationDatabaseConnect.getApplicationDatabaseConnectionObject().createPassengerAccount(passengerDetails);
			RailwayUserRegisterAndLoginView.userAccountSuccessfullyRegisteredDialogBox();
		}
		else
		{
			RailwayUserRegisterAndLoginView.userAlreadyExistDialogBox();
		}
	}
	
	public void passengerLoginAccess()
	{
		if(Boolean.TRUE.equals(ApplicationDatabaseConnect.getApplicationDatabaseConnectionObject().checkLoginCredentials(passengerDetails)))
		{
			ApplicationNavigatorWorkspaceView.navigatorWorkspaceScreen();
		}
		else
		{
			RailwayUserRegisterAndLoginView.invalidEmailDialogBox();
		}
	}
	
}
