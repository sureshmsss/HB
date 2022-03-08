package ss.it.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ss.it.entity.Product;
import ss.it.util.HBUtil;

public class SaveTest5 {
	public static void main(String[] args) {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {

			// executing entity scalar entity query for bunch of records
			Query query = ses.createQuery("select pid,pname,price from Product where pid>=:max and pid<=:min");
			query.setParameter("min", 180);
			query.setParameter("max", 170);
			// get the records from table
			List<Object[]> list = query.list();// execute the hql query

			list.forEach(prod ->{
				System.out.println();
				for(Object value:prod)
			System.out.print(value+"-");});
		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
