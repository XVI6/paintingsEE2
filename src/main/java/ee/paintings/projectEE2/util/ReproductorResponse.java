package ee.paintings.projectEE2.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import ee.paintings.projectEE2.domain.Reproductor;

@XmlRootElement
public class ReproductorResponse {
	
	private List<Reproductor> reproductor = new ArrayList<>();
	
	public List<Reproductor> getBook() {
		return reproductor;
	}
	
	public void setPainting(List<Reproductor> painting){
		this.reproductor = painting;
	}
}
