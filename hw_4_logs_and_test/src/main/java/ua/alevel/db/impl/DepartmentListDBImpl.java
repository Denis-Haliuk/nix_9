package ua.alevel.db.impl;

import ua.alevel.db.DepartmentDB;
import ua.alevel.entity.Department;
import ua.alevel.util.GenerateIdUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DepartmentListDBImpl implements DepartmentDB {

    private final List<Department> departmentList;
    private static DepartmentListDBImpl instance;

    public DepartmentListDBImpl() {
        System.out.println("DepartmentListDBImpl.DepartmentListDBImpl");
        departmentList = new ArrayList<>();
    }

    public static DepartmentListDBImpl getInstance() {
        if (instance == null) {
            instance = new DepartmentListDBImpl();
        }
        return instance;
    }

    @Override
    public void create(Department entity) {
        entity.setId(GenerateIdUtil.generateId(departmentList));
        departmentList.add(entity);
    }

    @Override
    public void update(Department entity) {
        Department current = findById(entity.getId());
        current.setDepartmentName(entity.getDepartmentName());
    }

    @Override
    public void delete(String id) {
        departmentList.removeIf(department -> department.getId().equals(id));
    }

    @Override
    public Department findById(String id) {
        return departmentList.stream().filter(dep -> dep.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("department not found by id"));
    }

    @Override
    public Collection<Department> findAll() {
        return departmentList;
    }
}
