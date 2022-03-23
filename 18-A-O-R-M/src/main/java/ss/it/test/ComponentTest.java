package ss.it.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ss.it.entity.Product;
import ss.it.util.HBUtil;

public class ComponentTest {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			// create Query object
			Query query = ses.createQuery("from Product");
			List<Product> list = query.getResultList();
			
			list.forEach(prod -> {
				System.out.println(prod.getPid() + "-" + prod.getPname() + "-" + prod.getPrice() + "-" + prod.getQty());
			});
			/*
			// create Query object
			Query query1 = ses.createQuery("from Product where details.sname=?1");

			// set query params
			query1.setParameter(1, "DMART");
			List<Product> list = query1.getResultList();

			list.forEach(prod -> {
				System.out.println(prod.getPid() + "-" + prod.getPname() + "-" + prod.getPrice() + "-" + prod.getQty());
				System.out.println(prod.getDetails().toString());
			});*/

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
