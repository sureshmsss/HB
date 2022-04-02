package ss.it.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.Customer;
import ss.it.entity.Employee;
import ss.it.entity.Person;
import ss.it.util.HBUtil;

public class TPCC_SelectTest {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			Query q1 = ses.createQuery("from Person");
			List<Person> p1 = q1.getResultList();
			p1.forEach(p11 -> System.out.println(p11));
			Query q2 = ses.createQuery("from Customer");
			List<Customer> p2 = q2.getResultList();
			p2.forEach(p22 -> System.out.println(p22));
			Query q3 = ses.createQuery("from Employee");
			List<Employee> p3 = q3.getResultList();
			p3.forEach(p33 -> System.out.println(p33));

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
