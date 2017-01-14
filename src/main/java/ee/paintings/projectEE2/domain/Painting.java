package ee.paintings.projectEE2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
	@NamedQuery(name = "painting.select.all", 
			query = "SELECT p FROM Painting p"),
	@NamedQuery(name = "painting.select.byName",
			query = "SELECT p FROM Painting p WHERE p.name = :name"),
	@NamedQuery(name = "painting.select.byId",
			query = "SELECT p FROM Painting p WHERE p.id = :id")
})
public class Painting {
	
	private Long id;
	
	private String name = "unknown";
	private int yoc = 0;
	private int cost = 0;
	private String artist = "unknown";
	private String origin_artist = "unknown";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
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
	
	public String getOrigin_artist() {
		return origin_artist;
	}

	public void setOrigin_artist(String origin_artist) {
		this.origin_artist = origin_artist;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}