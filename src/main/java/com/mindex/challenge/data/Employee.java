package com.mindex.challenge.data;

import java.util.List;

public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private List<Employee> directReports;

    public Employee() {
    }
    
    @Override
    public boolean equals(Object other) {
    	if (other == this) {
			return true;
		}
		if (!(other instanceof Employee)) {
			return false;
		}
		Employee other_employee = (Employee) other;
		return (other_employee.getEmployeeId().equals(this.getEmployeeId()) &&
				other_employee.getFirstName().equals(this.getFirstName()) &&
				other_employee.getLastName().equals(this.getLastName()) &&
				other_employee.getPosition().equals(this.getPosition()) &&
				other_employee.getDepartment().equals(this.getDepartment()) &&
				other_employee.getDirectReports().equals(this.getDirectReports()));
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    public void setDirectReports(List<Employee> directReports) {
        this.directReports = directReports;
    }
}
