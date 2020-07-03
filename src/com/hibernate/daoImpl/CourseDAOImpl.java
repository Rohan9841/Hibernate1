package com.hibernate.daoImpl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.daoInterface.CourseDAO;
import com.hibernate.model.Course;
import com.hibernate.model.Student;
import com.hibernate.utility.HibernateUtility;

public class CourseDAOImpl implements CourseDAO {

	@Override
	public void insertCourse(Course course) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		session.persist(course);
		transaction.commit();
	}

	@Override
	public boolean updateCourseName(long courseId, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Course getCourseInfo(long courseId) {
		Session session = HibernateUtility.getSession();
		Course course = (Course) session.load(Course.class, courseId);
		return(course!=null)?course:null;
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCourse(long courseId) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		Course course = (Course)session.get(Course.class, courseId);
		
		if(course != null) {
			course.removeAllStudents();
			session.delete(course);
			transaction.commit();
			return true;
		}
		return false;
	}

}
