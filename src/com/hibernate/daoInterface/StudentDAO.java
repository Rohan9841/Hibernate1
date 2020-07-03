package com.hibernate.daoInterface;

import java.util.List;

import com.hibernate.model.Student;

public interface StudentDAO {

	public void insertStudent(Student student);
	public boolean updateStudentMarks(long sId, int newMarks);
	public Student getStudentInfo(long sId);
	public List<Student> getAllStudents();
	public boolean removeStudent(long sId);
	public void updateStudent(Student student);
}
