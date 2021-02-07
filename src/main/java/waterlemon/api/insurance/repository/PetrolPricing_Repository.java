package waterlemon.api.insurance.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import waterlemon.api.insurance.models.PetrolPricing;


@Repository
public interface PetrolPricing_Repository extends JpaRepository<PetrolPricing, Long>{
	
}

