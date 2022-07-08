package com.ncs.empconsole.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("hibernateLazyInitializer")
@Entity
public class Project implements Serializable,Comparable<Project> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectNumber;
	private String projectName;
	private int cost;
	private Date startdate;
	private Date enddate;
	private String comments;
	private String projectHeadEmail;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="all_employees")
	@JsonBackReference
	private Set<Employee> allEmployees;
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Project(int projectNumber, String projectName, int cost, Date startdate, Date enddate, String comments,
			String projectHeadEmail, Set<Employee> allEmployees) {
		super();
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.cost = cost;
		this.startdate = startdate;
		this.enddate = enddate;
		this.comments = comments;
		this.projectHeadEmail = projectHeadEmail;
		this.allEmployees = allEmployees;
	}


	public Set<Employee> getAllEmployees() {
		return allEmployees;
	}


	public void setAllEmployees(Set<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}


	public Project(int projectNumber, String projectName) {
		super();
		this.projectNumber = projectNumber;
		this.projectName = projectName;
	}

	public int getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getProjectHeadEmail() {
		return projectHeadEmail;
	}

	public void setProjectHeadEmail(String projectHeadEmail) {
		this.projectHeadEmail = projectHeadEmail;
	}

	@Override
	public int compareTo(Project p) {
		return this.projectNumber - p.getProjectNumber();
	}


	@Override
	public int hashCode() {
		return Objects.hash(allEmployees, comments, cost, enddate, projectHeadEmail, projectName, projectNumber,
				startdate);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(allEmployees, other.allEmployees) && Objects.equals(comments, other.comments)
				&& cost == other.cost && Objects.equals(enddate, other.enddate)
				&& Objects.equals(projectHeadEmail, other.projectHeadEmail)
				&& Objects.equals(projectName, other.projectName) && projectNumber == other.projectNumber
				&& Objects.equals(startdate, other.startdate);
	}


	@Override
	public String toString() {
		return "Project [projectNumber=" + projectNumber + ", projectName=" + projectName + ", cost=" + cost
				+ ", startdate=" + startdate + ", enddate=" + enddate + ", comments=" + comments + ", projectHeadEmail="
				+ projectHeadEmail + ", allEmployees=" + allEmployees + "]";
	}

	
	
	

}
