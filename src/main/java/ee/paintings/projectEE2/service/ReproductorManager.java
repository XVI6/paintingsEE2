package ee.paintings.projectEE2.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import ee.paintings.projectEE2.domain.Painting;
import ee.paintings.projectEE2.domain.Reproductor;

@Stateless
@Path("/reproductor")
public class ReproductorManager 
{
	
	@EJB
	ReproductorStorageService rss;
	@EJB
	PaintingStorageService pss;

	//C
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response addReproductor(Reproductor r){		
            try {
                rss.addReproductor(r);
            } catch (Exception e) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
		
		return Response.status(Response.Status.CREATED).build();
	}
	
	
	//R
	@GET
    @Path("/{reproductorId}")
	//@Produces(MediaType.APPLICATION_JSON)
        public Response getReproductor(
    		@PathParam("reproductorId") Long id) {
		
		Reproductor r = null;
		
		try {
			 r = rss.getReproductor(id);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
    	return Response.ok(r, MediaType.APPLICATION_JSON).build();        
	}
	

	@GET
    @Path("/byName/{reproductorName}")
	//@Produces(MediaType.APPLICATION_JSON)
        public Response getReproductorByName(
    		@PathParam("reproductorName") String name) {
		
		Reproductor r = null;
		
		try {
			 r = rss.getReproductorByName(name);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
    	return Response.ok(r, MediaType.APPLICATION_JSON).build();        
	}
	
	@GET
	@Path("/")
	//@Produces(MediaType.APPLICATION_JSON)
        public Response getAllReproductors() {
		
		List<Reproductor> reproductors = null;
		
		try {
			reproductors = rss.getAllReproductors();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (reproductors.isEmpty()) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		else {
			return Response.ok(reproductors, MediaType.APPLICATION_JSON).build();
		}
		
	}
	
	//U
	@POST
    @Path("/{reproductorId}")
    public Response updateReproductor(Reproductor r) {

        if (r == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        else {
        	try {
        		rss.updateReproductor(r);					
        		return Response.status(Response.Status.OK).build();				
			} catch (Exception e) {
				// TODO: handle exception
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
		}
	}
	
	//D
	@DELETE
    @Path("/{reproductorId}")
    public Response deleteReproductor(
    		@PathParam("reproductorId") Long id) {
		Reproductor r ;
		
		try {
			r = rss.getReproductor(id);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_FOUND).build();
		}

        rss.deleteReproductor(r);
        return Response.status(Response.Status.OK).build();
	} 
	
	@GET
	@Path("/{reproductorId}/paintings")
	//@Produces(MediaType.APPLICATION_JSON)
        public Response getAllPaintings(
        		@PathParam("reproductorId") Long id) {
		Reproductor r;
		try {
			r = rss.getReproductor(id);			
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
        
		List<Painting> paintings = rss.getOwnedPaintings(r);
		
		if (paintings.isEmpty()) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		else {
			return Response.ok(paintings, MediaType.APPLICATION_JSON).build();
		}
		
	}
}