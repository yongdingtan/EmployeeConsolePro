package com.ncs.empconsole.service;

import java.util.List;
import java.util.Set;

import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.model.Project;

public interface ProjectService {
	
	public Project addProject(Project p);
	public Project getProjectDetails(int projectNumber);
	
	public List<Project> getAllProjects();
	public List<Project> getAllProjects(int startDate, int endDate);
	
	public boolean deleteProject(int projectNumber);
	public boolean updateProjectCost(int projectNumber, int cost);
	public Set<Employee> allocateProject(Project p, Employee e);
	public Set<Employee> getProjectResource(int projectId);

}
