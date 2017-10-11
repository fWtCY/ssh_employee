package com.fwt.service.impl;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fwt.dao.DepartmentDao;
import com.fwt.domain.Department;
import com.fwt.domain.PageBean;
import com.fwt.service.DepartmentService;
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentDao departmentDao;	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Department> pageBean = new PageBean<>();
		// 封装每页显示记录数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
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
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public void add(Department department) {
		departmentDao.add(department);	
	}
	@Override
	public Department findById(Integer integer) {
		
		Department department = departmentDao.findById(integer);
		// TODO Auto-generated method stub
		return department;
	}
	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
	}
	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
	}
	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}
	

}
