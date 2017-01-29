package ee.paintings.projectEE2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
	@NamedQuery(name = "painting.select.all", 
			query = "SELECT p FROM Painting p"),
	@NamedQuery(name = "painting.select.byName",
			query = "SELECT p FROM Painting p WHERE p.name = :name"),
	@NamedQuery(name = "painting.select.byId",
			query = "SELECT p FROM Painting p WHERE p.id = :id")
})
@XmlRootElement
public class Painting {
	
	private Long id;
	
	private String name;
	private int yoc;
	private int cost;
	private String artist;
	
	private Reproductor reproductor;
	
	
	public Painting() {
		// TODO Auto-generated constructor stub
	}
	
	public Painting(String name, int yoc, int cost, String artist) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.yoc = yoc;
		this.cost = cost;
		this.artist = artist;
	}
	
	public Painting(Long id, String name, int yoc, int cost, String artist) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.yoc = yoc;
		this.cost = cost;
		this.artist = artist;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2)
	@Column(unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYoc() {
		return yoc;
	}

	public void setYoc(int yoc) {
		this.yoc = yoc;
	}
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Reproductor getReproductor() {
		return reproductor;
	}

	public void setReproductor(Reproductor reproductor) {
		this.reproductor = reproductor;
	}
}