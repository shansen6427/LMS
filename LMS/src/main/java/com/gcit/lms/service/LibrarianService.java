package com.gcit.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.gcit.lms.entities.LibraryBranch;

public class LibrarianService {

	public void updateBranchDetails(LibraryBranch libraryBranch) throws Exception {
		
		Session sess = HibernateUtil.getInstance().getSessionFactory().openSession();
		try {
			sess.beginTransaction();
			sess.merge(libraryBranch);
			sess.getTransaction().commit();

		} catch(Exception e) {
			sess.getTransaction().rollback();
			throw e;
		} finally {
			sess.close();
		}
		
	}

	public LibraryBranch getLibraryBranch(int id) throws Exception {
		
		Session sess = HibernateUtil.getInstance().getSessionFactory().openSession();
		LibraryBranch lib = null;
		try {
			lib = (LibraryBranch) sess.load(LibraryBranch.class, id);
		} catch(Exception e) {
			throw e;
		} finally {
			sess.close();
		}
		
		return lib;
	}

	@SuppressWarnings("unchecked")
	public List<LibraryBranch> listAllBranches() throws Exception {
		
		Session sess = HibernateUtil.getInstance().getSessionFactory().openSession();
		List<LibraryBranch> branchList = new ArrayList<LibraryBranch>();
		try {
			Criteria crit = sess.createCriteria(LibraryBranch.class);
			branchList = crit.list();
		} catch(Exception e) {
			throw e;
		} finally {
			sess.close();
		}
		
		return branchList;
	}

	@SuppressWarnings("unchecked")
	public List<LibraryBranch> listBranchByName(String name) throws Exception {
		
		Session sess = HibernateUtil.getInstance().getSessionFactory().openSession();
		List<LibraryBranch> branchList = new ArrayList<LibraryBranch>();
		try {
			Criteria crit = sess.createCriteria(LibraryBranch.class);
			crit.add(Restrictions.ilike("branchName", name));
			
			branchList = crit.list();
		} catch(Exception e) {
			throw e;
		} finally {
			sess.close();
		}
		
		return branchList;
	}
}
