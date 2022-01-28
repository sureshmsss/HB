package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ss.it.entity.Product;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		// bootstrap the hibernate or activate
		Configuration cfg = new Configuration();

		// specify hibernate mapping file and location
		cfg.configure("ss/it/cfgs/hibernate.cfg.xml");

		// build session factory having all the services specified cfg file in mapping
		// file
		SessionFactory factory = cfg.buildSessionFactory();

		// create session obj
		Session session = factory.openSession();

		Transaction tx = null;
		try {

			// begin transaction
			tx = session.beginTransaction();// internally calls conn.autocommit(false) to disable auto commit mode on db
											// s/w

			// prepare entity object
			Product prod = new Product();
			//prod.setPid(1006);
			prod.setPname("mouse");
			prod.setPrice(550);
			prod.setQty(2.0f);

			// save object
			 session.save(prod);
			// when we use persist() method we should not give id value for the object
			//session.persist(prod);
			// commit the data
			tx.commit();
			System.out.println("record is inserted nothing but object is saved");

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("object or record is not saved");
		}

		// close session object
		session.close();
		// close factory object
		factory.close();

	}// main
}// class
