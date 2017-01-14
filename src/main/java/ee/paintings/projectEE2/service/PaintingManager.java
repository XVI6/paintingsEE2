package ee.paintings.projectEE2.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ee.paintings.projectEE2.domain.Painting;
import ee.paintings.projectEE2.domain.Reproductor;

@Stateless
public class PaintingManager 
{
	@PersistenceContext
	EntityManager em;
	
	/*
	public void addPainting(Painting p){
		
	}
	*/
	
	
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
}
