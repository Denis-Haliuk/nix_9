package ua.alevel.service.impl;


import ua.alevel.dao.EmployeeDao;
import ua.alevel.dao.impl.EmployeeDaoImpl;
import ua.alevel.entity.Employee;
import ua.alevel.service.EmployeeService;

import java.util.Collection;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public void create(Employee entity) {
        employeeDao.create(entity);
    }

    @Override
    public void update(Employee entity) {
        employeeDao.update(entity);
    }

    @Override
    public void delete(String id) {
        employeeDao.delete(id);
    }

    @Override
    public Employee findById(String id) {
        return employeeDao.findById(id);
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeDao.findAll();
    }
}
