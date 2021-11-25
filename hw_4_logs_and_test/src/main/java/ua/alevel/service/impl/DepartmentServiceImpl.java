package ua.alevel.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.dao.DepartmentDao;
import ua.alevel.dao.impl.DepartmentDaoImpl;
import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;
import ua.alevel.service.DepartmentService;

import java.util.Collection;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private static final org.slf4j.Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final org.slf4j.Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public void create(Department entity) {
        LOGGER_INFO.info("Department creating starting");
        departmentDao.create(entity);
        LOGGER_INFO.info("Department update finished" + " name = " + entity.getDepartmentName());
    }

    @Override
    public void update(Department entity) {
        LOGGER_INFO.info("Department update started");
        departmentDao.update(entity);
        LOGGER_INFO.info("Department update finished" + " name = " + entity.getDepartmentName());
    }

    @Override
    public void delete(String id) {
        LOGGER_WARN.warn("Department deleting started");
        departmentDao.delete(id);
        LOGGER_WARN.warn("Department by id = " + id + " deleted");
    }

    @Override
    public Department findById(String id) {
        return departmentDao.findById(id);
    }

    @Override
    public Collection<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String id) {
        return departmentDao.getEmployeesByDepartment(id);
    }
}
