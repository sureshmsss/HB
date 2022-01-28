package ss.it.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ss.it.entity.Product;

public class DELETE {
	public static void main(String[] args) {
		System.out.println("===full Object Updation===");
		// create configuration object
		Configuration cfg = new Configuration();
		cfg.configure("ss/it/cfgs/hibernate.cfg.xml");
		// create build session factory
		SessionFactory factory = cfg.buildSessionFactory();

		// create session object
		Session ses = factory.openSession();

		Transaction tx = null;
		try (factory; ses) {
			// begin transaction
			tx = ses.beginTransaction();
			// load object using get(-) method
			Product prod = new Product();
			prod.setPid(2);
			ses.delete(prod);

			// commit the transaction
			tx.commit();
			System.out.println("Object is deleted");
		} // try
		catch (Exception e) {
			if (tx != null && tx.getStatus() != null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("object is not updated");
			}
			e.printStackTrace();
		} // catch

	}// main
}// class
