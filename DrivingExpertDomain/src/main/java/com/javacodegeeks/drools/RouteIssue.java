package com.javacodegeeks.drools;

import java.util.HashMap;
import java.util.Map;

public class RouteIssue {

private Map<String, RouteStructure> roadErrors = new HashMap<String, RouteStructure>();
	
	public void logItemError(String key, RouteStructure routeStructure) {
		roadErrors.put(key,  routeStructure);
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String key : roadErrors.keySet()) {
			sb.append(key).append(roadErrors.get(key)).append("\n");
		}
		return sb.toString();
	}
	
	public boolean hasIssues() {
		return !roadErrors.isEmpty();
	}
	
}
