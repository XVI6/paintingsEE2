package ee.paintings.projectEE2.web;

import java.io.Serializable;

//@SessionScoped
//@Named("reproductorBean")
public class ReproductorFormBean implements Serializable{
	/*
	private static final long serialVersionUID = 1L;
	
	private Reproductor reproductor = new Reproductor();
	private ListDataModel<Reproductor> reproductors = new ListDataModel<Reproductor>();
	
	private Reproductor reproductor2 = new Reproductor();
	private ListDataModel<Painting> ownPaintings = new ListDataModel<Painting>();
	
	
	@Inject
	private ReproductorManager rm;
	
	@Inject
	private PaintingManager pm;
	
	public Reproductor getReproductor(){
		return reproductor;
	}
	
	public void setReproductor(Reproductor reproductor){
		this.reproductor = reproductor;
	}
	
	public ListDataModel<Reproductor> getAllReproductors(){
		reproductors.setWrappedData(rm.getAllReproductors());
		return reproductors;
	}
	
	public ListDataModel<Painting> getOwnPaintings(){
		ownPaintings.setWrappedData(rm.getOwnedPaintings(reproductor2));
		return ownPaintings;
	}
	
	//A
	public String addReproductor(){
		rm.addPerson(reproductor);
		return "showReproductor";
	}
	
	public String deleteReproductor(){
		Reproductor delReproductor = reproductors.getRowData();
		rm.deleteReproductor(delReproductor);
		return "details";
	}
	
	public String showDetails(){
		reproductor2 = reproductors.getRowData();
		return "details";
	}
	
	public String ownPaintings(){
		Painting p = ownPaintings.getRowData();
		//sm.disposeCar(personToShow, carToDispose);
		pm.deletePainting(reproductor2, p);
		return null;
	}
	*/
}
