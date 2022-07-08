package com.ncs.empconsole.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("hibernateLazyInitializer")
@Entity
public class Department implements Comparable<Department>,Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dCode; // d stands for department
	private String name;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(String name) {
		super();
		this.name = name;
	}
	public int getdCode() {
		return dCode;
	}
	public void setdCode(int dCode) {
		this.dCode = dCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(Department o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dCode, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return dCode == other.dCode && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Department [dCode=" + dCode + ", name=" + name + "]";
	}
	
	
	
}
