package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Compensation {
	private String employeeId;
	private BigDecimal salary;
	private Date effectiveDate;
	
	private static final Logger LOG = LoggerFactory.getLogger(Compensation.class);
	
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
		LOG.debug("Comparing employee [{}] to [{}]", other_comp.getSalary(), this.getSalary());
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
	
	public BigDecimal getSalary() {
		return this.salary;
	}
	
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	public Date getEffectiveDate() {
		return this.effectiveDate;
	}
	
	public void seteffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
}