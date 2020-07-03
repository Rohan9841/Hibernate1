package com.hibernate.daoInterface;

import java.util.List;

import com.hibernate.model.Department;

public interface DepartmentDAO {

	public void insertDepartment(Department department);
	public boolean updateDepartmentName(long depId, String name);
	public Department getDepartmentInfo(long depId);
	public List<Department> getAllDepartments();
	public boolean removeDepartment(long depId);
	public void updateDepartment(Department department);
}
