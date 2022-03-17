package ss.it.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ss.it.entity.Product;
import ss.it.util.HBUtil;

public class PaginationTest {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try(ses) {
			int pageSize = 4;
			// prepare HQL select query
			Query query = ses.createQuery("select count(*) from Product");
			// get no of records
			long totalRecords = (long) query.getSingleResult();
			long pageCount = totalRecords / pageSize;
			if (totalRecords % pageSize != 0)
				pageCount++;

			// create HQL query for pagination
			Query query1 = ses.createQuery("from Product");

			for (int pageNo = 1; pageNo <= pageCount; ++pageNo) {
				System.out.println("page No : " + pageNo);

				int startPosition = (pageNo * pageSize) - pageSize;
				// set pagination params
				query1.setFirstResult(startPosition);
				query1.setMaxResults(pageSize);
				// execute query
				List<Product> list = query1.getResultList();// gives object class pointing to object[]

				// print the reocrds
				list.forEach(System.out::println);

			} // for
		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.getStatus() != null && tx.getRollbackOnly()) {
				tx.rollback();
			}
			System.out.println("not found");
		} // catch

	}// main
}// class
