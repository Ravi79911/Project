package com.nt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.cfg.HibernateUtil;
import com.nt.model.User;

public class UserDAO {

	public void saveUser(User user) {
		Transaction tx=null;
		try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			tx=session.beginTransaction();
			session.save(user);
			tx.commit();
		}catch(Exception e) {
			if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
		}
	}
	
	public User findById(Long id) {
		try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			return session.get(User.class, id);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<User> findAll(){
		try (
			Session session=HibernateUtil.getSessionFactory().openSession()){
				return session.createQuery("FROM User",User.class).list();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}
	
	public void updateUser(User user) {
		Transaction tx=null;
		try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			tx=session.beginTransaction();
			session.update(user);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		
	}
	
	public void deleteUser(User user) {
		Transaction tx=null;
		try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			tx=session.beginTransaction();
			session.delete(user);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	
	
	}

