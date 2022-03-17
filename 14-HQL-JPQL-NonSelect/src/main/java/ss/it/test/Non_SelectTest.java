package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ss.it.util.HBUtil;

public class Non_SelectTest {
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
					"update Product set price=price-:discount where price>=:minprice and price<=:maxprice");

			// set values to query params
			query1.setParameter("discount", 30.0f);
			query1.setParameter("minprice", 600.0f);
			query1.setParameter("maxprice", 800.0f);

			// execute query
			int count = query1.executeUpdate();// gives object class pointing to object[]

			// commit the transaction
			tx.commit();
			// print the affected rows
			System.out.println("affected rows are : " + count);
			/*	 // executing HQL select query aggregate function
				Query query2 = ses.createQuery(
						"delete from Product where qty=:val");
				
				// set values to query params
				query2.setParameter("val", 4f);
				
				// execute query
				int count=query2.executeUpdate();// gives object class pointing to object[]
				
				// commit the transaction
				tx.commit();
				// print the affrected rows
				System.out.println("affected rows are : " + count);
				*/

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
