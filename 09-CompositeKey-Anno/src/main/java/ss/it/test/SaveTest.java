package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.AadarWithPAN_ID;
import ss.it.entity.Adaar_Pan_Link;
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

			// prepare id class object
			AadarWithPAN_ID apid = new AadarWithPAN_ID(468444484454l, 00662524525l);
			// prepare object for entity class
			Adaar_Pan_Link apl = new Adaar_Pan_Link(apid, "mahi", "SE", 4446852f);

			// save object
			AadarWithPAN_ID id = (AadarWithPAN_ID) ses.save(apl);

			// commit the transaction
			tx.commit();
			System.out.println("object is saved");

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
