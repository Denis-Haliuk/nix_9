package ua.alevel.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.dao.EmployeeDao;
import ua.alevel.dao.impl.EmployeeDaoImpl;
import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;
import ua.alevel.service.EmployeeService;

import java.util.Collection;

public class EmployeeServiceImpl implements EmployeeService {

    private static final org.slf4j.Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final org.slf4j.Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public void create(Employee entity) {
        LOGGER_INFO.info("Employee creating starting");
        employeeDao.create(entity);
        LOGGER_INFO.info("Employee with id = " + entity.getId() + " created");
    }

    @Override
    public void update(Employee entity) {
        LOGGER_INFO.info("Employee updating starting");
        employeeDao.update(entity);
        LOGGER_INFO.info("Employee with id = " + entity.getId() + " updated");
    }

    @Override
    public void delete(String id) {
        LOGGER_WARN.warn("Employee deleting started");
        employeeDao.delete(id);
        LOGGER_WARN.warn("Employee by id = " + id + " deleted");


    }

    @Override
    public Employee findById(String id) {
        return employeeDao.findById(id);
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeDao.findAll();
    }


    @Override
    public Department tryGetDepartment(String id) {
        return employeeDao.tryGetDepartment(id);
    }
}
