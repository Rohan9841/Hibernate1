package com.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_table")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sId;
	private String name;
	private int marks;

	@OneToOne(
			mappedBy = "student",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			orphanRemoval = true
//			optional = false
			)
	private Laptop laptop;

	//child relation in Student-Department relationship
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depId")
	private Department department;
	
	//this is the parent relationship. We don't use CascadeType.All because CascadeTYpe.remove will have chain removal.  
	@ManyToMany
			(
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			fetch = FetchType.LAZY
			)
	@JoinTable(
			name = "student_course",
			joinColumns = { @JoinColumn(name = "sId")},
			inverseJoinColumns = { @JoinColumn(name = "courseId")}
	)
	private Set<Course> courses = new HashSet<>();
	
	public Student() {
		super();
	}

	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	

	public Student(long sId, String name, int marks) {
		super();
		this.sId = sId;
		this.name = name;
		this.marks = marks;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
		course.getStudents().add(this);
	}
	
	public void removeCourse(Course course) {
		this.courses.remove(course);
		course.getStudents().remove(this);
	}
	
	public void removeAllCourses() {
		for(Course course : this.courses) {
			course.getStudents().remove(this);
		}
		this.courses = null;
	}
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	//this methods add laptop to this class and adds this class to Laptop class
	public void addLaptop(Laptop laptop) {
		if(laptop == null) {
			if(this.laptop != null) {
				this.laptop.setStudent(null);
			}
		}else {
			laptop.setStudent(this);
		}
		this.laptop = laptop;
	}
	
	
	//removes the laptop from this class and sets the student to null in Laptop class
	public void removeLaptop() {
		if(this.laptop != null) {
			this.laptop.setStudent(null);
		}
		this.laptop = null;
	}

	public long getsId() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", name=" + name + ", marks=" + marks + ", laptop=" + laptop + "]";
	}
	
	//Many side requires to override equals and hascode methods for state equality
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student )) return false;
        return sId != 0L && sId == (((Student) o).getsId());
    }
 
    @Override
    public int hashCode() {
        return 31;
    }
	
}
