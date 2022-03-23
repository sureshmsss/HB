package ss.it.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import ss.it.entity.Product;
import ss.it.util.HBUtil;

public class JPAQBC_ScalarTest {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {

			// create criteria builder object
			CriteriaBuilder ctBuilder = ses.getCriteriaBuilder();

			// create criteriaQuery object
			CriteriaQuery<Object[]> ctQuery = ctBuilder.createQuery(Object[].class);

			// create Root object specifying the from operation
			Root<Product> root = ctQuery.from(Product.class);// select * from Product

			// apply where clause condition
			ctQuery.multiselect(root.get("pid"), root.get("pname")).where(
					ctBuilder.and(ctBuilder.ge(root.get("price"), 200.0f), ctBuilder.le(root.get("price"), 800.0f)))
					.orderBy(ctBuilder.asc(root.get("pname")));

			// create query having criteriaQuery Object
			Query query = ses.createQuery(ctQuery);

			// execute the query
			List<Object[]> list = query.getResultList();

			// process the result list
			list.forEach(row -> {
				for (Object o : row) {
					System.out.print(o + " ");
				}
				System.out.println("");
			});
		} // try
		catch (

		HibernateException e) {
			e.printStackTrace();
		} // catch

	}// main
}// class
