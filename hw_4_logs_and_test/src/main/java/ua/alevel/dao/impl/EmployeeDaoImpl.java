package ua.alevel.dao.impl;


import ua.alevel.dao.EmployeeDao;
import ua.alevel.db.DepartmentDB;
import ua.alevel.db.EmployeeDB;
import ua.alevel.db.impl.EmployeeListDBImpl;
import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;

import java.util.Collection;

public class EmployeeDaoImpl implements EmployeeDao {

    private final EmployeeDB instanceDB = new EmployeeListDBImpl();

    @Override
    public void create(Employee entity) {
        instanceDB.create(entity);
    }

    @Override
    public void update(Employee entity) {
        instanceDB.update(entity);
    }

    @Override
    public void delete(String id) {
        instanceDB.delete(id);
    }

    @Override
    public Employee findById(String id) {
        return instanceDB.findById(id);
    }

    @Override
    public Collection<Employee> findAll() {
        return instanceDB.findAll();
    }


    @Override
    public Department tryGetDepartment(String id) {
        return instanceDB.tryGetDepartment(id);
    }
}
