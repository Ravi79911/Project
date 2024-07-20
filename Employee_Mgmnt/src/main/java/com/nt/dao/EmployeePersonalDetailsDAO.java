package com.nt.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.mgmt.HibernateUtil;
import com.nt.model.EmployeeMaster;
import com.nt.model.EmployeePersonalDetails;

public class EmployeePersonalDetailsDAO {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();


    public void saveEmployeePersonalDetails(EmployeePersonalDetails employeePersonalDetails) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(employeePersonalDetails);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        }
    
 public EmployeePersonalDetails getEmployeeById(Long id) {
    	
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(EmployeePersonalDetails.class, id);
        
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }

	  
	  public void updateEmployee(EmployeePersonalDetails employeePesronalDetails) {
	  Transaction tx = null;
	  
	  try (Session session=HibernateUtil.getSessionFactory().openSession()){ 
		  tx = session.beginTransaction(); 
	  		session.update(employeePesronalDetails);
	  		tx.commit();
	  		} catch (Exception e) { 
	  			if (tx != null) tx.rollback();
	  			e.printStackTrace();
	  			} 
	 
	  }
	 
}
