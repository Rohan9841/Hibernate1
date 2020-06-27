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
		
		Laptop laptop = new Laptop("HP");
		Laptop laptop2 = new Laptop("Dell");
		Laptop laptop3 = new Laptop("Mac");
		
		Student student = new Student("Roshik",89);
		Student student2 = new Student("Rohan",77);
		Student student3 = new Student("Ram",85);
		
		Course course = new Course("Computer Science");
		Course course2 = new Course("Biology");
		Course course3 = new Course("Math");
		
		Department department = new Department("CS");
		
		student.addLaptop(laptop);
		student2.addLaptop(laptop2);
		student3.addLaptop(laptop3);
		
		student.addCourse(course);
		student.addCourse(course2);
		student2.addCourse(course);
		student2.addCourse(course2);
		
		department.addStudent(student);
		department.addStudent(student2);

//		depDao.insertDepartment(department);
//		depDao.updateDepartmentName(1, "New Department");
//		System.out.println(depDao.getDepartmentInfo(1));
		
		
		sDao.removeStudent(1);
		
		System.out.println("Done");

		
		
	}
}
