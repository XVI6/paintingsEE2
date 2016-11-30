package java.ee.paintings.projectEE2.service;

import java.ee.paintings.projectEE2.domain.Location;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("locations")
public class LocationManager 
{
	private Map<Long, Location> locations = new HashMap<>();
	
	public LocationManager() 
	{
		// TODO Auto-generated constructor stub
		locations.put(1L, new Location("Poland", "Gdansk", "Museum"));
	}
	
	@GET
	@Path("/{idLocation}")
	@Produces("application/json")
	public Location getLocation(@PathParam("idLocation") Long id)
	{
		Location l = locations.get(id);
		
		if(l == null)
		{
			l = new Location();
		}
		
		return l;
	}
	
	@GET
	@Path("/test")
	@Produces("test/html")
	public String test(){
		return "TEST";
	}
}
