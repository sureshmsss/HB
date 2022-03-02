package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.Product;
import ss.it.util.HBUtil;

public class SaveTest {
	public static void main(String[] args) {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			// begin transaction
			tx = ses.beginTransaction();

			// prepare object for entity class
			Product p = ses.get(Product.class, 150);// query executes for 1st time
			System.out.println("object is ==> " + p);
			System.out.println("object is ==> " + p);
			ses.evict(p);// removies the object from l1 cache
			System.out.println("========================");
			Product p1 = ses.get(Product.class, 150);// query executes for 2nd time
			System.out.println("object is ==> " + p1);
			System.out.println("object is ==> " + p1);

			ses.clear();// clears the L1 cache so should get from db again and query executes again
			Product p2 = ses.get(Product.class, 150);// query executes for 2nd time
			System.out.println("object is ==> " + p2);
			ses.close();
			Product p3 = ses.get(Product.class, 150);// query executes for 2nd time
			System.out.println("object is ==> " + p3);
		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
