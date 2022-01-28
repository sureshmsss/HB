package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ss.it.entity.Product;
import ss.it.util.HBUtil;

public class MergeApproach2Problem {
	public static void main(String[] args) {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			// begin transaction
			tx = ses.beginTransaction();

			Product prod = ses.get(Product.class, 163);
			if (prod != null)
				System.out.println("prod is found : " + prod.hashCode());
			// prepare object for entity class
			Product prod1 = new Product();

			prod1.setPid(163);
			prod1.setPname("mm");
			prod1.setPrice(5620);
			prod1.setQty(2.0f);
			ses.merge(prod1);

			// commit the tx
			tx.commit();

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
		} // catch

	}// main
}// class
