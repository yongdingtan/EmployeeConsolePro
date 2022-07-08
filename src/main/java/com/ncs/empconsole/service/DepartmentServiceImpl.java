package com.ncs.empconsole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.empconsole.model.Department;
import com.ncs.empconsole.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department addDepartment(Department department) {
		
		Department savedEntity = departmentRepository.save(department);
		return savedEntity;
	}

	@Override
	public List<Department> getAllDepartments() {
		
		
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentByCode(int dCode) {
		
		return departmentRepository.findById(dCode).get();
	}

	
}
