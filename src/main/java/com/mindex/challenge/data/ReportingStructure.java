package com.mindex.challenge.data;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class ReportingStructure {
	private String employee;
	private int numberOfReports;
	
	@Autowired
    private EmployeeService employeeService;
	
	public ReportingStructure(String employeeID) {
		this.employee = employeeID;
		this.numberOfReports = lookUpReports(employeeID);
		
	}
	
	/**
	 * Recursively counts all reports under the employee with the given ID.
	 * N.B. Assumes that the org chart itself is non-recursive!
	 * @param employeeID: ID of the employee to count the reports of.
	 * @return The total number of reports beneath the specified employee.
	 */
	private int lookUpReports(String employeeID) {
		List<Employee> reports = employeeService.read(employeeID).getDirectReports();
		return reports.isEmpty() ? 0 : reports.size() + reports.stream().mapToInt(report -> lookUpReports(report.getEmployeeId())).sum();
	}
	
	public int getNumberOfReports() {
		return this.numberOfReports;
	}
	
	public String getEmployeeID( ) {
		return this.employee;
	}
}
