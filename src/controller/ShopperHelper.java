package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.GameShopper;

public class ShopperHelper 
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GameShoppingLists");
	
	public void insertShopper(GameShopper gs)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(gs);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<GameShopper> showAllShoppers()
	{
		EntityManager em = emfactory.createEntityManager();
		List<GameShopper> allShoppers = em.createQuery("SELECT gs FROM GameShopper gs").getResultList();
		return allShoppers;
	}
	
}
