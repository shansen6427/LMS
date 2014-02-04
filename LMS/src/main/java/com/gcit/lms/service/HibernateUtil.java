package com.gcit.lms.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

//Singleton class
public class HibernateUtil {
	private static SessionFactory sessionFactory;

	private static HibernateUtil instance = null;

	private HibernateUtil() {
		try {
//			// Create the SessionFactory from hibernate.cfg.xml
//			Configuration configuration = new Configuration();
//			configuration.configure();
//			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//					.applySettings(configuration.getProperties()).build();
//			sessionFactory = new Configuration().configure()
//					.buildSessionFactory(serviceRegistry);
			
			// Create the SessionFactory from hibernate.cfg.xml 
		    sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static HibernateUtil getInstance() {
		if (instance == null)
			instance = new HibernateUtil();

		return instance;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}