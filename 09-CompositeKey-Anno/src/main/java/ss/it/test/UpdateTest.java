package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.AadarWithPAN_ID;
import ss.it.entity.Adaar_Pan_Link;
import ss.it.util.HBUtil;

public class UpdateTest {
	public static void main(String[] args) {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			// prepare id class object
			AadarWithPAN_ID id = new AadarWithPAN_ID(468444484454l, 00662524525l);
			
			// load object
			Adaar_Pan_Link link = ses.get(Adaar_Pan_Link.class, id);
			if (link == null) {
				System.out.println("record not found");
				return;
			} else {
				System.out.println("object found");
				System.out.println(link);
			}
		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("some error occured");
		} // catch

	}// main
}// class
