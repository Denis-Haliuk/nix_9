package ua.alevel.dao;

import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;

import java.util.List;

public interface DepartmentDao extends BaseDao<Department>{
    List<Employee> getEmployeesByDepartment(String id);
}
