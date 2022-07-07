package com.ncs.empconsole.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("hibernateLazyInitializer")
@Entity
public class Employee implements Comparable<Employee>,Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	private String name;
	@OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "project_info", referencedColumnName = "projectNumber") 
	private Project project_info;
	private String email;
	private int bank_account;
	private String address;
	private String designation;
	private int salary;

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int emp_id, String name, Project project_info, String email, int bank_account, String address,
			String designation, int salary) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.project_info = project_info;
		this.email = email;
		this.bank_account = bank_account;
		this.address = address;
		this.designation = designation;
		this.salary = salary;
	}

	public int getEmpId() {
		return emp_id;
	}
	public void setEmpId(int empId) {
		this.emp_id = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Project getProject_info() {
		return project_info;
	}

	public void setProject_info(Project project_info) {
		this.project_info = project_info;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBankAccount() {
		return bank_account;
	}
	public void setBankAccount(int bankAccount) {
		this.bank_account = bankAccount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + emp_id + ", name=" + name + ", projectInfo=" + project_info + ", email=" + email
				+ ", bankAccount=" + bank_account + ", address=" + address + ", designation=" + designation + ", salary="
				+ salary + "]";
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(address, bank_account, designation, email, emp_id, name, project_info, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && bank_account == other.bank_account
				&& Objects.equals(designation, other.designation) && Objects.equals(email, other.email)
				&& emp_id == other.emp_id && Objects.equals(name, other.name)
				&& Objects.equals(project_info, other.project_info) && salary == other.salary;
	}
	@Override
	public int compareTo(Employee e2) {
		
		return this.getEmpId() - e2.getEmpId();
	}
	
	
	

}
