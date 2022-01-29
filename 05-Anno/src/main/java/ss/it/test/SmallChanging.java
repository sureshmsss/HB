package ss.it.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ss.it.entity.Movie;
import ss.it.proxy.IMovie;
import ss.it.util.HBUtil;

public class SmallChanging {

	public static void main(String[] args) {
		System.out.println("===full Object Updation===");

		// create build session factory
		SessionFactory factory = HBUtil.getFactory();

		// create session object
		Session ses = HBUtil.getSession();

		Transaction tx = null;
		try (factory; ses) {
			// Movie m = ses.load(Movie.class, 1);
			IMovie m = ses.load(IMovie.class, 1);

			System.out.println("get Class " + m.getClass());
			System.out.println("==========");
			System.out.println("get super class " + m.getClass().getSuperclass());
			System.out.println("==========");
			System.out.println("get Class " + m.getClass().getInterfaces());

		} // try
		catch (HibernateException e) {
			e.printStackTrace();
		} // catch

	}// main
}// class
