package ua.alevel.db.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.db.EmployeeDB;
import ua.alevel.db.GeneralDB;
import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;
import ua.alevel.util.GenerateIdUtil;
import java.util.Collection;

public class EmployeeListDBImpl implements EmployeeDB {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final GeneralDB generalDB;

    public EmployeeListDBImpl() {
        generalDB = GeneralDB.getInstance();
    }

    @Override
    public void create(Employee entity) {
        try {
            entity.setId(GenerateIdUtil.generateId(generalDB.getEmployeeList()));
            generalDB.getEmployeeList().add(entity);
        } catch (Exception e) {
            LOGGER_ERROR.error("Error: " + e);
            System.out.println("error = " + e);
        }
    }

    @Override
    public void update(Employee entity) {
        try {
            Employee current = findById(entity.getId());
            if (current == null) {
                throw new RuntimeException("employee not found");
            }
            current.setName(entity.getName());
            current.setAge(entity.getAge());
            current.setEmail(entity.getEmail());
            current.setDepartment(entity.getDepartment());
            if (entity.getDepartment() == null) {
                throw new RuntimeException("department123 not found");
            }
        } catch (Exception e) {
            LOGGER_ERROR.error("Error: " + e);
            System.out.println("error = " + e);
        }
    }

    @Override
    public void delete(String id) {
        generalDB.getEmployeeList().removeIf(employee -> employee.getId().equals(id));
    }

    @Override
    public Employee findById(String id) {
        try {
            return generalDB.getEmployeeList().stream().filter(emp -> emp.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("employee not found"));
        } catch (RuntimeException runtimeException) {
            LOGGER_ERROR.error("Error: " + runtimeException);
            System.out.println("runtimeException = " + runtimeException);
            return null;
        }
    }

    @Override
    public Collection<Employee> findAll() {
        return generalDB.getEmployeeList();
    }

    @Override
    public Department tryGetDepartment(String id) {
        for (var dep : generalDB.getDepartmentList()) {
            System.out.println(dep);
        }
        try {
            return generalDB.getDepartmentList().stream().filter(department -> department.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("department not found"));
        } catch (RuntimeException runtimeException) {
            LOGGER_ERROR.error("Error: " + runtimeException);
            System.out.println("runtimeException = " + runtimeException);
            return null;
        }
    }
}
