package ee.paintings.projectEE2.domain;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PaintingStorageService {
	
	@PersistenceContext
	EntityManager em;
	
	//C
	public void addPainting(Long reproductorId, Long paintingId){
		
		Reproductor r = em.find(Reproductor.class, reproductorId);
		Painting p = em.find(Painting.class, paintingId);
		
		r.getPaintings().add(p);
	}
	
	//R
	public Painting getPainting(Long id){
		return (Painting) em.createNamedQuery("painting.select.byId").
				setParameter("id", id).
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
