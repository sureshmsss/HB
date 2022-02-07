package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.BankAccount;
import ss.it.util.HBUtil;

public class UpdateTest {
	public static void main(String[] args) {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			// prepare object for entity class
			BankAccount ac  = ses.get(BankAccount.class, 242);
			if (ac == null) {
				System.out.println("record not found");
				return;
			} else {
				// begin tx
				tx = ses.beginTransaction();
				ac.setMobNo(9909009009l);
				ac.setPwd("suresh@#$12999");
				// save object
				ses.update(ac);

				// commit the transaction
				tx.commit();
				System.out.println("object is updated");
			}
		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not updated");
		} // catch

	}// main
}// class
