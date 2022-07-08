package com.ncs.empconsole.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ncs.empconsole.model.Department;

@Service
public interface DepartmentService {
	public Department addDepartment(Department department);
	public List<Department> getAllDepartments();
	public Department getDepartmentByCode(int dCode);
	
	
}
