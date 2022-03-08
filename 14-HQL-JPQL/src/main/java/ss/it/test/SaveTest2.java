package ss.it.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ss.it.entity.Product;
import ss.it.util.HBUtil;

public class SaveTest2 {
	public static void main(String[] args) {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {

			// prepare query object having HQL/JPQL object
			//type-1
		//	Query query = ses.createQuery("from Product where pid<=?0 and pid>=?1");
		//	query.setParameter(0, 190);
		//	query.setParameter(1, 180);
			//type-2 here 1,2 types are same
			Query query = ses.createQuery("from Product where pid<=?2 and pid>=?3");
			query.setParameter(2, 190);
			query.setParameter(3, 180);
			// get the records from table
			List<Product> list = query.list();// execute the hql query
			for (Product p : list) {
				System.out.println("p : " + p);
			}
		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
