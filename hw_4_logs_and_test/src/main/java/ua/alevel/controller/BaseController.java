package ua.alevel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseController {
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                selection(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                selection(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want to work with department, please enter 1");
        System.out.println("if you want to work with employee, please enter 2");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void selection(String position, BufferedReader reader) {
        switch (position) {
            case "1" -> new DepartmentController().run();
            case "2" -> new EmployeeController().run();

        }
        runNavigation();
    }
}
