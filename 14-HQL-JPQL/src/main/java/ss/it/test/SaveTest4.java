package ss.it.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ss.it.entity.Product;
import ss.it.util.HBUtil;

public class SaveTest4 {
	public static void main(String[] args) {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {

			// prepare query object having both positinal and named parameter HQL/JPQL
			// object
			Query query = ses.createQuery("from Product where pname in(?1,:prod2,?2) order by pname asc");
			query.setParameter(1, "cch");
			query.setParameter("prod2", "cccxx");
			query.setParameter(2, "mouse");
			// get the records from table
			List<Product> list = query.list();// execute the hql query

			list.forEach(prod -> System.out.println(prod));
		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
