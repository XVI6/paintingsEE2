package java.ee.paintings.projectEE2.service;

import java.ee.paintings.projectEE2.domain.Reproductor;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("reproductors")
public class ReproductorManager 
{
	
	private Map<Long, Reproductor> reproductors = new HashMap<>();
	
	public ReproductorManager() 
	{
		// TODO Auto-generated constructor stub
		reproductors.put(1L, new Reproductor("Nazwa", "Poland", "Gdansk", "Nowa", "25/4", "8464538421681", "repr@mail.com"));
	}
	
	
	@GET
	@Path("/{idReproductor}")
	@Produces("application/json")
	public Reproductor getReproductor(@PathParam("idReproductor") Long id)
	{
		Reproductor r = reproductors.get(id);
		
		if (r == null) 
		{
			r = new Reproductor();
		}
		
		return r;
	}
	
	
	@GET
	@Path("/test")
	@Produces("test/html")
	public String test()
	{
		return "TEST";
	}

}
