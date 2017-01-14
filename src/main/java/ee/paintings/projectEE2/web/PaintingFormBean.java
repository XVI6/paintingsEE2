package ee.paintings.projectEE2.web;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ee.paintings.projectEE2.domain.Painting;
import ee.paintings.projectEE2.domain.Reproductor;
import ee.paintings.projectEE2.service.PaintingManager;
import ee.paintings.projectEE2.service.ReproductorManager;

@SessionScoped
@Named("paintingBean")
public class PaintingFormBean {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ReproductorManager rm;
	
	@Inject
	private PaintingManager pm;
	
	private Long reproductorId;
	private Long paintingId;
	
	
	public Long getPaintingId(){
		return paintingId;
	}
	
	public void setPaintingId(Long paintingId){
		this.paintingId = paintingId;
	}
	
	public Long getReproductorId() {
		return reproductorId;
	}
	
	public void setReproductorId(Long reproductorId) {
		this.reproductorId = reproductorId;
	}

	public List<Reproductor> getAllPersons() {
		return rm.getAllReproductors();
	}

	public String addPainting() {
		pm.addPainting(reproductorId, paintingId);
		return null;
	}
}
