package ua.alevel.db;

import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;

public interface EmployeeDB extends BaseDB<Employee> {

    Department tryGetDepartment(String id);
}
