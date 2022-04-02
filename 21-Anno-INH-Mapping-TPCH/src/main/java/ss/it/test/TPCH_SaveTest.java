package ss.it.test;

import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;

import ss.it.entity.CardPayment;
import ss.it.entity.ChequePayment;
import ss.it.entity.Payment;
import ss.it.util.HBUtil;

public class TPCH_SaveTest {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			// prepare objects
			CardPayment cd1 = new CardPayment();
			cd1.setAmount(50000.0);
			cd1.setCardNo(9992123445l);
			cd1.setCardType("CREDIT");
			cd1.setGateWay("VISA");

			ChequePayment ch1 = new ChequePayment();
			ch1.setAmount(60000.0);
			ch1.setTxDate(LocalDateTime.now());
			ch1.setChequeType("self");
			ch1.setChequeNo(12356487l);
			ch1.setTxDate(LocalDateTime.now());
			// begin tx
			tx = ses.beginTransaction();

			// save objects
			ses.save(ch1);
			ses.save(cd1);

			// commit tx
			tx.commit();

			System.out.println("objects are saved");

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.getStatus() != null && tx.getRollbackOnly()) {
				tx.rollback();
			}
			System.out.println("problem in saving objects");
		} // catch

	}// main
}// class
