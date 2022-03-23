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

public class JPAQBC_ScalarTest_Pagination {
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
			CriteriaQuery<Product> ctQuery = ctBuilder.createQuery(Product.class);

			// create Root object specifying the from operation
			Root<Product> root = ctQuery.from(Product.class);// select * from Product

			// create query having criteriaQuery Object
			Query query = ses.createQuery(ctQuery);

			// perform pagination activities
			query.setFirstResult(0);
			query.setMaxResults(3);

			// process the result list
			List<Product> list = query.getResultList();

			// process the result list
			list.forEach(row -> System.out.println(row));

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
		} // catch

	}// main
}// class
