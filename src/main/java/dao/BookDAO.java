package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.google.common.base.Joiner;
import model.Book;
import utils.DatabaseHelper;

public class BookDAO {
	
	public static Book createBook(String title, String author) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		Book book = new Book(title, author);

		em.persist(book);
		DatabaseHelper.commitTxAndClose(em);
		
		return book;
	}
	
	private static String getPurchaseBook(Long id) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Book> query = em.createQuery(
				"select b " +
				"from Book b " +
				"inner join b.buyers buy " +
				"where buy.id =:id ", Book.class);
		query.setParameter("id", id);
		ArrayList<Book> books = (ArrayList<Book>) query.getResultList();
		
		String booksString = "The books purchased by client " + id + " :" + Joiner.on(" | ").join(books);
		
		return booksString;
	}
	
	public static void displayPurchasedBooksByClient(Long id) {
		System.out.println(getPurchaseBook(id));
	}
}

