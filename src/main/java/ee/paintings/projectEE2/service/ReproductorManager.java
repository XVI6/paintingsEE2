package ee.paintings.projectEE2.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ee.paintings.projectEE2.domain.Painting;
import ee.paintings.projectEE2.domain.Reproductor;

@Stateless
@Path("reproductors")
public class ReproductorManager 
{
	@PersistenceContext
	EntityManager em;
	
	//???
	@POST
	@Path("/{reproductor}")
	@Produces("application/json")
	//???
	public void addPerson(Reproductor r) {
		r.setId(null);
		em.persist(r);
	}
	
	/*
	@GET
	@Path("/{reproductorId}")
	@Produces("application/json")
	public Reproductor getReproductor(@PathParam("reproductorId") Long id){
		Reproductor r = ;
		
		return r;
	}
	*/
	
	
	@SuppressWarnings("unchecked")
	public List<Reproductor> getAllReproductors() {
		return em.createNamedQuery("reproductor.select.all").getResultList();
	}
	
	
	public void deleteReproductor(Reproductor r) {
		em.find(Reproductor.class, r.getId());
		em.remove(r);
	}
	
	public List<Painting> getOwnedPaintings(Reproductor r) {
		
		r = em.find(Reproductor.class, r.getId());
		
		return new ArrayList<Painting>(r.getPaintings());
	}
	
	
	@GET
	@Path("/test")
	@Produces("text/html")
	public String test(){
		return "REST Service is running";
	}
	
}