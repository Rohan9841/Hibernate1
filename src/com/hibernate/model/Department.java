package com.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department_table")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long depId;
	private String name;
	
	@OneToMany(
			mappedBy = "department",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
//			orphanRemoval = true
	   )
	private List<Student> students = new ArrayList<>();
	
	public Department() {
		super();
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public Department(String name, List<Student> students) {
		super();
		this.name = name;
		this.students = students;
	}
	
	public void addStudent(Student student) {
		students.add(student);
		student.setDepartment(this);
	}
	
	public void removeStudent(Student student) {
		students.remove(student);
		student.setDepartment(null);
	}
	
	public List<Student> getStudent() {
		return students;
	}


	public void setStudent(List<Student> students) {
		this.students = students;
	}


	public long getDepId() {
		return depId;
	}
	public void setDepId(long depId) {
		this.depId = depId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", name=" + name + ", students=" + students + "]";
	}
	
	
	
}
