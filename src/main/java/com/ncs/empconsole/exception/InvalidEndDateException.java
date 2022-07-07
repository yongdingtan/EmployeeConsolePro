package com.ncs.empconsole.exception;

import java.sql.Date;

public class InvalidEndDateException extends Exception {

	private String errorMsg;
	private int projectNumber;
	private Date endDate;
	public InvalidEndDateException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvalidEndDateException(String errorMsg, int projectNumber, Date endDate) {
		super();
		this.errorMsg = errorMsg;
		this.projectNumber = projectNumber;
		this.endDate = endDate;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public int getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "InvalidEndDateException [errorMsg=" + errorMsg + ", projectNumber=" + projectNumber + ", endDate="
				+ endDate + "]";
	}
	
	
	
	
}
