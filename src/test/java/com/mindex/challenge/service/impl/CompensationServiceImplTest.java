package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceImplTest {
	
	@LocalServerPort
    private int port;
    
    @Autowired
    private TestRestTemplate restTemplate;

    private String employeeUrl;
    private String compensationUrl;
    
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImplTest.class);
    
    /**
     * Create test data
     */
    Employee pete = new Employee();
    {
	    pete.setFirstName("Pete");
	    pete.setLastName("Best");
	    pete.setDepartment("Music");
	    pete.setPosition("Drummer");
    }
    
    Compensation petesSalary = new Compensation();
    {
    	petesSalary.seteffectiveDate(new Date());
    	petesSalary.setSalary(new BigDecimal(40.40));
    }
    
    /**
     * Test setup: Add test employees to the database
     */
    @Before
    public void setup() {
    	
    	employeeUrl = "http://localhost:" + port + "/employee";
    	compensationUrl = "http://localhost:" + port +"/employee/{id}/compensation";
    	
    	// Create and update Pete
    	pete = restTemplate.postForEntity(employeeUrl, pete, Employee.class).getBody();
    	petesSalary.setEmployeeId(pete.getEmployeeId());
    }
    
    /**
     * Asserts that an employee's compensation can be created, viewed, and updated.
     */
	@Test
	public void testCompensationWorkflow() {
		// Create checks
        Compensation petesNewSalary = restTemplate.postForEntity(compensationUrl, petesSalary, Compensation.class, pete.getEmployeeId()).getBody();
        
        LOG.debug("Sent: [{}]", petesSalary.getSalary());
        LOG.debug("Received: [{}]", petesNewSalary.getSalary());
        assertNotNull(petesNewSalary);
        assertEquals(petesSalary, petesNewSalary);


        // Read checks
        Compensation readSalary = restTemplate.getForEntity(compensationUrl, Compensation.class, pete.getEmployeeId()).getBody();
        assertNotNull(readSalary);
        assertEquals(petesSalary, readSalary);


        // Update checks
        
        // Give Pete a raise
        petesSalary.setSalary(petesSalary.getSalary().add(new BigDecimal(10.10)));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Compensation updatedSalary =
                restTemplate.exchange(compensationUrl,
                        HttpMethod.PUT,
                        new HttpEntity<Compensation>(petesSalary, headers),
                        Compensation.class,
                        pete.getEmployeeId()).getBody();

        assertEquals(petesSalary, updatedSalary);
	}

}
