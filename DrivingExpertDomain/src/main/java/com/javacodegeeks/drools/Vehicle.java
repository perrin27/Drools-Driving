package com.javacodegeeks.drools;

import java.util.ArrayList;
import java.util.List;
//representing customer
public class Vehicle {

	private static String id;
	private boolean gpsNominal;
	private boolean lidarNominal;
	private boolean computerVisonNominal;
	private boolean electricalAutomobileSystemNominal;
	private boolean passengerInSeat;
	private boolean vehicleStatus;
	
	private VehicleRoute vehicleRoute;
	private boolean validPath; 
	
	private boolean payPass;
	//private List<Product> registeredProducts = new ArrayList<Product>();
	
	public static Vehicle newVehicle(String _id){
		Vehicle vehicle = new Vehicle(_id);
		//vehicle.isNew = true;		
		return vehicle;
	}
	
	private Vehicle(String _id) {
		id = _id;
	}
	
	public String getID() {
		return id;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Vehicle is Nominal? ")
		   .append(getVehicleStatus())
		   .append("\nValid Path:")
		   .append(isValidPath())
		   .append("\nHas Pay Pass? ")
		   .append(payPass);
		return sb.toString();
	}

	protected void setVehicleRoute(VehicleRoute _vehicleRoute) {
			this.vehicleRoute = _vehicleRoute;
	}

	protected boolean getVehicleStatus() {
		if(gpsNominal && lidarNominal && computerVisonNominal && electricalAutomobileSystemNominal && passengerInSeat) {
			vehicleStatus = true;
		}else {
			vehicleStatus = false;
		}
		return vehicleStatus;
	}
	
	protected boolean isGpsNominal() {
		return gpsNominal;
	}


	protected void setGpsNominal(boolean gpsNominal) {
		this.gpsNominal = gpsNominal;
	}


	protected boolean isLidarNominal() {
		return lidarNominal;
	}


	protected void setLidarNominal(boolean lidarNominal) {
		this.lidarNominal = lidarNominal;
	}


	protected boolean isComputerVisonNominal() {
		return computerVisonNominal;
	}


	protected void setComputerVisonNominal(boolean computerVisonNominal) {
		this.computerVisonNominal = computerVisonNominal;
	}


	protected boolean isElectricalAutomobileSystem() {
		return electricalAutomobileSystemNominal;
	}


	protected void setElectricalAutomobileSystemNominal(boolean electricalAutomobileSystemNominal) {
		this.electricalAutomobileSystemNominal = electricalAutomobileSystemNominal;
	}


	protected boolean isPassengerInSeat() {
		return passengerInSeat;
	}


	protected void setPassengerInSeat(boolean passengerInSeat) {
		this.passengerInSeat = passengerInSeat;
	}

	protected VehicleRoute getVehicleRoute() {
		try {
		if(vehicleRoute == null) {
			System.out.println("Vehicle needs a destination");
			return vehicleRoute;
		}
		}catch(Exception e){
			System.out.println("Error");
			return null;
		}
		return vehicleRoute;
	}
/*
	protected void setVehicleRoute(VehicleRoute vehicleRoute) {
		this.vehicleRoute = vehicleRoute;
	}
*/
	protected boolean isValidPath() {
		return vehicleRoute.isValidPath();
	}

	protected void setValidPath(boolean validPath) {
		this.validPath = validPath;
	}

	protected boolean hasPayPass() {
		return payPass;
	}

	protected void setPayPass(boolean payPass) {
		this.payPass = payPass;
	}

	protected boolean isElectricalAutomobileSystemNominal() {
		return electricalAutomobileSystemNominal;
	}

	
	
}
