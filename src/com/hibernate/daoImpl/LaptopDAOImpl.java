package com.hibernate.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.daoInterface.LaptopDAO;
import com.hibernate.model.Laptop;
import com.hibernate.utility.HibernateUtility;

public class LaptopDAOImpl implements LaptopDAO {

	@Override
	public void insertLaptop(Laptop laptop) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		session.persist(laptop);
		transaction.commit();
	}

	@Override
	public boolean updateLaptopName(long lapId, String name) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("update Laptop set name = ? where lapId = ?");
		query.setString(0, name);
		query.setLong(1, lapId);
		
		int result = query.executeUpdate();
		
		transaction.commit();
		return(result != 0)?true:false;
	}

	@Override
	public Laptop getLaptopInfo(long lapId) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		Laptop laptop = (Laptop) session.load(Laptop.class, lapId);
		return(laptop!=null)?laptop:null;
	}

	@Override
	public List<Laptop> getAllLaptops() {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Laptop");
		List<Laptop> laptops = query.list();
	
		return(laptops!=null)?laptops:null;
	}

	@Override
	public boolean removeLaptop(long lapId) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		Laptop laptop = (Laptop)session.get(Laptop.class, lapId);
		
		if(laptop != null) {
			session.delete(laptop);
			transaction.commit();
			return true;
		}
		return false;
	}

}
