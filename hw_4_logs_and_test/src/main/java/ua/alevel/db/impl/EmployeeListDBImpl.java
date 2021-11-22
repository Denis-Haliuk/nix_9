package ua.alevel.db.impl;

import ua.alevel.db.EmployeeDB;
import ua.alevel.entity.Employee;
import ua.alevel.util.GenerateIdUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeeListDBImpl implements EmployeeDB {

    private final List<Employee> employees;
    private static EmployeeListDBImpl instance;

    public EmployeeListDBImpl() {
        System.out.println("EmployeeListDBImpl.EmployeeListDBImpl");
        employees = new ArrayList<>();
    }


    public static EmployeeListDBImpl getInstance() {
        if (instance == null) {
            instance = new EmployeeListDBImpl();
        }
        return instance;
    }
    @Override
    public void create(Employee entity) {
        entity.setId(GenerateIdUtil.generateId(employees));
        employees.add(entity);
    }

    @Override
    public void update(Employee entity) {
        Employee current = findById(entity.getId());
        current.setName(entity.getName());
        current.setAge(entity.getAge());
        current.setEmail(entity.getEmail());
        current.setDepartmentId(entity.getDepartmentId());
    }

    @Override
    public void delete(String id) {
        employees.removeIf(employee -> employee.getId().equals(id));
    }

    @Override
    public Employee findById(String id) {
        return employees.stream().filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("employee not found"));
    }

    @Override
    public Collection<Employee> findAll() {
        return employees;
    }

    @Override
    public boolean existByEmail(String email) {
        return employees.stream().anyMatch(employee -> employee.getEmail().equals(email));
    }
}
