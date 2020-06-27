package com.hibernate.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.daoInterface.CourseDAO;
import com.hibernate.model.Course;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCourse(long courseId) {
		// TODO Auto-generated method stub
		return false;
	}

}
