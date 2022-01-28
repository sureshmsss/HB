package ss.it.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ss.it.entity.Product;

public class Refresh {
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
			Product prod = ses.get(Product.class, 4);
			if (prod == null) {
				System.out.println("object not found with given id ");
			} else {
				// display the record
				System.out.println("1st : " + prod);
				Thread.sleep(30000);
				// prod.setPid(2);
				ses.refresh(prod);
				System.out.println("2nd : " + prod);

				// commit the transaction
				tx.commit();
				System.out.println("Object is refresh");
			} // else
		} // try
		catch (Exception e) {
			e.printStackTrace();
		} // catch

	}// main
}// class
