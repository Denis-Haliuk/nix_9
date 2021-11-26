package ua.alevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.entity.Employee;
import ua.alevel.service.EmployeeService;
import ua.alevel.service.impl.EmployeeServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class EmployeeController {
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                if (position.equals("0")) {
                    break;
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create employee, please enter 1");
        System.out.println("if you want update employee, please enter 2");
        System.out.println("if you want delete employee, please enter 3");
        System.out.println("if you want findById employee, please enter 4");
        System.out.println("if you want findAll employee, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll(reader);
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("EmployeeController.create");
        try {
            System.out.println("Please, enter employee name");
            String name = reader.readLine();
            System.out.println("Please, enter employee email");
            String email = reader.readLine();
            System.out.println("Please, enter employee age");
            String age = reader.readLine();
            int ageInt = Integer.parseInt(age);
            System.out.println("Please, enter department id ");
            String department = reader.readLine();

            Employee employee = new Employee();
            employee.setName(name);
            employee.setEmail(email);
            employee.setAge(Integer.parseInt(String.valueOf(ageInt)));
            employee.setDepartment(employeeService.tryGetDepartment(department));
            employeeService.create(employee);
        } catch (IOException | NumberFormatException e) {
            LOGGER_ERROR.error("Error: " + e);
            System.out.println("error = " + e);
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("EmployeeController.update");
        try {
            System.out.println("Please, enter employee id");
            String id = reader.readLine();
            System.out.println("Please, enter employee name");
            String name = reader.readLine();
            System.out.println("Please, enter employee email");
            String email = reader.readLine();
            System.out.println("Please, enter employee age");
            String age = reader.readLine();
            int ageInt = Integer.parseInt(age);
            System.out.println("Please, enter department id");
            String department = reader.readLine();

            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setEmail(email);
            employee.setAge(Integer.parseInt(String.valueOf(ageInt)));
            employee.setDepartment(employeeService.tryGetDepartment(department));
            employeeService.update(employee);
        } catch (Exception e) {
            LOGGER_ERROR.error("Error: " + e);
            System.out.println("error = " + e);
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("EmployeeController.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            employeeService.delete(id);

        } catch (Exception e) {
            LOGGER_ERROR.error("Error: " + e);
            System.out.println("error = " + e);
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("EmployeeController.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Employee employee = employeeService.findById(id);
            if (employee == null) {
                return;
            }
            System.out.println("employee = " + employee);
        } catch (Exception e) {
            LOGGER_ERROR.error("Error: " + e);
            System.out.println("error = " + e);
        }
    }

    private void findAll(BufferedReader reader) {
        System.out.println("EmployeeController.findAll");
        try {
            Collection<Employee> employees = employeeService.findAll();
            if (employees != null && employees.size() != 0) {
                for (Employee employee : employees) {
                    System.out.println("employee = " + employee);
                }
            } else {
                System.out.println("employees empty");
            }
        } catch (Exception e) {
            LOGGER_ERROR.error("Error: " + e);
            System.out.println("error = " + e);
        }
    }
}
