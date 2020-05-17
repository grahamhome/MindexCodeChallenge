package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private ReportingStructureService reportingStructureService;
    
    @Autowired
    private CompensationService compensationService;

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        LOG.debug("Received employee create request for [{}]", employee);

        return employeeService.create(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee read(@PathVariable String id) {
        LOG.debug("Received employee read request for id [{}]", id);

        return employeeService.read(id);
    }

    @PutMapping("/employee/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        LOG.debug("Received employee update request for id [{}] and employee [{}]", id, employee);

        employee.setEmployeeId(id);
        return employeeService.update(employee);
    }
    
    @GetMapping("/employee/{id}/reportingStructure")
    public ReportingStructure lookupReports(@PathVariable String id) {
    	LOG.debug("Received employee reporting structure lookup request for employee with id [{}]", id);
    	return reportingStructureService.create(employeeService.read(id));
    }
    
    @PostMapping("/employee{id}/compensation")
    public Compensation createCompensation(@PathVariable String id, @RequestBody Compensation compensation) {
        LOG.debug("Received compensation create request for employee with id [{}]. Compensation: [{}]", id, compensation);
        compensation.setEmployee(employeeService.read(id));
        return compensationService.create(compensation);
    }

    @GetMapping("/employee/{id}/compensation")
    public Compensation readCompensation(@PathVariable String id) {
        LOG.debug("Received employee compensation read request for id [{}]", id);

        return compensationService.read(employeeService.read(id));
    }

    @PutMapping("/employee/{id}/compensation")
    public Compensation updateCompensation(@PathVariable String id, @RequestBody Compensation compensation) {
        LOG.debug("Received employee compensation update request for employee with id [{}]. Compensation: [{}]", id, compensation);
        compensation.setEmployee(employeeService.read(id));
        return compensationService.update(compensation);
    }
}
