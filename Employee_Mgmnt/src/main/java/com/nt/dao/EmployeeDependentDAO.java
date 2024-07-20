package com.nt.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.mgmt.HibernateUtil;
import com.nt.model.EmployeeDependent;
import com.nt.model.EmployeePersonalDetails;


public class EmployeeDependentDAO {
	
	
	public void saveEmployeeDependents(List<EmployeeDependent> dependents) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            for (EmployeeDependent dependent : dependents) {
                session.save(dependent);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
 public EmployeeDependent getEmployeeById(Long id) {
    	
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(EmployeeDependent.class, id);
        
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }

	  
	  public EmployeeDependent updateEmployee(EmployeeDependent employeeDependent) {
	  Transaction tx = null;
	  
	  try (Session session=HibernateUtil.getSessionFactory().openSession()){ 
		  tx = session.beginTransaction(); 
	  		session.update(employeeDependent);
	  		tx.commit();
	  		} catch (Exception e) { 
	  			if (tx != null) tx.rollback();
	  			e.printStackTrace();
	  			} 
	  return employeeDependent;
	  }
	 
}
