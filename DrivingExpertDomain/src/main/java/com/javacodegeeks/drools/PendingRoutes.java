package com.javacodegeeks.drools;

import java.util.ArrayList;
import java.util.List;

//pending items
public class PendingRoutes {
	private Vehicle vehicle;
	private List<RouteStructure> routeStructures = new ArrayList<RouteStructure>();
	
	public PendingRoutes(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Vehicle getvehicle() {
		return vehicle;
	}	
	
	public List<RouteStructure> getCartItems() {
		return routeStructures;
	}

	public void addItem(RouteStructure routeStructure) {
		routeStructures.add(routeStructure);
	}
}
