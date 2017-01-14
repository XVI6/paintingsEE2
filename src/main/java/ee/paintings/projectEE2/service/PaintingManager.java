package ee.paintings.projectEE2.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ee.paintings.projectEE2.domain.Painting;

@Stateless
public class PaintingManager 
{
	@PersistenceContext
	EntityManager em;
	
	public void addPainting(Painting p){
		
	}
	
}
