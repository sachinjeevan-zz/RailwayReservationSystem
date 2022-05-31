package com.railways.train;

public class RailwayTrainEntity 
{
	private Integer trainNumber;
	private String  trainName;
	private String  trainSourceStation;
	private String trainDestinationStation;
	private Short trainTotalSeats;
	private Short trainSeatsAvailable;
	private Boolean isPantryAvailable;
	
	public Integer getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(Integer trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getTrainSourceStation() {
		return trainSourceStation;
	}
	public void setTrainSourceStation(String trainSourceStation) {
		this.trainSourceStation = trainSourceStation;
	}
	public String getTrainDestinationStation() {
		return trainDestinationStation;
	}
	public void setTrainDestinationStation(String trainDestinationStation) {
		this.trainDestinationStation = trainDestinationStation;
	}
	public Short getTrainTotalSeats() {
		return trainTotalSeats;
	}
	public void setTrainTotalSeats(Short trainTotalSeats) {
		this.trainTotalSeats = trainTotalSeats;
	}
	public Short getTrainSeatsAvailable() {
		return trainSeatsAvailable;
	}
	public void setTrainSeatsAvailable(Short trainSeatsAvailable) {
		this.trainSeatsAvailable = trainSeatsAvailable;
	}
	public Boolean getIsPantryAvailable() {
		return isPantryAvailable;
	}
	public void setIsPantryAvailable(Boolean isPantryAvailable) {
		this.isPantryAvailable = isPantryAvailable;
	}
	
	
}
