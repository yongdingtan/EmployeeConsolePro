package com.ncs.empconsole.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.empconsole.model.Employee;

public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository{

	@Autowired
	EntityManager springDataJPA;
	// Session in hibernate 
	
	
	@Override
	public Employee getEmployeeDetails(String searchedEmpName) {
		
			
		String query = "from Employee e where e.name = :searchName";
		Query q = springDataJPA.createQuery(query,Employee.class);
		q.setParameter("searchName", searchedEmpName);
		
		Employee queryOutput = (Employee) q.getSingleResult();
		return queryOutput;
	}

	@Override
	public List<Employee> getAllEmployees(int salaryRange1, int salaryRange2) {
		String query = "from Employee e where e.salary > :salaryRange1 AND e.salary < :salaryRange2";
		Query q = springDataJPA.createQuery(query, Employee.class);
		q.setParameter("salaryRange1", salaryRange1);
		q.setParameter("salaryRange2", salaryRange2);
		
		List<Employee> queryOutput = (List<Employee>) q.getResultList();
		
		return queryOutput;
	}

	@Override
	@Transactional
	public boolean updateProject(int searchEmpId, int projectId) {
		String query ="update Employee e set e.project_info = :projectId where e.emp_id = :searchEmpId";
		Query q = springDataJPA.createNativeQuery(query, Employee.class);
		q.setParameter("projectId", projectId);
		q.setParameter("searchEmpId", searchEmpId);
		
		int x = q.executeUpdate();
		
		return (x==1)?true:false;
	}
	
	@Override
	@Transactional
	public boolean updateBankAccount(int searchEmpId, int bankAccount)
	{
		String query ="update Employee e set e.bank_account = :bankAccount where e.emp_id = :searchEmpId";
		Query q = springDataJPA.createNativeQuery(query, Employee.class);
		q.setParameter("bankAccount", bankAccount);
		q.setParameter("searchEmpId", searchEmpId);
		
		int x = q.executeUpdate();
		
		return (x==1)?true:false;
	}
	
	@Override
	@Transactional
	public boolean deleteEmployee(int searchEmpId)
	{
		String query = "delete from Employee e where e.emp_id = :searchEmpId";
		Query q = springDataJPA.createNativeQuery(query, Employee.class);
		q.setParameter("searchEmpId", searchEmpId);
		int x = q.executeUpdate();
		
		return (x==1)?true:false;
	}
	
	

}
