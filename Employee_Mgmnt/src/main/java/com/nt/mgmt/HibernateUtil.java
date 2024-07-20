package com.nt.mgmt;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.nt.model.EmployeeDependent;
import com.nt.model.EmployeeMaster;
import com.nt.model.EmployeePersonalDetails;



public class HibernateUtil {

	 private static SessionFactory sessionFactory;
	 
	 public static SessionFactory getSessionFactory() {
		 if(sessionFactory==null) {
			 synchronized (HibernateUtil.class) {
				 if(sessionFactory==null) {
					try {
						Configuration cfg = new Configuration();
						Properties pro=new Properties();
						  	pro.put(Environment.DRIVER, "org.postgresql.Driver");
						  	pro.put(Environment.URL, "jdbc:postgresql://localhost:5432/myDB");
						  	pro.put(Environment.USER, "postgres");
						  	pro.put(Environment.PASS, "root");
						  	pro.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

						  	pro.put(Environment.SHOW_SQL, "true");
						  	pro.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
						  	pro.put(Environment.HBM2DDL_AUTO, "update");
						  	
						  	cfg.setProperties(pro);
	                        cfg.addAnnotatedClass(EmployeeMaster.class);
	                        cfg.addAnnotatedClass(EmployeeDependent.class);
	                        cfg.addAnnotatedClass(EmployeePersonalDetails.class);
	                        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                                .applySettings(cfg.getProperties()).build();

	                        sessionFactory = cfg.buildSessionFactory(serviceRegistry);

					}catch (Exception e) {
                        throw new ExceptionInInitializerError(e);
                    }
				 }
			 }
		 }
		 return sessionFactory;
	 }
}
