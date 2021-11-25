package ua.alevel.service;

import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;

import java.util.List;

public interface DepartmentService extends BaseService<Department> {
    List<Employee> getEmployeesByDepartment(String id);
}
