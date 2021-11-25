package ua.alevel.db;

import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;

import java.util.List;

public interface DepartmentDB extends BaseDB<Department> {

    List<Employee> getEmployeesByDepartment(String id);
}
