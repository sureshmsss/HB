package ss.it.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import ss.it.entity.Product;
import ss.it.util.HBUtil;

public class NativeSQLQueryTest3 {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			// scalar query getting multiple specific values
			NativeQuery query = ses.createNativeQuery("select * from product where qty<:range");
			// map entity query results with entity class
			query.addEntity(Product.class);

			// set query param values
			query.setParameter("range", 5.0);

			// execute query
			List<Product> list = query.getResultList();
			// process the results
			list.forEach(prod -> {
				System.out.println(prod);
			});

		} // try
		catch (

		HibernateException e) {
			e.printStackTrace();
		} // catch

	}// main
}// class
