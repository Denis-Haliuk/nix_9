package ua.alevel.db;

import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;
import java.util.ArrayList;
import java.util.List;

public class GeneralDB {
    private final List<Department> departmentList;
    private final List<Employee> employeeList;

    private static GeneralDB instance;

    public GeneralDB() {
        this.departmentList = new ArrayList<>();
        this.employeeList = new ArrayList<>();
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public static GeneralDB getInstance() {
        if (instance == null) {
            instance = new GeneralDB();
        }
        return instance;
    }
}
