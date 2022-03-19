package ss.it.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import ss.it.entity.Product;
import ss.it.util.HBUtil;

public class NativeSQLQueryTest {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			// scalar query getting multiple specific values
			NativeQuery query = ses.getNamedNativeQuery("GET_PROD_BY_PRICE");
			
			// map entity query results with entity class
			query.addEntity(Product.class);

			// set values to query params
			query.setParameter(1, 5000);
			query.setParameter(2, 251);

			// execute the query
			List<Product> list = query.getResultList();
			// process the results
			list.forEach(prod -> {
				System.out.println(prod);
			});
			System.out.println("===============");
			NativeQuery query1 = ses.getNamedNativeQuery("GET_PROD_BY_QTY");

			// map entity query results with entity class
			query1.addEntity(Product.class);

			// set values to query params
			query1.setParameter(1, 20);
			query1.setParameter(2, 2);

			// execute the query
			List<Product> list2 = query1.getResultList();
			// process the results
			list2.forEach(prod -> {
				System.out.println(prod);
			});

		} // try
		catch (

		HibernateException e) {
			e.printStackTrace();
		} // catch

	}// main
}// class
