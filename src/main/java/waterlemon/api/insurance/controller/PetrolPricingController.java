package waterlemon.api.insurance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;
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
import waterlemon.api.insurance.models.PetrolPricing;
import waterlemon.api.insurance.models.PetrolPricingString;
import waterlemon.api.insurance.models.Vehicle;
import waterlemon.api.insurance.repository.PetrolPricing_Repository;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "https://wattermelon-website.herokuapp.com")
public class PetrolPricingController {

	  @Autowired
	  private PetrolPricing_Repository petrolPricing_repository;
	  
	  @GetMapping("/ppricing/get_all")
	  public List<PetrolPricing> getAllQoutes(){
		  return petrolPricing_repository.findAll();
	  }
	  @GetMapping("/ppricing/get_all_as_string")
	  public List<PetrolPricingString> getAllQoutesString(){
		  List<PetrolPricingString> list = new ArrayList();
		  List<PetrolPricing> cur = getAllQoutes();
				  for(PetrolPricing e : cur) {
					  PetrolPricingString tempObj = new PetrolPricingString();
					  tempObj.setId(e.getId());
					  tempObj.setCar_value_range(e.getCar_value_range().toString());
					  tempObj.setAvg_dealer_2yr_30000kms(e.getAvg_dealer_2yr_30000kms().toString());
					  tempObj.setAvg_dealer_2yr_40000kms(e.getAvg_dealer_2yr_40000kms().toString());
					  tempObj.setAvg_dealer_2yr_45000kms(e.getAvg_dealer_2yr_45000kms().toString());
					  tempObj.setAvg_dealer_2yr_60000kms(e.getAvg_dealer_2yr_60000kms().toString());
					  tempObj.setAvg_rmi_2yr_30000kms(e.getAvg_rmi_2yr_30000kms().toString());
					  tempObj.setAvg_rmi_2yr_40000kms(e.getAvg_rmi_2yr_40000kms().toString());
					  tempObj.setAvg_rmi_2yr_45000kms(e.getAvg_rmi_2yr_45000kms().toString());
					  tempObj.setAvg_rmi_2yr_60000kms(e.getAvg_rmi_2yr_60000kms().toString());
					  list.add(tempObj);
				  }
		  return list;
	  }
	  
	  @CrossOrigin(origins = "http://localhost:4200")
	  @GetMapping("/ppricing/get_specific/{vehicle_value}/{term}")
	  public ResponseEntity<List<PetrolPricing>> getSpecificPricing(@PathVariable String vehicle_value, 
			  @PathVariable String term) {
		  
		  PetrolPricing petrolPricing = new PetrolPricing(0, "99999", 385.00, 495.00, 388.00, 581.00, 299.00, 384.00, 301.00, 451.00);
	      Example<PetrolPricing> petrolPricingExample = Example.of(petrolPricing);
	      //calling QueryByExampleExecutor#findAll(Example)
	      Iterable<PetrolPricing> qoutation = petrolPricing_repository.findAll(petrolPricingExample);
	      if(!qoutation.iterator().hasNext()) {
	    	  qoutation = getAllQoutes();
	      }
	      List<PetrolPricing> tempList = new ArrayList<PetrolPricing>();
	      for (PetrolPricing e : qoutation) {
	    	  String[] range = e.getCar_value_range().split("-");
	    	  if((Double.parseDouble(vehicle_value) >= Double.parseDouble(range[0])) && 
	    			  (Double.parseDouble(vehicle_value) <= Double.parseDouble(range[1]))) {
	    		  String[] terms =  vehicle_value.split("yr_"); 
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
	  @GetMapping("/ppricing/get_by_value/{vehicle_value}")
	  public ResponseEntity<List<PetrolPricing>> getPricingByVehicleValue(@PathVariable String vehicle_value) {
		  
		  PetrolPricing petrolPricing = new PetrolPricing(0, "99999", 385.00, 495.00, 388.00, 581.00, 299.00, 384.00, 301.00, 451.00);
	      Example<PetrolPricing> petrolPricingExample = Example.of(petrolPricing);
	      //calling QueryByExampleExecutor#findAll(Example)
	      Iterable<PetrolPricing> qoutation = petrolPricing_repository.findAll(petrolPricingExample);
	      if(!qoutation.iterator().hasNext()) {
	    	  qoutation = getAllQoutes();
	      }
	      List<PetrolPricing> tempList = new ArrayList<PetrolPricing>();
	      for (PetrolPricing e : qoutation) {
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
