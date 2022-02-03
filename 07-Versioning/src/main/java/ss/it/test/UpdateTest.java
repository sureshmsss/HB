package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.CallerTune;
import ss.it.util.HBUtil;

public class UpdateTest {
	public static void main(String[] args) {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			// prepare object for entity class
			CallerTune tune = ses.get(CallerTune.class, 1);
			if (tune == null) {
				System.out.println("record not found");
				return;
			} else {
				// begin tx
				tx = ses.beginTransaction();
				tune.setMovieName("pushpa the rise");
				tune.setTuneName("ey bidda ");
				// save object
				ses.update(tune);

				// commit the transaction
				tx.commit();
				System.out.println("object is updated");
			}
		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not updated");
		} // catch

	}// main
}// class
