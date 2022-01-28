package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ss.it.entity.Product;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		// create configuration object
		Configuration cfg = new Configuration();
		cfg.configure("ss/it/cfgs/hibernate.cfg.xml");

		// build session factory
		SessionFactory factory = cfg.buildSessionFactory();

		// build a session
		Session ses = factory.openSession();

		try (factory; ses) {// try with resource
			// load object using get(-,-) method
			Product prod = ses.load(Product.class, 1);
			System.out.println("prod is : "+prod.getClass().getName());
			if (prod != null) {
				System.out.println("prod detaisl " + prod);
			}

		} catch (HibernateException e) {
			e.printStackTrace();

		}
	}// main
}// class
