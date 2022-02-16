package ss.it.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ss.it.entity.Product;

public class Save {
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
			for (int i = 0; i <= 5; ++i) {
				// begin transaction
				tx = ses.beginTransaction();

				// prepare object for entity class
				Product prod = new Product();
				prod.setPname("a");
				prod.setPrice(54251);
				prod.setQty(5f);
				ses.save(prod);
				// save object
				ses.save(prod);

				// commit the transaction
				tx.commit();
				System.out.println("object is saved" + prod.getPid());
			}
		} // try

		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} // catch

	}// main
}// class
