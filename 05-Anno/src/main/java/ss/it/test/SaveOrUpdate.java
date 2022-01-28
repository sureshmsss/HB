package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.Movie;
import ss.it.util.HBUtil;

public class SaveOrUpdate {
	public static void main(String[] args) {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			//begin tx
			tx = ses.beginTransaction();

			// prepare object for entity class
			Movie movie = new Movie(1, "aaia", "pspk", 2.0f);

			ses.save(movie);
			// commit the transaction
			tx.commit();
			System.out.println("object is saved");

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
		} // catch

	}// main
}// class
