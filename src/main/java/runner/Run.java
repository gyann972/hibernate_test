package runner;

import javax.persistence.EntityManager;

import dao.BookDAO;
import dao.ClientDAO;
import model.Book;
import model.Client;
import utils.DatabaseHelper;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = DatabaseHelper.createEntityManager();
		
		Book wnij8 = BookDAO.createBook("What's New in Java 8", "Adam L. Davis");
		Book toto = BookDAO.createBook("Life of a Prime Minister", "James Cameron");
		Client gY = ClientDAO.createClient("GREGO", "Yannis", 'M', wnij8);
		
		ClientDAO.updateClient(wnij8, gY);
		ClientDAO.updateClient(toto, gY);
		
		BookDAO.displayPurchasedBooksByClient(gY.getId());
		
	}

}
