package java.ee.paintings.projectEE2.domain;

public class Location {
	
	private String country;
	private String city;
	private String plase;
	
	public Location() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Location(String country, String city, String plase) {
		super();
		this.country = country;
		this.city = city;
		this.plase = plase;
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
