package com.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.daoImpl.CourseDAOImpl;
import com.hibernate.daoImpl.DepartmentDAOImpl;
import com.hibernate.daoImpl.LaptopDAOImpl;
import com.hibernate.daoImpl.StudentDAOImpl;
import com.hibernate.daoInterface.CourseDAO;
import com.hibernate.daoInterface.DepartmentDAO;
import com.hibernate.daoInterface.LaptopDAO;
import com.hibernate.daoInterface.StudentDAO;
import com.hibernate.model.Course;
import com.hibernate.model.Department;
import com.hibernate.model.Laptop;
import com.hibernate.model.Student;

public class Test {
	public static void main(String[] args) {
		
		StudentDAO sDao = new StudentDAOImpl();
		LaptopDAO lapDao = new LaptopDAOImpl();
		DepartmentDAO depDao = new DepartmentDAOImpl();
		CourseDAO courseDao = new CourseDAOImpl();
		
//		Laptop laptop = new Laptop("HP");
//		Laptop laptop2 = new Laptop("Dell");
//		Laptop laptop3 = new Laptop("Mac");
//		
//		Student student = new Student("Roshik",89);
//		Student student2 = new Student("Rohan",77);
//		Student student3 = new Student("Ram",85);
////		
//		Course course = new Course("High thinking");
//		Course course2 = new Course("Algorithms");
		Course course3 = new Course("Datastructure");
//		
//		Department department = new Department("CS");
////		
//		student.addLaptop(laptop);
//		student2.addLaptop(laptop2);
//		student3.addLaptop(laptop3);
////		
//		student.addCourse(course);
//		student.addCourse(course2);
//		student2.addCourse(course);
//		student2.addCourse(course2);
//		
//		department.addStudent(student);
//		department.addStudent(student2);

//		depDao.insertDepartment(department);
//		depDao.updateDepartmentName(1, "New Department");
//		System.out.println(depDao.getDepartmentInfo(1));
		
		
//		sDao.removeStudent(1)
		
//		Department department = depDao.getDepartmentInfo(2);
//		Student s = new Student("s2",44);
//		Laptop laptop = new Laptop("laptop6");
//		Course course = courseDao.getCourseInfo(4);
//		
////		Department d = new Department("Math");
//		
//		s.addLaptop(laptop);
//		s.addCourse(course);
////		department.addStudent(s);
//		s.setDepartment(department);
////		depDao.insertStudent(s, department);
		
		
//		s1.addLaptop(new Laptop("radon"));
//		s1.addCourse(course);
//		
//		courseDao.insertCourse(course);
//		department.addStudent(s1);
//		depDao.insertDepartment(department);
//		depDao.removeDepartment(1);
		
//		depDao.removeDepartment(2);
//		sDao.removeStudent(2);
		
//		courseDao.removeCourse(1);
		
//		student3.setDepartment(department);
//		sDao.insertStudent(student3);
//		
//		Department department = depDao.getDepartmentInfo(1);
//		department.addStudent(student2);
//		sDao.insertStudent(student2);
//		depDao.updateDepartment(department);
//		System.out.println(department.getStudent());
		Student student = sDao.getStudentInfo(1);
//		student.addCourse(course3);
//		courseDao.insertCourse(course3);
//		System.out.println(student.getDepartment());
		
		Course course = courseDao.getCourseInfo(1);
		student.addCourse(course);
		sDao.updateStudent(student);
		System.out.println("Done");

		
		
	}
}
