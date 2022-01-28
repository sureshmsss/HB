package ss.it.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ss.it.entity.Product;

/*run this class by taking <class name="ss.it.entity.Product" dynamic-insert="true"
dynamic-update="true">*/

public class SaveOrUpdate {
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
			// prepare object for entity class
			Product prod = new Product();
			prod.setPid(10);
			prod.setPname("chair");
			prod.setPrice(500);
			prod.setQty(4.0f);
			ses.saveOrUpdate(prod);

			// commit the transaction
			tx.commit();
			System.out.println("Object is saved or updated");
		} // try
		catch (Exception e) {
			if (tx != null && tx.getStatus() != null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("object is not saved or updated");
			}
			e.printStackTrace();
		} // catch

	}// main
}// class
