package ee.paintings.projectEE2.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ee.paintings.projectEE2.api.PaintingStorageService;
import ee.paintings.projectEE2.api.ReproductorStorageService;
import ee.paintings.projectEE2.domain.Reproductor;

@Stateless
@Path("/reproductor")
public class ReproductorManager 
{
	
	@EJB
	ReproductorStorageService rss;
	@EJB
	PaintingStorageService pss;
	
	//TEST
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "REST Service is running";
	}
	
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
		
                try {
                    rss.addReproductor(r);
                } catch (Exception e) {
                    return Response.status(Response.Status.NOT_ACCEPTABLE).build();
                }
		
		return Response.status(Response.Status.CREATED).build();
		
	}
	
	//R
	@GET
    @Path("/{reproductorId}")
	//@Produces("application/json")
        public Response getReproductor(
    		@PathParam("reproductorId") Long id) {
		
		Reproductor r = rss.getReproductor(id);

        if (r == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return Response.ok(r, MediaType.APPLICATION_JSON).build();        
	}
	
	@GET
	@Path("/")
        public Response getAllReproductors() {
        return Response.status(Response.Status.OK).
        		entity(rss.getAllReproductors()).build();
	}
	
	
	//U
	@POST
        @Path("/{reproductorId}")
        public Response updateReproductor(
                        @PathParam("reproductorId") Long id,
                        @FormParam("name") String name,
			@FormParam("country") String country,
			@FormParam("city") String city,
			@FormParam("adress") String adress,
			@FormParam("house_number") String house_number,
			@FormParam("telephone") String telephone,
			@FormParam("e_mail") String e_mail) {
        
            Reproductor r;
            try {
                r = rss.getReproductor(id);
            } catch (Exception e) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        

        if (r == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        r.setName(name);
        r.setCountry(country);
        r.setCity(city);
        r.setAdress(adress);
        r.setHouse_number(house_number);
        r.setTelephone(telephone);
        r.setE_mail(e_mail);

        rss.updateReproductor(r);

        return Response.status(Response.Status.OK).build();
	}
	
	//D
	@DELETE
    @Path("/{reproductorId}")
    public Response deleteReproductor(
    		@PathParam("reproductorId") Long id) {
		Reproductor r = rss.getReproductor(id);

        if (r == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        rss.deleteReproductor(r);
        
        return Response.status(Response.Status.OK).build();
	}
	
}