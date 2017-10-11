package com.fwt.service;

import com.fwt.domain.Employee;
import com.fwt.domain.PageBean;

public interface EmployeeService {

	Employee login(Employee employee);
	PageBean<Employee> findByPage(Integer currPage);
	Employee findById(Integer eid);
	void add(Employee employee);
	void delete(Employee employee);

}
