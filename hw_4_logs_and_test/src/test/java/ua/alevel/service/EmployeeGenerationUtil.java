package ua.alevel.service;

import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;

public class EmployeeGenerationUtil {

    public static final String NAME = "test";
    public static final String EMAIL = "test@test.com";
    public static final int AGE = Integer.parseInt("123");

    public static Employee generateEmployee(Department department) {
        Employee employee = new Employee();
        employee.setName(NAME);
        employee.setEmail(EMAIL);
        employee.setAge(AGE);
        employee.setDepartment(department);
        return employee;
    }

    public static Employee generateEmployee(Department department, String name) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(EMAIL);
        employee.setAge(AGE);
        employee.setDepartment(department);
        return employee;
    }

    public static Employee generateEmployee(Department department, int age) {
        Employee employee = new Employee();
        employee.setName(NAME);
        employee.setEmail(EMAIL);
        employee.setAge(age);
        employee.setDepartment(department);
        return employee;
    }
}
