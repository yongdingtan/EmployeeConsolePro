package com.ncs.empconsole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
