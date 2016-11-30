package java.ee.paintings.projectEE2.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Painting {
	
	private String name;
	private int yoc;
	protected String artist;
	protected String location;
	

	public Painting() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Painting(String name, int yoc, String artist, String location) {
		super();
		this.name = name;
		this.yoc = yoc;
		this.artist = artist;
		this.location = location;
	}

	
	
	
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
	
	
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String plase) {
		this.location = plase;
	}
	
	
}
