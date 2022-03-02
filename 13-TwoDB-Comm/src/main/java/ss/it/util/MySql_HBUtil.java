package ss.it.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySql_HBUtil {
	private static SessionFactory factory;

	static {
		System.out.println("====hb util static block====");
		// create Configuration object
		Configuration cfg = new Configuration();
		// load and read HB configuration file
		cfg.configure("ss/it/cfgs/hibernate_MySql.cfg.xml");
		// create session factory object
		factory = cfg.buildSessionFactory();
	}

//static factory method for SessionFactory object
	public static SessionFactory getFactory() {
		return factory;
	}

//static factory method for Session Object
	public static Session getSession() {
		Session ses = null;
		if (factory != null)
			ses = factory.openSession();
		return ses;
	}
}
