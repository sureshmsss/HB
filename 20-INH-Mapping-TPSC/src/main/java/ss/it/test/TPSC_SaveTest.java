package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.Customer;
import ss.it.entity.Employee;
import ss.it.entity.Person;
import ss.it.util.HBUtil;

public class TPSC_SaveTest {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {

			Person p = new Person();
			// p.setId(null);
			p.setName("ss");
			p.setAddress("hyd");
			Customer c = new Customer();
			c.setBillAmt(5000.0f);
			c.setBillNo(12345);
			Employee e = new Employee();
			e.setDesg("dev");
			e.setSalary(50000.0f);
			e.setCompany("SS-IT");

			// begin tx
			tx = ses.beginTransaction();

			// save objects
			ses.save(p);
			ses.save(c);
			ses.save(e);

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
