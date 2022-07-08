package com.ncs.empconsole.exception;

import java.sql.Date;

public class InvalidEndDateException extends Exception {

	private String errorMsg;
	private String projectName;
	private Date endDate;
	public InvalidEndDateException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvalidEndDateException(String errorMsg, String projectName, Date endDate) {
		super();
		this.errorMsg = errorMsg;
		this.projectName = projectName;
		this.endDate = endDate;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "InvalidEndDateException [errorMsg=" + errorMsg + ", projectName=" + projectName + ", endDate="
				+ endDate + "]";
	}
	
	
	
	
}
