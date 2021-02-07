package waterlemon.api.insurance.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity 
@Table(name = "petrol_pricing")
public class PetrolPricing {


	public PetrolPricing() {
	
	}
	
	public PetrolPricing(int id, String car_value_range, double Avg_dealer_2yr_30000kms, 
			double Avg_dealer_2yr_40000kms, double Avg_dealer_2yr_45000kms,
			double Avg_dealer_2yr_60000kms, double Avg_rmi_2yr_30000kms,
			double Avg_rmi_2yr_40000kms, double Avg_rmi_2yr_45000kms, double Avg_rmi_2yr_60000kms) {
	  
		super();
		this.car_value_range = car_value_range;
		this.Avg_dealer_2yr_30000kms = Avg_dealer_2yr_30000kms;
		this.Avg_dealer_2yr_40000kms = Avg_dealer_2yr_40000kms;
		this.Avg_dealer_2yr_45000kms = Avg_dealer_2yr_45000kms;
		this.Avg_dealer_2yr_60000kms = Avg_dealer_2yr_60000kms;
		this.Avg_rmi_2yr_30000kms = Avg_rmi_2yr_30000kms;
		this.Avg_rmi_2yr_40000kms = Avg_rmi_2yr_40000kms;
		this.Avg_rmi_2yr_45000kms = Avg_rmi_2yr_45000kms;
		this.Avg_rmi_2yr_60000kms = Avg_rmi_2yr_60000kms;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name = "car_value_range")
	private String car_value_range;
	
	
	@Column(name = "Avg_dealer_2yr_30000kms")
	private Double Avg_dealer_2yr_30000kms;
	
	
	@Column(name = "Avg_dealer_2yr_40000kms")
	private Double Avg_dealer_2yr_40000kms;
	
	
	@Column(name = "Avg_dealer_2yr_45000kms")
	private Double Avg_dealer_2yr_45000kms;
	
	
	@Column(name = "Avg_dealer_2yr_60000kms")
	private Double Avg_dealer_2yr_60000kms;
	
	
	@Column(name = "Avg_rmi_2yr_30000kms")
	private Double Avg_rmi_2yr_30000kms;
	
	
	@Column(name = "Avg_rmi_2yr_40000kms")
	private Double Avg_rmi_2yr_40000kms;
	
	
	@Column(name = "Avg_rmi_2yr_45000kms")
	private Double Avg_rmi_2yr_45000kms;
	
	
	@Column(name = "Avg_rmi_2yr_60000kms")
	private Double Avg_rmi_2yr_60000kms;


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the car_value_range
	 */
	public String getCar_value_range() {
		return car_value_range;
	}

	/**
	 * @param car_value_range the car_value_range to set
	 */
	public void setCar_value_range(String car_value_range) {
		this.car_value_range = car_value_range;
	}

	/**
	 * @return the avg_dealer_2yr_30000kms
	 */
	public Double getAvg_dealer_2yr_30000kms() {
		return Avg_dealer_2yr_30000kms;
	}

	/**
	 * @param avg_dealer_2yr_30000kms the avg_dealer_2yr_30000kms to set
	 */
	public void setAvg_dealer_2yr_30000kms(Double avg_dealer_2yr_30000kms) {
		Avg_dealer_2yr_30000kms = avg_dealer_2yr_30000kms;
	}

	/**
	 * @return the avg_dealer_2yr_40000kms
	 */
	public Double getAvg_dealer_2yr_40000kms() {
		return Avg_dealer_2yr_40000kms;
	}

	/**
	 * @param avg_dealer_2yr_40000kms the avg_dealer_2yr_40000kms to set
	 */
	public void setAvg_dealer_2yr_40000kms(Double avg_dealer_2yr_40000kms) {
		Avg_dealer_2yr_40000kms = avg_dealer_2yr_40000kms;
	}

	/**
	 * @return the avg_dealer_2yr_45000kms
	 */
	public Double getAvg_dealer_2yr_45000kms() {
		return Avg_dealer_2yr_45000kms;
	}

	/**
	 * @param avg_dealer_2yr_45000kms the avg_dealer_2yr_45000kms to set
	 */
	public void setAvg_dealer_2yr_45000kms(Double avg_dealer_2yr_45000kms) {
		Avg_dealer_2yr_45000kms = avg_dealer_2yr_45000kms;
	}

	/**
	 * @return the avg_dealer_2yr_60000kms
	 */
	public Double getAvg_dealer_2yr_60000kms() {
		return Avg_dealer_2yr_60000kms;
	}

	/**
	 * @param avg_dealer_2yr_60000kms the avg_dealer_2yr_60000kms to set
	 */
	public void setAvg_dealer_2yr_60000kms(Double avg_dealer_2yr_60000kms) {
		Avg_dealer_2yr_60000kms = avg_dealer_2yr_60000kms;
	}

	/**
	 * @return the avg_rmi_2yr_30000kms
	 */
	public Double getAvg_rmi_2yr_30000kms() {
		return Avg_rmi_2yr_30000kms;
	}

	/**
	 * @param avg_rmi_2yr_30000kms the avg_rmi_2yr_30000kms to set
	 */
	public void setAvg_rmi_2yr_30000kms(Double avg_rmi_2yr_30000kms) {
		Avg_rmi_2yr_30000kms = avg_rmi_2yr_30000kms;
	}

	/**
	 * @return the avg_rmi_2yr_40000kms
	 */
	public Double getAvg_rmi_2yr_40000kms() {
		return Avg_rmi_2yr_40000kms;
	}

	/**
	 * @param avg_rmi_2yr_40000kms the avg_rmi_2yr_40000kms to set
	 */
	public void setAvg_rmi_2yr_40000kms(Double avg_rmi_2yr_40000kms) {
		Avg_rmi_2yr_40000kms = avg_rmi_2yr_40000kms;
	}

	/**
	 * @return the avg_rmi_2yr_45000kms
	 */
	public Double getAvg_rmi_2yr_45000kms() {
		return Avg_rmi_2yr_45000kms;
	}

	/**
	 * @param avg_rmi_2yr_45000kms the avg_rmi_2yr_45000kms to set
	 */
	public void setAvg_rmi_2yr_45000kms(Double avg_rmi_2yr_45000kms) {
		Avg_rmi_2yr_45000kms = avg_rmi_2yr_45000kms;
	}

	/**
	 * @return the avg_rmi_2yr_60000kms
	 */
	public Double getAvg_rmi_2yr_60000kms() {
		return Avg_rmi_2yr_60000kms;
	}

	/**
	 * @param avg_rmi_2yr_60000kms the avg_rmi_2yr_60000kms to set
	 */
	public void setAvg_rmi_2yr_60000kms(Double avg_rmi_2yr_60000kms) {
		Avg_rmi_2yr_60000kms = avg_rmi_2yr_60000kms;
	}
	
	
}