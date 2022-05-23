package com.railways.users;

import java.util.List;

import com.railways.datahandling.FileDataHandling;
import com.railways.userinterface.UserInterface;

public class RailwayPassengerService {
	private RailwayPassenger  passengerDetails;

	public RailwayPassenger getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(RailwayPassenger passengerDetails) {
		this.passengerDetails = passengerDetails;
	}
	
	public void passengerAccountCreation()
	{
		List<String> userMailIds =  FileDataHandling.userRegisterDetailsWriteinCsv();
		if(!userMailIds.contains(passengerDetails.getPassengerMailId()))
		{
			FileDataHandling.insertRowInPassengerCsv(passengerDetails);
			UserInterface.userAccountSuccessfullyRegisteredDialogBox();	
		}
		else
		{
			UserInterface.userAlreadyExistDialogBox();
		}
	}
}
