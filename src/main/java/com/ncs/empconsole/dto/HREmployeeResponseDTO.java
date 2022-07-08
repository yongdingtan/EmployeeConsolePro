package com.ncs.empconsole.dto;

public class HREmployeeResponseDTO {
	
	private int empId;
	private String name;
	private String email;
	private String address;
	private String designation;
	public HREmployeeResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HREmployeeResponseDTO(int empId, String name, String email, String address, String designation) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.designation = designation;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	

	
	

}
