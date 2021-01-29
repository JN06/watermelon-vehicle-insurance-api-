package waterlemon.api.insurance.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity 
@Table(name = "vehicle")
public class Vehicle {
	
	  
	public Vehicle() {
	
	}
	
	public Vehicle(int id, String vin, String brand, String name, String engineSize, String releaseYear, String qoutedPrice) {
	  super();
	  this.id = id;
	  this.vin = vin;
	  this.brand = brand;
	  this.engineSize =engineSize;
	  this.name = name;
	  this.releaseYear = releaseYear;
	  this.qoutedPrice = qoutedPrice;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name = "brand")
	private String brand;
	
	
	@Column(name = "vin")
	private String vin;
	
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "engineSize")
	private String engineSize;
	
	
	@Column(name = "releaseYear")
	private String releaseYear;
	
	
	@Column(name = "qoutedPrice")
	private String qoutedPrice;
	
	public String getQoutedPrice() {
		  return qoutedPrice;
		}
	

	public String getReleaseYear() {
	  return releaseYear;
	}

	public String getVin() {
	  return vin;
	}

	public String getBrand() {
		return brand;
	}

	@Override
	public String toString() {
		return "vehicle [vin=" + vin + ", brand=" + brand + ", name=" + name + ", engineSize=" + engineSize
				+ ", releaseYear=" + releaseYear + "]";
	}

	public String getName() {
		return name;
	}

	public String getEngineSize() {
		return engineSize;
	}
	
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
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @param vin the vin to set
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param engineSize the engineSize to set
	 */
	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}

	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	/**
	 * @param qoutedPrice the qoutedPrice to set
	 */
	public void setQoutedPrice(String qoutedPrice) {
		this.qoutedPrice = qoutedPrice;
	}

	
}
