package com.fwt.action;
import java.util.List;

import com.fwt.domain.Department;
import com.fwt.domain.Employee;
import com.fwt.domain.PageBean;
import com.fwt.service.DepartmentService;
import com.fwt.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.inject.Context;
/*
 * 员工管理的Action
 * */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public String login() {
		
		System.out.println("1211221");
		Employee existEmployee= employeeService.login(employee);
		if (existEmployee == null) {
			this.addActionError("用户名或密码错误");
			return INPUT;
		}else {
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}		
	}
	public String findAll() {
		
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		System.out.println(pageBean.getList());
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	public String edit(){
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		employee = employeeService.findById(employee.getEid());
		return "edit";
	}
	public String addUI() {
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "addUI";
	}
	public String add(){
		employeeService.add(employee);
		return "add";
	}
	public String delect() {
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "delete";
	}
	//模型驱动使用的对象
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
}
