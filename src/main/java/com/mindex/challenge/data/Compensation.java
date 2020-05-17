package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.util.Date;

public class Compensation {
	Employee employee;
	BigDecimal salary;
	Date effectiveDate;
	
	public Compensation() {
	}

	public Employee getEmployee() {
		return this.employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public BigDecimal getSalary() {
		return this.salary;
	}
	
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	public Date effectiveDate() {
		return this.effectiveDate;
	}
	
	public void seteffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
}