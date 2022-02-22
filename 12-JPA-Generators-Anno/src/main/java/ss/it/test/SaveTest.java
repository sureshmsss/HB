package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.Person;
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
			Person person = new Person();
			person.setId(12);
			person.setName("suresh");
			person.setAddress("hyd");
			person.setGender("male");
			// save object
			Integer Idval = (Integer) ses.save(person);

			// commit the transaction
			tx.commit();
			System.out.println("object is saved "+Idval);

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
