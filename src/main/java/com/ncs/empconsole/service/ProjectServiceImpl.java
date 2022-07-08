package com.ncs.empconsole.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.model.Project;
import com.ncs.empconsole.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public Project addProject(Project p) {
		if(p!=null)
		{
				Project savedEntity =  projectRepository.save(p);
				return savedEntity;
			
		}
		else
		{
			throw new NullPointerException("Project Info Is Null");
		}
	}

	@Override
	public Project getProjectDetails(int projectNumber) {
		Project returnedProject =  projectRepository.getById(projectNumber);
		
		 return (returnedProject!=null)? returnedProject : null;
	}
	
	@Override
	public Set<Employee> allocateProject(Project p, Employee e) {
		
			System.err.println(" -------- Project Inside Service Impl ------------");
			System.err.println("p :- "+p+" & e "+e);
			Set<Employee> allWorkingEmployees = p.getAllEmployees();
			System.err.println(" 1:- "+allWorkingEmployees);
			
			if(allWorkingEmployees !=null)
			{
				allWorkingEmployees.add(e);
				p.setAllEmployees(allWorkingEmployees);
				projectRepository.save(p);
				System.err.println("--->> inside if "+allWorkingEmployees);
				return allWorkingEmployees;
			}
			else
			{
				System.err.println(" -->> inside else ");
				Set<Employee> set = new HashSet<>();
				set.add(e);
				p.setAllEmployees(set);
				projectRepository.save(p);
				System.err.println(" --->> inside else 2 :- "+p);
				return set;
			}
		
	}

	@Override
	public Set<Employee> getProjectResource(int projectId) {
		
		Project p = getProjectDetails(projectId);
		
		if(p != null)
		{
			Set<Employee> allWorkingEmployees = p.getAllEmployees();
			
			if(allWorkingEmployees !=null)
			{
				return allWorkingEmployees;
			}
			else return null;
		}
		else return null;
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public List<Project> getAllProjects(int startDate, int endDate) {
		return projectRepository.getAllProjects(startDate, endDate);
	}

	@Override
	public boolean deleteProject(int projectNumber) {
		return projectRepository.deleteProject(projectNumber);
	}

	@Override
	public boolean updateProjectCost(int projectNumber, int cost) {
		// TODO Auto-generated method stub
		return projectRepository.updateProjectCost(projectNumber, cost);
	}

}
