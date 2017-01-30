package ee.paintings.projectEE2.service;

import java.util.List;

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
import ee.paintings.projectEE2.domain.Painting;


@Stateless
@Path("/painting")
public class PaintingManager 
{
	
	@EJB
	PaintingStorageService pss;
	
	//C
	@PUT
	@Path("/{rId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPainting(@PathParam("rId") Long rId, Painting p){
		
        try {
            pss.addPainting(rId, p);
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
		
		return Response.status(Response.Status.CREATED).build();
	}
	
	
	//R
	@GET
    @Path("/{paintingId}")
//	@Produces("application/json")
        public Painting getPainting(
    		@PathParam("paintingId") Long id) {
		
		Painting p = pss.getPainting(id);

        if (p == null) {
            return new Painting();
        }
        
        return p;        
	}
	
	@GET
	@Path("/")
//	@Produces("application/json")
        public List<Painting> getAllPaintings() {
            return pss.getAllPainting();
	}
	
	
	//U
	@POST
	@Path("/{paintingId}")
	public Response updatePainting(Painting p){
		
		if (p == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        else {
        	try {
        		pss.updatePainting(p);;					
        		return Response.status(Response.Status.OK).build();				
			} catch (Exception e) {
				// TODO: handle exception
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
		}
	}
	
	//D
	@DELETE
	@Path("/{paintingId}")
	public Response deletePainting(
			@PathParam("paintingId") Long id){
		
		Painting p = null;
		
		try {
			p = pss.getPainting(id);
			pss.deletePainting(p);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_FOUND).build();
		}
        
        return Response.status(Response.Status.OK).build();
	}
	
	/*
	@PersistenceContext
	EntityManager em;
		
	public void addPainting(Long reproductorId, Long paintingId){
		
		Reproductor r = em.find(Reproductor.class, reproductorId);
		Painting p = em.find(Painting.class, paintingId);
		
		r.getPaintings().add(p);
	}
	
	public void deletePainting(Reproductor r, Painting p){
		
		r = em.find(Reproductor.class, r.getId());
		p = em.find(Painting.class, p.getId());
		
		Painting delPainting = null;
		
		for (Painting allP : r.getPaintings()) {
			if (allP.getId().compareTo(p.getId()) == 0) {
				delPainting = allP;
				break;
			}
		}
		
		if (delPainting != null) {
			r.getPaintings().remove(delPainting);
		}
	}
	*/
}
