package com.fwt.service;
import java.util.List;

import com.fwt.domain.Department;
import com.fwt.domain.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void add(Department department);

	Department findById(Integer integer);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();
}
