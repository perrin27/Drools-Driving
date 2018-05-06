package com.javacodegeeks.drools;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {
	/**
	 * Hard coded path and vehicle path declaration in version 1(may place estimated time)
	 * @param args
	 */
	public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            Vehicle vehicle = Vehicle.newVehicle("Impalla");
            vehicle.setGpsNominal(true);
            vehicle.setLidarNominal(true);
            vehicle.setElectricalAutomobileSystemNominal(true);
            vehicle.setComputerVisonNominal(true);
            vehicle.setPassengerInSeat(true);
            vehicle.setPayPass(true);
            
            //possible crude random route generator 
    		RouteStructure r1 = new RouteStructure("Road");//establishing road structure
    		r1.setConstruction(false);
    		r1.payPassRequired(false);
    		r1.setSpeed(30);
    		r1.setStart(true);
    		/**
    		RouteStructure r2 = new RouteStructure("Crossoad"); 
    		r2.setConstruction(false);
    		r2.payPassRequired(false);
    		r2.setStop(true);
    		RouteStructure r3 = new RouteStructure("Road");
    		r3.setConstruction(false);
    		r3.payPassRequired(false);
    		r3.setSpeed(40);
    		RouteStructure r4 = new RouteStructure("Cloverleaf");
    		r4.setConstruction(false);
    		r4.payPassRequired(false);
    		r4.setSpeed(25);
    		RouteStructure r5 = new RouteStructure("Interstate");
    		r5.setConstruction(false);
    		r5.payPassRequired(false);
    		r5.setSpeed(70);
    		RouteStructure r6 = new RouteStructure("Cloverleaf");
    		r1.setConstruction(false);
    		r1.payPassRequired(false);
    		r1.setSpeed(25);
    		RouteStructure r7 = new RouteStructure("Street");
    		r6.setConstruction(false);
    		r6.payPassRequired(false);
    		r6.setSpeed(30);
    		r6.setFinish(true);
    		**/
    		
    		VehicleRoute vehicleRoute = new VehicleRoute(vehicle);   		
    		vehicleRoute.addRouteStructure(r1);//adding route to vehicle 
    		/**
    		vehicleRoute.addRouteStructure(r2);
    		vehicleRoute.addRouteStructure(r3);
    		vehicleRoute.addRouteStructure(r4);
    		vehicleRoute.addRouteStructure(r5);
    		vehicleRoute.addRouteStructure(r6);
    		vehicleRoute.addRouteStructure(r7);
    		**/
    		vehicle.setVehicleRoute(vehicleRoute);


    		List<RouteStructure> routeStructures = vehicleRoute.getRouteStructures();
    		for (RouteStructure routeStructure: routeStructures) {
    			kSession.insert(routeStructure);
    		}
    		System.out.println("************* Fire Rules **************");
            kSession.fireAllRules(); 
            System.out.println("************************************");
            System.out.println("Transportation Procedure\n" + vehicle);
           /* 
            Customer newCustomer = Customer.newCustomer("JOHN01");
    		newCustomer.addItem(p1, 1);
    		newCustomer.addItem(p2, 2);
    		newCustomer.addItem(p4OutOfStock, 1);
    		newCustomer.addItem(p5, 10);    		
    		
    		cartItems = newCustomer.getCart().getCartItems();
    		for (CartItem cartItem: cartItems) {
    			kSession.insert(cartItem);
    		}
    		kSession.insert(newCustomer.getCart());
    		kSession.setGlobal("outOfStockProducts", new ArrayList<Product>());
    		System.out.println("************* Fire Rules **************");
            kSession.fireAllRules(); 
            System.out.println("************************************");
            System.out.println("Customer cart\n" + customer);
             */           
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
