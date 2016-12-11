package java.ee.paintings.projectEE2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;

@Entity
@NamedNativeQueries({
	
})
public class Location {
	
	private Long id;
	
	private String country;
	private String city;
	private String plase;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPlase() {
		return plase;
	}
	public void setPlase(String plase) {
		this.plase = plase;
	}
	
	
	
}
