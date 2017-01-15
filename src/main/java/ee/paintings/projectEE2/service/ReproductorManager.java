package ee.paintings.projectEE2.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import ee.paintings.projectEE2.domain.Painting;
import ee.paintings.projectEE2.domain.Reproductor;
import ee.paintings.projectEE2.domain.ReproductorStorageService;

@Stateless
@Path("reproductors")
public class ReproductorManager 
{
	
	@EJB
	ReproductorStorageService rss;
	
	@GET
	@Path("/test")
	@Produces("text/html")
	public String test(){
		return "REST Service is running";
	}
	
	/*
	private String name = "unknown";
	private String country = "unknown";
	private String city = "unknown";
	private String adress = "unknown";
	private String house_number = "unknown";
	private String telephone = "unknown";
	private String e_mail = "unknown";
	*/
	
	//C
	@PUT
	public Response addReproductor(
			@FormParam("name") String name,
			@FormParam("country") String country,
			@FormParam("city") String city,
			@FormParam("adress") String adress,
			@FormParam("house_number") String house_number,
			@FormParam("telephone") String telephone,
			@FormParam("e_mail") String e_mail
			){
		Reproductor r = new Reproductor();
		
		r.setName(name);
		r.setCountry(country);
		r.setCity(city);
		r.setAdress(adress);
		r.setHouse_number(house_number);
		r.setTelephone(telephone);
		r.setE_mail(e_mail);
		
		rss.addReproductor(r);
		
		return Response.status(Response.Status.CREATED).build();
		
	}
	
	@GET
	public Response getAllReproductors(){
		return Response.status(Response.Status.OK).entity(rss.getAllReproductors()).build();
	}
	
	@GET
	@Path("{id}")
	public Response getReproductor(@PathParam("id") Long id){
		Reproductor r = (Reproductor)em.createNamedQuery("reproductor.select.byId").getParameter(0);
		if (r == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}else {
			return Response.status(Response.Status.OK).build();
		}
		
	}
	
	
	
	/*
	 * 
	 * 
	@PersistenceContext
	EntityManager em;
	
	@GET
	@Path("{id}")
	public Reproductor getReproductor(@PathParam("id") Long id){
		Reproductor r = (Reproductor)em.createNamedQuery("reproductor.select.byId").getParameter(0);
		if (r == null) {
			return new Reproductor();
		}else {
			return r;
		}
	}
	
	@GET
	public Response getAllReproductors(){
		return Response.status(Response.Status.OK).entity(rm.getAllReproductors()).build();
	}
	
	@GET
	@Path("{id}")
	public Response getReproductor(@PathParam("id") Long id){
		Reproductor r = (Reproductor)em.createNamedQuery("reproductor.select.byId").getParameter(0);
		if (r == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}else {
			return Response.status(Response.Status.OK).build();
		}
		
	}
	
	 *
	 * 
	 * 
	public void addPerson(Reproductor r) {
		r.setId(null);
		em.persist(r);
	}
	
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
	
	*/
	
	
}