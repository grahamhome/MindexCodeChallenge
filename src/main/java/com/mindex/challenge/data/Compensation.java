package com.mindex.challenge.data;


public class Compensation {
	private String employeeId;
	private String salary;
	private String effectiveDate;
	
	public Compensation() {
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Compensation)) {
			return false;
		}
		Compensation other_comp = (Compensation) other;
		return (other_comp.getEmployeeId().equals(this.getEmployeeId()) &&
				other_comp.getSalary().equals(this.getSalary()) && 
				other_comp.getEffectiveDate().equals(this.getEffectiveDate()));
	}

	public String getEmployeeId() {
		return this.employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getSalary() {
		return this.salary;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getEffectiveDate() {
		return this.effectiveDate;
	}
	
	public void seteffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
}