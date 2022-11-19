package com.jbd.utils;

public class Queries {

	public static final String GET_ALL_EMPLOYEES = "select * from employee order by id";
	public static final String GET_EMPLOYEE_BY_ID = "select * from employee where id = ?";
	public static final String DELETE_EMPLOYEE_BY_ID = "delete from employee where id = ?";
	public static final String INSERT_EMPLOYEE = "insert into employee values (?,?,?)";
	public static final String UPDATE_EMPLOYEE = "update employee set firstName = ?, lastName = ?, email = ? where id = ?";;
}
