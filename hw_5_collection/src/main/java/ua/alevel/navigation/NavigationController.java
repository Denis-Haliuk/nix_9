package ua.alevel.navigation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NavigationController {

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select operation:");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                if (position.equals("0")) {
                    break;
                }
                mainOperations(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println("1 - MathSet creation");
        System.out.println("2 - Methods");
        System.out.println("0 - exit");
        System.out.println();
    }

    private void mainOperations(String position, BufferedReader reader) {

        switch (position) {
            case "1":
                MathSetCreationNavigation.runCreationInterface(reader);
                break;
            case "2":
                MathSethMethodNavigation.runMethodsInterface(reader);
                break;
        }
        runNavigation();
    }




}
