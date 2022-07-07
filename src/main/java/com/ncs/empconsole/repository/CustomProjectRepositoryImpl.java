package com.ncs.empconsole.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import com.ncs.empconsole.model.Project;

public class CustomProjectRepositoryImpl implements CustomProjectRepository{
	
	@Autowired
	EntityManager springDataJPA;


	@Override
	public Project getProjectDetails(int projectNumber) {
		String query = "from Project p where p.projectNumber = :projectNumber";
		Query q = springDataJPA.createQuery(query, Project.class);
		q.setParameter("projectNumber", projectNumber);
		
		Project queryOutput = (Project)q.getSingleResult();
		return queryOutput;
	}
	
	@Override
	@Transactional
	public boolean updateProjectCost(int projectNumber, int cost)
	{
		String query = "update Project p set p.cost = :cost where p.project_number = :projectNumber";
		Query q = springDataJPA.createNativeQuery(query, Project.class);
		q.setParameter("cost", cost);
		q.setParameter("projectNumber", projectNumber);
		
		int x = q.executeUpdate();
		return(x==1)?true:false;
		
	}

	@Override
	public List<Project> getAllProjects(int startDate, int endDate) {
		String query = "from Project p where p.startdate > :startDate AND p.enddate < :endDate";
		Query q = springDataJPA.createQuery(query, Project.class);
		q.setParameter("startDate", startDate);
		q.setParameter("endDate", endDate);
		
		List<Project> queryOutput = (List<Project>) q.getResultList();
		
		return queryOutput;
	}

	@Override
	@Transactional
	public boolean deleteProject(int projectNumber) {
		String query = "delete from Project p where p.project_number = :projectNumber";
		Query q = springDataJPA.createNativeQuery(query, Project.class);
		q.setParameter("projectNumber", projectNumber);
		int x = q.executeUpdate();
		
		return (x==1)?true:false;
	}

}
