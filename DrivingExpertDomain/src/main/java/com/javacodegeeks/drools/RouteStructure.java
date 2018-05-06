package com.javacodegeeks.drools;
//representing cartitem
public class RouteStructure {
	
	protected String intersectionType;
	protected boolean intersection;
	protected boolean start;
	protected boolean finish;
	protected int speed;
	protected boolean construction;
	protected boolean paypass;
	protected boolean stop;
	protected VehicleRoute vehicleRoute;
	private RouteStatus routeStatus;

		protected void setVehicleRoute(VehicleRoute vehiclRoute) {
		this.vehicleRoute=vehiclRoute;
	}
		
		protected VehicleRoute getVehicleRoute() {
			return vehicleRoute;
		}


		RouteStructure(String _intersectionType){
			//intersection = _intersection;
			intersectionType = _intersectionType;
			//speed = _speed;
			//construction = _construction;
			//paypass = _paypass;
			//stop = _stop;
		}


		protected String getIntersectionType() {
			return intersectionType;
		}

		protected void setIntersectionType(String intersectionType) {
			this.intersectionType = intersectionType;
		}

		protected boolean isStart() {
			return start;
		}

		protected void setStart(boolean start) {
			this.start = start;
		}

		protected boolean isFinish() {
			return finish;
		}

		protected void setFinish(boolean finish) {
			this.finish = finish;
		}

		protected int getSpeed() {
			return speed;
		}

		protected void setSpeed(int speed) {
			this.speed = speed;
		}

		protected boolean hasConstruction() {
			return construction;
		}

		protected void setConstruction(boolean construction) {
			this.construction = construction;
		}

		protected boolean hasPaypass() {
			return paypass;
		}

		protected void payPassRequired(boolean paypass) {
			this.paypass = paypass;
		}

		protected boolean isStop() {
			return stop;
		}

		protected void setStop(boolean stop) {
			this.stop = stop;
		}
		
		public void updateAsProcessed() {
			routeStatus = routeStatus.PROCESSED;
		}
		
		public void setRouteStatus(RouteStatus routeStatus) {
			this.routeStatus = routeStatus;
		}
	
}
