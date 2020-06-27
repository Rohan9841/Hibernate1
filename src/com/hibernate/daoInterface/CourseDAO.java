package com.hibernate.daoInterface;

import java.util.List;

import com.hibernate.model.Course;

public interface CourseDAO {
	public void insertCourse(Course course);
	public boolean updateCourseName(long courseId, String name);
	public Course getCourseInfo(long courseId);
	public List<Course> getAllCourses();
	public boolean removeCourse(long courseId);
}
