package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.Product;
import ss.it.entity.Shop;
import ss.it.util.HBUtil;

public class AdvORMTest {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			// begin transaction
			tx = ses.beginTransaction();

			// prepare component property
			Shop shop = new Shop();
			shop.setSname("DMART");
			shop.setSadd("ESI");
			shop.setQuality("A");

			// prepare simple property
			Product product = new Product();
			product.setPid(452);
			product.setPname("table");
			product.setPrice(800f);
			product.setQty(5.0f);
			product.setDetails(shop);

			// save object
			int idVal = (int) ses.save(product);
			System.out.println("the product details are : " + product.toString());

			// commit the transaction
			tx.commit();
		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.getStatus() != null && tx.getRollbackOnly()) {
				tx.rollback();
			}
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
