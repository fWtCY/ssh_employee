package com.fwt.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fwt.dao.EmployeeDao;
import com.fwt.domain.Department;
import com.fwt.domain.Employee;
import com.fwt.domain.PageBean;



public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{

	@Override
	public Employee findUsernameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		String sql="from Employee where username = ? and password = ? ";
		List<Employee> employees =  this.getHibernateTemplate().find(sql, employee.getUsername(),employee.getPassword());
		if(employees.size()>0){
			return employees.get(0);
		}		
		return null;
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String sql=" select count(*) from Employee";
		List<Long> list= this.getHibernateTemplate().find(sql);		
		if (list!=null) {
			return list.get(0).intValue();
		}else {
			return 0;
		}
	}

	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);	
		return list;
	}

	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		Employee employee = this.getHibernateTemplate().get(Employee.class,eid);
		return employee;
	}

	@Override
	public void add(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(employee);
		System.out.println("1222222222");
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(employee);
	}
}
