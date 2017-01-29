package ee.paintings.projectEE2.api;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ee.paintings.projectEE2.domain.Painting;
import ee.paintings.projectEE2.domain.Reproductor;

@Stateless
public class PaintingStorageService {
	
	@PersistenceContext
	EntityManager em;
	
	//C
	public void addPainting(Long rId, Painting p){
		
		p.setId(null);
		em.persist(p);
		em.flush();
		
		p = getPainting(p.getName());
		
		Reproductor r = em.find(Reproductor.class, rId);
		//Painting p = em.find(Painting.class, paintingId);
		
		//r.getPaintings().add(p);
		//em.merge(r);
		p.setReproductor(r);
		em.merge(p);
	}
	
	//R
	public Painting getPainting(Long id){
		return (Painting) em.createNamedQuery("painting.select.byId").
				setParameter("id", id).
				getResultList().get(0);
	}
	
	public Painting getPainting(String name){
		return (Painting) em.createNamedQuery("painting.select.byName").
				setParameter("name", name).
				getResultList().get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Painting> getAllPainting(){
		return em.createNamedQuery("painting.select.all").getResultList();
	}
	
	//U
	public void updatePainting(Painting p){
		em.find(Painting.class, p.getId());
		em.merge(p);
	}
	
	//D
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
	
}
