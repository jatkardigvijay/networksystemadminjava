package com.jbd.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbd.dao.EmployeeDao;
import com.jbd.entity.Employee;
import com.jbd.exception.JbdException;
import com.jbd.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class.getName());

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() throws JbdException {

		logger.info("executing getAllEmployees() from employee service implementation");
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int id) throws JbdException {

		logger.info("executing getEmployeeById() from employee service implementation with id : " + id);
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public boolean deleteById(Integer id) throws JbdException {

		logger.info("executing deleteById() from employee service implementation with id : " + id);
		return employeeDao.deleteById(id);
	}

	@Override
	public Employee insertEmployee(Employee employee) throws JbdException {

		logger.info("executing insertEmployee() from employee service implementation");
		return employeeDao.insertEmployee(employee);
	}

	@Override
	public Employee updatedEmployee(Employee employee) throws JbdException {

		logger.info("executing updatedEmployee() from employee service implementation");
		Employee updatedEmployee = employeeDao.updatedEmployee(employee);
		return updatedEmployee;
	}

}
