package ua.alevel.dao.impl;

import ua.alevel.config.ApplicationConfig;
import ua.alevel.dao.DepartmentDao;
import ua.alevel.db.DepartmentDB;
import ua.alevel.db.UserDB;
import ua.alevel.entity.Department;

import java.util.Collection;

public class DepartmentDaoImpl implements DepartmentDao {

    private final DepartmentDB instanceDB = ApplicationConfig.getImpl(DepartmentDB.class);

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
}
