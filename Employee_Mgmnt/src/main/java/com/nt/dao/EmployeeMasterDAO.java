package com.nt.dao;




import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.mgmt.HibernateUtil;
import com.nt.model.EmployeeMaster;

public class EmployeeMasterDAO {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    public EmployeeMaster saveEmployeeMaster(EmployeeMaster employeeMaster) {
        Session session = factory.openSession();
        Transaction tx = null;
        EmployeeMaster savedEmployee = null;

        try {
            tx = session.beginTransaction();
            Long id = (Long) session.save(employeeMaster);
            tx.commit();
            savedEmployee = session.get(EmployeeMaster.class, id);

            // Generate and update employee code after saving
            if (savedEmployee != null) {
                savedEmployee.setEmployeeCode(generateEmployeeCode(savedEmployee.getId()));

                // Use the same session to update the employee
                tx = session.beginTransaction();
                session.update(savedEmployee);
                tx.commit();
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeMaster;
        
    }
    
    public EmployeeMaster getEmployeeById(Long id) {
    	
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(EmployeeMaster.class, id);
        
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }

	  
	  public void updateEmployee(EmployeeMaster employeeMaster) {
	  Transaction tx = null;
	  
	  try (Session session=HibernateUtil.getSessionFactory().openSession()){ 
		  tx = session.beginTransaction(); 
	  		session.update(employeeMaster);
	  		tx.commit();
	  		} catch (Exception e) { 
	  			if (tx != null) tx.rollback();
	  			e.printStackTrace();
	  			} 
	  
	  }
	 
    
    public List<EmployeeMaster> getAllActiveEmployees(Session session) {
        Query<EmployeeMaster> query = session.createQuery("FROM EmployeeMaster WHERE status = 1", EmployeeMaster.class);
        return query.list();
    }


    private String generateEmployeeCode(Long id) {
        return "EMP" + String.format("%05d", id); // Generates codes like EMP00001, EMP00002, etc.
    }
}
