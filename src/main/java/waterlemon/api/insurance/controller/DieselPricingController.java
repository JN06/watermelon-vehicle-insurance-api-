package waterlemon.api.insurance.controller;

	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.ResponseBody;

	import java.util.ArrayList;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import waterlemon.api.insurance.exceptions.ResourceNotFoundException;
	import waterlemon.api.insurance.models.DieselPricing;
import waterlemon.api.insurance.models.PetrolPricing;
import waterlemon.api.insurance.repository.DieselPricing_Repository;


	@RestController
	@RequestMapping("/api/v1/")
	public class DieselPricingController {

		
		  @Autowired
		  private DieselPricing_Repository dieselPricing_repository;
		  
		  @GetMapping("/dpricing/get_all")
		  public ResponseEntity<List<DieselPricing>> getAllQoutes(){
			  List<DieselPricing> tempList = dieselPricing_repository.findAll();
			  if(tempList.isEmpty()) {
				  throw new ResourceNotFoundException("There are currently no generic qoutations");
				  }
			    return new ResponseEntity<List<DieselPricing>>(tempList, HttpStatus.OK);
			  //return dieselPricing_repository.findAll();
		  }
		  
		  @CrossOrigin(origins = "http://localhost:4200")
		  @GetMapping("/dpricing/get_specific/{vehicle_value}/{term}")
		  public ResponseEntity<List<DieselPricing>> getSpecificPricing(@PathVariable String vehicle_value, 
				  @PathVariable String term) {
			  
			  DieselPricing petrolPricing = new DieselPricing(0, "99999", 385.00, 495.00, 388.00, 581.00, 299.00, 384.00, 301.00, 451.00);
		      Example<DieselPricing> petrolPricingExample = Example.of(petrolPricing);
		      //calling QueryByExampleExecutor#findAll(Example)
		      Iterable<DieselPricing> qoutation = dieselPricing_repository.findAll(petrolPricingExample);
		      if(!qoutation.iterator().hasNext()) {
		    	  qoutation = dieselPricing_repository.findAll();
		      }
		      List<DieselPricing> tempList = new ArrayList<DieselPricing>();
		      for (DieselPricing e : qoutation) {
		    	  String[] range = vehicle_value.split("-");
		    	  if((Double.parseDouble(vehicle_value) >= Double.parseDouble(range[0])) || 
		    			  (Double.parseDouble(vehicle_value) <= Double.parseDouble(range[1]))) {
		    		  String[] terms = vehicle_value.split("yr_"); 
		    		  Double tempMileage = Double.parseDouble(terms[1].replaceAll("([a-z])", ""));
		    		  Double tempDuration = Double.parseDouble(terms[0].substring(terms[0].length() - 1)); 
		    		  Double inputTerm = Double.parseDouble(term); 
		    		  if( tempMileage == inputTerm || tempDuration == inputTerm) {
			    		  tempList.add(e);
			    	  }
		    	  }
		      }
		      if(tempList.isEmpty()) {
		    	  new ResourceNotFoundException("Could not get qouation for: Vehicle to the value of R"+vehicle_value+", term: "+term+" " );
		      }else {
		    	  return ResponseEntity.ok(tempList);
		    	  
		      }
		      new ResourceNotFoundException("Could not get qouation for: Vehicle to the value of R"+vehicle_value+", term: "+term+" " );
		      return null;
		  }
		  
		  @CrossOrigin(origins = "http://localhost:4200")
		  @GetMapping("/dpricing/get_by_value/{vehicle_value}")
		  public ResponseEntity<List<DieselPricing>> getPricingByVehicleValue(@PathVariable String vehicle_value) {
			  
			  DieselPricing petrolPricing = new DieselPricing(0, "99999", 385.00, 495.00, 388.00, 581.00, 299.00, 384.00, 301.00, 451.00);
		      Example<DieselPricing> dieselPricingExample = Example.of(petrolPricing);
		      //calling QueryByExampleExecutor#findAll(Example)
		      Iterable<DieselPricing> qoutation = dieselPricing_repository.findAll(dieselPricingExample);
		      if(!qoutation.iterator().hasNext()) {
		    	  qoutation = dieselPricing_repository.findAll();
		      }
		      List<DieselPricing> tempList = new ArrayList<DieselPricing>();
		      for (DieselPricing e : qoutation) {
		    	  String[] range = e.getCar_value_range().split("-");
		    	  if((Double.parseDouble(vehicle_value) >= Double.parseDouble(range[0])) && 
		    			  (Double.parseDouble(vehicle_value) <= Double.parseDouble(range[1]))) {
			    		  tempList.add(e);
			    		  break;
		    	  }
		      }
		      if(tempList.isEmpty()) {
		    	  new ResourceNotFoundException("Could not get qouation for: Vehicle to the value of R"+vehicle_value+"" );
		      }else {
		    	  return ResponseEntity.ok(tempList);
		    	  
		      }
		      new ResourceNotFoundException("Could not get qouation for: Vehicle to the value of R"+vehicle_value+"" );
		      return null;
		  }
		}
