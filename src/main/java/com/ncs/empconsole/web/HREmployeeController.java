package com.ncs.empconsole.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.empconsole.exception.OutofRangeSalaryException;
import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.service.EmployeeService;

@RestController
@RequestMapping("/empconsole/hr")
public class HREmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	public HREmployeeController() {
		System.out.println("HR Employee Controller constructor called");
	}
	
	//Get all Employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return empService.getAllEmployees();
	}

	//Get One Employee by ID
	@GetMapping("/employee/id/{id}")
	public Employee getEmployeeById(@PathVariable int id)
	{
		System.out.println("path variable : "+id);
		return empService.getEmployeeDetails(id);
	}
	
	//Get One Employee by Name
	@GetMapping("/employee") // ..../employee/hr/employee?name=ramesh
	public Employee getEmployeeByName(@RequestParam String name)
	{
		System.out.println("path varible : "+name);
		Employee e =  empService.getEmployeeDetails(name);
		System.out.println(e);
		return e;
	}
	
	//Get One Employee By Id and ProjectId
	@GetMapping("/{id}/project")
	public Employee getEmployeeProject(@RequestParam int projectid, @PathVariable int id)
	{
		Employee e = empService.getEmployeeDetails(id);
		if(e.getProject_info().getProjectNumber() == projectid)
		{
			System.out.println(e);
			return e;
		}
		else
			{
			System.out.println("No employee with such project.");
			return null;
			}
	}
	
	//Get List of Employee with Salary within Range
	@GetMapping("/employeesalary")//localhost:8080/empconsole/hr/employeesalary?range1=1000&range2=5000
	public List<Employee> getEmployeeBasedOnRange(@RequestParam int range1, @RequestParam int range2)
	{
		List<Employee> empList = empService.getAllEmployees(range1, range2);
		for (Employee employee : empList) {
			System.out.println(employee.toString());
		}
		
		return empList;
	}
	
	//Set Project ID to Employee ID
	@PutMapping("employee/{id}/project")
	public boolean setEmployeeProjectId(@PathVariable int id, @RequestParam int projectid)
	{
		boolean status = empService.updateProject(id, projectid);
		if(status) System.out.println("Project ID updated successfully");
		else System.out.println("No such employee ID");
		return status;
	}
	
	//Set Bank Account to Employee ID
	@PutMapping("employee/{id}/bankaccount")
	public boolean setEmployeeBankAccount(@PathVariable int id, @RequestParam int bankaccount)
	{
		boolean status = empService.updateBankAccount(id, bankaccount);
		if(status) System.out.println("Bank account updated successfully");
		else System.out.println("No such employee ID");
		return status;
	}
	
	//Create Employee
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e)throws OutofRangeSalaryException
	{
		
		Employee savedEmployee = empService.addEmployee(e);
		
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
		
	}
	
	//Delete Employee
	@DeleteMapping("/employee/{id}")
	public boolean deleteEmployee(@PathVariable int id)
	{
		boolean status = empService.deleteEmployee(id);
		if(status) System.out.println("Employee deleted successfully");
		else System.out.println("Failed");
		return status;
	}
	
	
}//end class
