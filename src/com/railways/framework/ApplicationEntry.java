package com.railways.framework;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.railways.userinterface.RailwayUserRegisterAndLoginView;

public class ApplicationEntry 
{
	public static void main(String[] args) 
	{
			FlatDarculaLaf.setup();
		 	RailwayUserRegisterAndLoginView.userSelectionScreen();
	}
}