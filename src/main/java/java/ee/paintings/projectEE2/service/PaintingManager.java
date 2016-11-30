package java.ee.paintings.projectEE2.service;

import java.ee.paintings.projectEE2.domain.Painting;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("paintings")
public class PaintingManager 
{
	
	private Map<Long, Painting> paintings = new HashMap<>();
	
	public PaintingManager() 
	{
		// TODO Auto-generated constructor stub
		paintings.put(1L, new Painting("Nazwa", 1852, "anknown", "Museum"));
	}
	
	@GET
	@Path("/{idPainting}")
	@Produces("application/json")
	public Painting getReproductor(@PathParam("idPainting") Long id)
	{
		Painting p = paintings.get(id);
		
		if(p == null)
		{
			p = new Painting();
		}
		
		return p;
	}
	
	
	@GET
	@Path("/test")
	@Produces("test/html")
	public String test(){
		return "TEST";
	}

}
