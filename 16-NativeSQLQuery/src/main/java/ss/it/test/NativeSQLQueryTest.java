package ss.it.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

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

			NativeQuery query = ses.createNativeQuery("select * from product");
			List<Object[]> list = query.getResultList();
			list.forEach(record -> {
				for (Object val : record) {
					System.out.println(val);
				}
				System.out.println();
			});
			
		} // try
		catch (

		HibernateException e) {
			e.printStackTrace();
		} // catch

	}// main
}// class
