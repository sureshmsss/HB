package ss.it.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.Person;
import ss.it.util.HBUtil;

public class Coll_Mapping_SaveTest {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {

			Person p = new Person();
			p.setPname("suresh");
			p.setAddress("hyd");
			p.setNickNames(List.of("suri","soori","suribabu"));
			p.setFriends(List.of("ss", "ms", "ssms"));
			p.setPhones(Set.of(9865975845l, 5648546854l));
			p.setIdCards(Map.of("uid", 6623644152l, "pan", 121448434l));

			// begin tx
			tx = ses.beginTransaction();

			// save objects
			ses.save(p);
			// commit tx
			tx.commit();

			System.out.println("objects are saved");

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
