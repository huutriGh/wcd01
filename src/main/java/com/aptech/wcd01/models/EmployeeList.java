package com.aptech.wcd01.models;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private static List<Employee> employeeList = new ArrayList<>();

    public boolean insertEmp(Employee employee) {

        if (employeeList.contains((employee))) {
            return false;
        }
        employeeList.add(employee);
        return true;

    }

    public  List<Employee> getEmployeeList() {
        return employeeList;
    }
}
