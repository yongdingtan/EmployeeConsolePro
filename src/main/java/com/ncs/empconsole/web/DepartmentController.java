package com.ncs.empconsole.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.empconsole.model.Department;
import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.service.DepartmentService;
import com.ncs.empconsole.service.EmployeeService;
@RestController
@RequestMapping("/empconsole/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	EmployeeService empService;
	
	public DepartmentController()
	{
		System.out.println("Department Controller constructor called");
	}
	
	//Create Department
	@PostMapping("/")
	public Department createDepartment(@RequestBody String name)
	{
		Department department = new Department(name);
		return departmentService.addDepartment(department);
		
	}
	
	//Get all Departments
	@GetMapping("/")
	public List<Department> getAllDepartments()
	{
		return departmentService.getAllDepartments();
	}
	
	//Get Department Details by Code
	@GetMapping("/{id}")
	public Department getDepartmentByCode(@PathVariable int id)
	{
		return departmentService.getDepartmentByCode(id);
	}
	
	@PutMapping("/employee/{searchEmpId}/department")
	public Employee updateEmployeeDepartment(@PathVariable int searchEmpId,@RequestParam int dcode)
	{
		System.out.println(" HR @ REST Controller ");
		System.out.println(" Searched Emp Id :- "+searchEmpId);
		System.out.println("D code "+dcode);
		Department d = departmentService.getDepartmentByCode(dcode);
		
		if(d != null)
		{
			System.out.println("--->> inside d "+d);
			Employee e = empService.updateDepartment(searchEmpId, d);
			return e;
		}
		
		return null;
	}
	

}
