package ua.alevel.dao;

import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;

public interface EmployeeDao extends BaseDao<Employee> {
    Department tryGetDepartment(String id);
}
