package com.ncs.empconsole.web;

import java.sql.Date;
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

import com.ncs.empconsole.exception.InvalidEndDateException;
import com.ncs.empconsole.model.Project;
import com.ncs.empconsole.service.ProjectService;

@RestController
@RequestMapping("/empconsole/project")
public class ProjectRestController {
	
	@Autowired
	ProjectService projectService;
	
	public ProjectRestController()
	{
		System.out.println("Project Controller constructor called");
	}
	
	//Get all Projects
	@GetMapping("/projects")
	public List<Project> getAllProjects()
	{
		return projectService.getAllProjects();
	}
	
	//Get Project By ID
	@GetMapping("/project/id/{id}")
	public Project getProjectById(@PathVariable int id)
	{
		System.out.println("Path variable: "+id);
		return projectService.getProjectDetails(id);
	}
	
	//Get List of Projects within Date Range
	@GetMapping("/projects/date")
	public List<Project> getProjectsBasedOnDateRange(@RequestParam int date1, @RequestParam int date2)
	{
		List<Project> projectList = projectService.getAllProjects(date1, date2);
		for (Project project : projectList) {
			System.out.println(project.toString());
		}
		
		return projectList;
	}
	
	//Set cost to Project
	@PutMapping("/project/{id}/cost")
	public boolean setProjectCost(@PathVariable int id, @RequestParam int cost)
	{
		boolean status = projectService.updateProjectCost(id, cost);
		if(status) System.out.println("Cost updated successfully");
		else System.out.println("No such project ID");
		return status;
	}
	
	//Create Project
	@PostMapping("/project")
	public ResponseEntity<Project> addProject(@RequestBody Project p) throws InvalidEndDateException
	{
		Date date = new Date(System.currentTimeMillis());
		if(p.getEnddate().compareTo(date)>0)
		{
			Project savedProject = projectService.addProject(p);
			return new ResponseEntity<Project>(savedProject,HttpStatus.OK);
		}
		else
		{
			throw new InvalidEndDateException("End date cannot be earlier than current date", p.getProjectNumber(), p.getEnddate());
		}
	}
	
	//Delete Project
	@DeleteMapping("/project/{id}")
	public boolean deleteProject(@PathVariable int id)
	{
		boolean status = projectService.deleteProject(id);
		if(status)System.out.println("Project deleted successfully");
		else System.out.println("Failed");
		return status;
	}

}
