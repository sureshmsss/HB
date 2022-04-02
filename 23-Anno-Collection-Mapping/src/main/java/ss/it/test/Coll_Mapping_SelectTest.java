package ss.it.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.Person;
import ss.it.util.HBUtil;

public class Coll_Mapping_SelectTest {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			Query q1 = ses.createQuery("from Person");
			List<Person> list = q1.getResultList();
			list.forEach(p -> {
				System.out.println(p.getPid() + "-" + p.getPname() + "-" + p.getAddress());
				List<String> nickNames = p.getNickNames();
				list.forEach(System.out::println);
				List<String> friends = p.getFriends();
				list.forEach(System.out::println);
				Set<Long> phones = p.getPhones();
				list.forEach(System.out::println);
				Map<String, Long> idCards = p.getIdCards();
				System.out.println("id cards : " + idCards);

			});
		} // try
		catch (HibernateException e) {
			e.printStackTrace();
		} // catch

	}// main
}// class
