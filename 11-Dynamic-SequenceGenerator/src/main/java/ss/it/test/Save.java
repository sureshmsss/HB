package ss.it.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ss.it.entity.Person;

public class Save {
	public static void main(String[] args) {
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
			Person p = new Person();
			p.setName("MS");
			p.setGender("male");
			p.setAddress("krmr");
			// save object
			Integer idVal = (Integer) ses.save(p);

			// commit the transaction
			tx.commit();
			System.out.println("object is saved" + p.getId());
		//	System.out.println("object is saved" + idVal);
		} // try

		catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.getStatus() != null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("object is not saved ");
			}
		} // catch

	}// main
}// class
