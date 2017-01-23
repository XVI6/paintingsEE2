package ee.paintings.projectEE2.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import ee.paintings.projectEE2.domain.Painting;

@XmlRootElement
public class PaintingResponse {
	
	private List<Painting> painting = new ArrayList<>();
	
	public List<Painting> getBook() {
		return painting;
	}
	
	public void setPainting(List<Painting> painting){
		this.painting = painting;
	}
}
