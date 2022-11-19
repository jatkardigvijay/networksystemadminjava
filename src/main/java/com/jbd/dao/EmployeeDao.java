package com.jbd.dao;

import java.util.List;

import com.jbd.entity.Employee;
import com.jbd.exception.JbdException;

public interface EmployeeDao {

	List<Employee> getAllEmployees() throws JbdException;

	Employee getEmployeeById(int id) throws JbdException;

	boolean deleteById(Integer id) throws JbdException;

	Employee insertEmployee(Employee employee) throws JbdException;

	Employee updatedEmployee(Employee employee) throws JbdException;

}
