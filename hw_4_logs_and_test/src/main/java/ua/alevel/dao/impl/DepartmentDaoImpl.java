package ua.alevel.dao.impl;

import ua.alevel.dao.DepartmentDao;
import ua.alevel.db.DepartmentDB;
import ua.alevel.db.impl.DepartmentListDBImpl;
import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;

import java.util.Collection;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private final DepartmentDB instanceDB = new DepartmentListDBImpl();

    @Override
    public void create(Department entity) {
        instanceDB.create(entity);
    }

    @Override
    public void update(Department entity) {
        instanceDB.update(entity);
    }

    @Override
    public void delete(String id) {

        instanceDB.delete(id);
    }

    @Override
    public Department findById(String id) {
        return instanceDB.findById(id);
    }

    @Override
    public Collection<Department> findAll() {
        return instanceDB.findAll();
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String id) {
        return instanceDB.getEmployeesByDepartment(id);
    }
}
