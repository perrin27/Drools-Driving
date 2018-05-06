package com.javacodegeeks.drools;

import java.util.ArrayList;
import java.util.List;
//representing cart
public class VehicleRoute {
	private Vehicle vehicle;
	private RouteIssue routeIssues = new RouteIssue();
	private List<RouteStructure> roadStructures = new ArrayList<RouteStructure>();
	private PendingRoutes pendingRoads = new PendingRoutes(vehicle);
	public boolean validPath;
	
	protected boolean isValidPath() {
		validPath = true;
		for(int i = 0; i<roadStructures.size();i++) {//conditions to reroute
			if(roadStructures.get(i).hasConstruction()) {
				validPath = false;
			}
			if(roadStructures.get(i).hasPaypass() == true && vehicle.hasPayPass() != roadStructures.get(i).hasPaypass()) {
				
					validPath = false;
				}
		}
		return validPath;
	}


	public VehicleRoute(Vehicle _vehicle) {
		vehicle = _vehicle;
	}
	
	
	public void addRouteStructure(RouteStructure _routeStructure) {	
		_routeStructure.setVehicleRoute(this);//***
		roadStructures.add(_routeStructure);
	}
	
	public List<RouteStructure> getRouteStructures(){
		return roadStructures;
	}
	////////////////////////////////////////////////////////
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Vehicle getVehicleOfRoute() {
		return vehicle;
	}

	/*
	 * 
	 */
	public void logRoadStructureError(String key, RouteStructure _routeStructure) {
		routeIssues.logItemError(key, _routeStructure);
		pendingRoads.addItem(_routeStructure);
		_routeStructure.setRouteStatus(RouteStatus.PENDING);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (RouteStructure roadStructure : roadStructures) {
			sb.append(roadStructure)
			  .append("\n");
		}
	//	sb.append("Distance: ")
	//	  .append(getDistance())
		return sb.toString();
	}
	
	public PendingRoutes getPendingRouteStructures() {
		return pendingRoads;
	}
	
	public RouteIssue getRouteIssues() {
		return routeIssues;
	}

	public boolean hasIssues() {
		return routeIssues.hasIssues();
	}
}
