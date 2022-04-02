package ss.it.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.CardPayment;
import ss.it.entity.ChequePayment;
import ss.it.entity.Payment;
import ss.it.util.HBUtil;

public class TPSC_SelectTest {
	public static void main(String[] args) throws ClassCastException {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			Query q1 = ses.createQuery("from CardPayment");
			List<CardPayment> p1 = q1.getResultList();
			p1.forEach(card -> System.out.println(card));
			Query q2 = ses.createQuery("from ChequePayment");
			List<ChequePayment> p2 = q2.getResultList();
			p2.forEach(cheque -> System.out.println(cheque));
			Query q3 = ses.createQuery("from Payment");
			List<Payment> p3 = q3.getResultList();
			p3.forEach(payment -> System.out.println(payment));

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
