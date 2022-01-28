package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ss.it.entity.Product;
import ss.it.util.HBUtil;



public class MergeApproach1 {
	public static void main(String[] args) {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			//begin transaction
			tx=ses.beginTransaction();

			// prepare object for entity class
			Product prod = new Product();
			
			prod.setPid(163);
			prod.setPname("mixc1");
			prod.setPrice(5620);
			prod.setQty(2.0f);
			Product prod1=(Product) ses.merge(prod);
			if (prod1 != null) {
				System.out.println("object is merged");
			} /*if (ses.get(Product.class,163) != null) {
				System.out.println("object is merged");
				}else {
				System.out.println("object is not avial to merege");
				}*/
			
			//commit the tx
			tx.commit();

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
		} // catch

	}// main
}// class
