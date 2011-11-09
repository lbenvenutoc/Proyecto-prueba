package bastanteo.cloud.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	
	static {
		try {
			// Cree la SessionFactory para hibernate.cfg.xml
			/*
			sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.buildSessionFactory();
				*/
			sessionFactory= new AnnotationConfiguration().configure().buildSessionFactory();
			
		} catch (Throwable ex) {
			// Asegúrese de loguear la excepción, dado que puede ser "tragada"
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSessionFactory() {
		return sessionFactory.openSession();
	}
	
}
