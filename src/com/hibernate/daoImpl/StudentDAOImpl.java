package com.hibernate.daoImpl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.daoInterface.StudentDAO;
import com.hibernate.model.Course;
import com.hibernate.model.Laptop;
import com.hibernate.model.Student;
import com.hibernate.utility.HibernateUtility;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public void insertStudent(Student student) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		session.persist(student);
		transaction.commit();
		
	}

	@Override
	public boolean updateStudentMarks(long sId, int newMarks) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("update Student set marks = ? where sId = ?");
		query.setInteger(0, newMarks);
		query.setLong(1, sId);
		
		int result = query.executeUpdate();
		
		transaction.commit();
		return(result != 0)?true:false;
	}

	@Override
	public Student getStudentInfo(long sId) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student) session.load(Student.class, sId);
		return(student!=null)?student:null;
	
	}

	@Override
	public List<Student> getAllStudents() {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Student");
		List<Student> students = query.list();
		
		return(students!=null)?students:null;
	}

	@Override
	public boolean removeStudent(long sId) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = (Student)session.get(Student.class, sId);
		
		if(student != null) {
			Laptop laptop = student.getLaptop();
			student.removeLaptop(laptop);
			student.removeAllCourses();
//			session.saveOrUpdate(student);
			session.delete(student);
			transaction.commit();
			return true;
		}
		return false;
	}

}
