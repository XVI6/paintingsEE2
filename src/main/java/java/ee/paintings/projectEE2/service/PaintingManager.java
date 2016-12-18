package java.ee.paintings.projectEE2.service;

import java.ee.paintings.projectEE2.domain.Painting;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PaintingManager 
{
	@PersistenceContext
	EntityManager em;
	
	public void addPainting(Painting p){
		
	}
	
}
