package ua.alevel.db;

import ua.alevel.entity.Employee;

public interface EmployeeDB extends BaseDB<Employee> {

    boolean existByEmail(String email);
}
