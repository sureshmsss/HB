package ss.it.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ss.it.entity.Product;
import ss.it.util.HBUtil;

public class SaveTest6 {
	public static void main(String[] args) {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {

			/*			// executing HQL select query for single record
						Query query = ses.createQuery(" from Product where pid=:id");
						query.setParameter("id", 180);
						// get the records from table
						Product prod = (Product) query.getSingleResult();// execute the hql query
						if (prod != null)
							System.out.println("product found " + prod);
						else
							System.out.println("no product found");
			*/
			// executing HQL scalar select query for multiple col values
			/*			Query query2 = ses.createQuery("select pid,pname from Product where pid=:id");
						query2.setParameter("id", 180);
						// get the records from table
						Object result = query2.getSingleResult();// gives object class pointing to object[]
						Object values[] = (Object[]) result;
			
						System.out.println(values[0] + "=" + values[1]);
			 // executing HQL scalar select query for single value of single col
			Query query3 = ses.createQuery("select pname from Product where pid=:id");
			query3.setParameter("id", 180);
			// get the records from table
			String name = (String) query3.getSingleResult();// gives object class pointing to object[]
			
			System.out.println(name);
			// executing HQL select query aggregate function
			Query query4 = ses.createQuery("select count(*) from Product");
			// get the records from table
			long count = (long) query4.getSingleResult();// gives object class pointing to object[] 
			System.out.println(count);*/
			Query query5 = ses.createQuery("from Product where price=(select max(price) from Product)");
			List<Product> list = query5.getResultList();
			list.forEach(System.out::println);

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
