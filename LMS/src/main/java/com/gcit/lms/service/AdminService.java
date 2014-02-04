package com.gcit.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.gcit.lms.entities.Author;
import com.gcit.lms.entities.Publisher;

public class AdminService {

	public void insertUpdate (Object obj) throws Exception{
		
		Session sess = HibernateUtil.getInstance().getSessionFactory().openSession();
		try{
			sess.beginTransaction();
			sess.merge(obj);
			sess.getTransaction().commit();
		}
		catch (Exception e){
			sess.getTransaction().rollback();
			throw e;
		}
		finally{
			sess.close();
		}
	}
	
	public void deleteObj (Object obj) throws Exception{
		
		Session sess = HibernateUtil.getInstance().getSessionFactory().openSession();
		try{
			sess.beginTransaction();
			sess.delete(obj);
			sess.getTransaction().commit();
		}
		catch (Exception e){
			sess.getTransaction().rollback();
			throw e;
		}
		finally{
			sess.close();
		}
	}
	
	
	public List<Author> getAllAuthors() throws Exception{
		List<Author> authorList = new ArrayList<Author>();
		Session sess = HibernateUtil.getInstance().getSessionFactory().openSession();
		try{
			Criteria crit = sess.createCriteria(Author.class);
			authorList = crit.list();
		}
		catch (Exception e){
			throw e;
		}
		finally{
			sess.close();
		}
		
		return authorList;
	}

	public List<Publisher> getAllPublishers() throws Exception{
		List<Publisher> pubList = new ArrayList<Publisher>();
		Session sess = HibernateUtil.getInstance().getSessionFactory().openSession();
		try{
			Criteria crit = sess.createCriteria(Publisher.class);
			pubList = crit.list();
		}
		catch (Exception e){
			throw e;
		}
		finally{
			sess.close();
		}
		
		return pubList;
	}
}
