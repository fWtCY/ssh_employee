package com.fwt.dao;

import java.util.List;

import com.fwt.domain.Department;
import com.fwt.domain.Employee;
import com.fwt.domain.PageBean;

public interface EmployeeDao {


	Employee findUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	Employee findById(Integer eid);

	void add(Employee employee);

	void delete(Employee employee);

}
