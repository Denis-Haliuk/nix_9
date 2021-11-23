package ua.alevel.service.impl;


import ua.alevel.dao.DepartmentDao;
import ua.alevel.dao.impl.DepartmentDaoImpl;
import ua.alevel.entity.Department;
import ua.alevel.service.DepartmentService;

import java.util.Collection;

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public void create(Department entity) {
        departmentDao.create(entity);
    }

    @Override
    public void update(Department entity) {
        departmentDao.update(entity);
    }

    @Override
    public void delete(String id) {
        departmentDao.delete(id);
    }

    @Override
    public Department findById(String id) {
        return departmentDao.findById(id);
    }

    @Override
    public Collection<Department> findAll() {
        return departmentDao.findAll();
    }
}
