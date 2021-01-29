package waterlemon.api.insurance.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import waterlemon.api.insurance.exceptions.ResourceNotFoundException;
import waterlemon.api.insurance.models.Vehicle;
import waterlemon.api.insurance.repository.Vehicle_Repository;

@RestController
@RequestMapping("/api/v1/")
public class VehicleController {
 
  @Autowired
  private Vehicle_Repository Vehicle_repository;
  
  //get all vehicle prices
  //@CrossOrigin(origins = "http://localhost:4200") 
  @GetMapping("/vehicle/allQoutes")
  public List<Vehicle> getAllQoutes(){
	  return Vehicle_repository.findAll();
  }

  //get user by id
  @CrossOrigin(origins = "http://localhost:4200") 
  @GetMapping("/vehicle/{id}")
  @ResponseBody
  public ResponseEntity<Vehicle> getQouteByVin(@PathVariable Long id) {
	  Vehicle vehicle = Vehicle_repository.findById(id).orElseThrow(() -> 
	  new ResourceNotFoundException("Vehicle with ID: "+id+"does not exist" ));
	  return ResponseEntity.ok(vehicle);
  }
  
  //get user by id
  //@CrossOrigin(origins = "http://localhost:4200") 
  @GetMapping("/vehicle/getByName/{name}")
  public ResponseEntity<List<Vehicle>> getQouteByName(@PathVariable String name) {
	  Vehicle vehicle = new Vehicle(0, "", "",  name,  "",  "",  "");
      Example<Vehicle> vehicleExample = Example.of(vehicle);
      //calling QueryByExampleExecutor#findAll(Example)
      Iterable<Vehicle> vehicles = Vehicle_repository.findAll(vehicleExample);
      if(!vehicles.iterator().hasNext()) {
    	  vehicles = getAllQoutes();
      }
      List<Vehicle> tempList = new ArrayList<Vehicle>();
      for (Vehicle e : vehicles) {
    	  if(name.equals(e.getName())) {
    		  tempList.add(e);
    	  }
      }
      return ResponseEntity.ok(tempList);
  }
  
  
  @GetMapping("/vehicle/getQouteByBrandByYearByNameByEngineSize/{brand}/{name}/{year}/{engineSize}")
  @ResponseBody
  public ResponseEntity<Vehicle> getQouteByBrandByYearByNameByEngineCapacity(@PathVariable String brand, 
		  @PathVariable String name, @PathVariable String year,@PathVariable String engineSize) {
	  
      Vehicle vehicle = new Vehicle(0, "", brand,  name,  engineSize,  year,  "");
      Example<Vehicle> vehicleExample = Example.of(vehicle);
      //calling QueryByExampleExecutor#findAll(Example)
      Iterable<Vehicle> vehicles = Vehicle_repository.findAll(vehicleExample);
      if(!vehicles.iterator().hasNext()) {
    	  vehicles = getAllQoutes();
      }
      for (Vehicle e : vehicles) {
    	  if( brand.toLowerCase().equals(e.getBrand().toLowerCase())) {
    		  if( name.toLowerCase().equals(e.getName().toLowerCase())) {
    			  if(year.toLowerCase().equals(e.getReleaseYear().toLowerCase())) {
    				   if(engineSize.toLowerCase().equals(e.getEngineSize().toLowerCase())) {
    					   return ResponseEntity.ok(e);
    				   		}
    			  		}
    		  		}
    	  		}
    	  	}
          	return null;
          	//new ResourceNotFoundException("Vehicle with Brand: "+brand+", Name: "+name+", and Release year: "+year+" does not exist" );

  }
  //creates a user rest API
  @CrossOrigin(origins = "http://localhost:4200") 
  @PostMapping("/vehicles/create")
  public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
		return Vehicle_repository.save(vehicle);
	}
  
  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/vehicle/getQouteByBrandByYearByName/{brand}/{name}/{year}")
  public ResponseEntity<List<Vehicle>> getQouteByBrandByYearByName(@PathVariable String name, 
		  @PathVariable String brand, @PathVariable String year) {
	  
      Vehicle vehicle = new Vehicle(0, "", brand,  name,  "",  year, "");
      Example<Vehicle> vehicleExample = Example.of(vehicle);
      //calling QueryByExampleExecutor#findAll(Example)
      Iterable<Vehicle> vehicles = Vehicle_repository.findAll(vehicleExample);
      if(!vehicles.iterator().hasNext()) {
    	  vehicles = getAllQoutes();
      }
      List<Vehicle> tempList = new ArrayList<Vehicle>();
      for (Vehicle e : vehicles) {
    	  if( brand.toLowerCase().equals(e.getBrand().toLowerCase())) { 
    		  if(name.toLowerCase().equals(e.getName().toLowerCase())) {
    			  if(year.toLowerCase().equals(e.getReleaseYear().toLowerCase())) {
    				  tempList.add(e);
    			  }
    		  }
    	  }
      }
      return ResponseEntity.ok(tempList);
  }

}


