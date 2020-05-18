package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		return (other_comp.getSalary().equals(this.getSalary()) && 
				other_comp.getEffectiveDate().equals(this.getEffectiveDate()));
	}

	public String getEmployeeId() {
		return this.employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getSalary() {
		return this.salary.toPlainString();
	}
	
	public void setSalary(String salary) {
		this.salary = new BigDecimal(salary);
	}
	
	public String getEffectiveDate() {
		return new SimpleDateFormat("mm-dd-yyyy").format(this.effectiveDate);
	}
	
	public void setEffectiveDate(String effectiveDate) {
		try {
			this.effectiveDate = new SimpleDateFormat("mm-dd-yyyy").parse(effectiveDate);
		} catch (ParseException e) {
			LOG.debug("Unable to parse date: [{}]", effectiveDate);
		}
	}
}