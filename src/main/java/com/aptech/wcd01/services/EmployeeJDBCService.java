package com.aptech.wcd01.services;

import com.aptech.wcd01.models.Employee;

import java.util.List;

public interface EmployeeJDBCService {
    public boolean addEmployee(Employee employee);
    public boolean updateEmployee(Employee employee);
    public boolean deleteEmployee(String id);
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(String id);
}
