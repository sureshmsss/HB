package ss.it.thread;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ss.it.entity.Product;
import ss.it.util.HBUtil;

public class MultiThread implements Runnable {
	@Override
	public void run() {
		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;

		try (ses) {
			for (int i = 0; i <= 3; ++i) {
				// begin transaction
				tx = ses.beginTransaction();

				// prepare object for entity class
				Product prod = new Product();
				prod.setPname("b");
				prod.setPrice(54251);
				prod.setQty(5f);
				ses.save(prod);
				// save object
				ses.save(prod);

				// commit the transaction
				tx.commit();
				System.out.println("object is saved" + prod.getPid());
			}
		} // try

		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} // catch

	}
}
