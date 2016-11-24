package java.ee.paintings.projectEE2.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Reproductor {
	
	private String name;
	private String country;
	private String city;
	private String adress;
	private String house_number;
	private String telephone;
	private String e_mail;
	
	public Reproductor() {
		super();
	}
	
	public Reproductor(String name, String country, String city, String adress, String house_number, String telephone, String e_mail){
		super();
		this.name = name;
		this.country = country;
		this.city = city;
		this.adress = adress;
		this.house_number = house_number;
		this.telephone = telephone;
		this.e_mail = e_mail;
	}
	

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
	
	
}
