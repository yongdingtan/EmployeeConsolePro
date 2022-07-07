package com.ncs.empconsole.service;

import java.util.List;

import com.ncs.empconsole.model.Project;

public interface ProjectService {
	
	public Project addProject(Project p);
	public Project getProjectDetails(int projectNumber);
	
	public List<Project> getAllProjects();
	public List<Project> getAllProjects(int startDate, int endDate);
	
	public boolean deleteProject(int projectNumber);
	public boolean updateProjectCost(int projectNumber, int cost);

}
