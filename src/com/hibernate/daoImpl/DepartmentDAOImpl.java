package com.hibernate.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.daoInterface.DepartmentDAO;
import com.hibernate.daoInterface.StudentDAO;
import com.hibernate.model.Department;
import com.hibernate.utility.HibernateUtility;

public class DepartmentDAOImpl implements DepartmentDAO {

	StudentDAO sDao = new StudentDAOImpl();
	@Override
	public void insertDepartment(Department department) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		session.persist(department);
		transaction.commit();

	}

	@Override
	public boolean updateDepartmentName(long depId, String name) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("update Department set name = ? where depId = ?");
		query.setString(0, name);
		query.setLong(1, depId);
		
		int result = query.executeUpdate();
		
		transaction.commit();
		return(result != 0)?true:false;
	}

	@Override
	public Department getDepartmentInfo(long depId) {
		Session session = HibernateUtility.getSession();
		Department department = (Department) session.load(Department.class, depId);
		return(department!=null)?department:null;
	}

	@Override
	public List<Department> getAllDepartments() {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Department");
		List<Department> departments = query.list();
		
		return(departments!=null)?departments:null;
	}

	@Override
	public boolean removeDepartment(long depId) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		Department department = (Department)session.get(Department.class, depId);
		
		if(department != null) {
			department.removeAllStudents();
			session.delete(department);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public void updateDepartment(Department department) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(department);
		transaction.commit();
	}
	
	

}
