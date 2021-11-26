package ua.alevel.db.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.db.DepartmentDB;
import ua.alevel.db.GeneralDB;
import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;
import ua.alevel.util.GenerateIdUtil;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentListDBImpl implements DepartmentDB {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private final GeneralDB generalDB;

    public DepartmentListDBImpl() {
        generalDB = GeneralDB.getInstance();
    }

    @Override
    public void create(Department entity) {
        try {
            entity.setId(GenerateIdUtil.generateId(generalDB.getDepartmentList()));
            generalDB.getDepartmentList().add(entity);
        } catch (Exception e) {
            LOGGER_ERROR.error("Error: " + e);
            System.out.println("error = " + e);
        }

    }

    @Override
    public void update(Department entity) {
        try {
            Department current = findById(entity.getId());
            if (current == null) {
                throw new RuntimeException("department not found");
            }
            current.setDepartmentName(entity.getDepartmentName());
        } catch (Exception e) {
            LOGGER_ERROR.error("Error: " + e);
            System.out.println("error = " + e);
        }

    }

    @Override
    public void delete(String id) {
        try {
            generalDB.getDepartmentList().removeIf(department -> department.getId().equals(id));
            generalDB.getEmployeeList().removeIf(employee -> employee.getDepartment().getId().equals(id));
        } catch (Exception e) {
            LOGGER_ERROR.error("Error: " + e);
            System.out.println("error = " + e);
        }
    }

    @Override
    public Department findById(String id) {
        try {
            return generalDB.getDepartmentList().stream().filter(dep -> dep.getId().equals(id))
                    .findFirst().orElseThrow(() -> new RuntimeException("department not found by id"));
        } catch (Exception e) {
            LOGGER_ERROR.error("Error: " + e);
            System.out.println("error = " + e);
            return null;
        }
    }

    @Override
    public Collection<Department> findAll() {
        return generalDB.getDepartmentList();
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String id) {
        try {
            List<Employee> employeeList = generalDB.getEmployeeList()
                    .stream()
                    .filter(employee -> employee.getDepartment().getId().equals(id))
                    .collect(Collectors.toList());
            if (employeeList.isEmpty()) {
                return null;
            }
            return employeeList;
        } catch (Exception e) {
            LOGGER_ERROR.error("Error: " + e);
            System.out.println("error = " + e);
            return null;
        }
    }
}
