package ua.alevel.controller;

import ua.alevel.config.ApplicationConfig;
import ua.alevel.entity.Department;
import ua.alevel.service.DepartmentService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class DepartmentController {

    private final DepartmentService departmentService = ApplicationConfig.getImpl(DepartmentService.class);

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create department, please enter 1");
        System.out.println("if you want update department, please enter 2");
        System.out.println("if you want delete department, please enter 3");
        System.out.println("if you want findById department, please enter 4");
        System.out.println("if you want findAll department, please enter 5");
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
        System.out.println("DepartmentController.create");
        try {
            System.out.println("Please, enter department name");
            String name = reader.readLine();

            Department department = new Department();
            department.setDepartmentName(name);
            departmentService.create(department);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("DepartmentController.update");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            System.out.println("Please, enter department name");
            String name = reader.readLine();

            Department department = new Department();
            department.setId(id);
            department.setDepartmentName(name);
            departmentService.update(department);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("DepartmentController.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            departmentService.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("DepartmentController.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Department department = departmentService.findById(id);
            System.out.println("department = " + department);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        System.out.println("DepartmentController.findAll");
        Collection<Department> departments = departmentService.findAll();
        if (departments != null && departments.size() != 0) {
            for (Department department : departments) {
                System.out.println("department = " + department);
            }
        } else {
            System.out.println("departments empty");
        }
    }
}
