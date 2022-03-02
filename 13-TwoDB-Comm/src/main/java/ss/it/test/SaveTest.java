package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.Product;
import ss.it.util.MySql_HBUtil;
import ss.it.util.Oracle_HBUtil;

public class SaveTest {
	public static void main(String[] args) {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory oracle_factory = Oracle_HBUtil.getFactory();
		SessionFactory mysql_factory = MySql_HBUtil.getFactory();

		// create session object
		Session oracle_ses = Oracle_HBUtil.getSession();
		Session mysql_ses = MySql_HBUtil.getSession();

		Transaction oracle_tx = null;
		Transaction mysql_tx = null;
		try (oracle_factory; mysql_factory; oracle_ses; mysql_ses) {
			// begin transaction
			oracle_tx = oracle_ses.beginTransaction();

			// prepare object for entity class
			Product p = oracle_ses.get(Product.class, 151);// gets from ORACLE DB S/W
			mysql_tx = mysql_ses.beginTransaction();
			int idVal = (int) mysql_ses.save(p);// inserts into MySql DB S/W
			// commit the transaction
			mysql_tx.commit();
			System.out.println("object is saved and id value : " + idVal);

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
