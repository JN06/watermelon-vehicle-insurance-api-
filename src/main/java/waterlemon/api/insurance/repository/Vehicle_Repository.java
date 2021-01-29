package waterlemon.api.insurance.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import waterlemon.api.insurance.models.Vehicle;


@Repository
public interface Vehicle_Repository extends JpaRepository<Vehicle, Long>{
	
}