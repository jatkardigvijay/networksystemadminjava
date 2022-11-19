package com.jbd.controller;

import java.util.List;

import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbd.config.Response;
import com.jbd.entity.Employee;
import com.jbd.exception.JbdException;
import com.jbd.service.EmployeeService;

@RestController
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("employee")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeService employeeService;

	/**
	 * @author Digvijay.Jatkar
	 * @Description This method gets the list all the Employees
	 * @param 
	 * @return List of all Employees
	 * @throws JbdException
	 * @Created 29/10/2022
	 * @Updated
	 **/
	@GetMapping("/api/v1")
	public ResponseEntity<Response> getAllEmployees() throws JbdException {

		List<Employee> employeeList = employeeService.getAllEmployees();

		if (employeeList == null || employeeList.isEmpty()) {

			logger.info("No data found or list is empty");
			throw new JbdException("No data found", HttpStatus.OK, employeeList);
		} else {

			logger.info("received employee list with size : " + employeeList.size());
			return new ResponseEntity<Response>(new Response("success", employeeList, null), HttpStatus.OK);
		}
	}

	/**
	 * @author Digvijay.Jatkar
	 * @Description This method gets the Employee by the Employee ID
	 * @param empoyeeId
	 * @return Gets the employee by Employee id
	 * @throws JbdException
	 * @Created 29/10/2022
	 * @Updated
	 **/
	@GetMapping("/api/v1/{id}")
	public ResponseEntity<Response> getEmployeeById(
			@Min(value = 1, message = "minimum value should be 1") @PathVariable("id") int id) throws JbdException {

		Employee employee = employeeService.getEmployeeById(id);

		if (employee == null) {

			logger.info("No data found or list is empty");
			throw new JbdException("No data found", HttpStatus.OK, employee);
		} else {

			logger.info("received employee with id : " + employee.getId());
			return new ResponseEntity<Response>(new Response("success", employee, null), HttpStatus.OK);
		}
	}

	/**
	 * @author Digvijay.Jatkar
	 * @Description This method deletes the employee By passing the employee ID
	 * @param employeeId
	 * @return 
	 * @throws JbdException
	 * @Created 31/10/2022
	 * @Updated
	 **/
	@DeleteMapping("api/v1/{id}")
	public ResponseEntity<Integer> deleteById(
			@Min(value = 1, message = "minimum value should be 1") @PathVariable("id") Integer id) throws JbdException {

		boolean isRemoved = employeeService.deleteById(id);

		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Integer>(id, HttpStatus.OK);

	}

	/**
	 * @author Digvijay.Jatkar
	 * @Description This inserts an Employee
	 * @param Employee as a body
	 * @return Employee
	 * @throws JbdException
	 * @Created 01/11/2022
	 * @Updated
	 **/
	@PostMapping("/api/v1/add")
	public Employee insertEmployee(@RequestBody Employee employee) throws JbdException {

		logger.info("executing insertEmployee() method from employee controller");
		return employeeService.insertEmployee(employee);
	}

	/**
	 * @author Digvijay.Jatkar
	 * @Description This updates an Employee info based on the employeeId
	 * @param Employee as a body, Id
	 * @return updated Employee
	 * @throws JbdException
	 * @Created 01/11/2022
	 * @Updated
	 **/
	@PutMapping("/api/v1/update/{id}")
	public ResponseEntity<Response> updateEmployee( @RequestBody Employee employee, @PathVariable("id") Integer id)
			throws JbdException {
		validationCheck(id);
		employee.setId(id);
		Employee updatedEmployee = employeeService.updatedEmployee(employee);

		return new ResponseEntity<Response>(new Response("Record updated successfully", updatedEmployee, null),
				HttpStatus.OK);

	}
	
	/**
	 * @author Digvijay.Jatkar
	 * @Description This method is for the validation of an employee
	 * @param Id
	 * @return updated Employee
	 * @throws JbdException
	 * @Created 01/11/2022
	 * @Updated
	 **/
	public int validationCheck(int id) throws JbdException {
		
		if (id >= 1) {
			return id;
		} else {
			throw new JbdException("Id should be equal to 1 or greater than 1",HttpStatus.BAD_REQUEST);
		}
	}
}
