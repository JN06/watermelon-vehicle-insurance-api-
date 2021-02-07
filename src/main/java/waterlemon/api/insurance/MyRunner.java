package waterlemon.api.insurance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import waterlemon.api.insurance.controller.VehicleController;
import waterlemon.api.insurance.models.Vehicle;

@Component
public class MyRunner implements CommandLineRunner {
	/*
    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private VehicleController vehicleController;
    @Override
    public void run(String...args) throws Exception {
    	
    	//Vehicle Brand 1
    	vehicleController.createVehicle( new Vehicle( 1,658764L, "BMW",  "M3", "4.0", "2009", 450.75));
    	vehicleController.createVehicle( new Vehicle( 1,96546898L, "BMW",  "1 Series", "2.0", "2017", 188.59));
    	vehicleController.createVehicle( new Vehicle( 1,34745642L, "BMW",  "X5", "3.6", "2019", 512.07));
    	
    	//Vehicle Brand 2
    	vehicleController.createVehicle( new Vehicle( 1,36566786L, "BMW",  "M3", "4.0", "2016", 450.75));
    	vehicleController.createVehicle( new Vehicle( 1,96435657L, "BMW",  "M3", "4.0", "2016", 450.75));
    	vehicleController.createVehicle( new Vehicle( 1,714653256L, "BMW",  "M3", "4.0", "2016", 450.75));
    	
    	//Vehicle Brand 3
    	vehicleController.createVehicle( new Vehicle( 1,96857413L, "BMW",  "M3", "4.0", "2016", 450.75));
    	vehicleController.createVehicle( new Vehicle( 1,34789461L, "BMW",  "M3", "4.0", "2016", 450.75));
    	vehicleController.createVehicle( new Vehicle( 1,4796346L, "BMW",  "M3", "4.0", "2016", 450.75));
	
    }*/
	public void run(String...args) throws Exception {
		
	}
}

