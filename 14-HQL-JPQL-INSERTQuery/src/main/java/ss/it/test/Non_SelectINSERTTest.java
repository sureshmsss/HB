package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ss.it.util.HBUtil;

public class Non_SelectINSERTTest {
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
			Query query1 = ses.createQuery(
					"INSERT INTO SPProduct(pid,pname,price,qty) SELECT p.pid,p.pname,p.price,p.qty from Product as p where p.qty=:val");

			// set values to query params
			query1.setParameter("val", 4f);

			// execute query
			int count = query1.executeUpdate();// gives object class pointing to object[]

			// commit the transaction
			tx.commit();
			// print the affected rows
			 System.out.println("affected rows are : " + count);

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
