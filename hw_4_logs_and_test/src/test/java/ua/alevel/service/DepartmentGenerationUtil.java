package ua.alevel.service;

import ua.alevel.entity.Department;

public class DepartmentGenerationUtil {
    public static final String NAME = "test";

    public static Department generateDepartment() {
        Department department = new Department();
        department.setDepartmentName(NAME);
        return department;
    }

    public static Department generateDepartment(String name) {
        Department department = new Department();
        department.setDepartmentName(name);
        return department;
    }

}
