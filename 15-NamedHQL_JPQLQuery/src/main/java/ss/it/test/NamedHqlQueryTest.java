package ss.it.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ss.it.entity.Product;
import ss.it.util.HBUtil;

public class NamedHqlQueryTest {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			System.out.println("hello try opernd");
			// begin transaction
			tx = ses.beginTransaction();

			// prepare HQL select query aggregate function
			Query query1 = ses.getNamedQuery("GET_PRODUCTS_BY_PRICE");
			// set values to query params
			query1.setParameter("min", 100f);
			query1.setParameter("max", 500f);

			// execute query
			List<Product> list = query1.getResultList();// gives object class pointing to object[]

			// print the records
			list.forEach(System.out::println);
			// commit the transaction
			tx.commit();
			// print the affected rows
			// System.out.println("affected rows are : " + count);

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.getStatus() != null && tx.getRollbackOnly()) {
				tx.rollback();
			}
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
