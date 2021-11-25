package ua.alevel.service;

import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;

public interface EmployeeService extends BaseService<Employee> {
    Department tryGetDepartment(String id);
}
