package com.fwt.action;

import java.util.ArrayList;
import java.util.List;

import com.fwt.domain.Department;
import com.fwt.domain.PageBean;
import com.fwt.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	private DepartmentService departmentService;
	private Integer currPage=1;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public void setCurrPage(Integer currPage) {
		System.out.println(currPage);
		this.currPage = currPage;
	}

	public String findAll(){
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//将pageBean存入到值栈中
		
		ActionContext.getContext().getValueStack().push(pageBean);
		//ActionContext.getContext().getSession().put("pageBean", pageBean);
		return "findAll";
	}
	public String add(){
		departmentService.add(department);		
		return "add";
	}
	public String addUI(){
		return "addUI";
	}
	public String edit(){
		department = departmentService.findById(department.getDid());
		return "edit";
	}
	public String update(){
		departmentService.update(department);
		return  "update";
 	}
	public String delete(){
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "delete";
	}
	
	
	
	private Department department = new Department();
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
}
