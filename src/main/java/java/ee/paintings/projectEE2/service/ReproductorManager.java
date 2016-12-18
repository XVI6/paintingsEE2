package java.ee.paintings.projectEE2.service;

import java.ee.paintings.projectEE2.domain.Painting;
import java.ee.paintings.projectEE2.domain.Reproductor;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ReproductorManager 
{
	@PersistenceContext
	EntityManager em;
	
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
	
	public List<Painting> getPaintings(Reproductor r) {
		
		r = em.find(Reproductor.class, r.getId());
		
		return new ArrayList<>(r.getPaintings());
	}
	
}