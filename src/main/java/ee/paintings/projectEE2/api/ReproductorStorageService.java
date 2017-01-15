package ee.paintings.projectEE2.api;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ee.paintings.projectEE2.domain.Painting;
import ee.paintings.projectEE2.domain.Reproductor;

@Stateless
public class ReproductorStorageService {
	
	@PersistenceContext
	EntityManager em;
	
	//C
	public void addReproductor(Reproductor r) {
		r.setId(null);
		em.persist(r);
	}
	
	//R
	public Reproductor getReproductor(Long id){
		return (Reproductor)em.createNamedQuery("reproductor.select.byId").
				setParameter("id", id).
				getResultList().get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Reproductor> getAllReproductors() {
		return em.createNamedQuery("reproductor.select.all").getResultList();
	}
	
	//U
	public void updateReproductor(Reproductor r){
		em.find(Reproductor.class, r.getId());
		em.merge(r);
	}
	
	//D
	public void deleteReproductor(Reproductor r) {
		em.find(Reproductor.class, r.getId());
		em.remove(r);
	}
	
	
	//Others
	public List<Painting> getOwnedPaintings(Reproductor r) {
		
		r = em.find(Reproductor.class, r.getId());
		
		return new ArrayList<Painting>(r.getPaintings());
	}
	
}
