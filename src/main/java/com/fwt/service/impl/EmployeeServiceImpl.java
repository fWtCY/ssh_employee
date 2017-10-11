package com.fwt.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fwt.dao.EmployeeDao;
import com.fwt.domain.Department;
import com.fwt.domain.Employee;
import com.fwt.domain.PageBean;
import com.fwt.service.EmployeeService;
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
	 Employee existEmployee = employeeDao.findUsernameAndPassword(employee);
		
	 	return existEmployee;
	}
	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Employee>pageBean = new PageBean<Employee>();
		pageBean.setCurrPage(currPage);
		// 封装每页显示记录数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		int totalPage;
		if (totalCount%pageSize==0) {
		totalPage = totalCount/pageSize;
		}else{
		totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
				
		if (currPage<1) {
		currPage=1;
		}else if (currPage>totalPage) {
		currPage=totalPage;
		} 
		//  封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的数据
		int begin = (currPage -1)*pageSize;
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		Employee employee = employeeDao.findById(eid);
		return employee;
	}
	@Override
	public void add(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.add(employee);
	}
	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}




}
