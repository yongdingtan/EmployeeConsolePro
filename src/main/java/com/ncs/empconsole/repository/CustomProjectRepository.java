package com.ncs.empconsole.repository;

import java.util.List;

import com.ncs.empconsole.model.Project;

public interface CustomProjectRepository {
	
	public Project getProjectDetails(int projectNumber);
	
	public List<Project> getAllProjects(int startDate, int endDate);
	
	public boolean deleteProject(int projectNumber);

	public boolean updateProjectCost(int projectNumber, int cost);


}
