package dao;

import javax.persistence.EntityManager;

import model.Book;
import model.Client;
import utils.DatabaseHelper;

public class ClientDAO {
	
	public static Client createClient(String name, String firstname, char gender) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		Client client = new Client(name, firstname, gender);

		em.persist(client);
		DatabaseHelper.commitTxAndClose(em);
		
		return client;
	}
	
	public static Client createClient(String name, String firstname, char gender, Book favouriteBook) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		Client client = new Client(name, firstname, gender, favouriteBook);

		em.persist(client);
		DatabaseHelper.commitTxAndClose(em);
		
		return client;
	}
	
	public static void updateClient(Book purchase, Client client) {
		client.getPurchasedBooks().add(purchase);
		
		EntityManager em = DatabaseHelper.createEntityManager();
		
		DatabaseHelper.beginTx(em);
		em.merge(client);
		DatabaseHelper.commitTxAndClose(em);
	}
	
}
