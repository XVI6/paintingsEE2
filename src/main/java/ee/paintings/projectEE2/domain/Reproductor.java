package ee.paintings.projectEE2.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "reproduktor.select.all", 
			query = "SELECT r FROM Reproductor r"),
	@NamedQuery(name = "reproduktor.select.byName", 
			query = "SELECT r FROM Reproductor r WHERE r.name = :name"),
	@NamedQuery(name = "reproduktor.select.byId", 
			query = "SELECT r FROM Reproductor r WHERE r.id = :id")
})
public class Reproductor {
	private Long id;
	
	private String name = "unknown";
	private String country = "unknown";
	private String city = "unknown";
	private String adress = "unknown";
	private String house_number = "unknown";
	private String telephone = "unknown";
	private String e_mail = "unknown";
	
	private List<Painting> paintings = new ArrayList<Painting>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getHouse_number() {
		return house_number;
	}

	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	@OneToMany(cascade = CascadeType.ALL)
	public List<Painting> getPaintings() {
		return paintings;
	}

	public void setPaintings(List<Painting> paintings) {
		this.paintings = paintings;
	}	
}