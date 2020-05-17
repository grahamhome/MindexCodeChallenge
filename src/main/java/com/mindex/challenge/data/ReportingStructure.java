package com.mindex.challenge.data;


import java.util.List;

import com.mindex.challenge.data.Employee;


public class ReportingStructure {
	private Employee employee;
	private int numberOfReports;
	
	public ReportingStructure() {
		
	}
	
	public ReportingStructure(Employee employee) {
		this.employee = employee;
		this.numberOfReports = this.lookUpReports(employee);
		
	}
	
	/**
	 * Recursively counts all employees who report to the given employee.
	 * N.B. Assumes that the reporting structure itself is non-recursive!
	 * @param employee: Employee to count the reports of.
	 * @return The sum of all employees at all levels beneath the specified employee.
	 */
	private int lookUpReports(Employee employee) {
		List<Employee> reports = employee.getDirectReports();
		return reports == null ? 0 : reports.size() + reports.stream().mapToInt(report -> this.lookUpReports(report)).sum();
	}
	
	public int getNumberOfReports() {
		return this.numberOfReports;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
	
	public void setNumberOfReports(int numberOfReports) {
		this.numberOfReports = numberOfReports;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
