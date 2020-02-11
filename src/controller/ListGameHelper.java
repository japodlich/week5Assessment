package controller;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListGame;

public class ListGameHelper 
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("week3Assessment");
	
	public void insertGame(ListGame lg)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lg);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListGame> showAllGames()
	{
		EntityManager em = emfactory.createEntityManager();
		List<ListGame> allGames = em.createQuery("SELECT i FROM ListGame i").getResultList();
		return allGames;
	}
	
	public void deleteGame(ListGame toDelete)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListGame> typedQuery = em.createQuery("select lg from ListGame lg where lg.type = :selectedType and lg.price = :selectedPrice",ListGame.class);
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedPrice", toDelete.getPrice());
		typedQuery.setMaxResults(1);
		ListGame result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ListGame searchForGameById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListGame found = em.find(ListGame.class, idToEdit);
		em.close();
		return found;
	}

	public void updateGame(ListGame toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

	public List<ListGame> searchForGameByType(String typeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListGame> typedQuery = em.createQuery("select lg from ListGame lg where lg.type =:selectedType", ListGame.class);
		typedQuery.setParameter("selectedType", typeName);
		List<ListGame> foundGames = (List<ListGame>) typedQuery.getSingleResult();
		//The issue is that foundGames is expecting to create an array of ListGames, 
		//but the method you used told it to only return a single result
		//Therefore, it tried to convert a single result into a list.  
		//Instead use: List<ListGame> foundGames = typedQuery.getResultList(); 
		em.close();
		return foundGames;
	}

	public List<ListGame> searchForGameByPrice(String priceName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListGame> typedQuery = em.createQuery("select lg from ListGame lg where lg.price =:selectedPrice", ListGame.class);
		typedQuery.setParameter("selectedPrice", priceName);
		List<ListGame> foundGames = typedQuery.getResultList();
		em.close();
		return foundGames;
	}
	
	public void cleanUp()
	{
		emfactory.close();
	}
	
	
}
