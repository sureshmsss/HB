package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ss.it.entity.Product;
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

			// prepare object for entity class
			Product prod = ses.get(Product.class, 156);

			if (prod != null) {
				System.out.println("object found");
			}
		} // try
		catch (HibernateException e) {
			e.printStackTrace();
		} // catch

	}// main
}// class
