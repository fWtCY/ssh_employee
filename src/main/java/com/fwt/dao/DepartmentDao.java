package com.fwt.dao;

import java.util.List;

import com.fwt.domain.Department;

public interface DepartmentDao {

	public int findCount();

	public List<Department> findByPage(int begin, int pageSize);

	public void add(Department department);

	public Department findById(Integer integer);

	public void update(Department department);

	public void delete(Department department);

	public List<Department> findAll();
}
