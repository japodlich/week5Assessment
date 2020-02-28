package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;

public class ListDetailsHelper 
{
	static EntityManagerFactory emfactory = Persistence. createEntityManagerFactory ("GameShoppingLists"); 
	
	public void insertNewListDetails(ListDetails s) 
	{   
		EntityManager em = emfactory .createEntityManager();   
		em.getTransaction().begin();   
		em.persist(s);   
		em.getTransaction().commit();   
		em.close();
	}
	
	
	public List<ListDetails> getLists() 
	{   
		EntityManager em = emfactory .createEntityManager();   
		List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();   
		return allDetails;  
	}
	
	public void deleteListDetails(ListDetails s) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDetails> typedQuery = em.createQuery("select d from ListDetails d where d.id = :selectedid",ListDetails.class);
		typedQuery.setParameter("selectedid", s.getId());
		typedQuery.setMaxResults(1);
		ListDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public ListDetails searchForGameById(Integer tempId) {

		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListDetails found = em.find(ListDetails.class, tempId);
		em.close();
		return found;
	}
	
}
