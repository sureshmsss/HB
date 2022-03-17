package ss.it.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import ss.it.util.HBUtil;

public class NativeSQLQueryTest2 {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			/*	// scalar query getting multiple specific values
				NativeQuery query = ses.createNativeQuery("select pid,pname from product where price>=?1 and price<=?2");
				// map scalar query results hibarnate data types
				query.addScalar("pid", StandardBasicTypes.INTEGER);
				query.addScalar("pid", StandardBasicTypes.STRING);
			
				// set query param values
				query.setParameter(1, 200f);
				query.setParameter(2, 50000);
			
				// execute query
				List<Object[]> list = query.getResultList();
				list.forEach(record -> {
					for (Object val : record) {
						System.out.println(val + " ");
					}
				});
			*/
			// scalar query getting multiple specific values
			NativeQuery query = ses.createNativeQuery("select pid from product where pid<?");
			// map scalar query results hibarnate data types
			query.addScalar("pid", StandardBasicTypes.INTEGER);

			// set query param values
			query.setParameter(1, 180);

			// execute query
			List<Integer> list = query.getResultList();
			list.forEach(id -> {
				System.out.println(id);
			});

		} // try
		catch (

		HibernateException e) {
			e.printStackTrace();
		} // catch

	}// main
}// class
