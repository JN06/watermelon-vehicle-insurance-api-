package waterlemon.api.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import waterlemon.api.insurance.models.DieselPricing;


@Repository
public interface DieselPricing_Repository extends JpaRepository<DieselPricing, Long>{
	
}
