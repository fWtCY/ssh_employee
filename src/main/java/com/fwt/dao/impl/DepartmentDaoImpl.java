package com.fwt.dao.impl;

import java.util.List;

import javax.persistence.criteria.From;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fwt.dao.DepartmentDao;
import com.fwt.domain.Department;
import com.opensymphony.xwork2.ActionContext;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{
 
	@Override
	public int findCount() {
		String sql = "select count(*) from Department ";
		List<Long> count=this.getHibernateTemplate().find(sql);
		if (count!=null) {
			return count.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		 List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
	
	
	@Override
	public void add(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(department);
	}

	@Override
	public Department findById(Integer integer) {
		
		 Department department =  this.getHibernateTemplate().get(Department.class,integer);
		// TODO Auto-generated method stub
		return department;
	}

	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}

	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(department);
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		String sql = "from Department";
		List<Department> list = this.getHibernateTemplate().find(sql);
		return list;
	}

}
